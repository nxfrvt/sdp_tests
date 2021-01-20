package sdp.triangle;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle {

    private final int sideA, sideB, sideC;

    public TriangleType getType(){
        if(sideA <= 0 || sideB <= 0 || sideC <= 0){
            throw new IllegalArgumentException("Triangle edge can't be non-positive");
        }
        if(sideA + sideB <= sideC || sideB + sideC <= sideA || sideA + sideC <= sideB){
            throw new IllegalArgumentException("Triangle edge cannot be longer than sum of the remaining edges");
        }
        if(sideA == sideB && sideB == sideC){
            return TriangleType.EQUILATERAL;
        }
        else if (sideA == sideB || sideB == sideC || sideA == sideC){
            return TriangleType.ISOSCELES;
        }
        else { return TriangleType.SCALENE; }

    }

    public enum TriangleType{
        EQUILATERAL, ISOSCELES, SCALENE;
    }

}
