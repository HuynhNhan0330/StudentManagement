import React, { useState } from 'react';
import { Space, Table, Button, Input, Select, Modal, Card } from 'antd';
import { SearchOutlined } from '@ant-design/icons';

const { Search } = Input;
const { Option } = Select;

const Post = () => {
    const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);

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

    return (
        <div>
            <Card>
                <div>
                    <h5>Quản lý bài viết</h5>
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
                <Table
                    columns={[
                        {
                            title: <span className="custom-column-title">ID</span>,
                            dataIndex: 'id',
                            key: 'id',
                        },
                        {
                            title: <span className="custom-column-title">Tiêu đề</span>,
                            dataIndex: 'title',
                            key: 'title',
                        },
                        {
                            title: <span className="custom-column-title">Nội dung</span>,
                            dataIndex: 'content',
                            key: 'content',
                        },
                        {
                            title: <span className="custom-column-title">Ngày đăng</span>,
                            dataIndex: 'date',
                            key: 'date',
                        },
                        {
                            title: <span className="custom-column-title">File đính kèm</span>,
                            dataIndex: 'attachment',
                            key: 'attachment',
                        },
                        {
                            title: <span className="custom-column-title">Action</span>,
                            key: 'action',
                            render: (_, record) => (
                                <Space size="middle">
                                    <Button variant="contained" type="primary">
                                        Thêm
                                    </Button>
                                    <Button variant="contained" type="primary">
                                        Sửa
                                    </Button>
                                    <Button danger variant="contained" type="primary">
                                        Xóa
                                    </Button>
                                </Space>
                            ),
                        },
                    ]}
                    dataSource={[
                        {
                            key: '1',
                            id: '1',
                            title: 'Tiêu đề 1',
                            content: 'Nội dung 1',
                            date: '01/01/2023',
                            attachment: 'file1.txt',
                        },
                        {
                            key: '2',
                            id: '2',
                            title: 'Tiêu đề 2',
                            content: 'Nội dung 2',
                            date: '02/01/2023',
                            attachment: 'file2.txt',
                        },
                    ]}
                    rowSelection={{
                        type: 'checkbox',
                    }}
                />
            </Card>

            <Modal
                title="Thêm mới môn học"
                open={isCreateModalOpen}
                onOk={handleCreateModalOk}
                onCancel={handleCreateModalCancel}
            >
                {/* Add the form for creating a new subject */}
                {/* ... */}
            </Modal>
        </div>
    );
};

export default Post;
