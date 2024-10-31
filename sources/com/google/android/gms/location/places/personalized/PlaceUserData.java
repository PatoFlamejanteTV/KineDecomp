package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

/* loaded from: classes.dex */
public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f1901a;
    private final String b;
    private final String c;
    private final List<TestDataImpl> d;
    private final List<PlaceAlias> e;
    private final List<HereContent> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceUserData(int i, String str, String str2, List<TestDataImpl> list, List<PlaceAlias> list2, List<HereContent> list3) {
        this.f1901a = i;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = list2;
        this.f = list3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<PlaceAlias> c() {
        return this.e;
    }

    public List<HereContent> d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public List<TestDataImpl> e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.b.equals(placeUserData.b) && this.c.equals(placeUserData.c) && this.d.equals(placeUserData.d) && this.e.equals(placeUserData.e) && this.f.equals(placeUserData.f);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return zzw.a(this).a("accountName", this.b).a("placeId", this.c).a("testDataImpls", this.d).a("placeAliases", this.e).a("hereContents", this.f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.a(this, parcel, i);
    }
}
