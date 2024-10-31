package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* loaded from: classes2.dex */
final class gk extends com.google.android.gms.drive.metadata.internal.zzb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    /* renamed from: zze */
    public Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.b("trashed", i, i2) == 2);
    }
}
