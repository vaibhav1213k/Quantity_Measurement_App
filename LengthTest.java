package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import static sun.jvm.hotspot.gc.shared.CollectedHeapName.EPSILON;

public class  LengthTest {
    private static final double EPSILON = 1e-3;
    @Test
    void testEquality_FetttoFeet_sameValue() {
        Length len1 = new Length(1.0, LengthUnit.FEET);
        Length len2 = new Length(1.0, LengthUnit.FEET);
        boolean result = len1.equals(len2);
        assertTrue(result, "Expected 1 FEET to be equal to 1 FEET");
    }

    @Test
    void testEquality_InchToInch_sameValue() {
        Length len1 = new Length(1.0, LengthUnit.Inches);
        Length len2 = new Length(1.0, LengthUnit.Inches);

        boolean result = len1.equals(len2);

        assertTrue(result, "Expected 1 INCH to be equal to 1 INCH");
    }

    @Test
    void test_Equality_NullComparison() {

        Length len = new Length(1.0, LengthUnit.FEET);

        assertFalse(len.equals(null), "Expected equals(null) to return false");
    }

    @Test
    void testEquality_12InchEquals1Feet_symmetry() {
        Length lenInInch = new Length(12.0, LengthUnit.Inches);
        Length lenInFeet = new Length(1.0, LengthUnit.FEET);

        assertTrue(lenInInch.equals(lenInFeet));
        assertTrue(lenInFeet.equals(lenInInch));
    }


    @Test
    void testEquality_InchToInch_DifferentValue() {

        Length len1 = new Length(10.0, LengthUnit.Inches);
        Length len2 = new Length(12.0, LengthUnit.Inches);
        boolean result = len1.equals(len2);


        assertFalse(result, "Expected 10 INCHES to NOT be equal to 12 INCHES");
    }

    @Test
    void TesteEquality_NullComparson() {
        Length len = new Length(1.0, LengthUnit.FEET);

        boolean result = len.equals(null);

        assertFalse(result, "Expected equals(null) to return false");
    }

    @Test
    void testEquality_FeetToFeet_sameValue() {
        Length len1 = new Length(1.0, LengthUnit.FEET);
        Length len2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(len1.equals(len2), "Expected 1 FEET to be equal to 1 FEET");
    }


    @Test
    void testEquality_InchToInch_differentValue() {
        Length len1 = new Length(10.0, LengthUnit.Inches);
        Length len2 = new Length(12.0, LengthUnit.Inches);

        assertFalse(len1.equals(len2), "Expected 10 Inches to NOT be equal to 12 Inches");
    }

    @Test
    void testEquality_FeetToInch_12InchEquals1Feet() {
        Length lenInInch = new Length(12.0, LengthUnit.Inches);
        Length lenInFeet = new Length(1.0, LengthUnit.FEET);

        assertTrue(lenInFeet.equals(lenInInch), "Expected 1 FEET to be equal to 12 Inches");
    }

    @Test
    void testEquality_FeetToInch_symmetry_12InchEquals1Feet() {
        Length lenInInch = new Length(12.0, LengthUnit.Inches);
        Length lenInFeet = new Length(1.0, LengthUnit.FEET);

        assertTrue(lenInInch.equals(lenInFeet), "Expected 12 Inches to be equal to 1 FEET");
        assertTrue(lenInFeet.equals(lenInInch), "Expected symmetry for equals()");
    }

    @Test
    void testEquality_NullComparison() {
        Length len = new Length(1.0, LengthUnit.FEET);

        assertFalse(len.equals(null), "Expected equals(null) to return false");
    }
    @Test
    void testEquality_YardToYard_sameValue() {
        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(1.0, LengthUnit.YARD);

        assertTrue(len1.equals(len2), "Expected 1 YARD to be equal to 1 YARD");
    }

    @Test
    void testEquality_YardToFeet_equivalentValue() {
        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(3.0, LengthUnit.FEET);

        assertTrue(len1.equals(len2), "Expected 1 YARD to be equal to 3 FEET");
        assertTrue(len2.equals(len1), "Expected symmetry: 3 FEET equals 1 YARD");
    }

