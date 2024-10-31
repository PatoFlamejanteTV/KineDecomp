package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.lb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0434lb implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f6177a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6178b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0434lb(AbstractC0414hb.b bVar, Activity activity) {
        this.f6178b = bVar;
        this.f6177a = activity;
    }

    @Override // android.support.v7.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        String str2;
        if (str != null) {
            str2 = this.f6178b.f6115e;
            if (str.equalsIgnoreCase(str2)) {
                return false;
            }
        }
        this.f6178b.f6115e = str;
        AbstractC0414hb.this.g(str);
        return true;
    }

    @Override // android.support.v7.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        RelativeLayout relativeLayout;
        InputMethodManager inputMethodManager = (InputMethodManager) this.f6177a.getSystemService("input_method");
        View currentFocus = this.f6177a.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        relativeLayout = AbstractC0414hb.this.z;
        relativeLayout.requestFocus();
        return true;
    }
}
