package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SafeParcelReader {

    /* loaded from: classes.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    public static int A(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer B(Parcel parcel, int i) {
        int E = E(parcel, i);
        if (E == 0) {
            return null;
        }
        a(parcel, i, E, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long C(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long D(Parcel parcel, int i) {
        int E = E(parcel, i);
        if (E == 0) {
            return null;
        }
        a(parcel, i, E, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int E(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    public static void F(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + E(parcel, i));
    }

    public static int a(int i) {
        return i & SupportMenu.USER_MASK;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int E = E(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(a2));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = E + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static BigInteger c(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + E);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + E);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + E);
        return createBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + E);
        return readBundle;
    }

    public static byte[] g(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + E);
        return createByteArray;
    }

    public static byte[][] h(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + E);
        return bArr;
    }

    public static double[] i(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + E);
        return createDoubleArray;
    }

    public static float[] j(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + E);
        return createFloatArray;
    }

    public static int[] k(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + E);
        return createIntArray;
    }

    public static ArrayList<Integer> l(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + E);
        return arrayList;
    }

    public static long[] m(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + E);
        return createLongArray;
    }

    public static Parcel n(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, E);
        parcel.setDataPosition(dataPosition + E);
        return obtain;
    }

    public static Parcel[] o(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + E);
        return parcelArr;
    }

    public static String p(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + E);
        return readString;
    }

    public static String[] q(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + E);
        return createStringArray;
    }

    public static ArrayList<String> r(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + E);
        return createStringArrayList;
    }

    public static void s(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static boolean t(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean u(Parcel parcel, int i) {
        int E = E(parcel, i);
        if (E == 0) {
            return null;
        }
        a(parcel, i, E, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double v(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double w(Parcel parcel, int i) {
        int E = E(parcel, i);
        if (E == 0) {
            return null;
        }
        a(parcel, i, E, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float x(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float y(Parcel parcel, int i) {
        int E = E(parcel, i);
        if (E == 0) {
            return null;
        }
        a(parcel, i, E, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static IBinder z(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + E);
        return readStrongBinder;
    }

    private static void a(Parcel parcel, int i, int i2) {
        int E = E(parcel, i);
        if (E == i2) {
            return;
        }
        String hexString = Integer.toHexString(E);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(E);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    private static void a(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + E);
        return createTypedArrayList;
    }

    public static BigDecimal a(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + E);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] b(Parcel parcel, int i) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + E);
        return bigDecimalArr;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + E);
        return createFromParcel;
    }

    public static <T> T[] b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int E = E(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (E == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + E);
        return tArr;
    }
}
