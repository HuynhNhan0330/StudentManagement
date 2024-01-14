import React from 'react';
import './ScheduleBoard.scss'
function ScheduleHeader() {
    return (
        <thead>
            <tr>
                <th></th>
                <th className='monday'>Thứ 2</th>
                <th className='tuesday'>Thứ 3</th>
                <th className='wednesday'>Thứ 4</th>
                <th className='thursday'>Thứ 5</th>
                <th className='friday'>Thứ 6</th>
                <th className='saturday'>Thứ 7</th>
            </tr>
        </thead>
    );
}

export default ScheduleHeader;