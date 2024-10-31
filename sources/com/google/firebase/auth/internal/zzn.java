package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzn implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();

    /* renamed from: a */
    private long f16541a;

    /* renamed from: b */
    private long f16542b;

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2) {
        this.f16541a = j;
        this.f16542b = j2;
    }

    public final long a() {
        return this.f16542b;
    }

    public final long b() {
        return this.f16541a;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f16541a);
            jSONObject.put("creationTimestamp", this.f16542b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, b());
        SafeParcelWriter.a(parcel, 2, a());
        SafeParcelWriter.a(parcel, a2);
    }

    public static zzn a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzn(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }
}
