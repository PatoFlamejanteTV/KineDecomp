package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1303a;
    private final ArrayList<AppContentConditionEntity> b;
    private final String c;
    private final Bundle d;
    private final String e;
    private final String f;
    private final AppContentAnnotationEntity g;
    private final String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentActionEntity(int i, ArrayList<AppContentConditionEntity> arrayList, String str, Bundle bundle, String str2, String str3, AppContentAnnotationEntity appContentAnnotationEntity, String str4) {
        this.f1303a = i;
        this.g = appContentAnnotationEntity;
        this.b = arrayList;
        this.c = str;
        this.d = bundle;
        this.f = str3;
        this.h = str4;
        this.e = str2;
    }

    public AppContentActionEntity(AppContentAction appContentAction) {
        this.f1303a = 5;
        this.g = (AppContentAnnotationEntity) appContentAction.b().a();
        this.c = appContentAction.d();
        this.d = appContentAction.e();
        this.f = appContentAction.f();
        this.h = appContentAction.g();
        this.e = appContentAction.h();
        List<AppContentCondition> c = appContentAction.c();
        int size = c.size();
        this.b = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.b.add((AppContentConditionEntity) c.get(i).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppContentAction appContentAction) {
        return zzw.a(appContentAction.b(), appContentAction.c(), appContentAction.d(), appContentAction.e(), appContentAction.f(), appContentAction.g(), appContentAction.h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.a(appContentAction2.b(), appContentAction.b()) && zzw.a(appContentAction2.c(), appContentAction.c()) && zzw.a(appContentAction2.d(), appContentAction.d()) && zzw.a(appContentAction2.e(), appContentAction.e()) && zzw.a(appContentAction2.f(), appContentAction.f()) && zzw.a(appContentAction2.g(), appContentAction.g()) && zzw.a(appContentAction2.h(), appContentAction.h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppContentAction appContentAction) {
        return zzw.a(appContentAction).a("Annotation", appContentAction.b()).a("Conditions", appContentAction.c()).a("ContentDescription", appContentAction.d()).a("Extras", appContentAction.e()).a("Id", appContentAction.f()).a("OverflowText", appContentAction.g()).a("Type", appContentAction.h()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public AppContentAnnotation b() {
        return this.g;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public List<AppContentCondition> c() {
        return new ArrayList(this.b);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public Bundle e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String g() {
        return this.h;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String h() {
        return this.e;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.f1303a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public AppContentAction a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentActionEntityCreator.a(this, parcel, i);
    }
}
