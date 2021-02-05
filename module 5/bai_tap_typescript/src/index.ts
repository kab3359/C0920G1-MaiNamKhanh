// happy coding 👻
function submitAbc(){
    console.log("Start");
    // @ts-ignore
    let nameSearch: string = document.getElementById("search").value;
    let promiseObj = new Promise((resolve, reject) => {
        let xHttp = new XMLHttpRequest();
        xHttp.onload = function () {
            if (this.status == 200) {
                resolve(xHttp.responseText);
            }
            else {
                reject(xHttp.statusText);
            }
        };
        xHttp.open("GET", 'https://api.github.com/search/repositories?q=' + nameSearch);
        xHttp.send();
    });
    promiseObj.then(value => {
        console.log("OK");
        console.log(value);
        if (typeof value === "string") {
            let obj = JSON.parse(value);
            console.log(obj.items);
            console.log(obj.items.length)
        }
        // @ts-ignore

        if (typeof value === "string") {
            // @ts-ignore
            document.getElementById("display").innerHTML = value;
        }
        console.log("End");
    }, reason => {
        console.log("NG");
        console.log(reason);
    });
}

