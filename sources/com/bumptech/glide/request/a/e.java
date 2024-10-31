package com.bumptech.glide.request.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.b.f;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends j<ImageView, Z> implements f.a {
    private Animatable i;

    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.b.f.a
    public Drawable a() {
        return ((ImageView) this.f9084d).getDrawable();
    }

    protected abstract void a(Z z);

    @Override // com.bumptech.glide.request.a.j, com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void b(Drawable drawable) {
        super.b(drawable);
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
        c((e<Z>) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void c(Drawable drawable) {
        super.c(drawable);
        c((e<Z>) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.b.f.a
    public void d(Drawable drawable) {
        ((ImageView) this.f9084d).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.c.j
    public void onStart() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.c.j
    public void onStop() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.request.a.j, com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void a(Drawable drawable) {
        super.a(drawable);
        c((e<Z>) null);
        d(drawable);
    }

    private void c(Z z) {
        a((e<Z>) z);
        b((e<Z>) z);
    }

    @Override // com.bumptech.glide.request.a.i
    public void a(Z z, com.bumptech.glide.request.b.f<? super Z> fVar) {
        if (fVar != null && fVar.a(z, this)) {
            b((e<Z>) z);
        } else {
            c((e<Z>) z);
        }
    }

    private void b(Z z) {
        if (z instanceof Animatable) {
            this.i = (Animatable) z;
            this.i.start();
        } else {
            this.i = null;
        }
    }
}
