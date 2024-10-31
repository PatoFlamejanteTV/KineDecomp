package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {

    /* renamed from: a, reason: collision with root package name */
    DecorToolbar f2199a;

    /* renamed from: b, reason: collision with root package name */
    boolean f2200b;

    /* renamed from: c, reason: collision with root package name */
    Window.Callback f2201c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2202d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2203e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f2204f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f2205g = new Runnable() { // from class: android.support.v7.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.b();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final Toolbar.OnMenuItemClickListener f2206h = new Toolbar.OnMenuItemClickListener() { // from class: android.support.v7.app.ToolbarActionBar.2
        @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.f2201c.onMenuItemSelected(0, menuItem);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2209a;

        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (this.f2209a) {
                return;
            }
            this.f2209a = true;
            ToolbarActionBar.this.f2199a.dismissPopupMenus();
            Window.Callback callback = ToolbarActionBar.this.f2201c;
            if (callback != null) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.f2209a = false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback = ToolbarActionBar.this.f2201c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f2201c != null) {
                if (toolbarActionBar.f2199a.isOverflowMenuShowing()) {
                    ToolbarActionBar.this.f2201c.onPanelClosed(108, menuBuilder);
                } else if (ToolbarActionBar.this.f2201c.onPreparePanel(0, null, menuBuilder)) {
                    ToolbarActionBar.this.f2201c.onMenuOpened(108, menuBuilder);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(ToolbarActionBar.this.f2199a.getContext());
            }
            return super.onCreatePanelView(i);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.f2200b) {
                    toolbarActionBar.f2199a.setMenuPrepared();
                    ToolbarActionBar.this.f2200b = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f2199a = new ToolbarWidgetWrapper(toolbar, false);
        this.f2201c = new ToolbarCallbackWrapper(callback);
        this.f2199a.setWindowCallback(this.f2201c);
        toolbar.setOnMenuItemClickListener(this.f2206h);
        this.f2199a.setWindowTitle(charSequence);
    }

    private Menu c() {
        if (!this.f2202d) {
            this.f2199a.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f2202d = true;
        }
        return this.f2199a.getMenu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBar
    public void a() {
        this.f2199a.getViewGroup().removeCallbacks(this.f2205g);
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f2204f.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    void b() {
        Menu c2 = c();
        MenuBuilder menuBuilder = c2 instanceof MenuBuilder ? (MenuBuilder) c2 : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            c2.clear();
            if (!this.f2201c.onCreatePanelMenu(0, c2) || !this.f2201c.onPreparePanel(0, null, c2)) {
                c2.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public boolean closeOptionsMenu() {
        return this.f2199a.hideOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (!this.f2199a.hasExpandedActionView()) {
            return false;
        }
        this.f2199a.collapseActionView();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.f2203e) {
            return;
        }
        this.f2203e = z;
        int size = this.f2204f.size();
        for (int i = 0; i < size; i++) {
            this.f2204f.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.f2199a.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.f2199a.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.f2199a.getViewGroup());
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.f2199a.getHeight();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.f2199a.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        return this.f2199a.getContext();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.f2199a.getTitle();
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.f2201c;
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        this.f2199a.setVisibility(8);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.f2199a.getViewGroup().removeCallbacks(this.f2205g);
        ViewCompat.postOnAnimation(this.f2199a.getViewGroup(), this.f2205g);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        return this.f2199a.getVisibility() == 0;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu c2 = c();
        if (c2 == null) {
            return false;
        }
        c2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c2.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean openOptionsMenu() {
        return this.f2199a.showOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f2204f.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f2199a.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.f2199a.setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
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
        ViewCompat.setElevation(this.f2199a.getViewGroup(), f2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f2199a.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f2199a.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int i) {
        this.f2199a.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f2199a.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.f2199a.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int i) {
        if (i != 2) {
            this.f2199a.setNavigationMode(i);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        if (this.f2199a.getNavigationMode() == 1) {
            this.f2199a.setDropdownSelectedPosition(i);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.f2199a.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.f2199a.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.f2199a.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        this.f2199a.setVisibility(0);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f2199a.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        this.f2199a.setDisplayOptions((i & i2) | ((i2 ^ (-1)) & this.f2199a.getDisplayOptions()));
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.f2199a.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.f2199a.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.f2199a.setIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.f2199a.setLogo(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int i) {
        DecorToolbar decorToolbar = this.f2199a;
        decorToolbar.setSubtitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int i) {
        DecorToolbar decorToolbar = this.f2199a;
        decorToolbar.setTitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.f2199a.getContext()).inflate(i, this.f2199a.getViewGroup(), false));
    }
}
