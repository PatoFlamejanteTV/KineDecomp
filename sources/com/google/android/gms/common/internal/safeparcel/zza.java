package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class zza {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032zza extends RuntimeException {
        public C0032zza(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static BigDecimal[] A(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigDecimalArr;
    }

    public static String[] B(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> C(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a2);
        return arrayList;
    }

    public static ArrayList<String> D(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a2 + dataPosition);
        return createStringArrayList;
    }

    public static Parcel E(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a2);
        parcel.setDataPosition(a2 + dataPosition);
        return obtain;
    }

    public static Parcel[] F(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
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
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a2);
        return parcelArr;
    }

    public static int a(int i) {
        return 65535 & i;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(a2 + dataPosition);
        return createFromParcel;
    }

    private static void a(Parcel parcel, int i, int i2) {
        int a2 = a(parcel, i);
        if (a2 != i2) {
            throw new C0032zza("Expected size " + i2 + " got " + a2 + " (0x" + Integer.toHexString(a2) + ")", parcel);
        }
    }

    private static void a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0032zza("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static void a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(a2 + dataPosition);
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int a3 = a(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            throw new C0032zza("Expected object header. Got 0x" + Integer.toHexString(a2), parcel);
        }
        int i = dataPosition + a3;
        if (i < dataPosition || i > parcel.dataSize()) {
            throw new C0032zza("Size read is invalid start=" + dataPosition + " end=" + i, parcel);
        }
        return i;
    }

    public static void b(Parcel parcel, int i) {
        parcel.setDataPosition(a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(a2 + dataPosition);
        return tArr;
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a2 + dataPosition);
        return createTypedArrayList;
    }

    public static boolean c(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean d(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        if (a2 == 0) {
            return null;
        }
        a(parcel, i, a2, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte e(Parcel parcel, int i) {
        a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short f(Parcel parcel, int i) {
        a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int g(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer h(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        if (a2 == 0) {
            return null;
        }
        a(parcel, i, a2, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long i(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long j(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        if (a2 == 0) {
            return null;
        }
        a(parcel, i, a2, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger k(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a2 + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float l(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        if (a2 == 0) {
            return null;
        }
        a(parcel, i, a2, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double n(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal o(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a2 + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String p(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a2 + dataPosition);
        return readString;
    }

    public static IBinder q(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a2 + dataPosition);
        return readStrongBinder;
    }

    public static Bundle r(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a2 + dataPosition);
        return readBundle;
    }

    public static byte[] s(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createByteArray;
    }

    public static byte[][] t(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return (byte[][]) null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a2);
        return bArr;
    }

    public static boolean[] u(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createBooleanArray;
    }

    public static int[] v(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createIntArray;
    }

    public static long[] w(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] x(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigIntegerArr;
    }

    public static float[] y(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createFloatArray;
    }

    public static double[] z(Parcel parcel, int i) {
        int a2 = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a2 + dataPosition);
        return createDoubleArray;
    }
}
