import React from 'react';
import { Modal, Form, Input } from 'antd';

function CreateStudentModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Tạo sinh viên" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="MSSV">
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
                <Form.Item label="Khóa">
                    <Input />
                </Form.Item>
                <Form.Item label="Lớp">
                    <Input />
                </Form.Item>
                <Form.Item label="Faculty">
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateStudentModal;
