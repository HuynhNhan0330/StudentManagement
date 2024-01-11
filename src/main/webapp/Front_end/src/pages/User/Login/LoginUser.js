import './Login.css'

import { studentPaths } from '../../../routes/AppRoutes'
import { Button, Input, notification } from 'antd';
import { useEffect, useState } from 'react';
import 'boxicons/css/boxicons.min.css';



function LoginUser() {
    const [currentpath, setCurrentpath] = useState(window.location.pathname);
    useEffect(() => {
        setCurrentpath(window.location.pathname);
    }, [currentpath])
    const LoginTitle = currentpath === studentPaths.lecutrerLogin ? 'Login lecturer' : 'Login student';



    const forgotPassword = () => {
        notification.open({
            icon: <i class='bx bxs-badge-check' style={{ color: '#2f88ff' }}  ></i>,
            message: 'Success',
            description:
                'Your password had been sent to your mail! ',
            duration: 0,
        });
    };


    return (
        <>
            <div className='leftBlue'></div>
            <div className='container'>
                <div className="mainLoginForm">
                    <div className='LoginPage'>{LoginTitle}</div>
                    <div className='LoginPlace'>
                        <Input 
                            id='userid' className='StudentId' placeholder='Enter your user name'></Input>
                        <Input.Password 
                            id='password' className='Password' placeholder='Enter your password'></Input.Password>
                        {/*<div className='showpassword'>
                            <label >Forgot your password?</label>
                            <Button type='link' onClick={forgotPassword}>Click here?</Button>
        </div>*/}
                        <button className='LoginButton' >Login</button>

                    </div>


                </div>
            </div>
            </>
    )
}
export default LoginUser;