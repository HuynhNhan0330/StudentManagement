import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateClassModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Add New Class" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Name" name="name" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Room" name="room" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Program" name="program" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Class Type" name="class_type" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="SubjectID" name="sucject_id" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateClassModal;
