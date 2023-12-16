import { Drawer, List } from 'antd';

const ShowSubjectDrawer = ({ open, onClose, classesData, selectedSubject }) => {
    return (
        <Drawer
            title={`Danh sách lớp học của môn ${selectedSubject?.name}`}
            placement="right"
            onClose={onClose}
            open={open}
        >
            <List
                dataSource={classesData}
                renderItem={(item) => (
                    <List.Item>
                        <List.Item.Meta title={<a href="#">{item.class_name}</a>} description={`Some thing`} />
                    </List.Item>
                )}
            />
        </Drawer>
    );
};

export default ShowSubjectDrawer;
