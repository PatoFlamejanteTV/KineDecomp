package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzasg extends zzasc implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private Context mContext;
    private final Object mLock;
    private zzbbi zzbob;
    private zzbcn<zzasi> zzdvz;
    private final zzasa zzdwa;
    private zzazb zzdwd;

    @VisibleForTesting
    private zzash zzdwe;

    public zzasg(Context context, zzbbi zzbbiVar, zzbcn<zzasi> zzbcnVar, zzasa zzasaVar) {
        super(zzbcnVar, zzasaVar);
        this.mLock = new Object();
        this.mContext = context;
        this.zzbob = zzbbiVar;
        this.zzdvz = zzbcnVar;
        this.zzdwa = zzasaVar;
        this.zzdwe = new zzash(context, com.google.android.gms.ads.internal.zzbv.u().zzaak(), this, this);
        this.zzdwe.checkAvailabilityAndConnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzwa();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbd.zzdn("Cannot connect to remote service, fallback to local instance.");
        this.zzdwd = new zzasf(this.mContext, this.zzdvz, this.zzdwa);
        this.zzdwd.zzwa();
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "gms_connection_failed_fallback_to_local");
        com.google.android.gms.ads.internal.zzbv.e().zzb(this.mContext, this.zzbob.zzdp, "gmob-apps", bundle, true);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbbd.zzdn("Disconnected from remote ad request service.");
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzwi() {
        synchronized (this.mLock) {
            if (this.zzdwe.isConnected() || this.zzdwe.isConnecting()) {
                this.zzdwe.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final zzasq zzwj() {
        zzasq zzwk;
        synchronized (this.mLock) {
            try {
                try {
                    zzwk = this.zzdwe.zzwk();
                } catch (DeadObjectException | IllegalStateException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzwk;
    }
}
