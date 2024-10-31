package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes.dex */
public final class AppMetadata implements SafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f2093a;
    private final List<AppIdentifier> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppMetadata(int i, List<AppIdentifier> list) {
        this.f2093a = i;
        this.b = (List) zzx.a(list, "Must specify application identifiers");
        zzx.a(list.size(), "Application identifiers cannot be empty");
    }

    public int a() {
        return this.f2093a;
    }

    public List<AppIdentifier> b() {
        return this.b;
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
