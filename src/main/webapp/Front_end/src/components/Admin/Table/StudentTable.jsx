import React from 'react';
import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

function StudentTable({ data, loading, handleTableChange, handleEdit, handleDelete, handleDetail, textSearch }) {
    const columns = [
        {
            title: 'Mã sinh viên',
            dataIndex: 'maSV',
            filteredValue: [textSearch],
            onFilter: (value, record) => {
                return (String(record.maSV).includes(value) ||
                    String(record.tenTK).includes(value));
            }
        },
        {
            title: 'Tên sinh viên',
            dataIndex: 'tenTK',
        },
        {
            title: 'Giới tính',
            dataIndex: 'gioiTinh',
        },
        {
            title: 'Ngày sinh',
            dataIndex: 'ngaySinh',
        },
        {
            title: 'Email',
            dataIndex: 'email',
        },
        {
            title: 'Số điện thoại',
            dataIndex: 'phone',
        },
        {
            title: 'Ngành',
            dataIndex: 'tenNganh',
        },
        {
            title: 'Năm nhập học',
            dataIndex: 'namNhapHoc',
        },
        {
            title: 'Thao tác',
            key: 'action',
            render: (record) => (
                <>
                    <EditOutlined onClick={() => {handleEdit(record); }}/>
                    <DeleteOutlined style = {{ color: "red", marginLeft: 12 }}
                                    onClick = {() => { handleDelete(record); }}
                    />
                </>
            )
        }
    ]

    return (
        <Table
            columns={ columns }
            dataSource={ data }
            loading={ loading }
            onChange={ handleTableChange }
        />
    );
}

export default StudentTable;
