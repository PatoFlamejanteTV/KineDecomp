package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsRequest> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    int[] f2300a;
    private final int b;

    GetInstrumentsRequest() {
        this(1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetInstrumentsRequest(int i, int[] iArr) {
        this.b = i;
        this.f2300a = iArr;
    }

    public int a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
