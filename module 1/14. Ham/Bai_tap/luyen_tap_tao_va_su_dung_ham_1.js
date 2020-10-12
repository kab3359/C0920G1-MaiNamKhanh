function  alertMessage() {
    alert("Xin chao");
}

function increasedBy1(num) {
    num = parseInt(num) +1;
    alert(num)
}

// function check(num1, num2) {
//     if (num1 > num2) {
//         alert('thông báo');
//     } else {
//         let sum = num1 + num2;
//         return sum;
//     }
// }
// let num1 = parseInt(prompt('số 1'));
// let num2 = parseInt(prompt('số 2'));
// let sum = check(num1, num2);
// alert(sum);

function addNumbers() {
    let firstNum = 4;
    let secondNum = 8;
    let result = firstNum + secondNum;
    return result;
}
result = 0;
alert(result);
result = addNumbers();
alert(result);

let arr1 = ['Polaris', 'Aldebaran', 'Deneb', 'Vega', 'Altair', 'Dubhe' , 'Regulus'];
let arr2 = ['Ursa Minor', 'Tarurus', 'Cygnus', 'Lyra', 'Aquila', 'Ursa Major' , 'Leo'];
let arr;
function search(arr) {
    arr = document.getElementById('name').value;
    for (let i=0; i<arr1.length; i++) {
        if (arr == arr1[i]) {
            alert(arr2[i]);
        }
    }
}