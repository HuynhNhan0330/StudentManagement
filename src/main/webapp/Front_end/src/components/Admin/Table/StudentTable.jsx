import React from 'react';
import { Table, Space, Button } from 'antd';

function StudentTable({ handleDetail }) {
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
                    title: 'Giới tính ',
                    dataIndex: 'gioiTinh',
                    key: 'gioiTinh',
                },
                {
                    title: 'Khoa',
                    dataIndex: 'khoa',
                    key: 'khoa',
                },
                {
                    title: 'Tên ngành',
                    dataIndex: 'tenNganh',
                    key: 'tenNganh',
                },
                {
                    title: 'Năm nhập học ',
                    dataIndex: 'namNhaphoc',
                    key: 'namNhaphoc',
                },
                {
                    title: 'Số tín đã học',
                    dataIndex: 'soTin',
                    key: 'soTin',
                },
                {
                    title: 'Action',
                    key: 'action',
                    render: (_, record) => (
                        <Space size="small">
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
                    gioiTinh: 'Nam',
                    khoa: 'PM',
                    tenNganh: 'CNPM',
                    namNhaphoc: '2021',
                    soTin: '1',
                },
                {
                    key: '2',
                    stt: 2,
                    mssv: 'SV002',
                    name: 'John Brown',
                    ngaySinh: '01/01/1990',
                    gioiTinh: 'Nam',
                    khoa: 'PM',
                    tenNganh: 'CNPM',
                    namNhaphoc: '2077',
                    soTin: '1',
                },
                {
                    key: '3',
                    stt: 3,
                    mssv: 'SV003',
                    name: 'John Brown',
                    ngaySinh: '01/01/1990',
                    gioiTinh: 'Nam',
                    khoa: 'PM',
                    tenNganh: 'CNPM',
                    namNhaphoc: '2021',
                    soTin: '1',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
}

export default StudentTable;
