
const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
};

const isValidPhoneNumber = (phoneNumber) => {
    const phoneRegex = /^0\d{9}$/;
    return phoneRegex.test(phoneNumber);
};

const baseUrlAPI = "http://localhost:8080"

export  {
    isValidEmail,
    isValidPhoneNumber,
    baseUrlAPI
}