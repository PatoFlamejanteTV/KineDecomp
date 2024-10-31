package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public static zzmn f805a = zzmp.zzqt();
    final int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Uri g;
    private String h;
    private long i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j) {
        this.b = i;
        this.c = zzx.a(str);
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j;
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, a());
            if (b() != null) {
                jSONObject.put("tokenId", b());
            }
            if (c() != null) {
                jSONObject.put("email", c());
            }
            if (d() != null) {
                jSONObject.put("displayName", d());
            }
            if (e() != null) {
                jSONObject.put("photoUrl", e().toString());
            }
            if (f() != null) {
                jSONObject.put("serverAuthCode", f());
            }
            jSONObject.put("expirationTime", this.i);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GoogleSignInAccount) {
            return ((GoogleSignInAccount) obj).h().equals(h());
        }
        return false;
    }

    public String f() {
        return this.h;
    }

    public long g() {
        return this.i;
    }

    public String h() {
        return i().toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
