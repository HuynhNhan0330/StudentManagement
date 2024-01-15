import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, Modal, message } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateLecturerModal from '../../../components/Admin/Modal/Create/CreateLecturerModal';
import LecturerTable from '../../../components/Admin/Table/LecturerTable';
import { handleCreateLecturer, handleDeleteLecturer, handleGetLecturers, handleUpdateLecturer } from '../../../controller/LecturerController';
import { handleGetFaculties } from '../../../controller/FacultyController';
import { isValidEmail, isValidPhoneNumber } from '../../../utils/Helper';
import EditLecturerModal from '../../../components/Admin/Modal/Edit/EditLecturerModal';

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

    // create lecturer
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [dataFaculty, setDataFaculty] = useState([]);

    const fetchDataFaculty = () => {
        handleGetFaculties().then((results) => {
            if (results == null) {
                results = [];
            }   

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
        if (!isValidEmail(values.email)) {
            console.log("Email không hợp lệ");
            message.open({
                type: 'error',
                content: 'Email không hợp lệ',
            });
        } else if (!isValidPhoneNumber(values.phone)) {
            console.log("Số điện thoại không hợp lệ");
            message.open({
                type: 'error',
                content: 'Số điện thoại không hợp lệ',
            });
        } else {
            handleCreateLecturer(values).then((resp) => {
                if (resp.status === 200) {
                    const lecturer = resp.data;

                    if (lecturer != null) {
                        // Thông báo tạo thành công
                        message.open({
                            type: 'success',
                            content: 'Tạo giảng viên thành công',
                        });
                        // Cập nhật table   
                        setData([...data, lecturer]);

                        setIsCreateModalOpen(true);
                    }
                    else {
                        // Thông báo tạo thất bại
                        console.log("Tạo giảng viên thất bại");
                        message.open({
                            type: 'error',
                            content: 'Tạo giảng viên thất bại',
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
        }
    };

    const handleCreateModalCancel = () => {
        setIsCreateModalOpen(false);
    };

    const handleCreate = () => {
        showCreateModal();
    };
    // end

    // delete
    const handleDelete = (record) => {
        Modal.confirm({
            title: "Xác nhận xoá?",
            okText: "Có",
            cancelText: "Huỷ",
            onOk: () => {
                handleDeleteLecturer(record).then((result) => {
                    if (result) {
                        setData((pre) => {
                            return pre.filter((lecturer) => lecturer.maGV !== record.maGV);
                        });
                    } else {
                        message.open({
                            type: 'error',
                            content: 'Xoá thất bại',
                        });
                    }
                })
            }
        })
    };
    // end

    const [textSearch, setTextSearch] = useState("");


    // Edit
    const [selectedLecturer, setSelectedLecturer] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);

    const showEditModal = (record) => {
        setSelectedLecturer(record);
        setIsEditModalOpen(true);
    };

    const handleEditModalCancel = () => {
        setIsEditModalOpen(false);
    };

    const handleEditModalOk = (lecturer) => {
        console.log(lecturer);

        if (!isValidEmail(lecturer.email)) {
            console.log("Email không hợp lệ");
            message.open({
                type: 'error',
                content: 'Email không hợp lệ',
            });
        } else if (!isValidPhoneNumber(lecturer.phone)) {
            console.log("Số điện thoại không hợp lệ");
            message.open({
                type: 'error',
                content: 'Số điện thoại không hợp lệ',
            });
        } else {
            handleUpdateLecturer(lecturer).then((resp) => {
                if (resp.status === 200) {
                    const sv = resp.data;
                    console.log(sv);

                    if (sv != null) {
                        message.open({
                            type: 'success',
                            content: 'Cập nhật sinh viên thành công',
                        });
            
                        setData(pre => {
                            return pre.map(s => {
                                if (s.maGV === sv.maGV) {
                                    return sv;
                                } else {
                                    return s;
                                }
                            })
                        })
            
                        setIsEditModalOpen(false);
                    }
                    else {
                        // Thông báo tạo thất bại
                        console.log("Tạo sinh viên thất bại");
                        message.open({
                            type: 'error',
                            content: 'Cập nhật sinh viên thất bại',
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
        }
    };

    const handleEdit = (record) => {
        showEditModal({...record});
    };
    // end edit

    return (
        <div className='adminTableContainer'>
            <Card>
                <div>
                    <h5>Quản lý giảng viên</h5>
                </div>
                <Space style={{ marginBottom: 16 }} className='search_box_in_page'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => setTextSearch(value) }
                        style={{ width: 200 }}
                    />
                    <Button type="primary" onClick={handleCreate}>
                        Thêm mới
                    </Button>
                </Space>
                <LecturerTable data={data}
                    loading={loading}
                    onChange={handleTableChange}
                    handleDelete={handleDelete}
                    textSearch={textSearch}
                    handleEdit={handleEdit}
                />
            </Card>
            <CreateLecturerModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
                faculties={dataFaculty}
            />

<EditLecturerModal
                    open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}
                    faculties={dataFaculty}
                    selectedLecturer={selectedLecturer}
            />
        </div>
    );
};

export default Lecturer;
