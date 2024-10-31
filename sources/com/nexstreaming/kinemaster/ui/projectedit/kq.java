package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.java */
/* loaded from: classes.dex */
public class kq implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kp f4041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kq(kp kpVar) {
        this.f4041a = kpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        while (this.f4041a.getFragmentManager() != null && this.f4041a.getFragmentManager().popBackStackImmediate()) {
        }
    }
}
