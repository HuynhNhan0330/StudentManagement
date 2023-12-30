import axios from "axios"

const handleCreateSubject = (subject) => {
  return axios.post('http://localhost:8080/api-admin-monhoc', subject)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
      console.error(error);

      return null;
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
    handleCreateSubject,
    handleGetSubjects,
    handleDeleteSubjects
}