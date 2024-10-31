package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;

/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class a<Z> implements i<Z> {

    /* renamed from: a */
    private com.bumptech.glide.request.c f9076a;

    @Override // com.bumptech.glide.request.a.i
    public void a(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.a.i
    public void a(com.bumptech.glide.request.c cVar) {
        this.f9076a = cVar;
    }

    @Override // com.bumptech.glide.request.a.i
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.a.i
    public void c(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.a.i
    public com.bumptech.glide.request.c getRequest() {
        return this.f9076a;
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
}
