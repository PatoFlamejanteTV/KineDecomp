package com.bumptech.glide.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class i<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f8510a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f8511b;

    /* renamed from: c */
    private long f8512c;

    /* renamed from: d */
    private long f8513d;

    public i(long j) {
        this.f8511b = j;
        this.f8512c = j;
    }

    public synchronized Y a(T t) {
        return this.f8510a.get(t);
    }

    protected void a(T t, Y y) {
    }

    public int b(Y y) {
        return 1;
    }

    public synchronized long b() {
        return this.f8512c;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f8510a.remove(t);
        if (remove != null) {
            this.f8513d -= b(remove);
        }
        return remove;
    }

    public void a() {
        a(0L);
    }

    public synchronized Y b(T t, Y y) {
        long b2 = b(y);
        if (b2 >= this.f8512c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f8513d += b2;
        }
        Y put = this.f8510a.put(t, y);
        if (put != null) {
            this.f8513d -= b(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        c();
        return put;
    }

    public synchronized void a(long j) {
        while (this.f8513d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f8510a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f8513d -= b(value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    private void c() {
        a(this.f8512c);
    }
}
