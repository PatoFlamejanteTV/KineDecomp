package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.support.v4.app.Fragment;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* compiled from: AdobeAssetEditActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0384b implements FloatingActionsMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetEditActivity f6035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0384b(AdobeAssetEditActivity adobeAssetEditActivity) {
        this.f6035a = adobeAssetEditActivity;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void a() {
        this.f6035a.u = false;
        Fragment fragment = this.f6035a.f6020e;
        if (fragment != null) {
            ((B) fragment).l(false);
        }
        this.f6035a.B();
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void b() {
        this.f6035a.u = true;
        Fragment fragment = this.f6035a.f6020e;
        if (fragment != null) {
            ((B) fragment).l(true);
        }
        this.f6035a.B();
    }
}
