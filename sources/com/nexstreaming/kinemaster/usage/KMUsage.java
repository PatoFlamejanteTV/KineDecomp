package com.nexstreaming.kinemaster.usage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.m;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes2.dex */
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
    BailReport(4),
    DeviceInfo,
    Share_SelectTarget,
    Share_StartExport_ProjStatsA_SUB(8),
    Share_StartExport_ProjStatsB_SUB(8),
    Share_StartExport_ProjStatsA_NOSUB(8),
    Share_StartExport_ProjStatsB_NOSUB(8),
    Share_ExportResult(4),
    Share_LaunchSNSShare,
    Share_Upload_Start,
    Share_Upload_Finish,
    ProjectList_ProjectDetails,
    ProjectList_DeleteProject(4),
    ProjectList_RenameProject(4),
    ProjectList_EditProject,
    ProjectList_NewProject,
    ProjectList_TipTapped(4),
    EditScreen_AddLayer(16),
    EditScreen_AddButton(4),
    EditScreen_RecButton(4),
    EditScreen_PreviewPlay(4),
    EditScreen_Clip_Added,
    EditScreen_Clip_Deleted,
    EditScreen_Timeline_PinchZoom,
    EditScreen_Bookmark(4),
    EditScreen_OnStop,
    EditScreen_OnStop_ProjStatsA_SUB(8),
    EditScreen_OnStop_ProjStatsB_SUB(8),
    EditScreen_OnStop_ProjStatsA_NOSUB(8),
    EditScreen_OnStop_ProjStatsB_NOSUB(8),
    EditScreen_ActionButton(4),
    EditScreen_OverflowAction(4),
    EditScreen_CaptureAction(4),
    EditScreen_ProjectSettings(4),
    EditScreen_SelectClip(4),
    EditScreen_FlipRotate(4),
    EditScreen_AdjustVolume(4),
    EditScreen_SetMinVloume_Muserk(4),
    EditScreen_AdjustBGMVolume(4),
    EditScreen_SpeedControl(4),
    EditScreen_ColorTint(4),
    EditScreen_ColorAdj_Brightness(4),
    EditScreen_ColorAdj_Contrast(4),
    EditScreen_ColorAdj_Saturation(4),
    EditScreen_InAnimation(4),
    EditScreen_OutAnimation(4),
    EditScreen_OverallAnimation(4),
    EditScreen_Option_Tap(4),
    EditScreen_Adjust_Alpha(4),
    EditScreen_TransitionDuration,
    EditScreen_Transition(4),
    EditScreen_TransitionParam,
    EditScreen_VolumeEnvelope,
    EditScreen_Cropping,
    EditScreen_ClipEffect(4),
    EditScreen_ClipEffectParam,
    EditScreen_Visual_DragToTrim,
    EditScreen_Handwriting_Stroke,
    EditScreen_Handwriting_Action,
    EditScreen_Animation_Action,
    EditScreen_Sticker_Select,
    EditScreen_Timeline_MoveVisualClip(4),
    EditScreen_Timeline_MoveSecondaryClip(4),
    EditScreen_Theme_Confirm,
    EditScreen_TriggerAd_Show(4),
    EditScreen_TriggerAd_Tap(4),
    FontBrowser_SelectFont,
    ColorPicker_ApplyColor(4),
    MediaBrowser_EnterFolder(4),
    MediaBrowser_ShowDetails,
    MediaBrowser_DetailAction,
    MediaBrowser_Filter,
    AudioBrowser_ChooseCategory,
    AudioBrowser_PreviewPlay(4),
    AudioBrowser_AddOrSelect(4),
    GetStarted_Finish,
    GetStarted_Step,
    PurchaseFlowComplete(4),
    PurchaseButtonClick(4),
    SaveFail,
    Theme_Download,
    Theme_Uninstall,
    MediaDownload_Start,
    MediaDownload_Result,
    Transcode_Start(4),
    Transcode_Result(4),
    Settings_Tap_Option(4),
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
    Media_Indexing_End,
    TOS_Response,
    DCI(4),
    HWPA_CompletePopup_Show(4),
    HWPA_CompletePopup_TapOK(4),
    HWPA_CompletePopup_TapResults(4),
    Muserk_AgreePopupWM_Show(4),
    Muserk_AgreePopupWM_TapAgree(4),
    Muserk_AgreePopupWM_TapCancel(4),
    Muserk_AgreePopup_Show(4),
    Muserk_AgreePopup_TapAgree(4),
    Muserk_AgreePopup_TapCancel(4),
    Muserk_AgreePopupNC_Show(4),
    Muserk_AgreePopupNC_TapAgree(4),
    Muserk_AgreePopupNC_TapCancel(4),
    Muserk_Share_YouTube(4),
    Muserk_Share_Other(4),
    Muserk_Download_Track(4),
    Muserk_YouTubeWM_Share(4),
    Muserk_YouTubeNC_Share(4),
    GDPR_TEST_INIT(4),
    asset_preview(16),
    asset_download_attempt(16),
    asset_download_result(16),
    asset_select_category(16),
    asset_select_subcategory(16),
    asset_detailview(16),
    asset_store_enter(16),
    unlimited_layers_enable(16),
    activity_subscribe_screen(4),
    dci_analysis_start(4),
    dci_analysis_result(4),
    dci_analysis_popup(4),
    dci_analysis_popup_confirm(4),
    user_version(16),
    sever_sub_error(16);

    private static final String EVENT_PREFIX = "KM3_";
    public static final KMUsage FailToGetPurchaseType;
    public static final KMUsage GetCachedPurchaseType;
    private static final boolean LOG_PARAMS = false;
    private static final String LOG_TAG = "KMUsage";
    private static boolean didMixpanelIdentify;
    private static boolean didMixpanelPeopleProps;
    private static boolean didMixpanelStartup;
    private final int mFlags;

    static {
        KMUsage kMUsage = DiagnosticA;
        KMUsage kMUsage2 = DiagnosticB;
        GetCachedPurchaseType = kMUsage;
        FailToGetPurchaseType = kMUsage2;
        didMixpanelPeopleProps = false;
        didMixpanelStartup = false;
        didMixpanelIdentify = false;
    }

    KMUsage() {
        this.mFlags = 0;
    }

    private static String[] a(Collection<String> collection) {
        String[] strArr = new String[collection.size()];
        Iterator<String> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }

    public static String bucketParam0to100(int i) {
        return i <= 0 ? "A. <=0" : i <= 10 ? "B. 1~10" : i <= 20 ? "C. 11~20" : i <= 30 ? "D. 21~30" : i <= 40 ? "E. 31~40" : i <= 50 ? "F. 41~50" : i <= 60 ? "G. 51~60" : i <= 70 ? "H. 61~70" : i <= 80 ? "I. 71~80" : i <= 90 ? "J. 81~90" : i < 100 ? "K. 91~100" : "L. >=100";
    }

    public static String bucketParam0to200(int i) {
        return i == 0 ? "A. 0" : i <= 33 ? "B. 1~33" : i <= 66 ? "C. 34~66" : i < 100 ? "D. 66~99" : i == 100 ? "E. 100" : i <= 133 ? "F. 101~133" : i <= 166 ? "G. 134~166" : i < 200 ? "H. 167~199" : "I. >=200";
    }

    public static String bucketParam0to300(int i) {
        return i == 0 ? "A. 0" : i < 25 ? "B. 1~24" : i == 25 ? "C. 25" : i <= 50 ? "D. 26~50" : i <= 75 ? "E. 51~75" : i < 100 ? "F. 76~99" : i == 100 ? "G. 100" : i <= 125 ? "H. 101~125" : i <= 150 ? "I. 126~150" : i <= 175 ? "J. 151~175" : i <= 200 ? "K. 176~200" : i <= 250 ? "L. 201~250" : i < 300 ? "M. 251~299" : "N. >=300";
    }

    public static String bucketParamPlusMinus100(int i) {
        return i == -100 ? "A. -100" : i <= -66 ? "B. -99 ~ -66" : i <= -33 ? "C. -65 ~ -33" : i < 0 ? "D. -32 ~ -1" : i == 0 ? "E. 0" : i <= 33 ? "F. 1~33" : i <= 66 ? "G. 34~66" : i < 100 ? "H. 66~99" : "I. >=100";
    }

    public static String bucketParamProjectTime(int i) {
        return i < 1000 ? "A. <1s" : i <= 15000 ? "B. 1~15s" : i <= 30000 ? "C. 16~30s" : i <= 45000 ? "D. 31~45s" : i <= 60000 ? "E. 45~60s" : i < 90000 ? "F. 1~1.5m" : i == 120000 ? "G. 1.5~2m" : i <= 300000 ? "H. 2~5m" : i <= 600000 ? "I. 5~10m" : i <= 900000 ? "J. 10~15m" : i <= 1800000 ? "K. 15~30m" : i <= 3600000 ? "L. 30~60m" : i < 7200000 ? "M. 1~2h" : "N. >2h";
    }

    public static String getAssetCategoryName(InterfaceC1822k interfaceC1822k) {
        if (interfaceC1822k.getCategoryAliasName() == null) {
            if (interfaceC1822k.getCategoryName() == null || !interfaceC1822k.getCategoryName().containsKey("en") || interfaceC1822k.getCategoryName().get("en") == null) {
                return null;
            }
            return interfaceC1822k.getCategoryName().get("en");
        }
        return interfaceC1822k.getCategoryAliasName();
    }

    public static String getAssetSubCategoryName(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j.k() == null) {
            if (interfaceC1821j.c() == null || !interfaceC1821j.c().containsKey("en") || interfaceC1821j.c().get("en") == null) {
                return null;
            }
            return interfaceC1821j.c().get("en");
        }
        return interfaceC1821j.k();
    }

    public static String getAssetTitle(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j.j() != null) {
            return interfaceC1821j.j().get("en");
        }
        return interfaceC1821j.f();
    }

    public static String getISODateTimeUTC() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US).format(new Date());
    }

    public static void incrementUserProperty(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("km.analytics.uprop", 0);
        int i2 = sharedPreferences.getInt(str, 0) + i;
        sharedPreferences.edit().putInt(str, i2).apply();
        if (c.d.b.c.a.d(context)) {
            FirebaseAnalytics.getInstance(context).a(str.replace(" ", ""), String.valueOf(i2));
        }
    }

    public static void logProjectStats(NexTimeline nexTimeline, KMUsage kMUsage, KMUsage kMUsage2, KMUsage kMUsage3, KMUsage kMUsage4, boolean z) {
        NexTimeline nexTimeline2 = nexTimeline;
        if (nexTimeline2 == null) {
            return;
        }
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < primaryItemCount; i4++) {
            NexPrimaryTimelineItem primaryItem = nexTimeline2.getPrimaryItem(i4);
            if (primaryItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                if (nexVideoClipItem.isPreset()) {
                    i++;
                } else if (nexVideoClipItem.isImage()) {
                    i3++;
                } else {
                    i2++;
                }
            }
        }
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i5 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = nexTimeline2.getSecondaryItem(i5);
            if (secondaryItem instanceof NexAudioClipItem) {
                int i15 = e.f23943a[((NexAudioClipItem) secondaryItem).getAudioType().ordinal()];
                if (i15 == 1) {
                    i7++;
                } else if (i15 == 2) {
                    i8++;
                } else if (i15 == 3) {
                    i9++;
                } else if (i15 == 4 || i15 == 5) {
                    i10++;
                }
            } else if (secondaryItem instanceof TextLayer) {
                i6++;
            } else if (secondaryItem instanceof StickerLayer) {
                i11++;
            } else if (secondaryItem instanceof ImageLayer) {
                i12++;
            } else if (secondaryItem instanceof VideoLayer) {
                i13++;
            } else if (secondaryItem instanceof HandwritingLayer) {
                i14++;
            }
            i5++;
            nexTimeline2 = nexTimeline;
        }
        KMUsage kMUsage5 = z ? kMUsage3 : kMUsage;
        KMUsage kMUsage6 = z ? kMUsage4 : kMUsage2;
        int i16 = i7 + i8 + i9 + i10;
        kMUsage5.logEvent("ProjectDuration", bucketParamProjectTime(nexTimeline.getTotalTime()), "Solid", bucketParam0to100(i), "Video", bucketParam0to100(i2), "Image", bucketParam0to100(i3), "TextLayer", bucketParam0to100(i6), "StickerLayer", bucketParam0to100(i11), "ImageLayer", bucketParam0to100(i12), "VideoLayer", bucketParam0to100(i13), "HandwritingLayer", bucketParam0to100(i14), "AudioTrackTotal", bucketParam0to100(i16));
        kMUsage6.logEvent("AudioTrackTotal", bucketParam0to100(i16), "BackgroundAudio", bucketParam0to100(i7), "ExtractedAudio", bucketParam0to100(i8), "Music", bucketParam0to100(i9), "VoiceRecording", bucketParam0to100(i10));
    }

    public static JSONArray makeJsonArray(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(String.valueOf(it.next()));
        }
        return jSONArray;
    }

    public static void onPause(Context context) {
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().b(context);
    }

    public static void onResume(Context context) {
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(context);
    }

    public static void sendAssetDetailView(InterfaceC1821j interfaceC1821j, AssetStoreEntry assetStoreEntry) {
        sendAssetDetailView(interfaceC1821j, assetStoreEntry.getValue());
    }

    public static void sendAssetDownloadAttempt(InterfaceC1821j interfaceC1821j) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", interfaceC1821j.getAssetId());
        hashMap.put("title", getAssetTitle(interfaceC1821j));
        hashMap.put("price_type", interfaceC1821j.getPriceType());
        hashMap.put("category", interfaceC1821j.getCategoryAliasName());
        String assetSubCategoryName = getAssetSubCategoryName(interfaceC1821j);
        if (!TextUtils.isEmpty(assetSubCategoryName)) {
            hashMap.put("sub_category", assetSubCategoryName);
        }
        asset_download_attempt.logEvent(hashMap);
    }

    public static void sendAssetDownloadResult(InterfaceC1821j interfaceC1821j, AssetDownloadResult assetDownloadResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", interfaceC1821j.getAssetId());
        hashMap.put("title", getAssetTitle(interfaceC1821j));
        hashMap.put("price_type", interfaceC1821j.getPriceType());
        hashMap.put("category", interfaceC1821j.getCategoryAliasName());
        String assetSubCategoryName = getAssetSubCategoryName(interfaceC1821j);
        if (!TextUtils.isEmpty(assetSubCategoryName)) {
            hashMap.put("sub_category", assetSubCategoryName);
        }
        hashMap.put("result", assetDownloadResult.getValue());
        asset_download_result.logEvent(hashMap);
    }

    public static void sendAssetPreview(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        hashMap.put("title", str2);
        hashMap.put(MessengerShareContentUtility.MEDIA_TYPE, str3);
        asset_preview.logEvent(hashMap);
    }

    public static void sendAssetSelectCategory(InterfaceC1822k interfaceC1822k, AssetStoreEntry assetStoreEntry) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.toString(interfaceC1822k.getCategoryIdx()));
        hashMap.put("title", getAssetCategoryName(interfaceC1822k));
        asset_select_category.logEvent(hashMap);
    }

    public static void sendAssetSelectSubCategory(m mVar, AssetStoreEntry assetStoreEntry) {
    }

    public static void sendAssetStoreEnter(d dVar) {
        sendAssetStoreEnter(dVar.c(), dVar.e(), dVar.a(), dVar.b(), dVar.d());
    }

    public static void sendSubscriptionOrigin(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", str);
        activity_subscribe_screen.logEvent(hashMap);
    }

    public static void setUserProperty(Context context, String str, String str2) {
        if (c.d.b.c.a.d(context)) {
            FirebaseAnalytics.getInstance(context).a(str.replace(" ", ""), str2);
        }
    }

    public static void trackFirebaseProjectEvent(NexTimeline nexTimeline, String str, JSONObject jSONObject) {
        Object obj;
        if (jSONObject == null) {
            trackFirebaseProjectEvent(nexTimeline, str, (Bundle) null);
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                obj = jSONObject.get(next);
            } catch (JSONException unused) {
                obj = null;
            }
            String lowerCase = next.replace(" ", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR).toLowerCase(Locale.ENGLISH);
            if (obj instanceof Integer) {
                bundle.putInt(lowerCase, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(lowerCase, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(lowerCase, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(lowerCase, (String) obj);
            } else if (obj instanceof Float) {
                bundle.putFloat(lowerCase, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(lowerCase, ((Boolean) obj).booleanValue());
            }
        }
        trackFirebaseProjectEvent(nexTimeline, str, bundle);
    }

    public void begin() {
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext());
    }

    public void end() {
    }

    public void end(Map<String, String> map) {
    }

    public void end(String... strArr) {
    }

    public void logEvent() {
        String str = EVENT_PREFIX + name();
        if ((this.mFlags & 8) != 0) {
            return;
        }
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext(), str, (String) null);
    }

    public static void sendAssetDetailView(InterfaceC1821j interfaceC1821j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", interfaceC1821j.getAssetId());
        hashMap.put("title", getAssetTitle(interfaceC1821j));
        asset_detailview.logEvent(hashMap);
    }

    public void begin(Map<String, String> map) {
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().d(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), map);
    }

    KMUsage(int i) {
        this.mFlags = i;
    }

    public static void setUserProperty(Context context, String str, int i) {
        if (c.d.b.c.a.d(context)) {
            FirebaseAnalytics.getInstance(context).a(str.replace(" ", ""), String.valueOf(i));
        }
    }

    public void begin(String... strArr) {
        if (strArr != null && strArr.length >= 2) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < strArr.length / 2; i++) {
                int i2 = i * 2;
                hashMap.put(strArr[i2], strArr[i2 + 1]);
            }
            com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().d(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), hashMap);
            return;
        }
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().d(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), (Map<String, String>) null);
    }

    public void logEvent(String... strArr) {
        if (strArr != null && strArr.length >= 2) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < strArr.length / 2; i++) {
                int i2 = i * 2;
                hashMap.put(strArr[i2], strArr[i2 + 1]);
            }
            com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), hashMap);
            return;
        }
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), (String) null);
    }

    public static void sendAssetStoreEnter(AssetStoreEntry assetStoreEntry) {
        sendAssetStoreEnter(assetStoreEntry, null, null, null, null);
    }

    public static void sendAssetStoreEnter(AssetStoreEntry assetStoreEntry, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", assetStoreEntry.getValue());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("url", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("asset_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("category_id", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("subcategory_id", str4);
        }
        asset_store_enter.logEvent(hashMap);
    }

    public void logEvent(Map<String, String> map) {
        if ((this.mFlags & 16) != 0) {
            com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().f(KineMasterApplication.f24056d.getApplicationContext(), name(), map);
        } else {
            com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext(), name(), map);
        }
    }

    public static void trackFirebaseProjectEvent(NexTimeline nexTimeline, String str, Bundle bundle) {
        int i;
        int i2;
        HashSet hashSet;
        int i3;
        HashSet hashSet2;
        int i4;
        boolean z;
        LayerExpression layerExpression;
        int i5;
        String transitionEffectID;
        NexTimeline nexTimeline2 = nexTimeline;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (nexTimeline2 == null) {
            return;
        }
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (true) {
            i = R.id.opt_volume_env;
            if (i9 >= primaryItemCount) {
                break;
            }
            int i10 = primaryItemCount;
            NexPrimaryTimelineItem primaryItem = nexTimeline2.getPrimaryItem(i9);
            boolean isOptionApplied = z2 | primaryItem.isOptionApplied(R.id.opt_volume_env);
            z3 |= primaryItem.isOptionApplied(R.id.opt_volume);
            z4 |= primaryItem.isOptionApplied(R.id.opt_audio_voice_changer);
            z5 |= primaryItem.isOptionApplied(R.id.opt_audio_eq);
            z6 |= primaryItem.isOptionApplied(R.id.opt_rotate);
            z7 |= primaryItem.isOptionApplied(R.id.opt_color_adj);
            z8 |= primaryItem.isOptionApplied(R.id.opt_split_trim);
            z9 |= primaryItem.isOptionApplied(R.id.opt_speed_control);
            if (primaryItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                ColorEffect colorEffect = nexVideoClipItem.getColorEffect();
                if (colorEffect != null && colorEffect.getPresetName() != null) {
                    hashSet4.add(colorEffect.getPresetName());
                }
                String effectID = nexVideoClipItem.getEffectID();
                if (effectID != null && !effectID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                    hashSet9.add(effectID);
                }
                boolean isVignetteApplied = z10 | nexVideoClipItem.isVignetteApplied();
                String mediaPath = nexVideoClipItem.getMediaPath();
                if (mediaPath != null) {
                    hashSet3.add(mediaPath);
                }
                if (nexVideoClipItem.isPreset()) {
                    i8++;
                } else if (nexVideoClipItem.isImage()) {
                    i6++;
                } else {
                    i7++;
                }
                z10 = isVignetteApplied;
            } else if ((primaryItem instanceof NexTransitionItem) && (transitionEffectID = ((NexTransitionItem) primaryItem).getTransitionEffectID()) != null && !transitionEffectID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                hashSet8.add(transitionEffectID);
            }
            i9++;
            z2 = isOptionApplied;
            primaryItemCount = i10;
        }
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i11 < secondaryItemCount) {
            int i21 = secondaryItemCount;
            NexSecondaryTimelineItem secondaryItem = nexTimeline2.getSecondaryItem(i11);
            boolean isOptionApplied2 = z2 | secondaryItem.isOptionApplied(i);
            z4 |= secondaryItem.isOptionApplied(R.id.opt_audio_voice_changer);
            z5 |= secondaryItem.isOptionApplied(R.id.opt_audio_eq);
            z6 |= secondaryItem.isOptionApplied(R.id.opt_rotate);
            z7 |= secondaryItem.isOptionApplied(R.id.opt_color_adj);
            z8 |= secondaryItem.isOptionApplied(R.id.opt_split_trim);
            z9 |= secondaryItem.isOptionApplied(R.id.opt_speed_control);
            z3 |= secondaryItem.isOptionApplied(R.id.opt_volume);
            z11 |= secondaryItem.isOptionApplied(R.id.opt_splitscreen);
            z12 |= secondaryItem.isOptionApplied(R.id.opt_chroma_key);
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                String mediaPath2 = nexAudioClipItem.getMediaPath();
                z13 |= nexAudioClipItem.isLoop();
                if (mediaPath2 != null) {
                    hashSet3.add(mediaPath2);
                }
                int i22 = e.f23943a[nexAudioClipItem.getAudioType().ordinal()];
                if (i22 != 1) {
                    if (i22 != 2) {
                        if (i22 != 3) {
                            if (i22 == 4 || i22 == 5) {
                                i17++;
                            }
                            i2 = i16;
                            i5 = i17;
                        } else {
                            i5 = i17;
                            i2 = i16 + 1;
                        }
                        hashSet = hashSet8;
                    } else {
                        i2 = i16;
                        i5 = i17;
                        hashSet = hashSet8;
                        i15++;
                    }
                    i3 = i15;
                    hashSet2 = hashSet9;
                } else {
                    i2 = i16;
                    i5 = i17;
                    hashSet = hashSet8;
                    i3 = i15;
                    hashSet2 = hashSet9;
                    i14++;
                }
                i17 = i5;
                i4 = i14;
                z = isOptionApplied2;
            } else {
                i2 = i16;
                int i23 = i17;
                hashSet = hashSet8;
                i3 = i15;
                hashSet2 = hashSet9;
                i4 = i14;
                z = isOptionApplied2;
                if (secondaryItem instanceof TextLayer) {
                    i12++;
                } else if (secondaryItem instanceof StickerLayer) {
                    i13++;
                } else if (secondaryItem instanceof ImageLayer) {
                    i18++;
                    String mediaPath3 = ((ImageLayer) secondaryItem).getMediaPath();
                    if (mediaPath3 != null) {
                        hashSet3.add(mediaPath3);
                    }
                } else {
                    int i24 = i18;
                    if (secondaryItem instanceof VideoLayer) {
                        i19++;
                        String mediaPath4 = ((VideoLayer) secondaryItem).getMediaPath();
                        if (mediaPath4 != null) {
                            hashSet3.add(mediaPath4);
                        }
                    } else {
                        int i25 = i19;
                        if (secondaryItem instanceof HandwritingLayer) {
                            i20++;
                        }
                        i19 = i25;
                    }
                    i18 = i24;
                }
                i17 = i23;
            }
            if ((secondaryItem instanceof NexLayerItem) && (layerExpression = ((NexLayerItem) secondaryItem).getLayerExpression(LayerExpression.Type.In)) != null && layerExpression != LayerExpression.None) {
                layerExpression.name();
            }
            i11++;
            nexTimeline2 = nexTimeline;
            secondaryItemCount = i21;
            z2 = z;
            i14 = i4;
            hashSet9 = hashSet2;
            i15 = i3;
            hashSet8 = hashSet;
            i16 = i2;
            i = R.id.opt_volume_env;
        }
        int i26 = i12;
        int i27 = i13;
        int i28 = i17;
        int i29 = i19;
        int i30 = i20;
        int i31 = i18;
        int i32 = i16;
        HashSet hashSet10 = hashSet8;
        int i33 = i15;
        HashSet hashSet11 = hashSet9;
        int i34 = i14;
        Iterator it = hashSet3.iterator();
        while (it.hasNext()) {
            new File((String) it.next()).length();
            hashSet3 = hashSet3;
            i33 = i33;
        }
        HashSet hashSet12 = hashSet3;
        int i35 = i33;
        HashSet hashSet13 = new HashSet();
        if (z2) {
            hashSet13.add("Volume Envelope");
        }
        if (z4) {
            hashSet13.add("Voice Changer");
        }
        if (z5) {
            hashSet13.add("Equalizer");
        }
        if (z6) {
            hashSet13.add("Rotate or Flip");
        }
        if (z7) {
            hashSet13.add("Color Adjust");
        }
        if (z8) {
            hashSet13.add("Trim");
        }
        if (z9) {
            hashSet13.add("Speed Control");
        }
        if (z3) {
            hashSet13.add("Volume");
        }
        if (z13) {
            hashSet13.add("Audio Loop");
        }
        if (z11) {
            hashSet13.add("Split Screen");
        }
        if (z12) {
            hashSet13.add("Chroma Key");
        }
        if (z10) {
            hashSet13.add("Vignette");
        }
        bundle2.putInt("project_duration", nexTimeline.getTotalTime());
        bundle2.putInt("project_video_count", i7);
        bundle2.putInt("project_solid_count", i8);
        bundle2.putInt("project_image_count", i6);
        bundle2.putInt("project_text_layer_count", i26);
        bundle2.putInt("project_sticker_layer_count", i27);
        bundle2.putInt("project_image_layer_count", i31);
        bundle2.putInt("project_video_layer_count", i29);
        bundle2.putInt("project_handwriting_layer_count", i30);
        bundle2.putInt("project_background_audio_count", i34);
        bundle2.putInt("project_extracted_audio_count", i35);
        bundle2.putInt("project_music_count", i32);
        bundle2.putInt("project_voice_recording_count", i28);
        bundle2.putInt("project_unique_media_count", hashSet12.size());
        bundle2.putStringArray("project_color_effects", a(hashSet4));
        bundle2.putStringArray("project_animation_in", a(hashSet5));
        bundle2.putStringArray("project_animation_out", a(hashSet6));
        bundle2.putStringArray("project_animation_overall", a(hashSet7));
        bundle2.putStringArray("project_clip_effects", a(hashSet11));
        bundle2.putStringArray("project_transition", a(hashSet10));
        bundle2.putStringArray("project_applied_features", a(hashSet13));
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(KineMasterApplication.f24056d.getApplicationContext(), str, bundle2);
    }

    public void logEvent(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().d(KineMasterApplication.f24056d.getApplicationContext(), EVENT_PREFIX + name(), hashMap);
    }
}
