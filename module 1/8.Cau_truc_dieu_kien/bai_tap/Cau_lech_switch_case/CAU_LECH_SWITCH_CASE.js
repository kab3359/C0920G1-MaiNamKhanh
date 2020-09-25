function myFunction() {
    let date = parseInt(document.getElementById("date").value);
    switch (date) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            document.getElementById("result").innerHTML = "Tháng " + date + " có 31 ngày";
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            document.getElementById("result").innerHTML = "Tháng " + date + " có 30 ngày";
            break;
        case 2:
            document.getElementById("result").innerHTML = "Tháng " + date + " có 28 hoăc 29 ngày";
            break;
        default:
            document.getElementById("result").innerHTML = "Tháng " + date + " không có trong năm";
    }
}
