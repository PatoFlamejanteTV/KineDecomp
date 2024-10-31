package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash;

/* loaded from: classes2.dex */
public final class zzh extends a {
    private final boolean zzah;

    public zzh(Context context, FirebaseCrash.zza zzaVar, boolean z) {
        super(context, zzaVar);
        this.zzah = z;
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final String getErrorMessage() {
        boolean z = this.zzah;
        StringBuilder sb = new StringBuilder(30);
        sb.append("Failed to setAppState to ");
        sb.append(z);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.crash.a
    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }

    @Override // com.google.android.gms.internal.crash.a, java.lang.Runnable
    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final void zzd(zzm zzmVar) throws RemoteException {
        zzmVar.zza(this.zzah);
    }
}
