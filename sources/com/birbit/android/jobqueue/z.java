package com.birbit.android.jobqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: RunningJobSet.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a */
    private ArrayList<String> f8333a;

    /* renamed from: b */
    private final TreeSet<String> f8334b = new TreeSet<>();

    /* renamed from: c */
    private final Map<String, Long> f8335c = new HashMap();

    /* renamed from: d */
    private long f8336d = Long.MAX_VALUE;

    /* renamed from: e */
    private final com.birbit.android.jobqueue.i.b f8337e;

    public z(com.birbit.android.jobqueue.i.b bVar) {
        this.f8337e = bVar;
    }

    private long c() {
        long j = Long.MAX_VALUE;
        for (Long l : this.f8335c.values()) {
            if (l.longValue() < j) {
                j = l.longValue();
            }
        }
        return j;
    }

    public synchronized void a(String str, long j) {
        com.birbit.android.jobqueue.f.c.a("add group delay to %s until %s", str, Long.valueOf(j));
        Long l = this.f8335c.get(str);
        if (l == null || l.longValue() <= j) {
            this.f8335c.put(str, Long.valueOf(j));
            this.f8336d = c();
            this.f8333a = null;
        }
    }

    public synchronized Collection<String> b() {
        long b2 = this.f8337e.b();
        if (this.f8333a == null || b2 > this.f8336d) {
            if (this.f8335c.isEmpty()) {
                this.f8333a = new ArrayList<>(this.f8334b);
                this.f8336d = Long.MAX_VALUE;
            } else {
                TreeSet treeSet = new TreeSet((SortedSet) this.f8334b);
                Iterator<Map.Entry<String, Long>> it = this.f8335c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Long> next = it.next();
                    if (next.getValue().longValue() > b2) {
                        if (!treeSet.contains(next.getKey())) {
                            treeSet.add(next.getKey());
                        }
                    } else {
                        it.remove();
                    }
                }
                this.f8333a = new ArrayList<>(treeSet);
                this.f8336d = c();
            }
        }
        return this.f8333a;
    }

    public Long a() {
        long j = this.f8336d;
        if (j == Long.MAX_VALUE) {
            return null;
        }
        return Long.valueOf(j);
    }

    public synchronized void a(String str) {
        if (str == null) {
            return;
        }
        if (this.f8334b.add(str)) {
            this.f8333a = null;
        }
    }

    public synchronized void b(String str) {
        if (str == null) {
            return;
        }
        if (this.f8334b.remove(str)) {
            this.f8333a = null;
        }
    }
}
