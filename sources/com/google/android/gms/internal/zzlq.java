package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class zzlq<R extends Result> extends com.google.android.gms.common.api.zze<R> implements ResultCallback<R> {
    private final Object zzabh;
    private com.google.android.gms.common.api.zzb<? super R, ? extends Result> zzacY;
    private zzlq<? extends Result> zzacZ;
    private ResultCallbacks<? super R> zzada;
    private PendingResult<R> zzadb;

    private void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    private void zzon() {
        if (this.zzadb != null) {
            if (this.zzacY == null && this.zzada == null) {
                return;
            }
            this.zzadb.setResultCallback(this);
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(R r) {
        synchronized (this.zzabh) {
            if (!r.getStatus().d()) {
                zzx(r.getStatus());
                zzd(r);
            } else if (this.zzacY != null) {
                PendingResult<? extends Result> a2 = this.zzacY.a((com.google.android.gms.common.api.zzb<? super R, ? extends Result>) r);
                if (a2 == null) {
                    zzx(new Status(13, "Transform returned null"));
                } else {
                    this.zzacZ.zza(a2);
                }
                zzd(r);
            } else if (this.zzada != null) {
                this.zzada.a((ResultCallbacks<? super R>) r);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzabh) {
            this.zzadb = pendingResult;
            zzon();
        }
    }

    public void zzx(Status status) {
        synchronized (this.zzabh) {
            if (this.zzacY != null) {
                Status a2 = this.zzacY.a(status);
                com.google.android.gms.common.internal.zzx.a(a2, "onFailure must not return null");
                this.zzacZ.zzx(a2);
            } else if (this.zzada != null) {
                this.zzada.a(status);
            }
        }
    }
}
