package org.example;
public enum LengthUnit {
    FEET(12.0),
    Inches(1.0),
    YARD(36.0),
    CM(1.0 / 2.54);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double fromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
