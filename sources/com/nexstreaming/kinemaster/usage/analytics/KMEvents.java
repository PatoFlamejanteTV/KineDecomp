package com.nexstreaming.kinemaster.usage.analytics;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.ui.projectedit.ReverseController;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.TypeCastException;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EXPORT_RESULT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: KMEvents.kt */
/* loaded from: classes.dex */
public final class KMEvents {
    private static final /* synthetic */ KMEvents[] $VALUES;
    public static final KMEvents ASSET_DETAILVIEW;
    public static final KMEvents ASSET_DETAIL_PREVIEW;
    public static final KMEvents ASSET_DETAIL_THUMBNAIL;
    public static final KMEvents ASSET_DOWNLOAD_RESULT;
    public static final KMEvents ASSET_MY_REMOVE;
    public static final KMEvents ASSET_SELECT_CATEGORY;
    public static final KMEvents ASSET_SELECT_SUBCATEGORY;
    public static final KMEvents BAIL_REPORT;
    public static final KMEvents CAPABILITY_CHECK_RESULT;
    public static final a Companion;
    public static final KMEvents DCI_ANALYSIS_POPUP;
    public static final KMEvents DCI_ANALYSIS_POPUP_CONFIRM;
    public static final KMEvents DCI_ANALYSIS_RESULT;
    public static final KMEvents DCI_ANALYSIS_START;
    public static final KMEvents DEVICE_INFO;
    public static final KMEvents EDIT_ADD_AUDIO;
    public static final KMEvents EDIT_ADD_LAYER;
    public static final KMEvents EDIT_ADD_MEDIA;
    public static final KMEvents EDIT_ADD_VOICE;
    public static final KMEvents EDIT_CUT;
    public static final KMEvents EDIT_REVERSE_VIDEO;
    public static final KMEvents EDIT_SET_ANIMATION;
    public static final KMEvents EDIT_SET_AUDIO_FILTER;
    public static final KMEvents EDIT_SET_BLENDING_MODE;
    public static final KMEvents EDIT_SET_CHROMAKEY;
    public static final KMEvents EDIT_SET_CLIP_GRAPHICS;
    public static final KMEvents EDIT_SET_COLOR_FILTER;
    public static final KMEvents EDIT_SET_EQ;
    public static final KMEvents EDIT_SET_FONT;
    public static final KMEvents EDIT_SET_FULLSCREEN;
    public static final KMEvents EDIT_SET_SPEED_CONTROL;
    public static final KMEvents EDIT_SET_SPLIT_SCREEN;
    public static final KMEvents EDIT_SET_TRANSITION;
    public static final KMEvents EDIT_TAKE_CAMCORDER;
    public static final KMEvents EDIT_TAKE_CAMERA;
    public static final KMEvents EMPTY_PURCHASE_SUBSCRIPTION;
    public static final String EVENT_PREFIX = "km4_";
    public static final KMEvents EXPORT_RESULT;
    public static final KMEvents HELP_EMAIL_SUPPORT;
    public static final KMEvents HELP_HELP;
    public static final KMEvents HELP_SNS;
    public static final KMEvents HELP_TUTORIAL_VIDEO;
    public static final KMEvents HELP_WEBSITE;
    public static final KMEvents HELP_WECHAT;
    public static final KMEvents HELP_WEIBO;
    public static final KMEvents LOAD_RECENTLY_PURCHASE_PARSING_ERROR;
    public static final KMEvents MAIN_HELP;
    public static final KMEvents MAIN_TIKTOK;
    public static final KMEvents MAIN_TIP;
    public static final KMEvents MAIN_WEIBO;
    public static final KMEvents MAIN_YOUTUBE;
    public static final KMEvents MAIN_YOUTUBE_REENTRY;
    public static final KMEvents NEED_MORE_FONT;
    public static final KMEvents PROJECT_NEW;
    public static final KMEvents PURCHASE_PRODUCT_CANCEL;
    public static final KMEvents PURCHASE_PRODUCT_FAIL;
    public static final KMEvents PURCHASE_PRODUCT_SUCCESS;
    public static final KMEvents SEVER_SUB_ERROR;
    public static final KMEvents SHARE_EXPORT_DELETE;
    public static final KMEvents SHARE_EXPORT_PREVIEW;
    public static final KMEvents SHARE_EXPORT_VIDEO;
    public static final KMEvents SHARE_VIDEO;
    public static final KMEvents SUBSCRIPTION_CANCEL;
    public static final KMEvents SUBSCRIPTION_CLICK_BUTTON;
    public static final KMEvents SUBSCRIPTION_GET_FIREBASE;
    public static final int TO_ALL = 1;
    public static final int TO_FABRIC = 4;
    public static final int TO_FIREBASE = 2;
    public static final int TO_UMENG = 8;
    public static final KMEvents TRACKING_CLIP_INFO_SYNC;
    public static final KMEvents UNLIMITED_LAYERS_ENABLE;
    public static final KMEvents USER_VERSION;
    public static final KMEvents VERSION_CHECK;
    public static final KMEvents VIEW_ASSET_DETAIL;
    public static final KMEvents VIEW_ASSET_STORE;
    public static final KMEvents VIEW_EDIT;
    public static final KMEvents VIEW_EXPORT_SHARE;
    public static final KMEvents VIEW_HELP;
    public static final KMEvents VIEW_MEDIA_BROWSER;
    public static final KMEvents VIEW_MY_ACCOUNT;
    public static final KMEvents VIEW_PROJECT_INFO;
    public static final KMEvents VIEW_PROJECT_LIST;
    public static final KMEvents VIEW_SETTINGS;
    public static final KMEvents VIEW_SUBSCRIPTION;
    private final Context context;
    private final int flag;

