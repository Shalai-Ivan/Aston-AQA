package org.shalai.ivan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class StudentsGroup {
    Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );
    enum Gender {
        MAN,
        WOMAN
    }
    public static class Student {
        private final String name;
        private final Integer age;
        private final Gender sex;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.sex = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getSex() {
            return sex;
        }
        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + sex +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(sex, student.sex);
        }
        @Override
        public int hashCode() {
            return  Objects.hash(name, age, sex);
        }
    }
}
