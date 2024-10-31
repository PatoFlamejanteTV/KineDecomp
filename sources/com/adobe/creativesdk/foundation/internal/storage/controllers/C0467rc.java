package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.rc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0467rc implements FloatingActionsMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0477tc f6387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0467rc(C0477tc c0477tc) {
        this.f6387a = c0477tc;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void a() {
        View view;
        view = this.f6387a.W;
        view.setVisibility(4);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
    public void b() {
        View view;
        View view2;
        view = this.f6387a.W;
        view.setVisibility(0);
        this.f6387a._a();
        view2 = this.f6387a.W;
        view2.callOnClick();
    }
}
