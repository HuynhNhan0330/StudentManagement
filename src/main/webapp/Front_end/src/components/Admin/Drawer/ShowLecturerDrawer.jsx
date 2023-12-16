import React from 'react';
import { Drawer } from 'antd';

function ShowlecturerDrawer({ open, onClose, selectedStudent }) {
    return (
        <Drawer title="Lecturer Details" width={720} placement="right" onClose={() => onClose(false)} open={open}>
            {selectedStudent && (
                <div>
                    <p>
                        <strong>MSSV:</strong> {selectedStudent.mssv}
                    </p>
                    <p>
                        <strong>Name:</strong> {selectedStudent.name}
                    </p>
                </div>
            )}
        </Drawer>
    );
}

export default ShowlecturerDrawer;
