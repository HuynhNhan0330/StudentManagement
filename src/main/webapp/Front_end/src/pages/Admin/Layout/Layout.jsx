import React from 'react';
import Header from '../../../components/Admin/Header/Header';
import Sidebar from '../../../components/Admin/Sidebar/Sidebar';
import { ConfigProvider } from 'antd';

function Layout({ children }) {
    return (
        <div className="container-fluid">
            <Sidebar />
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

export default Layout;
