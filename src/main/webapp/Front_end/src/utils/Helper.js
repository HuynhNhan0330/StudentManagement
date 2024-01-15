
const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
};

const isValidPhoneNumber = (phoneNumber) => {
    const phoneRegex = /^0\d{9}$/;
    return phoneRegex.test(phoneNumber);
};

const baseUrlAPI = "https://3c9c1099dcb4b689ac3e7bda7c8c9473.serveo.net"

const DateOfWeek = {
    "Thứ 2": '1',
    "Thứ 3": '2',
    "Thứ 4": '3',
    "Thứ 5": '4',
    "Thứ 6": '5',
    "Thứ 7": '6',
    "Chủ Nhật": '7',
    GetDateOfWeek(date) {
        switch (date) {
            case 0: return "Chủ Nhật";
            case 1: return "Thứ 2";
            case 2: return "Thứ 3";
            case 3: return "Thứ 4";
            case 4: return "Thứ 5";
            case 5: return "Thứ 6";
            case 6: return "Thứ 7";
            default: return "Ngày không hợp lệ";
        }
    },
    default: 0
}

export  {
    isValidEmail,
    isValidPhoneNumber,
    baseUrlAPI,
    DateOfWeek
}