import React from 'react';
import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

function LecturerTable({ data, loading, handleTableChange, handleEdit, handleDelete }) {
    const columns = [
        {
            title: 'Mã giáo viên',
            dataIndex: 'maGV',
        },
        {
            title: 'Tên giáo viên',
            dataIndex: 'tenTK',
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
            title: 'Tên khoa',
            dataIndex: 'tenKhoa',
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

export default LecturerTable;
