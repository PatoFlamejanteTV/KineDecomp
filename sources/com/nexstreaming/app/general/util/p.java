package com.nexstreaming.app.general.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: NexMenuItem.java */
/* loaded from: classes.dex */
public class p implements MenuItem {

    /* renamed from: a, reason: collision with root package name */
    private int f3235a;
    private int b;
    private int c;
    private CharSequence d;
    private CharSequence e;
    private Context f;
    private Drawable g;
    private Intent h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = true;
    private boolean l = true;
    private MenuItem.OnMenuItemClickListener m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.f = context;
    }

    public p(Context context, int i, int i2, int i3) {
        this.f = context;
        this.b = i;
        this.f3235a = i2;
        this.c = i3;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3235a;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.d = this.f.getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.g = drawable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        if (i == 0) {
            this.g = null;
        } else {
            this.g = this.f.getResources().getDrawable(i);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.i = z;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.j = z;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.k = z;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.l = z;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        throw new UnsupportedOperationException();
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
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }
}
