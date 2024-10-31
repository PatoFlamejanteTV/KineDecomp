package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.zi */
/* loaded from: classes2.dex */
final class C1182zi<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f12704a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f12705b;

    /* renamed from: c */
    private final /* synthetic */ C1154xi f12706c;

    private C1182zi(C1154xi c1154xi) {
        List list;
        this.f12706c = c1154xi;
        list = this.f12706c.f12661b;
        this.f12704a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f12705b == null) {
            map = this.f12706c.f12665f;
            this.f12705b = map.entrySet().iterator();
        }
        return this.f12705b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f12704a;
        if (i > 0) {
            list = this.f12706c.f12661b;
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
        list = this.f12706c.f12661b;
        int i = this.f12704a - 1;
        this.f12704a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1182zi(C1154xi c1154xi, C1168yi c1168yi) {
        this(c1154xi);
    }
}
