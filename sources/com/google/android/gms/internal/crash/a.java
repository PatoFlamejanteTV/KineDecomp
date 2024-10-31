package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crash.FirebaseCrash;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private final FirebaseCrash.zza zzac;
    private final TaskCompletionSource<Void> zzad = new TaskCompletionSource<>();
    private final Context zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, FirebaseCrash.zza zzaVar) {
        this.zzac = zzaVar;
        this.zzf = context.getApplicationContext();
    }

    protected abstract String getErrorMessage();

    public Task<Void> getTask() {
        return this.zzad.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            zzm zzh = this.zzac.zzh();
            if (zzh != null) {
                if (!zzh.zzd() && zzk()) {
                    throw new IllegalStateException("Firebase Crash reporting is not enabled");
                }
                zzd(zzh);
                this.zzad.a((TaskCompletionSource<Void>) null);
                return;
            }
            throw new IllegalStateException("Firebase Crash api is not available");
        } catch (RemoteException | RuntimeException e2) {
            CrashUtils.a(this.zzf, e2);
            Log.e("FirebaseCrash", getErrorMessage(), e2);
            this.zzad.a(e2);
        }
    }

    protected abstract void zzd(zzm zzmVar) throws RemoteException;

    protected boolean zzk() {
        return false;
    }
}
