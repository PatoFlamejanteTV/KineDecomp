package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1304a;
    private final String b;
    private final Uri c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;
    private final int i;
    private final Bundle j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3, String str4, String str5, int i2, int i3, Bundle bundle) {
        this.f1304a = i;
        this.b = str;
        this.e = str3;
        this.g = str5;
        this.h = i2;
        this.c = uri;
        this.i = i3;
        this.f = str4;
        this.j = bundle;
        this.d = str2;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.f1304a = 4;
        this.b = appContentAnnotation.b();
        this.e = appContentAnnotation.c();
        this.g = appContentAnnotation.d();
        this.h = appContentAnnotation.e();
        this.c = appContentAnnotation.f();
        this.i = appContentAnnotation.h();
        this.f = appContentAnnotation.i();
        this.j = appContentAnnotation.g();
        this.d = appContentAnnotation.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppContentAnnotation appContentAnnotation) {
        return zzw.a(appContentAnnotation.b(), appContentAnnotation.c(), appContentAnnotation.d(), Integer.valueOf(appContentAnnotation.e()), appContentAnnotation.f(), Integer.valueOf(appContentAnnotation.h()), appContentAnnotation.i(), appContentAnnotation.g(), appContentAnnotation.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.a(appContentAnnotation2.b(), appContentAnnotation.b()) && zzw.a(appContentAnnotation2.c(), appContentAnnotation.c()) && zzw.a(appContentAnnotation2.d(), appContentAnnotation.d()) && zzw.a(Integer.valueOf(appContentAnnotation2.e()), Integer.valueOf(appContentAnnotation.e())) && zzw.a(appContentAnnotation2.f(), appContentAnnotation.f()) && zzw.a(Integer.valueOf(appContentAnnotation2.h()), Integer.valueOf(appContentAnnotation.h())) && zzw.a(appContentAnnotation2.i(), appContentAnnotation.i()) && zzw.a(appContentAnnotation2.g(), appContentAnnotation.g()) && zzw.a(appContentAnnotation2.j(), appContentAnnotation.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppContentAnnotation appContentAnnotation) {
        return zzw.a(appContentAnnotation).a("Description", appContentAnnotation.b()).a("Id", appContentAnnotation.c()).a("ImageDefaultId", appContentAnnotation.d()).a("ImageHeight", Integer.valueOf(appContentAnnotation.e())).a("ImageUri", appContentAnnotation.f()).a("ImageWidth", Integer.valueOf(appContentAnnotation.h())).a("LayoutSlot", appContentAnnotation.i()).a("Modifiers", appContentAnnotation.g()).a("Title", appContentAnnotation.j()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String c() {
        return this.e;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Uri f() {
        return this.c;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Bundle g() {
        return this.j;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int h() {
        return this.i;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String i() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String j() {
        return this.d;
    }

    public int k() {
        return this.f1304a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotation a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentAnnotationEntityCreator.a(this, parcel, i);
    }
}
