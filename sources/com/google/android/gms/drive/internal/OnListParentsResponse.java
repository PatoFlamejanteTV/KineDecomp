package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes2.dex */
public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new zzbe();

    /* renamed from: a, reason: collision with root package name */
    final int f1108a;
    final DataHolder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnListParentsResponse(int i, DataHolder dataHolder) {
        this.f1108a = i;
        this.b = dataHolder;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void a(Parcel parcel, int i) {
        zzbe.a(this, parcel, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
