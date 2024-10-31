package com.squareup.wire;

import com.squareup.wire.Message;

/* compiled from: MessageAdapter.java */
/* loaded from: classes3.dex */
public /* synthetic */ class k {

    /* renamed from: a */
    static final /* synthetic */ int[] f25723a;

    /* renamed from: b */
    static final /* synthetic */ int[] f25724b = new int[WireType.values().length];

    static {
        try {
            f25724b[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f25724b[WireType.FIXED32.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f25724b[WireType.FIXED64.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f25724b[WireType.LENGTH_DELIMITED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f25724b[WireType.START_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f25724b[WireType.END_GROUP.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        f25723a = new int[Message.Datatype.values().length];
        try {
            f25723a[Message.Datatype.INT32.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f25723a[Message.Datatype.INT64.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f25723a[Message.Datatype.UINT64.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f25723a[Message.Datatype.UINT32.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f25723a[Message.Datatype.SINT32.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f25723a[Message.Datatype.SINT64.ordinal()] = 6;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f25723a[Message.Datatype.BOOL.ordinal()] = 7;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f25723a[Message.Datatype.ENUM.ordinal()] = 8;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f25723a[Message.Datatype.STRING.ordinal()] = 9;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f25723a[Message.Datatype.BYTES.ordinal()] = 10;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f25723a[Message.Datatype.MESSAGE.ordinal()] = 11;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f25723a[Message.Datatype.FIXED32.ordinal()] = 12;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f25723a[Message.Datatype.SFIXED32.ordinal()] = 13;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f25723a[Message.Datatype.FLOAT.ordinal()] = 14;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f25723a[Message.Datatype.FIXED64.ordinal()] = 15;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f25723a[Message.Datatype.SFIXED64.ordinal()] = 16;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            f25723a[Message.Datatype.DOUBLE.ordinal()] = 17;
        } catch (NoSuchFieldError unused23) {
        }
    }
}
