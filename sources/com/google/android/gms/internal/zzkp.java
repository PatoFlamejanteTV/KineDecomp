package com.google.android.gms.internal;

import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzkp {
    private final String zzYi;
    private final int zzYj;
    private final String zzYk;

    public zzkp(String str, int i, String str2) {
        this.zzYi = str;
        this.zzYj = i;
        this.zzYk = str2;
    }

    public zzkp(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("applicationName"), jSONObject.optInt("maxPlayers"), jSONObject.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
    }

    public final int getMaxPlayers() {
        return this.zzYj;
    }

    public final String getVersion() {
        return this.zzYk;
    }

    public final String zzmH() {
        return this.zzYi;
    }
}
