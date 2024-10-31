package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzh extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* renamed from: a */
    private String f16525a;

    /* renamed from: b */
    private String f16526b;

    /* renamed from: c */
    private String f16527c;

    /* renamed from: d */
    private String f16528d;

    /* renamed from: e */
    private Uri f16529e;

    /* renamed from: f */
    private String f16530f;

    /* renamed from: g */
    private String f16531g;

    /* renamed from: h */
    private boolean f16532h;
    private String i;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 3) String str5, @SafeParcelable.Param(id = 6) String str6, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) String str7) {
        this.f16525a = str;
        this.f16526b = str2;
        this.f16530f = str3;
        this.f16531g = str4;
        this.f16527c = str5;
        this.f16528d = str6;
        if (!TextUtils.isEmpty(this.f16528d)) {
            this.f16529e = Uri.parse(this.f16528d);
        }
        this.f16532h = z;
        this.i = str7;
    }

    public static zzh e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzh(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaf(e2);
        }
    }

    public final String O() {
        return this.f16525a;
    }

    public final Uri a() {
        if (!TextUtils.isEmpty(this.f16528d) && this.f16529e == null) {
            this.f16529e = Uri.parse(this.f16528d);
        }
        return this.f16529e;
    }

    public final String getDisplayName() {
        return this.f16527c;
    }

    public final String getEmail() {
        return this.f16530f;
    }

    public final String getPhoneNumber() {
        return this.f16531g;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.f16526b;
    }

    public final String getRawUserInfo() {
        return this.i;
    }

    public final boolean isEmailVerified() {
        return this.f16532h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, O(), false);
        SafeParcelWriter.a(parcel, 2, getProviderId(), false);
        SafeParcelWriter.a(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.a(parcel, 4, this.f16528d, false);
        SafeParcelWriter.a(parcel, 5, getEmail(), false);
        SafeParcelWriter.a(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.a(parcel, 7, isEmailVerified());
        SafeParcelWriter.a(parcel, 8, this.i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzdz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f16525a);
            jSONObject.putOpt("providerId", this.f16526b);
            jSONObject.putOpt("displayName", this.f16527c);
            jSONObject.putOpt("photoUrl", this.f16528d);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EMAIL, this.f16530f);
            jSONObject.putOpt("phoneNumber", this.f16531g);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f16532h));
            jSONObject.putOpt("rawUserInfo", this.i);
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaf(e2);
        }
    }

    public zzh(zzct zzctVar, String str) {
        Preconditions.a(zzctVar);
        Preconditions.b(str);
        String localId = zzctVar.getLocalId();
        Preconditions.b(localId);
        this.f16525a = localId;
        this.f16526b = str;
        this.f16530f = zzctVar.getEmail();
        this.f16527c = zzctVar.getDisplayName();
        Uri photoUri = zzctVar.getPhotoUri();
        if (photoUri != null) {
            this.f16528d = photoUri.toString();
            this.f16529e = photoUri;
        }
        this.f16532h = zzctVar.isEmailVerified();
        this.i = null;
        this.f16531g = zzctVar.getPhoneNumber();
    }

    public zzh(zzdb zzdbVar) {
        Preconditions.a(zzdbVar);
        this.f16525a = zzdbVar.zzbg();
        String providerId = zzdbVar.getProviderId();
        Preconditions.b(providerId);
        this.f16526b = providerId;
        this.f16527c = zzdbVar.getDisplayName();
        Uri photoUri = zzdbVar.getPhotoUri();
        if (photoUri != null) {
            this.f16528d = photoUri.toString();
            this.f16529e = photoUri;
        }
        this.f16530f = zzdbVar.getEmail();
        this.f16531g = zzdbVar.getPhoneNumber();
        this.f16532h = false;
        this.i = zzdbVar.getRawUserInfo();
    }
}
