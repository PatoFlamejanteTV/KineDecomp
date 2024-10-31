package android.arch.persistence.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class i implements b.a.b.a.e, b.a.b.a.d {

    /* renamed from: a */
    static final TreeMap<Integer, i> f129a = new TreeMap<>();

    /* renamed from: b */
    private volatile String f130b;

    /* renamed from: c */
    final long[] f131c;

    /* renamed from: d */
    final double[] f132d;

    /* renamed from: e */
    final String[] f133e;

    /* renamed from: f */
    final byte[][] f134f;

    /* renamed from: g */
    private final int[] f135g;

    /* renamed from: h */
    final int f136h;
    int i;

    private i(int i) {
        this.f136h = i;
        int i2 = i + 1;
        this.f135g = new int[i2];
        this.f131c = new long[i2];
        this.f132d = new double[i2];
        this.f133e = new String[i2];
        this.f134f = new byte[i2];
    }

    public static i a(String str, int i) {
        synchronized (f129a) {
            Map.Entry<Integer, i> ceilingEntry = f129a.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                f129a.remove(ceilingEntry.getKey());
                i value = ceilingEntry.getValue();
                value.b(str, i);
                return value;
            }
            i iVar = new i(i);
            iVar.b(str, i);
            return iVar;
        }
    }

    private static void c() {
        if (f129a.size() <= 15) {
            return;
        }
        int size = f129a.size() - 10;
        Iterator<Integer> it = f129a.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    void b(String str, int i) {
        this.f130b = str;
        this.i = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // b.a.b.a.d
    public void f(int i) {
        this.f135g[i] = 1;
    }

    public void b() {
        synchronized (f129a) {
            f129a.put(Integer.valueOf(this.f136h), this);
            c();
        }
    }

    @Override // b.a.b.a.d
    public void b(int i, long j) {
        this.f135g[i] = 2;
        this.f131c[i] = j;
    }

    @Override // b.a.b.a.e
    public String a() {
        return this.f130b;
    }

    @Override // b.a.b.a.e
    public void a(b.a.b.a.d dVar) {
        for (int i = 1; i <= this.i; i++) {
            int i2 = this.f135g[i];
            if (i2 == 1) {
                dVar.f(i);
            } else if (i2 == 2) {
                dVar.b(i, this.f131c[i]);
            } else if (i2 == 3) {
                dVar.a(i, this.f132d[i]);
            } else if (i2 == 4) {
                dVar.a(i, this.f133e[i]);
            } else if (i2 == 5) {
                dVar.a(i, this.f134f[i]);
            }
        }
    }

    @Override // b.a.b.a.d
    public void a(int i, double d2) {
        this.f135g[i] = 3;
        this.f132d[i] = d2;
    }

    @Override // b.a.b.a.d
    public void a(int i, String str) {
        this.f135g[i] = 4;
        this.f133e[i] = str;
    }

    @Override // b.a.b.a.d
    public void a(int i, byte[] bArr) {
        this.f135g[i] = 5;
        this.f134f[i] = bArr;
    }
}
