package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
abstract class c<T> extends d<T> {

    /* renamed from: a, reason: collision with root package name */
    final Context f132a;
    private Map<android.support.v4.c.a.b, MenuItem> c;
    private Map<android.support.v4.c.a.c, SubMenu> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, T t) {
        super(t);
        this.f132a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof android.support.v4.c.a.b)) {
            return menuItem;
        }
        android.support.v4.c.a.b bVar = (android.support.v4.c.a.b) menuItem;
        if (this.c == null) {
            this.c = new android.support.v4.f.a();
        }
        MenuItem menuItem2 = this.c.get(menuItem);
        if (menuItem2 == null) {
            MenuItem a2 = m.a(this.f132a, bVar);
            this.c.put(bVar, a2);
            return a2;
        }
        return menuItem2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.c.a.c)) {
            return subMenu;
        }
        android.support.v4.c.a.c cVar = (android.support.v4.c.a.c) subMenu;
        if (this.d == null) {
            this.d = new android.support.v4.f.a();
        }
        SubMenu subMenu2 = this.d.get(cVar);
        if (subMenu2 == null) {
            SubMenu a2 = m.a(this.f132a, cVar);
            this.d.put(cVar, a2);
            return a2;
        }
        return subMenu2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.c != null) {
            Iterator<android.support.v4.c.a.b> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        if (this.c != null) {
            Iterator<android.support.v4.c.a.b> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
