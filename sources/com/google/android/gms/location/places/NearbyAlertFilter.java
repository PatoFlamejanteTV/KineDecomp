package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f1867a;
    final List<String> b;
    final List<Integer> c;
    final List<UserDataType> d;
    private final Set<String> e;
    private final Set<Integer> f;
    private final Set<UserDataType> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyAlertFilter(int i, List<String> list, List<Integer> list2, List<UserDataType> list3) {
        this.f1867a = i;
        this.c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f = a((List) this.c);
        this.g = a((List) this.d);
        this.e = a((List) this.b);
    }

    @Deprecated
    public static NearbyAlertFilter a(Collection<String> collection, Collection<Integer> collection2, Collection<UserDataType> collection3) {
        if ((collection == null || collection.isEmpty()) && ((collection2 == null || collection2.isEmpty()) && (collection3 == null || collection3.isEmpty()))) {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least onePlaceId, PlaceType, or UserDataType to match results with.");
        }
        return new NearbyAlertFilter(0, a(collection), a(collection2), a(collection3));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) obj;
        return this.f.equals(nearbyAlertFilter.f) && this.g.equals(nearbyAlertFilter.g) && this.e.equals(nearbyAlertFilter.e);
    }

    public int hashCode() {
        return zzw.a(this.f, this.g, this.e);
    }

    public String toString() {
        zzw.zza a2 = zzw.a(this);
        if (!this.f.isEmpty()) {
            a2.a("types", this.f);
        }
        if (!this.e.isEmpty()) {
            a2.a("placeIds", this.e);
        }
        if (!this.g.isEmpty()) {
            a2.a("requestedUserDataTypes", this.g);
        }
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.a(this, parcel, i);
    }
}
