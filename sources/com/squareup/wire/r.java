package com.squareup.wire;

/* compiled from: UnknownFieldMap.java */
/* loaded from: classes.dex */
/* synthetic */ class r {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4869a = new int[WireType.values().length];

    static {
        try {
            f4869a[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4869a[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4869a[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4869a[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
