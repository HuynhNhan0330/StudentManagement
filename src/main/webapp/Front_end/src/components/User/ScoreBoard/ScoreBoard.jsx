import { Table, } from 'antd';
import React from 'react';
import './ScoreBoard.scss'
function ScoreBoard(props) {

    const columns = [
        {
            title: 'No.',
            dataIndex: 'No_',
            key: 'No_'
        },
        {
            title: 'Subject Id',
            dataIndex: 'subject_id',
            key: 'subject_id',
        },
        {
            title: 'Subject name',
            dataIndex: 'subject_name',
            key: 'subject_name',
        },
        {
            title: 'Progress score',
            dataIndex: 'progress_score',
            key: 'progress_score',
        },
        {
            title: 'Midterm score',
            dataIndex: 'midterm_score',
            key: 'midterm_score',
        },
        {
            title: 'Practice score',
            dataIndex: 'practice_score',
            key: 'practice_score',
        },
        {
            title: 'Finalterm score',
            dataIndex: 'finalterm_score',
            key: 'finalterm_score',
        },
        {
            title: 'Average score',
            dataIndex: 'average_score',
            key: 'average_score',
        },
        {
            title: 'Status',
            dataIndex: 'status',
            key: 'status',
        }
    ];
    const data = props.StudentScoreData;
    return (
        <div className='ScoreBoardContainer'>
            <Table
                columns={columns}

                dataSource={data}
            />
        </div>

    );
}
export default ScoreBoard;