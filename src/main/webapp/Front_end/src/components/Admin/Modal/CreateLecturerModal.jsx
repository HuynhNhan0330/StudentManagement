import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateLecturerModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Tạo giảng viên" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="MSGV">
                    <Input />
                </Form.Item>
                <Form.Item label="Tên">
                    <Input />
                </Form.Item>
                <Form.Item label="Ngày sinh">
                    <Input />
                </Form.Item>
                <Form.Item label="Email">
                    <Input />
                </Form.Item>
                <Form.Item label="Số điện thoại">
                    <Input />
                </Form.Item>
                <Form.Item label="Khoa">
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateLecturerModal;
