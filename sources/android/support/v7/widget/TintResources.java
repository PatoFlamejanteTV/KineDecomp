package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* renamed from: b */
    private final WeakReference<Context> f3110b;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f3110b = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f3110b.get();
        if (drawable != null && context != null) {
            AppCompatDrawableManager.get();
            AppCompatDrawableManager.a(context, i, drawable);
        }
        return drawable;
    }
}
