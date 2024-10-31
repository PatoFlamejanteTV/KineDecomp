package com.facebook.marketing;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewIndexer.java */
/* loaded from: classes.dex */
public class h implements GraphRequest.Callback {
    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ViewIndexer.TAG;
        Logger.log(loggingBehavior, str, "App index sent to FB!");
    }
}
