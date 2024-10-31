package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

@TargetApi(23)
/* loaded from: classes2.dex */
final class Vl implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a */
    private final /* synthetic */ zzqo f11913a;

    /* JADX INFO: Access modifiers changed from: private */
    public Vl(zzqo zzqoVar, MediaCodec mediaCodec) {
        this.f11913a = zzqoVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        zzqo zzqoVar = this.f11913a;
        if (this != zzqoVar.zzbjt) {
            return;
        }
        zzqoVar.zzhq();
    }

    public /* synthetic */ Vl(zzqo zzqoVar, MediaCodec mediaCodec, Ul ul) {
        this(zzqoVar, mediaCodec);
    }
}
