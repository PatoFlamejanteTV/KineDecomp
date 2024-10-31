package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzku {
    private final int zzWw;
    private final String zzYf;
    private final JSONObject zzYv;

    public zzku(String str, int i, JSONObject jSONObject) {
        this.zzYf = str;
        this.zzWw = i;
        this.zzYv = jSONObject;
    }

    public zzku(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzku)) {
            return false;
        }
        zzku zzkuVar = (zzku) obj;
        return this.zzWw == zzkuVar.getPlayerState() && com.google.android.gms.cast.internal.zzf.a(this.zzYf, zzkuVar.getPlayerId()) && zzmu.zzd(this.zzYv, zzkuVar.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzYv;
    }

    public String getPlayerId() {
        return this.zzYf;
    }

    public int getPlayerState() {
        return this.zzWw;
    }
}
