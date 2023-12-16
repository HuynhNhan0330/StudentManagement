import React from 'react';
import { Drawer, Table } from 'antd';

function ShowClassDrawer({ selectedClass, onClose, open }) {
    return (
        <Drawer title="Thông tin môn lớp học" width={720} onClose={onClose} open={open}>
            {selectedClass && (
                <div>
                    <p>
                        <strong>Name:</strong> {selectedClass.name}
                    </p>
                    <p>
                        <strong>Teacher:</strong> {selectedClass.teacher}
                    </p>
                    <p>
                        <strong>Size:</strong> {selectedClass.size}
                    </p>
                    <Table
                        columns={[{ title: 'List Student', dataIndex: 'student', key: 'student' }]}
                        dataSource={selectedClass.students}
                        pagination={false}
                    />
                </div>
            )}
        </Drawer>
    );
}

export default ShowClassDrawer;
