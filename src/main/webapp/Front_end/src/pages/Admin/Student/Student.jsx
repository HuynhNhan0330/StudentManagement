import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, Modal, message } from 'antd';
import CreateStudentModal from '../../../components/Admin/Modal/Create/CreateStudentModal';
import ShowStudentDrawer from '../../../components/Admin/Drawer/ShowStudentDrawer';
import StudentTable from '../../../components/Admin/Table/StudentTable';
import { handleGetMajors } from '../../../controller/MajorController';
import { handleCreateStudent, handleDeleteStudent, handleGetStudents } from '../../../controller/StudentController';
import { isValidEmail, isValidPhoneNumber } from '../../../utils/Helper';

const { Search } = Input;

const Student = () => {
    const [isDetailDrawerOpen, setIsDetailDrawerOpen] = useState(false);
    const [selectedStudent, setSelectedStudent] = useState(null);

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
        } else if (!isValidPhoneNumber(values.phone)) {
            console.log("Số điện thoại không hợp lệ");
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

                        setIsCreateModalOpen(true);
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

    return (
        <div>
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
                />
            </Card>
            <CreateStudentModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
                majors={dataMajor}
            />
            <ShowStudentDrawer onClose={closeDrawer} open={isDetailDrawerOpen} selectedStudent={selectedStudent} />
        </div>
    );
};

export default Student;
