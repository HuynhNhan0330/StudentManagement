import React, { useEffect } from 'react';
import { Modal, Form, Input, Button } from 'antd';
import '../Create/CreateStyle.css'


function EditFacultyModal({ open, onOk, onCancel, selectedFaculty }) {
    const onFinish = (values) => {
        // onOk({
        //     maKhoa: selectedFaculty.maKhoa,
        //     ...values
        // });
    };

    const [form] = Form.useForm();

    useEffect(() => {
        if (selectedFaculty != null) {
            form.setFieldsValue({
                tenKhoa: selectedFaculty.tenKhoa
            });
        }
    }, [selectedFaculty])

    const editForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên khoa"
                       name="tenKhoa"
                       rules={[{ required: true, message: 'Nhập tên khoa' }]}
                       >
                <Input style={{width: 350, float:'right'}}/>
            </Form.Item>
            
            <Form.Item style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button onClick={onCancel} style={{ marginRight: 8 }}>Huỷ</Button>
                <Button type="primary" htmlType="submit">
                    Câp nhật
                </Button>
            </Form.Item>
        </Form>
    );

    return (
        <Modal title={`Sửa thông tin khoa ${selectedFaculty?.tenKhoa} `}
               open={open}
               onCancel={onCancel}
               footer={null}
            >
            {editForm}
        </Modal>
    );
}

export default EditFacultyModal;
