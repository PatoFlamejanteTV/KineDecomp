package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class zza<T> implements MetadataField<T> {
    private final String zzamv;
    private final Set<String> zzamw;
    private final Set<String> zzamx;
    private final int zzamy;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str, int i) {
        this.zzamv = (String) zzx.a(str, (Object) "fieldName");
        this.zzamw = Collections.singleton(str);
        this.zzamx = Collections.emptySet();
        this.zzamy = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzamv = (String) zzx.a(str, (Object) "fieldName");
        this.zzamw = Collections.unmodifiableSet(new HashSet(collection));
        this.zzamx = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzamy = i;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final String getName() {
        return this.zzamv;
    }

    public String toString() {
        return this.zzamv;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        if (zzb(dataHolder, i, i2)) {
            return zzc(dataHolder, i, i2);
        }
        return null;
    }

    protected abstract void zza(Bundle bundle, T t);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzx.a(dataHolder, "dataHolder");
        zzx.a(metadataBundle, "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.a(this, zzc(dataHolder, i, i2));
        }
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(T t, Bundle bundle) {
        zzx.a(bundle, "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, (Bundle) t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzamw) {
            if (!dataHolder.a(str) || dataHolder.h(str, i, i2)) {
                return false;
            }
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zzj(Bundle bundle) {
        zzx.a(bundle, "bundle");
        if (bundle.get(getName()) != null) {
            return zzk(bundle);
        }
        return null;
    }

    protected abstract T zzk(Bundle bundle);

    public final Collection<String> zzrG() {
        return this.zzamw;
    }
}
