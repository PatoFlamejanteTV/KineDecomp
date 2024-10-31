package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Tf implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tf(ProjectEditActivity projectEditActivity) {
        this.f22103a = projectEditActivity;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f22103a.ua = null;
    }
}
