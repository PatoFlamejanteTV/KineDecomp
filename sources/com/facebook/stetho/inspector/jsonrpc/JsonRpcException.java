package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;

/* loaded from: classes.dex */
public class JsonRpcException extends Exception {
    private final JsonRpcError mErrorMessage;

    public JsonRpcException(JsonRpcError jsonRpcError) {
        super(jsonRpcError.code + ": " + jsonRpcError.message);
        Util.throwIfNull(jsonRpcError);
        this.mErrorMessage = jsonRpcError;
    }

    public JsonRpcError getErrorMessage() {
        return this.mErrorMessage;
    }
}
