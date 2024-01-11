import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleLogin = (account) => {
    return axios.post(baseUrlAPI + '/login', account)
        .then((response) => {
            return response;
        })
        .catch((error) => {
            console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
            console.error(error);

            return error;
        });
};


export {
    handleLogin
}