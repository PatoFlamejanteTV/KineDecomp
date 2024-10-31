package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.zza;
import com.google.android.gms.wearable.zzc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class zzbo extends com.google.android.gms.common.internal.zzj<zzax> {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f2391a;
    private final a<zzc.zza> b;
    private final a<zza.InterfaceC0047zza> c;
    private final a<ChannelApi.ChannelListener> d;
    private final a<DataApi.DataListener> e;
    private final a<MessageApi.MessageListener> f;
    private final a<NodeApi.NodeListener> g;
    private final a<NodeApi.zza> h;
    private final Map<String, a<CapabilityApi.CapabilityListener>> i;

    public zzbo(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 14, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f2391a = Executors.newCachedThreadPool();
        this.b = new a<>();
        this.c = new a<>();
        this.d = new a<>();
        this.e = new a<>();
        this.f = new a<>();
        this.g = new a<>();
        this.h = new a<>();
        this.i = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzax zzW(IBinder iBinder) {
        return zzax.zza.a(iBinder);
    }

    public void a(zzlb.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, zzlm<ChannelApi.ChannelListener> zzlmVar, String str) throws RemoteException {
        if (str == null) {
            this.d.a(this, zzbVar, channelListener, g.e(zzlmVar));
        } else {
            this.d.a(this, zzbVar, new e(str, channelListener), g.a(zzlmVar, str));
        }
    }

    public void a(zzlb.zzb<Status> zzbVar, NodeApi.NodeListener nodeListener, zzlm<NodeApi.NodeListener> zzlmVar) throws RemoteException {
        this.g.a(this, zzbVar, nodeListener, g.c(zzlmVar));
    }

    public void a(zzlb.zzb<Status> zzbVar, NodeApi.zza zzaVar, zzlm<NodeApi.zza> zzlmVar) throws RemoteException {
        this.h.a(this, zzbVar, zzaVar, g.d(zzlmVar));
    }

    public void a(zzlb.zzb<Status> zzbVar, zza.InterfaceC0047zza interfaceC0047zza, zzlm<zza.InterfaceC0047zza> zzlmVar) throws RemoteException {
        this.c.a(this, zzbVar, interfaceC0047zza, g.a(zzlmVar));
    }

    public void a(zzlb.zzb<Status> zzbVar, zzc.zza zzaVar, zzlm<zzc.zza> zzlmVar) throws RemoteException {
        this.b.a(this, zzbVar, zzaVar, g.b(zzlmVar));
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        this.b.a(this);
        this.c.a(this);
        this.d.a(this);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
        synchronized (this.i) {
            Iterator<a<CapabilityApi.CapabilityListener>> it = this.i.values().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
        super.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.b.a(iBinder);
            this.c.a(iBinder);
            this.d.a(iBinder);
            this.e.a(iBinder);
            this.f.a(iBinder);
            this.g.a(iBinder);
            this.h.a(iBinder);
            synchronized (this.i) {
                Iterator<a<CapabilityApi.CapabilityListener>> it = this.i.values().iterator();
                while (it.hasNext()) {
                    it.next().a(iBinder);
                }
            }
        }
        super.zza(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
