
const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
};

const isValidPhoneNumber = (phoneNumber) => {
    const phoneRegex = /^0\d{9}$/;
    return phoneRegex.test(phoneNumber);
};

const baseUrlAPI = "http://localhost:8080"

const DateOfWeek = {
    "Thứ 2": 0,
    "Thứ 3": 1,
    "Thứ 4": 2,
    "Thứ 5": 3,
    "Thứ 6": 4,
    "Thứ 7": 5,
    "Chủ Nhật": 6,
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
    }
}

export  {
    isValidEmail,
    isValidPhoneNumber,
    baseUrlAPI,
    DateOfWeek
}