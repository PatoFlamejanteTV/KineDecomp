package kotlin.d;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class b<T> implements c<T> {

    /* renamed from: a */
    private final kotlin.jvm.a.a<T> f28527a;

    /* renamed from: b */
    private final kotlin.jvm.a.b<T, T> f28528b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        kotlin.jvm.internal.h.b(aVar, "getInitialValue");
        kotlin.jvm.internal.h.b(bVar, "getNextValue");
        this.f28527a = aVar;
        this.f28528b = bVar;
    }

    @Override // kotlin.d.c
    public Iterator<T> iterator() {
        return new a(this);
    }
}
