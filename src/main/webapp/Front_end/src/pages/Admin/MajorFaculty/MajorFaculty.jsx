import React, { useState, useEffect } from 'react';
import { Card, Button, Modal, message } from 'antd';
import MajorTable from '../../../components/Admin/Table/MajorTable';
import FacultyTable from '../../../components/Admin/Table/FacultyTable';
import CreateMajorModal from '../../../components/Admin/Modal/Create/CreateMajorModal';
import CreateFacultyModal from '../../../components/Admin/Modal/Create/CreateFacultyModal';
import { handleCreateFaculty, handleGetFaculties, handleDeleteFaculty } from '../../../controller/FacultyController';
import { handleGetMajors, handleCreateMajor, handleDeleteMajor, handleUpdateMajor } from '../../../controller/MajorController';
import EditMajorModal from '../../../components/Admin/Modal/Edit/EditMajorModal';
import EditFacultyModal from '../../../components/Admin/Modal/Edit/EditFacultyModal';
import '../Responsive.scss'
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
                    message.open({
                        type: 'success',
                        content: 'Tạo ngành thành công',
                    });
                    // Cập nhật table   
                    setDataMajor([...dataMajor, major]);
                    setIsModalOpenMajor(false);
                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo ngành thất bại");
                    message.open({
                        type: 'error',
                        content: 'Tạo ngành thất bại',
                    });
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
                message.open({
                    type: 'error',
                    content: resp.response.data,
                });
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
                    } else {
                        message.open({
                            type: 'error',
                            content: 'Xoá thất bại',
                        });
                    }
                })
            }
        })
    };

    // end

    // Edit major
    const [selectedMajor, setSelectedMajor] = useState(null);
    const [isEditMajorModalOpen, setIsEditMajorModalOpen] = useState(false);

    const showEditMajorModal = (record) => {
        setSelectedMajor(record);
        setIsEditMajorModalOpen(true);
    };

    const handleEditMajorModalCancel = () => {
        setIsEditMajorModalOpen(false);
    };

    const handleEditModalOk = (major) => {
        handleUpdateMajor(major).then((resp) => {
            const majorUpdate = resp.data

            message.open({
                type: 'success',
                content: 'Cập nhật ngành thành công',
            });

            setDataMajor(pre => {
                return pre.map(ng => {
                    if (ng.maNganh === majorUpdate.maNganh) {
                        return majorUpdate;
                    } else {
                        return ng;
                    }
                })
            })

            setIsEditMajorModalOpen(false);
        })
    };

    const handleMajorEdit = (record) => {
        showEditMajorModal({ ...record });
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
                    message.open({
                        type: 'success',
                        content: 'Tạo khoa thành công',
                    });
                    // Cập nhật table   
                    setDataFaculty([...dataFaculty, faculty]);
                    setIsModalOpenFaculty(false);

                }
                else {
                    // Thông báo tạo thất bại
                    console.log("Tạo khoa thất bại");
                    message.open({
                        type: 'error',
                        content: 'Tạo khoa thất bại',
                    });
                }
            }
            else {
                // Thông báo tạo thất bại
                console.log(resp.response.data);
                message.open({
                    type: 'error',
                    content: resp.response.data,
                });
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
                    } else {
                        message.open({
                            type: 'error',
                            content: 'Xoá thất bại',
                        });
                    }
                })
            }
        })
    };

    // end

    // Edit faculty
    const [selectedFaculty, setSelectedFaculty] = useState(null);
    const [isEditFacultyModalOpen, setIsEditFacultyModalOpen] = useState(false);

    const showEditFacultyModal = (record) => {
        setSelectedFaculty(record);
        setIsEditFacultyModalOpen(true);
    };

    const handleEditFacultyModalCancel = () => {
        setIsEditFacultyModalOpen(false);
    };

    const handleEditFacultyModalOk = (major) => {
        // handleUpdateFaculty(faculty).then((resp) => {
        //     const facultyUpdate = resp.data

        //     message.open({
        //         type: 'success',
        //         content: 'Cập nhật ngành thành công',
        //     });

        //     setDataFaculty(pre => {
        //         return pre.map(ng => {
        //             if (ng.maNganh === facultyUpdate.maNganh) {
        //                 return facultyUpdate;
        //             } else {
        //                 return ng;
        //             }
        //         })
        //     })

        //     setIsEditFacultyModalOpen(false);
        // })
    };

    const handleFacultyEdit = (record) => {
        showEditFacultyModal({ ...record });
    };

    // end

    return (
        <div className='adminTableContainer' style={{backgroundColor: 'white'}}>
            <div style={{ display: 'flex', gap: '16px' ,backgroundColor: 'white' }}>
                <Card title="Ngành" style={{ flex: 1, width: '50%' }}>
                    <div style={{ display: 'flex', gap: '8px' }}>
                        <div>
                            <Button type="primary" onClick={showModalMajor}>
                                Thêm mới
                            </Button>
                        </div>
                    </div>
                    <MajorTable data={dataMajor}
                        loading={loadingMajor}
                        onChange={handleTableMajorChange}
                        handleDelete={handleDeleteMajorModal}
                        handleEdit={handleMajorEdit}
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
                    <FacultyTable data={dataFaculty}
                        loading={loadingFaculty}
                        onChange={handleTableFacultyChange}
                        handleDelete={handleDeleteFacultyModal}
                        handleEdit={handleFacultyEdit}
                    />
                </Card>
                <CreateFacultyModal open={isModalOpenFaculty}
                    onOk={handleOkFaculty}
                    onCancel={handleCancelFaculty} />

                <EditMajorModal open={isEditMajorModalOpen}
                    onCancel={handleEditMajorModalCancel}
                    onOk={handleEditModalOk}
                    selectedMajor={selectedMajor}
                    faculties={dataFaculty}
                />

                <EditFacultyModal open={isEditFacultyModalOpen}
                    onCancel={handleEditFacultyModalCancel}
                    onOk={handleEditFacultyModalOk}
                    selectedFaculty={selectedFaculty}
                />

            </div>
        </div>
    );
};

export default MajorFaculty;
