package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class zzi<T extends Parcelable> extends com.google.android.gms.drive.metadata.zzb<T> {
    public zzi(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList<>(collection));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public Collection<T> zzk(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
