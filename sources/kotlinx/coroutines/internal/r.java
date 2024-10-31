package kotlinx.coroutines.internal;

import android.support.v7.widget.ActivityChooserView;

/* compiled from: SystemProps.kt */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a */
    private static final int f28656a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f28656a;
    }

    public static final String a(String str) {
        kotlin.jvm.internal.h.b(str, "propertyName");
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final boolean a(String str, boolean z) {
        kotlin.jvm.internal.h.b(str, "propertyName");
        try {
            String property = System.getProperty(str);
            return property != null ? Boolean.parseBoolean(property) : z;
        } catch (SecurityException unused) {
            return z;
        }
    }

    public static /* synthetic */ int a(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return a(str, i, i2, i3);
    }

    public static final int a(String str, int i, int i2, int i3) {
        kotlin.jvm.internal.h.b(str, "propertyName");
        return (int) a(str, i, i2, i3);
    }

    public static /* synthetic */ long a(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return a(str, j, j4, j3);
    }

    public static final long a(String str, long j, long j2, long j3) {
        Long b2;
        kotlin.jvm.internal.h.b(str, "propertyName");
        String a2 = a(str);
        if (a2 == null) {
            return j;
        }
        b2 = kotlin.text.u.b(a2);
        if (b2 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a2 + '\'').toString());
        }
        long longValue = b2.longValue();
        if (j2 <= longValue && j3 >= longValue) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }
}
