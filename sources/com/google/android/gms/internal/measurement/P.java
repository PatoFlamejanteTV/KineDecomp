package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes2.dex */
public final class P extends zzsi<Integer> {
    public P(zzso zzsoVar, String str, Integer num) {
        super(zzsoVar, str, num, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzsi
    /* renamed from: a */
    public final Integer zzs(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Long) {
            return Integer.valueOf(((Long) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zztr).length() + 24 + String.valueOf(valueOf).length());
        sb.append("Invalid int value for ");
        sb.append(zztr);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
