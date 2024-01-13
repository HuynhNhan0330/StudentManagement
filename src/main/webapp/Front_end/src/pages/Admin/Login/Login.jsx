import React from 'react';
import { Form, Input, Button, Card, notification } from 'antd';
import { useNavigate  } from 'react-router-dom';

import './Login.scss';
import { handleLogin } from '../../../controller/LoginController';

const Login = () => {
    const navigate = useNavigate();

    const onFinish = (values) => {
        handleLogin(values).then((resp) => {
            const account = resp.data;

            if (account != null) {
                localStorage.setItem('account', JSON.stringify(account));

                switch (account.role) {
                    case "1":
                        // Chuyển trang admin
                        navigate('/admin');
                        break;
    
                    case "2":
                        // Chuyển trang giáo viên
                        break;
    
                    case "3":
                        // Chuyển trang sinh viên
                        navigate('/student-schedule');
                        break;
                }
            }
            else {
                console.log('Tài khoản hoặc mật khẩu không chính xác');
                notification.open({
                    icon: <i class='bx bxs-error-alt' style={{color:'#ff0105'}} ></i>,
                    message: 'Đăng nhập thất bại',
                    description:
                        'Tài khoản hoặc mật khẩu không chính xác',
                    duration: 0,
                    placement:'topLeft',
                });
            }
        });
    }

    const backgroundImage =
        'url("https://png.pngtree.com/thumb_back/fh260/background/20200809/pngtree-doodles-on-green-chalkboard-background-back-to-school-background-image_389839.jpg")';

    return (
        <div className="login-container" style={{ backgroundImage }}>
            <div className='loginRightPlacement'>
                <Card  className="login-card">
                    <span style={{color: 'black', fontWeight:'bold', fontSize:'35px'}}>Đăng nhập</span>
                    <hr style={{color: '#00C2FF'}}></hr>
                    <Form name="login-form"
                        onFinish={onFinish}
                    >
                        <label>Tài khoản:</label>
                        <Form.Item
                            name="username"
                            rules={[{ required: true, message: 'Vui lòng nhập tài khoản của bạn!' }]}
                        >
                        <Input style={{height: '45px'}}/>
                        </Form.Item>
                        <label>Mật khẩu:</label>
                        <Form.Item
                            name="password"
                            rules={[{ required: true, message: 'Vui lòng nhập mật khẩu của bạn' }]}
                        >
                        <Input.Password style={{height: '45px'}}    />
                        </Form.Item>

                        <Form.Item >
                            <Button className='LoginButtonMain' type="primary" htmlType="submit" >
                                Đăng nhập
                            </Button>
                        </Form.Item>
                    </Form>
                </Card>
            </div>
        </div>
    );
};

export default Login;
