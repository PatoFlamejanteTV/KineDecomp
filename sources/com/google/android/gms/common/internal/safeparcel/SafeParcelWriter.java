package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    private static void b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i | (i2 << 16));
        }
    }

    private static void c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void d(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, 0);
            }
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i) {
        c(parcel, i);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    private static int b(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            b(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void c(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeStringList(list);
            c(parcel, b2);
        }
    }

    public static void b(Parcel parcel, int i, List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcel parcel2 = list.get(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i, int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, float f2) {
        b(parcel, i, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int i, Float f2, boolean z) {
        if (f2 != null) {
            b(parcel, i, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, double d2) {
        b(parcel, i, 8);
        parcel.writeDouble(d2);
    }

    public static void a(Parcel parcel, int i, Double d2, boolean z) {
        if (d2 != null) {
            b(parcel, i, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeString(str);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeBundle(bundle);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeByteArray(bArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeBooleanArray(zArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeIntArray(iArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeLongArray(jArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeFloatArray(fArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeDoubleArray(dArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.writeStringArray(strArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        c(parcel, b2);
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, i2);
            }
        }
        c(parcel, b2);
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int b2 = b(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            c(parcel, b2);
        }
    }
}
