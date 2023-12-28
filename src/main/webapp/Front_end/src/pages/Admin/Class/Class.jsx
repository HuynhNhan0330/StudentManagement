import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import ClassTable from '../../../components/Admin/Table/ClassTable';
import CreateClassModal from '../../../components/Admin/Modal/Create/CreateClassModal';
import ShowClassDrawer from '../../../components/Admin/Drawer/ShowClassDrawer';
import EditClassModal from '../../../components/Admin/Modal/Edit/EditClassModal';
const { Search } = Input;

const Class = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [selectedClass, setSelectedClass] = useState(null);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);

    const showModal = () => {
        setIsModalOpen(true);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };

    const handleOk = () => {
        setIsModalOpen(false);
    };

    const showDrawer = (record) => {
        setSelectedClass(record);
        setIsDrawerOpen(true);
    };

    const closeDrawer = () => {
        setIsDrawerOpen(false);
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
                    <h5>Quản lý lớp học</h5>
                </div>
                <Space style={{ marginBottom: 16 }}>
                    <Search
                        placeholder="Search..."
                        onSearch={(value) => console.log(value)}
                        style={{ width: 200 }}
                        prefix={<SearchOutlined />}
                    />

                    <Button type="primary" onClick={showModal}>
                        Thêm mới
                    </Button>
                </Space>
                <ClassTable showDrawer={showDrawer} showEdit={handleEdit}/>
            </Card>
            <CreateClassModal open={isModalOpen} onOk={handleOk} onCancel={handleCancel} />
            <ShowClassDrawer open={isDrawerOpen} onClose={closeDrawer} selectedClass={selectedClass} />
            <EditClassModal
                    open={isEditModalOpen}
                    onCancel={handleEditModalCancel}
                    onOk={handleEditModalOk}
            />
        </div>
    );
};

export default Class;
