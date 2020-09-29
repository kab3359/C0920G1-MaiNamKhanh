function myFunction() {
    let name = document.getElementById("name").value;
    let IDcard = document.getElementById("IDcard").value;
    let birthday = document.getElementById("birthday").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let customerSpecial = document.getElementById("customer_special").value;
    let discount = 0;
    let number = document.getElementById("number").value;
    let rentDay = parseInt(document.getElementById("rent_day").value);
    let serviceSpecial = document.getElementById("service_special").value;
    let roomSpecial = document.getElementById("room_special").value;
    let pay;
    let run = false;
    document.getElementById("confirm_name").innerHTML = name;
    document.getElementById("name").value = '';
    document.getElementById("confirm_IDcard").innerHTML = IDcard;
    document.getElementById("IDcard").value = '';
    document.getElementById("confirm_birthday").innerHTML = birthday;
    document.getElementById("birthday").value = '';
    document.getElementById('confirm_email').innerHTML = email;
    document.getElementById("email").value = '';
    document.getElementById("confirm_address").innerHTML = address;
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
    switch (address) {
        case 'Đà Nẵng':
            discount += 20;
            break;
        case 'Huế':
            discount += 10;
            break;
        case 'Quảng Nam':
            discount += 5;
    }
    if (rentDay >= 7) {
        discount += 30;
    } else if (rentDay >= 5) {
        discount += 20;
    } else {
        discount += 10;
    }
    document.getElementById('confirm_discount').innerHTML = discount + '';
    if (serviceSpecial == "Villa") {
        pay = 500 * rentDay - discount;
    } else if (serviceSpecial == "House") {
        pay = 300 * rentDay - discount;
    } else {
        pay = 100 * rentDay - discount;
    }
    document.getElementById("pay").innerHTML = pay;

    //check email
    let first = ''; // nhận giá trị @
    let second = ''; // nhận giá trị .
    let i=0;
    let temp;
    while (i < email.length) {
        if (email[i] === '@') {
            if (first !== ''){
                temp = false;
                break;
            }else {
                first = i;
            }
        } if (email[i] === '.') {
            second = i;
        } i++;
    } if (first === 0 || second === (email.length - 1) || first === '' || second === '' || first > second || temp === false) {
        alert('email sai');
    } else {
        run = true;
    }

    //check CMND

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
}

// function myFunction() {
// let email = document.getElementById('email').value;
// let first = ''; // nhận giá trị @
// let second = ''; // nhận giá trị .
// let i=0;
// let temp;
// while (i < email.length) {
//     if (email[i] === '@') {
//         if (first !== ''){
//             temp = false;
//             break;
//         }else {
//             first = i;
//         }
//     } if (email[i] === '.') {
//             second = i;
//     } i++;
// } if (first === 0 || second === (email.length - 1) || first === '' || second === '' || first > second || temp === false) {
//     temp = false;
//     } else {
//    temp = true;
//     }
//     alert(temp);
// }

// function xoaKhoangTrang() {
//     let inputName = document.getElementById('name').value;
//     let name = inputName.trim();
//     let confirmName = '';
//     for (let i = 0; i < name.length; i++) {
//         if (i === 0) {
//             confirmName += name[i].toUpperCase();
//         } else {
//             if (name[i-1] === " ") {
//                 if (name[i] === " ") {
//                     continue;
//                 } else {
//                     confirmName += name[i].toUpperCase();
//                 }
//             } else {
//                 confirmName += name[i].toLowerCase();
//             }
//         }
//     }
//     alert(confirmName);
// }

// function checkID() {
//     let num = document.getElementById('number').value;
//     let i = 0;
//     let temp = false;
//     while (i < num.length) {
//         if (num[i] >=0 && num[i] <= 9) {
//             temp = true;
//             i++;
//         } else {
//             temp = false;
//             break;
//         }
//     } if (temp) {
//         alert('yes');
//     } else {
//         alert('no');
//     }
// }

