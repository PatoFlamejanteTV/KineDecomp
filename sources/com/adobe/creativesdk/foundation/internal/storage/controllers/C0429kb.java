package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.kb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0429kb implements MenuItemCompat.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EditText f6163a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Menu f6164b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SearchView f6165c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6166d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0429kb(AbstractC0414hb.b bVar, EditText editText, Menu menu, SearchView searchView) {
        this.f6166d = bVar;
        this.f6163a = editText;
        this.f6164b = menu;
        this.f6165c = searchView;
    }

    @Override // android.support.v4.view.MenuItemCompat.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        if (!AbstractC0414hb.this.O || !AbstractC0414hb.this.ia()) {
            if (AbstractC0414hb.this.O) {
                AbstractC0414hb.this.O = false;
            }
        } else {
            AbstractC0414hb.this.O = false;
        }
        AbstractC0414hb.this.b(this.f6164b);
        AbstractC0414hb.this.za();
        AbstractC0414hb.this.wa();
        this.f6165c.setQuery("", false);
        this.f6165c.setIconified(false);
        return true;
    }

    @Override // android.support.v4.view.MenuItemCompat.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        AbstractC0414hb.this.O = true;
        if (AbstractC0414hb.this.ia()) {
            this.f6163a.requestFocus();
        }
        AbstractC0414hb.this.a(this.f6164b);
        AbstractC0414hb.this.fa();
        AbstractC0414hb.this.da();
        return true;
    }
}
