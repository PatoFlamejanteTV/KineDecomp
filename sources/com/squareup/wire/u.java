package com.squareup.wire;

/* compiled from: WireInput.java */
/* loaded from: classes.dex */
/* synthetic */ class u {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4872a = new int[WireType.values().length];

    static {
        try {
            f4872a[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4872a[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4872a[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4872a[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f4872a[WireType.START_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4872a[WireType.END_GROUP.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
