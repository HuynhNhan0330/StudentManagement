import './ScheduleBoard.scss'
import ScheduleHeader from './ScheduleHeader';
import FullCalendar from '@fullcalendar/react'
//import dayGridPlugin from '@fullcalendar/daygrid'
import { useState, useEffect } from 'react';
import timeGridPlugin from '@fullcalendar/timegrid'
import Dropdown from 'react-bootstrap/Dropdown';

function renderEventContent(eventInfo) {
    return (
        <>
            <h style={{ fontSize: '13px' }}>Thời gian học: <br></br><b>{eventInfo.timeText}</b> </h>
            <br></br>
            <h style={{ fontSize: '13px' }}>Môn học:<br></br></h>
            <b style={{ fontSize: '18px' }}> {eventInfo.event.extendedProps.classID}</b>
            <br></br>
            <i>Ngày bắt đầu: {eventInfo.event.extendedProps.dateStart}</i><br></br>
            <i>Ngày kết thúc: {eventInfo.event.extendedProps.dateEnd}</i>
        </>
    )
}
function renderEventContentSmall(eventInfo) {
    return (
        <>
            <br></br>
            <b style={{ fontSize: '15px', writingMode: 'vertical-rl' ,textOrientation: 'upright' }}> {eventInfo.event.extendedProps.classID}</b>
            <br></br>
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


    //
    const [width, setWidth] = useState(window.innerWidth);

    useEffect(() => {
        const handleResize = () => {
            setWidth(window.innerWidth);
        };
    
        window.addEventListener('resize', handleResize);
    
        return () => {
            window.removeEventListener('resize', handleResize);
        };
        }, []);
    if(width < 600)
    {
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
                        {/*<ScheduleHeader></ScheduleHeader>*/}
                        <FullCalendar
                            plugins={[timeGridPlugin]}
                            initialView='timeGridWeek'
                            weekends={true}
                            events={events}
                            eventContent={renderEventContentSmall}
                            slotMinTime="6:00:00"
                            slotMaxTime="17:00:00"
                            hiddenDays={[0]}
                            headerToolbar={false}
                            //dayHeaders={false}
                            allDaySlot={false}
                            height={"auto"}
                            borderColor="black"
                            themeSystem="bootstrap"
                            eventColor='#2f88ff'
                        />
                    </div>
                </div>
            </div>
    )
    }
    else{
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
                        {/*<ScheduleHeader></ScheduleHeader>*/}
                        <FullCalendar
                            plugins={[timeGridPlugin]}
                            initialView='timeGridWeek'
                            weekends={true}
                            events={events}
                            eventContent={renderEventContent}
                            slotMinTime="6:00:00"
                            slotMaxTime="17:00:00"
                            hiddenDays={[0]}
                            headerToolbar={false}
                            //dayHeaders={false}
                            allDaySlot={false}
                            height={"auto"}
                            borderColor="black"
                            themeSystem="bootstrap"
                            eventColor='#2f88ff'
                        />
                    </div>
                </div>
            </div>
    )
}
}
export default ScheduleBoard;