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

public static void main(String[] args){
    Length len1 = new Length(1.0, LengthUnit.YARD);
    Length len2 = new Length(360.0, LengthUnit.Inches);
    System.out.println(len1.equals(len2));
}
}

