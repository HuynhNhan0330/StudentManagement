import React, { useEffect, useState } from 'react';
import { Form, Input, InputNumber, Table, Modal, Button, Select, message } from 'antd';
import './StudentListTable.scss'
import { EditOutlined, CheckOutlined, UserDeleteOutlined, CloseOutlined } from '@ant-design/icons'
import { handleUpdateScoreByStudent } from '../../../controller/ScoreController';
import { handleGetStudents } from '../../../controller/StudentController';
import { handleAddStudentClass, handleDeleteStudentClass } from '../../../controller/ClassController';

const EditableCell = ({ editing, dataIndex, title, inputType, record, index, children, ...restProps }) => {
    const inputNode = inputType === 'number' ? <InputNumber min={0}
        max={10}
        step={0.1}
    />
        : <Input min={0} max={10} />;
    return (
        <td {...restProps}>
            {editing ? (
                <Form.Item
                    name={dataIndex}
                    style={{
                        margin: 0,
                    }}
                    rules={[
                        {
                            required: true,
                            message: `Vui lòng nhập ${title}!`,
                        },
                    ]}
                >
                    {inputNode}
                </Form.Item>
            ) : (
                children
            )}
        </td>
    );
};

const StudentListTable = ({ classListData, classs }) => {
    const [formSearch] = Form.useForm();
    const [form] = Form.useForm();

    const [data, setData] = useState(classListData);
    const [editingKey, setEditingKey] = useState('');

    useEffect(() => {
        setData(classListData);
    }, [classListData]);

    const handleDeleteStudent = (student) => {
        Modal.confirm({
            title: "Xác nhận xoá?",
            okText: "Có",
            cancelText: "Huỷ",
            onOk: () => {
                // console.log(classs);
                handleDeleteStudentClass(student.maSV, classs).then((result) => {
                    setData((pre) => {
                        return pre.filter((s) => s.maSV !== student.maSV);
                    });
                })
            }
        })
    }

    const isEditing = (record) => record.maSV === editingKey;

    const edit = (record) => {
        form.setFieldsValue({
            ...record,
        });

        setEditingKey(record.maSV);
    };

    const cancel = () => {
        setEditingKey('');
    };

    const save = async (id) => {
        try {
            const row = await form.validateFields();
            const newData = [...data];
            console.log(newData);
            const index = newData.findIndex((item) => id === item.maSV);

            if (index > -1) {
                const item = newData[index];

                const newRow = {
                    ...item,
                    ...row,
                }


                handleUpdateScoreByStudent(newRow).then(() => {

                });

                newData.splice(index, 1, newRow);

                setData(newData);
                setEditingKey('');
            } else {
                // Lưu sinh viên mới

                newData.push({
                    id,
                    ...row,
                });

                setData(newData);
                setEditingKey('');
            }

        } catch (errInfo) {
            console.log('Validate Failed:', errInfo);
        }
    };

    const columns = [
        {
            title: 'Mã SV',
            dataIndex: 'maSV',
            width: '10%',
        },
        {
            title: 'Tên',
            dataIndex: 'tenSV',
            width: '25%',
        },
        {
            title: 'Quá trình',
            dataIndex: 'quaTrinh',
            width: '12%',
            editable: true,
        },
        {
            title: 'Giữa kỳ',
            dataIndex: 'giuaKy',
            width: '12%',
            editable: true,
        },
        {
            title: 'Cuối kỳ',
            dataIndex: 'cuoiKy',
            width: '12%',
            editable: true,
        },
        {
            title: 'Tổng kết',
            render: (text, record) => (record.quaTrinh * 0.2 + record.giuaKy * 0.3 + record.cuoiKy * 0.5).toFixed(2),
            width: '12%',
        },
        {
            title: 'Thao tác',
            render: (_, record) => {
                const editable = isEditing(record);
                return editable ? (
                    <>
                        <CheckOutlined style={{ color: "green" }}
                            onClick={() => save(record.maSV)} />
                        <CloseOutlined style={{ color: "gray", marginLeft: 12 }}
                            onClick={cancel}
                        />
                    </>
                ) : (
                    <>
                        <EditOutlined style={{ color: "blue" }}
                            onClick={() => { edit(record); }} />
                        <UserDeleteOutlined style={{ color: "red", marginLeft: 12 }}
                            onClick={() => { handleDeleteStudent(record); }}
                        />
                    </>
                );
            },
        },
    ];

    const mergedColumns = columns.map((col) => {
        if (!col.editable) {
            return col;
        }
        return {
            ...col,
            onCell: (record) => ({
                record,
                dataIndex: col.dataIndex,
                inputType: col.dataIndex !== 'maSV' && col.dataIndex !== 'tenSV' ? 'number' : 'text',
                title: col.title,
                editing: isEditing(record),
                min: col.dataIndex === 'minValue' ? 0 : undefined,
                max: col.dataIndex === 'maxValue' ? 10 : undefined,
            }),
        };
    });

    // Add student
    const [students, setStudents] = useState([]); // Danh sách sinh viên từ API
    const [selectedStudent, setSelectedStudent] = useState(''); // Sinh viên được chọn

    const fetchStudents = () => {
        handleGetStudents().then((results) => {
            if (results == null) {
                results = [];
            }

            setStudents(results);
        });

    };

    useEffect(() => {
        fetchStudents();
    }, []);

    const handleAddStudent = () => {
        if (data.find((student) => student.maSV === selectedStudent)) {
            console.log()
            message.open({
                type: 'error',
                content: "Đã tồn tại sinh viên này",
            });
        }
        else {
            // Thêm sinh viên vào lớp
            handleAddStudentClass(selectedStudent, classs).then((resp) => {
                if (resp != null) {
                    // Thông báo tạo thành công
                    message.open({
                        type: 'success',
                        content: 'Thêm sinh viên thành công',
                    });
                    setData([...data, resp]);
                }
                else {
                    message.open({
                        type: 'error',
                        content: resp.response.data,
                    });
                }
            });
        }
    };


    // end

    return (
        <div className='StudentListTableContain'>
            <div style={{ width: '100%', display: 'flex', justifyContent: 'center', flexDirection: 'column' }}>
                <div style={{ width: '100%', display: 'flex' }}>
                    <Form form={formSearch} component={false} layout='inline'   >
                        <Form.Item label="Sinh viên" name="student" defaultValue="" style={{ width: '80%' }}>
                            <Select mode="single" showSearch optionFilterProp="children" allowClear style={{ width: '100%' }}
                                value={selectedStudent}
                                onChange={setSelectedStudent}>
                                {students.map((student) => (
                                    <Select.Option key={student.maSV} value={student.maSV}>
                                        {`${student.maSV} - ${student.tenTK}`}
                                    </Select.Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </Form>
                    <Button onClick={() => { handleAddStudent() }} style={{ marginLeft: '20px' }}>
                        Thêm sinh viên
                    </Button>
                </div>
                <Form form={form} component={false}>
                    <Table
                        components={{
                            body: {
                                cell: EditableCell,
                            },
                        }}
                        bordered
                        dataSource={data}
                        columns={mergedColumns}
                        rowClassName="editable-row"
                        pagination={false}
                    />
                </Form>
            </div>
        </div>
    );
};

export default StudentListTable;
