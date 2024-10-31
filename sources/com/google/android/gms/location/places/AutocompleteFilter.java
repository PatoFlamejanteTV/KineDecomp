package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f1866a;
    final boolean b;
    final List<Integer> c;
    private final Set<Integer> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutocompleteFilter(int i, boolean z, Collection<Integer> collection) {
        this.f1866a = i;
        this.b = z;
        this.c = collection == null ? Collections.emptyList() : new ArrayList<>(collection);
        if (this.c.isEmpty()) {
            this.d = Collections.emptySet();
        } else {
            this.d = Collections.unmodifiableSet(new HashSet(this.c));
        }
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.d.equals(autocompleteFilter.d) && this.b == autocompleteFilter.b;
    }

    public int hashCode() {
        return zzw.a(Boolean.valueOf(this.b), this.d);
    }

    public String toString() {
        zzw.zza a2 = zzw.a(this);
        if (!this.b) {
            a2.a("restrictedToPlaces", Boolean.valueOf(this.b));
        }
        a2.a("placeTypes", this.d);
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.a(this, parcel, i);
    }
}
