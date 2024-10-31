package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class g<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int a2;
        Constructor constructor = (Constructor) t2;
        kotlin.jvm.internal.h.a((Object) constructor, "it");
        Integer valueOf = Integer.valueOf(constructor.getParameterTypes().length);
        Constructor constructor2 = (Constructor) t;
        kotlin.jvm.internal.h.a((Object) constructor2, "it");
        a2 = kotlin.a.b.a(valueOf, Integer.valueOf(constructor2.getParameterTypes().length));
        return a2;
    }
}
