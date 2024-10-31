package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.facebook.ads.redexgen.X.Qw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0686Qw implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C0687Qx A00;

    public C0686Qw(C0687Qx c0687Qx) {
        this.A00 = c0687Qx;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new C0685Qv(this, i));
    }
}
