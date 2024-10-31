package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes2.dex */
public final class Q extends zzsi<Boolean> {
    public Q(zzso zzsoVar, String str, Boolean bool) {
        super(zzsoVar, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzsi
    final /* synthetic */ Boolean zzs(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzru.zzbqo.matcher(str).matches()) {
                return true;
            }
            if (zzru.zzbqp.matcher(str).matches()) {
                return false;
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zztr).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zztr);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
