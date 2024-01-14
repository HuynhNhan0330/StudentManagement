import axios from "axios"
import { baseUrlAPI } from "../utils/Helper";

const handleCreateSubject = (subject) => {
  return axios.post(baseUrlAPI + '/api-admin-monhoc', subject)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      // console.error(error);

      return error;
    });
};

const handleUpdateSubject = (subject) => {
  return axios.put(baseUrlAPI + '/api-admin-monhoc', subject)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      // console.error(error);

      return error;
    });
};

const handleGetSubjects = () => {
  return axios.get(baseUrlAPI + '/api-admin-monhoc')
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

const handleDeleteSubjects = (subject) => {
  return axios.delete(baseUrlAPI + '/api-admin-monhoc', {data: subject})
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
    handleCreateSubject,
    handleGetSubjects,
    handleDeleteSubjects,
    handleUpdateSubject
}