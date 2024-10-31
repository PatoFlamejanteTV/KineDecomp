package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f3131a;

    /* renamed from: b, reason: collision with root package name */
    private int f3132b;

    /* renamed from: c, reason: collision with root package name */
    private View f3133c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f3134d;

    /* renamed from: e, reason: collision with root package name */
    private View f3135e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f3136f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f3137g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f3138h;
    private boolean i;
    CharSequence j;
    private CharSequence k;
    private CharSequence l;
    Window.Callback m;
    boolean n;
    private ActionMenuPresenter o;
    private int p;
    private int q;
    private Drawable r;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    private int a() {
        if (this.f3131a.getNavigationIcon() == null) {
            return 11;
        }
        this.r = this.f3131a.getNavigationIcon();
        return 15;
    }

    private void b() {
        if (this.f3134d == null) {
            this.f3134d = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.f3134d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void c() {
        if ((this.f3132b & 4) != 0) {
            if (TextUtils.isEmpty(this.l)) {
                this.f3131a.setNavigationContentDescription(this.q);
            } else {
                this.f3131a.setNavigationContentDescription(this.l);
            }
        }
    }

    private void d() {
        if ((this.f3132b & 4) != 0) {
            Toolbar toolbar = this.f3131a;
            Drawable drawable = this.f3138h;
            if (drawable == null) {
                drawable = this.r;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f3131a.setNavigationIcon((Drawable) null);
    }

    private void e() {
        Drawable drawable;
        int i = this.f3132b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f3137g;
            if (drawable == null) {
                drawable = this.f3136f;
            }
        } else {
            drawable = this.f3136f;
        }
        this.f3131a.setLogo(drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200L);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f3131a.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void collapseActionView() {
        this.f3131a.collapseActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.f3131a.dismissPopupMenus();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public Context getContext() {
        return this.f3131a.getContext();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public View getCustomView() {
        return this.f3135e;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.f3132b;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner spinner = this.f3134d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner spinner = this.f3134d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getHeight() {
        return this.f3131a.getHeight();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public Menu getMenu() {
        return this.f3131a.getMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getNavigationMode() {
        return this.p;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.f3131a.getSubtitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f3131a.getTitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.f3131a;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getVisibility() {
        return this.f3131a.getVisibility();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        return this.f3133c != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.f3131a.hasExpandedActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasIcon() {
        return this.f3136f != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasLogo() {
        return this.f3137g != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f3131a.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f3131a.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f3131a.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.f3131a.isTitleTruncated();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f3131a.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f3131a.saveHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.f3131a, drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.f3131a.setCollapsible(z);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setCustomView(View view) {
        View view2 = this.f3135e;
        if (view2 != null && (this.f3132b & 16) != 0) {
            this.f3131a.removeView(view2);
        }
        this.f3135e = view;
        if (view == null || (this.f3132b & 16) == 0) {
            return;
        }
        this.f3131a.addView(this.f3135e);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i) {
        if (i == this.q) {
            return;
        }
        this.q = i;
        if (TextUtils.isEmpty(this.f3131a.getNavigationContentDescription())) {
            setNavigationContentDescription(this.q);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            d();
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.f3132b ^ i;
        this.f3132b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    c();
                }
                d();
            }
            if ((i2 & 3) != 0) {
                e();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f3131a.setTitle(this.j);
                    this.f3131a.setSubtitle(this.k);
                } else {
                    this.f3131a.setTitle((CharSequence) null);
                    this.f3131a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f3135e) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f3131a.addView(view);
            } else {
                this.f3131a.removeView(view);
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        b();
        this.f3134d.setAdapter(spinnerAdapter);
        this.f3134d.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.f3134d;
        if (spinner != null) {
            spinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f3133c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f3131a;
            if (parent == toolbar) {
                toolbar.removeView(this.f3133c);
            }
        }
        this.f3133c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.p != 2) {
            return;
        }
        this.f3131a.addView(this.f3133c, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f3133c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.gravity = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.o == null) {
            this.o = new ActionMenuPresenter(this.f3131a.getContext());
            this.o.setId(R.id.action_menu_presenter);
        }
        this.o.setCallback(callback);
        this.f3131a.setMenu((MenuBuilder) menu, this.o);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f3131a.setMenuCallbacks(callback, callback2);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenuPrepared() {
        this.n = true;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.l = charSequence;
        c();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.f3138h = drawable;
        d();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationMode(int i) {
        View view;
        int i2 = this.p;
        if (i != i2) {
            if (i2 == 1) {
                Spinner spinner = this.f3134d;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f3131a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f3134d);
                    }
                }
            } else if (i2 == 2 && (view = this.f3133c) != null) {
                ViewParent parent2 = view.getParent();
                Toolbar toolbar2 = this.f3131a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f3133c);
                }
            }
            this.p = i;
            if (i != 0) {
                if (i == 1) {
                    b();
                    this.f3131a.addView(this.f3134d, 0);
                    return;
                }
                if (i == 2) {
                    View view2 = this.f3133c;
                    if (view2 != null) {
                        this.f3131a.addView(view2, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f3133c.getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                        layoutParams.gravity = 8388691;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        this.k = charSequence;
        if ((this.f3132b & 8) != 0) {
            this.f3131a.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.i = true;
        a(charSequence);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setVisibility(int i) {
        this.f3131a.setVisibility(i);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.m = callback;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.i) {
            return;
        }
        a(charSequence);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.f3131a).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.2

            /* renamed from: a, reason: collision with root package name */
            private boolean f3141a = false;

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.f3141a = true;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (this.f3141a) {
                    return;
                }
                ToolbarWidgetWrapper.this.f3131a.setVisibility(i);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f3131a.setVisibility(0);
            }
        });
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f3131a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.p = 0;
        this.q = 0;
        this.f3131a = toolbar;
        this.j = toolbar.getTitle();
        this.k = toolbar.getSubtitle();
        this.i = this.j != null;
        this.f3138h = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.r = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.f3138h == null && (drawable = this.r) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f3131a.getContext()).inflate(resourceId, (ViewGroup) this.f3131a, false));
                setDisplayOptions(this.f3132b | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f3131a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f3131a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f3131a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.f3131a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.f3131a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f3131a.setPopupTheme(resourceId4);
            }
        } else {
            this.f3132b = a();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.l = this.f3131a.getNavigationContentDescription();
        this.f3131a.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.1

            /* renamed from: a, reason: collision with root package name */
            final ActionMenuItem f3139a;

            {
                this.f3139a = new ActionMenuItem(ToolbarWidgetWrapper.this.f3131a.getContext(), 0, android.R.id.home, 0, 0, ToolbarWidgetWrapper.this.j);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.m;
                if (callback == null || !toolbarWidgetWrapper.n) {
                    return;
                }
                callback.onMenuItemSelected(0, this.f3139a);
            }
        });
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f3136f = drawable;
        e();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        this.f3137g = drawable;
        e();
    }

    private void a(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f3132b & 8) != 0) {
            this.f3131a.setTitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }
}
