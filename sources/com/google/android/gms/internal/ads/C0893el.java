package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(21)
/* renamed from: com.google.android.gms.internal.ads.el */
/* loaded from: classes2.dex */
public final class C0893el implements InterfaceC0864cl {

    /* renamed from: a */
    private final int f12149a;

    /* renamed from: b */
    private MediaCodecInfo[] f12150b;

    public C0893el(boolean z) {
        this.f12149a = z ? 1 : 0;
    }

    private final void c() {
        if (this.f12150b == null) {
            this.f12150b = new MediaCodecList(this.f12149a).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final MediaCodecInfo a(int i) {
        c();
        return this.f12150b[i];
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final int b() {
        c();
        return this.f12150b.length;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
