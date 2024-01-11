import React, { useEffect, useState } from 'react';
import { Form, Input, InputNumber, Table, Typography, Button, Select, message } from 'antd';
import './StudentListTable.scss'
import { useParams } from 'react-router-dom';



const classListData = [
    { id: 1, name: 'Student 1', progress: 80, midterm: 75, practice: 90, final: 85, GPA: 85 },
    { id: 2, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
];
const { Option } = Select;

const EditableCell = ({ editing, dataIndex, title, inputType, record, index, children, ...restProps }) => {
    const inputNode = inputType === 'number' ? <InputNumber /> : <Input />;
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
                            message: `Please Input ${title}!`,
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

const StudentListTable = () => {
    const [formSearch] = Form.useForm();
    const [form] = Form.useForm();

    const [data, setData] = useState(classListData);
    const [editingKey, setEditingKey] = useState('');




    const { id } = useParams();

     

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
                newData.splice(index, 1, {
                    ...item,
                    ...row,
                });
                setData(newData);
                setEditingKey('');
            } else {
                newData.push({
                    id,
                    ...row,
                });
                setData(newData);
                setEditingKey('');
            }
            console.log(data)
        } catch (errInfo) {
            console.log('Validate Failed:', errInfo);
        }
    };

    const columns = [
        {
            title: 'Name',
            dataIndex: 'name',
            width: '25%',
            editable: true,
        },
        {
            title: 'Progress',
            dataIndex: 'progress',
            width: '10%',
            editable: true,
        },
        {
            title: 'Midterm',
            dataIndex: 'midterm',
            width: '10%',
            editable: true,
        },
        {
            title: 'Practice',
            dataIndex: 'practice',
            width: '10%',
            editable: true,
        },
        {
            title: 'Final',
            dataIndex: 'final',
            width: '10%',
            editable: true,
        },
        {
            title: 'GPA',
            dataIndex: 'GPA',
            width: '10%',
            editable: true,
        },
        {
            title: 'Action',
            dataIndex: 'Action',
            render: (_, record) => {
                const editable = isEditing(record);
                return editable ? (
                    <span>
                        <Typography.Link
                            onClick={() => save(record.id)}
                            style={{
                                marginRight: 8,
                            }}>
                            <Button type="primary">Save</Button>
                        </Typography.Link>
                        <Typography.Link
                            onClick={cancel}
                            style={{
                                marginRight: 8,
                            }}>
                            <Button type="primary" danger>
                                Cancel
                            </Button>
                        </Typography.Link>
                    </span>
                ) : (
                    <span>
                        <Typography.Link disabled={editingKey !== ''} onClick={() => edit(record)}>
                            <Button type="primary">Edit</Button>
                        </Typography.Link>
                        <Typography.Link disabled={editingKey !== ''} onClick={async () => { await handleDeleteStudent(record?.id) }}>
                            <Button type="primary" danger>Delete</Button>
                        </Typography.Link>
                    </span>
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
                inputType: col.dataIndex === 'progress' ? 'number' : 'text',
                dataIndex: col.dataIndex,
                title: col.title,
                editing: isEditing(record),
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
