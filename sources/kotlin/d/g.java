package kotlin.d;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public class g extends f {
    public static <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        kotlin.jvm.internal.h.b(aVar, "seedFunction");
        kotlin.jvm.internal.h.b(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
