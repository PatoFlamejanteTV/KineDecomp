package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes2.dex */
public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new zzbd();

    /* renamed from: a, reason: collision with root package name */
    final int f1107a;
    final DataHolder b;
    final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnListEntriesResponse(int i, DataHolder dataHolder, boolean z) {
        this.f1107a = i;
        this.b = dataHolder;
        this.c = z;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void a(Parcel parcel, int i) {
        zzbd.a(this, parcel, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
