package com.google.android.gms.cast.games;

import java.util.Collection;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface GameManagerState {
    CharSequence getApplicationName();

    JSONObject getGameData();

    CharSequence getGameStatusText();

    int getGameplayState();

    int getLobbyState();

    int getMaxPlayers();

    PlayerInfo getPlayer(String str);

    Collection<PlayerInfo> getPlayers();
}
