package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.appcompat.R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AppCompatDelegateImplBase extends AppCompatDelegate {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f2139c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f2140d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f2141e;

    /* renamed from: f, reason: collision with root package name */
    final Context f2142f;

    /* renamed from: g, reason: collision with root package name */
    final Window f2143g;

    /* renamed from: h, reason: collision with root package name */
    final Window.Callback f2144h;
    final Window.Callback i;
    final AppCompatCallback j;
    ActionBar k;
    MenuInflater l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    private CharSequence r;
    private boolean s;
    private boolean t;

    /* loaded from: classes.dex */
    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return AppCompatDelegateImplBase.this.a();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AppCompatWindowCallbackBase(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplBase.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImplBase.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImplBase.this.a(i, menu);
            return true;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.b(i, menu);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }
    }

    static {
        f2140d = Build.VERSION.SDK_INT < 21;
        if (f2140d && !f2139c) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.AppCompatDelegateImplBase.1
                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
            f2139c = true;
        }
        f2141e = new int[]{android.R.attr.windowBackground};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f2142f = context;
        this.f2143g = window;
        this.j = appCompatCallback;
        this.f2144h = this.f2143g.getCallback();
        Window.Callback callback = this.f2144h;
        if (!(callback instanceof AppCompatWindowCallbackBase)) {
            this.i = a(callback);
            this.f2143g.setCallback(this.i);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, f2141e);
            Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
            if (drawableIfKnown != null) {
                this.f2143g.setBackgroundDrawable(drawableIfKnown);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    Window.Callback a(Window.Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    abstract void a(CharSequence charSequence);

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(int i, Menu menu);

    abstract boolean a(KeyEvent keyEvent);

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence b() {
        Window.Callback callback = this.f2144h;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.r;
    }

    abstract void b(int i, Menu menu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Window.Callback c() {
        return this.f2143g.getCallback();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBar e() {
        return this.k;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.l == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.k;
            this.l = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.f2142f);
        }
        return this.l;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.k;
    }

    abstract void initWindowDecorActionBar();

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        this.t = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStart() {
        this.s = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onStop() {
        this.s = false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.r = charSequence;
        a(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.f2142f : themedContext;
    }
}
