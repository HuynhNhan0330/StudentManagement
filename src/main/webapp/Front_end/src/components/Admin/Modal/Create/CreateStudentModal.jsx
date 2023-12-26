import React from 'react';
import { Modal, Form, Input, DatePicker, Select } from 'antd';


function CreateStudentModal({ open, onOk, onCancel }) {
    const handleChange = (value) => {
        console.log(`selected ${value}`);
      };
    const onChange = (date, dateString) => {
        console.log(date, dateString);
      };
    return (
        <Modal title="Tạo sinh viên" open={open} onOk={onOk} onCancel={onCancel}>
            <Form>
                <Form.Item label="Tên">
                    <Input />
                </Form.Item>
                <Form.Item label="Ngày sinh">
                <DatePicker onChange={onChange} style={{
                        width: 400,
                    }} />
                </Form.Item>
                <Form.Item label="Giới tính">
                <Select
                    defaultValue=""
                    style={{
                        width: 400,
                    }}
                    onChange={handleChange}
                    options={[
                        {
                        value: 'Nam',
                        label: 'Nam',
                        },
                        {
                        value: 'Nu',
                        label: 'Nữ',
                        }, ]} />
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
