import React from 'react';
import { Table } from 'antd';
import { NavLink } from 'react-router-dom';
import { EditOutlined, DeleteOutlined, EyeOutlined } from '@ant-design/icons'
import { adminPaths, lecturerPaths } from '../../../routes/AppRoutes';

function ClassTable({ data, loading, handleTableChange, handleEdit, handleDelete, showDrawer, isAdmin, textSearch }) {
    const columns = [
        {
            title: 'Mã lớp',
            dataIndex: 'maLop',
            filteredValue: [textSearch],
            onFilter: (value, record) => {
                return (String(record.maLop).includes(value) ||
                    String(record.tenLop).includes(value) ||
                    String(record.tenGV).includes(value) ||
                    String(record.tenMH).includes(value))
            }
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
                    {/* <DeleteOutlined style = {{ color: "red" }}
                                    onClick = {() => { handleDelete(record); }} /> */}

                    <NavLink to = { isAdmin ? adminPaths.detatailclass.replace(":id", record.maLop) : lecturerPaths.detatailclass.replace(":id", record.maLop) }>
                        <EyeOutlined style = {{ color: "blue" }} />
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
