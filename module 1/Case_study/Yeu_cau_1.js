let displayName = ''; //tên khách hàng
let IDcard; // thông tin CMND
let birthday; // ngày sinh nhật
let email; // email
let displayAddress = ''; //địa chỉ
let customerSpecial; //Loại khách hàng
let discount = 0; //giảm giá
let number; //số người đi kèm
let rentDay; //ngày thuê
let serviceSpecial; //loại dichj vu
let roomSpecial; // loại phòng
let pay; //số tiền phải trả
function myFunction() {

    let name = document.getElementById("name").value;
    IDcard = document.getElementById("IDcard").value;
    birthday = document.getElementById("birthday").value;
    email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    customerSpecial = document.getElementById("customer_special").value;
    number = document.getElementById("number").value;
    rentDay = document.getElementById("rent_day").value;
    serviceSpecial = document.getElementById("service_special").value;
    roomSpecial = document.getElementById("room_special").value;

    //check name;
    let inputName = name.trim();
    for (let n = 0; n < inputName.length; n++) {
        if (n === 0) {
            displayName += inputName[n].toUpperCase();
        } else {
            if (inputName[n-1] === " ") {
                if (inputName[n] === " ") {
                    continue;
                } else {
                    displayName += inputName[n].toUpperCase();
                }
            } else {
                displayName += inputName[n].toLowerCase();
            }
        }
    }

    //check email
    let first = ''; // nhận giá trị @
    let second = ''; // nhận giá trị .
    let i=0;
    let checkEmail;
    while (i < email.length) {
        if (email[i] === '@') {
            if (first !== ''){
                checkEmail = false;
                break;
            }else {
                first = i;
            }
        } if (email[i] === '.') {
            second = i;
        } i++;
    } if (first === 0 || second === (email.length - 1) || first === '' || second === '' || first > second || checkEmail === false) {
        alert('email sai');
    } else {
        checkEmail = true;
    }

    //check CMND
    let j = 0;
    let checkIDcard;
    if (IDcard.length !== 8) {
        checkIDcard = false;
    } else {
        while (j < IDcard.length) {
            if (IDcard[j] >=0 && IDcard[j] <= 9) {
                checkIDcard = true;
                j++;
            } else {
                checkIDcard = false;
                break;
            }
        }
    }
    if (checkIDcard) {
        checkIDcard = true;
    } else {
        alert('Sai CMND');
    }

    //Check Address;
    let inputAddress = address.trim();
    for (let k = 0; k < inputAddress.length; k++) {
        if (k === 0) {
            displayAddress += inputAddress[k].toUpperCase();
        } else {
            if (inputAddress[k-1] === " ") {
                if (inputAddress[k] === " ") {
                    continue;
                } else {
                    displayAddress += inputAddress[k].toUpperCase();
                }
            } else {
                displayAddress += inputAddress[k].toLowerCase();
            }
        }
    }

    //Check số người đi kèm
    let l = 0;
    let checkNumber = false;
    while (l < number.length) {
        if (number[l] >=0 && number[l] <= 9) {
            checkNumber = true;
            l++;
        } else {
            checkNumber = false;
            break;
        }
    } if (checkNumber) {
        checkNumber = true;
    } else {
        alert('Sai số người đi kèm');
    }

    //Check số ngày thuê
    let m = 0;
    let checkRentDay = false;
    while (m < rentDay.length) {
        if (rentDay[m] >=0 && rentDay[m] <= 9) {
            checkRentDay = true;
            m++;
        } else {
            checkRentDay = false;
            break;
        }
    } if (checkRentDay) {
        checkRentDay = true;
    } else {
        alert('Sai số ngày thuê');
    }
    if (checkEmail === true && checkIDcard === true && checkNumber === true && checkRentDay === true) {
        document.getElementById("confirm_name").innerHTML = displayName;
        document.getElementById("name").value = '';
        document.getElementById("confirm_IDcard").innerHTML = IDcard;
        document.getElementById("IDcard").value = '';
        document.getElementById("confirm_birthday").innerHTML = birthday;
        document.getElementById("birthday").value = '';
        document.getElementById('confirm_email').innerHTML = email;
        document.getElementById("email").value = '';
        document.getElementById("confirm_address").innerHTML = displayAddress;
        document.getElementById("address").value = '';
        document.getElementById("confirm_customer_special").innerHTML = customerSpecial;
        document.getElementById("customer_special").value = '';
        document.getElementById("confirm_number").innerHTML = number;
        document.getElementById("number").value = '';
        document.getElementById("confirm_rent_day").innerHTML = rentDay;
        document.getElementById("rent_day").value = '';
        document.getElementById("confirm_service_special").innerHTML = serviceSpecial;
        document.getElementById("service_special").value = '';
        document.getElementById("confirm_room_special").innerHTML = roomSpecial;
        document.getElementById("room_special").value = '';
        switch (customerSpecial) {
            case 'Diamond':
                discount += 15;
                break;
            case 'Platinum':
                discount += 10;
                break;
            case 'Gold':
                discount += 5;
                break;
            case 'Silver':
                discount += 2;
                break;
            case 'Member':
                discount += 0;
        }
        switch (displayAddress) {
            case 'Đà Nẵng':
            case "Da Nang":
                discount += 20;
                break;
            case 'Huế':
            case 'Hue':
                discount += 10;
                break;
            case 'Quảng Nam':
            case 'Quang Nam':
                discount += 5;
        }
        if (rentDay >= 7) {
            discount += 30;
        } else if (rentDay >= 5) {
            discount += 20;
        } else {
            discount += 10;
        }
        document.getElementById('confirm_discount').innerHTML = discount + '$';
        if (serviceSpecial == "Villa") {
            pay = 500 * rentDay - discount;
        } else if (serviceSpecial == "House") {
            pay = 300 * rentDay - discount;
        } else {
            pay = 100 * rentDay - discount;
        }
        document.getElementById("pay").innerHTML = pay + '$';
    }
}
let x = 0;
let arrCustomer = [];
let arrInfoCustomer = [];
function addCustomer() {
    let confirm = prompt("Are you sure");
    if (confirm === 'y') {
        arrInfoCustomer.push(displayName);
        arrInfoCustomer.push(IDcard);
        arrInfoCustomer.push(birthday);
        arrInfoCustomer.push(email);
        arrInfoCustomer.push(displayAddress);
        arrInfoCustomer.push(customerSpecial);
        arrInfoCustomer.push(discount);
        arrInfoCustomer.push(number);
        arrInfoCustomer.push(rentDay);
        arrInfoCustomer.push(serviceSpecial);
        arrInfoCustomer.push(roomSpecial);
        arrInfoCustomer.push(pay);
        arrCustomer[x] = displayName;
        alert(arrInfoCustomer);
        alert(arrCustomer);
        document.getElementById("confirm_name").innerHTML = "";
        document.getElementById("confirm_IDcard").innerHTML = '';
        document.getElementById("confirm_birthday").innerHTML = '';
        document.getElementById('confirm_email').innerHTML = '';
        document.getElementById("confirm_address").innerHTML = '';
        document.getElementById("confirm_customer_special").innerHTML = '';
        document.getElementById("confirm_number").innerHTML = '';
        document.getElementById("confirm_rent_day").innerHTML = '';
        document.getElementById("confirm_service_special").innerHTML = '';
        document.getElementById("confirm_room_special").innerHTML = '';
        document.getElementById("pay").innerHTML = '';
        document.getElementById('confirm_discount').innerHTML = '';
        displayName = '';
        displayAddress = '';
        x++;
    }
}

