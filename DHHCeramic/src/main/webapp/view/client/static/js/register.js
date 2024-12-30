const form = document.getElementById('form_input_group');
const email = document.getElementById('email');
const username = document.getElementById('username');
const password = document.getElementById('password');
const re_password = document.getElementById('re-password');

//Show input error message

function showError(input, message) {
    const formControl = input.parentElement;
    formControl.className = 'input-group-control error';
    const small = formControl.querySelector('small');
    small.style.display = 'block';
    small.style.color = 'red';
    small.style.textAlign = 'left';
    small.style.marginLeft = '35px';
    small.style.marginTop = '-9px';
    small.innerText = message;

}

function showSuccess(input) {
    const formControl = input.parentElement;
    formControl.className = 'input-group-control success';

}

//Email

function isValidEmail(email) {
    const re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return re.test(String(email).toLowerCase());
}



function checkForm() {
    if (email.value === '') {
        showError(email, 'Vui lòng nhập email');
    } else if (!isValidEmail(email.value)) {
        showError(email, 'Email không tồn tại');
    }
    else {
        showSuccess(email);
    }
    if (username.value === '') {
        showError(username, 'Vui lòng nhập tên người dùng');
    }
    else {
        showSuccess(username);
    }
    if (password.value === '') {
        showError(password, 'Vui lòng nhập mật khẩu');
    }
    else {
        showSuccess(password);
    }
    if (re_password.value !== password.value || re_password === '') {
        showError(re_password, 'Xác nhận mật khẩu sai');
    }


}