package com.google.api.client.extensions.android.json;

import android.util.JsonToken;

/* compiled from: AndroidJsonParser.java */
/* loaded from: classes2.dex */
/* synthetic */ class b {

    /* renamed from: a */
    static final /* synthetic */ int[] f14635a;

    /* renamed from: b */
    static final /* synthetic */ int[] f14636b = new int[JsonToken.values().length];

    static {
        try {
            f14636b[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14636b[JsonToken.END_ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14636b[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14636b[JsonToken.END_OBJECT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14636b[JsonToken.BOOLEAN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14636b[JsonToken.NULL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f14636b[JsonToken.STRING.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f14636b[JsonToken.NUMBER.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f14636b[JsonToken.NAME.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        f14635a = new int[com.google.api.client.json.JsonToken.values().length];
        try {
            f14635a[com.google.api.client.json.JsonToken.START_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f14635a[com.google.api.client.json.JsonToken.START_OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
