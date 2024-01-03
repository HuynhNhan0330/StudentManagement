import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateLecturerModal from '../../../components/Admin/Modal/Create/CreateLecturerModal';
import LecturerTable from '../../../components/Admin/Table/LecturerTable';
import { handleCreateLecturer, handleGetLecturers } from '../../../controller/LecturerController';
import { handleGetFaculties } from '../../../controller/FacultyController';

const { Search } = Input;

const Lecturer = () => {

    // table
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
        handleGetLecturers().then((results) => {
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

    // create lecturer
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [dataFaculty, setDataFaculty] = useState([]);

    const fetchDataFaculty = () => {
        handleGetFaculties().then((results) => {
            setDataFaculty(results);
        });
    };

    useEffect(() => {
        fetchDataFaculty();
    }, [isCreateModalOpen]);

    const showCreateModal = () => {
        setIsCreateModalOpen(true);
    };

    const handleCreateModalOk = (values) => {
        handleCreateLecturer(values).then((resp) => {
            if (resp.status === 200) {
                const lecturer = resp.data;
                
                if (lecturer != null) {
                    // Thông báo tạo thành công

                    // Cập nhật table   
                    setData([...data, lecturer]);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo giảng viên thất bại");
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
            }
        })
    };

    const handleCreateModalCancel = () => {
        setIsCreateModalOpen(false);
    };

    const handleCreate = () => {
        showCreateModal();
    };
    // end

    return (
        <div>
            <Card>
                <div>
                    <h5>Quản lý giảng viên</h5>
                </div>
                <Space style={{ marginBottom: 16 }}>
                    <Search
                        placeholder="Search..."
                        onSearch={(value) => console.log(value)}
                        style={{ width: 200 }}
                        prefix={<SearchOutlined />}
                    />
                    <Button type="primary" onClick={handleCreate}>
                        Thêm mới
                    </Button>
                </Space>
                <LecturerTable data = { data }
                               loading ={ loading }
                               onChange ={ handleTableChange }
                            //    handleDelete= { handleDelete }
                />
            </Card>
            <CreateLecturerModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
                faculties={dataFaculty}
            />
        </div>
    );
};

export default Lecturer;
