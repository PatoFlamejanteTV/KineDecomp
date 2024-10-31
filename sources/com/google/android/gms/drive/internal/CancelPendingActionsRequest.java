package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CancelPendingActionsRequest> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f1077a;
    final List<String> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CancelPendingActionsRequest(int i, List<String> list) {
        this.f1077a = i;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
