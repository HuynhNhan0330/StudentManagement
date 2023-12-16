import React from 'react';
import { Modal, Input } from 'antd';

function SendNotiLecturerModal({ open, onOk, onCancel }) {
    return (
        <Modal title="Gửi thông báo" open={open} onOk={onOk} onCancel={onCancel}>
            <p>Nhập tiêu đề:</p>
            <Input placeholder="Tiêu đề" />
            <p style={{ marginTop: 16 }}>Nhập nội dung:</p>
            <Input.TextArea placeholder="Nội dung" />
        </Modal>
    );
}

export default SendNotiLecturerModal;
