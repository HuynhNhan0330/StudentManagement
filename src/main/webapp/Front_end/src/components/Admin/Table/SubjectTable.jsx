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
                    title: 'Predicate Subject',
                    dataIndex: 'predicate_subject',
                    key: 'predicate_subject',
                },
                {
                    title: 'Previos Subject',
                    dataIndex: 'previos_subject',
                    key: 'previos_subject',
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
                    subject_id: '1',
                    name: 'Hoa hoc',
                    predicate_subject: 'abc',
                    previos_subject: '90',
                },
                {
                    key: '2',
                    subject_id: '2',
                    name: 'Vat Ly',
                    predicate_subject: '4',
                    previos_subject: '120',
                },
            ]}
            rowSelection={{
                type: 'checkbox',
            }}
        />
    );
};

export default SubjectTable;
