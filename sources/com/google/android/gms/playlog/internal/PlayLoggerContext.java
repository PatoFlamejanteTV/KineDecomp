package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final int f2145a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final int j;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f2145a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.h = str4;
        this.i = z2;
        this.j = i4;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        this.f2145a = 1;
        this.b = (String) zzx.a(str);
        this.c = i;
        this.d = i2;
        this.h = null;
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.i = false;
        this.j = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.f2145a == playLoggerContext.f2145a && this.b.equals(playLoggerContext.b) && this.c == playLoggerContext.c && this.d == playLoggerContext.d && zzw.a(this.h, playLoggerContext.h) && zzw.a(this.e, playLoggerContext.e) && zzw.a(this.f, playLoggerContext.f) && this.g == playLoggerContext.g && this.i == playLoggerContext.i && this.j == playLoggerContext.j;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f2145a), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d), this.h, this.e, this.f, Boolean.valueOf(this.g), Boolean.valueOf(this.i), Integer.valueOf(this.j));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("versionCode=").append(this.f2145a).append(',');
        sb.append("package=").append(this.b).append(',');
        sb.append("packageVersionCode=").append(this.c).append(',');
        sb.append("logSource=").append(this.d).append(',');
        sb.append("logSourceName=").append(this.h).append(',');
        sb.append("uploadAccount=").append(this.e).append(',');
        sb.append("loggingId=").append(this.f).append(',');
        sb.append("logAndroidId=").append(this.g).append(',');
        sb.append("isAnonymous=").append(this.i).append(',');
        sb.append("qosTier=").append(this.j);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
