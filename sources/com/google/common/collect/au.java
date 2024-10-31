package com.google.common.collect;

import com.google.common.collect.LinkedHashMultimap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LinkedHashMultimap.java */
/* loaded from: classes2.dex */
class au<V> implements Iterator<V> {

    /* renamed from: a, reason: collision with root package name */
    LinkedHashMultimap.c<K, V> f2804a;
    LinkedHashMultimap.a<K, V> b;
    int c;
    final /* synthetic */ LinkedHashMultimap.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(LinkedHashMultimap.b bVar) {
        LinkedHashMultimap.c<K, V> cVar;
        int i;
        this.d = bVar;
        cVar = this.d.f;
        this.f2804a = cVar;
        i = this.d.e;
        this.c = i;
    }

    private void a() {
        int i;
        i = this.d.e;
        if (i != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return this.f2804a != this.d;
    }

    @Override // java.util.Iterator
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        LinkedHashMultimap.a<K, V> aVar = (LinkedHashMultimap.a) this.f2804a;
        V value = aVar.getValue();
        this.b = aVar;
        this.f2804a = aVar.b();
        return value;
    }

    @Override // java.util.Iterator
    public void remove() {
        LinkedHashMultimap.a[] aVarArr;
        LinkedHashMultimap.a[] aVarArr2;
        LinkedHashMultimap.a[] aVarArr3;
        a();
        Iterators.a(this.b != null);
        Object value = this.b.getValue();
        int a2 = ab.a(value != null ? value.hashCode() : 0);
        aVarArr = this.d.c;
        int length = a2 & (aVarArr.length - 1);
        aVarArr2 = this.d.c;
        LinkedHashMultimap.a aVar = aVarArr2[length];
        LinkedHashMultimap.a aVar2 = null;
        while (true) {
            if (aVar == null) {
                break;
            }
            if (aVar != this.b) {
                aVar2 = aVar;
                aVar = aVar.d;
            } else {
                if (aVar2 == null) {
                    aVarArr3 = this.d.c;
                    aVarArr3[length] = aVar.d;
                } else {
                    aVar2.d = aVar.d;
                }
                LinkedHashMultimap.a(this.b);
                LinkedHashMultimap.a((LinkedHashMultimap.a) this.b);
                LinkedHashMultimap.b.d(this.d);
                this.c = LinkedHashMultimap.b.e(this.d);
            }
        }
        this.b = null;
    }
}
