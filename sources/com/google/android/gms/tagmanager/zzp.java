package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlc;

/* loaded from: classes.dex */
public class zzp extends zzlc<ContainerHolder> {

    /* renamed from: a, reason: collision with root package name */
    private volatile zzo f2243a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContainerHolder zzb(Status status) {
        if (this.f2243a != null) {
            return this.f2243a;
        }
        if (status == Status.d) {
            zzbg.a("timer expired: setting result to failure");
        }
        return new zzo(status);
    }
}
