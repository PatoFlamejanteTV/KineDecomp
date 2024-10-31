package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class Permission implements SafeParcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    final int f1063a;
    private String b;
    private int c;
    private String d;
    private String e;
    private int f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Permission(int i, String str, int i2, String str2, String str3, int i3, boolean z) {
        this.f1063a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
        this.e = str3;
        this.f = i3;
        this.g = z;
    }

    public static boolean a(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public String a() {
        if (a(this.c)) {
            return this.b;
        }
        return null;
    }

    public int b() {
        if (a(this.c)) {
            return this.c;
        }
        return -1;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        if (b(this.f)) {
            return this.f;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Permission permission = (Permission) obj;
        return zzw.a(this.b, permission.b) && this.c == permission.c && this.f == permission.f && this.g == permission.g;
    }

    public boolean f() {
        return this.g;
    }

    public int hashCode() {
        return zzw.a(this.b, Integer.valueOf(this.c), Integer.valueOf(this.f), Boolean.valueOf(this.g));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
