package kotlin.c;

/* compiled from: _Ranges.kt */
/* loaded from: classes3.dex */
public class h extends g {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long a(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static int b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long b(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static b c(int i, int i2) {
        return b.f28499a.a(i, i2, -1);
    }

    public static d d(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return d.f28508f.a();
        }
        return new d(i, i2 - 1);
    }
}
