package kotlin.d;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class k<T, R> implements c<R> {

    /* renamed from: a */
    private final c<T> f28531a;

    /* renamed from: b */
    private final kotlin.jvm.a.b<T, R> f28532b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        kotlin.jvm.internal.h.b(cVar, "sequence");
        kotlin.jvm.internal.h.b(bVar, "transformer");
        this.f28531a = cVar;
        this.f28532b = bVar;
    }

    @Override // kotlin.d.c
    public Iterator<R> iterator() {
        return new j(this);
    }
}
