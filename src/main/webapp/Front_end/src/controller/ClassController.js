import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleCreateClass = (classs) => {
    return axios.post(baseUrlAPI + '/api-admin-lophoc', classs)
      .then((response) => {
        return response;
      })
      .catch((error) => {
        console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
        console.error(error);
  
        return error;
      });
  };

const handleGetClasses = () => {
  return axios.get(baseUrlAPI + '/api-admin-lophoc')
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
    handleCreateClass,
    handleGetClasses
}