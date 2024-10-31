package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1308a;
    private final String b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentTupleEntity(int i, String str, String str2) {
        this.f1308a = i;
        this.b = str;
        this.c = str2;
    }

    public AppContentTupleEntity(AppContentTuple appContentTuple) {
        this.f1308a = 1;
        this.b = appContentTuple.b();
        this.c = appContentTuple.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppContentTuple appContentTuple) {
        return zzw.a(appContentTuple.b(), appContentTuple.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return zzw.a(appContentTuple2.b(), appContentTuple.b()) && zzw.a(appContentTuple2.c(), appContentTuple.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppContentTuple appContentTuple) {
        return zzw.a(appContentTuple).a("Name", appContentTuple.b()).a("Value", appContentTuple.c()).toString();
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String c() {
        return this.c;
    }

    public int d() {
        return this.f1308a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AppContentTuple a() {
        return this;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentTupleEntityCreator.a(this, parcel, i);
    }
}
