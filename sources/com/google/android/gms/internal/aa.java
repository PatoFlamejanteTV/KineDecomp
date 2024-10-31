package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends zzbu<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(String str, Boolean bool) {
        super(str, bool, null);
    }

    @Override // com.google.android.gms.internal.zzbu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzde().booleanValue()));
    }
}
