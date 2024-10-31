package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.mixpanel.android.mpmetrics.n;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.MediaLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.CodecType;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Character;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public enum KMUsage {
    Activity_ProjectList,
    Activity_EditScreen,
    Activity_GettingStarted,
    Activity_Share,
    Activity_ShareChooseQuality,
    Activity_ShareDetails,
    Activity_Subscription,
    Activity_Camcording,
    Activity_CamcorderPreview,
    Activity_PreviewPlay,
    Activity_Settings,
    Activity_Help,
    BailReport,
    DeviceInfo,
    Share_SelectTarget,
    Share_StartExport_ProjStatsA_SUB(1),
    Share_StartExport_ProjStatsB_SUB(1),
    Share_StartExport_ProjStatsA_NOSUB(1),
    Share_StartExport_ProjStatsB_NOSUB(1),
    Share_ExportResult,
    Share_LaunchSNSShare,
    Share_Upload_Start,
    Share_Upload_Finish,
    ProjectList_ProjectDetails,
    ProjectList_DeleteProject,
    ProjectList_RenameProject,
    ProjectList_EditProject,
    ProjectList_NewProject,
    ProjectList_TipTapped,
    EditScreen_AddLayer,
    EditScreen_AddButton,
    EditScreen_RecButton,
    EditScreen_PreviewPlay,
    EditScreen_Clip_Added,
    EditScreen_Clip_Deleted,
    EditScreen_Timeline_PinchZoom,
    EditScreen_Bookmark,
    EditScreen_OnStop,
    EditScreen_OnStop_ProjStatsA_SUB(1),
    EditScreen_OnStop_ProjStatsB_SUB(1),
    EditScreen_OnStop_ProjStatsA_NOSUB(1),
    EditScreen_OnStop_ProjStatsB_NOSUB(1),
    EditScreen_ActionButton,
    EditScreen_OverflowAction,
    EditScreen_CaptureAction,
    EditScreen_ProjectSettings,
    EditScreen_SelectClip,
    EditScreen_FlipRotate,
    EditScreen_AdjustVolume,
    EditScreen_AdjustBGMVolume,
    EditScreen_SpeedControl,
    EditScreen_ColorTint,
    EditScreen_ColorAdj_Brightness,
    EditScreen_ColorAdj_Contrast,
    EditScreen_ColorAdj_Saturation,
    EditScreen_InAnimation,
    EditScreen_OutAnimation,
    EditScreen_OverallAnimation,
    EditScreen_Option_Tap,
    EditScreen_Adjust_Alpha,
    EditScreen_TransitionDuration,
    EditScreen_Transition,
    EditScreen_TransitionParam,
    EditScreen_VolumeEnvelope,
    EditScreen_Cropping,
    EditScreen_ClipEffect,
    EditScreen_ClipEffectParam,
    EditScreen_Visual_DragToTrim,
    EditScreen_Handwriting_Stroke,
    EditScreen_Handwriting_Action,
    EditScreen_Animation_Action,
    EditScreen_Sticker_Select,
    EditScreen_Timeline_MoveVisualClip,
    EditScreen_Timeline_MoveSecondaryClip,
    EditScreen_Theme_Confirm,
    FontBrowser_SelectFont,
    ColorPicker_ApplyColor,
    MediaBrowser_EnterFolder,
    MediaBrowser_ShowDetails,
    MediaBrowser_DetailAction,
    MediaBrowser_Filter,
    AudioBrowser_ChooseCategory,
    AudioBrowser_PreviewPlay,
    AudioBrowser_AddOrSelect,
    GetStarted_Finish,
    GetStarted_Step,
    PurchaseFlowComplete,
    PurchaseButtonClick,
    Theme_Download,
    Theme_Uninstall,
    MediaDownload_Start,
    MediaDownload_Result,
    Transcode_Start,
    Transcode_Result,
    Settings_Tap_Option,
    Settings_Default_PhotoDuration,
    Settings_Default_PhotoCropping,
    Settings_About_KineMaster,
    Camcorder_StartRecord,
    Camcorder_Result,
    Support_Email,
    DiagnosticA,
    DiagnosticB,
    Rate_Like_KM,
    Rate_Report,
    Rate_Review,
    Updated_Wrong_MODIFIED_DATE_DB,
    Purchase_Plan,
    Purchase_Store,
    InApp_Bad_SKU_Type,
    Download_Store,
    Show_WeChat_Promotion,
    WeChat_Promotion_Button,
    Media_Indexing_Start,
    Media_Indexing_End;

    private static final String EVENT_PREFIX = "KM3_";
    private static final boolean LOG_PARAMS = true;
    private static final String LOG_TAG = "KMUsage";
    private static final boolean USE_FLURRY = true;
    private final int mFlags;
    public static final KMUsage GetCachedPurchaseType = DiagnosticA;
    public static final KMUsage FailToGetPurchaseType = DiagnosticB;
    private static boolean didMixpanelPeopleProps = false;
    private static boolean didMixpanelStartup = false;
    private static boolean didMixpanelIdentify = false;

    KMUsage() {
        this.mFlags = 3;
    }

    KMUsage(int i) {
        this.mFlags = i;
    }

    public static void onStart(Context context) {
        com.flurry.a.a.b(true);
        com.flurry.a.a.a(true);
        com.flurry.a.a.a(context, "JP3SX25DKCXTXY7YV6GV");
    }

    public static void onStop(Context context) {
        com.flurry.a.a.a(context);
    }

    public static String bucketParam0to300(int i) {
        if (i == 0) {
            return "A. 0";
        }
        if (i < 25) {
            return "B. 1~24";
        }
        if (i == 25) {
            return "C. 25";
        }
        if (i <= 50) {
            return "D. 26~50";
        }
        if (i <= 75) {
            return "E. 51~75";
        }
        if (i < 100) {
            return "F. 76~99";
        }
        if (i == 100) {
            return "G. 100";
        }
        if (i <= 125) {
            return "H. 101~125";
        }
        if (i <= 150) {
            return "I. 126~150";
        }
        if (i <= 175) {
            return "J. 151~175";
        }
        if (i <= 200) {
            return "K. 176~200";
        }
        if (i <= 250) {
            return "L. 201~250";
        }
        if (i < 300) {
            return "M. 251~299";
        }
        return "N. >=300";
    }

    public static String bucketParamProjectTime(int i) {
        if (i < 1000) {
            return "A. <1s";
        }
        if (i <= 15000) {
            return "B. 1~15s";
        }
        if (i <= 30000) {
            return "C. 16~30s";
        }
        if (i <= 45000) {
            return "D. 31~45s";
        }
        if (i <= 60000) {
            return "E. 45~60s";
        }
        if (i < 90000) {
            return "F. 1~1.5m";
        }
        if (i == 120000) {
            return "G. 1.5~2m";
        }
        if (i <= 300000) {
            return "H. 2~5m";
        }
        if (i <= 600000) {
            return "I. 5~10m";
        }
        if (i <= 900000) {
            return "J. 10~15m";
        }
        if (i <= 1800000) {
            return "K. 15~30m";
        }
        if (i <= 3600000) {
            return "L. 30~60m";
        }
        if (i < 7200000) {
            return "M. 1~2h";
        }
        return "N. >2h";
    }

    public static String bucketParam0to200(int i) {
        if (i == 0) {
            return "A. 0";
        }
        if (i <= 33) {
            return "B. 1~33";
        }
        if (i <= 66) {
            return "C. 34~66";
        }
        if (i < 100) {
            return "D. 66~99";
        }
        if (i == 100) {
            return "E. 100";
        }
        if (i <= 133) {
            return "F. 101~133";
        }
        if (i <= 166) {
            return "G. 134~166";
        }
        if (i < 200) {
            return "H. 167~199";
        }
        return "I. >=200";
    }

    public static String bucketParam0to100(int i) {
        if (i <= 0) {
            return "A. <=0";
        }
        if (i <= 10) {
            return "B. 1~10";
        }
        if (i <= 20) {
            return "C. 11~20";
        }
        if (i <= 30) {
            return "D. 21~30";
        }
        if (i <= 40) {
            return "E. 31~40";
        }
        if (i <= 50) {
            return "F. 41~50";
        }
        if (i <= 60) {
            return "G. 51~60";
        }
        if (i <= 70) {
            return "H. 61~70";
        }
        if (i <= 80) {
            return "I. 71~80";
        }
        if (i <= 90) {
            return "J. 81~90";
        }
        if (i < 100) {
            return "K. 91~100";
        }
        return "L. >=100";
    }

    public static String bucketParamPlusMinus100(int i) {
        if (i == -100) {
            return "A. -100";
        }
        if (i <= -66) {
            return "B. -99 ~ -66";
        }
        if (i <= -33) {
            return "C. -65 ~ -33";
        }
        if (i < 0) {
            return "D. -32 ~ -1";
        }
        if (i == 0) {
            return "E. 0";
        }
        if (i <= 33) {
            return "F. 1~33";
        }
        if (i <= 66) {
            return "G. 34~66";
        }
        if (i < 100) {
            return "H. 66~99";
        }
        return "I. >=100";
    }

    public void logEvent() {
        com.flurry.a.a.a(EVENT_PREFIX + name());
    }

    public static IWXAPI getWXAPIInstance(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, null);
        createWXAPI.registerApp(context.getString(R.string.wx_app_id));
        return createWXAPI;
    }

    public static n getMixpanelInstanceFromContext(Context context) {
        n a2 = n.a(context == null ? KineMasterApplication.a().getApplicationContext() : context, "ad44e739cabc97d99e869baeba34b8bd");
        if (!didMixpanelStartup && context != null) {
            try {
                a(a2, context);
            } catch (JSONException e) {
                Log.w(LOG_TAG, "MixPanel reporting error", e);
            }
            didMixpanelStartup = true;
        }
        return a2;
    }

    public static void trackAddMedia(Context context, boolean z, String str, NexTimelineItem nexTimelineItem) {
        String str2;
        String mediaPath;
        try {
            n mixpanelInstanceFromContext = getMixpanelInstanceFromContext(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Origination", z ? "Assistant" : "Project");
            jSONObject.put("Class", nexTimelineItem.getClass().getSimpleName());
            String str3 = null;
            MSID mediaMSID = nexTimelineItem.getMediaMSID();
            if (nexTimelineItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
                if (nexVideoClipItem.isPreset()) {
                    if (str != null) {
                        mediaPath = null;
                    } else {
                        str = "Solid";
                        mediaPath = null;
                    }
                } else {
                    mediaPath = nexVideoClipItem.getMediaPath();
                }
                str3 = mediaPath;
                str2 = str;
            } else if (nexTimelineItem instanceof MediaLayer) {
                str3 = ((MediaLayer) nexTimelineItem).getMediaPath();
                if (nexTimelineItem instanceof VideoLayer) {
                    if (str == null) {
                        str = "Video Layer";
                    }
                } else if ((nexTimelineItem instanceof ImageLayer) && str == null) {
                    str = "Image Layer";
                }
                str2 = str;
            } else if (nexTimelineItem instanceof NexAudioClipItem) {
                str3 = ((NexAudioClipItem) nexTimelineItem).getMediaPath();
                if (str == null) {
                    str = "Audio";
                }
                str2 = str;
            } else if (nexTimelineItem instanceof StickerLayer) {
                jSONObject.put("Sticker Id", ((StickerLayer) nexTimelineItem).getSticker().f(context));
                if (str == null) {
                    str = "Sticker Layer";
                }
                str2 = str;
            } else if (nexTimelineItem instanceof TextLayer) {
                TextLayer textLayer = (TextLayer) nexTimelineItem;
                String text = textLayer.getText();
                int length = text.length();
                jSONObject.put("Text Font", textLayer.getFontId());
                jSONObject.put("Text Length", length);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < length; i++) {
                    hashSet.add(Character.UnicodeBlock.of(text.charAt(i)));
                }
                JSONArray jSONArray = new JSONArray();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((Character.UnicodeBlock) it.next()).toString());
                }
                jSONObject.put("Text Unicode Blocks", jSONArray);
                if (str == null) {
                    str = "Text Layer";
                }
                str2 = str;
            } else {
                str2 = ((nexTimelineItem instanceof HandwritingLayer) && str == null) ? "Handwriting Layer" : str;
            }
            if (str2 == null) {
                str2 = nexTimelineItem.getClass().getSimpleName();
            }
            jSONObject.put("Type", str2);
            if (nexTimelineItem instanceof NexLayerItem) {
                Character.UnicodeBlock.of('A');
            }
            if (str3 != null) {
                jSONObject.put("File Size", new File(str3).length());
                MediaInfo a2 = MediaInfo.a(new File(str3));
                if (a2 != null) {
                    if (a2.t() || a2.s()) {
                        jSONObject.put("Width", a2.w());
                        jSONObject.put("Height", a2.x());
                        jSONObject.put("Orientation", a2.C());
                    }
                    if (a2.r() || a2.s()) {
                        jSONObject.put("Duration", a2.y());
                    }
                    if (a2.r()) {
                        CodecType K = a2.K();
                        jSONObject.put("Audio Codec", K == null ? "?" : K.f3481a);
                        jSONObject.put("Audio Bitrate", a2.G());
                        jSONObject.put("Audio Channels", a2.I());
                        jSONObject.put("Audio Duration", a2.z());
                        jSONObject.put("Audio Sample Rate", a2.H());
                    }
                    if (a2.s()) {
                        CodecType J = a2.J();
                        jSONObject.put("Video Codec", J == null ? "?" : J.f3481a);
                        jSONObject.put("Video H264 Level", a2.E());
                        jSONObject.put("Video H264 Profile", a2.D());
                        jSONObject.put("Video Bitrate", a2.F());
                        jSONObject.put("Video Duration", a2.A());
                        jSONObject.put("Video IDR Count", a2.j());
                        jSONObject.put("Video IDR Interval", a2.y() / Math.max(1, a2.j()));
                        jSONObject.put("Video FPS", a2.B());
                    }
                }
            }
            if (mediaMSID != null) {
                jSONObject.put("Namespace", mediaMSID.getGenericNamespace());
            }
            mixpanelInstanceFromContext.a("Add Media", jSONObject);
        } catch (JSONException e) {
            Log.w(LOG_TAG, "MixPanel reporting error", e);
        }
    }

    public static n getMixpanelInstance(Activity activity) {
        return getMixpanelInstanceFromContext(activity);
    }

    public static String getISODateTimeUTC() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US).format(new Date());
    }

    public static n.c getMixpanelPeople(Context context) {
        return getMixpanelPeople(getMixpanelInstanceFromContext(context), context);
    }

    public static n.c getMixpanelPeople(n nVar, Context context) {
        Locale locale;
        Scanner scanner;
        Throwable th;
        String str = null;
        n.c c = nVar.c();
        if (!didMixpanelIdentify) {
            try {
                scanner = new Scanner(new File(EditorGlobal.g(), "mixpanel_name.txt"));
                try {
                    str = scanner.useDelimiter("\\Z").next();
                    if (scanner != null) {
                        scanner.close();
                    }
                } catch (FileNotFoundException e) {
                    if (scanner != null) {
                        scanner.close();
                    }
                    c.a(nVar.b());
                    c.b("529925300807");
                    if (str != null) {
                    }
                    c.a("$first_name", "Anon_" + nVar.b());
                    didMixpanelIdentify = true;
                    if (!didMixpanelPeopleProps) {
                        locale = context.getResources().getConfiguration().locale;
                        c.a("Last Activated", getISODateTimeUTC());
                        if (locale.getCountry() != null) {
                        }
                        c.a("Language", locale.getLanguage());
                        didMixpanelPeopleProps = true;
                    }
                    return c;
                } catch (Throwable th2) {
                    th = th2;
                    if (scanner != null) {
                        scanner.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                scanner = null;
            } catch (Throwable th3) {
                scanner = null;
                th = th3;
            }
            c.a(nVar.b());
            c.b("529925300807");
            if (str != null || str.trim().length() <= 0) {
                c.a("$first_name", "Anon_" + nVar.b());
            } else {
                c.a("$first_name", str);
            }
            didMixpanelIdentify = true;
        }
        if (!didMixpanelPeopleProps && context != null) {
            locale = context.getResources().getConfiguration().locale;
            c.a("Last Activated", getISODateTimeUTC());
            if (locale.getCountry() != null || locale.getCountry().length() <= 0) {
                c.a("Language", locale.getLanguage());
            } else {
                c.a("Language", locale.getLanguage() + "-" + locale.getCountry());
            }
            didMixpanelPeopleProps = true;
        }
        return c;
    }

    private static void a(n nVar, Context context) throws JSONException {
        JSONObject put = new JSONObject().put("Di Board", Build.BOARD).put("Di Board Platform", KineMasterApplication.b()).put("App Installed By", context.getPackageManager().getInstallerPackageName(context.getPackageName()));
        nVar.a(put);
        getMixpanelPeople(nVar, null).a(put);
    }

    public void logEvent(String... strArr) {
        if (strArr == null || strArr.length < 2) {
            com.flurry.a.a.a(EVENT_PREFIX + name());
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length / 2; i++) {
            hashMap.put(strArr[i * 2], strArr[(i * 2) + 1]);
        }
        com.flurry.a.a.a(EVENT_PREFIX + name(), hashMap);
    }

    public void logEvent(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
        }
        com.flurry.a.a.a(EVENT_PREFIX + name(), map);
    }

    public void logEvent(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
        }
        com.flurry.a.a.a(EVENT_PREFIX + name(), hashMap);
    }

    public void begin() {
        com.flurry.a.a.a(EVENT_PREFIX + name(), true);
    }

    public void begin(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
        }
        com.flurry.a.a.a(EVENT_PREFIX + name(), map, true);
    }

    public void begin(String... strArr) {
        if (strArr == null || strArr.length < 2) {
            com.flurry.a.a.a(EVENT_PREFIX + name(), true);
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length / 2; i++) {
            hashMap.put(strArr[i * 2], strArr[(i * 2) + 1]);
        }
        com.flurry.a.a.a(EVENT_PREFIX + name(), (Map<String, String>) hashMap, true);
    }

    public void end() {
        com.flurry.a.a.b(EVENT_PREFIX + name());
    }

    public void end(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
        }
        com.flurry.a.a.b(EVENT_PREFIX + name(), map);
    }

    public void end(String... strArr) {
        if (strArr == null || strArr.length < 2) {
            com.flurry.a.a.b(EVENT_PREFIX + name());
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length / 2; i++) {
            hashMap.put(strArr[i * 2], strArr[(i * 2) + 1]);
        }
        com.flurry.a.a.b(EVENT_PREFIX + name(), hashMap);
    }

    public static void logProjectStats(NexTimeline nexTimeline, KMUsage kMUsage, KMUsage kMUsage2, KMUsage kMUsage3, KMUsage kMUsage4, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if (nexTimeline != null) {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int primaryItemCount = nexTimeline.getPrimaryItemCount();
            int i25 = 0;
            while (i25 < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i25);
                if (primaryItem instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    if (nexVideoClipItem.isPreset()) {
                        int i26 = i15;
                        i11 = i14;
                        i12 = i13 + 1;
                        i10 = i26;
                    } else if (nexVideoClipItem.isImage()) {
                        i10 = i15 + 1;
                        i11 = i14;
                        i12 = i13;
                    } else {
                        int i27 = i14 + 1;
                        i12 = i13;
                        i10 = i15;
                        i11 = i27;
                    }
                } else {
                    i10 = i15;
                    i11 = i14;
                    i12 = i13;
                }
                i25++;
                i13 = i12;
                i14 = i11;
                i15 = i10;
            }
            int secondaryItemCount = nexTimeline.getSecondaryItemCount();
            int i28 = 0;
            while (i28 < secondaryItemCount) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i28);
                if (secondaryItem instanceof NexAudioClipItem) {
                    switch (((NexAudioClipItem) secondaryItem).getAudioType()) {
                        case BackgroundAudio:
                            int i29 = i24;
                            i7 = i23;
                            i8 = i22;
                            i9 = i21 + 1;
                            i6 = i29;
                            break;
                        case ExtractedAudio:
                            int i30 = i22 + 1;
                            i9 = i21;
                            int i31 = i23;
                            i8 = i30;
                            i6 = i24;
                            i7 = i31;
                            break;
                        case Music:
                            int i32 = i23 + 1;
                            i8 = i22;
                            i9 = i21;
                            int i33 = i24;
                            i7 = i32;
                            i6 = i33;
                            break;
                        case VoiceRecording:
                        case PendingVoiceRecording:
                            i6 = i24 + 1;
                            i7 = i23;
                            i8 = i22;
                            i9 = i21;
                            break;
                        default:
                            i6 = i24;
                            i7 = i23;
                            i8 = i22;
                            i9 = i21;
                            break;
                    }
                    i21 = i9;
                    i22 = i8;
                    i23 = i7;
                    i24 = i6;
                    i = i20;
                    i2 = i19;
                    i3 = i18;
                    i4 = i17;
                    i5 = i16;
                } else if (secondaryItem instanceof TextLayer) {
                    int i34 = i20;
                    i2 = i19;
                    i3 = i18;
                    i4 = i17;
                    i5 = i16 + 1;
                    i = i34;
                } else if (secondaryItem instanceof StickerLayer) {
                    int i35 = i17 + 1;
                    i5 = i16;
                    int i36 = i19;
                    i3 = i18;
                    i4 = i35;
                    i = i20;
                    i2 = i36;
                } else if (secondaryItem instanceof ImageLayer) {
                    int i37 = i18 + 1;
                    i4 = i17;
                    i5 = i16;
                    i = i20;
                    i2 = i19;
                    i3 = i37;
                } else if (secondaryItem instanceof VideoLayer) {
                    int i38 = i19 + 1;
                    i3 = i18;
                    i4 = i17;
                    i5 = i16;
                    i = i20;
                    i2 = i38;
                } else if (secondaryItem instanceof HandwritingLayer) {
                    i = i20 + 1;
                    i2 = i19;
                    i3 = i18;
                    i4 = i17;
                    i5 = i16;
                } else {
                    i = i20;
                    i2 = i19;
                    i3 = i18;
                    i4 = i17;
                    i5 = i16;
                }
                i28++;
                i16 = i5;
                i17 = i4;
                i18 = i3;
                i19 = i2;
                i20 = i;
            }
            if (!z) {
                kMUsage3 = kMUsage;
            }
            if (!z) {
                kMUsage4 = kMUsage2;
            }
            kMUsage3.logEvent("ProjectDuration", bucketParamProjectTime(nexTimeline.getTotalTime()), "Solid", bucketParam0to100(i13), "Video", bucketParam0to100(i14), "Image", bucketParam0to100(i15), "TextLayer", bucketParam0to100(i16), "StickerLayer", bucketParam0to100(i17), "ImageLayer", bucketParam0to100(i18), "VideoLayer", bucketParam0to100(i19), "HandwritingLayer", bucketParam0to100(i20), "AudioTrackTotal", bucketParam0to100(i21 + i22 + i23 + i24));
            kMUsage4.logEvent("AudioTrackTotal", bucketParam0to100(i21 + i22 + i23 + i24), "BackgroundAudio", bucketParam0to100(i21), "ExtractedAudio", bucketParam0to100(i22), "Music", bucketParam0to100(i23), "VoiceRecording", bucketParam0to100(i24));
        }
    }

    public static JSONArray makeJsonArray(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(String.valueOf(it.next()));
        }
        return jSONArray;
    }

    public static void timeEvent(Context context, String str) {
        getMixpanelInstanceFromContext(context).a(str);
    }

    public static void trackMixpanelProjectEvent(Context context, NexTimeline nexTimeline, String str, JSONObject jSONObject) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        LayerExpression layerExpression;
        int i6;
        int i7;
        int i8;
        int i9;
        String transitionEffectID;
        int i10;
        int i11;
        int i12;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nexTimeline != null) {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int primaryItemCount = nexTimeline.getPrimaryItemCount();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            HashSet hashSet7 = new HashSet();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int i16 = 0;
            while (i16 < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i16);
                boolean isOptionApplied = primaryItem.isOptionApplied(R.id.opt_volume_env) | z2;
                boolean isOptionApplied2 = primaryItem.isOptionApplied(R.id.opt_volume) | z8;
                z3 |= primaryItem.isOptionApplied(R.id.opt_audio_effect);
                z4 |= primaryItem.isOptionApplied(R.id.opt_rotate);
                z5 |= primaryItem.isOptionApplied(R.id.opt_color_adj);
                z6 |= primaryItem.isOptionApplied(R.id.opt_split_trim);
                z7 |= primaryItem.isOptionApplied(R.id.opt_speed_control);
                if (primaryItem instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    ColorEffect colorEffect = nexVideoClipItem.getColorEffect();
                    if (colorEffect != null && colorEffect.getPresetName() != null) {
                        hashSet2.add(colorEffect.getPresetName());
                    }
                    String effectID = nexVideoClipItem.getEffectID();
                    if (effectID != null && !effectID.equals("none")) {
                        hashSet7.add(effectID);
                    }
                    z10 |= nexVideoClipItem.isVignetteApplied();
                    String mediaPath = nexVideoClipItem.getMediaPath();
                    if (mediaPath != null) {
                        hashSet.add(mediaPath);
                    }
                    if (nexVideoClipItem.isPreset()) {
                        i10 = i14;
                        int i17 = i15;
                        i12 = i13 + 1;
                        i11 = i17;
                    } else if (nexVideoClipItem.isImage()) {
                        i11 = i15 + 1;
                        i10 = i14;
                        i12 = i13;
                    } else {
                        i10 = i14 + 1;
                        i11 = i15;
                        i12 = i13;
                    }
                    i14 = i10;
                    i13 = i12;
                    i15 = i11;
                } else if ((primaryItem instanceof NexTransitionItem) && (transitionEffectID = ((NexTransitionItem) primaryItem).getTransitionEffectID()) != null && !transitionEffectID.equals("none")) {
                    hashSet6.add(transitionEffectID);
                }
                i16++;
                z10 = z10;
                z8 = isOptionApplied2;
                z2 = isOptionApplied;
            }
            int secondaryItemCount = nexTimeline.getSecondaryItemCount();
            boolean z11 = z4;
            boolean z12 = z3;
            boolean z13 = z2;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            boolean z14 = z8;
            boolean z15 = z7;
            boolean z16 = z6;
            int i21 = 0;
            int i22 = 0;
            boolean z17 = false;
            int i23 = 0;
            int i24 = 0;
            boolean z18 = z5;
            int i25 = 0;
            boolean z19 = false;
            int i26 = 0;
            int i27 = 0;
            while (i27 < secondaryItemCount) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i27);
                z13 |= secondaryItem.isOptionApplied(R.id.opt_volume_env);
                z12 |= secondaryItem.isOptionApplied(R.id.opt_audio_effect);
                z11 |= secondaryItem.isOptionApplied(R.id.opt_rotate);
                z18 |= secondaryItem.isOptionApplied(R.id.opt_color_adj);
                z16 |= secondaryItem.isOptionApplied(R.id.opt_split_trim);
                z15 |= secondaryItem.isOptionApplied(R.id.opt_speed_control);
                z14 |= secondaryItem.isOptionApplied(R.id.opt_volume);
                z19 |= secondaryItem.isOptionApplied(R.id.opt_splitscreen);
                boolean isOptionApplied3 = z17 | secondaryItem.isOptionApplied(R.id.opt_chroma_key);
                if (secondaryItem instanceof NexAudioClipItem) {
                    NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                    String mediaPath2 = nexAudioClipItem.getMediaPath();
                    boolean isLoop = z9 | nexAudioClipItem.isLoop();
                    if (mediaPath2 != null) {
                        hashSet.add(mediaPath2);
                    }
                    switch (nexAudioClipItem.getAudioType()) {
                        case BackgroundAudio:
                            int i28 = i23;
                            i7 = i26;
                            i8 = i21;
                            i9 = i22 + 1;
                            i6 = i28;
                            break;
                        case ExtractedAudio:
                            int i29 = i21 + 1;
                            i9 = i22;
                            int i30 = i26;
                            i8 = i29;
                            i6 = i23;
                            i7 = i30;
                            break;
                        case Music:
                            int i31 = i26 + 1;
                            i8 = i21;
                            i9 = i22;
                            int i32 = i23;
                            i7 = i31;
                            i6 = i32;
                            break;
                        case VoiceRecording:
                        case PendingVoiceRecording:
                            i6 = i23 + 1;
                            i7 = i26;
                            i8 = i21;
                            i9 = i22;
                            break;
                        default:
                            i6 = i23;
                            i7 = i26;
                            i8 = i21;
                            i9 = i22;
                            break;
                    }
                    i22 = i9;
                    i21 = i8;
                    i26 = i7;
                    i23 = i6;
                    z = isLoop;
                    i = i25;
                    i2 = i18;
                    i3 = i19;
                    i4 = i20;
                    i5 = i24;
                } else if (secondaryItem instanceof TextLayer) {
                    boolean z20 = z9;
                    i = i25;
                    i2 = i18;
                    i3 = i19;
                    i4 = i20;
                    i5 = i24 + 1;
                    z = z20;
                } else if (secondaryItem instanceof StickerLayer) {
                    int i33 = i20 + 1;
                    i5 = i24;
                    int i34 = i25;
                    i2 = i18;
                    i3 = i19;
                    i4 = i33;
                    z = z9;
                    i = i34;
                } else if (secondaryItem instanceof ImageLayer) {
                    int i35 = i19 + 1;
                    String mediaPath3 = ((ImageLayer) secondaryItem).getMediaPath();
                    if (mediaPath3 != null) {
                        hashSet.add(mediaPath3);
                    }
                    z = z9;
                    i = i25;
                    i2 = i18;
                    i3 = i35;
                    i4 = i20;
                    i5 = i24;
                } else if (secondaryItem instanceof VideoLayer) {
                    int i36 = i18 + 1;
                    String mediaPath4 = ((VideoLayer) secondaryItem).getMediaPath();
                    if (mediaPath4 != null) {
                        hashSet.add(mediaPath4);
                    }
                    z = z9;
                    i = i25;
                    i2 = i36;
                    i3 = i19;
                    i4 = i20;
                    i5 = i24;
                } else if (secondaryItem instanceof HandwritingLayer) {
                    int i37 = i25 + 1;
                    i2 = i18;
                    i3 = i19;
                    i4 = i20;
                    i5 = i24;
                    boolean z21 = z9;
                    i = i37;
                    z = z21;
                } else {
                    z = z9;
                    i = i25;
                    i2 = i18;
                    i3 = i19;
                    i4 = i20;
                    i5 = i24;
                }
                if ((secondaryItem instanceof NexLayerItem) && (layerExpression = ((NexLayerItem) secondaryItem).getLayerExpression(LayerExpression.Type.In)) != null && layerExpression != LayerExpression.None) {
                    layerExpression.name();
                }
                i27++;
                z17 = isOptionApplied3;
                i24 = i5;
                i20 = i4;
                i19 = i3;
                i18 = i2;
                i25 = i;
                z9 = z;
            }
            long j = 0;
            Iterator it = hashSet.iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    j = new File((String) it.next()).length() + j2;
                } else {
                    HashSet hashSet8 = new HashSet();
                    if (z13) {
                        hashSet8.add("Volume Envelope");
                    }
                    if (z12) {
                        hashSet8.add("Audio Filter");
                    }
                    if (z11) {
                        hashSet8.add("Rotate or Flip");
                    }
                    if (z18) {
                        hashSet8.add("Color Adjust");
                    }
                    if (z16) {
                        hashSet8.add("Trim");
                    }
                    if (z15) {
                        hashSet8.add("Speed Control");
                    }
                    if (z14) {
                        hashSet8.add("Volume");
                    }
                    if (z9) {
                        hashSet8.add("Audio Loop");
                    }
                    if (z19) {
                        hashSet8.add("Split Screen");
                    }
                    if (z17) {
                        hashSet8.add("Chroma Key");
                    }
                    if (z10) {
                        hashSet8.add("Vignette");
                    }
                    try {
                        jSONObject.put("Project Duration", nexTimeline.getTotalTime());
                        jSONObject.put("Project Video Count", i14);
                        jSONObject.put("Project Solid Count", i13);
                        jSONObject.put("Project Image Count", i15);
                        jSONObject.put("Project Text Layer Count", i24);
                        jSONObject.put("Project Sticker Layer Count", i20);
                        jSONObject.put("Project Image Layer Count", i19);
                        jSONObject.put("Project Video Layer Count", i18);
                        jSONObject.put("Project Handwriting Layer Count", i25);
                        jSONObject.put("Project Background Audio Count", i22);
                        jSONObject.put("Project Extracted Audio Count", i21);
                        jSONObject.put("Project Music Count", i26);
                        jSONObject.put("Project Voice Recording Count", i23);
                        jSONObject.put("Project Total Audio Count", i22 + i21 + i26 + i23);
                        jSONObject.put("Project Unique Media Count", hashSet.size());
                        jSONObject.put("Project Total Media Size", j2);
                        jSONObject.put("Project Color Effects", makeJsonArray(hashSet2));
                        jSONObject.put("Project Animation In", makeJsonArray(hashSet3));
                        jSONObject.put("Project Animation Out", makeJsonArray(hashSet4));
                        jSONObject.put("Project Animation Overall", makeJsonArray(hashSet5));
                        jSONObject.put("Project Clip Effects", makeJsonArray(hashSet7));
                        jSONObject.put("Project Transitions", makeJsonArray(hashSet6));
                        jSONObject.put("Project Applied Features", makeJsonArray(hashSet8));
                        jSONObject.put("Theme ID", nexTimeline.getThemeId());
                    } catch (JSONException e) {
                        Log.e(LOG_TAG, "Mixpanel json err", e);
                    }
                    getMixpanelInstanceFromContext(context).a(str, jSONObject);
                    return;
                }
            }
        }
    }
}
