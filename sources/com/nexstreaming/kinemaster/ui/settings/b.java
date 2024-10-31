package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: CodecLimitsSettings.java */
/* loaded from: classes2.dex */
class B implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ CodecLimitsSettings f23021a;

    public B(CodecLimitsSettings codecLimitsSettings) {
        this.f23021a = codecLimitsSettings;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f23021a.J = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
