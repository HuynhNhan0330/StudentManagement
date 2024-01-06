import Home from '../pages/Admin/Home/Home';
import Student from '../pages/Admin/Student/Student';
import Lecturer from '../pages/Admin/Lecturer/Lecturer';
import Login from '../pages/Admin/Login/Login';
import Class from '../pages/Admin/Class/Class';
import MajorFaculty from '../pages/Admin/MajorFaculty/MajorFaculty';
import Subject from '../pages/Admin/Subject/Subject';

import Schedule from '../pages/User/Schedule/Schedule';
import ScorePage from '../pages/User/ScorePage/ScorePage';
const publicRoutes = [
    { path: '/', component: Home },
    { path: '/student', component: Student },
    { path: '/lecturer', component: Lecturer },
    { path: '/class', component: Class },
    { path: '/subject', component: Subject },
    { path: '/major_faculty', component: MajorFaculty },
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

    
];

const privateRoutes = [
    { path: '/login', component: Login, layout: null },
    // { path: '/register', component: Register, layout: null }
];

export { publicRoutes, privateRoutes ,studentRoutes,studentPaths};
