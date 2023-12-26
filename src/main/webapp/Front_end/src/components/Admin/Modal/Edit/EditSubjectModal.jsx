import { Modal, Form, Input } from 'antd';

const EditSubjectModal = ({ open, onCancel, onOk, selectedSubject}) => {
    const createForm = (
        <Form>
            <Form.Item label="Tên môn học" name="name">
                <Input />
            </Form.Item>
            <Form.Item label="Số tín chỉ" name="tinChi">
                <Input />
            </Form.Item>
        </Form>
    );

    return (
        <Modal title={`Sửa thông tin môn học ${selectedSubject?.subject_id} `} open={open} onOk={onOk} onCancel={onCancel}>
            {createForm}
        </Modal>
    );
};

export default EditSubjectModal;
