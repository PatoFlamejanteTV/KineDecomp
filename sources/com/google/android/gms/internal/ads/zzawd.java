package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@zzark
/* loaded from: classes2.dex */
public final class zzawd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawd> CREATOR = new zzawe();
    public final String type;
    public final int zzefo;

    public zzawd(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public static zzawd zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzawd(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public static zzawd zzdh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzawd)) {
            zzawd zzawdVar = (zzawd) obj;
            if (Objects.a(this.type, zzawdVar.type) && Objects.a(Integer.valueOf(this.zzefo), Integer.valueOf(zzawdVar.zzefo))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(this.type, Integer.valueOf(this.zzefo));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.type, false);
        SafeParcelWriter.a(parcel, 3, this.zzefo);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzawd(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i) {
        this.type = str;
        this.zzefo = i;
    }
}
