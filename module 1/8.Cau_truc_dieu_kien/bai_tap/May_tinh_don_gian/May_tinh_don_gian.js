let result = document.getElementById("input").value;
function input0() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '0';
        return result = '0';
    } else {
        document.getElementById("input").innerHTML= result + '0';
        return result = result + '0';
    }
}
function input1() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '1';
        return result = '1';
    } else {
        document.getElementById("input").innerHTML= result + '1';
        return result = result + '1';
    }
}
function input2() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '2';
        return result = '2';
    } else {
        document.getElementById("input").innerHTML= result + "2";
        return result = result + '2';
    }
}
function input3() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '3';
        return result = '3';
    } else {
        document.getElementById("input").innerHTML= result + 3;
        return result = result + '3';
    }
}
function input4() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '4';
        return result = '4';
    } else {
        document.getElementById("input").innerHTML= result + '4';
        return result = result + '4';
    }
}
function input5() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '5';
        return result = '5';
    } else {
        document.getElementById("input").innerHTML= result + '5';
        return result = result + '5';
    }
}
function input6() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '6';
        return result = '6';
    } else {
        document.getElementById("input").innerHTML= result + '6';
        return result = result + '6';
    }
}
function input7() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '7';
        return result = '7';
    } else {
        document.getElementById("input").innerHTML= result + '7';
        return result = result + '7';
    }
}
function input8() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '8';
        return result = '8';
    } else {
        document.getElementById("input").innerHTML= result + '8';
        return result = result + '8';
    }
}
function input9() {
    if (result == undefined) {
        document.getElementById("input").innerHTML= '9';
        return result = '9';
    } else {
        document.getElementById("input").innerHTML= result + '9';
        return result = result + '9';
    }
}
function inputc() {
    document.getElementById("input").innerHTML= "";
    return result = undefined;
}
function inputadd() {
    document.getElementById("input").innerHTML = result + '+';
    return result = result + '+';
    }
function inputsub() {
    document.getElementById("input").innerHTML = result + '-';
    return result = result + '-';
}
function inputdou() {
    document.getElementById("input").innerHTML = result + '*';
    return result = result + '*';
}
function inputdiv() {
    document.getElementById("input").innerHTML = result + '/';
    return result = result + '/';
}
function test() {
   let ketqua = eval(result);
   document.getElementById("input").innerHTML = ketqua;
}
