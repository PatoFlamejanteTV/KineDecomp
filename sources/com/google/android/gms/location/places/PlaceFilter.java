package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    final int f1869a;
    final List<Integer> b;
    final boolean c;
    final List<UserDataType> d;
    final List<String> e;
    private final Set<Integer> f;
    private final Set<UserDataType> g;
    private final Set<String> h;

    @Deprecated
    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private Collection<Integer> f1870a = null;
        private boolean b = false;
        private Collection<UserDataType> c = null;
        private String[] d = null;

        private zza() {
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceFilter(int i, List<Integer> list, boolean z, List<String> list2, List<UserDataType> list3) {
        this.f1869a = i;
        this.b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.c = z;
        this.d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f = a((List) this.b);
        this.g = a((List) this.d);
        this.h = a((List) this.e);
    }

    public PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<UserDataType> collection3) {
        this(0, a(collection), z, a(collection2), a(collection3));
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this(null, z, collection, null);
    }

    public Set<String> a() {
        return this.h;
    }

    public Set<Integer> b() {
        return this.f;
    }

    public Set<UserDataType> c() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzg zzgVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.f.equals(placeFilter.f) && this.c == placeFilter.c && this.g.equals(placeFilter.g) && this.h.equals(placeFilter.h);
    }

    public int hashCode() {
        return zzw.a(this.f, Boolean.valueOf(this.c), this.g, this.h);
    }

    public String toString() {
        zzw.zza a2 = zzw.a(this);
        if (!this.f.isEmpty()) {
            a2.a("types", this.f);
        }
        a2.a("requireOpenNow", Boolean.valueOf(this.c));
        if (!this.h.isEmpty()) {
            a2.a("placeIds", this.h);
        }
        if (!this.g.isEmpty()) {
            a2.a("requestedUserDataTypes", this.g);
        }
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg zzgVar = CREATOR;
        zzg.a(this, parcel, i);
    }
}
