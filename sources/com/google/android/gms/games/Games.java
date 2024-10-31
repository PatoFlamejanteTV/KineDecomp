package com.google.android.gms.games;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.internal.zzlb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Games {

    /* renamed from: a */
    static final Api.zzc<GamesClientImpl> f1296a = new Api.zzc<>();
    private static final Api.zza<GamesClientImpl, GamesOptions> v = new com.google.android.gms.games.a();
    private static final Api.zza<GamesClientImpl, GamesOptions> w = new b();
    public static final Scope b = new Scope("https://www.googleapis.com/auth/games");
    public static final Api<GamesOptions> c = new Api<>("Games.API", v, f1296a);
    public static final Scope d = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> e = new Api<>("Games.API_1P", w, f1296a);
    public static final GamesMetadata f = new GamesMetadataImpl();
    public static final Achievements g = new AchievementsImpl();
    public static final AppContents h = new AppContentsImpl();
    public static final Events i = new EventsImpl();
    public static final Leaderboards j = new LeaderboardsImpl();
    public static final Invitations k = new InvitationsImpl();
    public static final TurnBasedMultiplayer l = new TurnBasedMultiplayerImpl();
    public static final RealTimeMultiplayer m = new RealTimeMultiplayerImpl();
    public static final Multiplayer n = new MultiplayerImpl();
    public static final Players o = new PlayersImpl();
    public static final Notifications p = new NotificationsImpl();
    public static final Quests q = new QuestsImpl();
    public static final Requests r = new RequestsImpl();
    public static final Snapshots s = new SnapshotsImpl();
    public static final Stats t = new StatsImpl();
    public static final Acls u = new AclsImpl();

    /* loaded from: classes.dex */
    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zzlb.zza<R, GamesClientImpl> {
    }

    /* loaded from: classes.dex */
    public static final class GamesOptions implements Api.ApiOptions.Optional {

        /* renamed from: a */
        public final boolean f1297a;
        public final boolean b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        public final ArrayList<String> g;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            boolean f1298a = false;
            boolean b = true;
            int c = 17;
            boolean d = false;
            int e = 4368;
            String f = null;
            ArrayList<String> g = new ArrayList<>();

            private Builder() {
            }
        }

        private GamesOptions() {
            this.f1297a = false;
            this.b = true;
            this.c = 17;
            this.d = false;
            this.e = 4368;
            this.f = null;
            this.g = new ArrayList<>();
        }

        /* synthetic */ GamesOptions(com.google.android.gms.games.a aVar) {
            this();
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.f1297a);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.b);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.c);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.d);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.e);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.f);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.g);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a extends Api.zza<GamesClientImpl, GamesOptions> {
        private a() {
        }

        public /* synthetic */ a(com.google.android.gms.games.a aVar) {
            this();
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: a */
        public GamesClientImpl zza(Context context, Looper looper, zzf zzfVar, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, zzfVar, gamesOptions == null ? new GamesOptions(null) : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return 1;
        }
    }

    private Games() {
    }
}
