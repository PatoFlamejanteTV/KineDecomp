package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class F extends Q<AuthResult, com.google.firebase.auth.internal.zza> {
    private final zzbu w;

    public F(String str, String str2, String str3) {
        super(2);
        Preconditions.a(str, (Object) "email cannot be null or empty");
        Preconditions.a(str2, (Object) "password cannot be null or empty");
        this.w = new zzbu(str, str2, str3);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "signInWithEmailAndPassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().b(this.w.getEmail(), this.w.getPassword(), this.f16433b);
        } else {
            zzdqVar.a().a(this.w, this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, AuthResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.G

            /* renamed from: a, reason: collision with root package name */
            private final F f16426a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16426a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16426a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        zzl a2 = zzao.a(this.f16434c, this.k);
        ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, a2);
        b((F) new zzf(a2));
    }
}
