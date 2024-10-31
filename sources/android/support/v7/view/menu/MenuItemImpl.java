package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: a */
    private static String f2485a;

    /* renamed from: b */
    private static String f2486b;

    /* renamed from: c */
    private static String f2487c;

    /* renamed from: d */
    private static String f2488d;
    private int D;
    private View E;
    private ActionProvider F;
    private MenuItem.OnActionExpandListener G;
    private ContextMenu.ContextMenuInfo I;

    /* renamed from: e */
    private final int f2489e;

    /* renamed from: f */
    private final int f2490f;

    /* renamed from: g */
    private final int f2491g;

    /* renamed from: h */
    private final int f2492h;
    private CharSequence i;
    private CharSequence j;
    private Intent k;
    private char l;
    private char n;
    private Drawable p;
    MenuBuilder r;
    private SubMenuBuilder s;
    private Runnable t;
    private MenuItem.OnMenuItemClickListener u;
    private CharSequence v;
    private CharSequence w;
    private int m = 4096;
    private int o = 4096;
    private int q = 0;
    private ColorStateList x = null;
    private PorterDuff.Mode y = null;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private int C = 16;
    private boolean H = false;

    /* renamed from: android.support.v7.view.menu.MenuItemImpl$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ActionProvider.VisibilityListener {
        AnonymousClass1() {
        }

        @Override // android.support.v4.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            MenuItemImpl menuItemImpl = MenuItemImpl.this;
            menuItemImpl.r.b(menuItemImpl);
        }
    }

    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.D = 0;
        this.r = menuBuilder;
        this.f2489e = i2;
        this.f2490f = i;
        this.f2491g = i3;
        this.f2492h = i4;
        this.i = charSequence;
        this.D = i5;
    }

    public char a() {
        return this.r.isQwertyMode() ? this.n : this.l;
    }

    public void actionFormatChanged() {
        this.r.a(this);
    }

    public String b() {
        char a2 = a();
        if (a2 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f2485a);
        if (a2 == '\b') {
            sb.append(f2487c);
        } else if (a2 == '\n') {
            sb.append(f2486b);
        } else if (a2 != ' ') {
            sb.append(a2);
        } else {
            sb.append(f2488d);
        }
        return sb.toString();
    }

    public boolean c() {
        return this.r.isShortcutsVisible() && a() != 0;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.D & 8) == 0) {
            return false;
        }
        if (this.E == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.G;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.r.collapseItemActionView(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.G;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.r.expandItemActionView(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.E;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.F;
        if (actionProvider == null) {
            return null;
        }
        this.E = actionProvider.onCreateActionView(this);
        return this.E;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.n;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.v;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2490f;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.p;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.q == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.r.getContext(), this.q);
        this.q = 0;
        this.p = drawable2;
        return a(drawable2);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.x;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.y;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.k;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f2489e;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.I;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2491g;
    }

    public int getOrdering() {
        return this.f2492h;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.s;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.F;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.j;
        if (charSequence == null) {
            charSequence = this.i;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.w;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.D & 8) == 0) {
            return false;
        }
        if (this.E == null && (actionProvider = this.F) != null) {
            this.E = actionProvider.onCreateActionView(this);
        }
        return this.E != null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.s != null;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.u;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.r;
        if (menuBuilder.a(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.t;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.k != null) {
            try {
                this.r.getContext().startActivity(this.k);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        ActionProvider actionProvider = this.F;
        return actionProvider != null && actionProvider.onPerformDefaultAction();
    }

    public boolean isActionButton() {
        return (this.C & 32) == 32;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.H;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.C & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.C & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.C & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.C & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.F;
        return (actionProvider == null || !actionProvider.overridesItemVisibility()) ? (this.C & 8) == 0 : (this.C & 8) == 0 && this.F.isVisible();
    }

    public boolean requestsActionButton() {
        return (this.D & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.D & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z) {
        this.H = z;
        this.r.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.n == c2) {
            return this;
        }
        this.n = Character.toLowerCase(c2);
        this.r.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.t = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.C;
        this.C = (z ? 1 : 0) | (i & (-2));
        if (i != this.C) {
            this.r.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.C & 4) != 0) {
            this.r.a((MenuItem) this);
        } else {
            a(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.C |= 16;
        } else {
            this.C &= -17;
        }
        this.r.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.C = (z ? 4 : 0) | (this.C & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.q = 0;
        this.p = drawable;
        this.B = true;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.x = colorStateList;
        this.z = true;
        this.B = true;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.y = mode;
        this.A = true;
        this.B = true;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.k = intent;
        return this;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.C |= 32;
        } else {
            this.C &= -33;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.l == c2) {
            return this;
        }
        this.l = c2;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.G = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.u = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.l = c2;
        this.n = Character.toLowerCase(c3);
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.D = i;
        this.r.a(this);
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.s = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.F;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.E = null;
        this.F = actionProvider;
        this.r.onItemsChanged(true);
        ActionProvider actionProvider3 = this.F;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: android.support.v7.view.menu.MenuItemImpl.1
                AnonymousClass1() {
                }

                @Override // android.support.v4.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.r.b(menuItemImpl);
                }
            });
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.i = charSequence;
        this.r.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.s;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.j = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.i;
        }
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (b(z)) {
            this.r.b(this);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.r.a();
    }

    public boolean showsTextAsAction() {
        return (this.D & 4) == 4;
    }

    public String toString() {
        CharSequence charSequence = this.i;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence a(MenuView.ItemView itemView) {
        if (itemView != null && itemView.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.v = charSequence;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.w = charSequence;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        int i;
        this.E = view;
        this.F = null;
        if (view != null && view.getId() == -1 && (i = this.f2489e) > 0) {
            view.setId(i);
        }
        this.r.a(this);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.n == c2 && this.o == i) {
            return this;
        }
        this.n = Character.toLowerCase(c2);
        this.o = KeyEvent.normalizeMetaState(i);
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        if (this.l == c2 && this.m == i) {
            return this;
        }
        this.l = c2;
        this.m = KeyEvent.normalizeMetaState(i);
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.l = c2;
        this.m = KeyEvent.normalizeMetaState(i);
        this.n = Character.toLowerCase(c3);
        this.o = KeyEvent.normalizeMetaState(i2);
        this.r.onItemsChanged(false);
        return this;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.B && (this.z || this.A)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.z) {
                DrawableCompat.setTintList(drawable, this.x);
            }
            if (this.A) {
                DrawableCompat.setTintMode(drawable, this.y);
            }
            this.B = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.p = null;
        this.q = i;
        this.B = true;
        this.r.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.r.getContext().getString(i));
    }

    public boolean b(boolean z) {
        int i = this.C;
        this.C = (z ? 0 : 8) | (i & (-9));
        return i != this.C;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        Context context = this.r.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    public void a(boolean z) {
        int i = this.C;
        this.C = (z ? 2 : 0) | (i & (-3));
        if (i != this.C) {
            this.r.onItemsChanged(false);
        }
    }

    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.I = contextMenuInfo;
    }
}
