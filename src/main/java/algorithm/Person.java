package algorithm;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public Person() {
        this.name = "default";
        this.birthDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBirthDate() {
        return birthDate.getTime();
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}


