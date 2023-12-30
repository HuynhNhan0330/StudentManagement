import React, { useState, useEffect } from 'react';
import { Space, Button, Input, Card, Modal } from 'antd';

import EditSubjectModal from '../../../components/Admin/Modal/Edit/EditSubjectModal'
import CreateSubjectModal from '../../../components/Admin/Modal/Create/CreateSubjectModal';
import SubjectTable from '../../../components/Admin/Table/SubjectTable';
import { handleCreateSubject, handleGetSubjects, handleDeleteSubjects } from '../../../controller/SubjectController';
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
        handleCreateSubject(values).then((subject) => {
            if (subject != null) {
                // Thông báo tạo thành công

                // Cập nhật table   
                setData([...data, subject]);
            }
            else {
                // Thông báo tạo thất bại
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

    const handleEditModalOk = () => {
        setIsEditModalOpen(false);
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
                    }
                })
            }
        })
    };

    return (
        <div>
            <Card>
                <div>
                    <h5>Quản lý môn học</h5>
                </div>
                <Space className='search_subject'>
                    <Search
                        placeholder="Tìm kiếm..."
                        onSearch={(value) => console.log(value)}
                        style={{ width: 200 }}
                    />

                    <Button type="primary" onClick={handleCreate}>
                        Thêm môn học
                    </Button>
                </Space>
                <SubjectTable data = { data }
                              loading ={ loading }
                              onChange ={ handleTableChange }
                              handleDelete= { handleDelete }
                              handleEdit= { handleEdit }
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
                    setSelectedSubject = {setSelectedSubject}
            />
        </div>
    );
};

export default Subject;
