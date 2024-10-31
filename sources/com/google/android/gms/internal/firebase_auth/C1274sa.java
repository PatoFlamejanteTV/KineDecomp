package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.sa */
/* loaded from: classes2.dex */
final class C1274sa<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f13078a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f13079b;

    /* renamed from: c */
    private final /* synthetic */ C1269pa f13080c;

    private C1274sa(C1269pa c1269pa) {
        List list;
        this.f13080c = c1269pa;
        list = this.f13080c.f13067b;
        this.f13078a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13079b == null) {
            map = this.f13080c.f13071f;
            this.f13079b = map.entrySet().iterator();
        }
        return this.f13079b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f13078a;
        if (i > 0) {
            list = this.f13080c.f13067b;
            if (i <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (b().hasNext()) {
            return b().next();
        }
        list = this.f13080c.f13067b;
        int i = this.f13078a - 1;
        this.f13078a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1274sa(C1269pa c1269pa, C1272ra c1272ra) {
        this(c1269pa);
    }
}
