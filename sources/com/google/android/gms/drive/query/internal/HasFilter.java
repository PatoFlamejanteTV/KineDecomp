package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class HasFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final MetadataBundle f1163a;
    final int b;
    final MetadataField<T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HasFilter(int i, MetadataBundle metadataBundle) {
        this.b = i;
        this.f1163a = metadataBundle;
        this.c = (MetadataField<T>) a.a(metadataBundle);
    }

    public T a() {
        return (T) this.f1163a.a(this.c);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.a((MetadataField<MetadataField<T>>) this.c, (MetadataField<T>) a());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
