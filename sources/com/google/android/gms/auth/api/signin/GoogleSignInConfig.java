package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class GoogleSignInConfig implements Api.ApiOptions.Optional, SafeParcelable {
    final int e;
    private final ArrayList<Scope> f;
    private Account g;
    private boolean h;
    private final boolean i;
    private final boolean j;
    private String k;

    /* renamed from: a, reason: collision with root package name */
    public static final Scope f806a = new Scope("profile");
    public static final Scope b = new Scope("email");
    public static final Scope c = new Scope("openid");
    public static final GoogleSignInConfig d = new zza().a();
    public static final Parcelable.Creator<GoogleSignInConfig> CREATOR = new zze();

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private Set<Scope> f807a = new HashSet(Arrays.asList(GoogleSignInConfig.c));
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;

        public GoogleSignInConfig a() {
            return new GoogleSignInConfig(this.f807a, this.f, this.d, this.b, this.c, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInConfig(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str) {
        this.e = i;
        this.f = arrayList;
        this.g = account;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = str;
    }

    private GoogleSignInConfig(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str) {
        this(1, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str);
    }

    public ArrayList<Scope> a() {
        return new ArrayList<>(this.f);
    }

    public Account b() {
        return this.g;
    }

    public boolean c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInConfig googleSignInConfig = (GoogleSignInConfig) obj;
            if (this.f.size() != googleSignInConfig.a().size() || !this.f.containsAll(googleSignInConfig.a())) {
                return false;
            }
            if (this.g == null) {
                if (googleSignInConfig.b() != null) {
                    return false;
                }
            } else if (!this.g.equals(googleSignInConfig.b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.k)) {
                if (!TextUtils.isEmpty(googleSignInConfig.f())) {
                    return false;
                }
            } else if (!this.k.equals(googleSignInConfig.f())) {
                return false;
            }
            if (this.j == googleSignInConfig.e() && this.h == googleSignInConfig.c()) {
                return this.i == googleSignInConfig.d();
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String f() {
        return this.k;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        Collections.sort(arrayList);
        return new com.google.android.gms.auth.api.signin.internal.zzc().a(arrayList).a(this.g).a(this.k).a(this.j).a(this.h).a(this.i).a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
