package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.compat.EffectAssetCompatMap;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: NexTimeline.java */
/* loaded from: classes.dex */
public /* synthetic */ class Pa {

    /* renamed from: a */
    static final /* synthetic */ int[] f24161a;

    /* renamed from: b */
    static final /* synthetic */ int[] f24162b = new int[KMProto.KMProject.ClipType.values().length];

    static {
        try {
            f24162b[KMProto.KMProject.ClipType.TRANSITION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.VISUAL_CLIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.AUDIO_CLIP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_HANDWRITING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_STICKER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_TEXT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_IMAGE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_EFFECT.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_ASSET.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_VIDEO.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f24162b[KMProto.KMProject.ClipType.LAYER_GROUP.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        f24161a = new int[EffectAssetCompatMap.CompatAction.values().length];
        try {
            f24161a[EffectAssetCompatMap.CompatAction.Delete.ordinal()] = 1;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f24161a[EffectAssetCompatMap.CompatAction.Substitute.ordinal()] = 2;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f24161a[EffectAssetCompatMap.CompatAction.None.ordinal()] = 3;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
