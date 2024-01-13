import SidebarLecturer from "../SideBarLecturer/SideBar";
import LecturerHeader from "../HeaderLecturer/Header";
import './AppLayout.scss'
function LayoutLecturer({ children }) {
    return (
        <div id="children_cont" className="container-fluid">
            <SidebarLecturer />
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

export default LayoutLecturer;