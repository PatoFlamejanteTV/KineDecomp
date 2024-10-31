package com.bumptech.glide.request.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.b.f;

/* compiled from: BitmapContainerTransitionFactory.java */
/* loaded from: classes.dex */
public abstract class a<R> implements g<R> {

    /* renamed from: a */
    private final g<Drawable> f9098a;

    /* compiled from: BitmapContainerTransitionFactory.java */
    /* renamed from: com.bumptech.glide.request.b.a$a */
    /* loaded from: classes.dex */
    private final class C0058a implements f<R> {

        /* renamed from: a */
        private final f<Drawable> f9099a;

        C0058a(f<Drawable> fVar) {
            this.f9099a = fVar;
        }

        @Override // com.bumptech.glide.request.b.f
        public boolean a(R r, f.a aVar) {
            return this.f9099a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.a(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f9098a = gVar;
    }

    protected abstract Bitmap a(R r);

    @Override // com.bumptech.glide.request.b.g
    public f<R> a(DataSource dataSource, boolean z) {
        return new C0058a(this.f9098a.a(dataSource, z));
    }
}
