package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzpu implements Connections {
    public static final Api.zzc<zzpt> zzRk = new Api.zzc<>();
    public static final Api.zza<zzpt, Api.ApiOptions.NoOptions> zzRl = new hx();

    /* loaded from: classes.dex */
    private static abstract class a<R extends Result> extends zzlb.zza<R, zzpt> {
        public a(GoogleApiClient googleApiClient) {
            super(zzpu.zzRk, googleApiClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends a<Connections.StartAdvertisingResult> {
        private b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(GoogleApiClient googleApiClient, hx hxVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Connections.StartAdvertisingResult zzb(Status status) {
            return new id(this, status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c extends a<Status> {
        private c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(GoogleApiClient googleApiClient, hx hxVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    public static zzpt zzd(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.common.internal.zzx.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzpt zze(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.a(googleApiClient.zza(Nearby.f2082a), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.f2082a);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (hasConnectedApi) {
            return (zzpt) googleApiClient.zza(zzRk);
        }
        return null;
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, Connections.MessageListener messageListener) {
        return googleApiClient.zzb(new ib(this, googleApiClient, str, bArr, googleApiClient.zzo(messageListener)));
    }

    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzek(str);
    }

    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzAP();
    }

    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzAO();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new ic(this, googleApiClient, str));
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        return googleApiClient.zzb(new ia(this, googleApiClient, str, str2, bArr, googleApiClient.zzo(connectionResponseCallback), googleApiClient.zzo(messageListener)));
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zza(new String[]{str}, bArr);
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zza((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zzb(new String[]{str}, bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zzb((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, Connections.ConnectionRequestListener connectionRequestListener) {
        return googleApiClient.zzb(new hy(this, googleApiClient, str, appMetadata, j, googleApiClient.zzo(connectionRequestListener)));
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        return googleApiClient.zzb(new hz(this, googleApiClient, str, j, googleApiClient.zzo(endpointDiscoveryListener)));
    }

    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzAQ();
    }

    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzAR();
    }

    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzej(str);
    }
}
