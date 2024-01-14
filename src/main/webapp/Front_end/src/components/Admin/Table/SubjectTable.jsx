import React, { useState, useEffect } from 'react';
import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

const SubjectTable = ({ data, loading, handleTableChange, handleEdit, handleDelete, textSearch }) => {
    const columns = [
        {
            title: 'Mã môn học',
            dataIndex: 'maMH',
            filteredValue: [textSearch],
            onFilter: (value, record) => {
                return (String(record.maMH).includes(value) ||
                    String(record.tenMH).includes(value));
            }
        },
        {
            title: 'Tên môn học',
            dataIndex: 'tenMH',
        },

        {
            title: 'Số tín chỉ',
            dataIndex: 'soTinChi',
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

    // const [dataSource, setDatasource] = useState([]);

    return (
        <Table
            columns={ columns }
            dataSource={ data }
            loading={ loading }
            onChange={ handleTableChange }
        />
    );
};

export default SubjectTable;
