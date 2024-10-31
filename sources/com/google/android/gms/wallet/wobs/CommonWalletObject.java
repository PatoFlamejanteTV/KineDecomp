package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CommonWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new com.google.android.gms.wallet.wobs.zza();

    /* renamed from: a, reason: collision with root package name */
    String f2314a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    int i;
    ArrayList<WalletObjectMessage> j;
    TimeInterval k;
    ArrayList<LatLng> l;
    String m;
    String n;
    ArrayList<LabelValueRow> o;
    boolean p;
    ArrayList<UriData> q;
    ArrayList<TextModuleData> r;
    ArrayList<UriData> s;
    private final int t;

    /* loaded from: classes.dex */
    public final class zza {
        private zza() {
        }

        public zza a(String str) {
            CommonWalletObject.this.f2314a = str;
            return this;
        }

        public CommonWalletObject a() {
            return CommonWalletObject.this;
        }
    }

    CommonWalletObject() {
        this.t = 1;
        this.j = zzmj.zzqs();
        this.l = zzmj.zzqs();
        this.o = zzmj.zzqs();
        this.q = zzmj.zzqs();
        this.r = zzmj.zzqs();
        this.s = zzmj.zzqs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, ArrayList<WalletObjectMessage> arrayList, TimeInterval timeInterval, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<LabelValueRow> arrayList3, boolean z, ArrayList<UriData> arrayList4, ArrayList<TextModuleData> arrayList5, ArrayList<UriData> arrayList6) {
        this.t = i;
        this.f2314a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = i2;
        this.j = arrayList;
        this.k = timeInterval;
        this.l = arrayList2;
        this.m = str9;
        this.n = str10;
        this.o = arrayList3;
        this.p = z;
        this.q = arrayList4;
        this.r = arrayList5;
        this.s = arrayList6;
    }

    public static zza a() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int b() {
        return this.t;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.wallet.wobs.zza.a(this, parcel, i);
    }
}
