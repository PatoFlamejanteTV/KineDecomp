package android.support.v4.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private static final int[] f660a = {R.attr.homeAsUpIndicator};

    /* renamed from: b */
    final Activity f661b;

    /* renamed from: c */
    private final Delegate f662c;

    /* renamed from: d */
    private final DrawerLayout f663d;

    /* renamed from: e */
    private boolean f664e;

    /* renamed from: f */
    private boolean f665f;

    /* renamed from: g */
    private Drawable f666g;

    /* renamed from: h */
    private Drawable f667h;
    private SlideDrawable i;
    private final int j;
    private final int k;
    private final int l;
    private SetIndicatorInfo m;

    @Deprecated
    /* loaded from: classes.dex */
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* loaded from: classes.dex */
    public static class SetIndicatorInfo {

        /* renamed from: a */
        Method f668a;

        /* renamed from: b */
        Method f669b;

        /* renamed from: c */
        ImageView f670c;

        SetIndicatorInfo(Activity activity) {
            try {
                this.f668a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f669b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(R.id.home);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                if (childAt2 instanceof ImageView) {
                    this.f670c = (ImageView) childAt2;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a */
        private final boolean f671a;

        /* renamed from: b */
        private final Rect f672b;

        /* renamed from: c */
        private float f673c;

        /* renamed from: d */
        private float f674d;

        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
            this.f671a = Build.VERSION.SDK_INT > 18;
            this.f672b = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            copyBounds(this.f672b);
            canvas.save();
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.f661b.getWindow().getDecorView()) == 1;
            int i = z ? -1 : 1;
            float width = this.f672b.width();
            canvas.translate((-this.f674d) * width * this.f673c * i, 0.0f);
            if (z && !this.f671a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.f673c;
        }

        public void setOffset(float f2) {
            this.f674d = f2;
            invalidateSelf();
        }

        public void setPosition(float f2) {
            this.f673c = f2;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !a(activity), i, i2, i3);
    }

    private static boolean a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f664e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f665f) {
            this.f666g = a();
        }
        this.f667h = ContextCompat.getDrawable(this.f661b, this.j);
        syncState();
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.i.setPosition(0.0f);
        if (this.f664e) {
            a(this.k);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.i.setPosition(1.0f);
        if (this.f664e) {
            a(this.l);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        float min;
        float position = this.i.getPosition();
        if (f2 > 0.5f) {
            min = Math.max(position, Math.max(0.0f, f2 - 0.5f) * 2.0f);
        } else {
            min = Math.min(position, f2 * 2.0f);
        }
        this.i.setPosition(min);
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f664e) {
            return false;
        }
        if (this.f663d.isDrawerVisible(GravityCompat.START)) {
            this.f663d.closeDrawer(GravityCompat.START);
            return true;
        }
        this.f663d.openDrawer(GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f664e) {
            if (z) {
                a(this.i, this.f663d.isDrawerOpen(GravityCompat.START) ? this.l : this.k);
            } else {
                a(this.f666g, 0);
            }
            this.f664e = z;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f666g = a();
            this.f665f = false;
        } else {
            this.f666g = drawable;
            this.f665f = true;
        }
        if (this.f664e) {
            return;
        }
        a(this.f666g, 0);
    }

    public void syncState() {
        if (this.f663d.isDrawerOpen(GravityCompat.START)) {
            this.i.setPosition(1.0f);
        } else {
            this.i.setPosition(0.0f);
        }
        if (this.f664e) {
            a(this.i, this.f663d.isDrawerOpen(GravityCompat.START) ? this.l : this.k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.f664e = true;
        this.f661b = activity;
        if (activity instanceof DelegateProvider) {
            this.f662c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f662c = null;
        }
        this.f663d = drawerLayout;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.f666g = a();
        this.f667h = ContextCompat.getDrawable(activity, i);
        this.i = new SlideDrawable(this.f667h);
        this.i.setOffset(z ? 0.33333334f : 0.0f);
    }

    private Drawable a() {
        Context context;
        Delegate delegate = this.f662c;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f661b.getActionBar();
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.f661b;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f660a, R.attr.actionBarStyle, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        TypedArray obtainStyledAttributes2 = this.f661b.obtainStyledAttributes(f660a);
        Drawable drawable2 = obtainStyledAttributes2.getDrawable(0);
        obtainStyledAttributes2.recycle();
        return drawable2;
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? ContextCompat.getDrawable(this.f661b, i) : null);
    }

    private void a(Drawable drawable, int i) {
        Delegate delegate = this.f662c;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f661b.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            return;
        }
        if (this.m == null) {
            this.m = new SetIndicatorInfo(this.f661b);
        }
        SetIndicatorInfo setIndicatorInfo = this.m;
        if (setIndicatorInfo.f668a != null) {
            try {
                ActionBar actionBar2 = this.f661b.getActionBar();
                this.m.f668a.invoke(actionBar2, drawable);
                this.m.f669b.invoke(actionBar2, Integer.valueOf(i));
                return;
            } catch (Exception e2) {
                Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", e2);
                return;
            }
        }
        ImageView imageView = setIndicatorInfo.f670c;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
        }
    }

    private void a(int i) {
        Delegate delegate = this.f662c;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f661b.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            return;
        }
        if (this.m == null) {
            this.m = new SetIndicatorInfo(this.f661b);
        }
        if (this.m.f668a != null) {
            try {
                ActionBar actionBar2 = this.f661b.getActionBar();
                this.m.f669b.invoke(actionBar2, Integer.valueOf(i));
                actionBar2.setSubtitle(actionBar2.getSubtitle());
            } catch (Exception e2) {
                Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e2);
            }
        }
    }
}
