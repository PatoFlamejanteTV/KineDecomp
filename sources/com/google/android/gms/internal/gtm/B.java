package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
class B extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static final String f13125a = "com.google.android.gms.internal.gtm.B";

    /* renamed from: b, reason: collision with root package name */
    private final zzap f13126b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13127c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13128d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(zzap zzapVar) {
        Preconditions.a(zzapVar);
        this.f13126b = zzapVar;
    }

    private final void e() {
        this.f13126b.zzco();
        this.f13126b.zzcs();
    }

    @VisibleForTesting
    private final boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13126b.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }

    public final boolean a() {
        if (!this.f13127c) {
            this.f13126b.zzco().zzt("Connectivity unknown. Receiver not registered");
        }
        return this.f13128d;
    }

    public final void b() {
        if (this.f13127c) {
            this.f13126b.zzco().zzq("Unregistering connectivity change receiver");
            this.f13127c = false;
            this.f13128d = false;
            try {
                this.f13126b.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f13126b.zzco().zze("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final void c() {
        e();
        if (this.f13127c) {
            return;
        }
        Context context = this.f13126b.getContext();
        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
        this.f13128d = f();
        this.f13126b.zzco().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f13128d));
        this.f13127c = true;
    }

    @VisibleForTesting
    public final void d() {
        Context context = this.f13126b.getContext();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f13125a, true);
        context.sendOrderedBroadcast(intent, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        e();
        String action = intent.getAction();
        this.f13126b.zzco().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f2 = f();
            if (this.f13128d != f2) {
                this.f13128d = f2;
                zzae zzcs = this.f13126b.zzcs();
                zzcs.zza("Network connectivity status changed", Boolean.valueOf(f2));
                zzcs.zzcq().a(new RunnableC1292b(zzcs, f2));
                return;
            }
            return;
        }
        if ("com.google.analytics.RADIO_POWERED".equals(action)) {
            if (intent.hasExtra(f13125a)) {
                return;
            }
            zzae zzcs2 = this.f13126b.zzcs();
            zzcs2.zzq("Radio powered up");
            zzcs2.zzci();
            return;
        }
        this.f13126b.zzco().zzd("NetworkBroadcastReceiver received unknown action", action);
    }
}
