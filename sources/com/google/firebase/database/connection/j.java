package com.google.firebase.database.connection;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.database.connection.WebsocketConnection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebsocketConnection f16794a;

    public j(WebsocketConnection websocketConnection) {
        this.f16794a = websocketConnection;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebsocketConnection.a aVar;
        WebsocketConnection.a aVar2;
        aVar = this.f16794a.f16767b;
        if (aVar != null) {
            aVar2 = this.f16794a.f16767b;
            aVar2.a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.f16794a.h();
        }
    }
}
