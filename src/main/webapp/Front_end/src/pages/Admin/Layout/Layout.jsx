import React from 'react';
import Header from '../../../components/Admin/Header/Header';
import Sidebar from '../../../components/Admin/Sidebar/Sidebar';
import { ConfigProvider } from 'antd';
import { useState, useEffect } from 'react';
import './Layout.scss'
import NavheaderAdmin from '../../../components/Admin/Navheader/Navheader';
function Layout({ children }) {
    const [width, setWidth] = useState(window.innerWidth);

    useEffect(() => {
        const handleResize = () => {
            setWidth(window.innerWidth);
        };
    
        window.addEventListener('resize', handleResize);
    
        return () => {
            window.removeEventListener('resize', handleResize);
        };
        }, []);
    console.log(width);
    if (width >= 1200)
    {
        return (
            <div className="container-fluid">
                <div><Sidebar/></div>
                <div className="content">
                    <Header />
                    <div>
                        <div>
                            <ConfigProvider
                                theme={{
                                    components: {
                                        Table: {
                                            fontSize: '18px',
                                        },
                                    },
                                }}
                            >
                                {children}
                                
                            </ConfigProvider>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }
    else{
        return (
            <div className="container-fluid">
                <div hidden><Sidebar/></div>
                <div className="content">
                    <NavheaderAdmin />
                    <div>
                        <div>
                            <ConfigProvider
                                theme={{
                                    components: {
                                        Table: {
                                            fontSize: '18px',
                                        },
                                    },
                                }}
                            >
                                {children}
                                
                            </ConfigProvider>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }
    
}

export default Layout;
