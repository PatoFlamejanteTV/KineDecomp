package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes.dex */
public class PlusSession implements SafeParcelable {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f2161a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final PlusCommonExtras j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlusSession(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.f2161a = i;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = plusCommonExtras;
    }

    public PlusSession(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.f2161a = 1;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = null;
        this.j = plusCommonExtras;
    }

    public int a() {
        return this.f2161a;
    }

    public String b() {
        return this.b;
    }

    public String[] c() {
        return this.c;
    }

    public String[] d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusSession)) {
            return false;
        }
        PlusSession plusSession = (PlusSession) obj;
        return this.f2161a == plusSession.f2161a && zzw.a(this.b, plusSession.b) && Arrays.equals(this.c, plusSession.c) && Arrays.equals(this.d, plusSession.d) && Arrays.equals(this.e, plusSession.e) && zzw.a(this.f, plusSession.f) && zzw.a(this.g, plusSession.g) && zzw.a(this.h, plusSession.h) && zzw.a(this.i, plusSession.i) && zzw.a(this.j, plusSession.j);
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f2161a), this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public String i() {
        return this.i;
    }

    public PlusCommonExtras j() {
        return this.j;
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.j.a(bundle);
        return bundle;
    }

    public String toString() {
        return zzw.a(this).a("versionCode", Integer.valueOf(this.f2161a)).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("extra", this.j.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
