import React from 'react';
import './Header.scss';
import { Link } from 'react-router-dom';
import { useEffect } from 'react';
import { message } from 'antd';
const Header = () => {
    const currentpath = window.location.href;
    useEffect(() => {
        //message.info(`You now on item ${currentpath}`);
    }, [currentpath])
    return (
        <div className='header_'>
        </div>
    );
};

export default Header;
