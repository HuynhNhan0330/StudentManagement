import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, message } from 'antd';
import ClassTable from '../../../../components/Admin/Table/ClassTable';
import { handleGetClassesByLecturer } from '../../../../controller/ClassController';
import './ClassLecturer.scss'
const { Search } = Input;

const ClassLecturer = () => {
    const [user, setUser] = useState(JSON.parse(localStorage.getItem('account')));


    // Table
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false);
    const [tableParams, setTableParams] = useState({
        pagination: {
            current: 1,
            pageSize: 10,
        },
    });

    const fetchData = () => {
        setLoading(true);
        setUser(JSON.parse(localStorage.getItem('account')));
        handleGetClassesByLecturer(user.maGV).then((results) => {
            if (results == null) {
                results = [];
            }

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
    // end

    const [textSearch, setTextSearch] = useState("");


    return (
        <div className='DanhSachLopHocContainer'>
            <Card>
                <div>
                    <h5>Danh sách lớp học</h5>
                </div>
                <Space style={{ marginBottom: 16 }} className='search_box_in_page'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => setTextSearch(value)}
                        style={{ width: 200 }}
                    />
                    
                </Space>
                <ClassTable
                            data={data}
                            loading={loading}
                            onChange={handleTableChange}
                            isAdmin = {false}
                            textSearch={textSearch}
                            // handleDelete={handleDelete}
                />
            </Card>
            
        </div>
    );
};

export default ClassLecturer;
