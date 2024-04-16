public enum Gender {
    MALE("male"), FEMALE("female");

    private final String person;

    Gender(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }
}
