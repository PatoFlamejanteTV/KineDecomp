package com.nexstreaming.kinemaster.ui.previewplay;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class h implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3727a;
    private boolean b = false;
    private int c = -1;
    private int d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PreviewPlayActivity previewPlayActivity) {
        this.f3727a = previewPlayActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.b) {
            if (this.c < 0) {
                z = this.f3727a.o;
                if (!z) {
                    z2 = this.f3727a.n;
                    if (!z2) {
                        z3 = this.f3727a.f;
                        if (z3) {
                            this.f3727a.b().r();
                            this.f3727a.f();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            int i = this.c;
            this.c = -1;
            this.d++;
            int i2 = this.d;
            this.f3727a.o = true;
            this.f3727a.b().a(i).onComplete(new i(this, i2));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        boolean z2;
        TextView textView;
        String a2;
        if (z) {
            z2 = this.f3727a.n;
            if (z2) {
                textView = this.f3727a.i;
                a2 = this.f3727a.a(i);
                textView.setText(a2);
                this.c = i;
                a();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f3727a.n = true;
        this.f3727a.e();
        this.b = true;
        this.c = -1;
        this.f3727a.b().p().onComplete(new j(this));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f3727a.n = false;
        a();
    }
}
