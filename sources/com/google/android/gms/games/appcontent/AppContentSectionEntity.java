package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();

    /* renamed from: a */
    private final int f1307a;
    private final ArrayList<AppContentActionEntity> b;
    private final ArrayList<AppContentCardEntity> c;
    private final String d;
    private final Bundle e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final ArrayList<AppContentAnnotationEntity> k;

    public AppContentSectionEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentCardEntity> arrayList2, String str, Bundle bundle, String str2, String str3, String str4, String str5, String str6, ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.f1307a = i;
        this.b = arrayList;
        this.k = arrayList3;
        this.c = arrayList2;
        this.j = str6;
        this.d = str;
        this.e = bundle;
        this.i = str5;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    public AppContentSectionEntity(AppContentSection appContentSection) {
        this.f1307a = 5;
        this.j = appContentSection.e();
        this.d = appContentSection.f();
        this.e = appContentSection.g();
        this.i = appContentSection.h();
        this.f = appContentSection.i();
        this.g = appContentSection.j();
        this.h = appContentSection.k();
        List<AppContentAction> b = appContentSection.b();
        int size = b.size();
        this.b = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.b.add((AppContentActionEntity) b.get(i).a());
        }
        List<AppContentCard> d = appContentSection.d();
        int size2 = d.size();
        this.c = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.c.add((AppContentCardEntity) d.get(i2).a());
        }
        List<AppContentAnnotation> c = appContentSection.c();
        int size3 = c.size();
        this.k = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.k.add((AppContentAnnotationEntity) c.get(i3).a());
        }
    }

    public static int a(AppContentSection appContentSection) {
        return zzw.a(appContentSection.b(), appContentSection.c(), appContentSection.d(), appContentSection.e(), appContentSection.f(), appContentSection.g(), appContentSection.h(), appContentSection.i(), appContentSection.j(), appContentSection.k());
    }

    public static boolean a(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.a(appContentSection2.b(), appContentSection.b()) && zzw.a(appContentSection2.c(), appContentSection.c()) && zzw.a(appContentSection2.d(), appContentSection.d()) && zzw.a(appContentSection2.e(), appContentSection.e()) && zzw.a(appContentSection2.f(), appContentSection.f()) && zzw.a(appContentSection2.g(), appContentSection.g()) && zzw.a(appContentSection2.h(), appContentSection.h()) && zzw.a(appContentSection2.i(), appContentSection.i()) && zzw.a(appContentSection2.j(), appContentSection.j()) && zzw.a(appContentSection2.k(), appContentSection.k());
    }

    public static String b(AppContentSection appContentSection) {
        return zzw.a(appContentSection).a("Actions", appContentSection.b()).a("Annotations", appContentSection.c()).a("Cards", appContentSection.d()).a("CardType", appContentSection.e()).a("ContentDescription", appContentSection.f()).a("Extras", appContentSection.g()).a("Id", appContentSection.h()).a("Subtitle", appContentSection.i()).a("Title", appContentSection.j()).a("Type", appContentSection.k()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAction> b() {
        return new ArrayList(this.b);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAnnotation> c() {
        return new ArrayList(this.k);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentCard> d() {
        return new ArrayList(this.c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String f() {
        return this.d;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public Bundle g() {
        return this.e;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String h() {
        return this.i;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String i() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String j() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String k() {
        return this.h;
    }

    public int l() {
        return this.f1307a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: m */
    public AppContentSection a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentSectionEntityCreator.a(this, parcel, i);
    }
}
