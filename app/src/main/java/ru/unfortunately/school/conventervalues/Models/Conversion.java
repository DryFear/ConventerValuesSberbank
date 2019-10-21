package ru.unfortunately.school.conventervalues.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.unfortunately.school.conventervalues.R;

public enum Conversion {
    LENGHT(R.string.length, Arrays.asList(Units.METRE, Units.KILOMETRE, Units.MILLIMETRE, Units.FOOT, Units.MILE, Units.INCH)),
    AREA(R.string.area, Arrays.asList(Units.QUAD_METRE, Units.QUAD_KILOMETRE, Units.QUAD_MILLIMETRE, Units.HECTARE, Units.AKR)),
    WEIGHT(R.string.weight, Arrays.asList(Units.KILOGRAM, Units.MILLIGRAM, Units.GRAM, Units.POUND, Units.TON, Units.CENTNER)),
    VOLUME(R.string.volume, Arrays.asList(Units.KILOGRAM, Units.MILLIGRAM, Units.GRAM, Units.POUND, Units.TON, Units.CENTNER)),
    TEMPERATURE(R.string.temperature, Arrays.asList(Units.KILOGRAM, Units.MILLIGRAM, Units.GRAM, Units.POUND, Units.TON, Units.CENTNER)),
    DENSITY(R.string.density, Arrays.asList(Units.KILOGRAM, Units.MILLIGRAM, Units.GRAM, Units.POUND, Units.TON, Units.CENTNER));


    public final int mLabelRes;
    public final List<Units> units;


    Conversion(int labelName, List<Units> list) {
        mLabelRes = labelName;
        units = new ArrayList<>(list);

    }
}
