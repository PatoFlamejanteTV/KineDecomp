package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

/* loaded from: classes.dex */
public final class UserAddressRequest implements SafeParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    List<CountrySpecification> f1419a;
    private final int b;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    UserAddressRequest() {
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserAddressRequest(int i, List<CountrySpecification> list) {
        this.b = i;
        this.f1419a = list;
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
        zza.a(this, parcel, i);
    }
}
