package com.squareup.wire;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WireInput.java */
/* loaded from: classes3.dex */
public /* synthetic */ class t {

    /* renamed from: a */
    static final /* synthetic */ int[] f25742a = new int[WireType.values().length];

    static {
        try {
            f25742a[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f25742a[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f25742a[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f25742a[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f25742a[WireType.START_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f25742a[WireType.END_GROUP.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
