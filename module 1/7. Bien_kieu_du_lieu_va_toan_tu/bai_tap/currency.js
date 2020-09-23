
function doiTien() {
    let input = document.getElementById("amount").value;
    let from = document.getElementById("fromCurrency").value;
    let to = document.getElementById("toCurrency").value;
    let tranfres;
    let same = parseInt(input);
    if (from === to) {
        tranfres = same
    }
    if (from === "VN" && to === "USD") {
        tranfres = same / 23000;
    }
    if (from === "USD" && to === "VN") {
        tranfres = 23000 * same;
    }
    document.getElementById("amount").value = tranfres;
}



