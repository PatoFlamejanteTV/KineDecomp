package com.squareup.okhttp.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.s;
import okio.y;
import okio.z;

/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
public final class f implements Closeable {

    /* renamed from: a */
    static final Pattern f25164a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b */
    private static final y f25165b = new d();

    /* renamed from: c */
    private final com.squareup.okhttp.a.a.b f25166c;

    /* renamed from: d */
    private final File f25167d;

    /* renamed from: e */
    private final File f25168e;

    /* renamed from: f */
    private final File f25169f;

    /* renamed from: g */
    private final File f25170g;

    /* renamed from: h */
    private final int f25171h;
    private long i;
    private final int j;
    private okio.h l;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private final Executor s;
    private long k = 0;
    private final LinkedHashMap<String, b> m = new LinkedHashMap<>(0, 0.75f, true);
    private long r = 0;
    private final Runnable t = new com.squareup.okhttp.a.b(this);

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: a */
        private final b f25172a;

        /* renamed from: b */
        private final boolean[] f25173b;

        /* renamed from: c */
        private boolean f25174c;

        /* renamed from: d */
        private boolean f25175d;

        /* synthetic */ a(f fVar, b bVar, com.squareup.okhttp.a.b bVar2) {
            this(bVar);
        }

        private a(b bVar) {
            this.f25172a = bVar;
            this.f25173b = bVar.f25181e ? null : new boolean[f.this.j];
        }

        public void b() throws IOException {
            synchronized (f.this) {
                if (this.f25174c) {
                    f.this.a(this, false);
                    f.this.a(this.f25172a);
                } else {
                    f.this.a(this, true);
                }
                this.f25175d = true;
            }
        }

