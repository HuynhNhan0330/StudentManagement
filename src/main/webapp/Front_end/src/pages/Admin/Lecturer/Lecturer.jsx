import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateLecturerModal from '../../../components/Admin/Modal/CreateLecturerModal';
import SendNotiLecturerModal from '../../../components/Admin/Modal/SendNotiLecturerModal';
import ShowLecturerDrawer from '../../../components/Admin/Drawer/ShowLecturerDrawer';
import LecturerTable from '../../../components/Admin/Table/LecturerTable';

const { Search } = Input;

const Lecturer = () => {
    const [isOpen, setIsOpen] = useState(false);
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [isDetailDrawerOpen, setIsDetailDrawerOpen] = useState(false);
    const [selectedStudent, setSelectedStudent] = useState(null);

    const handleDetail = (record) => {
        setSelectedStudent(record);
        setIsDetailDrawerOpen(true);
    };

    const showCreateModal = () => {
        setIsCreateModalOpen(true);
    };

    const handleNotificationModalOk = () => {
        setIsOpen(false);
    };

    const handleNotificationModalCancel = () => {
        setIsOpen(false);
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
                <LecturerTable handleDetail={handleDetail} />
            </Card>
            <SendNotiLecturerModal
                open={isOpen}
                onOk={handleNotificationModalOk}
                onCancel={handleNotificationModalCancel}
            />
            <CreateLecturerModal
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
            />
            <ShowLecturerDrawer onClose={closeDrawer} open={isDetailDrawerOpen} selectedStudent={selectedStudent} />
        </div>
    );
};

export default Lecturer;
