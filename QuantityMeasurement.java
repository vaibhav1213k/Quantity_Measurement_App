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

    }



    public static void main(String[] args){

        Feet value1 = new Feet(10);
        Feet value2 = new Feet(100);

        boolean res = value1.equals(value2);

        System.out.println("Result : "+res);

    }
}