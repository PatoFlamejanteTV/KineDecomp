package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f2224a = new AccelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private static final Interpolator f2225b = new DecelerateInterpolator();
    private boolean A;
    ViewPropertyAnimatorCompatSet C;
    private boolean D;
    boolean E;

    /* renamed from: c, reason: collision with root package name */
    Context f2226c;

    /* renamed from: d, reason: collision with root package name */
    private Context f2227d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f2228e;

    /* renamed from: f, reason: collision with root package name */
    private Dialog f2229f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarOverlayLayout f2230g;

    /* renamed from: h, reason: collision with root package name */
    ActionBarContainer f2231h;
    DecorToolbar i;
    ActionBarContextView j;
    View k;
    ScrollingTabContainerView l;
    private TabImpl n;
    private boolean p;
    ActionModeImpl q;
    ActionMode r;
    ActionMode.Callback s;
    private boolean t;
    private boolean v;
    boolean y;
    boolean z;
    private ArrayList<TabImpl> m = new ArrayList<>();
    private int o = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> u = new ArrayList<>();
    private int w = 0;
    boolean x = true;
    private boolean B = true;
    final ViewPropertyAnimatorListener F = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.x && (view2 = windowDecorActionBar.k) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f2231h.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f2231h.setVisibility(8);
            WindowDecorActionBar.this.f2231h.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.C = null;
            windowDecorActionBar2.b();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f2230g;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener G = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.C = null;
            windowDecorActionBar.f2231h.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener H = new ViewPropertyAnimatorUpdateListener() { // from class: android.support.v7.app.WindowDecorActionBar.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.f2231h.getParent()).invalidate();
        }
    };

    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: c, reason: collision with root package name */
        private final Context f2235c;

        /* renamed from: d, reason: collision with root package name */
        private final MenuBuilder f2236d;

        /* renamed from: e, reason: collision with root package name */
        private ActionMode.Callback f2237e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<View> f2238f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f2235c = context;
            this.f2237e = callback;
            this.f2236d = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f2236d.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.f2236d.stopDispatchingItemsChanged();
            try {
                return this.f2237e.onCreateActionMode(this, this.f2236d);
            } finally {
                this.f2236d.startDispatchingItemsChanged();
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.q != this) {
                return;
            }
            if (!WindowDecorActionBar.a(windowDecorActionBar.y, windowDecorActionBar.z, false)) {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.r = this;
                windowDecorActionBar2.s = this.f2237e;
            } else {
                this.f2237e.onDestroyActionMode(this);
            }
            this.f2237e = null;
            WindowDecorActionBar.this.animateToMode(false);
            WindowDecorActionBar.this.j.closeMode();
            WindowDecorActionBar.this.i.getViewGroup().sendAccessibilityEvent(32);
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.f2230g.setHideOnContentScrollEnabled(windowDecorActionBar3.E);
            WindowDecorActionBar.this.q = null;
        }

        @Override // android.support.v7.view.ActionMode
        public View getCustomView() {
            WeakReference<View> weakReference = this.f2238f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // android.support.v7.view.ActionMode
        public Menu getMenu() {
            return this.f2236d;
        }

        @Override // android.support.v7.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f2235c);
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.j.getSubtitle();
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.j.getTitle();
        }

        @Override // android.support.v7.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.q != this) {
                return;
            }
            this.f2236d.stopDispatchingItemsChanged();
            try {
                this.f2237e.onPrepareActionMode(this, this.f2236d);
            } finally {
                this.f2236d.startDispatchingItemsChanged();
            }
        }

        @Override // android.support.v7.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.j.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f2237e;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f2237e == null) {
                return;
            }
            invalidate();
            WindowDecorActionBar.this.j.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f2237e == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        @Override // android.support.v7.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.j.setCustomView(view);
            this.f2238f = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.j.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.j.setTitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.j.setTitleOptional(z);
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.f2226c.getResources().getString(i));
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.f2226c.getResources().getString(i));
        }
    }

    /* loaded from: classes.dex */
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: a, reason: collision with root package name */
        private ActionBar.TabListener f2240a;

        /* renamed from: b, reason: collision with root package name */
        private Object f2241b;

        /* renamed from: c, reason: collision with root package name */
        private Drawable f2242c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f2243d;

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f2244e;

        /* renamed from: f, reason: collision with root package name */
        private int f2245f = -1;

        /* renamed from: g, reason: collision with root package name */
        private View f2246g;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.f2240a;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.f2244e;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public View getCustomView() {
            return this.f2246g;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.f2242c;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public int getPosition() {
            return this.f2245f;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public Object getTag() {
            return this.f2241b;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public CharSequence getText() {
            return this.f2243d;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.f2226c.getResources().getText(i));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.f2246g = view;
            int i = this.f2245f;
            if (i >= 0) {
                WindowDecorActionBar.this.l.updateTab(i);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f2242c = drawable;
            int i = this.f2245f;
            if (i >= 0) {
                WindowDecorActionBar.this.l.updateTab(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.f2245f = i;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f2240a = tabListener;
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.f2241b = obj;
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f2243d = charSequence;
            int i = this.f2245f;
            if (i >= 0) {
                WindowDecorActionBar.this.l.updateTab(i);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f2244e = charSequence;
            int i = this.f2245f;
            if (i >= 0) {
                WindowDecorActionBar.this.l.updateTab(i);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.f2226c, i));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.f2226c.getResources().getText(i));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f2228e = activity;
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (z) {
            return;
        }
        this.k = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void b(View view) {
        this.f2230g = (ActionBarOverlayLayout) view.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.i = a(view.findViewById(android.support.v7.appcompat.R.id.action_bar));
        this.j = (ActionBarContextView) view.findViewById(android.support.v7.appcompat.R.id.action_context_bar);
        this.f2231h = (ActionBarContainer) view.findViewById(android.support.v7.appcompat.R.id.action_bar_container);
        DecorToolbar decorToolbar = this.i;
        if (decorToolbar != null && this.j != null && this.f2231h != null) {
            this.f2226c = decorToolbar.getContext();
            boolean z = (this.i.getDisplayOptions() & 4) != 0;
            if (z) {
                this.p = true;
            }
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f2226c);
            setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
            a(actionBarPolicy.hasEmbeddedTabs());
            TypedArray obtainStyledAttributes = this.f2226c.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
                setHideOnContentScrollEnabled(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                setElevation(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void c() {
        if (this.n != null) {
            selectTab(null);
        }
        this.m.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.l;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.o = -1;
    }

    private void d() {
        if (this.l != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f2226c);
        if (this.v) {
            scrollingTabContainerView.setVisibility(0);
            this.i.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.f2231h.setTabContainer(scrollingTabContainerView);
        }
        this.l = scrollingTabContainerView;
    }

    private void e() {
        if (this.A) {
            this.A = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            b(false);
        }
    }

    private boolean f() {
        return ViewCompat.isLaidOut(this.f2231h);
    }

    private void g() {
        if (this.A) {
            return;
        }
        this.A = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        b(false);
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.u.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.m.isEmpty());
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            g();
        } else {
            e();
        }
        if (!f()) {
            if (z) {
                this.i.setVisibility(4);
                this.j.setVisibility(0);
                return;
            } else {
                this.i.setVisibility(0);
                this.j.setVisibility(8);
                return;
            }
        }
        if (z) {
            viewPropertyAnimatorCompat2 = this.i.setupAnimatorToVisibility(4, 100L);
            viewPropertyAnimatorCompat = this.j.setupAnimatorToVisibility(0, 200L);
        } else {
            viewPropertyAnimatorCompat = this.i.setupAnimatorToVisibility(0, 200L);
            viewPropertyAnimatorCompat2 = this.j.setupAnimatorToVisibility(8, 100L);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.start();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.i;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.i.collapseActionView();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.t) {
            return;
        }
        this.t = z;
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            this.u.get(i).onMenuVisibilityChanged(z);
        }
    }

    public void doHide(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.C;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.w == 0 && (this.D || z)) {
            this.f2231h.setAlpha(1.0f);
            this.f2231h.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            float f2 = -this.f2231h.getHeight();
            if (z) {
                this.f2231h.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f2231h).translationY(f2);
            translationY.setUpdateListener(this.H);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.x && (view = this.k) != null) {
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f2));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f2224a);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(this.F);
            this.C = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
            return;
        }
        this.F.onAnimationEnd(null);
    }

    public void doShow(boolean z) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.C;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.f2231h.setVisibility(0);
        if (this.w == 0 && (this.D || z)) {
            this.f2231h.setTranslationY(0.0f);
            float f2 = -this.f2231h.getHeight();
            if (z) {
                this.f2231h.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.f2231h.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f2231h).translationY(0.0f);
            translationY.setUpdateListener(this.H);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.x && (view2 = this.k) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.k).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f2225b);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(this.G);
            this.C = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        } else {
            this.f2231h.setAlpha(1.0f);
            this.f2231h.setTranslationY(0.0f);
            if (this.x && (view = this.k) != null) {
                view.setTranslationY(0.0f);
            }
            this.G.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.x = z;
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.i.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.i.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.f2231h);
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.f2231h.getHeight();
    }

    @Override // android.support.v7.app.ActionBar
    public int getHideOffset() {
        return this.f2230g.getActionBarHideOffset();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        int navigationMode = this.i.getNavigationMode();
        if (navigationMode == 1) {
            return this.i.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.m.size();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return this.i.getNavigationMode();
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.i.getNavigationMode();
        if (navigationMode == 1) {
            return this.i.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.n) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.n;
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.i.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        return this.m.get(i);
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return this.m.size();
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        if (this.f2227d == null) {
            TypedValue typedValue = new TypedValue();
            this.f2226c.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f2227d = new ContextThemeWrapper(this.f2226c, i);
            } else {
                this.f2227d = this.f2226c;
            }
        }
        return this.f2227d;
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.i.getTitle();
    }

    public boolean hasIcon() {
        return this.i.hasIcon();
    }

    public boolean hasLogo() {
        return this.i.hasLogo();
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        if (this.y) {
            return;
        }
        this.y = true;
        b(false);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (this.z) {
            return;
        }
        this.z = true;
        b(true);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.f2230g.isHideOnContentScrollEnabled();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.B && (height == 0 || getHideOffset() < height);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.i;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        a(ActionBarPolicy.get(this.f2226c).hasEmbeddedTabs());
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.C;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.C = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu;
        ActionModeImpl actionModeImpl = this.q;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        this.w = i;
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        c();
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.u.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int i) {
        if (this.l == null) {
            return;
        }
        TabImpl tabImpl = this.n;
        int position = tabImpl != null ? tabImpl.getPosition() : this.o;
        this.l.removeTabAt(i);
        TabImpl remove = this.m.remove(i);
        if (remove != null) {
            remove.setPosition(-1);
        }
        int size = this.m.size();
        for (int i2 = i; i2 < size; i2++) {
            this.m.get(i2).setPosition(i2);
        }
        if (position == i) {
            selectTab(this.m.isEmpty() ? null : this.m.get(Math.max(0, i - 1)));
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.i.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        if (getNavigationMode() != 2) {
            this.o = tab != null ? tab.getPosition() : -1;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.f2228e instanceof FragmentActivity) || this.i.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.f2228e).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        TabImpl tabImpl = this.n;
        if (tabImpl != tab) {
            this.l.setTabSelected(tab != null ? tab.getPosition() : -1);
            TabImpl tabImpl2 = this.n;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.n, disallowAddToBackStack);
            }
            this.n = (TabImpl) tab;
            TabImpl tabImpl3 = this.n;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.n, disallowAddToBackStack);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.n, disallowAddToBackStack);
            this.l.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack == null || disallowAddToBackStack.isEmpty()) {
            return;
        }
        disallowAddToBackStack.commit();
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.f2231h.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.i.getViewGroup(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (this.p) {
            return;
        }
        setDisplayHomeAsUpEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.p = true;
        }
        this.i.setDisplayOptions(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float f2) {
        ViewCompat.setElevation(this.f2231h, f2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.f2230g.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.f2230g.setActionBarHideOffset(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.f2230g.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.E = z;
        this.f2230g.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.i.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.i.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        this.i.setHomeButtonEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int i) {
        this.i.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.i.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.i.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int i) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.i.getNavigationMode();
        if (navigationMode == 2) {
            this.o = getSelectedNavigationIndex();
            selectTab(null);
            this.l.setVisibility(8);
        }
        if (navigationMode != i && !this.v && (actionBarOverlayLayout = this.f2230g) != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.i.setNavigationMode(i);
        boolean z = false;
        if (i == 2) {
            d();
            this.l.setVisibility(0);
            int i2 = this.o;
            if (i2 != -1) {
                setSelectedNavigationItem(i2);
                this.o = -1;
            }
        }
        this.i.setCollapsible(i == 2 && !this.v);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2230g;
        if (i == 2 && !this.v) {
            z = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        int navigationMode = this.i.getNavigationMode();
        if (navigationMode == 1) {
            this.i.setDropdownSelectedPosition(i);
        } else {
            if (navigationMode == 2) {
                selectTab(this.m.get(i));
                return;
            }
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.D = z;
        if (z || (viewPropertyAnimatorCompatSet = this.C) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f2231h.setStackedBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int i) {
        setSubtitle(this.f2226c.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int i) {
        setTitle(this.f2226c.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.i.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        if (this.y) {
            this.y = false;
            b(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.z) {
            this.z = false;
            b(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.q;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.f2230g.setHideOnContentScrollEnabled(false);
        this.j.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.j.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.q = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.j.initForMode(actionModeImpl2);
        animateToMode(true);
        this.j.sendAccessibilityEvent(32);
        return actionModeImpl2;
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.m.isEmpty());
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.i.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.i.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.i.setIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.i.setLogo(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        d();
        this.l.addTab(tab, z);
        a(tab, this.m.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.i.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.p = true;
        }
        this.i.setDisplayOptions((i & i2) | ((i2 ^ (-1)) & displayOptions));
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        this.i.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.i.setCustomView(view);
    }

    private void a(boolean z) {
        this.v = z;
        if (!this.v) {
            this.i.setEmbeddedTabView(null);
            this.f2231h.setTabContainer(this.l);
        } else {
            this.f2231h.setTabContainer(null);
            this.i.setEmbeddedTabView(this.l);
        }
        boolean z2 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.l;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2230g;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.i.setCollapsible(!this.v && z2);
        this.f2230g.setHasNonEmbeddedTabs(!this.v && z2);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        d();
        this.l.addTab(tab, i, z);
        a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f2229f = dialog;
        b(dialog.getWindow().getDecorView());
    }

    private void a(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i);
            this.m.add(i, tabImpl);
            int size = this.m.size();
            while (true) {
                i++;
                if (i >= size) {
                    return;
                } else {
                    this.m.get(i).setPosition(i);
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    void b() {
        ActionMode.Callback callback = this.s;
        if (callback != null) {
            callback.onDestroyActionMode(this.r);
            this.r = null;
            this.s = null;
        }
    }

    private void b(boolean z) {
        if (a(this.y, this.z, this.A)) {
            if (this.B) {
                return;
            }
            this.B = true;
            doShow(z);
            return;
        }
        if (this.B) {
            this.B = false;
            doHide(z);
        }
    }

    public WindowDecorActionBar(View view) {
        b(view);
    }
}
