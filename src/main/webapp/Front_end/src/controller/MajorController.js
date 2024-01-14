import axios from "axios"

import { baseUrlAPI } from "../utils/Helper";

const handleCreateMajor = (major) => {
  return axios.post(baseUrlAPI + '/api-admin-nganh', major)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return error;
    });
};

const handleUpdateMajor = (major) => {
  return axios.put(baseUrlAPI + '/api-admin-nganh', major)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return error;
    });
};

const handleGetMajors = () => {
  return axios.get(baseUrlAPI + '/api-admin-nganh')
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

const handleDeleteMajor = (major) => {
  return axios.delete(baseUrlAPI + '/api-admin-nganh', {data: major})
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
    handleCreateMajor,
    handleGetMajors,
    handleDeleteMajor,
    handleUpdateMajor
}