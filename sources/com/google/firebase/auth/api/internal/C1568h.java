package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.internal.zzp;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1568h extends Q<ProviderQueryResult, com.google.firebase.auth.internal.zza> {
    private final zzaw w;

    public C1568h(String str, String str2) {
        super(3);
        Preconditions.a(str, (Object) "email cannot be null or empty");
        this.w = new zzaw(str, str2);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "fetchProvidersForEmail";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().e(this.w.getEmail(), this.f16433b);
        } else {
            zzdqVar.a().a(this.w, this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, ProviderQueryResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.i

            /* renamed from: a, reason: collision with root package name */
            private final C1568h f16457a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16457a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16457a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        b((C1568h) new zzp(this.l));
    }
}
