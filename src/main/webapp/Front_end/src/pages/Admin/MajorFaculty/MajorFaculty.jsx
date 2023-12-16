import React, { useState } from 'react';
import { Card, Button } from 'antd';
import MajorTable from '../../../components/Admin/Table/MajorTable';
import FacultyTable from '../../../components/Admin/Table/FacultyTable';
import CreateMajorModal from '../../../components/Admin/Modal/CreateMajorModal';
import CreateFacultyModal from '../../../components/Admin/Modal/CreateFacultyModal';
const MajorFaculty = () => {
    const [isModalOpenMajor, setIsModalOpenMajor] = useState(false);

    const showModalMajor = () => {
        setIsModalOpenMajor(true);
    };

    const handleCancelMajor = () => {
        setIsModalOpenMajor(false);
    };

    const handleOkMajor = () => {
        setIsModalOpenMajor(false);
    };

    const [isModalOpenFaculty, setIsModalOpenFaculty] = useState(false);
    const showModalFaculty = () => {
        setIsModalOpenFaculty(true);
    };

    const handleCancelFaculty = () => {
        setIsModalOpenFaculty(false);
    };

    const handleOkFaculty = () => {
        setIsModalOpenFaculty(false);
    };

    return (
        <div style={{ display: 'flex', gap: '16px' }}>
            <Card title="Major" style={{ flex: 1, width: '50%' }}>
                <div style={{ display: 'flex', gap: '8px' }}>
                    <div>
                        <Button type="primary" onClick={showModalMajor}>
                            Create
                        </Button>
                    </div>
                </div>
                <MajorTable />
            </Card>
            <CreateMajorModal open={isModalOpenMajor} onOk={handleOkMajor} onCancel={handleCancelMajor} />

            <Card title="Faculty" style={{ flex: 1, width: '50%' }}>
                <div style={{ marginTop: '8px' }}>
                    <Button type="primary" onClick={showModalFaculty}>
                        Create
                    </Button>
                </div>
                <FacultyTable />
            </Card>
            <CreateFacultyModal open={isModalOpenFaculty} onOk={handleOkFaculty} onCancel={handleCancelFaculty} />
        </div>
    );
};

export default MajorFaculty;
