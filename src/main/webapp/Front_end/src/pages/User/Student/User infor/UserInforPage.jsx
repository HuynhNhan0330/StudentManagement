import React, { useState, useEffect } from 'react';
import UserInformation from '../../../../components/User/Userinfor/Userinformation'

import './UserInforPage.css'
function UserInforPage() {
  // Data:
  const [user, setUser] = useState(JSON.parse(localStorage.getItem('account')));

  const fetchData = () => {
    setUser(JSON.parse(localStorage.getItem('account')));
  };

  useEffect(() => {
    fetchData();
  }, []);

  // end 
  return (
    <>
      <div className="mainUserInfor">
        <UserInformation
          isStudent={true}
          maSV={user.maSV}
          tenTK={user.tenTK}
          gioiTinh={user.gioiTinh}
          ngaySinh={user.ngaySinh}
          phone={user.phone}
          email={user.email}
          tenNganh={user.tenNganh}
        />
      </div>
    </>
  );
}

export default UserInforPage;


// [
//   {
//     key: 1,
//     No_: 'Semester 1(2023- 2024)',
//     children: childrenScore,
//   },
//   {
//     key: 5,
//     No_: 'Semester 1(2023- 2024)',
//     children: [
//       {
//         key: 6,
//         No_: '1',
//         subject_id: 'OOP.1',
//         subject_name: 'OOP',
//         progress_score: 10,
//         midterm_score: 10,
//         practice_score: 10,
//         finalterm_score: 10,
//         average_score: 10
//       },
//       {
//         key: 7,
//         No_: '2',
//         subject_id: 'OOP.1',
//         subject_name: 'OOP',
//         progress_score: 10,
//         midterm_score: 10,
//         practice_score: 10,
//         finalterm_score: 10,
//         average_score: 10
//       },
//       {
//         key: 8,
//         No_: '3',
//         subject_id: 'OOP.1',
//         subject_name: 'OOP',
//         progress_score: 10,
//         midterm_score: 10,
//         practice_score: 10,
//         finalterm_score: 10,
//         average_score: 10
//       }
//     ]
//   },
//   {
//     key: 10,
//     No_: 'Semester 1(2023- 2024)',
//     children: [

//     ]
//   }
// ]