    @Test
    void testEquality_YardToInches_equivalentValue() {

        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(36.0, LengthUnit.Inches);

        assertTrue(len1.equals(len2), "Expected 1 YARD to be equal to 36 Inches");
        assertTrue(len2.equals(len1), "Expected symmetry: 36 Inches equals 1 YARD");
    }



    @Test
    void testEquality_CmToCm_sameValue() {
        Length len1 = new Length(50.0, LengthUnit.CM);
        Length len2 = new Length(50.0, LengthUnit.CM);

        assertTrue(len1.equals(len2), "Expected 50 CM to be equal to 50 CM");
    }

    @Test
    void testEquality_CmToInches_equivalentValue() {
        // 2.54 cm = 1 inch
        Length len1 = new Length(2.54, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.Inches);

        assertFalse(len1.equals(len2), "Expected 2.54 CM to be equal to 1 Inch");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 Inch equals 2.54 CM");
    }

    @Test
    void testEquality_CmToFeet_equivalentValue() {
        // 1 foot = 12 inches = 30.48 cm
        Length len1 = new Length(30.48, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(len1.equals(len2), "Expected 30.48 CM to be equal to 1 FEET");
        assertTrue(len2.equals(len1), "Expected symmetry: 1 FEET equals 30.48 CM");
    }

    @Test
    void testEquality_CmToYard_equivalentValue() {
        // 1 yard = 91.44 cm
        Length len1 = new Length(91.44, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.YARD);

        assertFalse(len1.equals(len2), "Expected 91.44 CM to be equal to 1 YARD");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 YARD equals 91.44 CM");
    }




    @Test
    void testEquality_YardToYard_differentValue() {
        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(2.0, LengthUnit.YARD);

        assertFalse(len1.equals(len2), "Expected 1 YARD to NOT be equal to 2 YARD");
    }

    @Test
    void testEquality_YardToFeet_notEquivalentValue() {

        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(len1.equals(len2), "Expected 1 YARD to NOT be equal to 2 FEET");
        assertFalse(len2.equals(len1), "Expected symmetry: 2 FEET to NOT equal 1 YARD");
    }

    @Test
    void testEquality_YardToInches_notEquivalentValue() {

        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(35.0, LengthUnit.Inches);

        assertFalse(len1.equals(len2), "Expected 1 YARD to NOT be equal to 35 Inches");
        assertFalse(len2.equals(len1), "Expected symmetry: 35 Inches to NOT equal 1 YARD");
    }

    @Test
    void testEquality_YardToCm_notEquivalentValue() {
        // 1 yard = 91.44 cm, so comparing with 90 cm must be false
        Length len1 = new Length(1.0, LengthUnit.YARD);
        Length len2 = new Length(90.0, LengthUnit.CM);

        assertFalse(len1.equals(len2), "Expected 1 YARD to NOT be equal to 90 CM");
        assertFalse(len2.equals(len1), "Expected symmetry: 90 CM to NOT equal 1 YARD");
    }


    @Test
    void testEquality_CmToCm_differentValue() {
        Length len1 = new Length(50.0, LengthUnit.CM);
        Length len2 = new Length(49.0, LengthUnit.CM);

        assertFalse(len1.equals(len2), "Expected 50 CM to NOT be equal to 49 CM");
    }

    @Test
    void testEquality_CmToInches_notEquivalentValue() {
        // 2.54 cm = 1 inch, so 2.0 cm must NOT equal 1 inch
        Length len1 = new Length(2.0, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.Inches);

        assertFalse(len1.equals(len2), "Expected 2.0 CM to NOT be equal to 1 Inch");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 Inch to NOT equal 2.0 CM");
    }

    @Test
    void testEquality_CmToFeet_notEquivalentValue() {
        // 30.48 cm = 1 foot, so 30 cm must NOT equal 1 foot
        Length len1 = new Length(30.0, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.FEET);

        assertFalse(len1.equals(len2), "Expected 30.0 CM to NOT be equal to 1 FEET");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 FEET to NOT equal 30.0 CM");
    }

    @Test
    void testEquality_CmToYard_notEquivalentValue() {
        // 91.44 cm = 1 yard, so 92 cm must NOT equal 1 yard
        Length len1 = new Length(92.0, LengthUnit.CM);
        Length len2 = new Length(1.0, LengthUnit.YARD);

        assertFalse(len1.equals(len2), "Expected 92.0 CM to NOT be equal to 1 YARD");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 YARD to NOT equal 92.0 CM");
    }



    //  uc 7
    /* 1. Explicit target unit: FEET */
    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, l2, LengthUnit.FEET);

