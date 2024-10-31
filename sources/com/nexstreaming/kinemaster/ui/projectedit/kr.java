package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Fragment;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.java */
/* loaded from: classes.dex */
public class kr implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kp f4042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kr(kp kpVar) {
        this.f4042a = kpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.f4042a.f;
        if (z) {
            Fragment findFragmentById = this.f4042a.getFragmentManager().findFragmentById(R.id.optionPanelHolder);
            if (findFragmentById != null && (findFragmentById instanceof mf)) {
                ((mf) findFragmentById).l_();
            }
            if (findFragmentById != null && (findFragmentById instanceof ce)) {
                ((ce) findFragmentById).l_();
            }
            if (findFragmentById == null || !(findFragmentById instanceof go) || !((go) findFragmentById).l_()) {
                this.f4042a.e();
            }
        }
    }
}
