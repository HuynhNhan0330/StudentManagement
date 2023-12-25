import React from 'react';
import { Table, Button, Space } from 'antd';

function MajorTable() {
    const MajorColumns = [
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
                { stt: 1, name: 'Khoa học máy tính', id: '22222' },
                { stt: 2, name: 'Công nghệ phần mềm', id: '11111' },
            ]}
            columns={MajorColumns}
        />
    );
}

export default MajorTable;
