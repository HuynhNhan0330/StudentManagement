import SidebarUser from "../SideBar/SideBar";
import Header from "../Header/Header";
import Navheader from "../Student/Navheader/Navheader";
import './AppLayout.scss'
import { useState , useEffect} from "react";
function AppLayout({ children }) {

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
            <div id="children_cont" className="container-fluid" >
                
                <div className='StudentSibarDisplay'>
                    <SidebarUser />
                </div>
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
    else{
        return (
            <div id="children_cont" className="container-fluid" >
                
                <div className='StudentSibarDisplay' hidden>
                    <SidebarUser />
                </div>
                <div className="content">
                    <Navheader />
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

export default AppLayout;