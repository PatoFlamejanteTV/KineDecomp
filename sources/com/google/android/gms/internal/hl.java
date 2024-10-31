package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzot;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hl extends zzns.a<SessionStopResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1603a;
    final /* synthetic */ String b;
    final /* synthetic */ zzot c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hl(zzot zzotVar, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.c = zzotVar;
        this.f1603a = str;
        this.b = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionStopResult zzb(Status status) {
        return SessionStopResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzns zznsVar) throws RemoteException {
        ((zzod) zznsVar.zzpc()).zza(new SessionStopRequest(this.f1603a, this.b, new zzot.b(this, null)));
    }
}
