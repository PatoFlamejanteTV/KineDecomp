package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: a */
    private static final Object f3106a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<TintContextWrapper>> f3107b;

    /* renamed from: c */
    private final Resources f3108c;

    /* renamed from: d */
    private final Resources.Theme f3109d;

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            this.f3108c = new VectorEnabledTintResources(this, context.getResources());
            this.f3109d = this.f3108c.newTheme();
            this.f3109d.setTo(context.getTheme());
        } else {
            this.f3108c = new TintResources(this, context.getResources());
            this.f3109d = null;
        }
    }

    private static boolean a(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed();
    }

    public static Context wrap(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f3106a) {
            if (f3107b == null) {
                f3107b = new ArrayList<>();
            } else {
                for (int size = f3107b.size() - 1; size >= 0; size--) {
                    WeakReference<TintContextWrapper> weakReference = f3107b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f3107b.remove(size);
                    }
                }
                for (int size2 = f3107b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<TintContextWrapper> weakReference2 = f3107b.get(size2);
                    TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            f3107b.add(new WeakReference<>(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f3108c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f3108c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3109d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f3109d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
