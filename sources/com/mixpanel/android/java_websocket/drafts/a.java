package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;

/* compiled from: Draft_17.java */
/* loaded from: classes.dex */
public class a extends Draft_10 {
    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(com.mixpanel.android.java_websocket.b.a aVar) throws InvalidHandshakeException {
        return b(aVar) == 13 ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public com.mixpanel.android.java_websocket.b.b a(com.mixpanel.android.java_websocket.b.b bVar) {
        super.a(bVar);
        bVar.a("Sec-WebSocket-Version", "13");
        return bVar;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft c() {
        return new a();
    }
}
