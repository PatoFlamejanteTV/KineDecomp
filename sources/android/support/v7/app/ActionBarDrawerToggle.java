package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a, reason: collision with root package name */
    private final Delegate f2082a;

    /* renamed from: b, reason: collision with root package name */
    private final DrawerLayout f2083b;

    /* renamed from: c, reason: collision with root package name */
    private DrawerArrowDrawable f2084c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2085d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f2086e;

    /* renamed from: f, reason: collision with root package name */
    boolean f2087f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2088g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2089h;
    private final int i;
    View.OnClickListener j;
    private boolean k;

    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* loaded from: classes.dex */
    private static class IcsDelegate implements Delegate {

        /* renamed from: a, reason: collision with root package name */
        final Activity f2091a;

        /* renamed from: b, reason: collision with root package name */
        ActionBarDrawerToggleHoneycomb.SetIndicatorInfo f2092b;

        IcsDelegate(Activity activity) {
            this.f2091a = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.f2091a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f2091a;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.f2091a);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.f2091a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            this.f2092b = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.f2092b, this.f2091a, i);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.f2091a.getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowHomeEnabled(true);
                this.f2092b = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.f2092b, this.f2091a, drawable, i);
                actionBar.setDisplayShowHomeEnabled(false);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class JellybeanMr2Delegate implements Delegate {

        /* renamed from: a, reason: collision with root package name */
        final Activity f2093a;

        JellybeanMr2Delegate(Activity activity) {
            this.f2093a = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.f2093a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f2093a;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.f2093a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            android.app.ActionBar actionBar = this.f2093a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.f2093a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* loaded from: classes.dex */
    static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a, reason: collision with root package name */
        final Toolbar f2094a;

        /* renamed from: b, reason: collision with root package name */
        final Drawable f2095b;

        /* renamed from: c, reason: collision with root package name */
        final CharSequence f2096c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f2094a = toolbar;
            this.f2095b = toolbar.getNavigationIcon();
            this.f2096c = toolbar.getNavigationContentDescription();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.f2094a.getContext();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.f2095b;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            if (i == 0) {
                this.f2094a.setNavigationContentDescription(this.f2096c);
            } else {
                this.f2094a.setNavigationContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f2094a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    void a(Drawable drawable, int i) {
        if (!this.k && !this.f2082a.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.k = true;
        }
        this.f2082a.setActionBarUpIndicator(drawable, i);
    }

    void b() {
        int drawerLockMode = this.f2083b.getDrawerLockMode(GravityCompat.START);
        if (this.f2083b.isDrawerVisible(GravityCompat.START) && drawerLockMode != 2) {
            this.f2083b.closeDrawer(GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.f2083b.openDrawer(GravityCompat.START);
        }
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.f2084c;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.j;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f2087f;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.f2085d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f2088g) {
            this.f2086e = a();
        }
        syncState();
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        a(0.0f);
        if (this.f2087f) {
            a(this.f2089h);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        a(1.0f);
        if (this.f2087f) {
            a(this.i);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        if (this.f2085d) {
            a(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            a(0.0f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f2087f) {
            return false;
        }
        b();
        return true;
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable drawerArrowDrawable) {
        this.f2084c = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f2087f) {
            if (z) {
                a(this.f2084c, this.f2083b.isDrawerOpen(GravityCompat.START) ? this.i : this.f2089h);
            } else {
                a(this.f2086e, 0);
            }
            this.f2087f = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.f2085d = z;
        if (z) {
            return;
        }
        a(0.0f);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f2086e = a();
            this.f2088g = false;
        } else {
            this.f2086e = drawable;
            this.f2088g = true;
        }
        if (this.f2087f) {
            return;
        }
        a(this.f2086e, 0);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void syncState() {
        if (this.f2083b.isDrawerOpen(GravityCompat.START)) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        if (this.f2087f) {
            a(this.f2084c, this.f2083b.isDrawerOpen(GravityCompat.START) ? this.i : this.f2089h);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, int i, int i2) {
        this.f2085d = true;
        this.f2087f = true;
        this.k = false;
        if (toolbar != null) {
            this.f2082a = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.app.ActionBarDrawerToggle.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.f2087f) {
                        actionBarDrawerToggle.b();
                        return;
                    }
                    View.OnClickListener onClickListener = actionBarDrawerToggle.j;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f2082a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.f2082a = new JellybeanMr2Delegate(activity);
        } else {
            this.f2082a = new IcsDelegate(activity);
        }
        this.f2083b = drawerLayout;
        this.f2089h = i;
        this.i = i2;
        if (drawerArrowDrawable == null) {
            this.f2084c = new DrawerArrowDrawable(this.f2082a.getActionBarThemedContext());
        } else {
            this.f2084c = drawerArrowDrawable;
        }
        this.f2086e = a();
    }

    void a(int i) {
        this.f2082a.setActionBarDescription(i);
    }

    Drawable a() {
        return this.f2082a.getThemeUpIndicator();
    }

    private void a(float f2) {
        if (f2 == 1.0f) {
            this.f2084c.setVerticalMirror(true);
        } else if (f2 == 0.0f) {
            this.f2084c.setVerticalMirror(false);
        }
        this.f2084c.setProgress(f2);
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.f2083b.getResources().getDrawable(i) : null);
    }
}
