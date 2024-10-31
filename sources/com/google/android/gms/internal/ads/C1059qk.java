package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(24)
/* renamed from: com.google.android.gms.internal.ads.qk */
/* loaded from: classes2.dex */
public final class C1059qk {

    /* renamed from: a */
    private final MediaCodec.CryptoInfo f12468a;

    /* renamed from: b */
    private final MediaCodec.CryptoInfo.Pattern f12469b;

    /* JADX INFO: Access modifiers changed from: private */
    public C1059qk(MediaCodec.CryptoInfo cryptoInfo) {
        this.f12468a = cryptoInfo;
        this.f12469b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public final void a(int i, int i2) {
        this.f12469b.set(i, i2);
        this.f12468a.setPattern(this.f12469b);
    }

    public /* synthetic */ C1059qk(MediaCodec.CryptoInfo cryptoInfo, C1045pk c1045pk) {
        this(cryptoInfo);
    }
}
