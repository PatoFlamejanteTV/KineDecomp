package com.google.android.gms.ads.internal.gmsg;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes.dex */
public final class zza implements zzu<Object> {

    /* renamed from: a */
    private final zzb f10057a;

    public zza(zzb zzbVar) {
        this.f10057a = zzbVar;
    }

    private static Bundle a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Bundle bundle = new Bundle();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj != null) {
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(next, ((Double) obj).doubleValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(next, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(next, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(next, (String) obj);
                    } else {
                        String valueOf = String.valueOf(next);
                        zzbbd.zzeo(valueOf.length() != 0 ? "Unsupported type for key:".concat(valueOf) : new String("Unsupported type for key:"));
                    }
                }
            }
            return bundle;
        } catch (JSONException e2) {
            zzbbd.zzb("Failed to convert ad metadata to JSON.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        if (this.f10057a == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            zzbbd.zzen("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle a2 = a(map.get("info"));
        if (a2 == null) {
            zzbbd.e("Failed to convert ad metadata to Bundle.");
        } else {
            this.f10057a.zza(str, a2);
        }
    }
}
