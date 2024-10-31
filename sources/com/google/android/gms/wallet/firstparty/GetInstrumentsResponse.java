package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsResponse> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    String[] f2301a;
    byte[][] b;
    private final int c;

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetInstrumentsResponse(int i, String[] strArr, byte[][] bArr) {
        this.c = i;
        this.f2301a = strArr;
        this.b = bArr;
    }

    public int a() {
        return this.c;
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
