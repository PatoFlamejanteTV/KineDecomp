package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzawo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawo> CREATOR = new zzawp();
    public final String zzegh;
    public final String zzegi;
    public final boolean zzegj;
    public final boolean zzegk;
    public final List<String> zzegl;
    public final boolean zzegm;
    public final boolean zzegn;
    public final List<String> zzego;

    @SafeParcelable.Constructor
    public zzawo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zzegh = str;
        this.zzegi = str2;
        this.zzegj = z;
        this.zzegk = z2;
        this.zzegl = list;
        this.zzegm = z3;
        this.zzegn = z4;
        this.zzego = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzawo zzo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzawo(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbac.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbac.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzegh, false);
        SafeParcelWriter.a(parcel, 3, this.zzegi, false);
        SafeParcelWriter.a(parcel, 4, this.zzegj);
        SafeParcelWriter.a(parcel, 5, this.zzegk);
        SafeParcelWriter.c(parcel, 6, this.zzegl, false);
        SafeParcelWriter.a(parcel, 7, this.zzegm);
        SafeParcelWriter.a(parcel, 8, this.zzegn);
        SafeParcelWriter.c(parcel, 9, this.zzego, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
