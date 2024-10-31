package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes.dex */
public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f779a;
    final List<AccountChangeEvent> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f779a = i;
        this.b = (List) zzx.a(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
