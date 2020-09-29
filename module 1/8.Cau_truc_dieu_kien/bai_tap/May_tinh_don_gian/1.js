
let temp =false;
function clearNumber() {
    document.getElementById("num").value ="";
}
function inputNumber(number) {
    if(temp){
        if (number === "+" || number === "-" || number === "*" || number === "/"){
            document.getElementById("num").value += number
        }
        else{
            document.getElementById("num").value = number;
        }
    }
    else{
        document.getElementById("num").value += number
    }
    temp =false;
}
function calculator() {
    document.getElementById("num").value=(eval(document.getElementById("num").value))
    temp =true;
}
​
