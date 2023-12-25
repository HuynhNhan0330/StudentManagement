import React from 'react';
import { Table, Button, Space } from 'antd';

function FacultyTable() {
    const facultyColumns = [
        {
            title: 'STT',
            dataIndex: 'stt',
            key: 'stt',
        },
        {
            title: 'Tên',
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: 'Id',
            dataIndex: 'id',
            key: 'id',
        },
        {
            title: '',
            key: 'action',
            render: (text, record) => (
                <Space size="middle">
                    <Button type="primary">Sửa</Button>
                    <Button type="primary" danger>
                        Xóa
                    </Button>
                </Space>
            ),
        },
    ];
    return (
        <Table
            dataSource={[
                { stt: 1, name: 'Khoa A', id: '11111' },
                { stt: 2, name: 'Khoa B', id: '21' },
            ]}
            columns={facultyColumns}
        />
    );
}

export default FacultyTable;
