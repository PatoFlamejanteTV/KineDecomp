package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzzv;

@zzark
/* loaded from: classes.dex */
public final class VideoController {

    /* renamed from: a */
    private final Object f9944a = new Object();

    /* renamed from: b */
    private zzyp f9945b;

    /* renamed from: c */
    private VideoLifecycleCallbacks f9946c;

    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void a(zzyp zzypVar) {
        synchronized (this.f9944a) {
            this.f9945b = zzypVar;
            if (this.f9946c != null) {
                a(this.f9946c);
            }
        }
    }

    public final zzyp b() {
        zzyp zzypVar;
        synchronized (this.f9944a) {
            zzypVar = this.f9945b;
        }
        return zzypVar;
    }

    public final void a(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.a(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f9944a) {
            this.f9946c = videoLifecycleCallbacks;
            if (this.f9945b == null) {
                return;
            }
            try {
                this.f9945b.zza(new zzzv(videoLifecycleCallbacks));
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e2);
            }
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f9944a) {
            z = this.f9945b != null;
        }
        return z;
    }
}
