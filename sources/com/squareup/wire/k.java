package com.squareup.wire;

import com.squareup.wire.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageAdapter.java */
/* loaded from: classes.dex */
public /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4861a;
    static final /* synthetic */ int[] b = new int[WireType.values().length];

    static {
        try {
            b[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            b[WireType.START_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            b[WireType.END_GROUP.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        f4861a = new int[Message.Datatype.values().length];
        try {
            f4861a[Message.Datatype.INT32.ordinal()] = 1;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f4861a[Message.Datatype.INT64.ordinal()] = 2;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f4861a[Message.Datatype.UINT64.ordinal()] = 3;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f4861a[Message.Datatype.UINT32.ordinal()] = 4;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f4861a[Message.Datatype.SINT32.ordinal()] = 5;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f4861a[Message.Datatype.SINT64.ordinal()] = 6;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f4861a[Message.Datatype.BOOL.ordinal()] = 7;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f4861a[Message.Datatype.ENUM.ordinal()] = 8;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f4861a[Message.Datatype.STRING.ordinal()] = 9;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f4861a[Message.Datatype.BYTES.ordinal()] = 10;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f4861a[Message.Datatype.MESSAGE.ordinal()] = 11;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f4861a[Message.Datatype.FIXED32.ordinal()] = 12;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f4861a[Message.Datatype.SFIXED32.ordinal()] = 13;
        } catch (NoSuchFieldError e19) {
        }
        try {
            f4861a[Message.Datatype.FLOAT.ordinal()] = 14;
        } catch (NoSuchFieldError e20) {
        }
        try {
            f4861a[Message.Datatype.FIXED64.ordinal()] = 15;
        } catch (NoSuchFieldError e21) {
        }
        try {
            f4861a[Message.Datatype.SFIXED64.ordinal()] = 16;
        } catch (NoSuchFieldError e22) {
        }
        try {
            f4861a[Message.Datatype.DOUBLE.ordinal()] = 17;
        } catch (NoSuchFieldError e23) {
        }
    }
}
