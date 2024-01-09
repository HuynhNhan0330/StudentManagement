import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleGetRoom = () => {
  return axios.get(baseUrlAPI + '/api-admin-phonghoc')
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

export  {
    handleGetRoom
}