package com.nexstreaming.app.general.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: NexMenuItem.java */
/* loaded from: classes2.dex */
public class x implements MenuItem {

    /* renamed from: a */
    private int f19897a;

    /* renamed from: b */
    private int f19898b;

    /* renamed from: c */
    private int f19899c;

    /* renamed from: d */
    private CharSequence f19900d;

    /* renamed from: e */
    private CharSequence f19901e;

    /* renamed from: f */
    private Context f19902f;

    /* renamed from: g */
    private Drawable f19903g;

    /* renamed from: h */
    private Intent f19904h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = true;
    private boolean l = true;
    private MenuItem.OnMenuItemClickListener m;
    private View n;

    public x(Context context) {
        this.f19902f = context;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.n;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f19898b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f19903g;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f19904h;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f19897a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f19899c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f19900d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f19901e;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        int i;
        this.n = view;
        if (view != null && view.getId() == -1 && (i = this.f19897a) > 0) {
            view.setId(i);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.i = z;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.j = z;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.l = z;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f19903g = drawable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f19904h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f19900d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f19901e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.k = z;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        if (i == 0) {
            this.f19903g = null;
        } else {
            this.f19903g = this.f19902f.getResources().getDrawable(i);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f19900d = this.f19902f.getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        setActionView(LayoutInflater.from(this.f19902f).inflate(i, (ViewGroup) null, false));
        return this;
    }

    public x(Context context, int i, int i2, int i3) {
        this.f19902f = context;
        this.f19898b = i;
        this.f19897a = i2;
        this.f19899c = i3;
    }
}
