package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class z extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Resources f195a;

    public static Context a(Context context) {
        if (!(context instanceof z)) {
            return new z(context);
        }
        return context;
    }

    private z(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f195a == null) {
            this.f195a = new a(super.getResources(), ab.a(this));
        }
        return this.f195a;
    }

    /* compiled from: TintContextWrapper.java */
    /* loaded from: classes.dex */
    static class a extends q {

        /* renamed from: a, reason: collision with root package name */
        private final ab f196a;

        public a(Resources resources, ab abVar) {
            super(resources);
            this.f196a = abVar;
        }

        @Override // android.support.v7.internal.widget.q, android.content.res.Resources
        public Drawable getDrawable(int i) throws Resources.NotFoundException {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null) {
                this.f196a.a(i, drawable);
            }
            return drawable;
        }
    }
}
