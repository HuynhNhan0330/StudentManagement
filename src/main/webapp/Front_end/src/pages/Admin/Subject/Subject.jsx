import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, Modal, message } from 'antd';

import EditSubjectModal from '../../../components/Admin/Modal/Edit/EditSubjectModal'
import CreateSubjectModal from '../../../components/Admin/Modal/Create/CreateSubjectModal';
import SubjectTable from '../../../components/Admin/Table/SubjectTable';
import { handleCreateSubject, handleGetSubjects, handleDeleteSubjects, handleUpdateSubject } from '../../../controller/SubjectController';
import './Subject.scss'
const { Search } = Input;

const Subject = () => {
    // Table:
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
        handleGetSubjects().then((results) => {
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

    // end table

    // Create
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);

    const showCreateModal = () => {
        setIsCreateModalOpen(true);
    };

    const handleCreateModalOk = (values) => {
        handleCreateSubject(values).then((resp) => {
            if (resp.status === 200) {
                const subject = resp.data;
                
                if (subject != null) {
                    // Thông báo tạo thành công
                    message.open({
                        type: 'success',
                        content: 'Tạo môn thành công',
                    });
                    // Cập nhật table   
                    setData([...data, subject]);

                    setIsCreateModalOpen(true);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo môn học thất bại");
                    message.open({
                        type: 'error',
                        content: 'Tạo môn thất bại',
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

    const handleCreateModalCancel = () => {
        setIsCreateModalOpen(false);
    };

    const handleCreate = () => {
        showCreateModal();
    };

    // end create
    
    // Edit
    const [selectedSubject, setSelectedSubject] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);

    const showEditModal = (record) => {
        setSelectedSubject(record);
        setIsEditModalOpen(true);
    };

    const handleEditModalCancel = () => {
        setIsEditModalOpen(false);
    };

    const handleEditModalOk = (subject) => {
        handleUpdateSubject(subject).then(() => {
            message.open({
                type: 'success',
                content: 'Cập nhật môn thành công',
            });

            setData(pre => {
                return pre.map(s => {
                    if (s.maMH === subject.maMH) {
                        return subject;
                    } else {
                        return s;
                    }
                })
            })

            setIsEditModalOpen(false);
        })
    };

    const handleEdit = (record) => {
        showEditModal({...record});
    };
    // end edit

    const handleDelete = (record) => {
        Modal.confirm({
            title: "Xác nhận xoá?",
            okText: "Có",
            cancelText: "Huỷ",
            onOk: () => {
                handleDeleteSubjects(record).then((result) => {
                    if (result) {
                        setData((pre) => {
                            return pre.filter((subject) => subject.maMH !== record.maMH);
                        });

                        message.open({
                            type: 'success',
                            content: 'Xoá môn thành công',
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

    const [textSearch, setTextSearch] = useState("");

    return (
        <div className='adminTableContainer'>
            <Card>
                <div>
                    <h5>Quản lý môn học</h5>
                </div>
                <Space className='search_box_in_page'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => setTextSearch(value)}
                        style={{ width: 200 }}
                    />

                    <Button type="primary" onClick={handleCreate}>
                        Thêm mới
                    </Button>
                </Space>
                <SubjectTable data = { data }
                              loading ={ loading }
                              onChange ={ handleTableChange }
                              handleDelete= { handleDelete }
                              handleEdit= { handleEdit }
                              textSearch={textSearch}
                />
            </Card>

            <CreateSubjectModal
                open={isCreateModalOpen}
                onCancel={handleCreateModalCancel}
                onOk={handleCreateModalOk}
            />
            
            <EditSubjectModal
                    open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}
                    selectedSubject={selectedSubject}
                    setSelectedSubject={setSelectedSubject}
            />
        </div>
    );
};

export default Subject;
