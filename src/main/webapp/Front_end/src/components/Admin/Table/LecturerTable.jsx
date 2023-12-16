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
                    title: 'Mssv',
                    dataIndex: 'mssv',
                    key: 'mssv',
                },
                {
                    title: 'Name',
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
                    title: 'SDT',
                    dataIndex: 'sdt',
                    key: 'sdt',
                },

                {
                    title: 'Faculty',
                    dataIndex: 'faculty',
                    key: 'faculty',
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
                            <Button variant="contained" onClick={() => handleDetail(record)}>
                                Detail
                            </Button>
                            <Button variant="contained" type="link">
                                Reset
                            </Button>
                        </Space>
                    ),
                },
            ]}
            dataSource={[
                {
                    key: '1',
                    stt: 1,
                    mssv: 'SV001',
                    name: 'John Brown',
                    ngaySinh: '01/01/1990',
                    email: 'john@example.com',
                    sdt: '123456789',
                    faculty: 'CNPM',
                },
                {
                    key: '2',
                    stt: 2,
                    mssv: 'SV002',
                    name: 'Jim Green',
                    ngaySinh: '02/02/1991',
                    email: 'jim@example.com',
                    sdt: '987654321',
                    faculty: 'CNPM',
                },
                {
                    key: '3',
                    stt: 3,
                    mssv: 'SV003',
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
