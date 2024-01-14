import { useEffect, useRef, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './Sidebar.scss';
import 'boxicons/css/boxicons.min.css';
import { adminPaths } from '../../../routes/AppRoutes';
const sidebarNavItems = [
    // {
    //     display: 'Trang chủ',
    //     icon: <i className='bx bx-home'></i>,
    //     to: adminPaths.home,
    //     section: 'admin'
    // },
    {
        display: 'Ngành khoa',
        icon: <FontAwesomeIcon icon="fa-solid fa-school" />,
        to: adminPaths.major_faculty,
        section: 'admin_major_faculty'
    },
    {
        display: 'Sinh viên',
        icon: <i className='bx bx-user'></i>,
        to: adminPaths.student,
        section: 'admin_student'
    },
    {
        display: 'Giảng viên',
        icon: <i class='bx bx-group'></i>,
        to: adminPaths.lecturer,
        section: 'admin_lecturer'
    },
    {
        display: 'Lớp',
        icon: <i class='bx bx-door-open'></i>,
        to: adminPaths.class,
        section: 'admin_class'
    },
    {
        display: 'Môn học',
        icon: <i className='bx bx-book'></i>,
        to: adminPaths.subject,
        section: 'admin_subject'
    },
    {
        display: <div style={{color: 'red'}}>Đăng xuất</div>,
        icon: <i class='bx bx-exit' style={{color: 'red'}}></i>,
        to: '/',
        section: 'admin_subject'
    },
    
]

const Sidebar = () => {
    const [activeIndex, setActiveIndex] = useState(0);
    const [stepHeight, setStepHeight] = useState(0);
    const sidebarRef = useRef();
    const indicatorRef = useRef();
    const location = useLocation();

    useEffect(() => {
        setTimeout(() => {
            const sidebarItem = sidebarRef.current.querySelector('.sidebar__menu__item');
            indicatorRef.current.style.height = `70px`; //${sidebarItem.clientHeight}px
            setStepHeight(sidebarItem.clientHeight);
        }, 50);
    }, []);

    // change active index
    useEffect(() => {
        const curPath = window.location.pathname.split('/')[1];
        const activeItem = sidebarNavItems.findIndex(item => item.section === curPath);
        setActiveIndex(curPath.length === 0 ? 0 : activeItem);
    }, [location]);

    return <nav className="navbar navbar-light navbar-vertical navbar-expand-xl">
        <div className='sidebar'>
            <div className="sidebar__logo">
                <img src='./LogoUni.png' alt='AdminLogo' width="50" height="50"/>
            
            </div>
            <div ref={sidebarRef} className="sidebar__menu">
                <div
                    ref={indicatorRef}
                    className="sidebar__menu__indicator"
                    style={{
                        transform: `translateX(-50%) translateY(${activeIndex * stepHeight}px)`
                    }}
                ></div>
                {
                    sidebarNavItems.map((item, index) => (
                        <Link to={item.to} key={index} style={{ textDecoration: 'none' }}>
                            <div className={`sidebar__menu__item ${activeIndex === index ? 'active' : ''}`}>
                                <div className="sidebar__menu__item__icon">
                                    {item.icon}
                                </div>
                                <div className="sidebar__menu__item__text">
                                    {item.display}
                                </div>
                            </div>
                        </Link>
                    ))
                }
            </div>
        </div>
    </nav>;
};

export default Sidebar;