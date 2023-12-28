import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateStudentModal from '../../../components/Admin/Modal/Create/CreateStudentModal';
import ShowStudentDrawer from '../../../components/Admin/Drawer/ShowStudentDrawer';
import StudentTable from '../../../components/Admin/Table/StudentTable';
import EditStudentModal from '../../../components/Admin/Modal/Edit/EditStudentModal'
const { Search } = Input;

const Student = () => {
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [isDetailDrawerOpen, setIsDetailDrawerOpen] = useState(false);
    const [selectedStudent, setSelectedStudent] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);

    const handleDetail = (record) => {
        setSelectedStudent(record);
        setIsDetailDrawerOpen(true);
    };

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
    const closeDrawer = () => {
        setIsDetailDrawerOpen(false);
    };
    const showEditModal = (record) => {
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
    return (
        <div>
            <Card>
                <div>
                    <h5>Quản lý sinh viên</h5>
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
                <StudentTable showEdit={handleEdit} handleDetail={handleDetail} />
            </Card>
            <CreateStudentModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
            />
            <ShowStudentDrawer onClose={closeDrawer} open={isDetailDrawerOpen} selectedStudent={selectedStudent} />
            <EditStudentModal open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}
                    
    />
        </div>
    );
};

export default Student;
