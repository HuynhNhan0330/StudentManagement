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
                    title: '',
                    key: 'action',
                    render: (_, record) => (
                        <Space size="small">
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
                    mssv: 'SV001',
                    name: 'Trần Văn A',
                    ngaySinh: '01/01/2003',
                    gioiTinh: 'Nam',
                    khoa: 'Công nghệ phần mềm',
                    tenNganh: 'Công nghệ phần mềm',
                    namNhaphoc: '2023',
                    soTin: '10',
                },
                {
                    key: '2',
                    stt: 2,
                    mssv: 'SV002',
                    name: 'John Brown',
                    ngaySinh: '01/01/2000',
                    gioiTinh: 'Nam',
                    khoa: 'Khoa X',
                    tenNganh: 'X',
                    namNhaphoc: '2017',
                    soTin: '100',
                },
                {
                    key: '3',
                    stt: 3,
                    mssv: 'SV003',
                    name: 'John Whites',
                    ngaySinh: '01/01/2001',
                    gioiTinh: 'Nữ',
                    khoa: 'Khoa Y',
                    tenNganh: 'Y',
                    namNhaphoc: '2021',
                    soTin: '100',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
}

export default StudentTable;
