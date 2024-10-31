package com.google.android.gms.games;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class b extends Games.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(null);
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Scope> zzm(Games.GamesOptions gamesOptions) {
        return Collections.singletonList(Games.d);
    }
}
