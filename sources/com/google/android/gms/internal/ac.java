package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends zzbu<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(String str, Long l) {
        super(str, l, null);
    }

    @Override // com.google.android.gms.internal.zzbu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), zzde().longValue()));
    }
}
