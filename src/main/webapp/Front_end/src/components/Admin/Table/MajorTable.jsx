import React from 'react';
import { Table, Button, Space } from 'antd';

function MajorTable() {
    const MajorColumns = [
        {
            title: 'Stt',
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
                    <Button type="primary">Edit</Button>
                    <Button type="primary" danger>
                        Delete
                    </Button>
                </Space>
            ),
        },
    ];
    return (
        <Table
            dataSource={[
                { stt: 1, name: 'Khoa hoc may tinh', id: '696969' },
                { stt: 2, name: 'Phan mem', id: '11111' },
            ]}
            columns={MajorColumns}
        />
    );
}

export default MajorTable;
