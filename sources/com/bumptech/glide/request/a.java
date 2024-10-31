package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.g.l;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.request.a;
import java.util.Map;

/* compiled from: BaseRequestOptions.java */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f9068a;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f9072e;

    /* renamed from: f, reason: collision with root package name */
    private int f9073f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f9074g;

    /* renamed from: h, reason: collision with root package name */
    private int f9075h;
    private boolean m;
    private Drawable o;
    private int p;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;

    /* renamed from: b, reason: collision with root package name */
    private float f9069b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private q f9070c = q.f8929e;

    /* renamed from: d, reason: collision with root package name */
    private Priority f9071d = Priority.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private com.bumptech.glide.load.c l = com.bumptech.glide.f.b.a();
    private boolean n = true;
    private com.bumptech.glide.load.g q = new com.bumptech.glide.load.g();
    private Map<Class<?>, j<?>> r = new com.bumptech.glide.g.b();
    private Class<?> s = Object.class;
    private boolean y = true;

    private T G() {
        return this;
    }

    private T H() {
        if (!this.t) {
            G();
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    private static boolean b(int i, int i2) {
        return (i & i2) != 0;
    }

    private T c(DownsampleStrategy downsampleStrategy, j<Bitmap> jVar) {
        return a(downsampleStrategy, jVar, false);
    }

    public final boolean A() {
        return c(2048);
    }

    public final boolean B() {
        return n.b(this.k, this.j);
    }

    public T C() {
        this.t = true;
        G();
        return this;
    }

    public T D() {
        return a(DownsampleStrategy.f8997b, new com.bumptech.glide.load.resource.bitmap.h());
    }

    public T E() {
        return c(DownsampleStrategy.f9000e, new com.bumptech.glide.load.resource.bitmap.i());
    }

    public T F() {
        return c(DownsampleStrategy.f8996a, new r());
    }

    public T a(float f2) {
        if (this.v) {
            return (T) mo7clone().a(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.f9069b = f2;
            this.f9068a |= 2;
            H();
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T b(boolean z) {
        if (this.v) {
            return (T) mo7clone().b(z);
        }
        this.z = z;
        this.f9068a |= 1048576;
        H();
        return this;
    }

    public final int d() {
        return this.f9073f;
    }

    public final Drawable e() {
        return this.f9072e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f9069b, this.f9069b) == 0 && this.f9073f == aVar.f9073f && n.b(this.f9072e, aVar.f9072e) && this.f9075h == aVar.f9075h && n.b(this.f9074g, aVar.f9074g) && this.p == aVar.p && n.b(this.o, aVar.o) && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f9070c.equals(aVar.f9070c) && this.f9071d == aVar.f9071d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && n.b(this.l, aVar.l) && n.b(this.u, aVar.u);
    }

    public final Drawable f() {
        return this.o;
    }

    public final int g() {
        return this.p;
    }

    public final boolean h() {
        return this.x;
    }

    public int hashCode() {
        return n.a(this.u, n.a(this.l, n.a(this.s, n.a(this.r, n.a(this.q, n.a(this.f9071d, n.a(this.f9070c, n.a(this.x, n.a(this.w, n.a(this.n, n.a(this.m, n.a(this.k, n.a(this.j, n.a(this.i, n.a(this.o, n.a(this.p, n.a(this.f9074g, n.a(this.f9075h, n.a(this.f9072e, n.a(this.f9073f, n.a(this.f9069b)))))))))))))))))))));
    }

    public final com.bumptech.glide.load.g i() {
        return this.q;
    }

    public final int j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final Drawable l() {
        return this.f9074g;
    }

    public final int m() {
        return this.f9075h;
    }

    public final Priority n() {
        return this.f9071d;
    }

    public final Class<?> o() {
        return this.s;
    }

    public final com.bumptech.glide.load.c p() {
        return this.l;
    }

    public final float q() {
        return this.f9069b;
    }

    public final Resources.Theme r() {
        return this.u;
    }

    public final Map<Class<?>, j<?>> s() {
        return this.r;
    }

    public final boolean t() {
        return this.z;
    }

    public final boolean u() {
        return this.w;
    }

    public final boolean v() {
        return this.i;
    }

    public final boolean w() {
        return c(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.y;
    }

    public final boolean y() {
        return this.n;
    }

    public final boolean z() {
        return this.m;
    }

    public final q c() {
        return this.f9070c;
    }

    @Override // 
    /* renamed from: clone */
    public T mo7clone() {
        try {
            T t = (T) super.clone();
            t.q = new com.bumptech.glide.load.g();
            t.q.a(this.q);
            t.r = new com.bumptech.glide.g.b();
            t.r.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean c(int i) {
        return b(this.f9068a, i);
    }

    public T b(int i) {
        if (this.v) {
            return (T) mo7clone().b(i);
        }
        this.f9075h = i;
        this.f9068a |= 128;
        this.f9074g = null;
        this.f9068a &= -65;
        H();
        return this;
    }

    public T a(q qVar) {
        if (this.v) {
            return (T) mo7clone().a(qVar);
        }
        l.a(qVar);
        this.f9070c = qVar;
        this.f9068a |= 4;
        H();
        return this;
    }

    public T a(Priority priority) {
        if (this.v) {
            return (T) mo7clone().a(priority);
        }
        l.a(priority);
        this.f9071d = priority;
        this.f9068a |= 8;
        H();
        return this;
    }

    public T b() {
        return b(DownsampleStrategy.f8997b, new com.bumptech.glide.load.resource.bitmap.h());
    }

    final T b(DownsampleStrategy downsampleStrategy, j<Bitmap> jVar) {
        if (this.v) {
            return (T) mo7clone().b(downsampleStrategy, jVar);
        }
        a(downsampleStrategy);
        return a(jVar);
    }

    public T a(int i) {
        if (this.v) {
            return (T) mo7clone().a(i);
        }
        this.f9073f = i;
        this.f9068a |= 32;
        this.f9072e = null;
        this.f9068a &= -17;
        H();
        return this;
    }

    public T a(boolean z) {
        if (this.v) {
            return (T) mo7clone().a(true);
        }
        this.i = !z;
        this.f9068a |= 256;
        H();
        return this;
    }

    public T a(int i, int i2) {
        if (this.v) {
            return (T) mo7clone().a(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.f9068a |= 512;
        H();
        return this;
    }

    public T a(com.bumptech.glide.load.c cVar) {
        if (this.v) {
            return (T) mo7clone().a(cVar);
        }
        l.a(cVar);
        this.l = cVar;
        this.f9068a |= 1024;
        H();
        return this;
    }

    public <Y> T a(com.bumptech.glide.load.f<Y> fVar, Y y) {
        if (this.v) {
            return (T) mo7clone().a(fVar, y);
        }
        l.a(fVar);
        l.a(y);
        this.q.a(fVar, y);
        H();
        return this;
    }

    public T a(Class<?> cls) {
        if (this.v) {
            return (T) mo7clone().a(cls);
        }
        l.a(cls);
        this.s = cls;
        this.f9068a |= 4096;
        H();
        return this;
    }

    public T a(DownsampleStrategy downsampleStrategy) {
        com.bumptech.glide.load.f fVar = DownsampleStrategy.f9003h;
        l.a(downsampleStrategy);
        return a((com.bumptech.glide.load.f<com.bumptech.glide.load.f>) fVar, (com.bumptech.glide.load.f) downsampleStrategy);
    }

    final T a(DownsampleStrategy downsampleStrategy, j<Bitmap> jVar) {
        if (this.v) {
            return (T) mo7clone().a(downsampleStrategy, jVar);
        }
        a(downsampleStrategy);
        return a(jVar, false);
    }

    private T a(DownsampleStrategy downsampleStrategy, j<Bitmap> jVar, boolean z) {
        T b2 = z ? b(downsampleStrategy, jVar) : a(downsampleStrategy, jVar);
        b2.y = true;
        return b2;
    }

    public T a(j<Bitmap> jVar) {
        return a(jVar, true);
    }

    @Deprecated
    public T a(j<Bitmap>... jVarArr) {
        return a((j<Bitmap>) new com.bumptech.glide.load.d(jVarArr), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    T a(j<Bitmap> jVar, boolean z) {
        if (this.v) {
            return (T) mo7clone().a(jVar, z);
        }
        p pVar = new p(jVar, z);
        a(Bitmap.class, jVar, z);
        a(Drawable.class, pVar, z);
        pVar.a();
        a(BitmapDrawable.class, pVar, z);
        a(com.bumptech.glide.load.c.d.c.class, new com.bumptech.glide.load.c.d.f(jVar), z);
        H();
        return this;
    }

    <Y> T a(Class<Y> cls, j<Y> jVar, boolean z) {
        if (this.v) {
            return (T) mo7clone().a(cls, jVar, z);
        }
        l.a(cls);
        l.a(jVar);
        this.r.put(cls, jVar);
        this.f9068a |= 2048;
        this.n = true;
        this.f9068a |= 65536;
        this.y = false;
        if (z) {
            this.f9068a |= 131072;
            this.m = true;
        }
        H();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.v) {
            return (T) mo7clone().a(aVar);
        }
        if (b(aVar.f9068a, 2)) {
            this.f9069b = aVar.f9069b;
        }
        if (b(aVar.f9068a, 262144)) {
            this.w = aVar.w;
        }
        if (b(aVar.f9068a, 1048576)) {
            this.z = aVar.z;
        }
        if (b(aVar.f9068a, 4)) {
            this.f9070c = aVar.f9070c;
        }
        if (b(aVar.f9068a, 8)) {
            this.f9071d = aVar.f9071d;
        }
        if (b(aVar.f9068a, 16)) {
            this.f9072e = aVar.f9072e;
            this.f9073f = 0;
            this.f9068a &= -33;
        }
        if (b(aVar.f9068a, 32)) {
            this.f9073f = aVar.f9073f;
            this.f9072e = null;
            this.f9068a &= -17;
        }
        if (b(aVar.f9068a, 64)) {
            this.f9074g = aVar.f9074g;
            this.f9075h = 0;
            this.f9068a &= -129;
        }
        if (b(aVar.f9068a, 128)) {
            this.f9075h = aVar.f9075h;
            this.f9074g = null;
            this.f9068a &= -65;
        }
        if (b(aVar.f9068a, 256)) {
            this.i = aVar.i;
        }
        if (b(aVar.f9068a, 512)) {
            this.k = aVar.k;
            this.j = aVar.j;
        }
        if (b(aVar.f9068a, 1024)) {
            this.l = aVar.l;
        }
        if (b(aVar.f9068a, 4096)) {
            this.s = aVar.s;
        }
        if (b(aVar.f9068a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.f9068a &= -16385;
        }
        if (b(aVar.f9068a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.f9068a &= -8193;
        }
        if (b(aVar.f9068a, 32768)) {
            this.u = aVar.u;
        }
        if (b(aVar.f9068a, 65536)) {
            this.n = aVar.n;
        }
        if (b(aVar.f9068a, 131072)) {
            this.m = aVar.m;
        }
        if (b(aVar.f9068a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (b(aVar.f9068a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            this.f9068a &= -2049;
            this.m = false;
            this.f9068a &= -131073;
            this.y = true;
        }
        this.f9068a |= aVar.f9068a;
        this.q.a(aVar.q);
        H();
        return this;
    }

    public T a() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        C();
        return this;
    }
}
