package com.squareup.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: TagMap.java */
/* loaded from: classes.dex */
abstract class o<T> {
    private static final Comparator<? super Map.Entry<Integer, ?>> b = new p();

    /* renamed from: a, reason: collision with root package name */
    List<T> f4862a;

    public abstract T a(int i);

    public abstract boolean b(int i);

    public static <T> o<T> a(Map<Integer, T> map) {
        int b2 = b(map);
        return a(map.size(), b2) ? a.a(map, b2) : b.b((Map) map);
    }

    private static boolean a(int i, int i2) {
        return i2 <= 64 || ((float) i) / ((float) i2) > 0.75f;
    }

    private static <T> int b(Map<Integer, T> map) {
        int i = -1;
        Iterator<Integer> it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().intValue();
                if (i <= i2) {
                    i = i2;
                }
            } else {
                return i2;
            }
        }
    }

    private static <T> List<T> c(Map<Integer, T> map) {
        TreeSet treeSet = new TreeSet(b);
        treeSet.addAll(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    protected o(Map<Integer, T> map) {
        this.f4862a = c(map);
    }

    public Collection<T> a() {
        return this.f4862a;
    }

    /* compiled from: TagMap.java */
    /* loaded from: classes.dex */
    static final class a<T> extends o<T> {
        Object[] b;
        int c;

        public static <T> a<T> a(Map<Integer, T> map, int i) {
            return new a<>(map, i);
        }

        private a(Map<Integer, T> map, int i) {
            super(map);
            this.c = -1;
            this.c = i;
            this.b = new Object[i + 1];
            for (Map.Entry<Integer, T> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (key.intValue() <= 0) {
                    throw new IllegalArgumentException("Input map key is negative or zero");
                }
                this.b[key.intValue()] = entry.getValue();
            }
        }

        @Override // com.squareup.wire.o
        public T a(int i) {
            if (i > this.c) {
                return null;
            }
            return (T) this.b[i];
        }

        @Override // com.squareup.wire.o
        public boolean b(int i) {
            return i <= this.c && this.b[i] != null;
        }
    }

    /* compiled from: TagMap.java */
    /* loaded from: classes.dex */
    static final class b<T> extends o<T> {
        Map<Integer, T> b;

        public static <T> b<T> b(Map<Integer, T> map) {
            return new b<>(map);
        }

        private b(Map<Integer, T> map) {
            super(map);
            this.b = map;
        }

        @Override // com.squareup.wire.o
        public T a(int i) {
            return this.b.get(Integer.valueOf(i));
        }

        @Override // com.squareup.wire.o
        public boolean b(int i) {
            return this.b.containsKey(Integer.valueOf(i));
        }
    }
}
