package android.support.v4.f;

import java.util.LinkedHashMap;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f80a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.f80a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V a(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.f80a.get(k);
            if (v2 != null) {
                this.g++;
                return v2;
            }
            this.h++;
            V b = b(k);
            if (b == null) {
                return null;
            }
            synchronized (this) {
                this.e++;
                v = (V) this.f80a.put(k, b);
                if (v != null) {
                    this.f80a.put(k, v);
                } else {
                    this.b += c(k, b);
                }
            }
            if (v != null) {
                a(false, k, b, v);
                return v;
            }
            a(this.c);
            return b;
        }
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.f80a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.b     // Catch: java.lang.Throwable -> L32
            if (r0 < 0) goto L11
            java.util.LinkedHashMap<K, V> r0 = r4.f80a     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L35
            int r0 = r4.b     // Catch: java.lang.Throwable -> L32
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
            int r0 = r4.b     // Catch: java.lang.Throwable -> L32
            if (r0 <= r5) goto L41
            java.util.LinkedHashMap<K, V> r0 = r4.f80a     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L43
        L41:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            return
        L43:
            java.util.LinkedHashMap<K, V> r0 = r4.f80a     // Catch: java.lang.Throwable -> L32
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L32
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L32
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L32
            java.util.LinkedHashMap<K, V> r2 = r4.f80a     // Catch: java.lang.Throwable -> L32
            r2.remove(r1)     // Catch: java.lang.Throwable -> L32
            int r2 = r4.b     // Catch: java.lang.Throwable -> L32
            int r3 = r4.c(r1, r0)     // Catch: java.lang.Throwable -> L32
            int r2 = r2 - r3
            r4.b = r2     // Catch: java.lang.Throwable -> L32
            int r2 = r4.f     // Catch: java.lang.Throwable -> L32
            int r2 = r2 + 1
            r4.f = r2     // Catch: java.lang.Throwable -> L32
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            r2 = 1
            r3 = 0
            r4.a(r2, r1, r0, r3)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.g.a(int):void");
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected V b(K k) {
        return null;
    }

    private int c(K k, V v) {
        int b = b(k, v);
        if (b < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return b;
    }

    protected int b(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        synchronized (this) {
            int i = this.g + this.h;
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
        }
        return format;
    }
}
