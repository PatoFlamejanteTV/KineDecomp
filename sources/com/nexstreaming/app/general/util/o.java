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
/* loaded from: classes.dex */
public class o implements Menu {

    /* renamed from: a, reason: collision with root package name */
    private List<p> f3234a = new ArrayList();
    private Context b;

    public o(Context context) {
        this.b = context;
    }

    private Context a() {
        return this.b;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        p pVar = new p(a());
        pVar.setTitle(charSequence);
        this.f3234a.add(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        p pVar = new p(a());
        pVar.setTitle(i);
        this.f3234a.add(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        p pVar = new p(a(), i, i2, i3);
        pVar.setTitle(charSequence);
        this.f3234a.add(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        p pVar = new p(a(), i, i2, i3);
        pVar.setTitle(i4);
        this.f3234a.add(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        throw new UnsupportedOperationException();
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
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ID cannot be zero");
        }
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f3234a) {
            if (pVar.getItemId() == i) {
                arrayList.add(pVar);
            }
        }
        this.f3234a.removeAll(arrayList);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("group ID cannot be zero");
        }
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f3234a) {
            if (pVar.getGroupId() == i) {
                arrayList.add(pVar);
            }
        }
        this.f3234a.removeAll(arrayList);
    }

    @Override // android.view.Menu
    public void clear() {
        this.f3234a.clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        Iterator<p> it = this.f3234a.iterator();
        while (it.hasNext()) {
            if (it.next().isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ID cannot be zero");
        }
        for (p pVar : this.f3234a) {
            if (pVar.getItemId() == i) {
                return pVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3234a.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f3234a.get(i);
    }

    @Override // android.view.Menu
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        throw new UnsupportedOperationException();
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
    public void setQwertyMode(boolean z) {
        throw new UnsupportedOperationException();
    }
}
