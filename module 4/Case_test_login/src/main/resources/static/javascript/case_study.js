let subjectObject = {
    "Đà Nẵng": {
        "Hải Châu": ["Hòa Cường", "Thanh Bình", "Bình Hiên"],
        "Sơn Trà": ["Nại Hiên", "An Hải Bắc", "Mân Thái"],
        "Thanh Khê": ["Xuân Hà", "Tam Thuận", "Thanh Khê Đông"]
    },
    "Hà Nội": {
        "Hai Bà Trưng": ["Bạch Đằng", "Bạch Mai", "Minh Khai"],
        "Hoàn Kiếm": ["Chương Dương", "Hàng Bông", "Trần Hưng Đạo"],
        "Ba Đình": ["Liễu Giai", "Trúc Bạch", "Đội Cấn"]
    },
    "Sài Gòn": {
        "Quận 1": ["Phường 1", "Phường 2", "Phường 3"],
        "Bình Thạnh": ["Phường 1", "Phường 2", "Phường 3"],
        "Tân Bình": ["Phường 1", "Phường 2", "Phường 3"]
    }
};

window.onload = function() {
    let subjectSel = document.getElementById("city");
    let topicSel = document.getElementById("district");
    let chapterSel = document.getElementById("ward");
    for (let x in subjectObject) {
        subjectSel.options[subjectSel.options.length] = new Option(x, x);
    }
    subjectSel.onchange = function() {
        //empty Chapters- and Topics- dropdowns
        chapterSel.length = 1;
        topicSel.length = 1;
        //display correct values
        for (let y in subjectObject[this.value]) {
            topicSel.options[topicSel.options.length] = new Option(y, y);
        }
    }
    topicSel.onchange = function() {
        //empty Chapters dropdown
        chapterSel.length = 1;
        //display correct values
        let z = subjectObject[subjectSel.value][this.value];
        for (let i = 0; i < z.length; i++) {
            chapterSel.options[chapterSel.options.length] = new Option(z[i], z[i]);
        }
    }
}