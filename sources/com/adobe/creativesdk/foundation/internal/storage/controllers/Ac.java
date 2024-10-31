package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Ac implements FloatingActionsMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ac(Jc jc) {
        this.f5510a = jc;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void a() {
        this.f5510a.ia.setVisibility(4);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void b() {
        boolean z;
        this.f5510a.ia.setVisibility(0);
        z = this.f5510a.X;
        if (z) {
            this.f5510a.ha.setVisibility(4);
            this.f5510a.ga.setVisibility(4);
        } else {
            this.f5510a.ha.setVisibility(0);
            Jc jc = this.f5510a;
            jc.ga.setTitle(jc.getResources().getString(c.a.a.a.b.i.adobe_csdk_UPLOAD_IMAGE_TO_LIBRARY_MENU_TITLE));
        }
    }
}
