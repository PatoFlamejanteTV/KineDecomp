package kotlin.jvm.internal;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <T> Iterator<T> a(T[] tArr) {
        h.b(tArr, "array");
        return new a(tArr);
    }
}
