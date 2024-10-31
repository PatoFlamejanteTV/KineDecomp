package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.n */
/* loaded from: classes.dex */
public /* synthetic */ class C2322n {

    /* renamed from: a */
    static final /* synthetic */ int[] f24318a;

    /* renamed from: b */
    static final /* synthetic */ int[] f24319b = new int[ColorPickerPopup.ColorDetailsMode.values().length];

    static {
        try {
            f24319b[ColorPickerPopup.ColorDetailsMode.HSV.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24319b[ColorPickerPopup.ColorDetailsMode.RGB.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f24318a = new int[ColorPickerPopup.ColorTab.values().length];
        try {
            f24318a[ColorPickerPopup.ColorTab.Grid.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f24318a[ColorPickerPopup.ColorTab.Wheel.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f24318a[ColorPickerPopup.ColorTab.Sliders.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
