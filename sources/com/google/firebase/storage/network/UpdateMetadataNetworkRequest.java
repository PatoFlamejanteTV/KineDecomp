package com.google.firebase.storage.network;

import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class UpdateMetadataNetworkRequest extends NetworkRequest {
    private final JSONObject o;

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String a() {
        return "PUT";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected JSONObject d() {
        return this.o;
    }
}
