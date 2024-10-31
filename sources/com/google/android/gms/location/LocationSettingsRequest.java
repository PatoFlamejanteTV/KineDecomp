package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f1847a;
    private final List<LocationRequest> b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList<LocationRequest> f1848a = new ArrayList<>();
        private boolean b = false;
        private boolean c = false;
        private boolean d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this.f1847a = i;
        this.b = list;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    public int a() {
        return this.f1847a;
    }

    public List<LocationRequest> b() {
        return Collections.unmodifiableList(this.b);
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
