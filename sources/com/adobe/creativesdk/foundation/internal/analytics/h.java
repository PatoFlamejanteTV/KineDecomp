package com.adobe.creativesdk.foundation.internal.analytics;

import com.birbit.android.jobqueue.v;
import com.birbit.android.jobqueue.x;

/* compiled from: AdobeAnalyticsETSJobManager.java */
/* loaded from: classes.dex */
class h implements x {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar) {
        this.f4731a = jVar;
    }

    @Override // com.birbit.android.jobqueue.x
    public v a(com.birbit.android.jobqueue.c.b bVar, long j) {
        return new com.birbit.android.jobqueue.e.b(bVar, j);
    }

    @Override // com.birbit.android.jobqueue.x
    public v b(com.birbit.android.jobqueue.c.b bVar, long j) {
        return new com.birbit.android.jobqueue.e.b(bVar, j);
    }
}
