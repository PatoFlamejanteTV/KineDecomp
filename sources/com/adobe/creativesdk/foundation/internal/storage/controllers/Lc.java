package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.MenuItem;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
class Lc implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc.e f5714a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lc(Jc.e eVar) {
        this.f5714a = eVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Jc.this.db();
        return true;
    }
}
