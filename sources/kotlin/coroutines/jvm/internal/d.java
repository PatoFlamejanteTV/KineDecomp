package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.h;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final StackTraceElement a(BaseContinuationImpl baseContinuationImpl) {
        String str;
        h.b(baseContinuationImpl, "$this$getStackTraceElementImpl");
        c b2 = b(baseContinuationImpl);
        if (b2 == null) {
            return null;
        }
        a(1, b2.v());
        int c2 = c(baseContinuationImpl);
        int i = c2 < 0 ? -1 : b2.l()[c2];
        String a2 = f.f28520c.a(baseContinuationImpl);
        if (a2 == null) {
            str = b2.c();
        } else {
            str = a2 + '/' + b2.c();
        }
        return new StackTraceElement(str, b2.m(), b2.f(), i);
    }

    private static final c b(BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            h.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
