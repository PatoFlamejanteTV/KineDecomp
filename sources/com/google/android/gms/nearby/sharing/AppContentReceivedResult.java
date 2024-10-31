package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class AppContentReceivedResult implements SafeParcelable {
    public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f2130a;
    private Uri b;
    private int c;

    private AppContentReceivedResult() {
        this.f2130a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentReceivedResult(int i, Uri uri, int i2) {
        this.f2130a = i;
        this.b = uri;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2130a;
    }

    public Uri b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppContentReceivedResult)) {
            return false;
        }
        AppContentReceivedResult appContentReceivedResult = (AppContentReceivedResult) obj;
        return zzw.a(this.b, appContentReceivedResult.b) && zzw.a(Integer.valueOf(this.c), Integer.valueOf(appContentReceivedResult.c));
    }

    public int hashCode() {
        return zzw.a(this.b, Integer.valueOf(this.c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
