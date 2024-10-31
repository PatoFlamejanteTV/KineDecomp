package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f816a;
    String b;
    String c;
    String d;
    String e;
    String f;
    List<String> g;
    public FACLData h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        this.f816a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = list;
        this.h = fACLData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
