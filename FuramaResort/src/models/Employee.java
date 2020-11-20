package models;

public class Employee {
    private String code;
    private String name;
    private String age;
    private String address;

    public Employee(String code, String name, String age, String address) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("ID='").append(code).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
