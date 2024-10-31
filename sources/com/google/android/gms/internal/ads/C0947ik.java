package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* renamed from: com.google.android.gms.internal.ads.ik */
/* loaded from: classes2.dex */
public final class C0947ik extends C0934hk {
    private final AudioTimestamp j;
    private long k;
    private long l;
    private long m;

    public C0947ik() {
        super(null);
        this.j = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.C0934hk
    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
    }

    @Override // com.google.android.gms.internal.ads.C0934hk
    public final boolean d() {
        boolean timestamp = this.f12195a.getTimestamp(this.j);
        if (timestamp) {
            long j = this.j.framePosition;
            if (this.l > j) {
                this.k++;
            }
            this.l = j;
            this.m = j + (this.k << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.C0934hk
    public final long e() {
        return this.j.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.C0934hk
    public final long f() {
        return this.m;
    }
}
