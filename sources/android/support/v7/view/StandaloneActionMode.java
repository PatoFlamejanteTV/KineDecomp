package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: c, reason: collision with root package name */
    private Context f2367c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContextView f2368d;

    /* renamed from: e, reason: collision with root package name */
    private ActionMode.Callback f2369e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<View> f2370f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2371g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2372h;
    private MenuBuilder i;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f2367c = context;
        this.f2368d = actionBarContextView;
        this.f2369e = callback;
        this.i = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.i.setCallback(this);
        this.f2372h = z;
    }

    @Override // android.support.v7.view.ActionMode
    public void finish() {
        if (this.f2371g) {
            return;
        }
        this.f2371g = true;
        this.f2368d.sendAccessibilityEvent(32);
        this.f2369e.onDestroyActionMode(this);
    }

    @Override // android.support.v7.view.ActionMode
    public View getCustomView() {
        WeakReference<View> weakReference = this.f2370f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.support.v7.view.ActionMode
    public Menu getMenu() {
        return this.i;
    }

    @Override // android.support.v7.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f2368d.getContext());
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f2368d.getSubtitle();
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getTitle() {
        return this.f2368d.getTitle();
    }

    @Override // android.support.v7.view.ActionMode
    public void invalidate() {
        this.f2369e.onPrepareActionMode(this, this.i);
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isTitleOptional() {
        return this.f2368d.isTitleOptional();
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isUiFocusable() {
        return this.f2372h;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2369e.onActionItemClicked(this, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        invalidate();
        this.f2368d.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f2368d.getContext(), subMenuBuilder).show();
        return true;
    }

    @Override // android.support.v7.view.ActionMode
    public void setCustomView(View view) {
        this.f2368d.setCustomView(view);
        this.f2370f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2368d.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2368d.setTitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f2368d.setTitleOptional(z);
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(int i) {
        setSubtitle(this.f2367c.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(int i) {
        setTitle(this.f2367c.getString(i));
    }
}
