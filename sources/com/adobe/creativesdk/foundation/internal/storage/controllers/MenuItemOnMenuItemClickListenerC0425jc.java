package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.MenuItem;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc;

/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.jc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0425jc implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc.b f6153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemOnMenuItemClickListenerC0425jc(C0415hc.b bVar) {
        this.f6153a = bVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        C0415hc.this.fb();
        return true;
    }
}
