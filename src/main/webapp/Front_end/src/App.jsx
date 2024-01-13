import Layout from './pages/Admin/Layout/Layout';
import AppLayout from './components/User/Layout/AppLayout' 
import LayoutLecturer from './components/User/LayoutLecturer/AppLayout';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { privateRoutes, publicRoutes, studentRoutes, lecturerRoutes } from './routes/AppRoutes';
import { Fragment } from 'react';
function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    {publicRoutes.map((route, index) => {
                        const Page = route.component;
                        let _Layout = Layout;
                        if (route.layout) {
                            _Layout = route.layout;
                        } else if (route.layout === null) {
                            _Layout = Fragment;
                        }
                        return (
                            <Route
                                key={index}
                                path={route.path}
                                element={
                                    <_Layout>
                                        <Page />
                                    </_Layout>
                                }
                            />
                        );
                    })}
                    {studentRoutes.map((route, index) => {
                        const Page = route.component;
                        let _Layout = AppLayout;
                        if (route.layout) {
                            _Layout = route.layout;
                        } else if (route.layout === null) {
                            _Layout = Fragment;
                        }
                        return (
                            <Route
                                key={index}
                                path={route.path}
                                element={
                                    <_Layout>
                                        <Page />
                                    </_Layout>
                                }
                            />
                        );
                    })}
                    {lecturerRoutes.map((route, index) => {
                        const Page = route.component;
                        let _Layout = LayoutLecturer;
                        if (route.layout) {
                            _Layout = route.layout;
                        } else if (route.layout === null) {
                            _Layout = Fragment;
                        }
                        return (
                            <Route
                                key={index}
                                path={route.path}
                                element={
                                    <_Layout>
                                        <Page />
                                    </_Layout>
                                }
                            />
                        );
                    })}
                    {privateRoutes.map((route, index) => {
                        const Page = route.component;
                        return <Route key={index} path={route.path} element={<Page />} />;
                    })}
                </Routes>
            </div>
        </Router>
    );
}

export default App;
