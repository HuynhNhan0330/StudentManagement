import SidebarLecturer from "../SideBarLecturer/SideBar";
import LecturerHeader from "../HeaderLecturer/Header";
import './AppLayout.scss'
import { useState, useEffect } from "react";
import LecturerNavHeader from "../Lecturer/Navheader/Navheader";
function LayoutLecturer({ children }) {
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
            <div id="children_cont" className="container-fluid">
                <div className="LecturerSibarDisplay">
                    <SidebarLecturer />
                </div>
                
                <div className="content">
                    <LecturerHeader />
                    <div >
                        <div className="background_">

                            {children}

                        </div>
                    </div>
                </div>
            </div>
        );
    }
    else{
        return (
            <div id="children_cont" className="container-fluid">
                <div className="LecturerSibarDisplay" hidden>
                    <SidebarLecturer />
                </div>
                
                <div className="content">
                    <LecturerNavHeader />
                    <div >
                        <div className="background_">

                            {children}

                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default LayoutLecturer;