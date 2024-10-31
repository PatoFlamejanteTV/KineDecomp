package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class SaveRequest implements SafeParcelable {
    public static final Parcelable.Creator<SaveRequest> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f795a;
    private final Credential b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaveRequest(int i, Credential credential) {
        this.f795a = i;
        this.b = credential;
    }

    public Credential a() {
        return this.b;
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
