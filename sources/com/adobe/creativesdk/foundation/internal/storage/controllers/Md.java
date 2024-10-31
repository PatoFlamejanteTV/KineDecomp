package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotosCollectionFragment.java */
/* loaded from: classes.dex */
public class Md implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Od f5726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Md(Od od) {
        this.f5726a = od;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FloatingActionsMenu floatingActionsMenu;
        view2 = this.f5726a.U;
        view2.setVisibility(4);
        floatingActionsMenu = this.f5726a.V;
        floatingActionsMenu.d();
    }
}
