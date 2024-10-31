package kotlin.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class a<T> implements Iterator<T>, kotlin.jvm.internal.a.a {

    /* renamed from: a */
    private T f28524a;

    /* renamed from: b */
    private int f28525b = -2;

    /* renamed from: c */
    final /* synthetic */ b f28526c;

    public a(b bVar) {
        this.f28526c = bVar;
    }

    private final void b() {
        kotlin.jvm.a.b bVar;
        T t;
        kotlin.jvm.a.a aVar;
        if (this.f28525b == -2) {
            aVar = this.f28526c.f28527a;
            t = (T) aVar.invoke();
        } else {
            bVar = this.f28526c.f28528b;
            T t2 = this.f28524a;
            if (t2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            t = (T) bVar.invoke(t2);
        }
        this.f28524a = t;
        this.f28525b = this.f28524a == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f28525b < 0) {
            b();
        }
        return this.f28525b == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f28525b < 0) {
            b();
        }
        if (this.f28525b != 0) {
            T t = this.f28524a;
            if (t != null) {
                this.f28525b = -1;
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
