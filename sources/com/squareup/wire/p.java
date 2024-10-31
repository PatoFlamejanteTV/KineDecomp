package com.squareup.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TagMap.java */
/* loaded from: classes3.dex */
public abstract class p<T> {

    /* renamed from: a */
    private static final Comparator<? super Map.Entry<Integer, ?>> f25725a = new o();

    /* renamed from: b */
    List<T> f25726b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TagMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends p<T> {

        /* renamed from: c */
        Object[] f25727c;

        /* renamed from: d */
        int f25728d;

        private a(Map<Integer, T> map, int i) {
            super(map);
            this.f25728d = -1;
            this.f25728d = i;
            this.f25727c = new Object[i + 1];
            for (Map.Entry<Integer, T> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (key.intValue() > 0) {
                    this.f25727c[key.intValue()] = entry.getValue();
                } else {
                    throw new IllegalArgumentException("Input map key is negative or zero");
                }
            }
        }

        public static <T> a<T> a(Map<Integer, T> map, int i) {
            return new a<>(map, i);
        }

        @Override // com.squareup.wire.p
        public T b(int i) {
            if (i > this.f25728d) {
                return null;
            }
            return (T) this.f25727c[i];
        }

        @Override // com.squareup.wire.p
        public boolean a(int i) {
            return i <= this.f25728d && this.f25727c[i] != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TagMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends p<T> {

        /* renamed from: c */
        Map<Integer, T> f25729c;

        private b(Map<Integer, T> map) {
            super(map);
            this.f25729c = map;
        }

        public static <T> b<T> b(Map<Integer, T> map) {
            return new b<>(map);
        }

        @Override // com.squareup.wire.p
        public boolean a(int i) {
            return this.f25729c.containsKey(Integer.valueOf(i));
        }

        @Override // com.squareup.wire.p
        public T b(int i) {
            return this.f25729c.get(Integer.valueOf(i));
        }
    }

    protected p(Map<Integer, T> map) {
        this.f25726b = c(map);
    }

    public static <T> p<T> a(Map<Integer, T> map) {
        int b2 = b(map);
        if (a(map.size(), b2)) {
            return a.a(map, b2);
        }
        return b.b((Map) map);
    }

    private static boolean a(int i, int i2) {
        return i2 <= 64 || ((float) i) / ((float) i2) > 0.75f;
    }

    private static <T> int b(Map<Integer, T> map) {
        Iterator<Integer> it = map.keySet().iterator();
        int i = -1;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue > i) {
                i = intValue;
            }
        }
        return i;
    }

    private static <T> List<T> c(Map<Integer, T> map) {
        TreeSet treeSet = new TreeSet(f25725a);
        treeSet.addAll(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    public abstract boolean a(int i);

    public abstract T b(int i);

    public Collection<T> a() {
        return this.f25726b;
    }
}
