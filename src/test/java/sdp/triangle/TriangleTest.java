package sdp.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void triangleGetType_nonpositiveInput_throwException(){
        Triangle triangle = new Triangle(4, 4, -2);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, triangle::getType);

        String expectedMessage = "Triangle edge can't be non-positive";
        String message = exception.getMessage();

        Assertions.assertTrue(message.contains(expectedMessage));
    }

    @Test
    void triangleGetType_allZeroInput_throwException(){
        Triangle triangle = new Triangle(0, 0, 0);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, triangle::getType);

        String expectedMessage = "Triangle edge can't be non-positive";
        String message = exception.getMessage();

        Assertions.assertTrue(message.contains(expectedMessage));
    }

    @Test
    void triangleGetType_sideLongerThanTwoRemainingEdgesCombinedInput_throwException() {
        Triangle triangle = new Triangle(2, 5, 15);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, triangle::getType);

        String expectedMessage = "Triangle edge cannot be longer than sum of the remaining edges";
        String message = exception.getMessage();

        Assertions.assertTrue(message.contains(expectedMessage));
    }

    @Test
    void triangleGetType_allEdgesEqualInput_returnEquilateral(){
        Triangle triangle = new Triangle(7, 7, 7);

        Assertions.assertEquals(triangle.getType(), Triangle.TriangleType.EQUILATERAL);
    }

    @Test
    void triangleGetType_twoEdgesEqualInput_returnIsosceles(){
        Triangle triangle = new Triangle(7, 7, 13);

        Assertions.assertEquals(triangle.getType(), Triangle.TriangleType.ISOSCELES);
    }

    @Test
    void triangleGetType_allDifferentEdgesInput_returnScalene(){
        Triangle triangle = new Triangle(2, 3, 4);

        Assertions.assertEquals(triangle.getType(), Triangle.TriangleType.SCALENE);
    }
}
