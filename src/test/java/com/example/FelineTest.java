package com.example;
import org.junit.Test;

import java.util.List;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittenNumber;
    private final int expected;

    public FelineTest(int kittenNumber, int expected) {
        this.kittenNumber = kittenNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittenNumber() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {100, 100},
        };
    }

    @Test
    public void testOfFelineGetKittens() {
        Feline feline = new Feline(); // создали экземпляр класса
        int actual = feline.getKittens(kittenNumber); // вызвали проверяемый метод
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }

    @Test
    public void testOfFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void testOfFelineGetFamily() {
        Feline feline = new Feline(); // создали экземпляр класса
        String actual = feline.getFamily(); // вызвали проверяемый метод
        String expected = "Кошачьи";
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }

}