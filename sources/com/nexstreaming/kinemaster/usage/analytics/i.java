package com.nexstreaming.kinemaster.usage.analytics;

import android.support.v4.app.Fragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.ui.assetbrowser.n;
import com.nexstreaming.kinemaster.ui.projectedit.C1899gc;
import com.nexstreaming.kinemaster.ui.projectedit.Je;
import com.nexstreaming.kinemaster.ui.projectedit.Kc;
import com.nexstreaming.kinemaster.ui.projectedit.Lc;
import com.nexstreaming.kinemaster.ui.projectedit.Mc;
import com.nexstreaming.kinemaster.ui.projectedit.Ng;
import com.nexstreaming.kinemaster.ui.projectedit.Xb;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioViewType;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.TypeCastException;

/* compiled from: OptionPropertyEventMaker.kt */
/* loaded from: classes2.dex */
public final class i {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(NexTimelineItem nexTimelineItem, Fragment fragment, ApplyBackEvent applyBackEvent) {
        LayerExpression layerExpression;
        ColorEffect colorEffect;
        String equalizer;
        kotlin.jvm.internal.h.b(applyBackEvent, "eventType");
        if (nexTimelineItem == 0 || fragment == null) {
            return;
        }
        String str = "video";
        String str2 = "unknown";
        if (fragment instanceof C1899gc) {
            if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                if (nexTimelineItem instanceof ImageLayer) {
                    str = MessengerShareContentUtility.MEDIA_IMAGE;
                } else if (!(nexTimelineItem instanceof VideoLayer)) {
                    str = "unknown";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("target", str);
                KMEvents.EDIT_SET_CHROMAKEY.logEvent(hashMap);
                return;
            }
            return;
        }
        if (fragment instanceof Xb) {
            if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                if (nexTimelineItem instanceof ImageLayer) {
                    str = MessengerShareContentUtility.MEDIA_IMAGE;
                } else if (!(nexTimelineItem instanceof VideoLayer)) {
                    if (nexTimelineItem instanceof AssetLayer) {
                        str = ((AssetLayer) nexTimelineItem).getLayerType() == AssetLayer.AssetLayerType.OVERLAY_LAYER ? "overlay" : "effect";
                    } else if (nexTimelineItem instanceof TextLayer) {
                        str = "text";
                    } else {
                        str = nexTimelineItem instanceof HandwritingLayer ? "handwrite" : "unknown";
                    }
                }
                String name = ((Xb) fragment).sa().name();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("name", name);
                hashMap2.put("target", str);
                KMEvents.EDIT_SET_BLENDING_MODE.logEvent(hashMap2);
                return;
            }
            return;
        }
        if (fragment instanceof w) {
            if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                NexTimelineItem.b bVar = (NexTimelineItem.b) nexTimelineItem;
                w wVar = (w) fragment;
                if (wVar.getViewType() == AudioViewType.VOICE_CHANGER) {
                    equalizer = bVar.getVoiceChanger();
                } else {
                    equalizer = bVar.getEqualizer();
                }
                if (nexTimelineItem instanceof NexVideoClipItem) {
                    str2 = "primary";
                } else if (nexTimelineItem instanceof NexAudioClipItem) {
                    str2 = ((NexAudioClipItem) nexTimelineItem).getIsVoiceRecording() ? "voice_layer" : "audio_layer";
                } else if (nexTimelineItem instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.f) {
                    str2 = "video_layer";
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("target", str2);
                if (equalizer == null) {
                    equalizer = "Normal";
                }
                hashMap3.put("name", equalizer);
                if (wVar.getViewType() == AudioViewType.VOICE_CHANGER) {
                    KMEvents.EDIT_SET_AUDIO_FILTER.logEvent(hashMap3);
                    return;
                } else {
                    if (wVar.getViewType() == AudioViewType.EQ) {
                        KMEvents.EDIT_SET_EQ.logEvent(hashMap3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (fragment instanceof Je) {
            if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                SplitScreenType splitScreenType = ((NexTimelineItem.t) nexTimelineItem).getSplitScreenType();
                HashMap hashMap4 = new HashMap();
                String name2 = splitScreenType.name();
                Locale locale = Locale.ENGLISH;
                kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
                if (name2 != null) {
                    String lowerCase = name2.toLowerCase(locale);
                    kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    hashMap4.put("type", lowerCase);
                    KMEvents.EDIT_SET_SPLIT_SCREEN.logEvent(hashMap4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return;
        }
        if (fragment instanceof n) {
            int i = h.f23918a[((n) fragment).wa().ordinal()];
            if (i == 1) {
                if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                    NexTimelineItem.l lVar = (NexTimelineItem.l) nexTimelineItem;
                    String a2 = a(lVar);
                    HashMap hashMap5 = new HashMap();
                    if (a2 != null) {
                        hashMap5.put("name", a2);
                    } else {
                        hashMap5.put("name", "unknown");
                    }
                    hashMap5.put("asset_id", String.valueOf(lVar.getEffectAssetIdx()));
                    KMEvents.EDIT_SET_CLIP_GRAPHICS.logEvent(hashMap5);
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            if (applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) {
                NexTimelineItem.l lVar2 = (NexTimelineItem.l) nexTimelineItem;
                String a3 = a(lVar2);
                HashMap hashMap6 = new HashMap();
                if (a3 != null) {
                    hashMap6.put("name", a3);
                } else {
                    hashMap6.put("name", "unknown");
                }
                hashMap6.put("asset_id", String.valueOf(lVar2.getEffectAssetIdx()));
                KMEvents.EDIT_SET_TRANSITION.logEvent(hashMap6);
                return;
            }
            return;
        }
        boolean z = fragment instanceof Kc;
        if (z || (fragment instanceof Lc) || (fragment instanceof Mc)) {
            NexLayerItem nexLayerItem = (NexLayerItem) nexTimelineItem;
            HashMap hashMap7 = new HashMap();
            if (z) {
                layerExpression = nexLayerItem.getLayerExpression(LayerExpression.Type.In);
                kotlin.jvm.internal.h.a((Object) layerExpression, "layerItem.getLayerExpres…(LayerExpression.Type.In)");
                hashMap7.put("type", "in-animation");
            } else if (fragment instanceof Lc) {
                layerExpression = nexLayerItem.getLayerExpression(LayerExpression.Type.Out);
                kotlin.jvm.internal.h.a((Object) layerExpression, "layerItem.getLayerExpres…LayerExpression.Type.Out)");
                hashMap7.put("type", "out-animation");
            } else if (fragment instanceof Mc) {
                layerExpression = nexLayerItem.getLayerExpression(LayerExpression.Type.Overall);
                kotlin.jvm.internal.h.a((Object) layerExpression, "layerItem.getLayerExpres…rExpression.Type.Overall)");
                hashMap7.put("type", "overall-animation");
            } else {
                layerExpression = nexLayerItem.getLayerExpression(LayerExpression.Type.None);
                kotlin.jvm.internal.h.a((Object) layerExpression, "layerItem.getLayerExpres…ayerExpression.Type.None)");
                hashMap7.put("type", NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE);
            }
            hashMap7.put("name", layerExpression.name());
            if (!(nexTimelineItem instanceof VideoLayer)) {
                if (nexTimelineItem instanceof ImageLayer) {
                    str = MessengerShareContentUtility.MEDIA_IMAGE;
                } else if (nexTimelineItem instanceof AssetLayer) {
                    str = ((AssetLayer) nexTimelineItem).getLayerType() == AssetLayer.AssetLayerType.OVERLAY_LAYER ? "overlay" : "effect";
                } else if (nexTimelineItem instanceof TextLayer) {
                    str = "text";
                } else {
                    str = nexTimelineItem instanceof HandwritingLayer ? "handwrite" : "unknown";
                }
            }
            hashMap7.put("target", str);
            KMEvents.EDIT_SET_ANIMATION.logEvent(hashMap7);
            return;
        }
        if (fragment instanceof Ng) {
            NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
            int playbackSpeed = nexVideoClipItem.getPlaybackSpeed();
            boolean muteAudio = nexVideoClipItem.getMuteAudio();
            boolean hasKeepPitch = nexVideoClipItem.hasKeepPitch();
            HashMap hashMap8 = new HashMap();
            hashMap8.put("speed", String.valueOf(playbackSpeed));
            String str3 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            hashMap8.put("mute_audio", muteAudio ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            if (!hasKeepPitch) {
                str3 = "false";
            }
            hashMap8.put("keep_pitch", str3);
            KMEvents.EDIT_SET_SPEED_CONTROL.logEvent(hashMap8);
            return;
        }
        if (fragment instanceof com.nexstreaming.kinemaster.ui.d.h) {
            if ((applyBackEvent == ApplyBackEvent.APPLY || applyBackEvent == ApplyBackEvent.BACK_TO || applyBackEvent == ApplyBackEvent.SYTEM_BACK) && (colorEffect = ((NexTimelineItem.h) nexTimelineItem).getColorEffect()) != null) {
                ColorEffect.FilterType filterType = colorEffect.getFilterType();
                String presetName = colorEffect.getPresetName();
                if (nexTimelineItem instanceof NexVideoClipItem) {
                    str2 = ((NexVideoClipItem) nexTimelineItem).isImage() ? "primary_image" : "primary_video";
                } else if (nexTimelineItem instanceof VideoLayer) {
                    str2 = "layer_video";
                } else if (nexTimelineItem instanceof ImageLayer) {
                    str2 = "layer_image";
                }
                if (filterType == null || presetName == null) {
                    return;
                }
                HashMap hashMap9 = new HashMap();
                String value = filterType.getValue();
                kotlin.jvm.internal.h.a((Object) value, "group.value");
                hashMap9.put("category", value);
                hashMap9.put("name", presetName);
                hashMap9.put("target", str2);
                KMEvents.EDIT_SET_COLOR_FILTER.logEvent(hashMap9);
            }
        }
    }

    public static final String a(NexTimelineItem.l lVar) {
        Map<String, String> label;
        kotlin.jvm.internal.h.b(lVar, "item");
        String effectItemID = lVar.getEffectItemID();
        if (effectItemID == null) {
            return NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
        Locale locale = Locale.US;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.US");
        if (effectItemID == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = effectItemID.toLowerCase(locale);
        kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (lowerCase.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            return NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
        r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(effectItemID);
        if (a2 == null || (label = a2.getLabel()) == null) {
            return null;
        }
        return label.get("en");
    }
}
