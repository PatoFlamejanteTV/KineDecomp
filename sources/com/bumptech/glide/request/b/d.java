package com.bumptech.glide.request.b;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.b.f;

/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: classes.dex */
public class d implements f<Drawable> {

    /* renamed from: a */
    private final int f9106a;

    /* renamed from: b */
    private final boolean f9107b;

    public d(int i, boolean z) {
        this.f9106a = i;
        this.f9107b = z;
    }

    @Override // com.bumptech.glide.request.b.f
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable a2 = aVar.a();
        if (a2 == null) {
            a2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{a2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f9107b);
        transitionDrawable.startTransition(this.f9106a);
        aVar.d(transitionDrawable);
        return true;
    }
}
