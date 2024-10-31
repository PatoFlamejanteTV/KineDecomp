package io.grpc.internal;

import com.google.gson.stream.JsonToken;

/* compiled from: JsonParser.java */
/* renamed from: io.grpc.internal.ob */
/* loaded from: classes3.dex */
/* synthetic */ class C2469ob {

    /* renamed from: a */
    static final /* synthetic */ int[] f27709a = new int[JsonToken.values().length];

    static {
        try {
            f27709a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27709a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27709a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f27709a[JsonToken.NUMBER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f27709a[JsonToken.BOOLEAN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f27709a[JsonToken.NULL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
