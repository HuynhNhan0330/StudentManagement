import axios from "axios"

const handleCreateMajor = (major) => {
  return axios.post('http://localhost:8080/api-admin-nganh', major)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return null;
    });
};

const handleGetMajors = () => {
  return axios.get('http://localhost:8080/api-admin-nganh')
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
  return axios.delete('http://localhost:8080/api-admin-nganh', {data: major})
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
    handleCreateMajor,
    handleGetMajors,
    handleDeleteMajor
}