import React, { useState, useEffect } from 'react';
import ScheduleBoard from "../../../../components/User/ScheduleBoard/ScheduleBoard";
import './Schedule.scss'
import { handleGetScheduleByStudent } from '../../../../controller/ScheduleController';
import { DateOfWeek } from '../../../../utils/Helper';

//
let SemesterSchedule = ["HK2 - 2023/2024"]

function Schedule() {
  // Table:
  const [data, setData] = useState([]);
  const [user, setUser] = useState(JSON.parse(localStorage.getItem('account')));

  const fetchData = () => {
    setUser(JSON.parse(localStorage.getItem('account')));
    handleGetScheduleByStudent(user.maSV).then((results) => {
      if (results == null) {
        results = [];

        setData(results);
      } else {
        if (Array.isArray(results)) {
          const newResults = results.map((item) => {
            return {
              title: "",
              daysOfWeek: DateOfWeek[item.ngayHoc],
              startTime: item.thoiGianBatDau + ":00",
              endTime: item.thoiGianKetThuc + ":00",
              extendedProps: {
                classID: item.tenLop,
                dateStart: item.thoiGianBatDauMon,
                dateEnd: item.thoiGianKetThucMon
              }
            }
          })

          setData(newResults);
        }
      }


    });
  };

  useEffect(() => {
    fetchData();
  }, []);

  // end table

  return (
    <>
      <div className="MainScreenScheduleStudent">
        <ScheduleBoard Semester={SemesterSchedule} ScheduleEvents={data}></ScheduleBoard>
      </div>
    </>
  );


}

export default Schedule;