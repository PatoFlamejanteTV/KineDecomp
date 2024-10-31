package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzl extends FirebaseUser {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    private zzcz f16533a;

    /* renamed from: b, reason: collision with root package name */
    private zzh f16534b;

    /* renamed from: c, reason: collision with root package name */
    private String f16535c;

    /* renamed from: d, reason: collision with root package name */
    private String f16536d;

    /* renamed from: e, reason: collision with root package name */
    private List<zzh> f16537e;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f16538f;

    /* renamed from: g, reason: collision with root package name */
    private String f16539g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f16540h;
    private zzn i;
    private boolean j;
    private com.google.firebase.auth.zzd k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 1) zzcz zzczVar, @SafeParcelable.Param(id = 2) zzh zzhVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) List<zzh> list, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Boolean bool, @SafeParcelable.Param(id = 9) zzn zznVar, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) com.google.firebase.auth.zzd zzdVar) {
        this.f16533a = zzczVar;
        this.f16534b = zzhVar;
        this.f16535c = str;
        this.f16536d = str2;
        this.f16537e = list;
        this.f16538f = list2;
        this.f16539g = str3;
        this.f16540h = bool;
        this.i = zznVar;
        this.j = z;
        this.k = zzdVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public Uri O() {
        return this.f16534b.a();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public List<? extends UserInfo> P() {
        return this.f16537e;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<String> Q() {
        return this.f16538f;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public String R() {
        return this.f16534b.O();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public boolean U() {
        GetTokenResult a2;
        Boolean bool = this.f16540h;
        if (bool == null || bool.booleanValue()) {
            zzcz zzczVar = this.f16533a;
            String str = "";
            if (zzczVar != null && (a2 = zzaa.a(zzczVar.zzdw())) != null) {
                str = a2.b();
            }
            boolean z = true;
            if (P().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.f16540h = Boolean.valueOf(z);
        }
        return this.f16540h.booleanValue();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp V() {
        return FirebaseApp.a(this.f16535c);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ FirebaseUser W() {
        this.f16540h = false;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzcz X() {
        return this.f16533a;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String Y() {
        return this.f16533a.zzdz();
    }

    public FirebaseUserMetadata Z() {
        return this.i;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUser a(List<? extends UserInfo> list) {
        Preconditions.a(list);
        this.f16537e = new ArrayList(list.size());
        this.f16538f = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = list.get(i);
            if (userInfo.getProviderId().equals("firebase")) {
                this.f16534b = (zzh) userInfo;
            } else {
                this.f16538f.add(userInfo.getProviderId());
            }
            this.f16537e.add((zzh) userInfo);
        }
        if (this.f16534b == null) {
            this.f16534b = this.f16537e.get(0);
        }
        return this;
    }

    public final List<zzh> aa() {
        return this.f16537e;
    }

    public final void b(boolean z) {
        this.j = z;
    }

    public final zzl e(String str) {
        this.f16539g = str;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public String getDisplayName() {
        return this.f16534b.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public String getEmail() {
        return this.f16534b.getEmail();
    }

    @Override // com.google.firebase.auth.UserInfo
    public String getProviderId() {
        return this.f16534b.getProviderId();
    }

    public final boolean isNewUser() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) X(), i, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.f16534b, i, false);
        SafeParcelWriter.a(parcel, 3, this.f16535c, false);
        SafeParcelWriter.a(parcel, 4, this.f16536d, false);
        SafeParcelWriter.d(parcel, 5, this.f16537e, false);
        SafeParcelWriter.c(parcel, 6, Q(), false);
        SafeParcelWriter.a(parcel, 7, this.f16539g, false);
        SafeParcelWriter.a(parcel, 8, Boolean.valueOf(U()), false);
        SafeParcelWriter.a(parcel, 9, (Parcelable) Z(), i, false);
        SafeParcelWriter.a(parcel, 10, this.j);
        SafeParcelWriter.a(parcel, 11, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzcf() {
        Map map;
        zzcz zzczVar = this.f16533a;
        if (zzczVar == null || zzczVar.zzdw() == null || (map = (Map) zzaa.a(this.f16533a.zzdw()).a().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzci() {
        return X().zzdw();
    }

    public final com.google.firebase.auth.zzd zzcv() {
        return this.k;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void a(zzcz zzczVar) {
        Preconditions.a(zzczVar);
        this.f16533a = zzczVar;
    }

    public zzl(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.a(firebaseApp);
        this.f16535c = firebaseApp.d();
        this.f16536d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f16539g = "2";
        a(list);
    }

    public final void a(zzn zznVar) {
        this.i = zznVar;
    }

    public final void a(com.google.firebase.auth.zzd zzdVar) {
        this.k = zzdVar;
    }
}
