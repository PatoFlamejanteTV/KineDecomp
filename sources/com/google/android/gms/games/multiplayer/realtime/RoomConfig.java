package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class RoomConfig {

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    protected RoomConfig() {
    }

    public static Bundle a(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", i);
        bundle.putInt("max_automatch_players", i2);
        bundle.putLong("exclusive_bit_mask", j);
        return bundle;
    }
}
