public class QuantityMeasurement{

    public static class Feet{

        private final double FeetMeasurement;

        public Feet(double FeetMeasurement){
            this.FeetMeasurement = FeetMeasurement;

        }
        @Override
        public boolean equals(Object obj){

            if(this == obj){
                return true;
            }
            if(obj == null){
                return false;
            }
            // typecast to Feet
            Feet value2 = (Feet) obj; 

            // compare the values
             int res = Double.compare(this.FeetMeasurement,value2.FeetMeasurement);
             
             boolean result = false;
             if(res == 0){
                return true;
             }
             if(res != 0){
                return false;
             }
             return result; 
        }

        public static void DemonstrateFeetEquality(double val1, double val2)
             {
                Feet value1 = new Feet(val1);
                Feet value2 = new Feet(val2);
                
                 boolean res = value1.equals(value2);

                 if(res == true){
                    System.out.println("Feet Equal");
                 }
                 if(res !=  true){
                    System.out.println("Feet Not Equal");
                 }
             }

            
    }

// class inches
    public static class Inches{
            private final Double InchMeasurement;

            public Inches(Double InchMeasurement){
                this.InchMeasurement = InchMeasurement;
            }
            @Override
            public boolean equals(Object obj){
                if(obj == null){
                    return false;
                }
                if(this == obj){
                    return true;
                }

                Inches val2  = (Inches) obj;

                int res =  Double.compare(this.InchMeasurement,val2.InchMeasurement);

                if(res == 0){
                    return true;
                }
                return false;
            }
            public static void DemonstrateInchesEquality(double val1, double val2)
             {

                Inches value1 = new Inches(val1);
                Inches value2 = new Inches(val2);
                
                 boolean res = value1.equals(value2);

                 if(res == true){
                    System.out.println(" Inches Equal");
                 }
                 if(res !=  true){
                    System.out.println("Inches Not Equal");
                 }
        }

        public static void FeetToInch(double feetvalue, double InchValue){
            DemonstrateInchesEquality(feetvalue*12,InchValue);
            
        }
    }



    public static void main(String[] args){

        //Feet value1 = new Feet(10);
        //Feet value2 = new Feet(100);

        Feet.DemonstrateFeetEquality(11,11);
        Inches.DemonstrateInchesEquality(12,12);




    }
    
}