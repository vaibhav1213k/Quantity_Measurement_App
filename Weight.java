
import com.example.weight.WeightUnit;


public class Weight {
    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double toBase() {
        return unit.toBase(value);
    }

    public Weight convertTo(WeightUnit targetUnit) {
        double baseValue = toBase();
        double targetValue = targetUnit.fromBase(baseValue);
        return new Weight(targetValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Weight other = (Weight) obj;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

        // Addition with no target unit - result in unit1
        public static Weight addition(Weight w1, Weight w2) {
            Weight convertedW2 = w2.convertTo(w1.unit);
            double combinedValue = w1.value + convertedW2.value;
            return new Weight(combinedValue, w1.unit);
        }

        // Addition with target unit - result in specified unit
        public static Weight addition(Weight w1, Weight w2, WeightUnit targetUnit) {
            if (w1 == null || w2 == null) {
                throw new IllegalArgumentException("Weight inputs cannot be null");
            }
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }
            Weight sum = addition(w1, w2);
            return sum.convertTo(targetUnit);
        }
}
