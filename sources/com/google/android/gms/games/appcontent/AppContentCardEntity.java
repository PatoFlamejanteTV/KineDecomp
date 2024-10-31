package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1305a;
    private final ArrayList<AppContentActionEntity> b;
    private final ArrayList<AppContentAnnotationEntity> c;
    private final ArrayList<AppContentConditionEntity> d;
    private final String e;
    private final int f;
    private final String g;
    private final Bundle h;
    private final String i;
    private final String j;
    private final int k;
    private final String l;
    private final String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.f1305a = i;
        this.b = arrayList;
        this.c = arrayList2;
        this.d = arrayList3;
        this.e = str;
        this.f = i2;
        this.g = str2;
        this.h = bundle;
        this.m = str6;
        this.i = str3;
        this.j = str4;
        this.k = i3;
        this.l = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        this.f1305a = 4;
        this.e = appContentCard.e();
        this.f = appContentCard.f();
        this.g = appContentCard.g();
        this.h = appContentCard.h();
        this.m = appContentCard.i();
        this.j = appContentCard.k();
        this.i = appContentCard.j();
        this.k = appContentCard.l();
        this.l = appContentCard.m();
        List<AppContentAction> b = appContentCard.b();
        int size = b.size();
        this.b = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.b.add((AppContentActionEntity) b.get(i).a());
        }
        List<AppContentAnnotation> c = appContentCard.c();
        int size2 = c.size();
        this.c = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.c.add((AppContentAnnotationEntity) c.get(i2).a());
        }
        List<AppContentCondition> d = appContentCard.d();
        int size3 = d.size();
        this.d = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.d.add((AppContentConditionEntity) d.get(i3).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppContentCard appContentCard) {
        return zzw.a(appContentCard.b(), appContentCard.c(), appContentCard.d(), appContentCard.e(), Integer.valueOf(appContentCard.f()), appContentCard.g(), appContentCard.h(), appContentCard.i(), appContentCard.j(), appContentCard.k(), Integer.valueOf(appContentCard.l()), appContentCard.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.a(appContentCard2.b(), appContentCard.b()) && zzw.a(appContentCard2.c(), appContentCard.c()) && zzw.a(appContentCard2.d(), appContentCard.d()) && zzw.a(appContentCard2.e(), appContentCard.e()) && zzw.a(Integer.valueOf(appContentCard2.f()), Integer.valueOf(appContentCard.f())) && zzw.a(appContentCard2.g(), appContentCard.g()) && zzw.a(appContentCard2.h(), appContentCard.h()) && zzw.a(appContentCard2.i(), appContentCard.i()) && zzw.a(appContentCard2.j(), appContentCard.j()) && zzw.a(appContentCard2.k(), appContentCard.k()) && zzw.a(Integer.valueOf(appContentCard2.l()), Integer.valueOf(appContentCard.l())) && zzw.a(appContentCard2.m(), appContentCard.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppContentCard appContentCard) {
        return zzw.a(appContentCard).a("Actions", appContentCard.b()).a("Annotations", appContentCard.c()).a("Conditions", appContentCard.d()).a("ContentDescription", appContentCard.e()).a("CurrentSteps", Integer.valueOf(appContentCard.f())).a("Description", appContentCard.g()).a("Extras", appContentCard.h()).a("Id", appContentCard.i()).a("Subtitle", appContentCard.j()).a("Title", appContentCard.k()).a("TotalSteps", Integer.valueOf(appContentCard.l())).a("Type", appContentCard.m()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAction> b() {
        return new ArrayList(this.b);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAnnotation> c() {
        return new ArrayList(this.c);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentCondition> d() {
        return new ArrayList(this.d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public Bundle h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String i() {
        return this.m;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String j() {
        return this.i;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String k() {
        return this.j;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int l() {
        return this.k;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String m() {
        return this.l;
    }

    public int n() {
        return this.f1305a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AppContentCard a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentCardEntityCreator.a(this, parcel, i);
    }
}
