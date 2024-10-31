package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes2.dex */
public final class O extends zzsi<Long> {
    public O(zzso zzsoVar, String str, Long l) {
        super(zzsoVar, str, l, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzsi
    /* renamed from: a */
    public final Long zzs(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zztr).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(zztr);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
