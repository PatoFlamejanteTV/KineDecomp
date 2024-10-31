package android.support.v4.graphics;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;

/* loaded from: classes.dex */
public final class ColorUtils {

    /* renamed from: a */
    private static final ThreadLocal<double[]> f1126a = new ThreadLocal<>();

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float abs = (1.0f - Math.abs((f4 * 2.0f) - 1.0f)) * f3;
        float f5 = f4 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f2) / 60) {
            case 0:
                round = Math.round((abs + f5) * 255.0f);
                round2 = Math.round((abs2 + f5) * 255.0f);
                round3 = Math.round(f5 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round((abs + f5) * 255.0f);
                round3 = Math.round(f5 * 255.0f);
                break;
            case 2:
                round = Math.round(f5 * 255.0f);
                round2 = Math.round((abs + f5) * 255.0f);
                round3 = Math.round((abs2 + f5) * 255.0f);
                break;
            case 3:
                round = Math.round(f5 * 255.0f);
                round2 = Math.round((abs2 + f5) * 255.0f);
                round3 = Math.round((abs + f5) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round(f5 * 255.0f);
                round3 = Math.round((abs + f5) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f5) * 255.0f);
                round2 = Math.round(f5 * 255.0f);
                round3 = Math.round((abs2 + f5) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(a(round, 0, 255), a(round2, 0, 255), a(round3, 0, 255));
    }

    public static int LABToColor(double d2, double d3, double d4) {
        double[] a2 = a();
        LABToXYZ(d2, d3, d4, a2);
        return XYZToColor(a2[0], a2[1], a2[2]);
    }

    public static void LABToXYZ(double d2, double d3, double d4, double[] dArr) {
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = (d3 / 500.0d) + d5;
        double d7 = d5 - (d4 / 200.0d);
        double pow = Math.pow(d6, 3.0d);
        if (pow <= 0.008856d) {
            pow = ((d6 * 116.0d) - 16.0d) / 903.3d;
        }
        double pow2 = d2 > 7.9996247999999985d ? Math.pow(d5, 3.0d) : d2 / 903.3d;
        double pow3 = Math.pow(d7, 3.0d);
        if (pow3 <= 0.008856d) {
            pow3 = ((d7 * 116.0d) - 16.0d) / 903.3d;
        }
        dArr[0] = pow * 95.047d;
        dArr[1] = pow2 * 100.0d;
        dArr[2] = pow3 * 108.883d;
    }

    public static void RGBToHSL(int i, int i2, int i3, float[] fArr) {
        float f2;
        float abs;
        float f3 = i / 255.0f;
        float f4 = i2 / 255.0f;
        float f5 = i3 / 255.0f;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = Math.min(f3, Math.min(f4, f5));
        float f6 = max - min;
        float f7 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            abs = 0.0f;
        } else {
            f2 = max == f3 ? ((f4 - f5) / f6) % 6.0f : max == f4 ? ((f5 - f3) / f6) + 2.0f : ((f3 - f4) / f6) + 4.0f;
            abs = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (f2 * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = b(f8, 0.0f, 360.0f);
        fArr[1] = b(abs, 0.0f, 1.0f);
        fArr[2] = b(f7, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i, int i2, int i3, double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        if (dArr.length == 3) {
            double d2 = i;
            Double.isNaN(d2);
            double d3 = d2 / 255.0d;
            double pow = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = i2;
            Double.isNaN(d4);
            double d5 = d4 / 255.0d;
            double pow2 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            double d6 = i3;
            Double.isNaN(d6);
            double d7 = d6 / 255.0d;
            double pow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int XYZToColor(double d2, double d3, double d4) {
        double d5 = (((3.2406d * d2) + ((-1.5372d) * d3)) + ((-0.4986d) * d4)) / 100.0d;
        double d6 = ((((-0.9689d) * d2) + (1.8758d * d3)) + (0.0415d * d4)) / 100.0d;
        double d7 = (((0.0557d * d2) + ((-0.204d) * d3)) + (1.057d * d4)) / 100.0d;
        return Color.rgb(a((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), a((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), a((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(double d2, double d3, double d4, double[] dArr) {
        if (dArr.length == 3) {
            double a2 = a(d2 / 95.047d);
            double a3 = a(d3 / 100.0d);
            double a4 = a(d4 / 108.883d);
            dArr[0] = Math.max(0.0d, (116.0d * a3) - 16.0d);
            dArr[1] = (a2 - a3) * 500.0d;
            dArr[2] = (a3 - a4) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    private static int a(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static float b(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int blendARGB(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f3) + (Color.blue(i2) * f2)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f2, float[] fArr3) {
        if (fArr3.length == 3) {
            float f3 = 1.0f - f2;
            fArr3[0] = a(fArr[0], fArr2[0], f2);
            fArr3[1] = (fArr[1] * f3) + (fArr2[1] * f2);
            fArr3[2] = (fArr[2] * f3) + (fArr2[2] * f2);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d2, double[] dArr3) {
        if (dArr3.length == 3) {
            double d3 = 1.0d - d2;
            dArr3[0] = (dArr[0] * d3) + (dArr2[0] * d2);
            dArr3[1] = (dArr[1] * d3) + (dArr2[1] * d2);
            dArr3[2] = (dArr[2] * d3) + (dArr2[2] * d2);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = compositeColors(i, i2);
            }
            double calculateLuminance = calculateLuminance(i) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static double calculateLuminance(int i) {
        double[] a2 = a();
        colorToXYZ(i, a2);
        return a2[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(int i, int i2, float f2) {
        int i3 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        double d2 = f2;
        if (calculateContrast(setAlphaComponent(i, 255), i2) < d2) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
            int i6 = (i4 + i3) / 2;
            if (calculateContrast(setAlphaComponent(i, i6), i2) < d2) {
                i4 = i6;
            } else {
                i3 = i6;
            }
        }
        return i3;
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int a2 = a(alpha2, alpha);
        return Color.argb(a2, a(Color.red(i), alpha2, Color.red(i2), alpha, a2), a(Color.green(i), alpha2, Color.green(i2), alpha, a2), a(Color.blue(i), alpha2, Color.blue(i2), alpha, a2));
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static double a(double d2) {
        return d2 > 0.008856d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * 903.3d) + 16.0d) / 116.0d;
    }

    static float a(float f2, float f3, float f4) {
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (f2 + ((f3 - f2) * f4)) % 360.0f;
    }

    private static double[] a() {
        double[] dArr = f1126a.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        f1126a.set(dArr2);
        return dArr2;
    }
}
