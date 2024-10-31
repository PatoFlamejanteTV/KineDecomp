package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzv;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1566f extends Q<Void, zzv> {
    public C1566f() {
        super(5);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "delete";
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, Void> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.g

            /* renamed from: a, reason: collision with root package name */
            private final C1566f f16456a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16456a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                C1566f c1566f = this.f16456a;
                zzdq zzdqVar = (zzdq) obj;
                c1566f.f16438g = new zzew(c1566f, (TaskCompletionSource) obj2);
                if (c1566f.r) {
                    zzdqVar.a().c(c1566f.f16435d.Y(), c1566f.f16433b);
                } else {
                    zzdqVar.a().a(new zzas(c1566f.f16435d.Y()), c1566f.f16433b);
                }
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        ((zzv) this.f16436e).a();
        b((C1566f) null);
    }
}
