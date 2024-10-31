package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final int f2144a;
    public final long b;
    public final long c;
    public final String d;
    public final byte[] e;
    public final Bundle f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.f2144a = i;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = bArr;
        this.f = bundle;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        this.f2144a = 1;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = bArr;
        this.f = a(strArr);
    }

    private static Bundle a(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=").append(this.d).append(",");
        sb.append("eventTime=").append(this.b).append(",");
        sb.append("eventUptime=").append(this.c).append(",");
        if (this.f != null && !this.f.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.f.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.f.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
