package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f1873a;
    private final String b;
    private final String c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceReport(int i, String str, String str2, String str3) {
        this.f1873a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.a(this.b, placeReport.b) && zzw.a(this.c, placeReport.c) && zzw.a(this.d, placeReport.d);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, this.d);
    }

    public String toString() {
        zzw.zza a2 = zzw.a(this);
        a2.a("placeId", this.b);
        a2.a("tag", this.c);
        if (!"unknown".equals(this.d)) {
            a2.a(ShareConstants.FEED_SOURCE_PARAM, this.d);
        }
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
