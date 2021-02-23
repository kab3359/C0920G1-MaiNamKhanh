export class Student {
  id: number;
  name: string;
  dateOfBirth: string;
  /* 1: Male, 0: Female */
  gender: number;

  constructor(id: number, name: string, dateOfBirth: string, gender: number) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
  }
}
