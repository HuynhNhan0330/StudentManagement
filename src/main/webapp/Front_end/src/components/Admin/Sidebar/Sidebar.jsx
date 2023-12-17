import React from 'react';
import { NavLink } from 'react-router-dom';
import './Sidebar.scss';
import '@fortawesome/free-solid-svg-icons';
import SidebarSection from '../../Common/SidebarSection/SidebarSction';

const Sidebar = () => {
    const sections = [
        {
            label: 'Quản lý chung',
            items: [
                { to: '/', icon: 'fas fa-home', text: 'Home' },
                { to: '/major_faculty', icon: 'fas fa-school', text: 'Ngành - Khoa' },
                { to: '/class', icon: 'fas fa-house-user', text: 'Lớp' },
                { to: '/subject', icon: 'fas fa-shapes', text: 'Môn học' },
                { to: '/student', icon: 'fas fa-user-graduate', text: 'Học sinh' },
                { to: '/lecturer', icon: 'fas fa-user-tie', text: 'Giảng viên' },
            ],
        },
        {
            label: 'Khác',
            items: [{ to: '/login', icon: 'fas fa-arrow-right', text: 'Đăng xuất' }],
        },
    ];

    return (
        <nav className="navbar navbar-light navbar-vertical navbar-expand-xl">
            <div className="d-flex align-items-center">
                <NavLink to="/" className="navbar-brand">
                    <div className="d-flex align-items-center py-3">
                        <span className="font-sans-serif">ADMIN</span>
                    </div>
                </NavLink>
            </div>

            <div className="navbar-vertical-content scrollbar">
                <ul className="navbar-nav flex-column mb-3">
                    {sections.map((section, index) => (
                        <SidebarSection key={index} section={section} />
                    ))}
                </ul>
            </div>
        </nav>
    );
};

export default Sidebar;
