package com.nexstreaming.app.general.expression;

/* compiled from: CommonFunctionHandler.java */
/* loaded from: classes.dex */
public class a implements ad {
    @Override // com.nexstreaming.app.general.expression.ad
    public Object a(String str, Object... objArr) {
        int i;
        int i2 = 1;
        if (str.equals("min")) {
            if (objArr.length < 1) {
                return null;
            }
            double doubleValue = ((Number) objArr[0]).doubleValue();
            int intValue = ((Number) objArr[0]).intValue();
            while (i2 < objArr.length) {
                doubleValue = Math.min(doubleValue, ((Number) objArr[0]).doubleValue());
                intValue = Math.min(intValue, ((Number) objArr[0]).intValue());
                i2++;
            }
            if (intValue == doubleValue) {
                return Integer.valueOf(intValue);
            }
            return Double.valueOf(doubleValue);
        }
        if (str.equals("max")) {
            if (objArr.length < 1) {
                return null;
            }
            double doubleValue2 = ((Number) objArr[0]).doubleValue();
            int intValue2 = ((Number) objArr[0]).intValue();
            double d = doubleValue2;
            while (true) {
                i = intValue2;
                if (i2 >= objArr.length) {
                    break;
                }
                d = Math.max(d, ((Number) objArr[0]).doubleValue());
                intValue2 = Math.max(i, ((Number) objArr[0]).intValue());
                i2++;
            }
            if (i == d) {
                return Integer.valueOf(i);
            }
            return Double.valueOf(d);
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (str.equals("sqrt")) {
                return Double.valueOf(Math.sqrt(((Number) obj).doubleValue()));
            }
            if (str.equals("cbrt")) {
                return Double.valueOf(Math.cbrt(((Number) obj).doubleValue()));
            }
            if (str.equals("abs")) {
                if (obj instanceof Integer) {
                    return Integer.valueOf(Math.abs(((Number) obj).intValue()));
                }
                return Double.valueOf(Math.sin(((Number) obj).doubleValue()));
            }
            if (str.equals("chr")) {
                return Character.toString((char) ((Number) obj).shortValue());
            }
            if (str.equals("len")) {
                return Integer.valueOf(obj.toString().length());
            }
            if (str.equals("ord")) {
                String obj2 = obj.toString();
                if (obj2.length() < 1) {
                    return 0;
                }
                return Integer.valueOf(obj2.charAt(0));
            }
            if (str.equals("sin")) {
                return Double.valueOf(Math.sin(((Number) obj).doubleValue()));
            }
            if (str.equals("sinh")) {
                return Double.valueOf(Math.sinh(((Number) obj).doubleValue()));
            }
            if (str.equals("cos")) {
                return Double.valueOf(Math.cos(((Number) obj).doubleValue()));
            }
            if (str.equals("cosh")) {
                return Double.valueOf(Math.cosh(((Number) obj).doubleValue()));
            }
            if (str.equals("ceil")) {
                return Double.valueOf(Math.ceil(((Number) obj).doubleValue()));
            }
            if (str.equals("floor")) {
                return Double.valueOf(Math.floor(((Number) obj).doubleValue()));
            }
            if (str.equals("tan")) {
                return Double.valueOf(Math.tan(((Number) obj).doubleValue()));
            }
            if (str.equals("tanh")) {
                return Double.valueOf(Math.tanh(((Number) obj).doubleValue()));
            }
            if (str.equals("asin")) {
                return Double.valueOf(Math.asin(((Number) obj).doubleValue()));
            }
            if (str.equals("acos")) {
                return Double.valueOf(Math.acos(((Number) obj).doubleValue()));
            }
            if (str.equals("atan")) {
                return Double.valueOf(Math.atan(((Number) obj).doubleValue()));
            }
            if (str.equals("exp")) {
                return Double.valueOf(Math.exp(((Number) obj).doubleValue()));
            }
            if (str.equals("log")) {
                return Double.valueOf(Math.log(((Number) obj).doubleValue()));
            }
            if (str.equals("log10")) {
                return Double.valueOf(Math.log10(((Number) obj).doubleValue()));
            }
            if (str.equals("log1p")) {
                return Double.valueOf(Math.log1p(((Number) obj).doubleValue()));
            }
            if (str.equals("int")) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (str.equals("double")) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (str.equals("str")) {
                return obj.toString();
            }
        } else if (objArr.length == 2) {
            Object obj3 = objArr[0];
            Object obj4 = objArr[1];
            if (str.equals("tan")) {
                return Double.valueOf(Math.atan2(((Number) obj3).doubleValue(), ((Number) obj4).doubleValue()));
            }
            if (str.equals("pow")) {
                return Double.valueOf(Math.pow(((Number) obj3).doubleValue(), ((Number) obj4).doubleValue()));
            }
        }
        return null;
    }
}