function myEdit() {
    let editName = document.getElementById('confirm_name').textContent;
    document.getElementById('name').value = editName;
    let editIDcard = document.getElementById("confirm_IDcard").textContent;
    document.getElementById("IDcard").value = editIDcard;
    let editBirthday = document.getElementById("confirm_birthday").textContent;
    document.getElementById("birthday").value = editBirthday;
    let editEmail = document.getElementById("confirm_email").textContent;
    document.getElementById("email").value = editEmail;
    let editAddress = document.getElementById("confirm_address").textContent;
    document.getElementById("address").value = editAddress;
    let editCustomerSpecial = document.getElementById("confirm_customer_special").textContent;
    document.getElementById("customer_special").value = editCustomerSpecial;
    let editNumber = document.getElementById("confirm_number").textContent;
    document.getElementById("number").value = editNumber;
    let editRentDay = document.getElementById("confirm_rent_day").textContent;
    document.getElementById("rent_day").value = editRentDay;
    let editServiceSpecial = document.getElementById("confirm_service_special").textContent;
    document.getElementById("service_special").value = editServiceSpecial;
    let editRoomSpecial = document.getElementById("confirm_room_special").textContent;
    document.getElementById("room_special").value = editRoomSpecial;
    displayName = '';
    displayAddress = '';
}
// function showCustomer() {
//     let name = prompt('nhâp tên');
//     let i = 0;
//     while (i < arrInfoCustomer.length) {
//         if (arrInfoCustomer[i] === name) {
//             alert("Họ và tên:" + arrInfoCustomer[i] + "\n" + "Số CMND:" + arrInfoCustomer[i+1] + "\n" + "Ngày tháng năm sinh:" +
//                 arrInfoCustomer[i+2] + "\n" + "Email:" + arrInfoCustomer[i+3] + "\n" + "Đia chỉ:" + arrInfoCustomer[i+4] + "\n" +
//             "Loại Customer:" + arrInfoCustomer[i+5] + "\n" + "");
//             break;
//         } else {
//             i++;
//         }
//     }
// }

