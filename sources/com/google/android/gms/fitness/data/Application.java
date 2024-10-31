package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class Application implements SafeParcelable {
    private final int b;
    private final String c;
    private final String d;
    private final String e;

    /* renamed from: a, reason: collision with root package name */
    public static final Application f1216a = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.f863a), null);
    public static final Parcelable.Creator<Application> CREATOR = new zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Application(int i, String str, String str2, String str3) {
        this.b = i;
        this.c = (String) zzx.a(str);
        this.d = "";
        this.e = str3;
    }

    public Application(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean a(Application application) {
        return this.c.equals(application.c) && zzw.a(this.d, application.d) && zzw.a(this.e, application.e);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Application) && a((Application) obj));
    }

    public int hashCode() {
        return zzw.a(this.c, this.d, this.e);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", this.c, this.d, this.e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
