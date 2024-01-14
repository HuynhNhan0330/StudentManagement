import React, { useEffect } from 'react';
import { Modal, Form, Input, Button } from 'antd';

const EditSubjectModal = ({ open, onCancel, onOk, selectedSubject, setSelectedSubject }) => {
    const onFinish = (values) => {
        onOk({
            maMH: selectedSubject.maMH,
            ...values
        });
    };

    const [form] = Form.useForm();

    useEffect(() => {
        if (selectedSubject != null) {
            form.setFieldsValue({
                tenMH: selectedSubject.tenMH,
                soTinChi: selectedSubject.soTinChi,
            });
        }


    }, [selectedSubject])

    const createForm = (
        <Form form={form}
            onFinish={onFinish}
        >
            <Form.Item label="Tên môn học"
                name="tenMH"
                rules={[{ required: true, message: 'Nhập tên môn học' }]}

            >
                <Input />
            </Form.Item>

            <Form.Item label="Số tín chỉ"
                name="soTinChi"
                rules={[{ required: true, message: 'Nhập số tín chỉ môn học' }]}
            >
                <Input value={selectedSubject?.soTinChi} />
            </Form.Item>
            <Form.Item style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button onClick={onCancel} style={{ marginRight: 8 }}>Huỷ</Button>
                <Button type="primary" htmlType="submit">
                    Cập nhật
                </Button>
            </Form.Item>
        </Form>
    );

    return (
        <Modal title={`Sửa thông tin môn học ${selectedSubject?.tenMH} `}
            open={open}
            onCancel={onCancel}
            footer={null}>
            {createForm}
        </Modal>
    );
};

export default EditSubjectModal;
