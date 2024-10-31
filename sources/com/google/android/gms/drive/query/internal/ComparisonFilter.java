package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final Operator f1158a;
    final MetadataBundle b;
    final int c;
    final MetadataField<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.c = i;
        this.f1158a = operator;
        this.b = metadataBundle;
        this.d = (MetadataField<T>) a.a(metadataBundle);
    }

    public T a() {
        return (T) this.b.a(this.d);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.a(this.f1158a, this.d, a());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
