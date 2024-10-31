package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1840a;
    private final List<ParcelableGeofence> b;
    private final int c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<ParcelableGeofence> f1841a = new ArrayList();
        private int b = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.f1840a = i;
        this.b = list;
        this.c = i2;
    }

    public int a() {
        return this.f1840a;
    }

    public List<ParcelableGeofence> b() {
        return this.b;
    }

    public int c() {
        return this.c;
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
