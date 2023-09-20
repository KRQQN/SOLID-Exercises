package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FinderTests {

    Person sue = new Person();
    Person greg = new Person();
    Person sarah = new Person();
    Person mike = new Person();

    @BeforeEach
    public void setup() {
        sue.name = "Sue";
        sue.birthDate = new Date(50, 0, 1);
        greg.name = "Greg";
        greg.birthDate = new Date(52, 5, 1);
        sarah.name = "Sarah";
        sarah.birthDate = new Date(82, 0, 1);
        mike.name = "Mike";
        mike.birthDate = new Date(79, 0, 1);
    }

    @Test
    void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.BIGGEST);
        assertNull(result.youngestPerson);
        assertNull(result.oldestPerson);
    }

    @Test
    void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.BIGGEST);
        assertNull(result.youngestPerson);
        assertNull(result.oldestPerson);
    }

    @Test
    void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.SMALLEST);
        assertEquals(sue, result.youngestPerson);
        assertEquals(greg, result.oldestPerson);
    }

    @Test
    void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.BIGGEST);
        assertEquals(greg, result.youngestPerson);
        assertEquals(mike, result.oldestPerson);
    }

    @Test
    void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.BIGGEST);
        assertEquals(sue, result.youngestPerson);
        assertEquals(sarah, result.oldestPerson);
    }

    @Test
    void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        PersonComparer personComparer = new PersonComparer(list);

        AgeCompare result = personComparer.Find(AgeDifference.BIGGEST);
        assertEquals(sue, result.youngestPerson);
        assertEquals(sarah, result.oldestPerson);
    }

}
