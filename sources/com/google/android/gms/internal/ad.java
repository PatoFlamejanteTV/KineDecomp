package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad extends zzbu<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(String str, String str2) {
        super(str, str2, null);
    }

    @Override // com.google.android.gms.internal.zzbu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zzde());
    }
}
