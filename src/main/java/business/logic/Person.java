package business.logic;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person>{
    private Integer id;
    private String first;
    private String last;
    private LocalDate birthday;

    public Person(Integer id, String first, String last, LocalDate birthday) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.birthday = birthday;
    }

    public Person(String first, String last, LocalDate birthday) {
        this.first = first;
        this.last = last;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person person) {
        return last.compareTo(person.last);
    }

    public String getName() {
        return String.format("%s %s", first, last);
    }

    public Integer getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(first, person.first) &&
                Objects.equals(last, person.last) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", dob=" + birthday +
                '}';
    }
}
