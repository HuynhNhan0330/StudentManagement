import React from 'react';
import { Modal, Form, Input, Button } from 'antd';
import './CreateStyle.css'


function CreateFacultyModal({ open, onOk, onCancel }) {
    const onFinish = (values) => {
        onOk(values);
    };

    const createForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên khoa"
                       name="tenKhoa"
                       rules={[{ required: true, message: 'Nhập tên khoa' }]}
                       >
                <Input style={{width: 350, float:'right'}}/>
            </Form.Item>
            
            <Form.Item style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button onClick={onCancel} style={{ marginRight: 8 }}>Huỷ</Button>
                <Button type="primary" htmlType="submit">
                    Tạo
                </Button>
            </Form.Item>
        </Form>
    );

    return (
        <Modal title="Tạo khoa mới" 
               open={open}
               onCancel={onCancel}
               footer={null}
            >
            {createForm}
        </Modal>
    );
}

export default CreateFacultyModal;
