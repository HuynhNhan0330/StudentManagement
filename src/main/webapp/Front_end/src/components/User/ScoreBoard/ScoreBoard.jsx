import { Table, } from 'antd';
import React, { useState, useEffect } from 'react';

import './ScoreBoard.scss'
function ScoreBoard({ classListData }) {
    const [data, setData] = useState([]);

    useEffect(() => {
        setData(classListData);
    }, [classListData]);

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
            render: (text, record) => (record.quaTrinh * 0.2 + record.giuaKy * 0.3 + record.cuoiKy * 0.5).toFixed(2),
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