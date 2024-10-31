package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final MetadataBundle f1159a;
    final int b;
    private final MetadataField<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.b = i;
        this.f1159a = metadataBundle;
        this.c = a.a(metadataBundle);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <T> T a(zzf<T> zzfVar) {
        return zzfVar.a(this.c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
