import ScheduleBoard from "../../../../components/User/ScheduleBoard/ScheduleBoard";
import './Schedule.scss'

//
let SemesterSchedule = ["Semester 1 (2023-2024)", "Semester 2 (2023-2024)", "Semester summer (2023-2024)"]

function Schedule() {

  
  const events = [
    {
      title: '',// để title như tên lớp
      daysOfWeek: '4',
      startTime: '8:00:00',
      endTime: '10:00:00',
      extendedProps: {
        classID: 'OOP1',
        dateStart: '20/11/2023',
        dateEnd: '20/12/2023'
      },
    },
    {
      title: ' ',// để title như tên lớp
      daysOfWeek: ['5'],
      startTime: '8:00:00',
      endTime: '10:00:00',
      extendedProps: {
        classID: 'OOP1',
        dateStart: '20/11/2023',
        dateEnd: '20/12/2023'
      },
    }
  ]
  return (
      <>
        <div className="MainScreenSchedule">
          <ScheduleBoard Semester={SemesterSchedule} ScheduleEvents={events}></ScheduleBoard>
        </div>
      </>
    );
  

}

export default Schedule;