        public y a(int i) throws IOException {
            e eVar;
            synchronized (f.this) {
                if (this.f25172a.f25182f == this) {
                    if (!this.f25172a.f25181e) {
                        this.f25173b[i] = true;
                    }
                    try {
                        eVar = new e(this, f.this.f25166c.f(this.f25172a.f25180d[i]));
                    } catch (FileNotFoundException unused) {
                        return f.f25165b;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return eVar;
        }

        public void a() throws IOException {
            synchronized (f.this) {
                f.this.a(this, false);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class b {

        /* renamed from: a */
        private final String f25177a;

        /* renamed from: b */
        private final long[] f25178b;

        /* renamed from: c */
        private final File[] f25179c;

        /* renamed from: d */
        private final File[] f25180d;

        /* renamed from: e */
        private boolean f25181e;

        /* renamed from: f */
        private a f25182f;

        /* renamed from: g */
        private long f25183g;

        /* synthetic */ b(f fVar, String str, com.squareup.okhttp.a.b bVar) {
            this(str);
        }

        private b(String str) {
            this.f25177a = str;
            this.f25178b = new long[f.this.j];
            this.f25179c = new File[f.this.j];
            this.f25180d = new File[f.this.j];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < f.this.j; i++) {
                sb.append(i);
                this.f25179c[i] = new File(f.this.f25167d, sb.toString());
                sb.append(".tmp");
                this.f25180d[i] = new File(f.this.f25167d, sb.toString());
                sb.setLength(length);
            }
        }

        public void b(String[] strArr) throws IOException {
            if (strArr.length == f.this.j) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f25178b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        void a(okio.h hVar) throws IOException {
            for (long j : this.f25178b) {
                hVar.writeByte(32).d(j);
            }
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        c a() {
            if (Thread.holdsLock(f.this)) {
                z[] zVarArr = new z[f.this.j];
                long[] jArr = (long[]) this.f25178b.clone();
                for (int i = 0; i < f.this.j; i++) {
                    try {
                        zVarArr[i] = f.this.f25166c.e(this.f25179c[i]);
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < f.this.j && zVarArr[i2] != null; i2++) {
                            o.a(zVarArr[i2]);
                        }
                        return null;
                    }
                }
                return new c(f.this, this.f25177a, this.f25183g, zVarArr, jArr, null);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class c implements Closeable {

        /* renamed from: a */
        private final String f25185a;

        /* renamed from: b */
        private final long f25186b;

        /* renamed from: c */
        private final z[] f25187c;

        /* renamed from: d */
        private final long[] f25188d;

        /* synthetic */ c(f fVar, String str, long j, z[] zVarArr, long[] jArr, com.squareup.okhttp.a.b bVar) {
            this(str, j, zVarArr, jArr);
        }

        public a a() throws IOException {
            return f.this.a(this.f25185a, this.f25186b);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (z zVar : this.f25187c) {
                o.a(zVar);
            }
        }

        private c(String str, long j, z[] zVarArr, long[] jArr) {
            this.f25185a = str;
            this.f25186b = j;
            this.f25187c = zVarArr;
            this.f25188d = jArr;
        }

        public z a(int i) {
            return this.f25187c[i];
        }
    }

    f(com.squareup.okhttp.a.a.b bVar, File file, int i, int i2, long j, Executor executor) {
        this.f25166c = bVar;
        this.f25167d = file;
        this.f25171h = i;
        this.f25168e = new File(file, "journal");
        this.f25169f = new File(file, "journal.tmp");
        this.f25170g = new File(file, "journal.bkp");
        this.j = i2;
        this.i = j;
        this.s = executor;
    }

    private void i(String str) {
        if (f25164a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private synchronized void r() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public boolean s() {
        int i = this.n;
        return i >= 2000 && i >= this.m.size();
    }

    private okio.h u() throws FileNotFoundException {
        return s.a(new com.squareup.okhttp.a.c(this, this.f25166c.c(this.f25168e)));
    }

    private void v() throws IOException {
        this.f25166c.g(this.f25169f);
        Iterator<b> it = this.m.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f25182f == null) {
                while (i < this.j) {
                    this.k += next.f25178b[i];
                    i++;
                }
            } else {
                next.f25182f = null;
                while (i < this.j) {
                    this.f25166c.g(next.f25179c[i]);
                    this.f25166c.g(next.f25180d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void w() throws IOException {
        okio.i a2 = s.a(this.f25166c.e(this.f25168e));
        try {
            String h2 = a2.h();
            String h3 = a2.h();
            String h4 = a2.h();
            String h5 = a2.h();
            String h6 = a2.h();
            if (!"libcore.io.DiskLruCache".equals(h2) || !"1".equals(h3) || !Integer.toString(this.f25171h).equals(h4) || !Integer.toString(this.j).equals(h5) || !"".equals(h6)) {
                throw new IOException("unexpected journal header: [" + h2 + ", " + h3 + ", " + h5 + ", " + h6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    h(a2.h());
                    i++;
                } catch (EOFException unused) {
                    this.n = i - this.m.size();
                    if (!a2.l()) {
                        x();
                    } else {
                        this.l = u();
                    }
                    o.a(a2);
                    return;
                }
            }
        } catch (Throwable th) {
            o.a(a2);
            throw th;
        }
    }

    public synchronized void x() throws IOException {
        if (this.l != null) {
            this.l.close();
        }
        okio.h a2 = s.a(this.f25166c.f(this.f25169f));
        try {
            a2.a("libcore.io.DiskLruCache").writeByte(10);
            a2.a("1").writeByte(10);
            a2.d(this.f25171h).writeByte(10);
            a2.d(this.j).writeByte(10);
            a2.writeByte(10);
            for (b bVar : this.m.values()) {
                if (bVar.f25182f != null) {
                    a2.a("DIRTY").writeByte(32);
                    a2.a(bVar.f25177a);
                    a2.writeByte(10);
                } else {
                    a2.a("CLEAN").writeByte(32);
                    a2.a(bVar.f25177a);
                    bVar.a(a2);
                    a2.writeByte(10);
                }
            }
            a2.close();
            if (this.f25166c.b(this.f25168e)) {
                this.f25166c.a(this.f25168e, this.f25170g);
            }
            this.f25166c.a(this.f25169f, this.f25168e);
            this.f25166c.g(this.f25170g);
            this.l = u();
            this.o = false;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    public void y() throws IOException {
        while (this.k > this.i) {
            a(this.m.values().iterator().next());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.p && !this.q) {
            for (b bVar : (b[]) this.m.values().toArray(new b[this.m.size()])) {
                if (bVar.f25182f != null) {
                    bVar.f25182f.a();
                }
            }
            y();
            this.l.close();
            this.l = null;
            this.q = true;
            return;
        }
        this.q = true;
    }

    public synchronized boolean isClosed() {
        return this.q;
    }

    private void h(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.m.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            b bVar = this.m.get(substring);
            if (bVar == null) {
                bVar = new b(this, substring, null);
                this.m.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                bVar.f25181e = true;
                bVar.f25182f = null;
                bVar.b(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f25182f = new a(this, bVar, null);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public void b() throws IOException {
        close();
        this.f25166c.a(this.f25167d);
    }

    public synchronized void c() throws IOException {
        if (this.p) {
            return;
        }
        if (this.f25166c.b(this.f25170g)) {
            if (this.f25166c.b(this.f25168e)) {
                this.f25166c.g(this.f25170g);
            } else {
                this.f25166c.a(this.f25170g, this.f25168e);
            }
        }
        if (this.f25166c.b(this.f25168e)) {
            try {
                w();
                v();
                this.p = true;
                return;
            } catch (IOException e2) {
                l.a().a("DiskLruCache " + this.f25167d + " is corrupt: " + e2.getMessage() + ", removing");
                b();
                this.q = false;
            }
        }
        x();
        this.p = true;
    }

    public a e(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized c f(String str) throws IOException {
        c();
        r();
        i(str);
        b bVar = this.m.get(str);
        if (bVar != null && bVar.f25181e) {
            c a2 = bVar.a();
            if (a2 == null) {
                return null;
            }
            this.n++;
            this.l.a("READ").writeByte(32).a(str).writeByte(10);
            if (s()) {
                this.s.execute(this.t);
            }
            return a2;
        }
        return null;
    }

    public synchronized boolean g(String str) throws IOException {
        c();
        r();
        i(str);
        b bVar = this.m.get(str);
        if (bVar == null) {
            return false;
        }
        return a(bVar);
    }

    public static f a(com.squareup.okhttp.a.a.b bVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new f(bVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), o.a("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized a a(String str, long j) throws IOException {
        c();
        r();
        i(str);
        b bVar = this.m.get(str);
        if (j != -1 && (bVar == null || bVar.f25183g != j)) {
            return null;
        }
        if (bVar != null && bVar.f25182f != null) {
            return null;
        }
        this.l.a("DIRTY").writeByte(32).a(str).writeByte(10);
        this.l.flush();
        if (this.o) {
            return null;
        }
        if (bVar == null) {
            bVar = new b(this, str, null);
            this.m.put(str, bVar);
        }
        a aVar = new a(this, bVar, null);
        bVar.f25182f = aVar;
        return aVar;
    }

    public synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.f25172a;
        if (bVar.f25182f == aVar) {
            if (z && !bVar.f25181e) {
                for (int i = 0; i < this.j; i++) {
                    if (aVar.f25173b[i]) {
                        if (!this.f25166c.b(bVar.f25180d[i])) {
                            aVar.a();
                            return;
                        }
                    } else {
                        aVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.j; i2++) {
                File file = bVar.f25180d[i2];
                if (z) {
                    if (this.f25166c.b(file)) {
                        File file2 = bVar.f25179c[i2];
                        this.f25166c.a(file, file2);
                        long j = bVar.f25178b[i2];
                        long d2 = this.f25166c.d(file2);
                        bVar.f25178b[i2] = d2;
                        this.k = (this.k - j) + d2;
                    }
                } else {
                    this.f25166c.g(file);
                }
            }
            this.n++;
            bVar.f25182f = null;
            if (!(bVar.f25181e | z)) {
                this.m.remove(bVar.f25177a);
                this.l.a("REMOVE").writeByte(32);
                this.l.a(bVar.f25177a);
                this.l.writeByte(10);
            } else {
                bVar.f25181e = true;
                this.l.a("CLEAN").writeByte(32);
                this.l.a(bVar.f25177a);
                bVar.a(this.l);
                this.l.writeByte(10);
                if (z) {
                    long j2 = this.r;
                    this.r = 1 + j2;
                    bVar.f25183g = j2;
                }
            }
            this.l.flush();
            if (this.k > this.i || s()) {
                this.s.execute(this.t);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public boolean a(b bVar) throws IOException {
        if (bVar.f25182f != null) {
            bVar.f25182f.f25174c = true;
        }
        for (int i = 0; i < this.j; i++) {
            this.f25166c.g(bVar.f25179c[i]);
            this.k -= bVar.f25178b[i];
            bVar.f25178b[i] = 0;
        }
        this.n++;
        this.l.a("REMOVE").writeByte(32).a(bVar.f25177a).writeByte(10);
        this.m.remove(bVar.f25177a);
        if (s()) {
            this.s.execute(this.t);
        }
        return true;
    }
}
