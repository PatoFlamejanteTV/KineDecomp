package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzks implements GameManagerState {
    private final String zzYi;
    private final int zzYj;
    private final int zzYo;
    private final int zzYp;
    private final JSONObject zzYr;
    private final String zzYs;
    private final Map<String, PlayerInfo> zzYu;

    public zzks(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzYp = i;
        this.zzYo = i2;
        this.zzYs = str;
        this.zzYr = jSONObject;
        this.zzYi = str2;
        this.zzYj = i3;
        this.zzYu = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzYu.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == null || !(obj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) obj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                if (!com.google.android.gms.cast.internal.zzf.a(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z = z2;
                } else {
                    if (!com.google.android.gms.cast.internal.zzf.a(playerInfo, playerInfo2)) {
                        return false;
                    }
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                return false;
            }
        }
        return this.zzYp == gameManagerState.getLobbyState() && this.zzYo == gameManagerState.getGameplayState() && this.zzYj == gameManagerState.getMaxPlayers() && com.google.android.gms.cast.internal.zzf.a(this.zzYi, gameManagerState.getApplicationName()) && com.google.android.gms.cast.internal.zzf.a(this.zzYs, gameManagerState.getGameStatusText()) && zzmu.zzd(this.zzYr, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getApplicationName() {
        return this.zzYi;
    }

    public List<PlayerInfo> getConnectedControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getConnectedPlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public JSONObject getGameData() {
        return this.zzYr;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getGameStatusText() {
        return this.zzYs;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getGameplayState() {
        return this.zzYo;
    }

    public Collection<String> getListOfChangedPlayers(GameManagerState gameManagerState) {
        HashSet hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = gameManagerState.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getLobbyState() {
        return this.zzYp;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getMaxPlayers() {
        return this.zzYj;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public PlayerInfo getPlayer(String str) {
        if (str == null) {
            return null;
        }
        return this.zzYu.get(str);
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzYu.values());
    }

    public List<PlayerInfo> getPlayersInState(int i) {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == i) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public boolean hasGameDataChanged(GameManagerState gameManagerState) {
        return !zzmu.zzd(this.zzYr, gameManagerState.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.a(this.zzYs, gameManagerState.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState gameManagerState) {
        return this.zzYo != gameManagerState.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState gameManagerState) {
        return this.zzYp != gameManagerState.getLobbyState();
    }

    public boolean hasPlayerChanged(String str, GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.a(getPlayer(str), gameManagerState.getPlayer(str));
    }

    public boolean hasPlayerDataChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || !zzmu.zzd(player.getPlayerData(), player2.getPlayerData());
    }

    public boolean hasPlayerStateChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(Integer.valueOf(this.zzYp), Integer.valueOf(this.zzYo), this.zzYu, this.zzYs, this.zzYr, this.zzYi, Integer.valueOf(this.zzYj));
    }
}
