import { studentPaths } from '../../../routes/AppRoutes';
import { Link } from 'react-router-dom';
import './Header.css'
import 'boxicons/css/boxicons.min.css';
import { Button } from 'antd';
function Header() {

    return <div className='header'>
        <div className='logo'>
            <i class='bx bxs-graduation' style={{ color: '#2f88ff' }}>
                <span className='uniName'>University</span>
            </i>
        </div>
        <div className='UserandNavigation'>
            <Link to={studentPaths.user_infor} >
                <i class='bx bxs-user-circle' style={{ color: '#2f88ff' }}  ></i>
            </Link>

        </div>


    </div >

}
export default Header;