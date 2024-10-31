package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* renamed from: com.google.android.gms.internal.ads.gk */
/* loaded from: classes2.dex */
public final class C0920gk extends Thread {

    /* renamed from: a */
    private final /* synthetic */ AudioTrack f12183a;

    /* renamed from: b */
    private final /* synthetic */ zzgs f12184b;

    public C0920gk(zzgs zzgsVar, AudioTrack audioTrack) {
        this.f12184b = zzgsVar;
        this.f12183a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.f12183a.flush();
            this.f12183a.release();
        } finally {
            conditionVariable = this.f12184b.zzacb;
            conditionVariable.open();
        }
    }
}
