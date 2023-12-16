import React from 'react';
import { NavLink } from 'react-router-dom';

const NavItem = ({ item }) => (
    <NavLink to={item.to} className="nav-link" role="button">
        <div className="d-flex align-items-center">
            <span className="nav-link-icon">
                <span className={item.icon}></span>
            </span>
            <span className="nav-link-text ps-1">{item.text}</span>
        </div>
    </NavLink>
);

export default NavItem;
