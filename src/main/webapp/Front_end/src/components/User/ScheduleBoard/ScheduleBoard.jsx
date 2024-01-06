import './ScheduleBoard.scss'
import ScheduleHeader from './ScheduleHeader';
import FullCalendar from '@fullcalendar/react'
//import dayGridPlugin from '@fullcalendar/daygrid'
import { useState } from 'react';
import timeGridPlugin from '@fullcalendar/timegrid'
import Dropdown from 'react-bootstrap/Dropdown';





function renderEventContent(eventInfo) {
    return (
        <>
            <b style={{ fontSize: '15px' }}>{eventInfo.timeText}</b>
            <br></br>
            <h style={{ fontSize: '18px' }}>{eventInfo.event.extendedProps.classID}</h>
            <br></br>
            <i>{eventInfo.event.extendedProps.dateStart} - {eventInfo.event.extendedProps.dateEnd}</i>
        </>
    )
}
function ScheduleBoard(props) {
    const events = props.ScheduleEvents;

    let mySemester = "";
    console.log(!(props.Semester === undefined || props.Semester === null || props.Semester?.length === 0))
    if (!(props.Semester === undefined || props.Semester === null || props.Semester?.length === 0))
        mySemester = props.Semester[0];

    const [selectedSemester, setSelectedSemester] = useState(mySemester);

    const handleSelect = (eventKey) => {
        setSelectedSemester(eventKey);
    };

    

    return (
        <div className='MainContainErSchedule'>
            <div className='dropSemester_1'>

                <Dropdown id='dropSemester_1' onSelect={handleSelect}>

                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        {selectedSemester}
                    </Dropdown.Toggle>
                    <Dropdown.Menu >
                        {props.Semester.map((item =>
                            (<Dropdown.Item eventKey={item}>{item}</Dropdown.Item>)
                        ))}
                    </Dropdown.Menu>
                </Dropdown>

            </div>
            <div className='ScheduleBoardM'>
                <div>
                    <ScheduleHeader></ScheduleHeader>
                    <FullCalendar
                        plugins={[timeGridPlugin]}
                        initialView='timeGridWeek'
                        weekends={true}
                        events={events}
                        eventContent={renderEventContent}
                        slotMinTime="6:00:00"
                        slotMaxTime="18:00:00"
                        hiddenDays={[0]}
                        headerToolbar={false}
                        dayHeaders={false}
                        allDaySlot={false}
                        height={"auto"}
                    />
                </div>
            </div>

        </div>
    )
}
export default ScheduleBoard;