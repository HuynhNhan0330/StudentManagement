import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';

import EditSubjectModal from '../../../components/Admin/Modal/Edit/EditSubjectModal'
import CreateSubjectModal from '../../../components/Admin/Modal/Create/CreateSubjectModal';
import SubjectTable from '../../../components/Admin/Table/SubjectTable';
import './Subject.scss'
const { Search } = Input;

const Subject = () => {
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);

    const [selectedSubject, setSelectedSubject] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);


    const showCreateModal = () => {
        setIsCreateModalOpen(true);
    };

    const handleCreateModalOk = () => {
        setIsCreateModalOpen(false);
    };

    const handleCreateModalCancel = () => {
        setIsCreateModalOpen(false);
    };

    const handleCreate = () => {
        showCreateModal();
    };

    

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

    const handleEdit = () => {
        showEditModal();
    };

    const classesData = [
        {
            key: '1',
            class_name: 'Class A',
        },
    ];

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
                        Thêm mới
                    </Button>
                </Space>
                <SubjectTable showEdit={handleEdit} />
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
            />
        </div>
    );
};

export default Subject;
