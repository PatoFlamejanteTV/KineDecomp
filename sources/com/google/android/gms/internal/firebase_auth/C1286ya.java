package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.ya */
/* loaded from: classes2.dex */
final class C1286ya<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13094a;

    /* renamed from: b */
    private boolean f13095b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f13096c;

    /* renamed from: d */
    private final /* synthetic */ C1269pa f13097d;

    private C1286ya(C1269pa c1269pa) {
        this.f13097d = c1269pa;
        this.f13094a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13096c == null) {
            map = this.f13097d.f13068c;
            this.f13096c = map.entrySet().iterator();
        }
        return this.f13096c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f13094a + 1;
        list = this.f13097d.f13067b;
        if (i >= list.size()) {
            map = this.f13097d.f13068c;
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
        this.f13095b = true;
        int i = this.f13094a + 1;
        this.f13094a = i;
        list = this.f13097d.f13067b;
        if (i >= list.size()) {
            return b().next();
        }
        list2 = this.f13097d.f13067b;
        return (Map.Entry) list2.get(this.f13094a);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f13095b) {
            this.f13095b = false;
            this.f13097d.f();
            int i = this.f13094a;
            list = this.f13097d.f13067b;
            if (i < list.size()) {
                C1269pa c1269pa = this.f13097d;
                int i2 = this.f13094a;
                this.f13094a = i2 - 1;
                c1269pa.c(i2);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ C1286ya(C1269pa c1269pa, C1272ra c1272ra) {
        this(c1269pa);
    }
}
