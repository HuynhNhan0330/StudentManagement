import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateMajorModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Create New Major" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Name" name="name" rules={[{ required: true }]}>
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
