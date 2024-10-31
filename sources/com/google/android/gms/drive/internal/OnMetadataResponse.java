package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class OnMetadataResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new zzbf();

    /* renamed from: a, reason: collision with root package name */
    final int f1110a;
    final MetadataBundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnMetadataResponse(int i, MetadataBundle metadataBundle) {
        this.f1110a = i;
        this.b = metadataBundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbf.a(this, parcel, i);
    }
}
