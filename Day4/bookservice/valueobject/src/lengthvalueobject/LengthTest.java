package lengthvalueobject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthTest {


    @Test
    public void testValueOfLength(){

    Length length= new Length(1.0, "inch");
    Length length1= new Length(1.0, "inch");

    assertEquals(length, length1);
    }

    @Test
    public void testValueConversionOfCmToInch(){
        Length length= new Length(1.0, "inch");
        Length length1= new Length(2.5, "cm");
        assertEquals(length, length1);
    }

    @Test
    public void testValueConversionOfInchToCm(){
        Length length= new Length(2.5, "cm");
        Length length1= new Length(1.0, "inch");
        assertEquals(length, length1);
    }

    @Test
    public void testValueConversionForHigherValues(){
        Length length= new Length(7.5, "cm");
        Length length1= new Length(3.0, "inch");
        assertEquals(length, length1);
    }

}

