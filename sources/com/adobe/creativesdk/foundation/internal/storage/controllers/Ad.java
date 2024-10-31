package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotosAssetsFragment.java */
/* loaded from: classes.dex */
public class Ad implements FloatingActionsMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fd f5511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ad(Fd fd) {
        this.f5511a = fd;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void a() {
        View view;
        view = this.f5511a.Z;
        view.setVisibility(4);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void b() {
        View view;
        view = this.f5511a.Z;
        view.setVisibility(0);
        if (this.f5511a.ba) {
            this.f5511a.X.setTitle(this.f5511a.getResources().getString(c.a.a.a.b.i.adobe_csdk_CANCEL_UPLOAD_ASSET_BROWSER_BUTTON));
            this.f5511a.Y.setVisibility(8);
        } else {
            this.f5511a.X.setTitle(this.f5511a.getResources().getString(c.a.a.a.b.i.adobe_csdk_UPLOAD_PHOTO_ASSET_BROWSER_BUTTON));
            this.f5511a.Y.setVisibility(0);
        }
    }
}
