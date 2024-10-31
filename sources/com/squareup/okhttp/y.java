package com.squareup.okhttp;

import com.squareup.okhttp.HttpUrl;

/* compiled from: HttpUrl.java */
/* loaded from: classes3.dex */
public /* synthetic */ class y {

    /* renamed from: a */
    static final /* synthetic */ int[] f25541a = new int[HttpUrl.Builder.ParseResult.values().length];

    static {
        try {
            f25541a[HttpUrl.Builder.ParseResult.SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f25541a[HttpUrl.Builder.ParseResult.INVALID_HOST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f25541a[HttpUrl.Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f25541a[HttpUrl.Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f25541a[HttpUrl.Builder.ParseResult.INVALID_PORT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
