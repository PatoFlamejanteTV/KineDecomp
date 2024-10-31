package kotlin;

/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
public class f {
    public static <T> d<T> a(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.h.b(aVar, "initializer");
        kotlin.jvm.internal.f fVar = null;
        return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
    }
}
