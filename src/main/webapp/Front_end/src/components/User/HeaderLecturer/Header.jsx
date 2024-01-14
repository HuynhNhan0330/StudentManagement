import { lecturerPaths } from '../../../routes/AppRoutes';
import { Link } from 'react-router-dom';
import './Header.css'
import 'boxicons/css/boxicons.min.css';
import { Button } from 'antd';
function LecturerHeader() {

    return <div className='header_lecter'>
        <div className='logo_lecter'>
            <img src='./LogoUni.png' alt="Lecturer" width="50" height="50"/>
        </div>
        <div className='UserandNavigation_lecter'>
            <Link to={lecturerPaths.user_infor} >
                <i class='bx bxs-user-circle' style={{ color: '#2f88ff' }}  ></i>
            </Link>

        </div>


    </div >

}
export default LecturerHeader;