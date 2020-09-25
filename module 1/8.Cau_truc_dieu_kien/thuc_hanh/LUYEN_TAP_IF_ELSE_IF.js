let userName = prompt("Who's there?");
if (userName == "Admin") {
    let passWord = prompt("Nhập password");
    if (passWord == "TheMaster") {
        alert("Welcome");
    } else if (passWord == "Null") {
        alert("Canceled");
    } else {
        alert("Wrong password");
    }
} else if (userName == "Null") {
    alert("canceld");
} else {
    alert("I dont know you");
}