package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoi;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzot implements SessionsApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zzoh.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<SessionReadResult> f1794a;

        private a(zzlb.zzb<SessionReadResult> zzbVar) {
            this.f1794a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(zzlb.zzb zzbVar, hk hkVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzoh
        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.f1794a.zzp(sessionReadResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends zzoi.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<SessionStopResult> f1795a;

        private b(zzlb.zzb<SessionStopResult> zzbVar) {
            this.f1795a = zzbVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(zzlb.zzb zzbVar, hk hkVar) {
            this(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzoi
        public void zza(SessionStopResult sessionStopResult) {
            this.f1795a.zzp(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new hl(this, googleApiClient, str, str2));
    }

    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza((GoogleApiClient) new hm(this, googleApiClient, sessionInsertRequest));
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza((GoogleApiClient) new hn(this, googleApiClient, sessionReadRequest));
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, pendingIntent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session) {
        com.google.android.gms.common.internal.zzx.a(session, "Session cannot be null");
        com.google.android.gms.common.internal.zzx.b(session.a(TimeUnit.MILLISECONDS) == 0, "Cannot start a session which has already ended");
        return googleApiClient.zzb(new hk(this, googleApiClient, session));
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, (String) null, str);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new hp(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
        return googleApiClient.zzb(new ho(this, googleApiClient, pendingIntent, i));
    }
}
