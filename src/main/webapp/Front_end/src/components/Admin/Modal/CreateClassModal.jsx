import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateClassModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Thêm lớp mới" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Tên" name="name" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Mã lớp" name="id" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Mã giảng viên" name="MSGV" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Mã môn học" name="SubjectId" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Thời gian" name="time" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateClassModal;
