package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.d */
/* loaded from: classes2.dex */
public final class C0867d extends zzaac<Float> {
    public C0867d(int i, String str, Float f2) {
        super(i, str, f2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f2) {
        editor.putFloat(getKey(), f2.floatValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Float zzb(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), zzqv().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Float zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), zzqv().floatValue()));
    }
}
