import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import CreateSubjectModal from '../../../components/Admin/Modal/CreateSubjectModal';
import ShowSubjectDrawer from '../../../components/Admin/Drawer/ShowSubjectDrawer';
import SubjectTable from '../../../components/Admin/Table/SubjectTable';

const { Search } = Input;

const Subject = () => {
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [selectedSubject, setSelectedSubject] = useState(null);

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

    const showDrawer = (subject) => {
        setSelectedSubject(subject);
        setIsDrawerOpen(true);
    };

    const onCloseDrawer = () => {
        setIsDrawerOpen(false);
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
                <SubjectTable showDrawer={showDrawer} />
            </Card>
            <CreateSubjectModal
                open={isCreateModalOpen}
                onCancel={handleCreateModalCancel}
                onOk={handleCreateModalOk}
            />
            <ShowSubjectDrawer
                open={isDrawerOpen}
                onClose={onCloseDrawer}
                classesData={classesData}
                selectedSubject={selectedSubject}
            />
        </div>
    );
};

export default Subject;
