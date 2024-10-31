package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
public final class zzpt extends com.google.android.gms.common.internal.zzj<zzpw> {
    private final long zzavo;

    /* loaded from: classes.dex */
    private static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1804a;

        public a(zzlb.zzb<Status> zzbVar, zzlm<Connections.MessageListener> zzlmVar) {
            super(zzlmVar);
            this.f1804a = (zzlb.zzb) com.google.android.gms.common.internal.zzx.a(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zziv(int i) throws RemoteException {
            this.f1804a.zzp(new Status(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends zzps {

        /* renamed from: a, reason: collision with root package name */
        private final zzlm<Connections.MessageListener> f1805a;

        b(zzlm<Connections.MessageListener> zzlmVar) {
            this.f1805a = zzlmVar;
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void onDisconnected(String str) throws RemoteException {
            this.f1805a.zza(new hs(this, str));
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException {
            this.f1805a.zza(new hr(this, str, bArr, z));
        }
    }

    /* loaded from: classes.dex */
    private static class c extends zzps {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1806a;

        c(zzlb.zzb<Status> zzbVar) {
            this.f1806a = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zziw(int i) throws RemoteException {
            this.f1806a.zzp(new Status(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1807a;
        private final zzlm<Connections.ConnectionResponseCallback> b;

        public d(zzlb.zzb<Status> zzbVar, zzlm<Connections.ConnectionResponseCallback> zzlmVar, zzlm<Connections.MessageListener> zzlmVar2) {
            super(zzlmVar2);
            this.f1807a = (zzlb.zzb) com.google.android.gms.common.internal.zzx.a(zzbVar);
            this.b = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zza(String str, int i, byte[] bArr) throws RemoteException {
            this.b.zza(new ht(this, str, i, bArr));
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zziu(int i) throws RemoteException {
            this.f1807a.zzp(new Status(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e extends zzps {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Connections.StartAdvertisingResult> f1808a;
        private final zzlm<Connections.ConnectionRequestListener> b;

        e(zzlb.zzb<Connections.StartAdvertisingResult> zzbVar, zzlm<Connections.ConnectionRequestListener> zzlmVar) {
            this.f1808a = (zzlb.zzb) com.google.android.gms.common.internal.zzx.a(zzbVar);
            this.b = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            this.b.zza(new hu(this, str, str2, str3, bArr));
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zzm(int i, String str) throws RemoteException {
            this.f1808a.zzp(new f(new Status(i), str));
        }
    }

    /* loaded from: classes.dex */
    private static final class f implements Connections.StartAdvertisingResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1809a;
        private final String b;

        f(Status status, String str) {
            this.f1809a = status;
            this.b = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1809a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g extends zzps {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1810a;
        private final zzlm<Connections.EndpointDiscoveryListener> b;

        g(zzlb.zzb<Status> zzbVar, zzlm<Connections.EndpointDiscoveryListener> zzlmVar) {
            this.f1810a = (zzlb.zzb) com.google.android.gms.common.internal.zzx.a(zzbVar);
            this.b = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
            this.b.zza(new hv(this, str, str2, str3, str4));
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void onEndpointLost(String str) throws RemoteException {
            this.b.zza(new hw(this, str));
        }

        @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzpv
        public void zzis(int i) throws RemoteException {
            this.f1810a.zzp(new Status(i));
        }
    }

    public zzpt(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzavo = hashCode();
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        if (isConnected()) {
            try {
                zzpc().zzE(this.zzavo);
            } catch (RemoteException e2) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e2);
            }
        }
        super.disconnect();
    }

    public String zzAO() {
        try {
            return zzpc().zzT(this.zzavo);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String zzAP() {
        try {
            return zzpc().zzAP();
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void zzAQ() {
        try {
            zzpc().zzQ(this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e2);
        }
    }

    public void zzAR() {
        try {
            zzpc().zzS(this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e2);
        }
    }

    public void zza(zzlb.zzb<Status> zzbVar, String str, long j, zzlm<Connections.EndpointDiscoveryListener> zzlmVar) throws RemoteException {
        zzpc().zza(new g(zzbVar, zzlmVar), str, j, this.zzavo);
    }

    public void zza(zzlb.zzb<Connections.StartAdvertisingResult> zzbVar, String str, AppMetadata appMetadata, long j, zzlm<Connections.ConnectionRequestListener> zzlmVar) throws RemoteException {
        zzpc().zza(new e(zzbVar, zzlmVar), str, appMetadata, j, this.zzavo);
    }

    public void zza(zzlb.zzb<Status> zzbVar, String str, String str2, byte[] bArr, zzlm<Connections.ConnectionResponseCallback> zzlmVar, zzlm<Connections.MessageListener> zzlmVar2) throws RemoteException {
        zzpc().zza(new d(zzbVar, zzlmVar, zzlmVar2), str, str2, bArr, this.zzavo);
    }

    public void zza(zzlb.zzb<Status> zzbVar, String str, byte[] bArr, zzlm<Connections.MessageListener> zzlmVar) throws RemoteException {
        zzpc().zza(new a(zzbVar, zzlmVar), str, bArr, this.zzavo);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            zzpc().zza(strArr, bArr, this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e2);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            zzpc().zzb(strArr, bArr, this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdh, reason: merged with bridge method [inline-methods] */
    public zzpw zzW(IBinder iBinder) {
        return zzpw.zza.zzdj(iBinder);
    }

    public void zzej(String str) {
        try {
            zzpc().zzg(str, this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e2);
        }
    }

    public void zzek(String str) {
        try {
            zzpc().zzh(str, this.zzavo);
        } catch (RemoteException e2) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e2);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(zzlb.zzb<Status> zzbVar, String str) throws RemoteException {
        zzpc().zza(new c(zzbVar), str, this.zzavo);
    }
}
