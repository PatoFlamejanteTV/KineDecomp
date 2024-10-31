package com.airbnb.lottie;

import com.airbnb.lottie.Layer;
import com.airbnb.lottie.Mask;

/* compiled from: BaseLayer.java */
/* renamed from: com.airbnb.lottie.x */
/* loaded from: classes.dex */
public /* synthetic */ class C0681x {

    /* renamed from: a */
    static final /* synthetic */ int[] f7837a;

    /* renamed from: b */
    static final /* synthetic */ int[] f7838b = new int[Mask.MaskMode.values().length];

    static {
        try {
            f7838b[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7838b[Mask.MaskMode.MaskModeAdd.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f7837a = new int[Layer.LayerType.values().length];
        try {
            f7837a[Layer.LayerType.Shape.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7837a[Layer.LayerType.PreComp.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7837a[Layer.LayerType.Solid.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7837a[Layer.LayerType.Image.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7837a[Layer.LayerType.Null.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f7837a[Layer.LayerType.Text.ordinal()] = 6;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f7837a[Layer.LayerType.Unknown.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
