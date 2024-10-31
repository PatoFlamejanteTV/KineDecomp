package kotlin.collections;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class s<T> implements kotlin.d.c<T> {

    /* renamed from: a */
    final /* synthetic */ Iterable f28511a;

    public s(Iterable iterable) {
        this.f28511a = iterable;
    }

    @Override // kotlin.d.c
    public Iterator<T> iterator() {
        return this.f28511a.iterator();
    }
}
