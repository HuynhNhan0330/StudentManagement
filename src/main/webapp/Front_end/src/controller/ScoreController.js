import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleGetScoreByClass = (classId) => {
    return axios.get(baseUrlAPI + '/api-admin-diem/' + classId)
        .then((response) => {
            console.log('Dữ liệu đã được gửi thành công!');
            console.log(response.data);

            return response.data;
        })
        .catch((error) => {
            console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
            console.error(error);
        });
}

const handleGetScoreByStudent = (studentID) => {
    return axios.get(baseUrlAPI + '/api-admin-diem/sv/' + studentID)
        .then((response) => {
            console.log('Dữ liệu đã được gửi thành công!');
            console.log(response.data);

            return response.data;
        })
        .catch((error) => {
            console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
            console.error(error);
        });
}

const handleUpdateScoreByStudent = (score) => {
    return axios.put(baseUrlAPI + '/api-admin-diem', score)
        .then((response) => {
            console.log('Dữ liệu đã được gửi thành công!');
            console.log(response.data);

            return response.data;
        })
        .catch((error) => {
            console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
            console.error(error);
        });
}

export {
    handleGetScoreByClass,
    handleGetScoreByStudent,
    handleUpdateScoreByStudent
}