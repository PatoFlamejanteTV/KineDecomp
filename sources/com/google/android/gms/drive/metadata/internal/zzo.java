package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public class zzo extends com.google.android.gms.drive.metadata.zza<String> {
    public zzo(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public void zza(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public String zzc(DataHolder dataHolder, int i, int i2) {
        return dataHolder.c(getName(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public String zzk(Bundle bundle) {
        return bundle.getString(getName());
    }
}
