package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.MenuItem;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc;

/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.gc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0410gc implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc.a f6099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemOnMenuItemClickListenerC0410gc(C0415hc.a aVar) {
        this.f6099a = aVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        C0415hc.this.hb();
        return true;
    }
}
