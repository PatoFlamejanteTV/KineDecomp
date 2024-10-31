package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.projectedit.LayerTransformTouchHandler;

/* compiled from: LayerTransformTouchHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wb */
/* loaded from: classes2.dex */
public /* synthetic */ class C2063wb {

    /* renamed from: a */
    static final /* synthetic */ int[] f22749a;

    /* renamed from: b */
    static final /* synthetic */ int[] f22750b = new int[LayerTransformTouchHandler.DragMode.values().length];

    static {
        try {
            f22750b[LayerTransformTouchHandler.DragMode.Split.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.Move.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.Rotate.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.Scale.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.CropNE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.CropNW.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.CropSE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f22750b[LayerTransformTouchHandler.DragMode.CropSW.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        f22749a = new int[SplitScreenType.values().length];
        try {
            f22749a[SplitScreenType.FULL.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f22749a[SplitScreenType.LEFT.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f22749a[SplitScreenType.BOTTOM.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f22749a[SplitScreenType.RIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f22749a[SplitScreenType.TOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
