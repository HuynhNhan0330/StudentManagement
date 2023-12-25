import React from 'react';
import { Space, Button, Table } from 'antd';


    
    const SubjectTable = ({ showEdit }) => {

        const Delete = () =>{
        
        };
        return (
            <>
                <Table
                    columns={[
                        {
                            title: 'Mã môn học',
                            dataIndex: 'subject_id',
                            key: 'subject_id',
                        },
                        {
                            title: 'Tên môn học',
                            dataIndex: 'name',
                            key: 'name',
                        },

                        {
                            title: 'Số tín chỉ',
                            dataIndex: 'soTinchi',
                            key: 'soTinchi',
                        },
                        {
                            title: '',
                            key: 'action',
                            render: (_, record) => (
                                <Space size="middle">
                                    <Button type="primary" onClick={()=>showEdit(record)}>
                                        Sửa
                                    </Button>
                                    <Button danger variant="contained" type="primary" onClick={() => Delete()}>
                                        Xóa
                                    </Button>

                                </Space>
                            ),
                        },
                    ]}
                    dataSource={[
                        {
                            key: '1',
                            subject_id: 'SE347',
                            name: 'Công nghệ Web',
                            soTinchi: '2',
                        },
                        {
                            key: '2',
                            subject_id: 'SE34z',
                            name: 'Mon Z',
                            soTinchi: '3',
                        },
                    ]}
                    rowSelection={{
                        type: 'checkbox',
                    }}
                />
            </>
        );
        
    };

    export default SubjectTable;
