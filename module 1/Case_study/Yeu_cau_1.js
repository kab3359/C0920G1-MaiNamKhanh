function myFunction() {
    let name = document.getElementById("name").value;
    let IDcard = document.getElementById("IDcard").value;
    let birthday = document.getElementById("birthday").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let customerSpecial = document.getElementById("customer_special").value;
    let discount = parseInt(document.getElementById("discount").value);
    let number = document.getElementById("number").value;
    let rentDay = parseInt(document.getElementById("rent_day").value);
    let serviceSpecial = document.getElementById("service_special").value;
    let roomSpecial = document.getElementById("room_special").value;
    let pay;
    document.getElementById("confirm_name").innerHTML = name;
    document.getElementById("confirm_IDcard").innerHTML = IDcard;
    document.getElementById("confirm_birthday").innerHTML = birthday;
    document.getElementById("confirm_email").innerHTML = email;
    document.getElementById("confirm_address").innerHTML = address;
    document.getElementById("confirm_customer_special").innerHTML = customerSpecial;
    document.getElementById("confirm_discount").innerHTML = discount;
    document.getElementById("confirm_number").innerHTML = number;
    document.getElementById("confirm_rent_day").innerHTML = rentDay;
    document.getElementById("confirm_service_special").innerHTML = serviceSpecial;
    document.getElementById("confirm_room_special").innerHTML = roomSpecial;
    if (serviceSpecial == "Villa") {
        pay = 500 * rentDay * (1 - discount / 100);
    } else if (serviceSpecial == "House") {
        pay = 300 * rentDay * (1 - discount / 100);
    } else {
        pay = 100 * rentDay * (1 - discount / 100);
    }
    document.getElementById("pay").innerHTML = pay;
}