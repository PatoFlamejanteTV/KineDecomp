package com.facebook.appevents;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
public class k implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessTokenAppIdPair f9204a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GraphRequest f9205b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ y f9206c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ w f9207d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, y yVar, w wVar) {
        this.f9204a = accessTokenAppIdPair;
        this.f9205b = graphRequest;
        this.f9206c = yVar;
        this.f9207d = wVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        m.b(this.f9204a, this.f9205b, graphResponse, this.f9206c, this.f9207d);
    }
}
