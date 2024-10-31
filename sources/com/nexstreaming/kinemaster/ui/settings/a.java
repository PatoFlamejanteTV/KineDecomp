package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/* compiled from: CodecLimitsSettings.java */
/* loaded from: classes2.dex */
class A implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ Spinner f23018a;

    /* renamed from: b */
    final /* synthetic */ CodecLimitsSettings f23019b;

    public A(CodecLimitsSettings codecLimitsSettings, Spinner spinner) {
        this.f23019b = codecLimitsSettings;
        this.f23018a = spinner;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        View view2;
        View view3;
        this.f23019b.I = i;
        if (i != this.f23018a.getAdapter().getCount() - 1) {
            view3 = this.f23019b.H;
            view3.setVisibility(0);
        } else {
            view2 = this.f23019b.H;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
