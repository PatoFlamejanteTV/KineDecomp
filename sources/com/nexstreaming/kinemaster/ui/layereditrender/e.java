package com.nexstreaming.kinemaster.ui.layereditrender;

import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
public /* synthetic */ class e {

    /* renamed from: a */
    static final /* synthetic */ int[] f21635a;

    /* renamed from: b */
    static final /* synthetic */ int[] f21636b = new int[SplitScreenType.values().length];

    static {
        try {
            f21636b[SplitScreenType.FULL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21636b[SplitScreenType.LEFT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21636b[SplitScreenType.BOTTOM.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21636b[SplitScreenType.RIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21636b[SplitScreenType.TOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f21635a = new int[MarchingAnts.Feature.values().length];
        try {
            f21635a[MarchingAnts.Feature.ROTATE_HANDLE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f21635a[MarchingAnts.Feature.SIZE_HANDLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f21635a[MarchingAnts.Feature.SPLIT_HANDLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f21635a[MarchingAnts.Feature.CROP_HANDLES.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
