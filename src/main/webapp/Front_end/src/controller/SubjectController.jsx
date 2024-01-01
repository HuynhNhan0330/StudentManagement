import axios from "axios"

const handleCreateSubject = (subject) => {
  return axios.post('http://localhost:8080/api-admin-monhoc', subject)
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
  return axios.get('http://localhost:8080/api-admin-monhoc')
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
  return axios.delete('http://localhost:8080/api-admin-monhoc', {data: subject})
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
    handleDeleteSubjects
}