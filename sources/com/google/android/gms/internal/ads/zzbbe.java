package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzark
/* loaded from: classes2.dex */
public final class zzbbe {
    public static <T> T zza(Context context, String str, zzbbf<IBinder, T> zzbbfVar) throws zzbbg {
        try {
            return zzbbfVar.apply(zzbn(context).a(str));
        } catch (Exception e2) {
            throw new zzbbg(e2);
        }
    }

    public static Context zzbm(Context context) throws zzbbg {
        return zzbn(context).a();
    }

    private static DynamiteModule zzbn(Context context) throws zzbbg {
        try {
            return DynamiteModule.a(context, DynamiteModule.f11326h, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzbbg(e2);
        }
    }
}
