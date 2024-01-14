import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, message } from 'antd';
import ClassTable from '../../../components/Admin/Table/ClassTable';
import CreateClassModal from '../../../components/Admin/Modal/Create/CreateClassModal';
import ShowClassDrawer from '../../../components/Admin/Drawer/ShowClassDrawer';
import { handleGetRoom } from '../../../controller/RoomController';
import { handleGetLecturers } from '../../../controller/LecturerController';
import { handleGetSubjects } from '../../../controller/SubjectController';
import { handleCreateClass, handleGetClasses } from '../../../controller/ClassController';

const { Search } = Input;

const Class = () => {
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [selectedClass, setSelectedClass] = useState(null);

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
        handleGetClasses().then((results) => {
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

    // create
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [dataRoom, setDataRoom] = useState([]);
    const [dataLecturer, setDataLecturer] = useState([]);
    const [dataSubject, setDataSubject] = useState([]);

    const fetchDataRoom = () => {
        handleGetRoom().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataRoom(results);
        });
    };

    const fetchDataLecturer = () => {
        handleGetLecturers().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataLecturer(results);
        });
    };

    const fetchDataSubject = () => {
        handleGetSubjects().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataSubject(results);
        });
    };

    useEffect(() => {
        fetchDataRoom();
        fetchDataLecturer();
        fetchDataSubject();
    }, [isModalOpen]);

    const showModal = () => {
        setIsModalOpen(true);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };

    const handleOk = (values) => {
        handleCreateClass(values).then((resp) => {
            if (resp.status === 200) {
                const classs = resp.data;

                if (classs != null) {
                    // Thông báo tạo thành công
                    message.open({
                        type: 'success',
                        content: 'Tạo lớp thành công',
                    });
                    // Cập nhật table   
                    setData([...data, classs]);
                    setIsModalOpen(false);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo lớp thất bại");
                    message.open({
                        type: 'error',
                        content: 'Tạo lớp thất bại',
                    });
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
                message.open({
                    type: 'error',
                    content: resp.response.data,
                });
            }
        })
    };

    // end

    const showDrawer = (record) => {
        setSelectedClass(record);
        setIsDrawerOpen(true);
    };

    const closeDrawer = () => {
        setIsDrawerOpen(false);
    };

    const [textSearch, setTextSearch] = useState("");

    return (
        <div className='adminTableContainer'>
            <Card>
                <div>
                    <h5>Quản lý lớp học</h5>
                </div>
                <Space style={{ marginBottom: 16 }} className='search_box_in_page'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => setTextSearch(value)}
                        style={{ width: 200 }}
                    />

                    <Button type="primary" onClick={showModal}>
                        Thêm mới
                    </Button>
                </Space>
                <ClassTable showDrawer={showDrawer}
                            data={data}
                            loading={loading}
                            onChange={handleTableChange}
                            isAdmin={true}
                            // handleDelete={handleDelete}
                            textSearch={textSearch}

                />
            </Card>
            <CreateClassModal open={isModalOpen} onOk={handleOk} onCancel={handleCancel} rooms={dataRoom} subjects={dataSubject} lecturers={dataLecturer} />
            <ShowClassDrawer open={isDrawerOpen} onClose={closeDrawer} selectedClass={selectedClass} />
        </div>
    );
};

export default Class;
