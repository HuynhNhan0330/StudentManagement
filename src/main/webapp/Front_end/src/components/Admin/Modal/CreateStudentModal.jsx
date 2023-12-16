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
                <Form.Item label="Giới tính">
                    <Input />
                </Form.Item>
                <Form.Item label="Khoa">
                    <Input />
                </Form.Item>
                <Form.Item label="Tên ngành">
                    <Input />
                </Form.Item>
                <Form.Item label="Năm nhập học">
                    <Input />
                </Form.Item>
                <Form.Item label="Số tín đã học">
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
}

export default CreateStudentModal;
