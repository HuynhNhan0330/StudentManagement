import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateMajorModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Tạo ngành mới" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Tên" name="name" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Id" name="id" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateMajorModal;
