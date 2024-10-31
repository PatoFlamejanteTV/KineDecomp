package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1576p extends Q<AuthResult, com.google.firebase.auth.internal.zza> {
    private final PhoneAuthCredential w;

    public C1576p(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        Preconditions.a(phoneAuthCredential, "credential cannot be null");
        this.w = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "linkPhoneAuthCredential";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().a(this.f16435d.Y(), this.w, this.f16433b);
        } else {
            zzdqVar.a().a(new zzbc(this.f16435d.Y(), this.w), this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, AuthResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.q

            /* renamed from: a, reason: collision with root package name */
            private final C1576p f16461a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16461a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16461a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        zzl a2 = zzao.a(this.f16434c, this.k);
        ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, a2);
        b((C1576p) new zzf(a2));
    }
}
