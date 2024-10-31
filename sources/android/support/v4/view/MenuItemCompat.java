package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    /* renamed from: a */
    static final MenuVersionImpl f1802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.view.MenuItemCompat$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements MenuItem.OnActionExpandListener {
        AnonymousClass1() {
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return OnActionExpandListener.this.onMenuItemActionExpand(menuItem);
        }
    }

    /* loaded from: classes.dex */
    static class MenuItemCompatApi26Impl extends MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getAlphabeticModifiers(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public CharSequence getContentDescription(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public ColorStateList getIconTintList(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getNumericModifiers(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public CharSequence getTooltipText(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(MenuItem menuItem, char c2, int i) {
            menuItem.setAlphabeticShortcut(c2, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(MenuItem menuItem, char c2, int i) {
            menuItem.setNumericShortcut(c2, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setShortcut(MenuItem menuItem, char c2, char c3, int i, int i2) {
            menuItem.setShortcut(c2, c3, i, i2);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MenuItemCompatBaseImpl implements MenuVersionImpl {
        MenuItemCompatBaseImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getAlphabeticModifiers(MenuItem menuItem) {
            return 0;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public CharSequence getContentDescription(MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public ColorStateList getIconTintList(MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public int getNumericModifiers(MenuItem menuItem) {
            return 0;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public CharSequence getTooltipText(MenuItem menuItem) {
            return null;
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(MenuItem menuItem, char c2, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(MenuItem menuItem, char c2, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setShortcut(MenuItem menuItem, char c2, char c3, int i, int i2) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MenuVersionImpl {
        int getAlphabeticModifiers(MenuItem menuItem);

        CharSequence getContentDescription(MenuItem menuItem);

        ColorStateList getIconTintList(MenuItem menuItem);

        PorterDuff.Mode getIconTintMode(MenuItem menuItem);

        int getNumericModifiers(MenuItem menuItem);

        CharSequence getTooltipText(MenuItem menuItem);

        void setAlphabeticShortcut(MenuItem menuItem, char c2, int i);

        void setContentDescription(MenuItem menuItem, CharSequence charSequence);

        void setIconTintList(MenuItem menuItem, ColorStateList colorStateList);

        void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode);

        void setNumericShortcut(MenuItem menuItem, char c2, int i);

        void setShortcut(MenuItem menuItem, char c2, char c3, int i, int i2);

        void setTooltipText(MenuItem menuItem, CharSequence charSequence);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f1802a = new MenuItemCompatApi26Impl();
        } else {
            f1802a = new MenuItemCompatBaseImpl();
        }
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        return f1802a.getAlphabeticModifiers(menuItem);
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        return f1802a.getContentDescription(menuItem);
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        return f1802a.getIconTintList(menuItem);
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        return f1802a.getIconTintMode(menuItem);
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        return f1802a.getNumericModifiers(menuItem);
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        return f1802a.getTooltipText(menuItem);
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c2, i);
        } else {
            f1802a.setAlphabeticShortcut(menuItem, c2, i);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else {
            f1802a.setContentDescription(menuItem, charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            f1802a.setIconTintList(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            f1802a.setIconTintMode(menuItem, mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c2, i);
        } else {
            f1802a.setNumericShortcut(menuItem, c2, i);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: android.support.v4.view.MenuItemCompat.1
            AnonymousClass1() {
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionExpand(menuItem2);
            }
        });
    }

    public static void setShortcut(MenuItem menuItem, char c2, char c3, int i, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c2, c3, i, i2);
        } else {
            f1802a.setShortcut(menuItem, c2, c3, i, i2);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else {
            f1802a.setTooltipText(menuItem, charSequence);
        }
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
