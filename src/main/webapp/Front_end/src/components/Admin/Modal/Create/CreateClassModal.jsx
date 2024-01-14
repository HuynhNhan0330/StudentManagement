import React from 'react';
import { Modal, Form, Input, Button, TimePicker, Select } from 'antd';
import { DateOfWeek } from '../../../../utils/Helper';
import './CreateStyle.css'


const { Option } = Select;

function CreateClassModal({ open, onOk, onCancel, rooms, lecturers, subjects }) {
    const onFinish = (values) => {
        const newValues = {
            'tenLop': values.tenLop,
            'maGV': values.maGV,
            'maMH': values.maMH,
            'ngayHoc': values.ngayHoc,
            'thoiGianBatDau': values.thoiGian[0].$d.getHours() + ':' + values.thoiGian[0].$d.getMinutes(),
            'thoiGianKetThuc': values.thoiGian[1].$d.getHours() + ':' + values.thoiGian[1].$d.getMinutes(),
            'maPH': values.maPH
        }
        
        onOk(newValues);
    };

    const disabledTime = () => {
        const hours = [];
        
        for (let i = 0; i < 6; i += 1) {
          hours.push(i);
        }

        for (let i = 18; i < 24; i += 1) {
            hours.push(i);
          }

        return { disabledHours: () => hours };
      };

    const createForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên lớp học"
                name="tenLop"
                rules={[{ required: true, message: 'Nhập tên lớp' }]}
            >
                <Input style={{width: 350, float: 'right'}}/>
            </Form.Item>

            <Form.Item
                label="Giáo viên"
                name="maGV"
                rules={[{ required: true, message: 'Chọn giáo viên' }]}
            >
                <Select style={{width: 350, float: 'right'}}>
                    {lecturers.map((lecturer) => (
                        <Option key={lecturer.maGV} value={lecturer.maGV}>
                            {lecturer.tenTK}
                        </Option>
                    ))}
                </Select>
            </Form.Item>

            <Form.Item
                label="Môn học"
                name="maMH"
                rules={[{ required: true, message: 'Chọn môn học' }]}
            >
                <Select style={{width: 350, float: 'right'}}>
                    {subjects.map((subject) => (
                        <Option key={subject.maMH} value={subject.maMH}>
                            {subject.tenMH}
                        </Option>
                    ))}
                </Select>
            </Form.Item>

            <Form.Item label="Ngày học" name="ngayHoc">
                <Select allowClear  style={{width: 350, float: 'right'}}>
                    {Array.from({ length: 7 }, (_, i) => (
                        <Option key={i} value={DateOfWeek.GetDateOfWeek(i)}>
                            {DateOfWeek.GetDateOfWeek(i)}
                        </Option>
                    ))}
                </Select>
            </Form.Item>

            <Form.Item label="Thời gian học" name="thoiGian">
                <TimePicker.RangePicker format="HH:mm" 
                                        disabledTime={disabledTime}
                                        minuteStep={15}
                                        hideDisabledOptions={true}
                                        style={{width: 350, float: 'right'}}
                />
            </Form.Item>

            <Form.Item
                label="Phòng học"
                name="maPH"
                rules={[{ required: true, message: 'Chọn phòng học' }]}
            >
                <Select style={{width: 350, float: 'right'}}>
                    {rooms.map((room) => (
                        <Option key={room.maPH} value={room.maPH}>
                            {room.tenPH}
                        </Option>
                    ))}
                </Select>
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
        <Modal title="Thêm lớp mới"
            open={open}
            onCancel={onCancel}
            footer={null}>
            {createForm}
        </Modal>
    );
}

export default CreateClassModal;
