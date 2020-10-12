let customer = function () {
    this.setName = function (name) {
        let displayName = '';
        let inputName = name.trim();
        for (let n = 0; n < inputName.length; n++) {
            if (n === 0) {
                displayName += inputName[n].toUpperCase();
            } else {
                if (inputName[n-1] === " ") {
                    if (inputName[n] === " ") {
                        continue;
                    } else {
                        displayName += inputName[n].toUpperCase();
                    }
                } else {
                    displayName += inputName[n].toLowerCase();
                }
            }
        }
        this.name = displayName;
    }
    this.getName = function () {
        return this.name
    }
    this.setIDcard = function (IDcard) {
        let regexIDcard = /^[\d]{8,8}$/;
        let checkIDcard = false;
        do {
            if(regexIDcard.test(document.getElementById('IDcard').value)){
                checkIDcard = true
            } else {
                alert('CMND')
                break;
            }
        }while (!checkIDcard)
        if(checkIDcard){
            this.IDcard = IDcard;
        }
    }
    this.getIDcard = function () {
        return this.IDcard
    }
    this.setBirthday= function (Birthday) {
        let regexBirthday = /^\d{2}[./-]\d{2}[./-]\d{4}$/;
        let checkBirthday = false;
        do {
            if(regexBirthday.test(document.getElementById('birthday').value)){
                checkBirthday = true;
            } else {
                alert('SN')
                break;
            }
        }while (!checkBirthday)
        if(checkBirthday){
            this.Birthday = Birthday;
        }
    }
    this.getBirthday = function () {
        return this.Birthday
    }
    this.setEmail = function (Email) {
        let regexEmail = /\S+@\S+\.\S+/
        let checkEmail = false;
        do {
            if(regexEmail.test(document.getElementById('email').value)){
                checkEmail = true;
            } else {
                alert('Email')
                break;
            }
        } while (!checkEmail)
        if (checkEmail){
            this.Email = Email;
        }
    }
    this.getEmail = function () {
        return this.Email
    }
    this.setAddress = function (Address) {

        this.Address = Address;
    }
    this.getAddress = function () {
        return this.Address
    }
    this.setSpecialCustomer = function (SpecialCustomer) {
        this.SpecialCustomer = SpecialCustomer;
    }
    this.getSpecialCustomer = function () {
        return this.SpecialCustomer
    }
    this.setNumOfPerson = function (NumOfPerson) {
        let regexNumOfPerson = /^\d+$/
        let checkNumOfPerson = false
        do {
            if(regexNumOfPerson.test(document.getElementById('numOfPerson').value)){
                checkNumOfPerson = true;
            }else {
                alert('số')
                break;
            }
        }while (!checkNumOfPerson)
        if(checkNumOfPerson){
            this.NumOfPerson = NumOfPerson;
        }
    }
    this.getNumOfPerson = function () {
        return this.NumOfPerson
    }
    this.setRentDay = function (RentDay) {
        let regexRentDay = /^\d+$/
        let checkRentDay = false
        do {
            if(regexRentDay.test(document.getElementById('rentDay').value)){
                checkRentDay = true;
            } else {
                alert('Rentday')
                break;
            }
        }while (!checkRentDay)
        if(checkRentDay){
            this.RentDay = RentDay;
        }
    }
    this.getRentDay = function () {
        return this.RentDay
    }
    this.setSpecialService = function (SpecialService) {
        this.SpecialService = SpecialService;
    }
    this.getSpecialService = function () {
        return this.SpecialService
    }
    this.setSpecialRoom = function (SpecialRoom) {
        this.SpecialRoom = SpecialRoom;
    }
    this.getSpecialRoom = function () {
        return this.SpecialRoom
    }
    this.getDiscount = function () {
        let discount = 0;
        switch (this.getAddress()) {
            case 'Đà Nẵng': discount += 20;
                break;
            case 'Huế': discount += 10;
                break;
            case 'Quảng Nam': discount += 5;
                break;
        }
        if (this.getRentDay() >= 7) {
            discount += 30;
        } else if (this.getRentDay() >= 5) {
            discount += 20;
        } else if (this.getRentDay() >= 2) {
            discount += 10;
        }
        switch (this.getSpecialCustomer()) {
            case 'Diamond': discount += 15;
                break;
            case 'Platium': discount += 10;
                break;
            case 'Gold': discount += 5;
                break;
            case 'Silver': discount += 2;
                break;
        }
    }
    this.totalPay = function () {
        let money = 0;
        switch (this.getSpecialService()) {
            case 'Villa': money = 500;
                break;
            case 'House': money = 300;
                break;
            case 'Room': money = 100;
                break;
        }
        return money * this.getRentDay() - this.getDiscount()
    }
}