import React from 'react';
import { Table } from 'antd';
import { NavLink } from 'react-router-dom';
import { EditOutlined, DeleteOutlined, EyeOutlined } from '@ant-design/icons'
import { adminPaths } from '../../../routes/AppRoutes';

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

                    <NavLink to = { adminPaths.detatailclass +`${record.id}`}>
                        <EyeOutlined style = {{ color: "blue", marginLeft: 12 }} />
                    </NavLink>
                    
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
