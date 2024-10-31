package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class nb<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13494a;

    /* renamed from: b */
    private boolean f13495b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f13496c;

    /* renamed from: d */
    private final /* synthetic */ C1362fb f13497d;

    private nb(C1362fb c1362fb) {
        this.f13497d = c1362fb;
        this.f13494a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13496c == null) {
            map = this.f13497d.f13450c;
            this.f13496c = map.entrySet().iterator();
        }
        return this.f13496c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f13494a + 1;
        list = this.f13497d.f13449b;
        if (i >= list.size()) {
            map = this.f13497d.f13450c;
            if (map.isEmpty() || !b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.f13495b = true;
        int i = this.f13494a + 1;
        this.f13494a = i;
        list = this.f13497d.f13449b;
        if (i >= list.size()) {
            return b().next();
        }
        list2 = this.f13497d.f13449b;
        return (Map.Entry) list2.get(this.f13494a);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f13495b) {
            this.f13495b = false;
            this.f13497d.f();
            int i = this.f13494a;
            list = this.f13497d.f13449b;
            if (i < list.size()) {
                C1362fb c1362fb = this.f13497d;
                int i2 = this.f13494a;
                this.f13494a = i2 - 1;
                c1362fb.c(i2);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ nb(C1362fb c1362fb, C1365gb c1365gb) {
        this(c1362fb);
    }
}
