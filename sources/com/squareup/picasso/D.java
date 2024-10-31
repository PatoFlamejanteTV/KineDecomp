package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.C;
import com.squareup.picasso.Picasso;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator.java */
/* loaded from: classes3.dex */
public class D {

    /* renamed from: a */
    private static final AtomicInteger f25559a = new AtomicInteger();

    /* renamed from: b */
    private final Picasso f25560b;

    /* renamed from: c */
    private final C.a f25561c;

    /* renamed from: d */
    private boolean f25562d;

    /* renamed from: e */
    private boolean f25563e;

    /* renamed from: f */
    private boolean f25564f = true;

    /* renamed from: g */
    private int f25565g;

    /* renamed from: h */
    private int f25566h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    public D(Picasso picasso, Uri uri, int i) {
        if (!picasso.q) {
            this.f25560b = picasso;
            this.f25561c = new C.a(uri, i, picasso.n);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private Drawable b() {
        if (this.f25565g != 0) {
            return this.f25560b.f25609g.getResources().getDrawable(this.f25565g);
        }
        return this.k;
    }

    public D a(int i) {
        if (!this.f25564f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (i != 0) {
            if (this.k == null) {
                this.f25565g = i;
                return this;
            }
            throw new IllegalStateException("Placeholder image already set.");
        }
        throw new IllegalArgumentException("Placeholder image resource invalid.");
    }

    public D a(Object obj) {
        if (obj != null) {
            if (this.m == null) {
                this.m = obj;
                return this;
            }
            throw new IllegalStateException("Tag already set.");
        }
        throw new IllegalArgumentException("Tag invalid.");
    }

    public D a() {
        this.f25563e = false;
        return this;
    }

    public D a(int i, int i2) {
        this.f25561c.a(i, i2);
        return this;
    }

    public void a(ImageView imageView, InterfaceC2399l interfaceC2399l) {
        Bitmap b2;
        long nanoTime = System.nanoTime();
        N.a();
        if (imageView != null) {
            if (!this.f25561c.b()) {
                this.f25560b.a(imageView);
                if (this.f25564f) {
                    z.a(imageView, b());
                    return;
                }
                return;
            }
            if (this.f25563e) {
                if (!this.f25561c.c()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width != 0 && height != 0) {
                        this.f25561c.a(width, height);
                    } else {
                        if (this.f25564f) {
                            z.a(imageView, b());
                        }
                        this.f25560b.a(imageView, new o(this, imageView, interfaceC2399l));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            C a2 = a(nanoTime);
            String a3 = N.a(a2);
            if (MemoryPolicy.shouldReadFromMemoryCache(this.i) && (b2 = this.f25560b.b(a3)) != null) {
                this.f25560b.a(imageView);
                Picasso picasso = this.f25560b;
                z.a(imageView, picasso.f25609g, b2, Picasso.LoadedFrom.MEMORY, this.f25562d, picasso.o);
                if (this.f25560b.p) {
                    N.a("Main", "completed", a2.g(), "from " + Picasso.LoadedFrom.MEMORY);
                }
                if (interfaceC2399l != null) {
                    interfaceC2399l.onSuccess();
                    return;
                }
                return;
            }
            if (this.f25564f) {
                z.a(imageView, b());
            }
            this.f25560b.a((AbstractC2388a) new s(this.f25560b, imageView, a2, this.i, this.j, this.f25566h, this.l, a3, this.m, interfaceC2399l, this.f25562d));
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    private C a(long j) {
        int andIncrement = f25559a.getAndIncrement();
        C a2 = this.f25561c.a();
        a2.f25544b = andIncrement;
        a2.f25545c = j;
        boolean z = this.f25560b.p;
        if (z) {
            N.a("Main", "created", a2.g(), a2.toString());
        }
        this.f25560b.a(a2);
        if (a2 != a2) {
            a2.f25544b = andIncrement;
            a2.f25545c = j;
            if (z) {
                N.a("Main", "changed", a2.d(), "into " + a2);
            }
        }
        return a2;
    }
}
