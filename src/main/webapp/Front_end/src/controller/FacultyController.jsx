import axios from "axios"

const handleCreateFaculty = (faculty) => {
  return axios.post('http://localhost:8080/api-admin-khoa', faculty)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return null;
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
    if (response.status === 200)
      return true;
    else 
      return false;
  })
  .catch((error) => { 
    console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
    console.error(error);
  });
}

export  {
    handleCreateFaculty,
    handleGetFaculties,
    handleDeleteFaculty
}