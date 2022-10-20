package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest { // создали тестовый класс

    private final String kindOfAnimal;
    private final List<String> expected; // создали поля тестового класса

    public AnimalTest(String kindOfAnimal, List<String> expected) {
        this.kindOfAnimal = kindOfAnimal;
        this.expected = expected; // создали конструктор тестового класса
    }

    @Parameterized.Parameters
    public static Object[] getListOfMealDataForHerbivoreAndPredator() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
                // передали тестовые данные
        };
    }

    @Test
    public void testOfAnimalGetFoodPositive() throws Exception {
        Animal animal = new Animal(); // создали экземпляр класса
        List<String> actual = animal.getFood(kindOfAnimal); // обратились к полям тестового класса
        assertEquals(expected, actual); // сравнили ожидаемый и фактический результат
    }

    @Test(expected = Exception.class)
    public void testOfAnimalGetFoodException() throws Exception {
        Animal animal = new Animal();
        String invalidKindOfAnimal = "неизвестно";
        Exception actualException = null;
        animal.getFood(invalidKindOfAnimal);
        Assert.assertNotNull(actualException);
    }


    @Test
    public void testOfAnimalGetFamily() {
        Animal animal = new Animal(); // создали экземпляр класса
        String actual = animal.getFamily(); // вызвали проверяемый метод
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }
}