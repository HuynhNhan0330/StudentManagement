import React from 'react';
import { Form, Input, Button, Card } from 'antd';
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
                        navigate('/student-home');
                        break;
                }
            }
            else {
                console.log('Tài khoản hoặc mật khẩu không chính xác')
            }
        });
    }

    const backgroundImage =
        'url("https://png.pngtree.com/thumb_back/fh260/background/20200809/pngtree-doodles-on-green-chalkboard-background-back-to-school-background-image_389839.jpg")';

    return (
        <div className="login-container" style={{ backgroundImage }}>
            <Card title="Login" className="login-card">
                <Form name="login-form"
                    onFinish={onFinish}
                >
                    <Form.Item
                        label="Tài khoản"
                        name="username"
                        rules={[{ required: true, message: 'Vui lòng nhập tài khoản của bạn!' }]}
                    >
                        <Input />
                    </Form.Item>

                    <Form.Item
                        label="Mật khẩu"
                        name="password"
                        rules={[{ required: true, message: 'Vui lòng nhập mật khẩu của bạn' }]}
                    >
                        <Input.Password />
                    </Form.Item>

                    <Form.Item>
                        <Button type="primary" htmlType="submit" >
                            Đăng nhập
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
};

export default Login;
