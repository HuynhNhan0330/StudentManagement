import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, Modal, message } from 'antd';
import CreateStudentModal from '../../../components/Admin/Modal/Create/CreateStudentModal';
import ShowStudentDrawer from '../../../components/Admin/Drawer/ShowStudentDrawer';
import StudentTable from '../../../components/Admin/Table/StudentTable';
import { handleGetMajors } from '../../../controller/MajorController';
import { handleCreateStudent, handleDeleteStudent, handleGetStudents, handleUpdateStudent } from '../../../controller/StudentController';
import { isValidEmail, isValidPhoneNumber } from '../../../utils/Helper';
import EditStudentModal from '../../../components/Admin/Modal/Edit/EditStudentModal';

const { Search } = Input;

const Student = () => {
    const [isDetailDrawerOpen, setIsDetailDrawerOpen] = useState(false);

    const handleDetail = (record) => {
        setSelectedStudent(record);
        setIsDetailDrawerOpen(true);
    };

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
        handleGetStudents().then((results) => {
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

    // Create
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [dataMajor, setDataMajor] = useState([]);

    const fetchDataMajor = () => {
        handleGetMajors().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataMajor(results);
        });
    };

    useEffect(() => {
        fetchDataMajor();
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
            handleCreateStudent(values).then((resp) => {
                if (resp.status === 200) {
                    const lecturer = resp.data;

                    if (lecturer != null) {
                        // Thông báo tạo thành công
                        message.open({
                            type: 'success',
                            content: 'Tạo sinh viên thành công',
                        });
                        // Cập nhật table   
                        setData([...data, lecturer]);

                        setIsCreateModalOpen(false);
                    }
                    else {
                        // Thông báo tạo thất bại
                        console.log("Tạo sinh viên thất bại");
                        message.open({
                            type: 'error',
                            content: 'Tạo sinh viên thất bại',
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
                handleDeleteStudent(record).then((result) => {
                    if (result) {
                        setData((pre) => {
                            return pre.filter((student) => student.maSV !== record.maSV);
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

    const closeDrawer = () => {
        setIsDetailDrawerOpen(false);
    };

    // search
    const [textSearch, setTextSearch] = useState("");

    // Edit
    const [selectedStudent, setSelectedStudent] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);

    const showEditModal = (record) => {
        setSelectedStudent(record);
        setIsEditModalOpen(true);
    };

    const handleEditModalCancel = () => {
        setIsEditModalOpen(false);
    };

    const handleEditModalOk = (student) => {
        console.log(student);

        if (!isValidEmail(student.email)) {
            console.log("Email không hợp lệ");
            message.open({
                type: 'error',
                content: 'Email không hợp lệ',
            });
        } else if (!isValidPhoneNumber(student.phone)) {
            console.log("Số điện thoại không hợp lệ");
            message.open({
                type: 'error',
                content: 'Số điện thoại không hợp lệ',
            });
        } else {
            handleUpdateStudent(student).then((resp) => {
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
                                if (s.maSV === sv.maSV) {
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
                    <h5>Quản lý sinh viên</h5>
                </div>
                <Space style={{ marginBottom: 16 }} className='search_box_in_page'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => {
                            setTextSearch(value)
                        }}
                        style={{ width: 200 }}
                    />
                    <Button type="primary" onClick={handleCreate}>
                        Thêm mới
                    </Button>
                </Space>
                <StudentTable handleDetail={handleDetail} 
                    data={data}
                    loading={loading}
                    onChange={handleTableChange}
                    handleDelete={handleDelete}
                    textSearch={textSearch}
                    handleEdit={handleEdit}
                />
            </Card>
            <CreateStudentModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
                majors={dataMajor}
            />
            
            <EditStudentModal
                    open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}
                    majors={dataMajor}
                    selectedStudent={selectedStudent}
            />
            
            <ShowStudentDrawer onClose={closeDrawer} open={isDetailDrawerOpen} selectedStudent={selectedStudent} />
        </div>
    );
};

export default Student;
