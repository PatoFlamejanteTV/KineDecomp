package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class Fi<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f11532a;

    /* renamed from: b */
    private boolean f11533b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f11534c;

    /* renamed from: d */
    private final /* synthetic */ C1154xi f11535d;

    private Fi(C1154xi c1154xi) {
        this.f11535d = c1154xi;
        this.f11532a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f11534c == null) {
            map = this.f11535d.f12662c;
            this.f11534c = map.entrySet().iterator();
        }
        return this.f11534c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f11532a + 1;
        list = this.f11535d.f12661b;
        if (i >= list.size()) {
            map = this.f11535d.f12662c;
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
        this.f11533b = true;
        int i = this.f11532a + 1;
        this.f11532a = i;
        list = this.f11535d.f12661b;
        if (i >= list.size()) {
            return b().next();
        }
        list2 = this.f11535d.f12661b;
        return (Map.Entry) list2.get(this.f11532a);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f11533b) {
            this.f11533b = false;
            this.f11535d.f();
            int i = this.f11532a;
            list = this.f11535d.f12661b;
            if (i < list.size()) {
                C1154xi c1154xi = this.f11535d;
                int i2 = this.f11532a;
                this.f11532a = i2 - 1;
                c1154xi.c(i2);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ Fi(C1154xi c1154xi, C1168yi c1168yi) {
        this(c1154xi);
    }
}
