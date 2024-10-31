package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzkt implements PlayerInfo {
    private final int zzWw;
    private final String zzYf;
    private final JSONObject zzYv;
    private final boolean zzYw;

    public zzkt(String str, int i, JSONObject jSONObject, boolean z) {
        this.zzYf = str;
        this.zzWw = i;
        this.zzYv = jSONObject;
        this.zzYw = z;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PlayerInfo)) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) obj;
        return this.zzYw == playerInfo.isControllable() && this.zzWw == playerInfo.getPlayerState() && com.google.android.gms.cast.internal.zzf.a(this.zzYf, playerInfo.getPlayerId()) && zzmu.zzd(this.zzYv, playerInfo.getPlayerData());
    }

    @Override // com.google.android.gms.cast.games.PlayerInfo
    public JSONObject getPlayerData() {
        return this.zzYv;
    }

    @Override // com.google.android.gms.cast.games.PlayerInfo
    public String getPlayerId() {
        return this.zzYf;
    }

    @Override // com.google.android.gms.cast.games.PlayerInfo
    public int getPlayerState() {
        return this.zzWw;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.zzYf, Integer.valueOf(this.zzWw), this.zzYv, Boolean.valueOf(this.zzYw));
    }

    @Override // com.google.android.gms.cast.games.PlayerInfo
    public boolean isConnected() {
        switch (this.zzWw) {
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.cast.games.PlayerInfo
    public boolean isControllable() {
        return this.zzYw;
    }
}
