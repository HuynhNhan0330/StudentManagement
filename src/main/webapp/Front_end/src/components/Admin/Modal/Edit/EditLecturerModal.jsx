import React from 'react';
import { Modal, Form, Input, DatePicker } from 'antd';

function EditLecturerModal({ open, onOk, onCancel }) {
    const onChange = (date, dateString) => {
        console.log(date, dateString);
      };
    return (
        <Modal title="Sửa thông tin giảng viên" open={open} onOk={onOk} onCancel={onCancel} okButtonProps={{className : 'SubjectOkButton'}} cancelButtonProps={{className : 'SubjectCancelButton'}}>
            <Form>
                <Form.Item label="Tên">
                    <Input />
                </Form.Item>
                <Form.Item label="Ngày sinh">
                <DatePicker onChange={onChange}
                    placeholder=''
                    style={{ width: 390, }} />
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

export default EditLecturerModal;
