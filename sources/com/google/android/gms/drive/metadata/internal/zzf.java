package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public class zzf extends com.google.android.gms.drive.metadata.zza<Integer> {
    public zzf(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer zzk(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer zzc(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.b(getName(), i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }
}
