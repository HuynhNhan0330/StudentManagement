import Home from '../pages/Admin/Home/Home';
import Student from '../pages/Admin/Student/Student';
import Lecturer from '../pages/Admin/Lecturer/Lecturer';
import Login from '../pages/Admin/Login/Login';
import Class from '../pages/Admin/Class/Class';
import MajorFaculty from '../pages/Admin/MajorFaculty/MajorFaculty';
import Subject from '../pages/Admin/Subject/Subject';
import DetailClass from '../pages/Admin/Class/DetailClass';

import Schedule from '../pages/User/Student/Schedule/Schedule';
import ScorePage from '../pages/User/Student/ScorePage/ScorePage';
import UserInforPage from '../pages/User/Student/User infor/UserInforPage'

import LecturerSchedule from '../pages/User/Lecturer/Schedule/Schedule';
import LecturerUserInforPage from '../pages/User/Lecturer/User infor/UserInforPage';
import ClassLecturer from '../pages/User/Lecturer/ScorePage/ClassLecturer';

const adminPaths= {
    home: '/admin',
    student: '/admin_student',
    lecturer: '/admin_lecturer',
    class: '/admin_class',
    subject: '/admin_subject',
    major_faculty: '/admin_major_faculty',
    detatailclass: '/admin_class/detail-class/:id'

}
const publicRoutes = [
    { path: adminPaths.home, component: Home },
    { path: adminPaths.student, component: Student },
    { path: adminPaths.lecturer, component: Lecturer },
    { path: adminPaths.class, component: Class },
    { path: adminPaths.subject, component: Subject },
    { path: adminPaths.major_faculty, component: MajorFaculty },
    {path: adminPaths.detatailclass, component: DetailClass}
];

const lecturerPaths={
    schedule: '/lecturer-schedule',
    user_infor: '/lecturer-info',
    score: '/lecturer-score',
    detatailclass: '/lecturer-score/detail-class/:id'
}

const lecturerRoutes = [
    { path: lecturerPaths.home, component: Home },
    { path: lecturerPaths.schedule, component: LecturerSchedule },
    { path: lecturerPaths.score, component: ClassLecturer },
    {path: lecturerPaths.user_infor, component: LecturerUserInforPage },
    {path: lecturerPaths.detatailclass, component: DetailClass}
];
const studentPaths =
{
    home: '/student-home',
    score: '/student-score',
    user_infor: '/student-info',
    schedule: '/student-schedule',
}

const studentRoutes = [
    { path: studentPaths.home, component: Home },
    { path: studentPaths.schedule, component: Schedule },
    { path: studentPaths.score, component: ScorePage },
    {path: studentPaths.user_infor, component: UserInforPage },
    
];

const privateRoutes = [
    { path: '/', component: Login, layout: null },
    // { path: '/register', component: Register, layout: null }
];

export { publicRoutes, privateRoutes ,studentRoutes,studentPaths, adminPaths,lecturerPaths,lecturerRoutes};
