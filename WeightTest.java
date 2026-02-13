package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
import org.example.Length;
import org.example.LengthUnit;

public class WeightTest {

    @Test
    public void testEquality_KilogramToKilogram_sameValue() {
        Weight w1 = new Weight(5, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(5, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        Weight w1 = new Weight(5, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(6, WeightUnit.KILOGRAM);
        assertFalse(w1.equals(w2));
    }

    @Test
    public void testEquality_KilogramtoGram_Equivalent() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquality_KilogramtoGram_DifferentValue() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(900, WeightUnit.GRAM);
        assertFalse(w1.equals(w2));
    }

    @Test
    public void testEquality_GramToKilogram_Equivalent() {
        Weight w1 = new Weight(2000, WeightUnit.GRAM);
        Weight w2 = new Weight(2, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquility_WeightVsLength_Incompatible() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        Length l = new Length(1, LengthUnit.FEET);
        assertFalse(w.equals(l));
    }

    @Test
    public void testEquality_NullComparison() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        assertFalse(w.equals(null));
    }

    @Test
    public void testEqualtiy_SameReference() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        assertTrue(w.equals(w));
    }



    @Test
    public void testEquality_ZeroVlaue() {
        Weight w1 = new Weight(0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquilaty_NegativeWeight() {
        Weight w1 = new Weight(-1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(-1000, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquality_LargeWeightValue() {
        Weight w1 = new Weight(1e6, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1e9, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testEquilaty_SmallWeightValue() {
        Weight w1 = new Weight(0.001, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testConversion_PoundToKilogram() {
        Weight w = new Weight(2.20462, WeightUnit.POUND);
        Weight converted = w.convertTo(WeightUnit.KILOGRAM);
        assertEquals(1.0, converted.getValue(), 0.001);
    }

    @Test
    public void testKilogram_KilogrtamToPound() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        Weight converted = w.convertTo(WeightUnit.POUND);
        assertEquals(2.20462, converted.getValue(), 0.001);
    }

    @Test
    public void testConversion_SameUnit() {
        Weight w = new Weight(5, WeightUnit.KILOGRAM);
        Weight converted = w.convertTo(WeightUnit.KILOGRAM);
        assertEquals(5, converted.getValue(), 0.0);
    }

    @Test
    public void testConversionZeroVlaue() {
        Weight w = new Weight(0, WeightUnit.POUND);
        Weight converted = w.convertTo(WeightUnit.KILOGRAM);
        assertEquals(0, converted.getValue(), 0.0);
    }

    @Test
    public void testConverasion_NegativeValue() {
        Weight w = new Weight(-2, WeightUnit.KILOGRAM);
        Weight converted = w.convertTo(WeightUnit.POUND);
        assertEquals(-4.40924, converted.getValue(), 0.001);
    }

    @Test
    public void testConversion_RoundTrip() {
        Weight w = new Weight(3.5, WeightUnit.KILOGRAM);
        Weight converted = w.convertTo(WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM);
        assertEquals(3.5, converted.getValue(), 0.001);
    }

    @Test
    public void testAddition_SameUnit_KilpogramPlusKilogram() {
        Weight w1 = new Weight(2, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(3, WeightUnit.KILOGRAM);
        Weight sum = Weight.addition(w1, w2);
        assertEquals(5, sum.getValue(), 0.0);
        assertEquals(WeightUnit.KILOGRAM, sum.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        Weight w1 = new Weight(2, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(500, WeightUnit.GRAM);
        Weight sum = Weight.addition(w1, w2);
        assertEquals(2.5, sum.getValue(), 0.001);
        assertEquals(WeightUnit.KILOGRAM, sum.getUnit());
    }



    @Test
    public void testAddidtion_ExplicitTargetUnit_Kilogram() {
        Weight w1 = new Weight(1, WeightUnit.POUND);
        Weight w2 = new Weight(1, WeightUnit.KILOGRAM);
        Weight sum = Weight.addition(w1, w2, WeightUnit.KILOGRAM);
        assertEquals(1.45359, sum.getValue(), 0.001);
        assertEquals(WeightUnit.KILOGRAM, sum.getUnit());
    }

    @Test
    public void testAddidtion_WithZerro() {
        Weight w1 = new Weight(0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(0, WeightUnit.POUND);
        Weight sum = Weight.addition(w1, w2);
        assertEquals(0, sum.getValue(), 0.0);
    }

    @Test
    public void test_addition_NegativeValues() {
        Weight w1 = new Weight(-1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(-1000, WeightUnit.GRAM);
        Weight sum = Weight.addition(w1, w2);
        assertEquals(-2, sum.getValue(), 0.0);
    }

    @Test
    public void testAddition_LargeValues() {
        Weight w1 = new Weight(1e6, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(2e6, WeightUnit.KILOGRAM);
        Weight sum = Weight.addition(w1, w2);
        assertEquals(3e6, sum.getValue(), 1.0);
    }
}
