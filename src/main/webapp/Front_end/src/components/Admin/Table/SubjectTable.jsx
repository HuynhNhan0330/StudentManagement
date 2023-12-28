import React, { useEffect, useState } from "react";
import { Space, Button, Table } from 'antd';
import { handleGetSubjects } from '../../../controller/SubjectController';

const Delete = () => {

};

const SubjectTable = ({ showEdit }) => {
    const [data, setData] = useState();
    const [loading, setLoading] = useState(false);
    const [tableParams, setTableParams] = useState({
        pagination: {
            current: 1,
            pageSize: 5,
        },
    });

    const columns = [
        {
            title: 'Mã môn học',
            dataIndex: 'maMH',
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
            render: (_, record) => (
                <Space size="middle">
                    <Button type="primary" onClick={() => Delete()}>
                        Sửa
                    </Button>
                    <Button danger variant="contained" type="primary" onClick={() => Delete()}>
                        Xóa
                    </Button>
                </Space>
            ),
        },
    ]

    const fetchData = () => {
        setLoading(true);
        handleGetSubjects().then((results) => {
            setData(results);
            setLoading(false);
            setTableParams({
                ...tableParams,
                pagination: {
                    ...tableParams.pagination,
                    total: results.length,
                },
            });
        });
    };

    useEffect(() => {
        fetchData();
    }, [JSON.stringify(tableParams)]);

    const handleTableChange = (pagination, filters, sorter) => {
        setTableParams({
            pagination,
            filters,
            ...sorter,
        });

        // `dataSource` is useless since `pageSize` changed
        if (pagination.pageSize !== tableParams.pagination?.pageSize) {
            setData([]);
        }
    };

    return (
        <Table
            columns={columns}
            dataSource={data}
            loading={loading}
            onChange={handleTableChange}
            pagination={tableParams.pagination}
        />
    );
};

export default SubjectTable;
