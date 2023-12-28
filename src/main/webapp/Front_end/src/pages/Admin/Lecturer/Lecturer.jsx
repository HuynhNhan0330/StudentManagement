import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateLecturerModal from '../../../components/Admin/Modal/Create/CreateLecturerModal';
import ShowLecturerDrawer from '../../../components/Admin/Drawer/ShowLecturerDrawer';
import LecturerTable from '../../../components/Admin/Table/LecturerTable';
import EditLecturerModal from '../../../components/Admin/Modal/Edit/EditLecturerModal';
const { Search } = Input;

const Lecturer = () => {
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
                    <h5>Quản lý giảng viên</h5>
                </div>
                <Space style={{ marginBottom: 16 }}>
                    {/*<Select style={{ width: 150 }} placeholder="Select Khoa">
                        <Option value="K42">K42</Option>
                        <Option value="K43">K43</Option>
    </Select>*/}
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
                <LecturerTable handleDetail={handleDetail} showEdit={handleEdit}/>
            </Card>
            <CreateLecturerModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
            />
            <ShowLecturerDrawer onClose={closeDrawer} open={isDetailDrawerOpen} selectedStudent={selectedStudent} />
            <EditLecturerModal 
                open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}/>
        </div>
    );
};

export default Lecturer;
