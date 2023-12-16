import React from 'react';
import './Header.scss';

const Header = () => {
    return (
        <nav className="navbar navbar-light navbar-glass navbar-top navbar-expand">
            <ul className="navbar-nav align-items-center d-none d-lg-block">{/*<SearchBox />*/}</ul>
        </nav>
    );
};

export default Header;
