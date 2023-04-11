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

    public class PersonTest {

        @Test
        public void testAgeExists() throws Exception {
            try {
                Field ageField = Person.class.getDeclaredField("age");
                assertNotNull(ageField);
                assertTrue(ageField.getType().equals(int.class));
            } catch (Exception e) {
                fail("accountNumber not found");
            }
        }

        @Test
        public void testNameExists() throws Exception {
            try {
                Field nameField = Person.class.getDeclaredField("name");
                assertNotNull(nameField);
                assertTrue(nameField.getType().equals(String.class));
            } catch (Exception e) {
                fail("accountNumber not found");
            }
        }

        @Test
        public void testConstructorExists() throws Exception {
            try {
                Class<?>[] parameterTypes = {int.class, String.class};
                Constructor<Person> constructor = Person.class.getDeclaredConstructor(parameterTypes);
                assertNotNull(constructor);
            } catch (Exception e) {
                fail("accountNumber not found");
            }
        }

        @Test
        public void testConstructorSignature() throws Exception {
            try {
                Class<?>[] parameterTypes = {int.class, String.class};
                Constructor<Person> constructor = Person.class.getDeclaredConstructor(parameterTypes);
                assertNotNull(constructor);
                assertEquals(int.class, constructor.getParameterTypes()[0]);
                assertEquals(String.class, constructor.getParameterTypes()[1]);
            } catch (Exception e) {
                fail("accountNumber not found");
            }
        }

    @Test
    public void testConstructor() throws Exception {
       try {
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
        } catch (Exception e) {
            fail("accountNumber not found");
        }
    }

}
