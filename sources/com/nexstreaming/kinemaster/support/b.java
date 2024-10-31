package com.nexstreaming.kinemaster.support;

import android.view.View;

/* compiled from: ChoiceCloudActivity.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChoiceCloudActivity f21238a;

    public b(ChoiceCloudActivity choiceCloudActivity) {
        this.f21238a = choiceCloudActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.f21238a.f21220h;
        if (rVar != null) {
            ChoiceCloudActivity choiceCloudActivity = this.f21238a;
            rVar2 = choiceCloudActivity.f21220h;
            choiceCloudActivity.a(rVar2);
            return;
        }
        this.f21238a.finish();
    }
}
