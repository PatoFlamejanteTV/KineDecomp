package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotosCollectionFragment.java */
/* loaded from: classes.dex */
public class Nd implements FloatingActionsMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Od f5738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nd(Od od) {
        this.f5738a = od;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void a() {
        View view;
        view = this.f5738a.U;
        view.setVisibility(4);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void b() {
        View view;
        View view2;
        view = this.f5738a.U;
        view.setVisibility(0);
        this.f5738a.Wa();
        view2 = this.f5738a.U;
        view2.callOnClick();
    }
}
