package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: a */
    private int f2362a;

    /* renamed from: b */
    private Resources.Theme f2363b;

    /* renamed from: c */
    private LayoutInflater f2364c;

    /* renamed from: d */
    private Configuration f2365d;

    /* renamed from: e */
    private Resources f2366e;

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources a() {
        if (this.f2366e == null) {
            Configuration configuration = this.f2365d;
            if (configuration == null) {
                this.f2366e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f2366e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f2366e;
    }

    private void b() {
        boolean z = this.f2363b == null;
        if (z) {
            this.f2363b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2363b.setTo(theme);
            }
        }
        a(this.f2363b, this.f2362a, z);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.f2366e == null) {
            if (this.f2365d == null) {
                this.f2365d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f2364c == null) {
                this.f2364c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f2364c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2363b;
        if (theme != null) {
            return theme;
        }
        if (this.f2362a == 0) {
            this.f2362a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f2363b;
    }

    public int getThemeResId() {
        return this.f2362a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f2362a != i) {
            this.f2362a = i;
            b();
        }
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f2362a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f2363b = theme;
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }
}
