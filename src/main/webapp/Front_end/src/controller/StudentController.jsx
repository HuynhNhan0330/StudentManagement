import axios from "axios"

const handleCreateStudent = (student) => {
  return axios.post('http://localhost:8080/api-admin-sinhvien', student)
    .then((response) => {
      return response;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      // console.error(error);

      return error;
    });
};

const handleGetStudents = () => {
  return axios.get('http://localhost:8080/api-admin-sinhvien')
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

const handleDeleteStudent = (student) => {
  return axios.delete('http://localhost:8080/api-admin-sinhvien', {data: student})
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
    handleCreateStudent,
    handleGetStudents,
    handleDeleteStudent
}