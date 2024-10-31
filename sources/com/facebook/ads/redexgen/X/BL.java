package com.facebook.ads.redexgen.X;

import android.media.AudioManager;

/* loaded from: assets/audience_network.dex */
public class BL implements InterfaceC0267Al {
    public final /* synthetic */ BR A00;

    public BL(BR br) {
        this.A00 = br;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        AudioManager audioManager;
        BR br = this.A00;
        audioManager = this.A00.A00;
        return br.A0F(audioManager.isMicrophoneMute());
    }
}
