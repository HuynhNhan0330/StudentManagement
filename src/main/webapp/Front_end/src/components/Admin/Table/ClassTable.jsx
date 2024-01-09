import React from 'react';
import { Table, Button, Space } from 'antd';
import { EditOutlined, DeleteOutlined, EyeOutlined } from '@ant-design/icons'

function ClassTable({ data, loading, handleTableChange, handleEdit, handleDelete, showDrawer }) {
    const columns = [
        {
            title: 'Mã lớp',
            dataIndex: 'maLop',
        },
        {
            title: 'Tên lớp',
            dataIndex: 'tenLop',
        },
        {
            title: 'Tên giáo viên',
            dataIndex: 'tenGV',
        },
        {
            title: 'Tên môn học',
            dataIndex: 'tenMH',
        },
        {
            title: 'Thời gian',
            render: (text, record) => `${record.ngayHoc}: ${record.thoiGianBatDau} - ${record.thoiGianKetThuc} `
        },
        {
            title: 'Phòng học',
            dataIndex: 'tenPH',
        },
        {
            title: 'Thao tác',
            key: 'action',
            render: (record) => (
                <>
                    <EditOutlined onClick={() => {handleEdit(record); }}/>
                    <DeleteOutlined style = {{ color: "red", marginLeft: 12 }}
                                    onClick = {() => { handleDelete(record); }} />
                    <EyeOutlined style = {{ color: "blue", marginLeft: 12 }}
                                    onClick = {() => { showDrawer(record); }}/>
                </>
            )
        }
    ]

    return (
        <Table
            columns={columns}
            dataSource={ data }
            loading={ loading }
            onChange={ handleTableChange }
        />
    );
}

export default ClassTable;