    /* compiled from: KMEvents.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        KMEvents kMEvents = new KMEvents("PROJECT_NEW", 0, 10);
        PROJECT_NEW = kMEvents;
        KMEvents kMEvents2 = new KMEvents("MAIN_TIP", 1, 10);
        MAIN_TIP = kMEvents2;
        KMEvents kMEvents3 = new KMEvents("MAIN_YOUTUBE", 2, 10);
        MAIN_YOUTUBE = kMEvents3;
        KMEvents kMEvents4 = new KMEvents("MAIN_YOUTUBE_REENTRY", 3, 10);
        MAIN_YOUTUBE_REENTRY = kMEvents4;
        KMEvents kMEvents5 = new KMEvents("MAIN_WEIBO", 4, 10);
        MAIN_WEIBO = kMEvents5;
        KMEvents kMEvents6 = new KMEvents("MAIN_HELP", 5, 10);
        MAIN_HELP = kMEvents6;
        KMEvents kMEvents7 = new KMEvents("MAIN_TIKTOK", 6, 10);
        MAIN_TIKTOK = kMEvents7;
        KMEvents kMEvents8 = new KMEvents("DCI_ANALYSIS_START", 7, 10);
        DCI_ANALYSIS_START = kMEvents8;
        KMEvents kMEvents9 = new KMEvents("DCI_ANALYSIS_RESULT", 8, 10);
        DCI_ANALYSIS_RESULT = kMEvents9;
        KMEvents kMEvents10 = new KMEvents("DCI_ANALYSIS_POPUP", 9, 10);
        DCI_ANALYSIS_POPUP = kMEvents10;
        KMEvents kMEvents11 = new KMEvents("DCI_ANALYSIS_POPUP_CONFIRM", 10, 10);
        DCI_ANALYSIS_POPUP_CONFIRM = kMEvents11;
        KMEvents kMEvents12 = new KMEvents("VIEW_PROJECT_LIST", 11, 2);
        VIEW_PROJECT_LIST = kMEvents12;
        KMEvents kMEvents13 = new KMEvents("VIEW_PROJECT_INFO", 12, 2);
        VIEW_PROJECT_INFO = kMEvents13;
        KMEvents kMEvents14 = new KMEvents("VIEW_EDIT", 13, 2);
        VIEW_EDIT = kMEvents14;
        KMEvents kMEvents15 = new KMEvents("VIEW_MEDIA_BROWSER", 14, 2);
        VIEW_MEDIA_BROWSER = kMEvents15;
        KMEvents kMEvents16 = new KMEvents("VIEW_EXPORT_SHARE", 15, 2);
        VIEW_EXPORT_SHARE = kMEvents16;
        KMEvents kMEvents17 = new KMEvents("VIEW_SUBSCRIPTION", 16, 2);
        VIEW_SUBSCRIPTION = kMEvents17;
        KMEvents kMEvents18 = new KMEvents("VIEW_ASSET_STORE", 17, 10);
        VIEW_ASSET_STORE = kMEvents18;
        KMEvents kMEvents19 = new KMEvents("VIEW_ASSET_DETAIL", 18, 2);
        VIEW_ASSET_DETAIL = kMEvents19;
        KMEvents kMEvents20 = new KMEvents("VIEW_SETTINGS", 19, 2);
        VIEW_SETTINGS = kMEvents20;
        KMEvents kMEvents21 = new KMEvents("VIEW_MY_ACCOUNT", 20, 2);
        VIEW_MY_ACCOUNT = kMEvents21;
        KMEvents kMEvents22 = new KMEvents("VIEW_HELP", 21, 2);
        VIEW_HELP = kMEvents22;
        KMEvents kMEvents23 = new KMEvents("SHARE_EXPORT_VIDEO", 22, 10);
        SHARE_EXPORT_VIDEO = kMEvents23;
        KMEvents kMEvents24 = new KMEvents("SHARE_VIDEO", 23, 10);
        SHARE_VIDEO = kMEvents24;
        KMEvents kMEvents25 = new KMEvents("SHARE_EXPORT_PREVIEW", 24, 10);
        SHARE_EXPORT_PREVIEW = kMEvents25;
        KMEvents kMEvents26 = new KMEvents("SHARE_EXPORT_DELETE", 25, 10);
        SHARE_EXPORT_DELETE = kMEvents26;
        int i = 0;
        int i2 = 1;
        kotlin.jvm.internal.f fVar = null;
        KMEvents kMEvents27 = new KMEvents("EXPORT_RESULT", 26, i, i2, fVar);
        EXPORT_RESULT = kMEvents27;
        KMEvents kMEvents28 = new KMEvents("HELP_HELP", 27, 10);
        HELP_HELP = kMEvents28;
        KMEvents kMEvents29 = new KMEvents("HELP_WEBSITE", 28, 10);
        HELP_WEBSITE = kMEvents29;
        KMEvents kMEvents30 = new KMEvents("HELP_EMAIL_SUPPORT", 29, 10);
        HELP_EMAIL_SUPPORT = kMEvents30;
        KMEvents kMEvents31 = new KMEvents("HELP_SNS", 30, 10);
        HELP_SNS = kMEvents31;
        KMEvents kMEvents32 = new KMEvents("HELP_WEIBO", 31, 10);
        HELP_WEIBO = kMEvents32;
        KMEvents kMEvents33 = new KMEvents("HELP_WECHAT", 32, 10);
        HELP_WECHAT = kMEvents33;
        KMEvents kMEvents34 = new KMEvents("HELP_TUTORIAL_VIDEO", 33, 10);
        HELP_TUTORIAL_VIDEO = kMEvents34;
        KMEvents kMEvents35 = new KMEvents("EDIT_ADD_MEDIA", 34, 10);
        EDIT_ADD_MEDIA = kMEvents35;
        KMEvents kMEvents36 = new KMEvents("EDIT_ADD_LAYER", 35, 10);
        EDIT_ADD_LAYER = kMEvents36;
        KMEvents kMEvents37 = new KMEvents("EDIT_ADD_AUDIO", 36, 10);
        EDIT_ADD_AUDIO = kMEvents37;
        KMEvents kMEvents38 = new KMEvents("EDIT_ADD_VOICE", 37, 10);
        EDIT_ADD_VOICE = kMEvents38;
        KMEvents kMEvents39 = new KMEvents("EDIT_TAKE_CAMERA", 38, 10);
        EDIT_TAKE_CAMERA = kMEvents39;
        KMEvents kMEvents40 = new KMEvents("EDIT_TAKE_CAMCORDER", 39, 10);
        EDIT_TAKE_CAMCORDER = kMEvents40;
        KMEvents kMEvents41 = new KMEvents("EDIT_SET_TRANSITION", 40, 10);
        EDIT_SET_TRANSITION = kMEvents41;
        KMEvents kMEvents42 = new KMEvents("EDIT_SET_BLENDING_MODE", 41, 10);
        EDIT_SET_BLENDING_MODE = kMEvents42;
        KMEvents kMEvents43 = new KMEvents("EDIT_SET_AUDIO_FILTER", 42, 10);
        EDIT_SET_AUDIO_FILTER = kMEvents43;
        KMEvents kMEvents44 = new KMEvents("EDIT_SET_EQ", 43, 10);
        EDIT_SET_EQ = kMEvents44;
        KMEvents kMEvents45 = new KMEvents("EDIT_SET_SPLIT_SCREEN", 44, 10);
        EDIT_SET_SPLIT_SCREEN = kMEvents45;
        KMEvents kMEvents46 = new KMEvents("EDIT_CUT", 45, 10);
        EDIT_CUT = kMEvents46;
        KMEvents kMEvents47 = new KMEvents("EDIT_SET_ANIMATION", 46, 10);
        EDIT_SET_ANIMATION = kMEvents47;
        KMEvents kMEvents48 = new KMEvents("EDIT_SET_CLIP_GRAPHICS", 47, 10);
        EDIT_SET_CLIP_GRAPHICS = kMEvents48;
        KMEvents kMEvents49 = new KMEvents("EDIT_SET_SPEED_CONTROL", 48, 10);
        EDIT_SET_SPEED_CONTROL = kMEvents49;
        KMEvents kMEvents50 = new KMEvents("EDIT_SET_FONT", 49, 10);
        EDIT_SET_FONT = kMEvents50;
        KMEvents kMEvents51 = new KMEvents("EDIT_SET_FULLSCREEN", 50, 10);
        EDIT_SET_FULLSCREEN = kMEvents51;
        KMEvents kMEvents52 = new KMEvents("EDIT_SET_COLOR_FILTER", 51, 10);
        EDIT_SET_COLOR_FILTER = kMEvents52;
        KMEvents kMEvents53 = new KMEvents("EDIT_REVERSE_VIDEO", 52, i, i2, fVar);
        EDIT_REVERSE_VIDEO = kMEvents53;
        KMEvents kMEvents54 = new KMEvents("EDIT_SET_CHROMAKEY", 53, 10);
        EDIT_SET_CHROMAKEY = kMEvents54;
        KMEvents kMEvents55 = new KMEvents("ASSET_SELECT_CATEGORY", 54, 10);
        ASSET_SELECT_CATEGORY = kMEvents55;
        KMEvents kMEvents56 = new KMEvents("ASSET_SELECT_SUBCATEGORY", 55, 10);
        ASSET_SELECT_SUBCATEGORY = kMEvents56;
        KMEvents kMEvents57 = new KMEvents("ASSET_DETAIL_THUMBNAIL", 56, 10);
        ASSET_DETAIL_THUMBNAIL = kMEvents57;
        KMEvents kMEvents58 = new KMEvents("ASSET_DETAILVIEW", 57, 10);
        ASSET_DETAILVIEW = kMEvents58;
        KMEvents kMEvents59 = new KMEvents("ASSET_DOWNLOAD_RESULT", 58, 10);
        ASSET_DOWNLOAD_RESULT = kMEvents59;
        KMEvents kMEvents60 = new KMEvents("ASSET_DETAIL_PREVIEW", 59, 10);
        ASSET_DETAIL_PREVIEW = kMEvents60;
        KMEvents kMEvents61 = new KMEvents("ASSET_MY_REMOVE", 60, 10);
        ASSET_MY_REMOVE = kMEvents61;
        KMEvents kMEvents62 = new KMEvents("PURCHASE_PRODUCT_SUCCESS", 61, 10);
        PURCHASE_PRODUCT_SUCCESS = kMEvents62;
        KMEvents kMEvents63 = new KMEvents("PURCHASE_PRODUCT_CANCEL", 62, 10);
        PURCHASE_PRODUCT_CANCEL = kMEvents63;
        KMEvents kMEvents64 = new KMEvents("PURCHASE_PRODUCT_FAIL", 63, 10);
        PURCHASE_PRODUCT_FAIL = kMEvents64;
        KMEvents kMEvents65 = new KMEvents("SUBSCRIPTION_CANCEL", 64, 10);
        SUBSCRIPTION_CANCEL = kMEvents65;
        KMEvents kMEvents66 = new KMEvents("SUBSCRIPTION_CLICK_BUTTON", 65, 10);
        SUBSCRIPTION_CLICK_BUTTON = kMEvents66;
        KMEvents kMEvents67 = new KMEvents("EMPTY_PURCHASE_SUBSCRIPTION", 66, 6);
        EMPTY_PURCHASE_SUBSCRIPTION = kMEvents67;
        KMEvents kMEvents68 = new KMEvents("LOAD_RECENTLY_PURCHASE_PARSING_ERROR", 67, 6);
        LOAD_RECENTLY_PURCHASE_PARSING_ERROR = kMEvents68;
        KMEvents kMEvents69 = new KMEvents("BAIL_REPORT", 68, 10);
        BAIL_REPORT = kMEvents69;
        int i3 = 0;
        int i4 = 1;
        kotlin.jvm.internal.f fVar2 = null;
        KMEvents kMEvents70 = new KMEvents("USER_VERSION", 69, i3, i4, fVar2);
        USER_VERSION = kMEvents70;
        KMEvents kMEvents71 = new KMEvents("SEVER_SUB_ERROR", 70, 6);
        SEVER_SUB_ERROR = kMEvents71;
        KMEvents kMEvents72 = new KMEvents("UNLIMITED_LAYERS_ENABLE", 71, i3, i4, fVar2);
        UNLIMITED_LAYERS_ENABLE = kMEvents72;
        KMEvents kMEvents73 = new KMEvents("DEVICE_INFO", 72, 2);
        DEVICE_INFO = kMEvents73;
        KMEvents kMEvents74 = new KMEvents("CAPABILITY_CHECK_RESULT", 73, 2);
        CAPABILITY_CHECK_RESULT = kMEvents74;
        KMEvents kMEvents75 = new KMEvents("SUBSCRIPTION_GET_FIREBASE", 74, 6);
        SUBSCRIPTION_GET_FIREBASE = kMEvents75;
        KMEvents kMEvents76 = new KMEvents("NEED_MORE_FONT", 75, 6);
        NEED_MORE_FONT = kMEvents76;
        KMEvents kMEvents77 = new KMEvents("TRACKING_CLIP_INFO_SYNC", 76, 6);
        TRACKING_CLIP_INFO_SYNC = kMEvents77;
        KMEvents kMEvents78 = new KMEvents("VERSION_CHECK", 77, 0, 1, null);
        VERSION_CHECK = kMEvents78;
        $VALUES = new KMEvents[]{kMEvents, kMEvents2, kMEvents3, kMEvents4, kMEvents5, kMEvents6, kMEvents7, kMEvents8, kMEvents9, kMEvents10, kMEvents11, kMEvents12, kMEvents13, kMEvents14, kMEvents15, kMEvents16, kMEvents17, kMEvents18, kMEvents19, kMEvents20, kMEvents21, kMEvents22, kMEvents23, kMEvents24, kMEvents25, kMEvents26, kMEvents27, kMEvents28, kMEvents29, kMEvents30, kMEvents31, kMEvents32, kMEvents33, kMEvents34, kMEvents35, kMEvents36, kMEvents37, kMEvents38, kMEvents39, kMEvents40, kMEvents41, kMEvents42, kMEvents43, kMEvents44, kMEvents45, kMEvents46, kMEvents47, kMEvents48, kMEvents49, kMEvents50, kMEvents51, kMEvents52, kMEvents53, kMEvents54, kMEvents55, kMEvents56, kMEvents57, kMEvents58, kMEvents59, kMEvents60, kMEvents61, kMEvents62, kMEvents63, kMEvents64, kMEvents65, kMEvents66, kMEvents67, kMEvents68, kMEvents69, kMEvents70, kMEvents71, kMEvents72, kMEvents73, kMEvents74, kMEvents75, kMEvents76, kMEvents77, kMEvents78};
        Companion = new a(null);
    }

    private KMEvents(String str, int i, int i2) {
        this.flag = i2;
        Context applicationContext = KineMasterApplication.f24058f.c().getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "KineMasterApplication.instance.applicationContext");
        this.context = applicationContext;
    }

    private final void a(NexTimeline nexTimeline, HashMap<String, String> hashMap) {
        int i;
        hashMap.put("project_duration", String.valueOf(nexTimeline.getTotalTime()));
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : nexTimeline.getPrimaryItems()) {
            boolean z = nexPrimaryTimelineItem instanceof NexVideoClipItem;
            if (z && ((NexVideoClipItem) nexPrimaryTimelineItem).isPreset()) {
                i3++;
            } else if (z && ((NexVideoClipItem) nexPrimaryTimelineItem).isImage()) {
                i5++;
            } else if (!(nexPrimaryTimelineItem instanceof NexTransitionItem)) {
                i4++;
            }
        }
        Iterator<NexSecondaryTimelineItem> it = nexTimeline.getSecondaryItems().iterator();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (it.hasNext()) {
            NexSecondaryTimelineItem next = it.next();
            Iterator<NexSecondaryTimelineItem> it2 = it;
            if (next instanceof NexAudioClipItem) {
                NexAudioClipItem.AudioType audioType = ((NexAudioClipItem) next).getAudioType();
                if (audioType != null && ((i = g.f23914a[audioType.ordinal()]) == 1 || i == 2)) {
                    i6++;
                } else {
                    i2++;
                }
            } else if (next instanceof TextLayer) {
                i12++;
            } else if (next instanceof ImageLayer) {
                if (((ImageLayer) next).isSolid()) {
                    i10++;
                } else {
                    i7++;
                }
            } else if (next instanceof VideoLayer) {
                i9++;
            } else if (next instanceof HandwritingLayer) {
                i13++;
            } else {
                if (!(next instanceof StickerLayer)) {
                    if (next instanceof AssetLayer) {
                        AssetLayer.AssetLayerType layerType = ((AssetLayer) next).getLayerType();
                        if (layerType != null && g.f23915b[layerType.ordinal()] == 1) {
                            i11++;
                        }
                    }
                }
                i8++;
            }
            it = it2;
        }
        hashMap.put("project_primary_video_count", String.valueOf(i4));
        hashMap.put("project_primary_image_count", String.valueOf(i5));
        hashMap.put("project_primary_solid_count", String.valueOf(i3));
        hashMap.put("project_audio_count", String.valueOf(i2));
        hashMap.put("project_voice_record_count", String.valueOf(i6));
        hashMap.put("project_image_layer_count", String.valueOf(i7));
        hashMap.put("project_overlay_layer_count", String.valueOf(i8));
        hashMap.put("project_video_layer_count", String.valueOf(i9));
        hashMap.put("project_solid_layer_count", String.valueOf(i10));
        hashMap.put("project_effect_layer_count", String.valueOf(i11));
        hashMap.put("project_text_layer_count", String.valueOf(i12));
        hashMap.put("project_handwrite_layer_count", String.valueOf(i13));
        hashMap.put("project_max_video_layer_count", String.valueOf(i4 + i9));
    }

    public static /* synthetic */ void trackExport$default(KMEvents kMEvents, NexTimeline nexTimeline, NexExportProfile nexExportProfile, File file, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            file = null;
        }
        kMEvents.trackExport(nexTimeline, nexExportProfile, file, str, str2, (i2 & 32) != 0 ? 0 : i);
    }

    public static KMEvents valueOf(String str) {
        return (KMEvents) Enum.valueOf(KMEvents.class, str);
    }

    public static KMEvents[] values() {
        return (KMEvents[]) $VALUES.clone();
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final void logEvent(String str) {
        kotlin.jvm.internal.h.b(str, "param");
        StringBuilder sb = new StringBuilder();
        sb.append(EVENT_PREFIX);
        String name = name();
        Locale locale = Locale.ENGLISH;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String sb2 = sb.toString();
            int i = this.flag;
            if ((i & 1) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(this.context, sb2, str);
                return;
            }
            if ((i & 2) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().c(this.context, sb2, str);
            }
            if ((this.flag & 4) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().b(this.context, sb2, str);
            }
            if ((this.flag & 8) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().d(this.context, sb2, str);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void logTiktokEvent() {
        int i = PreferenceManager.getDefaultSharedPreferences(this.context).getInt("visit_tiktok", 0) + 1;
        logEvent(String.valueOf(i));
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putInt("visit_tiktok", i).apply();
    }

    public final void logWeiboEvent() {
        int i = PreferenceManager.getDefaultSharedPreferences(this.context).getInt("visit_weibo", 0) + 1;
        logEvent(String.valueOf(i));
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putInt("visit_weibo", i).apply();
    }

    public final void logYoutubeEvent() {
        int i = PreferenceManager.getDefaultSharedPreferences(this.context).getInt("visit_youtube", 0) + 1;
        logEvent(String.valueOf(i));
        PreferenceManager.getDefaultSharedPreferences(this.context).edit().putInt("visit_youtube", i).apply();
    }

    public final void trackAddLayer(NexLayerItem nexLayerItem, String str) {
        kotlin.jvm.internal.h.b(nexLayerItem, "layerItem");
        kotlin.jvm.internal.h.b(str, "result");
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        if (nexLayerItem instanceof AssetLayer) {
            AssetLayer assetLayer = (AssetLayer) nexLayerItem;
            AssetLayer.AssetLayerType layerType = assetLayer.getLayerType();
            if (layerType != null) {
                int i = g.f23916c[layerType.ordinal()];
                if (i == 1) {
                    hashMap.put("type", "Effect");
                } else if (i == 2) {
                    hashMap.put("type", "Overlay");
                }
            }
            String a2 = i.a(assetLayer);
            if (a2 == null) {
                a2 = "unknown";
            }
            hashMap.put("name", a2);
            hashMap.put("asset_id", String.valueOf(assetLayer.getEffectAssetIdx()));
        } else if (nexLayerItem instanceof HandwritingLayer) {
            hashMap.put("type", "Handwrite");
            hashMap.put("name", "Handwrite");
        } else if (nexLayerItem instanceof TextLayer) {
            hashMap.put("type", "Text");
            hashMap.put("name", "Text");
        } else if (nexLayerItem instanceof VideoLayer) {
            hashMap.put("type", "Media");
            hashMap.put("name", "Video");
        } else if (nexLayerItem instanceof ImageLayer) {
            hashMap.put("type", "Media");
            hashMap.put("name", "Image");
        } else {
            Log.d("Event", "Unknown Layer " + nexLayerItem.getClass().getSimpleName());
        }
        logEvent(hashMap);
    }

    public final void trackEnterAssetStore(com.nexstreaming.kinemaster.usage.d dVar) {
        kotlin.jvm.internal.h.b(dVar, "entryData");
        HashMap hashMap = new HashMap();
        AssetStoreEntry c2 = dVar.c();
        kotlin.jvm.internal.h.a((Object) c2, "entryData.from");
        String value = c2.getValue();
        kotlin.jvm.internal.h.a((Object) value, "entryData.from.value");
        hashMap.put("entering_point", value);
        String b2 = dVar.b();
        if (b2 != null) {
            switch (b2.hashCode()) {
                case -303778277:
                    if (b2.equals("ClipGraphics")) {
                        hashMap.put("entering_point", "Clip Graphics");
                        break;
                    }
                    break;
                case 2195567:
                    if (b2.equals("Font")) {
                        hashMap.put("entering_point", "Font");
                        break;
                    }
                    break;
                case 63613878:
                    if (b2.equals("Audio")) {
                        hashMap.put("entering_point", "Music");
                        break;
                    }
                    break;
                case 269306229:
                    if (b2.equals("Transition")) {
                        hashMap.put("entering_point", "Transition");
                        break;
                    }
                    break;
                case 573365296:
                    if (b2.equals("Overlay")) {
                        hashMap.put("entering_point", "Overlay");
                        break;
                    }
                    break;
                case 2072749489:
                    if (b2.equals("Effect")) {
                        hashMap.put("entering_point", "Effect");
                        break;
                    }
                    break;
            }
        }
        logEvent(hashMap);
    }

    public final void trackExport(NexTimeline nexTimeline, NexExportProfile nexExportProfile, File file, String str, String str2, int i) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (file != null) {
            hashMap.put("export_file_size", String.valueOf(file.length()));
        }
        if (nexExportProfile != null) {
            hashMap.put("export_resolution", c.d.b.m.g.a(nexExportProfile.width(), nexExportProfile.height()));
        }
        String num = Integer.toString(i);
        kotlin.jvm.internal.h.a((Object) num, "Integer.toString(elapsedExportTime)");
        hashMap.put("export_elapsed_time", num);
        if (str2 != null && str != null && kotlin.jvm.internal.h.a((Object) str, (Object) AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED)) {
            hashMap.put("result", str2);
        } else if (str != null) {
            hashMap.put("result", str);
        }
        if (nexTimeline == null) {
            return;
        }
        a(nexTimeline, hashMap);
        logEvent(hashMap);
    }

    public final void trackReverse(String str, int i, int i2, ReverseController.ReverseResult reverseResult) {
        kotlin.jvm.internal.h.b(str, "itemType");
        kotlin.jvm.internal.h.b(reverseResult, "result");
        HashMap hashMap = new HashMap();
        hashMap.put("target", str);
        hashMap.put("clip_duration", String.valueOf(i));
        hashMap.put("convert_time", String.valueOf(i2));
        int i3 = g.f23917d[reverseResult.ordinal()];
        if (i3 == 1) {
            hashMap.put("result", GraphResponse.SUCCESS_KEY);
        } else if (i3 != 2) {
            hashMap.put("result", "fail_convert");
        } else {
            hashMap.put("result", "cancel_convert");
        }
        logEvent(hashMap);
    }

    public final void trackScreen(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append(EVENT_PREFIX);
        String name = name();
        Locale locale = Locale.ENGLISH;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String sb2 = sb.toString();
            if (activity == null || (this.flag & 2) == 0) {
                return;
            }
            FirebaseAnalytics.getInstance(this.context).setCurrentScreen(activity, sb2, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* synthetic */ KMEvents(String str, int i, int i2, int i3, kotlin.jvm.internal.f fVar) {
        this(str, i, (i3 & 1) != 0 ? 1 : i2);
    }

    public final void logEvent(Map<String, String> map) {
        kotlin.jvm.internal.h.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        StringBuilder sb = new StringBuilder();
        sb.append(EVENT_PREFIX);
        String name = name();
        Locale locale = Locale.ENGLISH;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String sb2 = sb.toString();
            int i = this.flag;
            if ((i & 1) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(this.context, sb2, map);
                return;
            }
            if ((i & 2) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().c(this.context, sb2, map);
            }
            if ((this.flag & 4) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().b(this.context, sb2, map);
            }
            if ((this.flag & 8) != 0) {
                com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().e(this.context, sb2, map);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void trackReverse(String str) {
        kotlin.jvm.internal.h.b(str, "reason");
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        logEvent(hashMap);
    }
}
