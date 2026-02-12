package org.example;

public class Length{

    double value;
    LengthUnit unit;
    public Length(double value, LengthUnit unit){
        this.value = value;
        this.unit = unit;
    }

    // convert to inches
    public double convertToBaseUnit(){
        return this.unit.toBaseUnit(this.value);
    }
    public static double convertToBaseUnit(Length source){
        if (source == null) {
            throw new IllegalArgumentException("Source Length cannot be null");
        }
        return source.unit.toBaseUnit(source.value);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public static  Length ConvertTo(Length source, LengthUnit toUnit){
        if (source == null) {
            throw new IllegalArgumentException("Source Length cannot be null");
        }
        if (toUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        // convert to base inches - multiply conversion factor
        Double baseUnit = convertToBaseUnit(source);
        // convert to target  - divide by conversion factor
        Double TargetValue = toUnit.fromBaseUnit(baseUnit);

        return new Length(TargetValue, toUnit);
    }

    public static Length DemonstrateLengthConversion(Length source, LengthUnit toUnit){
        Length convertedLength = ConvertTo(source,toUnit);
        return convertedLength;
    }

    @Override
    public  boolean equals(Object obj){
        boolean boolResult = false;

        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        // typecasting
        Length val2 = (Length) obj;

        double value1 = this.convertToBaseUnit();
        double value2 = val2.convertToBaseUnit();

        int result = Double.compare(value1,value2);
        if(result == 0){
            boolResult = true;
        }
        return boolResult;
    }

    // feet inch - feet
    // addition with no target value - converted to length1 unit
    public static Length Addition(Length Length1, Length Length2){
        Length convertedLength2 = DemonstrateLengthConversion(Length2,Length1.unit);
        double combinedValue = Length1.value + convertedLength2.value;
        return new Length(combinedValue,Length1.unit);
    }

    // addition with target unit  - addition of 2 length converted to a target unit
    public static Length Addition(Length Length1, Length Length2, LengthUnit TargetUnit){
        if (Length1 == null || Length2 == null) {
            throw new IllegalArgumentException("Length inputs cannot be null");
        }
        if (TargetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        Length AdditionLength = Addition(Length1,Length2);
        Length ConvertedLength = DemonstrateLengthConversion(AdditionLength, TargetUnit);
        return ConvertedLength;
    }


    public static void main(String[] args) {

        Length len1 = new Length(100, LengthUnit.CM);
        Length len2 = new Length(36.0, LengthUnit.Inches);

//check if length is equal
        System.out.println("Equal? " + len1.equals(len2));
// conversion of length unit
        Length res = Length.DemonstrateLengthConversion(len1, LengthUnit.YARD);
        System.out.println(len1.toString() + " is " + res.toString());
// addition of 2 lengths
        System.out.println();
        System.out.println("Addition of 2 lengths:");
        Length result = Addition(len1, len2);
        System.out.println("Result = " + result.toString());
        System.out.println(len1.toString() + " + " + len2.toString() + " is : " + result.toString());

// addition of 2 length with target Unit
        System.out.println();
        System.out.println("Addition of 2 lengths with target unit:");
        Length resultWithTargetUnit = Addition(len1, len2,LengthUnit.CM);
        System.out.println("Result = " + resultWithTargetUnit.toString());
        System.out.println(len1.toString() + " + " + len2.toString() + " is : " + resultWithTargetUnit.toString());
    }
}

