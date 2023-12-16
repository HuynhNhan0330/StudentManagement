import { Space, Button, Table } from 'antd';

const SubjectTable = ({ showDrawer }) => {
    return (
        <Table
            columns={[
                {
                    title: 'Subject id',
                    dataIndex: 'subject_id',
                    key: 'subject_id',
                },
                {
                    title: 'Name',
                    dataIndex: 'name',
                    key: 'name',
                },

                {
                    title: 'Số tín chỉ',
                    dataIndex: 'soTinchi',
                    key: 'soTinchi',
                },
                {
                    title: 'Action',
                    key: 'action',
                    render: (_, record) => (
                        <Space size="middle">
                            <Button type="primary" onClick={() => console.log('Edit')}>
                                Edit
                            </Button>
                            <Button danger variant="contained" type="primary" onClick={() => console.log('Delete')}>
                                Delete
                            </Button>
                            <Button type="dashed" onClick={() => showDrawer(record)}>
                                Detail
                            </Button>
                        </Space>
                    ),
                },
            ]}
            dataSource={[
                {
                    key: '1',
                    subject_id: 'Subject1',
                    name: 'Hoa hoc',
                    soTinchi: '1',
                },
                {
                    key: '2',
                    subject_id: 'SUbject2',
                    name: 'Vat Ly',
                    soTinchi: '4',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
};

export default SubjectTable;
