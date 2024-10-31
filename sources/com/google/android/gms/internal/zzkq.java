package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzkq {
    private static final com.google.android.gms.cast.internal.zzl zzVo = new com.google.android.gms.cast.internal.zzl("GameManagerMessage");
    protected final zzkp zzXM;
    protected final String zzYf;
    protected final long zzYg;
    protected final JSONObject zzYh;
    protected final int zzYl;
    protected final int zzYm;
    protected final String zzYn;
    protected final int zzYo;
    protected final int zzYp;
    protected final List<zzku> zzYq;
    protected final JSONObject zzYr;
    protected final String zzYs;
    protected final String zzYt;

    public zzkq(int i, int i2, String str, JSONObject jSONObject, int i3, int i4, List<zzku> list, JSONObject jSONObject2, String str2, String str3, long j, String str4, zzkp zzkpVar) {
        this.zzYl = i;
        this.zzYm = i2;
        this.zzYn = str;
        this.zzYh = jSONObject;
        this.zzYo = i3;
        this.zzYp = i4;
        this.zzYq = list;
        this.zzYr = jSONObject2;
        this.zzYs = str2;
        this.zzYf = str3;
        this.zzYg = j;
        this.zzYt = str4;
        this.zzXM = zzkpVar;
    }

    private static List<zzku> zza(JSONArray jSONArray) {
        zzku zzkuVar;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    zzkuVar = new zzku(optJSONObject);
                } catch (JSONException e) {
                    zzVo.b(e, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", Integer.valueOf(i));
                    zzkuVar = null;
                }
                if (zzkuVar != null) {
                    arrayList.add(zzkuVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkq zzh(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("type", -1);
        try {
        } catch (JSONException e) {
            zzVo.b(e, "Exception while parsing GameManagerMessage from json", new Object[0]);
        }
        switch (optInt) {
            case 1:
                JSONObject optJSONObject = jSONObject.optJSONObject("gameManagerConfig");
                return new zzkq(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray("players")), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), jSONObject.optLong("requestId"), jSONObject.optString("playerToken"), optJSONObject != null ? new zzkp(optJSONObject) : null);
            case 2:
                return new zzkq(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray("players")), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), -1L, null, null);
            default:
                zzVo.d("Unrecognized Game Message type %d", Integer.valueOf(optInt));
                return null;
        }
    }

    public final JSONObject getExtraMessageData() {
        return this.zzYh;
    }

    public final JSONObject getGameData() {
        return this.zzYr;
    }

    public final int getGameplayState() {
        return this.zzYo;
    }

    public final int getLobbyState() {
        return this.zzYp;
    }

    public final String getPlayerId() {
        return this.zzYf;
    }

    public final long getRequestId() {
        return this.zzYg;
    }

    public final int getStatusCode() {
        return this.zzYm;
    }

    public final int zzmI() {
        return this.zzYl;
    }

    public final String zzmJ() {
        return this.zzYn;
    }

    public final List<zzku> zzmK() {
        return this.zzYq;
    }

    public final String zzmL() {
        return this.zzYs;
    }

    public final String zzmM() {
        return this.zzYt;
    }

    public final zzkp zzmN() {
        return this.zzXM;
    }
}
