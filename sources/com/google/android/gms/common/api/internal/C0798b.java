package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0798b implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ BasePendingResult f10823a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaab f10824b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0798b(zaab zaabVar, BasePendingResult basePendingResult) {
        this.f10824b = zaabVar;
        this.f10823a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        Map map;
        map = this.f10824b.f10865a;
        map.remove(this.f10823a);
    }
}
