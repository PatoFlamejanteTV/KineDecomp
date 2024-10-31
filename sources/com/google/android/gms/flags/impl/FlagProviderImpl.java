package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends com.google.android.gms.flags.zzd {

    /* renamed from: a, reason: collision with root package name */
    private boolean f11342a = false;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f11343b;

    @Override // com.google.android.gms.flags.zzc
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f11342a ? z : zzb.a(this.f11343b, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f11342a ? i : zzd.a(this.f11343b, str, Integer.valueOf(i)).intValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public long getLongFlagValue(String str, long j, int i) {
        return !this.f11342a ? j : zzf.a(this.f11343b, str, Long.valueOf(j)).longValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f11342a ? str2 : zzh.a(this.f11343b, str, str2);
    }

    @Override // com.google.android.gms.flags.zzc
    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        if (this.f11342a) {
            return;
        }
        try {
            this.f11343b = zzj.a(context.createPackageContext("com.google.android.gms", 0));
            this.f11342a = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
