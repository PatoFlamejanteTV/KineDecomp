package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1306a;
    private final String b;
    private final String c;
    private final String d;
    private final Bundle e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.f1306a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.f1306a = 1;
        this.b = appContentCondition.b();
        this.c = appContentCondition.c();
        this.d = appContentCondition.d();
        this.e = appContentCondition.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppContentCondition appContentCondition) {
        return zzw.a(appContentCondition.b(), appContentCondition.c(), appContentCondition.d(), appContentCondition.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.a(appContentCondition2.b(), appContentCondition.b()) && zzw.a(appContentCondition2.c(), appContentCondition.c()) && zzw.a(appContentCondition2.d(), appContentCondition.d()) && zzw.a(appContentCondition2.e(), appContentCondition.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppContentCondition appContentCondition) {
        return zzw.a(appContentCondition).a("DefaultValue", appContentCondition.b()).a("ExpectedValue", appContentCondition.c()).a("Predicate", appContentCondition.d()).a("PredicateParameters", appContentCondition.e()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public Bundle e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int f() {
        return this.f1306a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AppContentCondition a() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentConditionEntityCreator.a(this, parcel, i);
    }
}
