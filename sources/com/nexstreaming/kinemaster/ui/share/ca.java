package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class ca implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(ShareSNSActivity shareSNSActivity) {
        this.f4339a = shareSNSActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String[] strArr;
        ShareSNSActivity shareSNSActivity = this.f4339a;
        strArr = this.f4339a.m;
        shareSNSActivity.r = strArr[i];
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f4339a.r = null;
    }
}
