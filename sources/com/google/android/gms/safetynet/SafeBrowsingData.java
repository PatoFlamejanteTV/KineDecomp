package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class SafeBrowsingData implements SafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f2188a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeBrowsingData(int i, String str) {
        this.f2188a = i;
        this.b = str;
    }

    public String a() {
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
