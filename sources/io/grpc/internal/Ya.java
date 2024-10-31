package io.grpc.internal;

import io.grpc.internal.GzipInflatingBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GzipInflatingBuffer.java */
/* loaded from: classes3.dex */
public /* synthetic */ class Ya {

    /* renamed from: a */
    static final /* synthetic */ int[] f27538a = new int[GzipInflatingBuffer.State.values().length];

    static {
        try {
            f27538a[GzipInflatingBuffer.State.HEADER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.HEADER_EXTRA_LEN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.HEADER_EXTRA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.HEADER_NAME.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.HEADER_COMMENT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.HEADER_CRC.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.INITIALIZE_INFLATER.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.INFLATING.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.INFLATER_NEEDS_INPUT.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f27538a[GzipInflatingBuffer.State.TRAILER.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
