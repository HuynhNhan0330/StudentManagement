import { Modal, Form, Input } from 'antd';

const EditClassModal = ({ open, onCancel, onOk, selectedSubject}) => {
    const createForm = (
        <Form>
            <Form.Item label="Tên" name="name" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
            <Form.Item label="Mã giảng viên" name="MSGV" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Mã môn học" name="SubjectId" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
                <Form.Item label="Thời gian" name="time" rules={[{ required: true }]}>
                    <Input />
                </Form.Item>
        </Form>
    );

    return (
        <Modal title={`Sửa thông tin lớp học ${selectedSubject?.subject_id} `} open={open} onOk={onOk} onCancel={onCancel}>
            {createForm}
        </Modal>
    );
};

export default EditClassModal;
