package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.E;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapHunter.java */
/* renamed from: com.squareup.picasso.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2396i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f25638a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f25639b = new C2390c();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f25640c = new AtomicInteger();

    /* renamed from: d, reason: collision with root package name */
    private static final E f25641d = new C2391d();

    /* renamed from: e, reason: collision with root package name */
    final int f25642e = f25640c.incrementAndGet();

    /* renamed from: f, reason: collision with root package name */
    final Picasso f25643f;

    /* renamed from: g, reason: collision with root package name */
    final q f25644g;

    /* renamed from: h, reason: collision with root package name */
    final InterfaceC2398k f25645h;
    final H i;
    final String j;
    final C k;
    final int l;
    int m;
    final E n;
    AbstractC2388a o;
    List<AbstractC2388a> p;
    Bitmap q;
    Future<?> r;
    Picasso.LoadedFrom s;
    Exception t;
    int u;
    int v;
    Picasso.Priority w;

    RunnableC2396i(Picasso picasso, q qVar, InterfaceC2398k interfaceC2398k, H h2, AbstractC2388a abstractC2388a, E e2) {
        this.f25643f = picasso;
        this.f25644g = qVar;
        this.f25645h = interfaceC2398k;
        this.i = h2;
        this.o = abstractC2388a;
        this.j = abstractC2388a.c();
        this.k = abstractC2388a.h();
        this.w = abstractC2388a.g();
        this.l = abstractC2388a.d();
        this.m = abstractC2388a.e();
        this.n = e2;
        this.v = e2.a();
    }

    static Bitmap a(InputStream inputStream, C c2) throws IOException {
        u uVar = new u(inputStream);
        long a2 = uVar.a(65536);
        BitmapFactory.Options b2 = E.b(c2);
        boolean a3 = E.a(b2);
        boolean b3 = N.b(uVar);
        uVar.g(a2);
        if (b3) {
            byte[] c3 = N.c(uVar);
            if (a3) {
                BitmapFactory.decodeByteArray(c3, 0, c3.length, b2);
                E.a(c2.i, c2.j, b2, c2);
            }
            return BitmapFactory.decodeByteArray(c3, 0, c3.length, b2);
        }
        if (a3) {
            BitmapFactory.decodeStream(uVar, null, b2);
            E.a(c2.i, c2.j, b2, c2);
            uVar.g(a2);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(uVar, null, b2);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    private Picasso.Priority p() {
        Picasso.Priority priority = Picasso.Priority.LOW;
        List<AbstractC2388a> list = this.p;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        if (this.o == null && !z2) {
            z = false;
        }
        if (!z) {
            return priority;
        }
        AbstractC2388a abstractC2388a = this.o;
        if (abstractC2388a != null) {
            priority = abstractC2388a.g();
        }
        if (z2) {
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                Picasso.Priority g2 = this.p.get(i).g();
                if (g2.ordinal() > priority.ordinal()) {
                    priority = g2;
                }
            }
        }
        return priority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AbstractC2388a abstractC2388a) {
        boolean remove;
        if (this.o == abstractC2388a) {
            this.o = null;
            remove = true;
        } else {
            List<AbstractC2388a> list = this.p;
            remove = list != null ? list.remove(abstractC2388a) : false;
        }
        if (remove && abstractC2388a.g() == this.w) {
            this.w = p();
        }
        if (this.f25643f.p) {
            N.a("Hunter", "removed", abstractC2388a.f25623b.d(), N.a(this, "from "));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2388a c() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<AbstractC2388a> d() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C e() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception f() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.LoadedFrom h() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso j() {
        return this.f25643f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.Priority k() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap l() {
        return this.q;
    }

    Bitmap m() throws IOException {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.l)) {
            bitmap = this.f25645h.a(this.j);
            if (bitmap != null) {
                this.i.b();
                this.s = Picasso.LoadedFrom.MEMORY;
                if (this.f25643f.p) {
                    N.a("Hunter", "decoded", this.k.d(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        this.k.f25546d = this.v == 0 ? NetworkPolicy.OFFLINE.index : this.m;
        E.a a2 = this.n.a(this.k, this.m);
        if (a2 != null) {
            this.s = a2.c();
            this.u = a2.b();
            bitmap = a2.a();
            if (bitmap == null) {
                InputStream d2 = a2.d();
                try {
                    Bitmap a3 = a(d2, this.k);
                    N.a(d2);
                    bitmap = a3;
                } catch (Throwable th) {
                    N.a(d2);
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            if (this.f25643f.p) {
                N.a("Hunter", "decoded", this.k.d());
            }
            this.i.a(bitmap);
            if (this.k.f() || this.u != 0) {
                synchronized (f25638a) {
                    if (this.k.e() || this.u != 0) {
                        bitmap = a(this.k, bitmap, this.u);
                        if (this.f25643f.p) {
                            N.a("Hunter", "transformed", this.k.d());
                        }
                    }
                    if (this.k.b()) {
                        bitmap = a(this.k.f25550h, bitmap);
                        if (this.f25643f.p) {
                            N.a("Hunter", "transformed", this.k.d(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.i.b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        Future<?> future = this.r;
        return future != null && future.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.n.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    a(this.k);
                    if (this.f25643f.p) {
                        N.a("Hunter", "executing", N.a(this));
                    }
                    this.q = m();
                    if (this.q == null) {
                        this.f25644g.b(this);
                    } else {
                        this.f25644g.a(this);
                    }
                } catch (Downloader.ResponseException e2) {
                    if (!e2.localCacheOnly || e2.responseCode != 504) {
                        this.t = e2;
                    }
                    this.f25644g.b(this);
                } catch (IOException e3) {
                    this.t = e3;
                    this.f25644g.c(this);
                } catch (Exception e4) {
                    this.t = e4;
                    this.f25644g.b(this);
                }
            } catch (NetworkRequestHandler.ContentLengthException e5) {
                this.t = e5;
                this.f25644g.c(this);
            } catch (OutOfMemoryError e6) {
                StringWriter stringWriter = new StringWriter();
                this.i.a().a(new PrintWriter(stringWriter));
                this.t = new RuntimeException(stringWriter.toString(), e6);
                this.f25644g.b(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        Future<?> future;
        if (this.o != null) {
            return false;
        }
        List<AbstractC2388a> list = this.p;
        return (list == null || list.isEmpty()) && (future = this.r) != null && future.cancel(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC2388a abstractC2388a) {
        boolean z = this.f25643f.p;
        C c2 = abstractC2388a.f25623b;
        if (this.o == null) {
            this.o = abstractC2388a;
            if (z) {
                List<AbstractC2388a> list = this.p;
                if (list != null && !list.isEmpty()) {
                    N.a("Hunter", "joined", c2.d(), N.a(this, "to "));
                    return;
                } else {
                    N.a("Hunter", "joined", c2.d(), "to empty hunter");
                    return;
                }
            }
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList(3);
        }
        this.p.add(abstractC2388a);
        if (z) {
            N.a("Hunter", "joined", c2.d(), N.a(this, "to "));
        }
        Picasso.Priority g2 = abstractC2388a.g();
        if (g2.ordinal() > this.w.ordinal()) {
            this.w = g2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.v > 0)) {
            return false;
        }
        this.v--;
        return this.n.a(z, networkInfo);
    }

    static void a(C c2) {
        String a2 = c2.a();
        StringBuilder sb = f25639b.get();
        sb.ensureCapacity(a2.length() + 8);
        sb.replace(8, sb.length(), a2);
        Thread.currentThread().setName(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RunnableC2396i a(Picasso picasso, q qVar, InterfaceC2398k interfaceC2398k, H h2, AbstractC2388a abstractC2388a) {
        C h3 = abstractC2388a.h();
        List<E> a2 = picasso.a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            E e2 = a2.get(i);
            if (e2.a(h3)) {
                return new RunnableC2396i(picasso, qVar, interfaceC2398k, h2, abstractC2388a, e2);
            }
        }
        return new RunnableC2396i(picasso, qVar, interfaceC2398k, h2, abstractC2388a, f25641d);
    }

    static Bitmap a(List<J> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            J j = list.get(i);
            try {
                Bitmap a2 = j.a(bitmap);
                if (a2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(j.key());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<J> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().key());
                        sb.append('\n');
                    }
                    Picasso.f25603a.post(new RunnableC2393f(sb));
                    return null;
                }
                if (a2 == bitmap && bitmap.isRecycled()) {
                    Picasso.f25603a.post(new RunnableC2394g(j));
                    return null;
                }
                if (a2 != bitmap && !bitmap.isRecycled()) {
                    Picasso.f25603a.post(new RunnableC2395h(j));
                    return null;
                }
                i++;
                bitmap = a2;
            } catch (RuntimeException e2) {
                Picasso.f25603a.post(new RunnableC2392e(j, e2));
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.graphics.Bitmap a(com.squareup.picasso.C r13, android.graphics.Bitmap r14, int r15) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.RunnableC2396i.a(com.squareup.picasso.C, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
