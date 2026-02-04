public class Length{

    double value;
    private LengthUnit unit;

    public enum LengthUnit{
        FEET(12.0),
        Inches(1.0),
        YARD(36.0),
        CM(1.0/2.54);
        
        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor = conversionFactor;
        }
        public double getConversionFactor(){
            return conversionFactor;
        }
        

    }
    public Length(double value, LengthUnit unit){
            this.value = value;
            this.unit = unit;
        }

    // convert to inches
    public double convertToBaseUnit(){
        return this.value*this.unit.getConversionFactor();
    }
    public static double convertToBaseUnit(Length source){      
        if (source == null) {
            throw new IllegalArgumentException("Source Length cannot be null");
        }
        return source.value*source.unit.getConversionFactor();
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
        Double TargetValue = baseUnit/toUnit.getConversionFactor();
        
        return new Length(TargetValue, toUnit);
    }

    public static Length DemonstrateLengthConversion(Length source, Length.LengthUnit toUnit){
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
    
    public static Length Addition(Length Length1, Length Length2){
        Length convertedLength2 = DemonstrateLengthConversion(Length2,Length1.unit);
        double combinedValue = Length1.value + convertedLength2.value;
        return new Length(combinedValue,Length1.unit);
    }


public static void main(String[] args) {

    Length len1 = new Length(100, LengthUnit.CM);
    Length len2 = new Length(36.0, LengthUnit.Inches);

    System.out.println("Equal? " + len1.equals(len2));

    Length res = Length.DemonstrateLengthConversion(len1, LengthUnit.YARD);
    System.out.println(len1.toString() + " is " + res.toString());

    System.out.println();
    System.out.println("Addition of 2 lengths:");

    Length result = Addition(len1, len2);
    System.out.println("Result = " + result.toString());
    System.out.println(len1.toString() + " + " + len2.toString() + " is : " + result.toString());
}
}

