package com.nexstreaming.kinemaster.ui.store.controller;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailPreviewFragment.java */
/* loaded from: classes2.dex */
public class Ba implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    int f23409a;

    /* renamed from: b, reason: collision with root package name */
    long f23410b;

    /* renamed from: c, reason: collision with root package name */
    long f23411c;

    /* renamed from: d, reason: collision with root package name */
    long f23412d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Ca f23413e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(Ca ca) {
        this.f23413e = ca;
    }

    private long a() {
        this.f23411c = SystemClock.uptimeMillis();
        long j = this.f23411c;
        this.f23412d = j - this.f23410b;
        this.f23410b = j;
        return this.f23412d;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SeekBar seekBar;
        SeekBar seekBar2;
        SeekBar seekBar3;
        SeekBar seekBar4;
        SeekBar seekBar5;
        if (keyEvent.getAction() == 0) {
            if (i == 21) {
                this.f23413e.a(a());
                this.f23413e.f23424h = true;
                seekBar = this.f23413e.n;
                this.f23409a = seekBar.getProgress() - 3000;
                if (this.f23409a < 0) {
                    this.f23409a = 0;
                    seekBar2 = this.f23413e.n;
                    seekBar2.setProgress(this.f23409a);
                }
                a(this.f23409a);
                return false;
            }
            if (i == 22) {
                this.f23413e.a(a());
                this.f23413e.f23424h = true;
                seekBar3 = this.f23413e.n;
                this.f23409a = seekBar3.getProgress() + 3000;
                int i2 = this.f23409a;
                seekBar4 = this.f23413e.n;
                if (i2 > seekBar4.getMax()) {
                    seekBar5 = this.f23413e.n;
                    this.f23409a = seekBar5.getMax();
                }
                a(this.f23409a);
                return false;
            }
            if (i == 62) {
                this.f23413e.G();
                return true;
            }
        } else if (keyEvent.getAction() == 1) {
            if (i == 21) {
                this.f23413e.D();
            } else if (i == 22) {
                this.f23413e.D();
                return false;
            }
        }
        return false;
    }

    private void a(int i) {
        SeekBar seekBar;
        int i2;
        TextView textView;
        int i3;
        String m;
        this.f23413e.f23418b = i;
        seekBar = this.f23413e.n;
        i2 = this.f23413e.f23418b;
        seekBar.setProgress(i2);
        textView = this.f23413e.r;
        Ca ca = this.f23413e;
        i3 = ca.f23418b;
        m = ca.m(i3);
        textView.setText(m);
    }
}
