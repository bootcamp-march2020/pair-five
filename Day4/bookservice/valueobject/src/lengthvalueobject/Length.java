package lengthvalueobject;

import java.util.Objects;

public class Length {

   private final double value;
   private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;

        if(Objects.equals(unit, length.unit)){
            return Objects.equals(value, length.value) &&
                    Objects.equals(unit, length.unit);
        }else{
            if (length.unit.equals("cm")){
                return value==convertToInch(length.value);
            }else{
                return convertToInch(value)==(length.value);
            }
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    private double convertToInch(double cmValue){
        return cmValue/2.5;
    }
}
