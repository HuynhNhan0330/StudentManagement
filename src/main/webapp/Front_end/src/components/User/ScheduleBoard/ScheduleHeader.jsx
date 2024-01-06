import React from 'react';
import './ScheduleBoard.scss'
function ScheduleHeader() {
    return (
        <thead>
            <tr>
                <th>Period</th>
                <th className='monday'>Monday</th>
                <th className='tuesday'>Tuesday</th>
                <th className='wednesday'>Wednesday</th>
                <th className='thursday'>Thursday</th>
                <th className='friday'>Friday</th>
                <th className='saturday'>Saturday</th>
            </tr>
        </thead>
    );
}

export default ScheduleHeader;