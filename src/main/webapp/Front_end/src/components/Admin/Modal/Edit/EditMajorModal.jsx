import React, { useEffect } from 'react';
import { Modal, Form, Input, Button, Select } from 'antd';
import '../Create/CreateStyle.css'

const { Option } = Select;

function EditMajorModal({ open, onOk, onCancel, faculties, selectedMajor }) {
    const onFinish = (values) => {
        onOk({
            maNganh: selectedMajor.maNganh,
            ...values
        });
    };

    const [form] = Form.useForm();

    useEffect(() => {
        if (selectedMajor != null) {
            form.setFieldsValue({
                tenNganh: selectedMajor.tenNganh,
                maKhoa: selectedMajor.tenKhoa,
            });
        }
    }, [selectedMajor])

    const editForm = (
        <Form form={form} onFinish={onFinish}>
            <Form.Item label="Tên ngành"
                name="tenNganh"
                rules={[{ required: true, message: 'Nhập tên ngành' }]}
            >
                <Input style={{width: 350, float:'right'}}/>
            </Form.Item>

            <Form.Item
                label="Khoa"
                name="maKhoa"
                rules={[{ required: true, message: 'Chọn khoa' }]}
            >
                <Select style={{width: 350, float:'right'}}>
                    {faculties.map((faculty) => (
                        <Option key={faculty.maKhoa} value={faculty.maKhoa}>
                            {faculty.tenKhoa}
                        </Option>
                    ))}
                </Select>
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
        <Modal title={`Sửa thông tin ngành ${selectedMajor?.tenNganh} `}
            open={open}
            onCancel={onCancel}
            footer={null}
        >
            {editForm}
        </Modal>
    );
}

export default EditMajorModal;
