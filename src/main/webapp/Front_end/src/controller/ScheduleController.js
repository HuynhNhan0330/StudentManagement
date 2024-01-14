import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleGetScheduleByStudent = (studentId) => {
    return axios.get(baseUrlAPI + '/api-admin-lichhoc/sv/' + studentId)
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

const handleGetScheduleByLecturer = (lecturerId) => {
    return axios.get(baseUrlAPI + '/api-admin-lichhoc/gv/' + lecturerId)
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
    handleGetScheduleByStudent,
    handleGetScheduleByLecturer
}