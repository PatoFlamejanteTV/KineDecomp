package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.nexstreaming.kinemaster.ui.store.controller.Ca;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailPreviewFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.store.controller.za, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2292za implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ca f23641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2292za(Ca ca) {
        this.f23641a = ca;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoView videoView;
        Ca.a aVar;
        VideoView videoView2;
        VideoView videoView3;
        boolean z;
        VideoView videoView4;
        VideoView videoView5;
        SeekBar seekBar;
        SeekBar seekBar2;
        View view;
        Ca.a aVar2;
        TextView textView;
        String m;
        TextView textView2;
        String m2;
        videoView = this.f23641a.i;
        if (videoView == null) {
            return;
        }
        aVar = this.f23641a.q;
        if (aVar != null) {
            z = this.f23641a.f23419c;
            if (!z && this.f23641a.isAdded()) {
                videoView4 = this.f23641a.i;
                int currentPosition = videoView4.getCurrentPosition();
                videoView5 = this.f23641a.i;
                int duration = videoView5.getDuration();
                seekBar = this.f23641a.n;
                seekBar.setMax(duration);
                seekBar2 = this.f23641a.n;
                seekBar2.setProgress(currentPosition);
                view = this.f23641a.p;
                aVar2 = this.f23641a.q;
                view.setSelected(aVar2.a());
                textView = this.f23641a.r;
                m = this.f23641a.m(currentPosition);
                textView.setText(m);
                textView2 = this.f23641a.s;
                m2 = this.f23641a.m(duration);
                textView2.setText(m2);
            }
        }
        videoView2 = this.f23641a.i;
        videoView2.removeCallbacks(this);
        if (this.f23641a.isAdded()) {
            videoView3 = this.f23641a.i;
            videoView3.postOnAnimationDelayed(this, 33L);
        }
    }
}
