package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public final class zzib {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends zzhz {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(dl dlVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzhz
        public void onStop() {
        }
    }

    /* loaded from: classes.dex */
    public interface zzb {
        void zzd(Bundle bundle);
    }

    public static Future zza(Context context, int i) {
        return new dn(context, i).zzfu();
    }

    public static Future zza(Context context, zzb zzbVar) {
        return new dm(context, zzbVar).zzfu();
    }

    public static Future zza(Context context, boolean z) {
        return new dl(context, z).zzfu();
    }

    public static Future zzb(Context context, zzb zzbVar) {
        return new Cdo(context, zzbVar).zzfu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
