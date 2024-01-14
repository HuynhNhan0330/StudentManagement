import React from 'react';
import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

function FacultyTable({ data, loading, handleTableChange, handleEdit, handleDelete }) {
    const columns = [
        {
            title: 'Mã khoa',
            dataIndex: 'maKhoa',
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
                    {/* <EditOutlined onClick={() => {handleEdit(record); }}/> */}
                    <DeleteOutlined style = {{ color: "red" }}
                                    onClick = {() => { handleDelete(record); }}
                    />
                </>
            )
        }
    ];
    return (
        <Table
            columns={ columns }
            dataSource={ data }
            loading={ loading }
            onChange={ handleTableChange }
        />
    );
}

export default FacultyTable;
