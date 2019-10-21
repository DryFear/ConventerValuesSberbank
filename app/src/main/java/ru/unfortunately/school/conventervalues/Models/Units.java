package ru.unfortunately.school.conventervalues.Models;

import androidx.annotation.StringRes;
import ru.unfortunately.school.conventervalues.R;

public enum Units {
    KILOMETRE(R.string.kilometre, 1000,     0.001),
    METRE(R.string.metre, 1, 1),
    MILLIMETRE(R.string.millimetre, 0.001, 1000),
    MILE(R.string.mile, 1609.34, 0.000621371),
    FOOT(R.string.foot, 0.3048,3.28084),
    INCH(R.string.inch,0.0254, 39.3701),

    QUAD_METRE(R.string.quad_metre, 1, 1),
    QUAD_KILOMETRE(R.string.quad_kilometre, 1000000, 0.000001),
    QUAD_MILLIMETRE(R.string.quad_millimetre, 0.000001, 1000000),
    HECTARE(R.string.hectare, 10000, 0.0001),
    AKR(R.string.akre,4046.86, 0.000247105),

    KILOGRAM(R.string.kilogram, 1, 1),
    MILLIGRAM(R.string.milligram, 0.000001, 1000000),
    GRAM(R.string.gram, 0.001, 1000),
    TON(R.string.ton, 1000, 0.001),
    CENTNER(R.string.centner, 100, 0.01),
    POUND(R.string.pound, 2.20462, 0.453592);


    @StringRes
    public int mLabelRes;
    public double mConvertToBase;
    public double mConvertFromBase;

    Units(@StringRes int mLabelRes, double convertToBase, double convertFromBase){
        this.mLabelRes = mLabelRes;
        this.mConvertFromBase = convertFromBase;
        this.mConvertToBase = convertToBase;
    }
}
