import {
    Card,
    Table,
    Divider,
    Space,
    Typography,
    List,
    Breadcrumb,
    Descriptions,
    Badge,
    Tabs,
    Button,
    Input,
} from 'antd';
import { EditOutlined } from '@ant-design/icons';
import StudentListTable from '../../../components/Admin/Table/StudentListTable';
import { FloatButton } from 'antd';
import 'boxicons/css/boxicons.min.css';

import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import { adminPaths } from '../../../routes/AppRoutes';

const Column = Table.Column;
const Title = Typography.Title;

function DetailClass() {
    const [editing, setEditing] = useState(false);

    

    const [selectedSchoolClass, setSelectedSchoolClass] = useState({});

    let subjectId = useParams().id;

    


    const classListData = [
        { id: 1, name: 'Student 1', progress: 80, midterm: 75, practice: 90, final: 85, GPA: 85 },
        { id: 2, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
        { id: 3, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
        { id: 4, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
        { id: 5, name: 'Student 2', progress: 70, midterm: 80, practice: 85, final: 78, GPA: 78 },
    ];

    const items = [
        {
            key: '1',
            label: 'Tên lớp',
            children: selectedSchoolClass?.id + ' - ' + selectedSchoolClass?.name,
        },
        {
            key: '2',
            label: 'Giảng viên',
            children: selectedSchoolClass?.lecturer?.name,
        },
        {
            key: '5',
            label: 'Mã môn học',
            children: selectedSchoolClass?.subject?.id,
        },
        {
            key: '7',
            label: 'Ghi chú',
            children: '............................',
        },
    ];
    const [editedDescriptions, setEditedDescriptions] = useState([...items]);

    const handleEdit = () => {
        setEditing(true);
    };

    const handleSave = () => {
        setEditing(false);
        console.log('Saved:', editedDescriptions);
    };

    const handleCancel = () => {
        setEditing(false);
        setEditedDescriptions([...items]);
    };

    const onChange = (key) => {
        console.log(key);
    };
    

    const renderDescriptions = () => {
        if (editing) {
            return (
                <Descriptions bordered>
                    {editedDescriptions.map((item) => (
                        <Descriptions.Item key={item.key} label={item.label}>
                            <Input
                                value={item.children}
                                onChange={(e) => {
                                    const updatedDescriptions = editedDescriptions.map((d) => {
                                        if (d.key === item.key) {
                                            return { ...d, children: e.target.value };
                                        }
                                        return d;
                                    });
                                    setEditedDescriptions(updatedDescriptions);
                                }}
                            />
                        </Descriptions.Item>
                    ))}
                </Descriptions>
            );
        }

        return <Descriptions bordered items={items} />;
    };

    return (
        <div>
            <Card>
                <Breadcrumb
                    items={[
                        {
                            title: (
                                <a href={adminPaths.class} className="breadcrumb-link">
                                    Lớp học
                                </a>
                            ),
                        },
                        {
                            title: <span className="breadcrumb-link">Chi tiết lớp học</span>,
                        },
                    ]}
                />
                <Divider style={{ color: 'blue', fontSize: '16px' }}>Chi tiết lớp</Divider>
                <Space>
                    {editing ? (
                        <>
                            <Button type="primary" onClick={handleSave}>
                                Save
                            </Button>
                            <Button onClick={handleCancel}>Cancel</Button>
                        </>
                    ) : (
                        <Button icon={<EditOutlined />} onClick={handleEdit}>
                            Edit
                        </Button>
                    )}
                </Space>
                {renderDescriptions()}
            </Card>
            <Divider style={{ color: 'blue', fontSize: '16px' }}>Danh sách học sinh</Divider>
            <StudentListTable />
            <FloatButton
                type='primary'
                description="Add student"
                shape="square"
                style={{
                    right: '2.5%',
                    width: '150px',
                    bottom: '1%'
                }}
    />
        </div>
    );
}

export default DetailClass;
