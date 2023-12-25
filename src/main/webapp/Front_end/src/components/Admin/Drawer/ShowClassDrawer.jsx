import React from 'react';
import { Drawer, Table } from 'antd';

function ShowClassDrawer({ selectedClass, onClose, open }) {
    return (
        <Drawer title="Thông tin môn lớp học" width={720} onClose={onClose} open={open}>
            {selectedClass && (
                <div>
                    <p>
                        <strong>Tên lớp:</strong> {selectedClass.name}
                    </p>
                    <p>
                        <strong>Giảng viên:</strong> {selectedClass.teacher}
                    </p>
                    <p>
                        <strong>Sĩ số:</strong> {selectedClass.size}
                    </p>
                    <Table
                        columns={[{ title: 'Danh sách học sinh', dataIndex: 'student', key: 'student' }]}
                        dataSource={selectedClass.students}
                        pagination={false}
                    />
                </div>
            )}
        </Drawer>
    );
}

export default ShowClassDrawer;
