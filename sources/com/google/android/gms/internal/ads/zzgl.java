package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes2.dex */
public final class zzgl {
    private final Handler handler;
    private final zzgk zzabi;

    public zzgl(Handler handler, zzgk zzgkVar) {
        Handler handler2;
        if (zzgkVar != null) {
            zzpo.checkNotNull(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.handler = handler2;
        this.zzabi = zzgkVar;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0848bk(this, str, j, j2));
        }
    }

    public final void zzc(zzhn zzhnVar) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0833ak(this, zzhnVar));
        }
    }

    public final void zzd(zzfs zzfsVar) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0863ck(this, zzfsVar));
        }
    }

    public final void zzm(int i) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0906fk(this, i));
        }
    }

    public final void zzb(int i, long j, long j2) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0878dk(this, i, j, j2));
        }
    }

    public final void zzd(zzhn zzhnVar) {
        if (this.zzabi != null) {
            this.handler.post(new RunnableC0892ek(this, zzhnVar));
        }
    }
}
