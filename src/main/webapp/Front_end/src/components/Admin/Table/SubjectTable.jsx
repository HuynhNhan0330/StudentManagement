import { Table } from 'antd';
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'

const SubjectTable = ({ data, loading, handleTableChange, handleEdit, handleDelete }) => {
    const columns = [
        {
            title: 'Mã môn học',
            dataIndex: 'maMH',
        },
        {
            title: 'Tên môn học',
            dataIndex: 'tenMH',
        },

        {
            title: 'Số tín chỉ',
            dataIndex: 'soTinChi',
        },
        {
            title: 'Thao tác',
            key: 'action',
            render: (record) => (
                <>
                    <EditOutlined onClick={() => {handleEdit(record); }}/>
                    <DeleteOutlined style = {{ color: "red", marginLeft: 12 }}
                                    onClick = {() => { handleDelete(record); }}
                    />
                </>
            )
        }
    ]

    return (
        <Table
            columns={ columns }
            dataSource={ data }
            loading={ loading }
            onChange={ handleTableChange }
        />
    );
};

export default SubjectTable;
