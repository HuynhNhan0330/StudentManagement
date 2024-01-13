import React, { useEffect, useState } from 'react';
import { Form, Input, InputNumber, Table, Typography, Button, Select } from 'antd';
import './StudentListTable.scss'
import { EditOutlined, CheckOutlined, UserDeleteOutlined, CloseOutlined } from '@ant-design/icons'
import { handleUpdateScoreByStudent } from '../../../controller/ScoreController';

// const classListData = [
//     { maSV: 1, tenTK: 'Student 1', quaTrinh: 80, giuaKy: 75, cuoiKy: 90 },
//     { maSV: 2, tenTK: 'Student 2', quaTrinh: 70, giuaKy: 80, cuoiKy: 85 },
// ];

const EditableCell = ({ editing, dataIndex, title, inputType, record, index, children, ...restProps }) => {
    const inputNode = inputType === 'number' ? <InputNumber min = {0} 
                                                            max = {10}
                                                            step = {0.1}
                                                            /> 
                                                : <Input min = {0} max = {10}/>;
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

const StudentListTable = ({ classListData }) => {
    const [formSearch] = Form.useForm();
    const [form] = Form.useForm();

    const [data, setData] = useState(classListData);
    const [editingKey, setEditingKey] = useState('');

    useEffect(() => {
        setData(classListData);
    }, [classListData]);

    const handleAddStudent = async (option) => {

    }

    const handleDeleteStudent = async (studentId) => {

    }


    const isEditing = (record) => record.id === editingKey;

    const edit = (record) => {
        form.setFieldsValue({
            ...record,
        });
        setEditingKey(record.id);
    };

    const cancel = () => {
        setEditingKey('');
    };

    const save = async (id) => {
        try {
            const row = await form.validateFields();
            const newData = [...data];
            const index = newData.findIndex((item) => id === item.id);
            
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
            width: '10%',
            editable: true,
        },
        {
            title: 'Giữa kỳ',
            dataIndex: 'giuaKy',
            width: '10%',
            editable: true,
        },
        {
            title: 'Cuối kỳ',
            dataIndex: 'cuoiKy',
            width: '10%',
            editable: true,
        },
        {
            title: 'Tổng kết',
            render: (text, record) => (record.quaTrinh * 0.2 + record.giuaKy * 0.3 + record.cuoiKy * 0.5),
            width: '10%',
        },
        {
            title: 'Thao tác',
            render: (_, record) => {
                const editable = isEditing(record);
                return editable ? (
                    <>
                        <CheckOutlined style={{ color: "green"}}
                                       onClick={() => save(record.id)}  />
                        <CloseOutlined style={{ color: "gray", marginLeft: 12 }}
                            onClick={cancel}
                        />
                    </>
                ) : (
                    <>
                        <EditOutlined style={{ color: "blue"}}
                                        onClick={() => { edit(record); }} />
                        <UserDeleteOutlined style={{ color: "red", marginLeft: 12 }}
                            onClick={async () => { await handleDeleteStudent(record?.id) }}
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
                inputType: col.dataIndex !== 'maSV' && col.dataIndex !== 'tenSV'  ? 'number' : 'text',
                title: col.title,
                editing: isEditing(record),
                min: col.dataIndex === 'minValue' ? 0 : undefined,
                max: col.dataIndex === 'maxValue' ? 10 : undefined,
            }),
        };
    });

    return (
        <div className='StudentListTableContain'>
            <div style={{ width: '100%', display: 'flex', justifyContent: 'center', flexDirection: 'column' }}>
                <div style={{ width: '100%', display: 'flex' }}>
                    <Form form={formSearch} component={false} layout='inline'   >
                        <Form.Item label="Student" name="student" defaultValue="" style={{ width: '80%' }}>
                            <Select mode="single" showSearch optionFilterProp="children" allowClear style={{ width: '100%' }}>
                                {

                                }
                            </Select>
                        </Form.Item>
                    </Form>
                    <Button onClick={() => { handleAddStudent(1) }} style={{ marginLeft: '20px' }}>
                        Add Student
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
