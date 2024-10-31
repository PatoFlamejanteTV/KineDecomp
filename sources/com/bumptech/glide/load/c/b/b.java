package com.bumptech.glide.load.c.b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.l;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.engine.z;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements E<T>, z {

    /* renamed from: a */
    protected final T f8683a;

    public b(T t) {
        l.a(t);
        this.f8683a = t;
    }

    @Override // com.bumptech.glide.load.engine.z
    public void d() {
        T t = this.f8683a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.bumptech.glide.load.c.d.c) {
            ((com.bumptech.glide.load.c.d.c) t).c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.E
    public final T get() {
        Drawable.ConstantState constantState = this.f8683a.getConstantState();
        if (constantState == null) {
            return this.f8683a;
        }
        return (T) constantState.newDrawable();
    }
}
