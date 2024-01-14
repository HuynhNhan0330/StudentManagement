import { Modal, Form, Input, Button } from 'antd';
import './CreateStyle.css';

const CreateSubjectModal = ({ open, onCancel, onOk }) => {
    const onFinish = (values) => {
        onOk(values);
    };

    const createForm = (
        <Form onFinish={onFinish}>
            <Form.Item label="Tên môn học"
                       name="tenMH"
                       rules={[{ required: true, message: 'Nhập tên môn học' }]}
                       >
                <Input style={{width: 350, float: 'right'}}/>
            </Form.Item>

            <Form.Item label="Số tín chỉ"
                       name="soTinChi"
                       rules={[{ required: true, message: 'Nhập số tín chỉ môn học'}]}
                       >
                <Input style={{width: 350, float: 'right'}}/>
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
        <Modal title="Thêm mới môn học"
               open={open}
               onCancel={onCancel}
               footer={null}
        >
            {createForm}
        </Modal>
    );
};

export default CreateSubjectModal;
