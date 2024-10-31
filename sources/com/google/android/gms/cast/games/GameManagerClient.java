package com.google.android.gms.cast.games;

import com.google.android.gms.common.api.Result;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class GameManagerClient {

    /* loaded from: classes.dex */
    public interface GameManagerInstanceResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface GameManagerResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface Listener {
        void a(GameManagerState gameManagerState, GameManagerState gameManagerState2);

        void a(String str, JSONObject jSONObject);
    }
}
