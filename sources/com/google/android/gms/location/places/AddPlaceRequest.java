package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AddPlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1865a;
    private final String b;
    private final LatLng c;
    private final String d;
    private final List<Integer> e;
    private final String f;
    private final Uri g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddPlaceRequest(int i, String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this.f1865a = i;
        this.b = zzx.a(str);
        this.c = (LatLng) zzx.a(latLng);
        this.d = zzx.a(str2);
        this.e = new ArrayList((Collection) zzx.a(list));
        zzx.b(!this.e.isEmpty(), "At least one place type should be provided.");
        zzx.b((TextUtils.isEmpty(str3) && uri == null) ? false : true, "One of phone number or URI should be provided.");
        this.f = str3;
        this.g = uri;
    }

    public String a() {
        return this.b;
    }

    public LatLng b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public List<Integer> d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public Uri f() {
        return this.g;
    }

    public String toString() {
        return zzw.a(this).a("name", this.b).a("latLng", this.c).a("address", this.d).a("placeTypes", this.e).a("phoneNumer", this.f).a("websiteUri", this.g).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
