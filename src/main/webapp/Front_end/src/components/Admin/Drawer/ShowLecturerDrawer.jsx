import React from 'react';
import { Drawer } from 'antd';

function ShowlecturerDrawer({ open, onClose, selectedStudent }) {
    return (
        <Drawer title="Lecturer Details" width={720} placement="right" onClose={() => onClose(false)} open={open}>
            {selectedStudent && (
                <div>
                    <p>
                        <strong>MSGV:</strong> {selectedStudent.mssv}
                    </p>
                    <p>
                        <strong>Tên:</strong> {selectedStudent.name}
                    </p>
                </div>
            )}
        </Drawer>
    );
}

export default ShowlecturerDrawer;
