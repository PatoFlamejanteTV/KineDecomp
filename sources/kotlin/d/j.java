package kotlin.d;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class j<R> implements Iterator<R>, kotlin.jvm.internal.a.a {

    /* renamed from: a */
    private final Iterator<T> f28529a;

    /* renamed from: b */
    final /* synthetic */ k f28530b;

    public j(k kVar) {
        c cVar;
        this.f28530b = kVar;
        cVar = kVar.f28531a;
        this.f28529a = cVar.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f28529a.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        kotlin.jvm.a.b bVar;
        bVar = this.f28530b.f28532b;
        return (R) bVar.invoke(this.f28529a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
