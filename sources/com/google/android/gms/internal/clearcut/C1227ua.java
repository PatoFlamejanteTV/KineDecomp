package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.ua */
/* loaded from: classes2.dex */
final class C1227ua<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f12895a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f12896b;

    /* renamed from: c */
    private final /* synthetic */ C1223sa f12897c;

    private C1227ua(C1223sa c1223sa) {
        List list;
        this.f12897c = c1223sa;
        list = this.f12897c.f12887b;
        this.f12895a = list.size();
    }

    public /* synthetic */ C1227ua(C1223sa c1223sa, C1225ta c1225ta) {
        this(c1223sa);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f12896b == null) {
            map = this.f12897c.f12891f;
            this.f12896b = map.entrySet().iterator();
        }
        return this.f12896b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f12895a;
        if (i > 0) {
            list = this.f12897c.f12887b;
            if (i <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> entry;
        if (b().hasNext()) {
            entry = b().next();
        } else {
            list = this.f12897c.f12887b;
            int i = this.f12895a - 1;
            this.f12895a = i;
            entry = (Map.Entry<K, V>) list.get(i);
        }
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
