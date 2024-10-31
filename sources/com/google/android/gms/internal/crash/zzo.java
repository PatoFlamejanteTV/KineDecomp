package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class zzo {
    private static zzo zzam;
    private Context zzf;

    private zzo() {
    }

    public static synchronized zzo zzl() {
        zzo zzoVar;
        synchronized (zzo.class) {
            if (zzam == null) {
                zzam = new zzo();
            }
            zzoVar = zzam;
        }
        return zzoVar;
    }

    public final void init(Context context) {
        this.zzf = context;
    }

    public final zzm zzm() throws zzp {
        try {
            DynamiteModule a2 = DynamiteModule.a(this.zzf, DynamiteModule.j, "com.google.android.gms.crash");
            Preconditions.a(a2);
            IBinder a3 = a2.a("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl");
            if (a3 == null) {
                return null;
            }
            IInterface queryLocalInterface = a3.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
            if (queryLocalInterface instanceof zzm) {
                return (zzm) queryLocalInterface;
            }
            return new zzn(a3);
        } catch (DynamiteModule.LoadingException e2) {
            CrashUtils.a(this.zzf, e2);
            throw new zzp(e2);
        }
    }
}
