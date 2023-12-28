import axios from "axios"

const handleCreateSubject = (subject) => {
    axios.post('http://localhost:8080/api-admin-monhoc', subject)
  .then((response) => {
    console.log('Dữ liệu đã được gửi thành công!');
    console.log(response.data);
  })
  .catch((error) => {
    console.error('Đã xảy ra lỗi khi gửi dữ liệu:');
    console.error(error);
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

export  {
    handleCreateSubject,
    handleGetSubjects
}