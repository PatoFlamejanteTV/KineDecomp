package com.squareup.wire;

/* compiled from: UnknownFieldMap.java */
/* loaded from: classes3.dex */
/* synthetic */ class q {

    /* renamed from: a */
    static final /* synthetic */ int[] f25730a = new int[WireType.values().length];

    static {
        try {
            f25730a[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f25730a[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f25730a[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f25730a[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
