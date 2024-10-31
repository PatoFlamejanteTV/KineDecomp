package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1564d extends Q<AuthResult, com.google.firebase.auth.internal.zza> {
    final zzaq w;

    public C1564d(String str, String str2, String str3) {
        super(2);
        Preconditions.a(str, (Object) "email cannot be null or empty");
        Preconditions.a(str2, (Object) "password cannot be null or empty");
        this.w = new zzaq(str, str2, str3);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "createUserWithEmailAndPassword";
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, AuthResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.e

            /* renamed from: a, reason: collision with root package name */
            private final C1564d f16455a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16455a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                C1564d c1564d = this.f16455a;
                zzdq zzdqVar = (zzdq) obj;
                c1564d.f16438g = new zzew(c1564d, (TaskCompletionSource) obj2);
                if (c1564d.r) {
                    zzdqVar.a().e(c1564d.w.getEmail(), c1564d.w.getPassword(), c1564d.f16433b);
                } else {
                    zzdqVar.a().a(c1564d.w, c1564d.f16433b);
                }
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        zzl a2 = zzao.a(this.f16434c, this.k);
        ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, a2);
        b((C1564d) new zzf(a2));
    }
}
