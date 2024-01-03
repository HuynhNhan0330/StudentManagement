import axios from "axios"

const handleCreateLecturer = (lecturer) => {
  return axios.post('http://localhost:8080/api-admin-giaovien', lecturer)
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
  return axios.get('http://localhost:8080/api-admin-giaovien')
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
  return axios.delete('http://localhost:8080/api-admin-giaovien', {data: lecturer})
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
    handleDeleteLecturer
}