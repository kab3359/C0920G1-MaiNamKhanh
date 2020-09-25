function myFunction() {
    let inputPhysical = document.getElementById("physical").value;
    let inputChemical = document.getElementById("chemical").value;
    let inputBio = document.getElementById("bio").value;
    let physical = parseInt(inputPhysical);
    let chemical = parseInt(inputChemical);
    let bio = parseInt(inputBio);
    let sum = physical + chemical + bio;
    let average = sum/3;
    document.getElementById("sum").value = sum;
    document.getElementById("average").value = average;
}

function myFunction1() {
    let Celsius = parseInt(document.getElementById("Celsius").value);
    let Fahrenheit = Celsius * 9 / 5 + 32
    document.getElementById("Fahrenheit").value = Fahrenheit;
}

function myFunction2() {
    let radius = document.getElementById("radius").value;
    let perimiter = 2 * radius * 3.14;
    let acreage = radius * radius * 3.14;
    document.getElementById("perimiter").value = perimiter;
    document.getElementById("acreage").value = acreage;
}