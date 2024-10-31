package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jn implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jn(ProjectEditActivity projectEditActivity) {
        this.f4011a = projectEditActivity;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4011a.G = null;
    }
}
