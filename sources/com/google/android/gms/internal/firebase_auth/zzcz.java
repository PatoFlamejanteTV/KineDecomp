package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzjm;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcz extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdw<zzcz, zzjm.zzb> {
    public static final Parcelable.Creator<zzcz> CREATOR = new zzda();
    private String zzgd;
    private String zzid;
    private Long zzph;
    private String zzpi;
    private Long zzpj;

    public zzcz() {
        this.zzpj = Long.valueOf(System.currentTimeMillis());
    }

    public static zzcz zzcf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzcz zzczVar = new zzcz();
            zzczVar.zzid = jSONObject.optString("refresh_token", null);
            zzczVar.zzgd = jSONObject.optString("access_token", null);
            zzczVar.zzph = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY));
            zzczVar.zzpi = jSONObject.optString("token_type", null);
            zzczVar.zzpj = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzczVar;
        } catch (JSONException e2) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new zzaf(e2);
        }
    }

    public final boolean isValid() {
        return DefaultClock.d().a() + 300000 < this.zzpj.longValue() + (this.zzph.longValue() * 1000);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzid, false);
        SafeParcelWriter.a(parcel, 3, this.zzgd, false);
        SafeParcelWriter.a(parcel, 4, Long.valueOf(zzs()), false);
        SafeParcelWriter.a(parcel, 5, this.zzpi, false);
        SafeParcelWriter.a(parcel, 6, Long.valueOf(this.zzpj.longValue()), false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdw zza(zzhc zzhcVar) {
        if (zzhcVar instanceof zzjm.zzb) {
            zzjm.zzb zzbVar = (zzjm.zzb) zzhcVar;
            this.zzid = Strings.a(zzbVar.zzr());
            this.zzgd = Strings.a(zzbVar.zzdw());
            this.zzph = Long.valueOf(zzbVar.zzs());
            this.zzpi = Strings.a(zzbVar.zzdx());
            this.zzpj = Long.valueOf(System.currentTimeMillis());
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GrantTokenResponse.");
    }

    public final void zzce(String str) {
        Preconditions.b(str);
        this.zzid = str;
    }

    public final zzhm<zzjm.zzb> zzdj() {
        return zzjm.zzb.zzl();
    }

    public final String zzdw() {
        return this.zzgd;
    }

    public final String zzdx() {
        return this.zzpi;
    }

    public final long zzdy() {
        return this.zzpj.longValue();
    }

    public final String zzdz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzid);
            jSONObject.put("access_token", this.zzgd);
            jSONObject.put(AccessToken.EXPIRES_IN_KEY, this.zzph);
            jSONObject.put("token_type", this.zzpi);
            jSONObject.put("issued_at", this.zzpj);
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new zzaf(e2);
        }
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        Long l = this.zzph;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public zzcz(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    @SafeParcelable.Constructor
    public zzcz(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) Long l2) {
        this.zzid = str;
        this.zzgd = str2;
        this.zzph = l;
        this.zzpi = str3;
        this.zzpj = l2;
    }
}
