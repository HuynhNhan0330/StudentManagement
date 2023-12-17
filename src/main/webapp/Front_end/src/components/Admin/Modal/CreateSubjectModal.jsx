import { Modal, Form, Input } from 'antd';

const CreateSubjectModal = ({ open, onCancel, onOk }) => {
    const createForm = (
        <Form>
            <Form.Item label="Tên môn học" name="name">
                <Input />
            </Form.Item>
            <Form.Item label="Mã môn học" name="id">
                <Input />
            </Form.Item>
            <Form.Item label="Số tín chỉ" name="tinChi">
                <Input />
            </Form.Item>
        </Form>
    );

    return (
        <Modal title="Thêm mới môn học" open={open} onOk={onOk} onCancel={onCancel}>
            {createForm}
        </Modal>
    );
};

export default CreateSubjectModal;
