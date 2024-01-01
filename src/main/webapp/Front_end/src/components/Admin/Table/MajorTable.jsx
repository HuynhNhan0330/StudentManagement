import React from 'react';
import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

function MajorTable({ data, loading, handleTableChange, handleEdit, handleDelete }) {
    const columns = [
        {
            title: 'Mã ngành',
            dataIndex: 'maNganh',
        },
        {
            title: 'Tên ngành',
            dataIndex: 'tenNganh',
        },

        {
            title: 'Thuộc Khoa',
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

export default MajorTable;
