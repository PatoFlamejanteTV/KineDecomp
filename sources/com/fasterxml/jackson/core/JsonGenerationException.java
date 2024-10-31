package com.fasterxml.jackson.core;

/* loaded from: classes.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;

    public JsonGenerationException(Throwable th) {
        super(th);
    }

    public JsonGenerationException(String str) {
        super(str, (JsonLocation) null);
    }

    public JsonGenerationException(String str, Throwable th) {
        super(str, (JsonLocation) null, th);
    }
}
