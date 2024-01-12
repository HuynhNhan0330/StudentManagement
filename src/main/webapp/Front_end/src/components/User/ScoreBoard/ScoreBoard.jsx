import { Table, } from 'antd';
import React from 'react';
import './ScoreBoard.scss'
function ScoreBoard({ data }) {
    const columns = [
        {
            title: 'Mã môn học',
            dataIndex: 'maMH',
        },
        {
            title: 'Tên môn học',
            dataIndex: 'tenMH',
        },
        {
            title: 'Quá trình',
            dataIndex: 'quaTrinh',
        },
        {
            title: 'Giữa kỳ',
            dataIndex: 'giuaKy',
        },
        {
            title: 'Cuối kỳ',
            dataIndex: 'cuoiKy',
        },
        {
            title: 'Tổng kết',
            render: (text, record) => (record.quaTrinh * 0.2 + record.giuaKy * 0.3 + record.cuoiKy * 0.5),
        },
    ];
    
    return (
        <div className='ScoreBoardContainer'>
            <Table
                columns={columns}
                pagination={{
                    position: ['none', 'none'],
                  }}
                dataSource={data}
            />
        </div>

    );
}
export default ScoreBoard;