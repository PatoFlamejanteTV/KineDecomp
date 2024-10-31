package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public class zzg extends com.google.android.gms.drive.metadata.zza<Long> {
    public zzg(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public Long zzc(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.a(getName(), i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public Long zzk(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
