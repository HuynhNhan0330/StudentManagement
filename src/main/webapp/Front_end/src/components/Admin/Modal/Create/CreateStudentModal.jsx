import React from 'react';
import { Modal, Form, Input, DatePicker, Select, Button } from 'antd';
import moment from 'moment';
import './CreateStyle.css'


const { Option } = Select;

function CreateStudentModal({ open, onOk, onCancel, majors }) {
    const onFinish = (values) => {
        values.ngaySinh = moment(values.ngaySinh).format('DD/MM/YYYY');
        onOk(values);
    };

    const createForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên sinh viên"
                name="tenTK"
                rules={[{ required: true, message: 'Nhập tên sinh viên' }]}
            >
                <Input style={{
                    width: 340,
                    float: 'right'
                }}/>
            </Form.Item>
            <Form.Item label="Ngày sinh"
                name="ngaySinh"
                rules={[{ required: true, message: 'Chọn ngày sinh' }]}
            >
                <DatePicker format="DD/MM/YYYY"
                    style={{
                        width: 340,
                        float: 'right'
                    }}
                />
            </Form.Item>
            <Form.Item label="Giới tính"
                       name="gioiTinh"
                       rules={[{ required: true, message: 'Nhập giới tính' }]}>
                <Select
                    style={{
                        width: 340,
                        float: 'right'
                    }}
                    options={[
                        {
                            value: 'Nam',
                            label: 'Nam',
                        },
                        {
                            value: 'Nữ',
                            label: 'Nữ',
                        },]} />
            </Form.Item>
            <Form.Item label="Email"
                name="email"
                rules={[{ required: true, message: 'Nhập email' }]}
            >
                <Input style={{
                    width: 340,
                    float: 'right'
                }}/>
            </Form.Item>
            <Form.Item label="Số điện thoại"
                name="phone"
                rules={[{ required: true, message: 'Nhập số điện thoại' }]}
            >
                <Input pattern="[0-9]*" style={{
                    width: 340,
                    float: 'right'
                }}/>
            </Form.Item>
            <Form.Item
                label="Ngành"
                name="maNganh"
                rules={[{ required: true, message: 'Chọn ngành' }]}
            >
                <Select style={{width: 340, float: 'right'}}>
                    {majors.map((major) => (
                        <Option key={major.maNganh} value={major.maNganh}>
                            {major.tenNganh}
                        </Option>
                    ))}
                </Select>
            </Form.Item>

            <Form.Item label="Năm nhập học"
                       name="namNhapHoc"
                       rules={[{ required: true, message: 'Nhập năm nhập học' }]}>
                <Input style={{
                    width: 340,
                    float: 'right'
                }}/>
            </Form.Item>

            <Form.Item style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button onClick={onCancel} style={{ marginRight: 8 }}>Huỷ</Button>
                <Button type="primary" htmlType="submit">
                    Tạo
                </Button>
            </Form.Item>
        </Form>
    );


    return (
        <Modal title="Tạo sinh viên"
            open={open}
            onCancel={onCancel}
            footer={null}>
            {createForm}
        </Modal>
    );
}

export default CreateStudentModal;
