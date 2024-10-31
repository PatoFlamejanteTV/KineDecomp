package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzko extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = com.google.android.gms.cast.internal.zzf.b("com.google.cast.games");
    private static final com.google.android.gms.cast.internal.zzl zzVo = new com.google.android.gms.cast.internal.zzl("GameManagerChannel");
    private final Map<String, String> zzXH;
    private final List<com.google.android.gms.cast.internal.zzp> zzXI;
    private final String zzXJ;
    private final Cast.CastApi zzXK;
    private final GoogleApiClient zzXL;
    private zzkp zzXM;
    private boolean zzXN;
    private GameManagerState zzXO;
    private GameManagerState zzXP;
    private String zzXQ;
    private JSONObject zzXR;
    private long zzXS;
    private GameManagerClient.Listener zzXT;
    private String zzXU;
    private final SharedPreferences zzuj;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements GameManagerClient.GameManagerInstanceResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1744a;
        private final GameManagerClient b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Status status, GameManagerClient gameManagerClient) {
            this.f1744a = status;
            this.b = gameManagerClient;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1744a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements GameManagerClient.GameManagerResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1745a;
        private final String b;
        private final long c;
        private final JSONObject d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Status status, String str, long j, JSONObject jSONObject) {
            this.f1745a = status;
            this.b = str;
            this.c = j;
            this.d = jSONObject;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1745a;
        }
    }

    /* loaded from: classes.dex */
    public abstract class zza extends zzb<GameManagerClient.GameManagerResult> {
        public zza() {
            super();
            this.zzXu = new fe(this, zzko.this);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public GameManagerClient.GameManagerResult zzb(Status status) {
            return new b(status, null, -1L, null);
        }
    }

    /* loaded from: classes.dex */
    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected com.google.android.gms.cast.internal.zzo zzXu;

        public zzb() {
            super(zzko.this.zzXL);
        }

        public abstract void execute();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        public void zza(com.google.android.gms.cast.internal.zze zzeVar) {
            execute();
        }

        public com.google.android.gms.cast.internal.zzo zzmG() {
            return this.zzXu;
        }
    }

    /* loaded from: classes.dex */
    public abstract class zzc extends zzb<GameManagerClient.GameManagerInstanceResult> {
        private GameManagerClient zzYd;

        public zzc(GameManagerClient gameManagerClient) {
            super();
            this.zzYd = gameManagerClient;
            this.zzXu = new ff(this, zzko.this);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public GameManagerClient.GameManagerInstanceResult zzb(Status status) {
            return new a(status, null);
        }
    }

    public zzko(GoogleApiClient googleApiClient, String str, Cast.CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        this.zzXH = new ConcurrentHashMap();
        this.zzXN = false;
        this.zzXS = 0L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        }
        if (googleApiClient == null || !googleApiClient.isConnected() || !googleApiClient.hasConnectedApi(Cast.f818a)) {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        }
        this.zzXI = new ArrayList();
        this.zzXJ = str;
        this.zzXK = castApi;
        this.zzXL = googleApiClient;
        Context applicationContext = googleApiClient.getContext().getApplicationContext();
        this.zzuj = applicationContext.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", applicationContext.getPackageName(), "game_manager_channel_data"), 0);
        this.zzXP = null;
        this.zzXO = new zzks(0, 0, "", null, new ArrayList(), "", -1);
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzbJ(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzVo.d("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzkq zzkqVar) {
        synchronized (this) {
            boolean z = zzkqVar.zzmI() == 1;
            this.zzXP = this.zzXO;
            if (z && zzkqVar.zzmN() != null) {
                this.zzXM = zzkqVar.zzmN();
            }
            if (isInitialized()) {
                ArrayList arrayList = new ArrayList();
                for (zzku zzkuVar : zzkqVar.zzmK()) {
                    String playerId = zzkuVar.getPlayerId();
                    arrayList.add(new zzkt(playerId, zzkuVar.getPlayerState(), zzkuVar.getPlayerData(), this.zzXH.containsKey(playerId)));
                }
                this.zzXO = new zzks(zzkqVar.getLobbyState(), zzkqVar.getGameplayState(), zzkqVar.zzmL(), zzkqVar.getGameData(), arrayList, this.zzXM.zzmH(), this.zzXM.getMaxPlayers());
                PlayerInfo player = this.zzXO.getPlayer(zzkqVar.getPlayerId());
                if (player != null && player.isControllable() && zzkqVar.zzmI() == 2) {
                    this.zzXQ = zzkqVar.getPlayerId();
                    this.zzXR = zzkqVar.getExtraMessageData();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, int i, JSONObject jSONObject, com.google.android.gms.cast.internal.zzo zzoVar) {
        long j = 1 + this.zzXS;
        this.zzXS = j;
        JSONObject zza2 = zza(j, str, i, jSONObject);
        if (zza2 == null) {
            zzoVar.a(-1L, 2001, null);
            zzVo.d("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        com.google.android.gms.cast.internal.zzp zzpVar = new com.google.android.gms.cast.internal.zzp(30000L);
        zzpVar.a(j, zzoVar);
        this.zzXI.add(zzpVar);
        zzV(true);
        this.zzXK.a(this.zzXL, getNamespace(), zza2.toString()).setResultCallback(new fd(this, j));
    }

    private int zzaX(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return 2003;
            case 3:
                return 2150;
            case 4:
                return 2151;
            default:
                zzVo.d("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zzb(long j, int i, Object obj) {
        Iterator<com.google.android.gms.cast.internal.zzp> it = this.zzXI.iterator();
        while (it.hasNext()) {
            if (it.next().a(j, i, obj)) {
                it.remove();
            }
        }
    }

    private synchronized void zzmB() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        }
        if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zzmC() {
        if (this.zzXT != null) {
            if (this.zzXP != null && !this.zzXO.equals(this.zzXP)) {
                this.zzXT.a(this.zzXO, this.zzXP);
            }
            if (this.zzXR != null && this.zzXQ != null) {
                this.zzXT.a(this.zzXQ, this.zzXR);
            }
        }
        this.zzXP = null;
        this.zzXQ = null;
        this.zzXR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzmD() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzXJ);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzXH));
            this.zzuj.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzVo.d("Error while saving data: %s", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzmE() {
        String string = this.zzuj.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzXJ.equals(jSONObject.getString("castSessionId"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("playerTokenMap");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.zzXH.put(next, jSONObject2.getString(next));
                    }
                    this.zzXS = 0L;
                }
            } catch (JSONException e) {
                zzVo.d("Error while loading data: %s", e.getMessage());
            }
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzXN) {
            this.zzXO = null;
            this.zzXP = null;
            this.zzXQ = null;
            this.zzXR = null;
            this.zzXN = true;
            try {
                this.zzXK.a(this.zzXL, getNamespace());
            } catch (IOException e) {
                zzVo.d("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zzmB();
        return this.zzXO;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zzmB();
        return this.zzXU;
    }

    public synchronized boolean isDisposed() {
        return this.zzXN;
    }

    public synchronized boolean isInitialized() {
        return this.zzXM != null;
    }

    public synchronized void sendGameMessage(String str, JSONObject jSONObject) throws IllegalStateException {
        zzmB();
        long j = 1 + this.zzXS;
        this.zzXS = j;
        JSONObject zza2 = zza(j, str, 7, jSONObject);
        if (zza2 != null) {
            this.zzXK.a(this.zzXL, getNamespace(), zza2.toString());
        }
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> sendGameRequest(String str, JSONObject jSONObject) throws IllegalStateException {
        zzmB();
        return this.zzXL.zzb(new fc(this, str, jSONObject));
    }

    public synchronized void setListener(GameManagerClient.Listener listener) {
        this.zzXT = listener;
    }

    public synchronized PendingResult<GameManagerClient.GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzXL.zzb(new ez(this, gameManagerClient));
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        zzmB();
        return this.zzXL.zzb(new fb(this, i, str, jSONObject));
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzbJ(String str) throws IllegalStateException {
        return str == null ? null : this.zzXH.get(str);
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzbK(String str) {
        zzVo.b("message received: %s", str);
        try {
            zzkq zzh = zzkq.zzh(new JSONObject(str));
            if (zzh == null) {
                zzVo.d("Could not parse game manager message from string: %s", str);
                return;
            }
            if ((isInitialized() || zzh.zzmN() != null) && !isDisposed()) {
                boolean z = zzh.zzmI() == 1;
                if (z && !TextUtils.isEmpty(zzh.zzmM())) {
                    this.zzXH.put(zzh.getPlayerId(), zzh.zzmM());
                    zzmD();
                }
                if (zzh.getStatusCode() == 0) {
                    zza(zzh);
                } else {
                    zzVo.d("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzh.getStatusCode()));
                }
                int zzaX = zzaX(zzh.getStatusCode());
                if (z) {
                    zzb(zzh.getRequestId(), zzaX, zzh);
                }
                if (isInitialized() && zzaX == 0) {
                    zzmC();
                }
            }
        } catch (JSONException e) {
            zzVo.d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzc
    protected boolean zzz(long j) {
        boolean z;
        Iterator<com.google.android.gms.cast.internal.zzp> it = this.zzXI.iterator();
        while (it.hasNext()) {
            if (it.next().b(j, 15)) {
                it.remove();
            }
        }
        synchronized (com.google.android.gms.cast.internal.zzp.f859a) {
            Iterator<com.google.android.gms.cast.internal.zzp> it2 = this.zzXI.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (it2.next().b()) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }
}
