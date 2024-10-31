package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.SplitScreenType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.ya, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public /* synthetic */ class C1778ya {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20378a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f20379b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f20380c = new int[NexLayerItem.DragType.values().length];

    static {
        try {
            f20380c[NexLayerItem.DragType.END.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20380c[NexLayerItem.DragType.START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f20379b = new int[LayerExpression.Type.values().length];
        try {
            f20379b[LayerExpression.Type.In.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20379b[LayerExpression.Type.Out.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20379b[LayerExpression.Type.Overall.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        f20378a = new int[SplitScreenType.values().length];
        try {
            f20378a[SplitScreenType.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f20378a[SplitScreenType.TOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f20378a[SplitScreenType.RIGHT.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f20378a[SplitScreenType.BOTTOM.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f20378a[SplitScreenType.FULL.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f20378a[SplitScreenType.OFF.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
