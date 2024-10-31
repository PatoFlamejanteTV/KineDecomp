package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash;

/* loaded from: classes2.dex */
public final class zzi extends a {
    private final boolean zzai;

    public zzi(Context context, FirebaseCrash.zza zzaVar, boolean z) {
        super(context, zzaVar);
        this.zzai = z;
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final String getErrorMessage() {
        boolean z = this.zzai;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Failed to set crash enabled to ");
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
        zzmVar.zzb(this.zzai);
    }
}
