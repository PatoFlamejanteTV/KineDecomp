package com.nexstreaming.app.general.nexasset.assetpackage;

/* compiled from: XMLItemDefReader.java */
/* loaded from: classes2.dex */
/* synthetic */ class x {

    /* renamed from: a */
    static final /* synthetic */ int[] f19557a;

    /* renamed from: b */
    static final /* synthetic */ int[] f19558b = new int[ItemParameterType.values().length];

    static {
        try {
            f19558b[ItemParameterType.CHOICE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19558b[ItemParameterType.SWITCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19558b[ItemParameterType.IMAGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19558b[ItemParameterType.RANGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19558b[ItemParameterType.RECT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19558b[ItemParameterType.RGB.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f19558b[ItemParameterType.RGBA.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f19558b[ItemParameterType.TEXT.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f19558b[ItemParameterType.XY.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f19558b[ItemParameterType.XYZ.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        f19557a = new int[ItemType.values().length];
        try {
            f19557a[ItemType.kedl.ordinal()] = 1;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f19557a[ItemType.renderitem.ordinal()] = 2;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f19557a[ItemType.overlay.ordinal()] = 3;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
