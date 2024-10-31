package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* loaded from: classes2.dex */
public class zzb extends com.google.android.gms.drive.metadata.zza<Boolean> {
    public zzb(String str, int i) {
        super(str, i);
    }

    public zzb(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.d(getName(), i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public Boolean zzk(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
