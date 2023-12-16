import React from 'react';
import { Drawer } from 'antd';

function ShowStudentDrawer({ open, onClose, selectedStudent }) {
    return (
        <Drawer title="Student Details" width={720} placement="right" onClose={() => onClose(false)} open={open}>
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

export default ShowStudentDrawer;
