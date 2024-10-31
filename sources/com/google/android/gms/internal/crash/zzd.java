package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash;

/* loaded from: classes2.dex */
public final class zzd extends a {
    private final long timestamp;
    private final String zzae;
    private final Bundle zzaf;

    public zzd(Context context, FirebaseCrash.zza zzaVar, String str, long j, Bundle bundle) {
        super(context, zzaVar);
        this.zzae = str;
        this.timestamp = j;
        this.zzaf = bundle;
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final String getErrorMessage() {
        return "Failed to log analytics event";
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
        zzmVar.zza(this.zzae, this.timestamp, this.zzaf);
    }

    @Override // com.google.android.gms.internal.crash.a
    protected final boolean zzk() {
        return true;
    }
}
