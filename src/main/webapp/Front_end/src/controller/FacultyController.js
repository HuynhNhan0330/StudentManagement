import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleCreateFaculty = (faculty) => {
  return axios.post(baseUrlAPI + '/api-admin-khoa', faculty)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return error;
    });
};

const handleGetFaculties = () => {
  return axios.get(baseUrlAPI + '/api-admin-khoa')
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

const handleDeleteFaculty = (faculty) => {
  return axios.delete(baseUrlAPI + '/api-admin-khoa', {data: faculty})
  .then((response) => {
    return true;
  })
  .catch((error) => { 
    console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
    console.error(error);

    return false;
  });
}

export  {
    handleCreateFaculty,
    handleGetFaculties,
    handleDeleteFaculty
}