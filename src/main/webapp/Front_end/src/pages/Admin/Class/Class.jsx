import React, { useState } from 'react';
import { Space, Button, Input, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import ClassTable from '../../../components/Admin/Table/ClassTable';
import CreateClassModal from '../../../components/Admin/Modal/CreateClassModal';
import ShowClassDrawer from '../../../components/Admin/Drawer/ShowClassDrawer';

const { Search } = Input;

const Class = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [selectedClass, setSelectedClass] = useState(null);

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
                <ClassTable showDrawer={showDrawer} />
            </Card>
            <CreateClassModal open={isModalOpen} onOk={handleOk} onCancel={handleCancel} />
            <ShowClassDrawer open={isDrawerOpen} onClose={closeDrawer} selectedClass={selectedClass} />
        </div>
    );
};

export default Class;
