import axios from "axios"

const handleCreateFaculty = (faculty) => {
  return axios.post('http://localhost:8080/api-admin-khoa', faculty)
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
  return axios.get('http://localhost:8080/api-admin-khoa')
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
  return axios.delete('http://localhost:8080/api-admin-khoa', {data: faculty})
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