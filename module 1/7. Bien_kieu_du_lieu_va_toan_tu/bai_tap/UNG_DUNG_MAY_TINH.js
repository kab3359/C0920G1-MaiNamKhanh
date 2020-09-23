function myFunctionAddition() {
    let num1 = parseInt(document.getElementById("num1").value) ;
    let num2 = parseInt(document.getElementById("num2").value) ;
    let num = num1 + num2
    document.getElementById("num").innerHTML = "result Addition:" + num ;
}
function myFunctionSubtraction() {
    let num1 = parseInt(document.getElementById("num1").value) ;
    let num2 = parseInt(document.getElementById("num2").value) ;
    let num = num1 - num2
    document.getElementById("num").innerHTML = "result Subtraction:" + num ;
}
function myFunctionMultiplication() {
    let num1 = parseInt(document.getElementById("num1").value) ;
    let num2 = parseInt(document.getElementById("num2").value) ;
    let num = num1 * num2
    document.getElementById("num").innerHTML = "result Multiplication:" + num ;
}
function myFunctionDivision() {
    let num1 = parseInt(document.getElementById("num1").value) ;
    let num2 = parseInt(document.getElementById("num2").value) ;
    let num = num1 / num2
    document.getElementById("num").innerHTML = "result Division:" + num ;
}