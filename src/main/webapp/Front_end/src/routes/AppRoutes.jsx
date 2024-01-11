import Home from '../pages/Admin/Home/Home';
import Student from '../pages/Admin/Student/Student';
import Lecturer from '../pages/Admin/Lecturer/Lecturer';

import Class from '../pages/Admin/Class/Class';
import MajorFaculty from '../pages/Admin/MajorFaculty/MajorFaculty';
import Subject from '../pages/Admin/Subject/Subject';
import DetailClass from '../pages/Admin/Class/DetailClass';

import Schedule from '../pages/User/Schedule/Schedule';
import ScorePage from '../pages/User/ScorePage/ScorePage';
import UserInforPage from '../pages/User/User infor/UserInforPage'
import LoginUser from '../pages/User/Login/LoginUser'
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
    { path: '/login', component: LoginUser, layout: null },
    // { path: '/register', component: Register, layout: null }
];

export { publicRoutes, privateRoutes ,studentRoutes,studentPaths, adminPaths};
