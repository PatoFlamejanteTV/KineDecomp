package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;

/* loaded from: classes.dex */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    private OnPreloadStatusUpdatedListener d;
    private OnQueueStatusUpdatedListener e;
    private OnMetadataUpdatedListener f;
    private OnStatusUpdatedListener g;

    /* renamed from: a, reason: collision with root package name */
    private final Object f837a = new Object();
    private final a c = new a();
    private final zzm b = new e(this, null);

    /* loaded from: classes.dex */
    public interface MediaChannelResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface OnMetadataUpdatedListener {
        void a();
    }

    /* loaded from: classes.dex */
    public interface OnPreloadStatusUpdatedListener {
        void a();
    }

    /* loaded from: classes.dex */
    public interface OnQueueStatusUpdatedListener {
        void a();
    }

    /* loaded from: classes.dex */
    public interface OnStatusUpdatedListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements zzn {
        private GoogleApiClient b;
        private long c = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private final class C0030a implements ResultCallback<Status> {
            private final long b;

            C0030a(long j) {
                this.b = j;
            }

            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.d()) {
                    return;
                }
                RemoteMediaPlayer.this.b.zzb(this.b, status.e());
            }
        }

        public a() {
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public long a() {
            long j = this.c + 1;
            this.c = j;
            return j;
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public void a(String str, String str2, long j, String str3) throws IOException {
            if (this.b == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.b.a(this.b, str, str2).setResultCallback(new C0030a(j));
        }
    }

    public RemoteMediaPlayer() {
        this.b.zza(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g != null) {
            this.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f != null) {
            this.f.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void a(CastDevice castDevice, String str, String str2) {
        this.b.zzbK(str2);
    }
}
