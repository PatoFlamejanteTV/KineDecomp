package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    private static final boolean u;
    PopupWindow A;
    Runnable B;
    ViewPropertyAnimatorCompat C;
    private boolean D;
    private ViewGroup E;
    private TextView F;
    private View G;
    private boolean H;
    private boolean I;
    private boolean J;
    private PanelFeatureState[] K;
    private PanelFeatureState L;
    private boolean M;
    boolean N;
    int O;
    private final Runnable P;
    private boolean Q;
    private Rect R;
    private Rect S;
    private AppCompatViewInflater T;
    private DecorContentParent v;
    private ActionMenuPresenterCallback w;
    private PanelMenuPresenterCallback x;
    ActionMode y;
    ActionBarContextView z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV9.this.a(menuBuilder);
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback c2 = AppCompatDelegateImplV9.this.c();
            if (c2 == null) {
                return true;
            }
            c2.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        private ActionMode.Callback f2165a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f2165a = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2165a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2165a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2165a.onDestroyActionMode(actionMode);
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (appCompatDelegateImplV9.A != null) {
                appCompatDelegateImplV9.f2143g.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.B);
            }
            AppCompatDelegateImplV9 appCompatDelegateImplV92 = AppCompatDelegateImplV9.this;
            if (appCompatDelegateImplV92.z != null) {
                appCompatDelegateImplV92.g();
                AppCompatDelegateImplV9 appCompatDelegateImplV93 = AppCompatDelegateImplV9.this;
                appCompatDelegateImplV93.C = ViewCompat.animate(appCompatDelegateImplV93.z).alpha(0.0f);
                AppCompatDelegateImplV9.this.C.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV9.this.z.setVisibility(8);
                        AppCompatDelegateImplV9 appCompatDelegateImplV94 = AppCompatDelegateImplV9.this;
                        PopupWindow popupWindow = appCompatDelegateImplV94.A;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImplV94.z.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.z.getParent());
                        }
                        AppCompatDelegateImplV9.this.z.removeAllViews();
                        AppCompatDelegateImplV9.this.C.setListener(null);
                        AppCompatDelegateImplV9.this.C = null;
                    }
                });
            }
            AppCompatDelegateImplV9 appCompatDelegateImplV94 = AppCompatDelegateImplV9.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImplV94.j;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImplV94.y);
            }
            AppCompatDelegateImplV9.this.y = null;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f2165a.onPrepareActionMode(actionMode, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV9.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImplV9.this.a(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState a2 = appCompatDelegateImplV9.a((Menu) menuBuilder);
            if (a2 != null) {
                if (z2) {
                    AppCompatDelegateImplV9.this.a(a2.f2168a, a2, rootMenu);
                    AppCompatDelegateImplV9.this.a(a2, true);
                } else {
                    AppCompatDelegateImplV9.this.a(a2, z);
                }
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback c2;
            if (menuBuilder != null) {
                return true;
            }
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (!appCompatDelegateImplV9.m || (c2 = appCompatDelegateImplV9.c()) == null || AppCompatDelegateImplV9.this.d()) {
                return true;
            }
            c2.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        u = Build.VERSION.SDK_INT < 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.C = null;
        this.P = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
                if ((appCompatDelegateImplV9.O & 1) != 0) {
                    appCompatDelegateImplV9.b(0);
                }
                AppCompatDelegateImplV9 appCompatDelegateImplV92 = AppCompatDelegateImplV9.this;
                if ((appCompatDelegateImplV92.O & 4096) != 0) {
                    appCompatDelegateImplV92.b(108);
                }
                AppCompatDelegateImplV9 appCompatDelegateImplV93 = AppCompatDelegateImplV9.this;
                appCompatDelegateImplV93.N = false;
                appCompatDelegateImplV93.O = 0;
            }
        };
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i, true);
        if (a2.o) {
            return false;
        }
        return b(a2, keyEvent);
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        DecorContentParent decorContentParent;
        if (this.y != null) {
            return false;
        }
        PanelFeatureState a2 = a(i, true);
        if (i == 0 && (decorContentParent = this.v) != null && decorContentParent.canShowOverflowMenu() && !ViewConfiguration.get(this.f2142f).hasPermanentMenuKey()) {
            if (!this.v.isOverflowMenuShowing()) {
                if (!d() && b(a2, keyEvent)) {
                    z = this.v.showOverflowMenu();
                }
                z = false;
            } else {
                z = this.v.hideOverflowMenu();
            }
        } else if (!a2.o && !a2.n) {
            if (a2.m) {
                if (a2.q) {
                    a2.m = false;
                    z2 = b(a2, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    a(a2, keyEvent);
                    z = true;
                }
            }
            z = false;
        } else {
            z = a2.o;
            a(a2, true);
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.f2142f.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void j() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.E.findViewById(R.id.content);
        View decorView = this.f2143g.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f2142f.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup k() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f2142f.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.p = obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f2143g.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f2142f);
            if (!this.q) {
                if (this.p) {
                    viewGroup = (ViewGroup) from.inflate(android.support.v7.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.n = false;
                    this.m = false;
                } else if (this.m) {
                    TypedValue typedValue = new TypedValue();
                    this.f2142f.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                    int i = typedValue.resourceId;
                    if (i != 0) {
                        context = new ContextThemeWrapper(this.f2142f, i);
                    } else {
                        context = this.f2142f;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(android.support.v7.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                    this.v = (DecorContentParent) viewGroup.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
                    this.v.setWindowCallback(c());
                    if (this.n) {
                        this.v.initFeature(109);
                    }
                    if (this.H) {
                        this.v.initFeature(2);
                    }
                    if (this.I) {
                        this.v.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                if (this.o) {
                    viewGroup = (ViewGroup) from.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.2
                        @Override // android.support.v4.view.OnApplyWindowInsetsListener
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            int c2 = AppCompatDelegateImplV9.this.c(systemWindowInsetTop);
                            if (systemWindowInsetTop != c2) {
                                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), c2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                        }
                    });
                } else {
                    ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.3
                        @Override // android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                        public void onFitSystemWindows(Rect rect) {
                            rect.top = AppCompatDelegateImplV9.this.c(rect.top);
                        }
                    });
                }
            }
            if (viewGroup != null) {
                if (this.v == null) {
                    this.F = (TextView) viewGroup.findViewById(android.support.v7.appcompat.R.id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f2143g.findViewById(R.id.content);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(R.id.content);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f2143g.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.4
                    @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
                    public void onAttachedFromWindow() {
                    }

                    @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
                    public void onDetachedFromWindow() {
                        AppCompatDelegateImplV9.this.f();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.q + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void l() {
        if (this.D) {
            return;
        }
        this.E = k();
        CharSequence b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            a(b2);
        }
        j();
        a(this.E);
        this.D = true;
        PanelFeatureState a2 = a(0, false);
        if (d()) {
            return;
        }
        if (a2 == null || a2.j == null) {
            d(108);
        }
    }

    private void m() {
        if (this.D) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    void a(ViewGroup viewGroup) {
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    void a(CharSequence charSequence) {
        DecorContentParent decorContentParent = this.v;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (e() != null) {
            e().setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        l();
        ((ViewGroup) this.E.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2144h.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    void b(int i, Menu menu) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.M;
            this.M = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            }
            if (h()) {
                return true;
            }
        } else if (i == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.app.AppCompatDelegate
    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.T == null) {
            String string = this.f2142f.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme).getString(android.support.v7.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string != null && !AppCompatViewInflater.class.getName().equals(string)) {
                try {
                    this.T = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.T = new AppCompatViewInflater();
                }
            } else {
                this.T = new AppCompatViewInflater();
            }
        }
        if (u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = a((ViewParent) view);
            }
            z = z2;
        } else {
            z = false;
        }
        return this.T.a(view, str, context, attributeSet, z, u, true, VectorEnabledTintResources.shouldBeUsed());
    }

    void f() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.v;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.A != null) {
            this.f2143g.getDecorView().removeCallbacks(this.B);
            if (this.A.isShowing()) {
                try {
                    this.A.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.A = null;
        }
        g();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || (menuBuilder = a2.j) == null) {
            return;
        }
        menuBuilder.close();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public <T extends View> T findViewById(int i) {
        l();
        return (T) this.f2143g.findViewById(i);
    }

    void g() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.C;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    boolean h() {
        ActionMode actionMode = this.y;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int e2 = e(i);
        if (e2 == 1) {
            return this.q;
        }
        if (e2 == 2) {
            return this.H;
        }
        if (e2 == 5) {
            return this.I;
        }
        if (e2 == 10) {
            return this.o;
        }
        if (e2 == 108) {
            return this.m;
        }
        if (e2 != 109) {
            return false;
        }
        return this.n;
    }

    final boolean i() {
        ViewGroup viewGroup;
        return this.D && (viewGroup = this.E) != null && ViewCompat.isLaidOut(viewGroup);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    public void initWindowDecorActionBar() {
        l();
        if (this.m && this.k == null) {
            Window.Callback callback = this.f2144h;
            if (callback instanceof Activity) {
                this.k = new WindowDecorActionBar((Activity) callback, this.n);
            } else if (callback instanceof Dialog) {
                this.k = new WindowDecorActionBar((Dialog) callback);
            }
            ActionBar actionBar = this.k;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.Q);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f2142f);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else {
            if (from.getFactory2() instanceof AppCompatDelegateImplV9) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            d(0);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.m && this.D && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.f2142f);
        applyDayNight();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        Window.Callback callback = this.f2144h;
        if (!(callback instanceof Activity) || NavUtils.getParentActivityName((Activity) callback) == null) {
            return;
        }
        ActionBar e2 = e();
        if (e2 == null) {
            this.Q = true;
        } else {
            e2.setDefaultDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 != null ? a2 : createView(view, str, context, attributeSet);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        if (this.N) {
            this.f2143g.getDecorView().removeCallbacks(this.P);
        }
        super.onDestroy();
        ActionBar actionBar = this.k;
        if (actionBar != null) {
            actionBar.a();
        }
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback c2 = c();
        if (c2 == null || d() || (a2 = a((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return c2.onMenuItemSelected(a2.f2168a, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        a(menuBuilder, true);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        l();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int e2 = e(i);
        if (this.q && e2 == 108) {
            return false;
        }
        if (this.m && e2 == 1) {
            this.m = false;
        }
        if (e2 == 1) {
            m();
            this.q = true;
            return true;
        }
        if (e2 == 2) {
            m();
            this.H = true;
            return true;
        }
        if (e2 == 5) {
            m();
            this.I = true;
            return true;
        }
        if (e2 == 10) {
            m();
            this.o = true;
            return true;
        }
        if (e2 == 108) {
            m();
            this.m = true;
            return true;
        }
        if (e2 != 109) {
            return this.f2143g.requestFeature(e2);
        }
        m();
        this.n = true;
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2144h.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f2144h instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (!(supportActionBar instanceof WindowDecorActionBar)) {
                this.l = null;
                if (supportActionBar != null) {
                    supportActionBar.a();
                }
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, ((Activity) this.f2144h).getTitle(), this.i);
                    this.k = toolbarActionBar;
                    this.f2143g.setCallback(toolbarActionBar.getWrappedWindowCallback());
                } else {
                    this.k = null;
                    this.f2143g.setCallback(this.i);
                }
                invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            ActionMode actionMode = this.y;
            if (actionMode != null) {
                actionMode.finish();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                this.y = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
                ActionMode actionMode2 = this.y;
                if (actionMode2 != null && (appCompatCallback = this.j) != null) {
                    appCompatCallback.onSupportActionModeStarted(actionMode2);
                }
            }
            if (this.y == null) {
                this.y = a(actionModeCallbackWrapperV9);
            }
            return this.y;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private void d(int i) {
        this.O = (1 << i) | this.O;
        if (this.N) {
            return;
        }
        ViewCompat.postOnAnimation(this.f2143g.getDecorView(), this.P);
        this.N = true;
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.M = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(int i) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2142f).inflate(i, viewGroup);
        this.f2144h.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean a(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(a());
        panelFeatureState.f2174g = new ListMenuDecorView(panelFeatureState.l);
        panelFeatureState.f2170c = 81;
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        Context context = this.f2142f;
        int i = panelFeatureState.f2168a;
        if ((i == 0 || i == 108) && this.v != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.a(menuBuilder);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.support.v7.view.ActionMode a(android.support.v7.view.ActionMode.Callback r8) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.a(android.support.v7.view.ActionMode$Callback):android.support.v7.view.ActionMode");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (d()) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.L;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            a(panelFeatureState2, false);
        }
        Window.Callback c2 = c();
        if (c2 != null) {
            panelFeatureState.i = c2.onCreatePanelView(panelFeatureState.f2168a);
        }
        int i = panelFeatureState.f2168a;
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent3 = this.v) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z || !(e() instanceof ToolbarActionBar))) {
            if (panelFeatureState.j == null || panelFeatureState.q) {
                if (panelFeatureState.j == null && (!c(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.v != null) {
                    if (this.w == null) {
                        this.w = new ActionMenuPresenterCallback();
                    }
                    this.v.setMenu(panelFeatureState.j, this.w);
                }
                panelFeatureState.j.stopDispatchingItemsChanged();
                if (!c2.onCreatePanelMenu(panelFeatureState.f2168a, panelFeatureState.j)) {
                    panelFeatureState.a((MenuBuilder) null);
                    if (z && (decorContentParent = this.v) != null) {
                        decorContentParent.setMenu(null, this.w);
                    }
                    return false;
                }
                panelFeatureState.q = false;
            }
            panelFeatureState.j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.r;
            if (bundle != null) {
                panelFeatureState.j.restoreActionViewStates(bundle);
                panelFeatureState.r = null;
            }
            if (!c2.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z && (decorContentParent2 = this.v) != null) {
                    decorContentParent2.setMenu(null, this.w);
                }
                panelFeatureState.j.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.j.startDispatchingItemsChanged();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.L = panelFeatureState;
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        l();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2144h.onContentChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        int f2168a;

        /* renamed from: b, reason: collision with root package name */
        int f2169b;

        /* renamed from: c, reason: collision with root package name */
        int f2170c;

        /* renamed from: d, reason: collision with root package name */
        int f2171d;

        /* renamed from: e, reason: collision with root package name */
        int f2172e;

        /* renamed from: f, reason: collision with root package name */
        int f2173f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f2174g;

        /* renamed from: h, reason: collision with root package name */
        View f2175h;
        View i;
        MenuBuilder j;
        ListMenuPresenter k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        boolean p = false;
        boolean q;
        public boolean qwertyMode;
        Bundle r;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }
            };

            /* renamed from: a, reason: collision with root package name */
            int f2176a;

            /* renamed from: b, reason: collision with root package name */
            boolean f2177b;

            /* renamed from: c, reason: collision with root package name */
            Bundle f2178c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f2176a = parcel.readInt();
                savedState.f2177b = parcel.readInt() == 1;
                if (savedState.f2177b) {
                    savedState.f2178c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2176a);
                parcel.writeInt(this.f2177b ? 1 : 0);
                if (this.f2177b) {
                    parcel.writeBundle(this.f2178c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f2168a = i;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(android.support.v7.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
            this.f2169b = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f2173f = obtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.j;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.k);
            }
            this.k = null;
        }

        public boolean hasPanelItems() {
            if (this.f2175h == null) {
                return false;
            }
            return this.i != null || this.k.getAdapter().getCount() > 0;
        }

        void a(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.k);
            }
            this.j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.k) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new ListMenuPresenter(this.l, android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
                this.k.setCallback(callback);
                this.j.addMenuPresenter(this.k);
            }
            return this.k.getMenuView(this.f2174g);
        }
    }

    private int e(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    int c(int i) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.z;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
            if (this.z.isShown()) {
                if (this.R == null) {
                    this.R = new Rect();
                    this.S = new Rect();
                }
                Rect rect = this.R;
                Rect rect2 = this.S;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.E, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.G;
                    if (view == null) {
                        this.G = new View(this.f2142f);
                        this.G.setBackgroundColor(this.f2142f.getResources().getColor(android.support.v7.appcompat.R.color.abc_input_method_navigation_guard));
                        this.E.addView(this.G, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.G.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.G != null;
                if (!this.o && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.z.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    void b(int i) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a3.r = bundle;
            }
            a3.j.stopDispatchingItemsChanged();
            a3.j.clear();
        }
        a3.q = true;
        a3.p = true;
        if ((i != 108 && i != 0) || this.v == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean a(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.L;
        if (panelFeatureState != null && a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.L;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.L == null) {
            PanelFeatureState a2 = a(0, true);
            b(a2, keyEvent);
            boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
            a2.m = false;
            if (a3) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f2144h.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? b(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2143g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        Window.Callback callback = this.f2144h;
        if (!(callback instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) callback).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || d()) {
            return;
        }
        if (panelFeatureState.f2168a == 0) {
            if ((this.f2142f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback c2 = c();
        if (c2 != null && !c2.onMenuOpened(panelFeatureState.f2168a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2142f.getSystemService("window");
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.f2174g != null && !panelFeatureState.p) {
                View view = panelFeatureState.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f2171d, panelFeatureState.f2172e, 1002, 8519680, -3);
                    layoutParams2.gravity = panelFeatureState.f2170c;
                    layoutParams2.windowAnimations = panelFeatureState.f2173f;
                    windowManager.addView(panelFeatureState.f2174g, layoutParams2);
                    panelFeatureState.o = true;
                }
            } else {
                ViewGroup viewGroup = panelFeatureState.f2174g;
                if (viewGroup == null) {
                    if (!b(panelFeatureState) || panelFeatureState.f2174g == null) {
                        return;
                    }
                } else if (panelFeatureState.p && viewGroup.getChildCount() > 0) {
                    panelFeatureState.f2174g.removeAllViews();
                }
                if (!a(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f2175h.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f2174g.setBackgroundResource(panelFeatureState.f2169b);
                ViewParent parent = panelFeatureState.f2175h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f2175h);
                }
                panelFeatureState.f2174g.addView(panelFeatureState.f2175h, layoutParams3);
                if (!panelFeatureState.f2175h.hasFocus()) {
                    panelFeatureState.f2175h.requestFocus();
                }
            }
            i = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f2171d, panelFeatureState.f2172e, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.f2170c;
            layoutParams22.windowAnimations = panelFeatureState.f2173f;
            windowManager.addView(panelFeatureState.f2174g, layoutParams22);
            panelFeatureState.o = true;
        }
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        DecorContentParent decorContentParent = this.v;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.f2142f).hasPermanentMenuKey() || this.v.isOverflowMenuShowPending())) {
            Window.Callback c2 = c();
            if (this.v.isOverflowMenuShowing() && z) {
                this.v.hideOverflowMenu();
                if (d()) {
                    return;
                }
                c2.onPanelClosed(108, a(0, true).j);
                return;
            }
            if (c2 == null || d()) {
                return;
            }
            if (this.N && (this.O & 1) != 0) {
                this.f2143g.getDecorView().removeCallbacks(this.P);
                this.P.run();
            }
            PanelFeatureState a2 = a(0, true);
            MenuBuilder menuBuilder2 = a2.j;
            if (menuBuilder2 == null || a2.q || !c2.onPreparePanel(0, a2.i, menuBuilder2)) {
                return;
            }
            c2.onMenuOpened(108, a2.j);
            this.v.showOverflowMenu();
            return;
        }
        PanelFeatureState a3 = a(0, true);
        a3.p = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.f2175h = view;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.x == null) {
            this.x = new PanelMenuPresenterCallback();
        }
        panelFeatureState.f2175h = (View) panelFeatureState.a(this.x);
        return panelFeatureState.f2175h != null;
    }

    void a(MenuBuilder menuBuilder) {
        if (this.J) {
            return;
        }
        this.J = true;
        this.v.dismissPopups();
        Window.Callback c2 = c();
        if (c2 != null && !d()) {
            c2.onPanelClosed(108, menuBuilder);
        }
        this.J = false;
    }

    void a(int i) {
        a(a(i, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.f2168a == 0 && (decorContentParent = this.v) != null && decorContentParent.isOverflowMenuShowing()) {
            a(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2142f.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.f2174g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(panelFeatureState.f2168a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.f2175h = null;
        panelFeatureState.p = true;
        if (this.L == panelFeatureState) {
            this.L = null;
        }
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.K;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !d()) {
            this.f2144h.onPanelClosed(i, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.K;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PanelFeatureState a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.K;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.K = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.j) != null) {
            z = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.v == null) {
            a(panelFeatureState, true);
        }
        return z;
    }
}
