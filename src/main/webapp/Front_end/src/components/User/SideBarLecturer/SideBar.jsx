import { useEffect, useRef, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import './SideBar.scss';
import 'boxicons/css/boxicons.min.css';
import { lecturerPaths } from '../../../routes/AppRoutes';
const sidebarNavItems = [
    {
        display: 'Lịch',
        icon: <i className='bx bx-calendar'></i>,
        to: lecturerPaths.schedule,
        section: 'lecturer-schedule'
    },
    {
        display: 'Nhập điểm',
        icon: <i class='bx bx-clipboard'></i>,// <i class='bx bx-math'></i>
        to: lecturerPaths.score,
        section: 'lecturer-score'
    },
    {
        display: 'Người dùng',
        icon: <i className='bx bx-user'></i>,
        to: lecturerPaths.user_infor,
        section: 'lecturer-info'
    },
    {
        display:  <div style={{color: 'red'}}>Đăng xuất</div>,
        icon: <i class='bx bx-exit' style={{color: 'red'}}></i>,
        to: '/',
        section: 'admin_subject'
    },
]

const SidebarLecturer = () => {
    const [activeIndex, setActiveIndex] = useState(0);
    const [stepHeight, setStepHeight] = useState(0);
    const sidebarRef = useRef();
    const indicatorRef = useRef();
    const location = useLocation();

    useEffect(() => {
        setTimeout(() => {
            const sidebarItem = sidebarRef.current.querySelector('.sidebar_user__menu__item');
            indicatorRef.current.style.height = `${sidebarItem.clientHeight}px`;
            setStepHeight(sidebarItem.clientHeight);
        }, 60);
    }, []);

    // change active index
    useEffect(() => {
        const curPath = window.location.pathname.split('/')[1];
        const activeItem = sidebarNavItems.findIndex(item => item.section === curPath);
        setActiveIndex(curPath.length === 0 ? 0 : activeItem);
    }, [location]);

    return <nav className="navbar navbar-light navbar-vertical navbar-expand-xl">
        <div className='sidebar_user'>
            <div className="sidebar_user__logo_lecturer">

            </div>
            <div ref={sidebarRef} className="sidebar_user__menu">
                <div
                    ref={indicatorRef}
                    className="sidebar_user__menu__indicator"
                    style={{
                        transform: `translateX(-50%) translateY(${activeIndex * stepHeight}px)`
                    }}
                ></div>
                {
                    sidebarNavItems.map((item, index) => (
                        <Link to={item.to} key={index} style={{ textDecoration: 'none' }}>
                            <div className={`sidebar_user__menu__item ${activeIndex === index ? 'active' : ''}`}>
                                <div className="sidebar_user__menu__item__icon">
                                    {item.icon}
                                </div>
                                <div className="sidebar_user__menu__item__text">
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

export default SidebarLecturer;