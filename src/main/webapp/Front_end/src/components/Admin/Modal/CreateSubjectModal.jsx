import { Modal, Form, Input } from 'antd';

const CreateSubjectModal = ({ open, onCancel, onOk }) => {
    const createForm = (
        <Form>
            <Form.Item label="Name" name="name">
                <Input />
            </Form.Item>
            <Form.Item label="Predicate Subject" name="predicate_subject">
                <Input />
            </Form.Item>
            <Form.Item label="Previos Subject" name="previos_subject">
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
