import React from 'react';
import { Form, Input, Button, Checkbox, Card } from 'antd';
import { NavLink } from 'react-router-dom';

import './Login.scss';

const Login = () => {
    const backgroundImage =
        'url("https://png.pngtree.com/thumb_back/fh260/background/20200809/pngtree-doodles-on-green-chalkboard-background-back-to-school-background-image_389839.jpg")';

    return (
        <div className="login-container" style={{ backgroundImage }}>
            <Card title="Login" className="login-card">
                <Form name="login-form" initialValues={{ remember: true }}>
                    <Form.Item
                        label="Username"
                        name="username"
                        rules={[{ required: true, message: 'Please input your username!' }]}
                    >
                        <Input />
                    </Form.Item>

                    <Form.Item
                        label="Password"
                        name="password"
                        rules={[{ required: true, message: 'Please input your password!' }]}
                    >
                        <Input.Password />
                    </Form.Item>

                    <Form.Item name="remember" valuePropName="checked">
                        <Checkbox>Remember me</Checkbox>
                    </Form.Item>

                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            <NavLink to="/">Log in</NavLink>
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
};

export default Login;
