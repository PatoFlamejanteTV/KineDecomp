package com.nexstreaming.app.general.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NexMenu.java */
/* loaded from: classes2.dex */
public class w implements Menu {

    /* renamed from: a */
    private List<x> f19895a = new ArrayList();

    /* renamed from: b */
    private Context f19896b;

    public w(Context context) {
        this.f19896b = context;
    }

    private Context a() {
        return this.f19896b;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        x xVar = new x(a());
        xVar.setTitle(charSequence);
        this.f19895a.add(xVar);
        return xVar;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void clear() {
        this.f19895a.clear();
    }

    @Override // android.view.Menu
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        if (i != 0) {
            for (x xVar : this.f19895a) {
                if (xVar.getItemId() == i) {
                    return xVar;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("ID cannot be zero");
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f19895a.get(i);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        Iterator<x> it = this.f19895a.iterator();
        while (it.hasNext()) {
            if (it.next().isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        if (i != 0) {
            ArrayList arrayList = new ArrayList();
            for (x xVar : this.f19895a) {
                if (xVar.getGroupId() == i) {
                    arrayList.add(xVar);
                }
            }
            this.f19895a.removeAll(arrayList);
            return;
        }
        throw new IllegalArgumentException("group ID cannot be zero");
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        if (i != 0) {
            ArrayList arrayList = new ArrayList();
            for (x xVar : this.f19895a) {
                if (xVar.getItemId() == i) {
                    arrayList.add(xVar);
                }
            }
            this.f19895a.removeAll(arrayList);
            return;
        }
        throw new IllegalArgumentException("ID cannot be zero");
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public int size() {
        return this.f19895a.size();
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        x xVar = new x(a());
        xVar.setTitle(i);
        this.f19895a.add(xVar);
        return xVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        x xVar = new x(a(), i, i2, i3);
        xVar.setTitle(charSequence);
        this.f19895a.add(xVar);
        return xVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        x xVar = new x(a(), i, i2, i3);
        xVar.setTitle(i4);
        this.f19895a.add(xVar);
        return xVar;
    }
}
