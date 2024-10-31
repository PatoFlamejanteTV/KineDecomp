package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: CodecLimitsSettings.java */
/* loaded from: classes2.dex */
class C implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ CodecLimitsSettings f23024a;

    public C(CodecLimitsSettings codecLimitsSettings) {
        this.f23024a = codecLimitsSettings;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f23024a.J = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
