package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.internal.ads.hk */
/* loaded from: classes2.dex */
public class C0934hk {

    /* renamed from: a */
    protected AudioTrack f12195a;

    /* renamed from: b */
    private boolean f12196b;

    /* renamed from: c */
    private int f12197c;

    /* renamed from: d */
    private long f12198d;

    /* renamed from: e */
    private long f12199e;

    /* renamed from: f */
    private long f12200f;

    /* renamed from: g */
    private long f12201g;

    /* renamed from: h */
    private long f12202h;
    private long i;

    private C0934hk() {
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.f12195a = audioTrack;
        this.f12196b = z;
        this.f12201g = -9223372036854775807L;
        this.f12198d = 0L;
        this.f12199e = 0L;
        this.f12200f = 0L;
        if (audioTrack != null) {
            this.f12197c = audioTrack.getSampleRate();
        }
    }

    public final long b() {
        if (this.f12201g != -9223372036854775807L) {
            return Math.min(this.i, this.f12202h + ((((SystemClock.elapsedRealtime() * 1000) - this.f12201g) * this.f12197c) / 1000000));
        }
        int playState = this.f12195a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.f12195a.getPlaybackHeadPosition();
        if (this.f12196b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f12200f = this.f12198d;
            }
            playbackHeadPosition += this.f12200f;
        }
        if (this.f12198d > playbackHeadPosition) {
            this.f12199e++;
        }
        this.f12198d = playbackHeadPosition;
        return playbackHeadPosition + (this.f12199e << 32);
    }

    public final long c() {
        return (b() * 1000000) / this.f12197c;
    }

    public boolean d() {
        return false;
    }

    public long e() {
        throw new UnsupportedOperationException();
    }

    public long f() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C0934hk(C0920gk c0920gk) {
        this();
    }

    public final void a(long j) {
        this.f12202h = b();
        this.f12201g = SystemClock.elapsedRealtime() * 1000;
        this.i = j;
        this.f12195a.stop();
    }

    public final void a() {
        if (this.f12201g != -9223372036854775807L) {
            return;
        }
        this.f12195a.pause();
    }
}
