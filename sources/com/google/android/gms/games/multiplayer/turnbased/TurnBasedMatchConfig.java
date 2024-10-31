package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TurnBasedMatchConfig {

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        int f1392a = -1;
        ArrayList<String> b = new ArrayList<>();
        Bundle c = null;
        int d = 2;

        private Builder() {
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Bundle a(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", i);
        bundle.putInt("max_automatch_players", i2);
        bundle.putLong("exclusive_bit_mask", j);
        return bundle;
    }
}
