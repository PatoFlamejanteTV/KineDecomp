package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class VersionInfoParcel implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final int f653a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES), i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.f653a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
