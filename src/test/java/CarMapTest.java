import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {

    private CarMap carMap;

    @Before
    public void setUp() throws Exception {
        //carMap = new CarMap();

    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSizeBecome10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "LastName" + index);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());
    }

    @Test
    public void removeReturnsTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "LastName5");
        assertTrue(carMap.remove(elementForDeleting));
        assertEquals(9,carMap.size());
        assertFalse(carMap.remove(elementForDeleting));
    }

    @Test
    public void removeOnTheBackOfMapReturnsTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());

        CarOwner elementForDeleting = new CarOwner(9, "Name9", "LastName9");
        assertTrue(carMap.remove(elementForDeleting));
        assertEquals(9,carMap.size());
        assertFalse(carMap.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOFValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
        assertEquals(100,carMap.values().size());
        assertEquals(100, carMap.keySet().size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }

        CarOwner key = new CarOwner(50, "Name50", "LastName50");
        Car value = carMap.get(key);
        String expectedBrand = "Brand50";
        assertEquals(expectedBrand, value.getBrand());
    }
}