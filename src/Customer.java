public class Customer {
    private final String name;
    private final int age;
    private final Gender gender;

    public Customer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name +
                "'" + ", age=" + age +
                ", gender='" + gender.getPerson() + "'" +
        "}";
    }
}
