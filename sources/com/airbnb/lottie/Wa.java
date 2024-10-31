package com.airbnb.lottie;

import com.airbnb.lottie.ShapeStroke;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public /* synthetic */ class Wa {

    /* renamed from: a */
    static final /* synthetic */ int[] f7724a;

    /* renamed from: b */
    static final /* synthetic */ int[] f7725b = new int[ShapeStroke.LineJoinType.values().length];

    static {
        try {
            f7725b[ShapeStroke.LineJoinType.Bevel.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7725b[ShapeStroke.LineJoinType.Miter.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7725b[ShapeStroke.LineJoinType.Round.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f7724a = new int[ShapeStroke.LineCapType.values().length];
        try {
            f7724a[ShapeStroke.LineCapType.Butt.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7724a[ShapeStroke.LineCapType.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7724a[ShapeStroke.LineCapType.Unknown.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
