package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

    /* renamed from: a */
    @VisibleForTesting
    private static Clock f10545a = DefaultClock.d();

    /* renamed from: b */
    private final int f10546b;

    /* renamed from: c */
    private String f10547c;

    /* renamed from: d */
    private String f10548d;

    /* renamed from: e */
    private String f10549e;

    /* renamed from: f */
    private String f10550f;

    /* renamed from: g */
    private Uri f10551g;

    /* renamed from: h */
    private String f10552h;
    private long i;
    private String j;
    private List<Scope> k;
    private String l;
    private String m;
    private Set<Scope> n = new HashSet();

    @SafeParcelable.Constructor
    public GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) String str7, @SafeParcelable.Param(id = 12) String str8) {
        this.f10546b = i;
        this.f10547c = str;
        this.f10548d = str2;
        this.f10549e = str3;
        this.f10550f = str4;
        this.f10551g = uri;
        this.f10552h = str5;
        this.i = j;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    private final JSONObject X() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (P() != null) {
                jSONObject.put("givenName", P());
            }
            if (O() != null) {
                jSONObject.put("familyName", O());
            }
            if (Q() != null) {
                jSONObject.put("photoUrl", Q().toString());
            }
            if (U() != null) {
                jSONObject.put("serverAuthCode", U());
            }
            jSONObject.put("expirationTime", this.i);
            jSONObject.put("obfuscatedIdentifier", this.j);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.k.toArray(new Scope[this.k.size()]);
            Arrays.sort(scopeArr, a.f10581a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(f10545a.a() / 1000) : l).longValue();
        Preconditions.b(str7);
        Preconditions.a(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public static GoogleSignInAccount e(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a2.f10552h = jSONObject.optString("serverAuthCode", null);
        return a2;
    }

    public String O() {
        return this.m;
    }

    public String P() {
        return this.l;
    }

    public Uri Q() {
        return this.f10551g;
    }

    @KeepForSdk
    public Set<Scope> R() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public String U() {
        return this.f10552h;
    }

    public final String V() {
        return this.j;
    }

    public final String W() {
        JSONObject X = X();
        X.remove("serverAuthCode");
        return X.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.j.equals(this.j) && googleSignInAccount.R().equals(R());
    }

    public String getDisplayName() {
        return this.f10550f;
    }

    public String getEmail() {
        return this.f10549e;
    }

    public String getId() {
        return this.f10547c;
    }

    public String getIdToken() {
        return this.f10548d;
    }

    public int hashCode() {
        return ((this.j.hashCode() + 527) * 31) + R().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10546b);
        SafeParcelWriter.a(parcel, 2, getId(), false);
        SafeParcelWriter.a(parcel, 3, getIdToken(), false);
        SafeParcelWriter.a(parcel, 4, getEmail(), false);
        SafeParcelWriter.a(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) Q(), i, false);
        SafeParcelWriter.a(parcel, 7, U(), false);
        SafeParcelWriter.a(parcel, 8, this.i);
        SafeParcelWriter.a(parcel, 9, this.j, false);
        SafeParcelWriter.d(parcel, 10, this.k, false);
        SafeParcelWriter.a(parcel, 11, P(), false);
        SafeParcelWriter.a(parcel, 12, O(), false);
        SafeParcelWriter.a(parcel, a2);
    }

    public Account a() {
        String str = this.f10549e;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }
}
