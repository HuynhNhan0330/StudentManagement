import {
    Card,
    Divider,
    Space,
    Breadcrumb,
    Descriptions,
    Button,
    Input,
} from 'antd';
import { EditOutlined } from '@ant-design/icons';
import StudentListTable from '../../../components/Admin/Table/StudentListTable';
import 'boxicons/css/boxicons.min.css';

import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import { adminPaths } from '../../../routes/AppRoutes';
import { handleGetClassById } from '../../../controller/ClassController';
import { handleGetScoreByClass } from '../../../controller/ScoreController';

function DetailClass() {
    const [editing, setEditing] = useState(false);

    const [selectedSchoolClass, setSelectedSchoolClass] = useState(null);

    // base
    const items = [
        {
            key: '1',
            label: 'Tên lớp',
            children: selectedSchoolClass?.tenLop,
        },
        {
            key: '2',
            label: 'Giảng viên',
            children: selectedSchoolClass?.tenGV,
        },
        {
            key: '5',
            label: 'Tên môn học',
            children: selectedSchoolClass?.tenMH,
        }
    ];

    // end

    // set data class
    let classId = useParams().id;

    useEffect(() => {
        // get api     
        handleGetClassById(classId).then((classs) => {
            setSelectedSchoolClass(classs);
        });

    }, [classId]);

    // end

    // edit class
    
    const [editedDescriptions, setEditedDescriptions] = useState([...items]);

    useEffect(() => {
        setEditedDescriptions([...items]);
    }, []);
    
    const handleEdit = () => {
        // if (data.length > 0) {
        //     console.log("Đã có sinh viên không sửa được");
        // }
        // else
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

    // table

    const [data, setData] = useState([]);

    const fetchData = () => {
        console.log(classId)
        handleGetScoreByClass(classId).then((results) => {
            if (results == null) {
                results = [];
            }

            setData(results);
        });
            
    };

    useEffect(() => {
        fetchData();
    }, [classId]);


    // end

    return (
        <div className='adminTableContainer'>
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
                {/* <Space>
                    {editing ? (
                        <>
                            <Button type="primary" onClick={handleSave}>
                                Lưu
                            </Button>
                            <Button onClick={handleCancel}>Huỷ</Button>
                        </>
                    ) : (
                        <Button icon={<EditOutlined />} onClick={handleEdit}>
                            Sửa
                        </Button>
                    )}
                </Space> */}
                {renderDescriptions()}
            </Card>
            <Divider style={{ color: 'blue', fontSize: '16px' }}>Danh sách học sinh</Divider>
            <StudentListTable classListData = { data } classs={selectedSchoolClass}/>

        </div>
    );
}

export default DetailClass;
