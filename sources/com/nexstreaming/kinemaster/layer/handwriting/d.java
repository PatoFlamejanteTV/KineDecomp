package com.nexstreaming.kinemaster.layer.handwriting;

import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: Stroke.java */
/* loaded from: classes.dex */
public /* synthetic */ class d {

    /* renamed from: a */
    static final /* synthetic */ int[] f20644a;

    /* renamed from: b */
    static final /* synthetic */ int[] f20645b;

    /* renamed from: c */
    static final /* synthetic */ int[] f20646c;

    /* renamed from: d */
    static final /* synthetic */ int[] f20647d = new int[KMProto.KMProject.CapDecorationStyle.values().length];

    static {
        try {
            f20647d[KMProto.KMProject.CapDecorationStyle.NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20647d[KMProto.KMProject.CapDecorationStyle.ROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20647d[KMProto.KMProject.CapDecorationStyle.SOLID_ARROW.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20647d[KMProto.KMProject.CapDecorationStyle.HOLLOW_ARROW.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f20646c = new int[Stroke.CapDecorationStyle.values().length];
        try {
            f20646c[Stroke.CapDecorationStyle.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f20646c[Stroke.CapDecorationStyle.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f20646c[Stroke.CapDecorationStyle.SolidArrow.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f20646c[Stroke.CapDecorationStyle.HollowArrow.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        f20645b = new int[KMProto.KMProject.PathStyle.values().length];
        try {
            f20645b[KMProto.KMProject.PathStyle.SMOOTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.SHARP.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.RECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.XSHAPE.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.ELLIPSE.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.ROUND_RECT.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.FILL_RECT.ordinal()] = 7;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.FILL_ELLIPSE.ordinal()] = 8;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f20645b[KMProto.KMProject.PathStyle.FILL_ROUND_RECT.ordinal()] = 9;
        } catch (NoSuchFieldError unused17) {
        }
        f20644a = new int[Stroke.PathStyle.values().length];
        try {
            f20644a[Stroke.PathStyle.Smooth.ordinal()] = 1;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f20644a[Stroke.PathStyle.Sharp.ordinal()] = 2;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f20644a[Stroke.PathStyle.Interpolated.ordinal()] = 3;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f20644a[Stroke.PathStyle.Rect.ordinal()] = 4;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f20644a[Stroke.PathStyle.XShape.ordinal()] = 5;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            f20644a[Stroke.PathStyle.Ellipse.ordinal()] = 6;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            f20644a[Stroke.PathStyle.RoundRect.ordinal()] = 7;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            f20644a[Stroke.PathStyle.FillRect.ordinal()] = 8;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            f20644a[Stroke.PathStyle.FillEllipse.ordinal()] = 9;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            f20644a[Stroke.PathStyle.FillRoundRect.ordinal()] = 10;
        } catch (NoSuchFieldError unused27) {
        }
    }
}
