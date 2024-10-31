package com.bumptech.glide.request.a;

import com.bumptech.glide.g.n;

/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class g<Z> extends a<Z> {

    /* renamed from: b */
    private final int f9080b;

    /* renamed from: c */
    private final int f9081c;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.a.i
    public void a(h hVar) {
    }

    @Override // com.bumptech.glide.request.a.i
    public final void b(h hVar) {
        if (n.b(this.f9080b, this.f9081c)) {
            hVar.a(this.f9080b, this.f9081c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f9080b + " and height: " + this.f9081c + ", either provide dimensions in the constructor or call override()");
    }

    public g(int i, int i2) {
        this.f9080b = i;
        this.f9081c = i2;
    }
}
