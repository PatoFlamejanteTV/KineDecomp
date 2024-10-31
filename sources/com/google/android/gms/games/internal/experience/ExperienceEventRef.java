package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

/* loaded from: classes.dex */
public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef c;

    public ExperienceEventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        if (i("external_game_id")) {
            this.c = null;
        } else {
            this.c = new GameRef(this.a_, this.b_);
        }
    }
}
