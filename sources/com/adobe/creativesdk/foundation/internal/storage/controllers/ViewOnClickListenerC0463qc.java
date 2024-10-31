package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.qc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0463qc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0477tc f6382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0463qc(C0477tc c0477tc) {
        this.f6382a = c0477tc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FloatingActionsMenu floatingActionsMenu;
        view2 = this.f6382a.W;
        view2.setVisibility(4);
        floatingActionsMenu = this.f6382a.X;
        floatingActionsMenu.d();
    }
}
