package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class z extends Q<AuthResult, com.google.firebase.auth.internal.zza> {
    private final zzby w;

    public z(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.a(phoneAuthCredential, "credential cannot be null");
        this.w = new zzby(phoneAuthCredential.b(false), str);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "reauthenticateWithPhoneCredentialWithData";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().a(this.w.zzcp(), this.f16433b);
        } else {
            zzdqVar.a().a(this.w, this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, AuthResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.A

            /* renamed from: a, reason: collision with root package name */
            private final z f16423a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16423a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16423a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        zzl a2 = zzao.a(this.f16434c, this.k);
        if (this.f16435d.R().equalsIgnoreCase(a2.R())) {
            ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, a2);
            b((z) new zzf(a2));
        } else {
            a(new Status(17024));
        }
    }
}
