import SidebarUser from "../SideBar/SideBar";
import Header from "../Header/Header";
import './AppLayout.scss'
function AppLayout({ children }) {
    return (
        <div id="children_cont" className="container-fluid">
            <SidebarUser />
            <div className="content">
                <Header />
                <div >
                    <div className="background_">

                        {children}

                    </div>
                </div>
            </div>
        </div>
    );
}

export default AppLayout;