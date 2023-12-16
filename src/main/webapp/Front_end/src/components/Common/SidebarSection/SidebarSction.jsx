import React from 'react';
import NavItem from '../NavItem/NavItem';

const SidebarSection = ({ section }) => (
    <li className="nav-item">
        <div className="row navbar-vertical-label-wrapper mt-3 mb-2">
            <div className="col-auto navbar-vertical-label">{section.label}</div>
            <div className="col ps-0">
                <hr className="mb-0 navbar-vertical-divider" />
            </div>
        </div>
        {section.items.map((item, index) => (
            <NavItem key={index} item={item} />
        ))}
    </li>
);

export default SidebarSection;
