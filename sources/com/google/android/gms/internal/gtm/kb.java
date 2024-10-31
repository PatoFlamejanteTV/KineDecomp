package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class kb<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13258a;

    /* renamed from: b */
    private boolean f13259b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f13260c;

    /* renamed from: d */
    private final /* synthetic */ C1297cb f13261d;

    private kb(C1297cb c1297cb) {
        this.f13261d = c1297cb;
        this.f13258a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13260c == null) {
            map = this.f13261d.f13218c;
            this.f13260c = map.entrySet().iterator();
        }
        return this.f13260c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f13258a + 1;
        list = this.f13261d.f13217b;
        if (i >= list.size()) {
            map = this.f13261d.f13218c;
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
        this.f13259b = true;
        int i = this.f13258a + 1;
        this.f13258a = i;
        list = this.f13261d.f13217b;
        if (i >= list.size()) {
            return b().next();
        }
        list2 = this.f13261d.f13217b;
        return (Map.Entry) list2.get(this.f13258a);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f13259b) {
            this.f13259b = false;
            this.f13261d.f();
            int i = this.f13258a;
            list = this.f13261d.f13217b;
            if (i < list.size()) {
                C1297cb c1297cb = this.f13261d;
                int i2 = this.f13258a;
                this.f13258a = i2 - 1;
                c1297cb.c(i2);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ kb(C1297cb c1297cb, C1300db c1300db) {
        this(c1297cb);
    }
}
