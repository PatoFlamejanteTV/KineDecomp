package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends zzbu<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(String str, Integer num) {
        super(str, num, null);
    }

    @Override // com.google.android.gms.internal.zzbu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zzde().intValue()));
    }
}
