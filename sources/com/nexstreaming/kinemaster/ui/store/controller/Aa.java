package com.nexstreaming.kinemaster.ui.store.controller;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailPreviewFragment.java */
/* loaded from: classes2.dex */
public class Aa implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ca f23407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(Ca ca) {
        this.f23407a = ca;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        TextView textView;
        int i2;
        String m;
        if (z) {
            z2 = this.f23407a.f23419c;
            if (z2) {
                this.f23407a.f23424h = true;
                this.f23407a.f23418b = i;
                textView = this.f23407a.r;
                Ca ca = this.f23407a;
                i2 = ca.f23418b;
                m = ca.m(i2);
                textView.setText(m);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f23407a.C();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f23407a.D();
    }
}
