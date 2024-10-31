package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class UserAttributeParcel implements SafeParcelable {
    public static final zzaf CREATOR = new zzaf();

    /* renamed from: a, reason: collision with root package name */
    public final int f2021a;
    public final String b;
    public final long c;
    public final Long d;
    public final Float e;
    public final String f;
    public final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3) {
        this.f2021a = i;
        this.b = str;
        this.c = j;
        this.d = l;
        this.e = f;
        this.f = str2;
        this.g = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserAttributeParcel(String str, long j, Object obj, String str2) {
        zzx.a(str);
        this.f2021a = 1;
        this.b = str;
        this.c = j;
        this.g = str2;
        if (obj == null) {
            this.d = null;
            this.e = null;
            this.f = null;
            return;
        }
        if (obj instanceof Long) {
            this.d = (Long) obj;
            this.e = null;
            this.f = null;
            return;
        }
        if (obj instanceof Float) {
            this.d = null;
            this.e = (Float) obj;
            this.f = null;
        } else if (obj instanceof String) {
            this.d = null;
            this.e = null;
            this.f = (String) obj;
        } else {
            if (obj != null) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    public Object a() {
        if (this.d != null) {
            return this.d;
        }
        if (this.e != null) {
            return this.e;
        }
        if (this.f != null) {
            return this.f;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaf.a(this, parcel, i);
    }
}
