import React from 'react';
import { Card, Button, Input } from 'antd';
import MajorTable from '../../../components/Admin/Table/MajorTable';
import FacultyTable from '../../../components/Admin/Table/FacultyTable';

function MajorFaculty() {
    return (
        <div style={{ display: 'flex', gap: '16px' }}>
            <Card title="Major" style={{ flex: 1, width: '50%' }}>
                <div style={{ display: 'flex', gap: '8px' }}>
                    <div>
                        <label>Name: </label>
                        <Input style={{ width: '150px', marginRight: '8px' }} />
                        <Button type="primary">Create</Button>
                    </div>
                </div>
                <MajorTable />
            </Card>

            <Card title="Faculty" style={{ flex: 1, width: '50%' }}>
                <div style={{ marginTop: '8px' }}>
                    <label>Name: </label>
                    <Input style={{ width: '120px', marginRight: '8px' }} />
                    <label>Description: </label>
                    <Input style={{ width: '240px', marginRight: '8px' }} />
                    <Button type="primary">Create</Button>
                </div>
                <FacultyTable />
            </Card>
        </div>
    );
}

export default MajorFaculty;
