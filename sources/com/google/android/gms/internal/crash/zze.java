package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash;

/* loaded from: classes2.dex */
public final class zze extends a {
    private final Throwable zzag;
    private final zzq zzk;

    public zze(Context context, FirebaseCrash.zza zzaVar, Throwable th, zzq zzqVar) {
        super(context, zzaVar);
        this.zzag = th;
        this.zzk = zzqVar;
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final String getErrorMessage() {
        return "Failed to report caught exception";
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
        zzq zzqVar = this.zzk;
        if (zzqVar != null) {
            zzqVar.zza(false, System.currentTimeMillis());
        }
        zzmVar.zza(ObjectWrapper.a(this.zzag));
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final boolean zzk() {
        return true;
    }
}
