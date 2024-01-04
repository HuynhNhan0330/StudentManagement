import React, { useState, useEffect } from 'react';
import { Card, Button, Modal } from 'antd';
import MajorTable from '../../../components/Admin/Table/MajorTable';
import FacultyTable from '../../../components/Admin/Table/FacultyTable';
import CreateMajorModal from '../../../components/Admin/Modal/Create/CreateMajorModal';
import CreateFacultyModal from '../../../components/Admin/Modal/Create/CreateFacultyModal';
import { handleCreateFaculty, handleGetFaculties, handleDeleteFaculty } from '../../../controller/FacultyController';
import { handleGetMajors, handleCreateMajor, handleDeleteMajor } from '../../../controller/MajorController';
const MajorFaculty = () => {

    // create major
    const [isModalOpenMajor, setIsModalOpenMajor] = useState(false);

    const showModalMajor = () => {
        setIsModalOpenMajor(true);
    };

    const handleCancelMajor = () => {
        setIsModalOpenMajor(false);
    };

    const handleOkMajor = (values) => {
        handleCreateMajor(values).then((resp) => {
            if (resp.status === 200) {
                const major = resp.data;
                
                if (major != null) {
                    // Thông báo tạo thành công

                    // Cập nhật table   
                    setDataMajor([...dataMajor, major]);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo ngành thất bại");
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
            }
        })
    };

    // end

    // table major
    const [dataMajor, setDataMajor] = useState([]);
    const [loadingMajor, setLoadingMajor] = useState(false);
    const [tableParamsMajor, setTableParamsMajor] = useState({
        pagination: {
        current: 1,
        pageSize: 10,
        },
    });

    const fetchDataMajor = () => {
        setLoadingMajor(true);
        handleGetMajors().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataMajor(results);
            setLoadingMajor(false);
            setTableParamsMajor({
                ...tableParamsMajor,
                pagination: {
                ...tableParamsMajor.pagination,
                total: results.length,
                },
            });
        });
    };

    useEffect(() => {
        fetchDataMajor();
    }, [JSON.stringify(tableParamsMajor)]);

    const handleTableMajorChange = (pagination, filters, sorter) => {
        setTableParamsMajor({
            pagination,
            filters,
            ...sorter,
        });

        // `dataSource` is useless since `pageSize` changed
        if (pagination.pageSize !== tableParamsMajor.pagination?.pageSize) {
            setDataMajor([]);
        }
    };

    // end

    // delete major
    const handleDeleteMajorModal = (record) => {
        Modal.confirm({
            title: "Xác nhận xoá?",
            okText: "Có",
            cancelText: "Huỷ",
            onOk: () => {
                handleDeleteMajor(record).then((result) => {
                    if (result) {
                        setDataMajor((pre) => {
                            return pre.filter((major) => major.maNganh !== record.maNganh);
                        });
                    }
                })
            }
        })
    };
    
    // end

    
    // table faculty
    const [dataFaculty, setDataFaculty] = useState([]);
    const [loadingFaculty, setLoadingFaculty] = useState(false);
    const [tableParamsFaculty, setTableParamsFaculty] = useState({
        pagination: {
        current: 1,
        pageSize: 10,
        },
    });

    const fetchDataFaculty = () => {
        setLoadingFaculty(true);
        handleGetFaculties().then((results) => {
            if (results == null) {
                results = [];
            }   

            setDataFaculty(results);
            setLoadingFaculty(false);
            setTableParamsFaculty({
                ...tableParamsFaculty,
                pagination: {
                ...tableParamsFaculty.pagination,
                total: results.length,
                },
            });
        });
    };

    useEffect(() => {
        fetchDataFaculty();
    }, [JSON.stringify(tableParamsFaculty)]);

    const handleTableFacultyChange = (pagination, filters, sorter) => {
        setTableParamsFaculty({
            pagination,
            filters,
            ...sorter,
        });

        // `dataSource` is useless since `pageSize` changed
        if (pagination.pageSize !== tableParamsFaculty.pagination?.pageSize) {
            setDataFaculty([]);
        }
    };

    // end

    // create faculty

    const [isModalOpenFaculty, setIsModalOpenFaculty] = useState(false);
    const showModalFaculty = () => {
        setIsModalOpenFaculty(true);
    };

    const handleCancelFaculty = () => {
        setIsModalOpenFaculty(false);
    };

    const handleOkFaculty = (values) => {
        handleCreateFaculty(values).then((resp) => {
            if (resp.status === 200) {
                const faculty = resp.data;
                
                if (faculty != null) {
                    // Thông báo tạo thành công

                    // Cập nhật table   
                    setDataFaculty([...dataFaculty, faculty]);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo môn học thất bại");
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
            }
        })
    };

    // end

    // delete faculty
    const handleDeleteFacultyModal = (record) => {
        Modal.confirm({
            title: "Xác nhận xoá?",
            okText: "Có",
            cancelText: "Huỷ",
            onOk: () => {
                handleDeleteFaculty(record).then((result) => {
                    if (result) {
                        setDataFaculty((pre) => {
                            return pre.filter((faculty) => faculty.maKhoa !== record.maKhoa);
                        });
                    }
                })
            }
        })
    };
    
    // end

    return (
        <div style={{ display: 'flex', gap: '16px' }}>
            <Card title="Ngành" style={{ flex: 1, width: '50%' }}>
                <div style={{ display: 'flex', gap: '8px' }}>
                    <div>
                        <Button type="primary" onClick={showModalMajor}>
                            Thêm mới
                        </Button>
                    </div>
                </div>
                <MajorTable data = { dataMajor }
                            loading ={ loadingMajor }
                            onChange ={ handleTableMajorChange }
                            handleDelete= { handleDeleteMajorModal }
                />
            </Card>
            <CreateMajorModal open={isModalOpenMajor}
                              onOk={handleOkMajor}
                              onCancel={handleCancelMajor}
                              faculties={dataFaculty} />

            <Card title="Khoa" style={{ flex: 1, width: '50%' }}>
                <div style={{ marginTop: '8px' }}>
                    <Button type="primary" onClick={showModalFaculty}>
                        Thêm mới
                    </Button>
                </div>
                <FacultyTable data = { dataFaculty }
                              loading ={ loadingFaculty }
                              onChange ={ handleTableFacultyChange }
                              handleDelete= { handleDeleteFacultyModal }
                />
            </Card>
            <CreateFacultyModal open={isModalOpenFaculty} 
                                onOk={handleOkFaculty} 
                                onCancel={handleCancelFaculty} />
        </div>
    );
};

export default MajorFaculty;
