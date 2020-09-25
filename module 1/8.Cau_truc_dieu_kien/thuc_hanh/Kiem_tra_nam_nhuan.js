let year = parseInt(prompt("Enter a year"));
if (year % 4 == 0) {
    if (year % 100 == 0) {
        if (year % 400 == 0) {
            alert(year + "is a leaf year");
        }else {
            alert(year + "is NOT a leaf year");
        }
    }else {
        alert(year + "is a leaf year");
    }
}else {
    alert(year + "is NOT a leaf year");
}