package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.dl */
/* loaded from: classes2.dex */
public final class C0879dl implements InterfaceC0864cl {
    /* JADX INFO: Access modifiers changed from: private */
    public C0879dl() {
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final boolean a() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final int b() {
        return MediaCodecList.getCodecCount();
    }

    public /* synthetic */ C0879dl(C0849bl c0849bl) {
        this();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0864cl
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
