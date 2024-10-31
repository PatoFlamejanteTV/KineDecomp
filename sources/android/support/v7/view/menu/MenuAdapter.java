package android.support.v7.view.menu;

import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    static final int f2467a = R.layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    MenuBuilder f2468b;

    /* renamed from: c, reason: collision with root package name */
    private int f2469c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2470d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f2471e;

    /* renamed from: f, reason: collision with root package name */
    private final LayoutInflater f2472f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z) {
        this.f2471e = z;
        this.f2472f = layoutInflater;
        this.f2468b = menuBuilder;
        a();
    }

    void a() {
        MenuItemImpl expandedItem = this.f2468b.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f2468b.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f2469c = i;
                    return;
                }
            }
        }
        this.f2469c = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.f2468b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.f2471e ? this.f2468b.getNonActionItems() : this.f2468b.getVisibleItems();
        if (this.f2469c < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.f2470d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2472f.inflate(f2467a, viewGroup, false);
        }
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f2470d) {
            ((ListMenuItemView) view).setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.f2470d = z;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> nonActionItems = this.f2471e ? this.f2468b.getNonActionItems() : this.f2468b.getVisibleItems();
        int i2 = this.f2469c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }
}
