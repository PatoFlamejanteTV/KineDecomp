package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* loaded from: classes2.dex */
final class gl extends com.google.android.gms.drive.metadata.internal.zzj<BitmapTeleporter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapTeleporter zzc(DataHolder dataHolder, int i, int i2) {
        throw new IllegalStateException("Thumbnail field is write only");
    }
}
