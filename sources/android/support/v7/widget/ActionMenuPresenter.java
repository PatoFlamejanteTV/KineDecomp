package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    ActionButtonSubmenu A;
    OpenOverflowRunnable B;
    private ActionMenuPopupCallback C;
    final PopupPresenterCallback D;
    int E;
    OverflowMenuButton k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    private View y;
    OverflowPopup z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.k;
                setAnchorView(view2 == null ? (View) ((BaseMenuPresenter) ActionMenuPresenter.this).i : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.D);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        protected void a() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.a();
        }
    }

    /* loaded from: classes.dex */
    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.A;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private OverflowPopup f2556a;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f2556a = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f2422c != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f2422c.changeMenuMode();
            }
            View view = (View) ((BaseMenuPresenter) ActionMenuPresenter.this).i;
            if (view != null && view.getWindowToken() != null && this.f2556a.tryShow()) {
                ActionMenuPresenter.this.z = this.f2556a;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        /* renamed from: c, reason: collision with root package name */
        private final float[] f2558c;

        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.f2558c = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // android.support.v7.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.z;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.getPopup();
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.B != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.D);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        protected void a() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f2422c != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f2422c.close();
            }
            ActionMenuPresenter.this.z = null;
            super.a();
        }
    }

    /* loaded from: classes.dex */
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.E = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.D = new PopupPresenterCallback();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.C == null) {
            this.C = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f2422c;
        int i5 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.r;
        int i7 = actionMenuPresenter.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.i;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            MenuItemImpl menuItemImpl = arrayList.get(i11);
            if (menuItemImpl.requiresActionButton()) {
                i9++;
            } else if (menuItemImpl.requestsActionButton()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.v && menuItemImpl.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.n && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i13 = actionMenuPresenter.w;
            i3 = i7 / i13;
            i2 = i13 + ((i7 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i15);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.y, viewGroup);
                if (actionMenuPresenter.y == null) {
                    actionMenuPresenter.y = itemView;
                }
                if (actionMenuPresenter.t) {
                    i3 -= ActionMenuView.a(itemView, i2, i3, makeMeasureSpec, i5);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                menuItemImpl2.setIsActionButton(z);
                i4 = i;
                i16 = measuredWidth;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!actionMenuPresenter.t || i3 > 0);
                if (z4) {
                    boolean z5 = z4;
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.y, viewGroup);
                    i4 = i;
                    if (actionMenuPresenter.y == null) {
                        actionMenuPresenter.y = itemView2;
                    }
                    if (actionMenuPresenter.t) {
                        int a2 = ActionMenuView.a(itemView2, i2, i3, makeMeasureSpec, 0);
                        i3 -= a2;
                        if (a2 == 0) {
                            z5 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = z5 & (!actionMenuPresenter.t ? i14 + i16 <= 0 : i14 < 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i17);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i12++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                menuItemImpl2.setIsActionButton(z4);
            } else {
                i4 = i;
                menuItemImpl2.setIsActionButton(false);
                i15++;
                i5 = 0;
                actionMenuPresenter = this;
                i = i4;
            }
            i15++;
            i5 = 0;
            actionMenuPresenter = this;
            i = i4;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.i;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.k;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.B;
        if (openOverflowRunnable != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.B = null;
            return true;
        }
        OverflowPopup overflowPopup = this.z;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.A;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.o) {
            this.n = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.u) {
            this.p = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.s) {
            this.r = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.p;
        if (this.n) {
            if (this.k == null) {
                this.k = new OverflowMenuButton(this.f2420a);
                if (this.m) {
                    this.k.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = i;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.y = null;
    }

    public boolean isOverflowMenuShowPending() {
        return this.B != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.z;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.n;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.s) {
            this.r = ActionBarPolicy.get(this.f2421b).getMaxActionButtons();
        }
        MenuBuilder menuBuilder = this.f2422c;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.f2422c.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.E;
        return savedState;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.f2422c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View a2 = a(subMenuBuilder2.getItem());
        if (a2 == null) {
            return false;
        }
        this.E = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.A = new ActionButtonSubmenu(this.f2421b, subMenuBuilder, a2);
        this.A.setForceShowIcon(z);
        this.A.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override // android.support.v4.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.f2422c;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.v = z;
    }

    public void setItemLimit(int i) {
        this.r = i;
        this.s = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.initialize(this.f2422c);
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.k;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.m = true;
            this.l = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        this.n = z;
        this.o = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.p = i;
        this.t = z;
        this.u = true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (!this.n || isOverflowMenuShowing() || (menuBuilder = this.f2422c) == null || this.i == null || this.B != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        this.B = new OpenOverflowRunnable(new OverflowPopup(this.f2421b, this.f2422c, this.k, true));
        ((View) this.i).post(this.B);
        super.onSubMenuSelected(null);
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.i).requestLayout();
        MenuBuilder menuBuilder = this.f2422c;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f2422c;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.n && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new OverflowMenuButton(this.f2420a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.k;
            if (overflowMenuButton != null) {
                Object parent = overflowMenuButton.getParent();
                Object obj = this.i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }
}
