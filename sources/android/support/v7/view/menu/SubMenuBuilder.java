package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder A;
    private MenuItemImpl B;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.A = menuBuilder;
        this.B = menuItemImpl;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.a(menuBuilder, menuItem) || this.A.a(menuBuilder, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.A.collapseItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.A.expandItemActionView(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl menuItemImpl = this.B;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.B;
    }

    public Menu getParentMenu() {
        return this.A;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.A.getRootMenu();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.A.isQwertyMode();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.A.isShortcutsVisible();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback callback) {
        this.A.setCallback(callback);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.B.setIcon(drawable);
        return this;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.A.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean z) {
        this.A.setShortcutsVisible(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.a(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.b(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.B.setIcon(i);
        return this;
    }
}
