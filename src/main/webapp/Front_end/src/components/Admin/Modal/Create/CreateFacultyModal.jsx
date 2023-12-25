import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateFacultyModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Tạo khoa mới" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Tên khoa" name="name" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Id" name="id" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateFacultyModal;
