
import UserInformation from '../../../components/User/Userinfor/Userinformation'


function UserInforPage() {

  
  const UserInformationItem =
  {
    Avatar: "https://cdn-icons-png.flaticon.com/512/3135/3135715.png",
    Full_name: 'Nguyen Van A',
    Phone_number: '0123456789',
    DateOfBirth: '01/01/2003',
    Gender: 'Male',
    Student_ID: '123456',
    //Email: 'student@gmail.com',
    Program: 'CLC',
    Faculty: 'SE',

  }

  return (
    <>
      <div className="mainUserInfor">
        <UserInformation
          Avatar={UserInformationItem.Avatar}
          Full_name={UserInformationItem.Full_name}
          Student_ID={UserInformationItem.Student_ID}
          DateOfBirth={UserInformationItem.DateOfBirth}
          Gender={UserInformationItem.Gender}
          Phone_number={UserInformationItem.Phone_number}
          Program={UserInformationItem.Program}
          Faculty={UserInformationItem.Faculty}
          
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