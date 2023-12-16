import React from 'react';
import { Table, Button, Space } from 'antd';

function ClassTable({ showDrawer }) {
    const columns = [
        {
            title: 'Class id',
            dataIndex: 'class_id',
            key: 'class_id',
        },
        {
            title: 'Class Name',
            dataIndex: 'name',
            key: 'name',
            render: (text) => <a>{text}</a>,
        },
        {
            title: 'Room',
            dataIndex: 'room',
            key: 'room',
        },

        {
            title: 'Program',
            dataIndex: 'program',
            key: 'program',
        },
        {
            title: 'Class Type',
            dataIndex: 'class_type',
            key: 'class_type',
        },
        {
            title: 'Subject_ID',
            dataIndex: 'subject_id',
            key: 'subject_id',
        },
        {
            title: 'Action',
            key: 'action',
            render: (_, record) => (
                <Space size="middle">
                    <Button variant="contained" type="primary">
                        Edit
                    </Button>
                    <Button danger variant="contained" type="primary">
                        Delete
                    </Button>
                    <Button default variant="contained" onClick={() => showDrawer(record)}>
                        Details
                    </Button>
                </Space>
            ),
        },
    ];
    return (
        <Table
            columns={columns}
            dataSource={[
                {
                    key: '1',
                    class_id: '1',
                    name: 'Hoa hoc',
                    room: '101',
                    program: 'John Doe',
                    class_type: '30',
                    subject_id: '90',
                },
                {
                    key: '2',
                    class_id: '2',
                    name: 'Vat Ly',
                    room: '102',
                    program: 'Jane Smith',
                    class_type: '25',
                    subject_id: '120',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
}

export default ClassTable;
