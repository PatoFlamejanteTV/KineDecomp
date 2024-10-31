package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {

    /* renamed from: b */
    final Context f2428b;

    /* renamed from: c */
    private Map<SupportMenuItem, MenuItem> f2429c;

    /* renamed from: d */
    private Map<SupportSubMenu, SubMenu> f2430d;

    public BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f2428b = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f2429c == null) {
            this.f2429c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f2429c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.f2428b, supportMenuItem);
        this.f2429c.put(supportMenuItem, wrapSupportMenuItem);
        return wrapSupportMenuItem;
    }

    public final void b(int i) {
        Map<SupportMenuItem, MenuItem> map = this.f2429c;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f2430d == null) {
            this.f2430d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f2430d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.f2428b, supportSubMenu);
        this.f2430d.put(supportSubMenu, wrapSupportSubMenu);
        return wrapSupportSubMenu;
    }

    public final void a() {
        Map<SupportMenuItem, MenuItem> map = this.f2429c;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.f2430d;
        if (map2 != null) {
            map2.clear();
        }
    }

    public final void a(int i) {
        Map<SupportMenuItem, MenuItem> map = this.f2429c;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
