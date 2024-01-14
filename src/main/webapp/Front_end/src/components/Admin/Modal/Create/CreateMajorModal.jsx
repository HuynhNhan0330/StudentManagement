import React from 'react';
import { Modal, Form, Input, Button, Select } from 'antd';
import './CreateStyle.css'

const { Option } = Select;

function CreateMajorModal({ open, onOk, onCancel, faculties }) {
    const onFinish = (values) => {
        onOk(values);
    };

    const createForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên ngành"
                name="tenNganh"
                rules={[{ required: true, message: 'Nhập tên ngành' }]}
            >
                <Input style={{width: 350, float:'right'}}/>
            </Form.Item>

            <Form.Item
                label="Khoa"
                name="maKhoa"
                rules={[{ required: true, message: 'Chọn khoa' }]}
            >
                <Select style={{width: 350, float:'right'}}>
                    {faculties.map((faculty) => (
                        <Option key={faculty.maKhoa} value={faculty.maKhoa}>
                            {faculty.tenKhoa}
                        </Option>
                    ))}
                </Select>
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

export default CreateMajorModal;
