package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class Aa<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f12763a;

    /* renamed from: b */
    private boolean f12764b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f12765c;

    /* renamed from: d */
    private final /* synthetic */ C1223sa f12766d;

    private Aa(C1223sa c1223sa) {
        this.f12766d = c1223sa;
        this.f12763a = -1;
    }

    public /* synthetic */ Aa(C1223sa c1223sa, C1225ta c1225ta) {
        this(c1223sa);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f12765c == null) {
            map = this.f12766d.f12888c;
            this.f12765c = map.entrySet().iterator();
        }
        return this.f12765c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f12763a + 1;
        list = this.f12766d.f12887b;
        if (i >= list.size()) {
            map = this.f12766d.f12888c;
            if (map.isEmpty() || !b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> next;
        List list2;
        this.f12764b = true;
        int i = this.f12763a + 1;
        this.f12763a = i;
        list = this.f12766d.f12887b;
        if (i < list.size()) {
            list2 = this.f12766d.f12887b;
            next = (Map.Entry<K, V>) list2.get(this.f12763a);
        } else {
            next = b().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f12764b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f12764b = false;
        this.f12766d.f();
        int i = this.f12763a;
        list = this.f12766d.f12887b;
        if (i >= list.size()) {
            b().remove();
            return;
        }
        C1223sa c1223sa = this.f12766d;
        int i2 = this.f12763a;
        this.f12763a = i2 - 1;
        c1223sa.c(i2);
    }
}
