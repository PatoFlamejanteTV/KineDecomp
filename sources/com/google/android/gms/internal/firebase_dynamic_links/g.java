package com.google.android.gms.internal.firebase_dynamic_links;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class g extends b<AppInviteInvitationResult> {
    private final WeakReference<Activity> s;
    private final boolean t;
    private final Intent u;

    public g(zze zzeVar, GoogleApiClient googleApiClient, Activity activity, boolean z) {
        super(googleApiClient);
        this.t = z;
        this.s = new WeakReference<>(activity);
        this.u = activity != null ? activity.getIntent() : null;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzn zznVar) throws RemoteException {
        zzn zznVar2 = zznVar;
        if (AppInviteReferral.a(this.u)) {
            a((g) new zzo(Status.f10704a, this.u));
            zznVar2.zza((zzp) null);
        } else {
            zznVar2.zza(new h(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result a(Status status) {
        return new zzo(status, new Intent());
    }
}
