package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class zzj<T extends Parcelable> extends com.google.android.gms.drive.metadata.zza<T> {
    public zzj(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public T zzk(Bundle bundle) {
        return (T) bundle.getParcelable(getName());
    }
}
