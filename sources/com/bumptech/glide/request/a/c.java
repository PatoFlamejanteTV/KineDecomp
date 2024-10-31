package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.n;

/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class c<T> implements i<T> {

    /* renamed from: a */
    private final int f9077a;

    /* renamed from: b */
    private final int f9078b;

    /* renamed from: c */
    private com.bumptech.glide.request.c f9079c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.a.i
    public void a(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.a.i
    public final void a(h hVar) {
    }

    @Override // com.bumptech.glide.request.a.i
    public final void a(com.bumptech.glide.request.c cVar) {
        this.f9079c = cVar;
    }

    @Override // com.bumptech.glide.request.a.i
    public final void b(h hVar) {
        hVar.a(this.f9077a, this.f9078b);
    }

    @Override // com.bumptech.glide.request.a.i
    public void c(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.a.i
    public final com.bumptech.glide.request.c getRequest() {
        return this.f9079c;
    }

    @Override // com.bumptech.glide.c.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.c.j
    public void onStart() {
    }

    @Override // com.bumptech.glide.c.j
    public void onStop() {
    }

    public c(int i, int i2) {
        if (n.b(i, i2)) {
            this.f9077a = i;
            this.f9078b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
