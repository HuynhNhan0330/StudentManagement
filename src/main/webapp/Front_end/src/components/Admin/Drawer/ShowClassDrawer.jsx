import React from 'react';
import { Button, Drawer, Flex, Table } from 'antd';
import InputScore from '../InputScore/InputScore';

function ShowClassDrawer({ selectedClass, onClose, open }) {
    const columns = [{
        title: 'STT',
        dataIndex: 'stt',
        key: 'stt',
    },

    {
        title: 'Mssv',
        dataIndex: 'mssv',
        key: 'mssv',
    },
    {
        title: 'Tên',
        dataIndex: 'name',
        key: 'name',
    },
    {
        title: 'Ngày Sinh',
        dataIndex: 'ngaySinh',
        key: 'ngaySinh',
    }, ];
    return (
        <Drawer title="Thông tin môn lớp học" width={800} onClose={onClose} open={open}>
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
                    {/*<Table
                        columns={columns}
                        dataSource={[]}
                        pagination={true}
            />
            */}
                    <InputScore></InputScore>
                       
                </div>
            )}
        </Drawer>
    );
}

export default ShowClassDrawer;
