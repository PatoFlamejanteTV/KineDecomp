package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class L extends Q<Void, com.google.firebase.auth.internal.zza> {
    private final UserProfileChangeRequest w;

    public L(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        Preconditions.a(userProfileChangeRequest, "request cannot be null");
        this.w = userProfileChangeRequest;
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "updateProfile";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().a(this.f16435d.Y(), this.w, this.f16433b);
        } else {
            zzdqVar.a().a(new zzce(this.w, this.f16435d.Y()), this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, Void> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.M

            /* renamed from: a, reason: collision with root package name */
            private final L f16429a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16429a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16429a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, zzao.a(this.f16434c, this.k));
        b((L) null);
    }
}
