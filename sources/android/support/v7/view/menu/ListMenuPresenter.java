package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a, reason: collision with root package name */
    Context f2457a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f2458b;

    /* renamed from: c, reason: collision with root package name */
    MenuBuilder f2459c;

    /* renamed from: d, reason: collision with root package name */
    ExpandedMenuView f2460d;

    /* renamed from: e, reason: collision with root package name */
    int f2461e;

    /* renamed from: f, reason: collision with root package name */
    int f2462f;

    /* renamed from: g, reason: collision with root package name */
    int f2463g;

    /* renamed from: h, reason: collision with root package name */
    private MenuPresenter.Callback f2464h;
    MenuAdapter i;
    private int j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f2465a = -1;

        public MenuAdapter() {
            a();
        }

        void a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f2459c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f2459c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f2465a = i;
                        return;
                    }
                }
            }
            this.f2465a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f2459c.getNonActionItems().size() - ListMenuPresenter.this.f2461e;
            return this.f2465a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f2458b.inflate(listMenuPresenter.f2463g, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f2459c.getNonActionItems();
            int i2 = i + ListMenuPresenter.this.f2461e;
            int i3 = this.f2465a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f2457a = context;
        this.f2458b = LayoutInflater.from(this.f2457a);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.i == null) {
            this.i = new MenuAdapter();
        }
        return this.i;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public int getId() {
        return this.j;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f2460d == null) {
            this.f2460d = (ExpandedMenuView) this.f2458b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new MenuAdapter();
            }
            this.f2460d.setAdapter((ListAdapter) this.i);
            this.f2460d.setOnItemClickListener(this);
        }
        return this.f2460d;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        int i = this.f2462f;
        if (i != 0) {
            this.f2457a = new ContextThemeWrapper(context, i);
            this.f2458b = LayoutInflater.from(this.f2457a);
        } else if (this.f2457a != null) {
            this.f2457a = context;
            if (this.f2458b == null) {
                this.f2458b = LayoutInflater.from(this.f2457a);
            }
        }
        this.f2459c = menuBuilder;
        MenuAdapter menuAdapter = this.i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f2464h;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2459c.performItemAction(this.i.getItem(i), this, 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.f2460d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).show(null);
        MenuPresenter.Callback callback = this.f2464h;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f2460d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f2460d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f2464h = callback;
    }

    public void setId(int i) {
        this.j = i;
    }

    public void setItemIndexOffset(int i) {
        this.f2461e = i;
        if (this.f2460d != null) {
            updateMenuView(false);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        MenuAdapter menuAdapter = this.i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i, int i2) {
        this.f2463g = i;
        this.f2462f = i2;
    }
}
