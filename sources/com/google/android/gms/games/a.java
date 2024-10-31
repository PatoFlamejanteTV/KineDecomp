package com.google.android.gms.games;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends Games.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        super(null);
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Scope> zzm(Games.GamesOptions gamesOptions) {
        return Collections.singletonList(Games.b);
    }
}
