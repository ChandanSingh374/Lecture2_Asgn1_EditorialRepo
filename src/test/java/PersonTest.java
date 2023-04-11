import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;


//    @Test
//    public void testConstructor() {
//        Person person = new Person(25, "John");
//        assertNotNull(person);
//    }
//
//    @Test
//    public void testPersonAge() throws Exception {
//        Person person = new Person(25, "John");
//        Field ageField = Person.class.getDeclaredField("age");
//        ageField.setAccessible(true);
//        int age = ageField.getInt(person);
//        assertEquals(25, age);
//    }
    public class PersonTest {

        @Test
        public void testAgeExists() throws NoSuchFieldException {
            Field ageField = Person.class.getDeclaredField("age");
            assertNotNull(ageField);
            assertTrue(ageField.getType().equals(int.class));
        }

        @Test
        public void testNameExists() throws NoSuchFieldException {
            Field nameField = Person.class.getDeclaredField("name");
            assertNotNull(nameField);
            assertTrue(nameField.getType().equals(String.class));
        }

        @Test
        public void testConstructorExists() throws NoSuchMethodException {
            Class<?>[] parameterTypes = {int.class, String.class};
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(parameterTypes);
            assertNotNull(constructor);
        }

        @Test
        public void testConstructorSignature() throws NoSuchMethodException {
            Class<?>[] parameterTypes = {int.class, String.class};
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(parameterTypes);
            assertNotNull(constructor);
            assertEquals(int.class, constructor.getParameterTypes()[0]);
            assertEquals(String.class, constructor.getParameterTypes()[1]);
        }

    @Test
    public void testConstructor() throws Exception {
        Class<?> personClass = Class.forName("Person");

        // check if constructor with age and name parameters exist
        Constructor<?> constructor = personClass.getConstructor(int.class, String.class);

        // check if age data member exists
        Field ageField = personClass.getDeclaredField("age");

        // check if name data member exists
        Field nameField = personClass.getDeclaredField("name");

        // create an instance of Person using the constructor
        Object person = ((Constructor<?>) constructor).newInstance(25, "John Doe");

        // check if the age value is set correctly
        ageField.setAccessible(true);
        int age = (int) ageField.get(person);
        assertEquals(25, age);

        // check if the name value is set correctly
        nameField.setAccessible(true);
        String name = (String) nameField.get(person);
        assertEquals("John Doe", name);
    }

}

