package c.d.b.m;

import java.util.Arrays;

/* compiled from: IntExtension.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final String a(int i, int i2) {
        kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
        String format = String.format("%dx%d", Arrays.copyOf(objArr, objArr.length));
        kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }
}
