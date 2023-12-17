import React from 'react';
import { Table, Space, Button } from 'antd';

function LecturerTable({ handleDetail }) {
    return (
        <Table
            columns={[
                {
                    title: 'STT',
                    dataIndex: 'stt',
                    key: 'stt',
                },

                {
                    title: 'MsGV',
                    dataIndex: 'msgv',
                    key: 'msgv',
                },
                {
                    title: 'Tên',
                    dataIndex: 'name',
                    key: 'name',
                },
                {
                    title: 'Ngày Sinh',
                    dataIndex: 'ngaySinh',
                    key: 'ngaySinh',
                },
                {
                    title: 'Email',
                    dataIndex: 'email',
                    key: 'email',
                },
                {
                    title: 'SĐT',
                    dataIndex: 'sdt',
                    key: 'sdt',
                },

                {
                    title: 'Khoa',
                    dataIndex: 'faculty',
                    key: 'faculty',
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
                            <Button variant="contained" onClick={() => handleDetail(record)}>
                                Chi tiết
                            </Button>
                            {/* 
                            <Button variant="contained" type="link">
                                Reset
                            </Button>*/}
                            
                        </Space>
                    ),
                },
            ]}
            dataSource={[
                {
                    key: '1',
                    stt: 1,
                    msgv: 'GV001',
                    name: 'John Brown',
                    ngaySinh: '01/01/1990',
                    email: 'john@example.com',
                    sdt: '123456789',
                    faculty: 'CNPM',
                },
                {
                    key: '2',
                    stt: 2,
                    msgv: 'GV002',
                    name: 'Jim Green',
                    ngaySinh: '02/02/1991',
                    email: 'jim@example.com',
                    sdt: '987654321',
                    faculty: 'CNPM',
                },
                {
                    key: '3',
                    stt: 3,
                    msgv: 'GV003',
                    name: 'Joe Black',
                    ngaySinh: '03/03/1992',
                    email: 'joe@example.com',
                    sdt: '456789123',
                    faculty: 'CNPM',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
}

export default LecturerTable;
