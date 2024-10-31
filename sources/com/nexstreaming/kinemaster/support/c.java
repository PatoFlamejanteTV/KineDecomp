package com.nexstreaming.kinemaster.support;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: ChoiceCloudActivity.java */
/* loaded from: classes.dex */
public class c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ChoiceCloudActivity f21239a;

    public c(ChoiceCloudActivity choiceCloudActivity) {
        this.f21239a = choiceCloudActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar;
        t tVar2;
        tVar = this.f21239a.f21218f;
        if (tVar != null) {
            tVar2 = this.f21239a.f21218f;
            this.f21239a.c(tVar2.getItem(i).f21256b);
        }
    }
}
