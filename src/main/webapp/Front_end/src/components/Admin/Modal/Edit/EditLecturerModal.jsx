import React, { useEffect } from 'react';
import { Modal, Form, Input, DatePicker, Button, Select } from 'antd';
import moment from 'moment';

const { Option } = Select;

function EditLecturerModal({ open, onOk, onCancel, faculties, selectedLecturer }) {
    const onFinish = (values) => {
        const lecturer = {
            maGV: selectedLecturer.maGV,
            maTK: selectedLecturer.maTK,
            role: selectedLecturer.role,
            ...values
        }

        lecturer.ngaySinh = moment(lecturer.ngaySinh).format('DD/MM/YYYY');

        onOk(lecturer);
    };

    const [form] = Form.useForm();

    useEffect(() => {
        console.log(selectedLecturer)

        if (selectedLecturer != null) {
            form.setFieldsValue({
                tenTK: selectedLecturer.tenTK,
                ngaySinh: moment(selectedLecturer.ngaySinh, 'DD/MM/YYYY'),
                gioiTinh: selectedLecturer.gioiTinh,
                email: selectedLecturer.email,
                phone: selectedLecturer.phone,
                maKhoa: selectedLecturer.tenKhoa,
                namNhapHoc: selectedLecturer.namNhapHoc
            });
        }

    }, [selectedLecturer])

    const editForm = (
        <Form form={form} onFinish={onFinish}>
            <Form.Item label="Tên giáo viên"
                name="tenTK"
                rules={[{ required: true, message: 'Nhập tên giáo viên' }]}
            >
                <Input style={ {
                    width: '330px',
                    float: 'right'
                    }}
                />
            </Form.Item>
            <Form.Item label="Ngày sinh"
                name="ngaySinh"
                rules={[{ required: true, message: 'Chọn ngày sinh' }]}
            >
                <DatePicker format="DD/MM/YYYY"
                    style={{
                        width: '330px',
                        float: 'right'
                    }}
                />
            </Form.Item>
            <Form.Item label="Email"
                name="email"
                rules={[{ required: true, message: 'Nhập email' }]}
            >
                <Input style={{
                    width: '330px',
                    float: 'right'
                }}/>
            </Form.Item>
            <Form.Item label="Số điện thoại"
                name="phone"
                rules={[{ required: true, message: 'Nhập số điện thoại' }]}
            >
                <Input style={{
                    width: '330px',
                    float: 'right'
                }}/>
            </Form.Item>
            <Form.Item
                label="Khoa"
                name="maKhoa"
                rules={[{ required: true, message: 'Chọn khoa' }]}
            >
                <Select style={{width:'330px', float:'right'}}>
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
    )

    return (
        <Modal title={`Sửa thông tin giảng viên ${selectedLecturer?.tenTK} `}
            open={open}
            onCancel={onCancel}
            footer={null}>
            {editForm}
        </Modal>
    );
}

export default EditLecturerModal;
