package com.facebook.appevents;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class g implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger.AccessTokenAppIdPair f256a;
    final /* synthetic */ GraphRequest b;
    final /* synthetic */ AppEventsLogger.d c;
    final /* synthetic */ AppEventsLogger.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AppEventsLogger.AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, AppEventsLogger.d dVar, AppEventsLogger.a aVar) {
        this.f256a = accessTokenAppIdPair;
        this.b = graphRequest;
        this.c = dVar;
        this.d = aVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        AppEventsLogger.handleResponse(this.f256a, this.b, graphResponse, this.c, this.d);
    }
}
