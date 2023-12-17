import React from 'react';
import { Table, Button, Space } from 'antd';

function ClassTable({ showDrawer }) {
    const columns = [
        {
            title: 'Mã lớp',
            dataIndex: 'class_id',
            key: 'class_id',
        },
        {
            title: 'Tên lớp',
            dataIndex: 'name',
            key: 'name',
            //render: (text) => <a>{text}</a>,
        },
        {
            title: 'Mã giảng viên',
            dataIndex: 'LecturerId',
            key: 'LecturerId',
        },

        {
            title: 'Tên giảng viên',
            dataIndex: 'LecturerName',
            key: 'LecturerName',
        },
        {
            title: 'Thời gian',
            dataIndex: 'Time',
            key: 'Time',
        },
        {
            title: 'Mã môn học',
            dataIndex: 'subject_id',
            key: 'subject_id',
        },
        {
            title: '',
            key: 'action',
            render: (_, record) => (
                <Space size="middle">
                    <Button variant="contained" type="primary">
                        Sửa
                    </Button>
                    <Button danger variant="contained" type="primary">
                        Xóa
                    </Button>
                    <Button default variant="contained" onClick={() => showDrawer(record)}>
                        Chi tiết
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
                    name: 'Lop 11.1',
                    LecturerId: '101',
                    LecturerName: 'John Doe',
                    Time: 'Thứ 6 - Tiết 1,2,3,4',
                    subject_id: '90',
                },
                {
                    key: '2',
                    class_id: '2',
                    name: '122.2',
                    LecturerId: '102',
                    LecturerName: 'Jane Smith',
                    Time: 'Thứ 7 - Tiết 5,6,7,8',
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
