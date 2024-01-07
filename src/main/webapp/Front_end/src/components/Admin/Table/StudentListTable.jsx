import React, { useState } from 'react';
import { Form, Input, InputNumber, Table, Typography, Button } from 'antd';
import './StudentListTable.scss'
const classListData = [
    { id: 1, name: 'Student 1', progress: 80, midterm: 75, practice: 90, final: 85, GPA: 85 },
    { id: 2, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
    { id: 3, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
    { id: 4, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
    { id: 5, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
];

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
    const [form] = Form.useForm();
    const [data, setData] = useState(classListData);
    const [editingKey, setEditingKey] = useState('');

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
        } catch (errInfo) {
            console.log('Validate Failed:', errInfo);
        }
    };

    const columns = [
        {
            title: 'Họ tên',
            dataIndex: 'name',
            width: '20%',
            //editable: true,
        },
        {
            title: 'Quá trình',
            dataIndex: 'progress',
            width: '12%',
            editable: true,
        },
        {
            title: 'Giữa kì',
            dataIndex: 'midterm',
            width: '12%',
            editable: true,
        },
        {
            title: 'Thực hành',
            dataIndex: 'practice',
            width: '12%',
            editable: true,
        },
        {
            title: 'Cuối kì',
            dataIndex: 'final',
            width: '12%',
            editable: true,
        },
        {
            title: 'GPA',
            dataIndex: 'GPA',
            width: '12%',
            editable: true,
        },
        {
            title: 'Thao tác',
            dataIndex: 'Action',
            render: (_, record) => {
                const editable = isEditing(record);
                return editable ? (
                    <span>
                        <Typography.Link
                            onClick={() => save(record.id)}
                            style={{
                                marginRight: 8,
                            }}
                        >
                            <Button type="primary">Save</Button>
                        </Typography.Link>
                        <Typography.Link
                            onClick={cancel}
                            style={{
                                marginRight: 8,
                            }}
                        >
                            <Button type="primary" danger>
                                Cancel
                            </Button>
                        </Typography.Link>
                    </span>
                ) : (
                    <Typography.Link disabled={editingKey !== ''} onClick={() => edit(record)}>
                        <Button type="primary">Edit</Button>
                    </Typography.Link>
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
    );
};

export default StudentListTable;
