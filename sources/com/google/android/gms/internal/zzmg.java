package com.google.android.gms.internal;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class zzmg<K, V> {
    private int size;
    private final LinkedHashMap<K, V> zzagB;
    private int zzagC;
    private int zzagD;
    private int zzagE;
    private int zzagF;
    private int zzagG;
    private int zzagH;

    public zzmg(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zzagC = i;
        this.zzagB = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int zzc(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return sizeOf;
    }

    protected V create(K k) {
        return null;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final V get(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.zzagB.get(k);
            if (v2 != null) {
                this.zzagG++;
                return v2;
            }
            this.zzagH++;
            V create = create(k);
            if (create == null) {
                return null;
            }
            synchronized (this) {
                this.zzagE++;
                v = (V) this.zzagB.put(k, create);
                if (v != null) {
                    this.zzagB.put(k, v);
                } else {
                    this.size += zzc(k, create);
                }
            }
            if (v != null) {
                entryRemoved(false, k, create, v);
                return v;
            }
            trimToSize(this.zzagC);
            return create;
        }
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.zzagD++;
            this.size += zzc(k, v);
            put = this.zzagB.put(k, v);
            if (put != null) {
                this.size -= zzc(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.zzagC);
        return put;
    }

    public final synchronized int size() {
        return this.size;
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        synchronized (this) {
            int i = this.zzagG + this.zzagH;
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zzagC), Integer.valueOf(this.zzagG), Integer.valueOf(this.zzagH), Integer.valueOf(i != 0 ? (this.zzagG * 100) / i : 0));
        }
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.size     // Catch: java.lang.Throwable -> L32
            if (r0 < 0) goto L11
            java.util.LinkedHashMap<K, V> r0 = r4.zzagB     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L35
            int r0 = r4.size     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L35
        L11:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r1.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L32
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L32
        L32:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            throw r0
        L35:
            int r0 = r4.size     // Catch: java.lang.Throwable -> L32
            if (r0 <= r5) goto L41
            java.util.LinkedHashMap<K, V> r0 = r4.zzagB     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L43
        L41:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            return
        L43:
            java.util.LinkedHashMap<K, V> r0 = r4.zzagB     // Catch: java.lang.Throwable -> L32
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L32
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L32
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L32
            java.util.LinkedHashMap<K, V> r2 = r4.zzagB     // Catch: java.lang.Throwable -> L32
            r2.remove(r1)     // Catch: java.lang.Throwable -> L32
            int r2 = r4.size     // Catch: java.lang.Throwable -> L32
            int r3 = r4.zzc(r1, r0)     // Catch: java.lang.Throwable -> L32
            int r2 = r2 - r3
            r4.size = r2     // Catch: java.lang.Throwable -> L32
            int r2 = r4.zzagF     // Catch: java.lang.Throwable -> L32
            int r2 = r2 + 1
            r4.zzagF = r2     // Catch: java.lang.Throwable -> L32
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            r2 = 1
            r3 = 0
            r4.entryRemoved(r2, r1, r0, r3)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmg.trimToSize(int):void");
    }
}
