package test.sun.misc;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeSpec {


    class Person {
        String name;

        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }


    @Test
    public void unsafe() throws NoSuchFieldException, IllegalAccessException {


        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        Person person = new Person("orson", 28);

        long nameOffset = unsafe.objectFieldOffset(Person.class.getDeclaredField("name"));


        unsafe.compareAndSwapObject(person, nameOffset, "orson", "martin");


        System.out.println(person.getName());

    }
}
