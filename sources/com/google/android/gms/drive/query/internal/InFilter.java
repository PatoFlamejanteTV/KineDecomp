package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

/* loaded from: classes2.dex */
public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final MetadataBundle f1164a;
    final int b;
    private final com.google.android.gms.drive.metadata.zzb<T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InFilter(int i, MetadataBundle metadataBundle) {
        this.b = i;
        this.f1164a = metadataBundle;
        this.c = (com.google.android.gms.drive.metadata.zzb) a.a(metadataBundle);
    }

    public T a() {
        return (T) ((Collection) this.f1164a.a(this.c)).iterator().next();
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.a((com.google.android.gms.drive.metadata.zzb<com.google.android.gms.drive.metadata.zzb<T>>) this.c, (com.google.android.gms.drive.metadata.zzb<T>) a());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
