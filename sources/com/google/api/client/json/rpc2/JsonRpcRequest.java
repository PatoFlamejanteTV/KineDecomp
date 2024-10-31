package com.google.api.client.json.rpc2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

@Beta
/* loaded from: classes.dex */
public class JsonRpcRequest extends GenericData {

    /* renamed from: a, reason: collision with root package name */
    @Key
    private final String f2497a = "2.0";

    @Override // com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonRpcRequest set(String str, Object obj) {
        return (JsonRpcRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonRpcRequest clone() {
        return (JsonRpcRequest) super.clone();
    }
}
