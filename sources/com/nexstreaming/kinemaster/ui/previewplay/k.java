package com.nexstreaming.kinemaster.ui.previewplay;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class k implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f21732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PreviewPlayActivity previewPlayActivity) {
        this.f21732a = previewPlayActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView;
        String d2;
        if (z) {
            textView = this.f21732a.L;
            d2 = this.f21732a.d(i);
            textView.setText(d2);
            this.f21732a.Q = i;
            this.f21732a.T();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f21732a.N();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f21732a.O();
    }
}
