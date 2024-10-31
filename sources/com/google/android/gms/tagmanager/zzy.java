package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzy extends BasePendingResult<ContainerHolder> {
    private volatile F q;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ContainerHolder a(Status status) {
        if (this.q != null) {
            return this.q;
        }
        if (status == Status.f10707d) {
            zzdi.c("timer expired: setting result to failure");
        }
        return new F(status);
    }
}
