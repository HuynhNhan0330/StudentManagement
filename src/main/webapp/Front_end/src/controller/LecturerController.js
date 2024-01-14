import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleCreateLecturer = (lecturer) => {
  return axios.post(baseUrlAPI + '/api-admin-giaovien', lecturer)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      // console.error(error);

      return error;
    });
};

const handleUpdateLecturer = (lecturer) => {
  return axios.put(baseUrlAPI + '/api-admin-giaovien', lecturer)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      // console.error(error);

      return error;
    });
};

const handleGetLecturers = () => {
  return axios.get(baseUrlAPI + '/api-admin-giaovien')
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

const handleDeleteLecturer = (lecturer) => {
  return axios.delete(baseUrlAPI + '/api-admin-giaovien', {data: lecturer})
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
    handleCreateLecturer,
    handleGetLecturers,
    handleDeleteLecturer,
    handleUpdateLecturer
}