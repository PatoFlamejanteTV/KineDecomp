package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g<T> extends zzaw.zza {

    /* renamed from: a */
    private zzlm<zza.InterfaceC0047zza> f2370a;
    private zzlm<zzc.zza> b;
    private zzlm<DataApi.DataListener> c;
    private zzlm<MessageApi.MessageListener> d;
    private zzlm<NodeApi.NodeListener> e;
    private zzlm<NodeApi.zza> f;
    private zzlm<ChannelApi.ChannelListener> g;
    private zzlm<CapabilityApi.CapabilityListener> h;
    private final IntentFilter[] i;
    private final String j;
    private final String k;

    private g(IntentFilter[] intentFilterArr, String str, String str2) {
        this.i = intentFilterArr;
        this.j = str;
        this.k = str2;
    }

    public static g<zza.InterfaceC0047zza> a(zzlm<zza.InterfaceC0047zza> zzlmVar) {
        g<zza.InterfaceC0047zza> gVar = new g<>(null, null, null);
        ((g) gVar).f2370a = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    public static g<ChannelApi.ChannelListener> a(zzlm<ChannelApi.ChannelListener> zzlmVar, String str) {
        g<ChannelApi.ChannelListener> gVar = new g<>(null, (String) com.google.android.gms.common.internal.zzx.a(str), null);
        ((g) gVar).g = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    private static zzlm.zzb<DataApi.DataListener> b(DataHolder dataHolder) {
        return new j(dataHolder);
    }

    private static zzlm.zzb<zza.InterfaceC0047zza> b(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new i(amsEntityUpdateParcelable);
    }

    private static zzlm.zzb<zzc.zza> b(AncsNotificationParcelable ancsNotificationParcelable) {
        return new h(ancsNotificationParcelable);
    }

    private static zzlm.zzb<CapabilityApi.CapabilityListener> b(CapabilityInfoParcelable capabilityInfoParcelable) {
        return new p(capabilityInfoParcelable);
    }

    private static zzlm.zzb<ChannelApi.ChannelListener> b(ChannelEventParcelable channelEventParcelable) {
        return new o(channelEventParcelable);
    }

    private static zzlm.zzb<MessageApi.MessageListener> b(MessageEventParcelable messageEventParcelable) {
        return new k(messageEventParcelable);
    }

    private static zzlm.zzb<NodeApi.zza> b(List<NodeParcelable> list) {
        return new n(list);
    }

    public static g<zzc.zza> b(zzlm<zzc.zza> zzlmVar) {
        g<zzc.zza> gVar = new g<>(null, null, null);
        ((g) gVar).b = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    private static zzlm.zzb<NodeApi.NodeListener> c(NodeParcelable nodeParcelable) {
        return new l(nodeParcelable);
    }

    public static g<NodeApi.NodeListener> c(zzlm<NodeApi.NodeListener> zzlmVar) {
        g<NodeApi.NodeListener> gVar = new g<>(null, null, null);
        ((g) gVar).e = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    private static zzlm.zzb<NodeApi.NodeListener> d(NodeParcelable nodeParcelable) {
        return new m(nodeParcelable);
    }

    public static g<NodeApi.zza> d(zzlm<NodeApi.zza> zzlmVar) {
        g<NodeApi.zza> gVar = new g<>(null, null, null);
        ((g) gVar).f = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    public static g<ChannelApi.ChannelListener> e(zzlm<ChannelApi.ChannelListener> zzlmVar) {
        g<ChannelApi.ChannelListener> gVar = new g<>(null, null, null);
        ((g) gVar).g = (zzlm) com.google.android.gms.common.internal.zzx.a(zzlmVar);
        return gVar;
    }

    private static void f(zzlm<?> zzlmVar) {
        if (zzlmVar != null) {
            zzlmVar.clear();
        }
    }

    public void a() {
        f(this.f2370a);
        this.f2370a = null;
        f(this.b);
        this.b = null;
        f(this.c);
        this.c = null;
        f(this.d);
        this.d = null;
        f(this.e);
        this.e = null;
        f(this.f);
        this.f = null;
        f(this.g);
        this.g = null;
        f(this.h);
        this.h = null;
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(DataHolder dataHolder) {
        if (this.c != null) {
            this.c.zza(b(dataHolder));
        } else {
            dataHolder.i();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.f2370a != null) {
            this.f2370a.zza(b(amsEntityUpdateParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.b != null) {
            this.b.zza(b(ancsNotificationParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.h != null) {
            this.h.zza(b(capabilityInfoParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(ChannelEventParcelable channelEventParcelable) {
        if (this.g != null) {
            this.g.zza(b(channelEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(MessageEventParcelable messageEventParcelable) {
        if (this.d != null) {
            this.d.zza(b(messageEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(NodeParcelable nodeParcelable) {
        if (this.e != null) {
            this.e.zza(c(nodeParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void a(List<NodeParcelable> list) {
        if (this.f != null) {
            this.f.zza(b(list));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void b(NodeParcelable nodeParcelable) {
        if (this.e != null) {
            this.e.zza(d(nodeParcelable));
        }
    }

    public IntentFilter[] b() {
        return this.i;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return this.k;
    }
}
