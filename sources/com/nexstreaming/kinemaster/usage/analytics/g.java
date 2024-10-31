package com.nexstreaming.kinemaster.usage.analytics;

import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.ui.projectedit.ReverseController;
import com.nextreaming.nexeditorui.NexAudioClipItem;

/* loaded from: classes2.dex */
public final /* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23914a = new int[NexAudioClipItem.AudioType.values().length];

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f23915b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f23916c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f23917d;

    static {
        f23914a[NexAudioClipItem.AudioType.VoiceRecording.ordinal()] = 1;
        f23914a[NexAudioClipItem.AudioType.PendingVoiceRecording.ordinal()] = 2;
        f23915b = new int[AssetLayer.AssetLayerType.values().length];
        f23915b[AssetLayer.AssetLayerType.EFFECT_LAYER.ordinal()] = 1;
        f23916c = new int[AssetLayer.AssetLayerType.values().length];
        f23916c[AssetLayer.AssetLayerType.EFFECT_LAYER.ordinal()] = 1;
        f23916c[AssetLayer.AssetLayerType.OVERLAY_LAYER.ordinal()] = 2;
        f23917d = new int[ReverseController.ReverseResult.values().length];
        f23917d[ReverseController.ReverseResult.RESULT_OK.ordinal()] = 1;
        f23917d[ReverseController.ReverseResult.RESULT_CANCEL.ordinal()] = 2;
    }
}
