package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.clearcut.g */
/* loaded from: classes2.dex */
public final class C1199g extends zzae<String> {
    public C1199g(zzao zzaoVar, String str, String str2) {
        super(zzaoVar, str, str2, null);
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    /* renamed from: a */
    public final String zza(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.zzds, null);
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid string value in SharedPreferences for ".concat(valueOf) : new String("Invalid string value in SharedPreferences for "), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    protected final /* synthetic */ String zzb(String str) {
        return str;
    }
}