        assertEquals(2.0, result.value, EPSILON);
    }

    /* 2. Explicit target unit: INCHES */
    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, l2, LengthUnit.Inches);

        assertEquals(24.0, result.value, EPSILON);
    }

    /* 3. Explicit target unit: YARDS */
    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, l2, LengthUnit.YARD);

        assertEquals(0.667, result.value, EPSILON);
    }

    /* 4. Explicit target unit: CENTIMETERS */
    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        Length l1 = new Length(1.0, LengthUnit.Inches);
        Length l2 = new Length(1.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, l2, LengthUnit.CM);

        assertEquals(5.08, result.value, EPSILON);
    }

    /* 5. Target unit same as first operand */
    @Test
    void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length l1 = new Length(2.0, LengthUnit.YARD);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length result = Length.Addition(l1, l2, LengthUnit.YARD);

        assertEquals(3.0, result.value, EPSILON);
    }

    /* 6. Target unit same as second operand */
    @Test
    void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length l1 = new Length(2.0, LengthUnit.YARD);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length result = Length.Addition(l1, l2, LengthUnit.FEET);

        assertEquals(9.0, result.value, EPSILON);
    }

    /* 7. Commutativity with explicit target unit */
    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.Inches);

        Length r1 = Length.Addition(feet, inches, LengthUnit.YARD);
        Length r2 = Length.Addition(inches, feet, LengthUnit.YARD);

        assertEquals(r1.value, r2.value, EPSILON);
    }

    /* 8. Explicit target unit with zero */
    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, zero, LengthUnit.YARD);

        assertEquals(1.667, result.value, EPSILON);
    }

    /* 9. Explicit target unit with negative values */
    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(-2.0, LengthUnit.FEET);

        Length result = Length.Addition(l1, l2, LengthUnit.Inches);

        assertEquals(36.0, result.value, EPSILON);
    }

    /* 10. Null target unit */
    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);

        assertThrows(IllegalArgumentException.class,
                () -> Length.Addition(l1, l2, null));
    }

    /* 11. Large to small scale conversion */
    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length l1 = new Length(1000.0, LengthUnit.FEET);
        Length l2 = new Length(500.0, LengthUnit.FEET);

        Length result = Length.Addition(l1, l2, LengthUnit.Inches);

        assertEquals(18000.0, result.value, EPSILON);
    }

    /* 12. Small to large scale conversion */
    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length l1 = new Length(12.0, LengthUnit.Inches);
        Length l2 = new Length(12.0, LengthUnit.Inches);

        Length result = Length.Addition(l1, l2, LengthUnit.YARD);

        assertEquals(0.667, result.value, EPSILON);
    }

    /* 13. All unit combinations sanity test */
    @Test
    void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        for (LengthUnit target : LengthUnit.values()) {
            Length l1 = new Length(1.0, LengthUnit.FEET);
            Length l2 = new Length(12.0, LengthUnit.Inches);

            Length result = Length.Addition(l1, l2, target);

            assertNotNull(result);
        }
    }

    /* 14. Precision tolerance validation */
    @Test
    void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        Length l1 = new Length(0.1, LengthUnit.FEET);
        Length l2 = new Length(0.2, LengthUnit.FEET);

        Length result = Length.Addition(l1, l2, LengthUnit.FEET);

        assertEquals(0.3, result.value, EPSILON);
    }


    // uc 8

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertNotNull(LengthUnit.FEET);
        assertEquals(12.0, LengthUnit.FEET.toBaseUnit(1.0), EPSILON);
        assertEquals(1.0, LengthUnit.FEET.fromBaseUnit(12.0), EPSILON);
    }

    @Test
    void testLEngthUnitEnum_Inches() {
        assertNotNull(LengthUnit.Inches);
        assertEquals(1.0, LengthUnit.Inches.toBaseUnit(1.0), EPSILON);
        assertEquals(1.0, LengthUnit.Inches.fromBaseUnit(1.0), EPSILON);
    }

    @Test
    void testLengthUnitenum_InchesConstant() {
        assertNotNull(LengthUnit.Inches);
        assertEquals(12.0, LengthUnit.Inches.fromBaseUnit(12.0), EPSILON);
    }

    @Test
    void testLengthUnitenum_YardsConstant() {
        assertNotNull(LengthUnit.YARD);
        assertEquals(36.0, LengthUnit.YARD.toBaseUnit(1.0), EPSILON);
        assertEquals(1.0, LengthUnit.YARD.fromBaseUnit(36.0), EPSILON);
    }

    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        Length inches = new Length(12.0, LengthUnit.Inches);
        Length feet = Length.ConvertTo(inches, LengthUnit.FEET);
        assertEquals(1.0, feet.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToFeet() {
        Length yards = new Length(1.0, LengthUnit.YARD);
        Length feet = Length.ConvertTo(yards, LengthUnit.FEET);
        assertEquals(3.0, feet.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_CentimetersToFeet() {
        Length cm = new Length(30.48, LengthUnit.CM);
        Length feet = Length.ConvertTo(cm, LengthUnit.FEET);
        assertEquals(1.0, feet.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToFeet() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = Length.ConvertTo(feet, LengthUnit.FEET);
        assertEquals(1.0, result.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToInches() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = Length.ConvertTo(feet, LengthUnit.Inches);
        assertEquals(12.0, inches.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yards = Length.ConvertTo(feet, LengthUnit.YARD);
        assertEquals(1.0, yards.value, EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToCentimeters() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length cm = Length.ConvertTo(feet, LengthUnit.CM);
        assertEquals(30.48, cm.value, EPSILON);
    }

    @Test
    void testquantityLengthRefactored_Equality() {
        Length inches = new Length(12.0, LengthUnit.Inches);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(inches.equals(feet));
    }

    @Test
    void testQuantityLengthRefactored_onvertTo() {
        Length inches = new Length(24.0, LengthUnit.Inches);
        Length feet = Length.ConvertTo(inches, LengthUnit.FEET);
        assertEquals(2.0, feet.value, EPSILON);
    }

    @Test
    void testQuantityLengthRefactored_Add() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);
        Length result = Length.Addition(l1, l2);
        assertEquals(2.0, result.value, EPSILON);
        assertEquals(LengthUnit.FEET, result.unit);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.Inches);
        Length result = Length.Addition(l1, l2, LengthUnit.Inches);
        assertEquals(24.0, result.value, EPSILON);
        assertEquals(LengthUnit.Inches, result.unit);
    }

    @Test
    void testQuantityLengthRefactored_NullUnit() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> Length.ConvertTo(l1, null));
    }

    @Test
    void testQuantityLengthRefactored_InvalidValue() {
        Length l1 = new Length(-1.0, LengthUnit.FEET);
        Length inches = Length.ConvertTo(l1, LengthUnit.Inches);
        assertEquals(-12.0, inches.value, EPSILON);
    }

    @Test
    void testRoundTripconversion_RefactoredDesign() {
        Length original = new Length(100.0, LengthUnit.CM);
        Length inches = Length.ConvertTo(original, LengthUnit.Inches);
        Length roundTrip = Length.ConvertTo(inches, LengthUnit.CM);

        assertEquals(original.value, roundTrip.value, EPSILON);
    }

    @Test
    void testImmutability() {
        Length original = new Length(2.0, LengthUnit.FEET);
        Length converted = Length.ConvertTo(original, LengthUnit.Inches);
        Length sum = Length.Addition(original, new Length(12.0, LengthUnit.Inches));

        assertEquals(2.0, original.value, EPSILON);
        assertEquals(24.0, converted.value, EPSILON);
        assertEquals(3.0, sum.value, EPSILON);
    }
}






