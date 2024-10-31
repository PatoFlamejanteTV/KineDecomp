package com.nextreaming.nexeditorui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.general.tracelog.TLP;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexVisualClipChecker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
public abstract class cl extends PreferenceFragment {
    protected abstract int a();

    static /* synthetic */ ArrayList b() {
        return e();
    }

    public void a(String str) {
        a(getPreferenceScreen(), str);
    }

    private static boolean a(PreferenceGroup preferenceGroup, String str) {
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            if (preference.hasKey() && preference.getKey().equals(str)) {
                preferenceGroup.removePreference(preference);
                return true;
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (a(preferenceGroup2, str)) {
                    if (preferenceGroup2.getPreferenceCount() < 1) {
                        preferenceGroup.removePreference(preferenceGroup2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(a());
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStart() {
        if (Build.VERSION.SDK_INT > 18) {
            a("select_sdcard");
        }
        a("pref_logo_edit");
        if (!EditorGlobal.h) {
            a("report_anon_usage");
        }
        if (EditorGlobal.g != EditorGlobal.DataUsage.ASK_WIFI_OR_MOBILE) {
            a("mobile_updates");
        }
        if (EditorGlobal.g != EditorGlobal.DataUsage.ASK_WIFI_MOBILE_NEVER) {
            a("data_usage");
        }
        super.onStart();
    }

    @Override // android.preference.PreferenceFragment
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference.getKey().equalsIgnoreCase("guide_reset")) {
            c();
            return true;
        }
        if (preference.getKey().equalsIgnoreCase("select_sdcard")) {
            d();
            return true;
        }
        if (preference.getKey().equalsIgnoreCase("set_mixpanel_name")) {
            startActivityForResult(FullScreenInputActivity.a(getActivity()).c(false).a("").a(), R.id.pref_mixpanel_name);
            return true;
        }
        if (preference.getKey().equalsIgnoreCase("diagnostic_info")) {
            a(getActivity());
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        FileWriter fileWriter;
        if (i != R.id.pref_mixpanel_name) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        String b = FullScreenInputActivity.b(intent);
        if (b == null || b.trim().length() <= 0) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            fileWriter = new FileWriter(new File(EditorGlobal.g(), "mixpanel_name.txt"));
        } catch (IOException e) {
            fileWriter = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(b);
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e2) {
                }
            }
        } catch (IOException e3) {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e4) {
                }
            }
            KMUsage.getMixpanelPeople(getActivity()).a("$first_name", b);
        } catch (Throwable th2) {
            fileWriter2 = fileWriter;
            th = th2;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        KMUsage.getMixpanelPeople(getActivity()).a("$first_name", b);
    }

    private void c() {
        new a.C0074a(getActivity()).f(R.string.pref_confirm_reset_guide_balloons_title).a(R.string.pref_confirm_reset_guide_balloons).c(16).e(18).a(R.string.reset_guide_balloons_ok, new cn(this)).b(R.string.reset_guide_balloons_cancel, new cm(this)).a().show();
    }

    private void d() {
        new a().show(getFragmentManager(), "fragment_sdcard_dialog");
    }

    private static String a(int i) {
        if (i == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        int[] iArr = {180, 192, 320, 352, 360, 368, 480, 540, 544, 640, 720, 736, 960, 1080, 1088, 1280, 1920, 2048};
        int length = iArr.length;
        int i2 = 0;
        String str = null;
        int i3 = Integer.MAX_VALUE;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3;
            String str2 = str;
            int i6 = i5;
            for (int i7 : iArr) {
                if (i4 > i7) {
                    if (i == i4 * i7 && i4 / i7 < 2.0f) {
                        return "" + i4 + "x" + i7 + " (" + i + ")";
                    }
                    if (i4 / i7 < 2.0f && Math.abs((i4 * i7) - i) < i6) {
                        i6 = Math.abs((i4 * i7) - i);
                        int i8 = i - (i4 * i7);
                        if (i8 > 0) {
                            str2 = "" + i4 + "x" + i7 + "+" + i8 + " (" + i + ")";
                        } else {
                            str2 = "" + i4 + "x" + i7 + "" + i8 + " (" + i + ")";
                        }
                    }
                }
            }
            i2++;
            int i9 = i6;
            str = str2;
            i3 = i9;
        }
        return str == null ? "" + i : str;
    }

    public static void a(Context context) {
        String str;
        String str2;
        String str3;
        TLP.TLPResponseInfo a2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        NexEditor a3 = EditorGlobal.a();
        StringBuilder sb = new StringBuilder();
        String b = av.a().b();
        if (b == null) {
            sb.append("Config: DEFAULT\n");
        } else {
            sb.append("Config:\n");
            sb.append(b);
        }
        sb.append("----- DEVICE INFO -----\n");
        sb.append("Board: ").append(Build.BOARD).append("\n");
        sb.append("Product: ").append(Build.PRODUCT).append("\n");
        sb.append("Device: ").append(Build.DEVICE).append("\n");
        sb.append("Manufacturer: ").append(Build.MANUFACTURER).append("\n");
        sb.append("Model: ").append(Build.MODEL).append("\n");
        sb.append("Brand: ").append(Build.BRAND).append("\n");
        sb.append("Hardware: ").append(Build.HARDWARE).append("\n");
        sb.append("ROBoardPlat: ").append(NexEditor.a("ro.board.platform")).append("\n");
        sb.append("ROHardware: ").append(NexEditor.a("ro.hardware")).append("\n");
        sb.append("ROOther: ").append(NexEditor.a("ro.mediatek.platform")).append("\n");
        sb.append("----- OS VERSION -----\n");
        sb.append("Build: ").append(Build.DISPLAY).append("\n");
        sb.append("Release: ").append(Build.VERSION.RELEASE).append("\n");
        sb.append("Incremental: ").append(Build.VERSION.INCREMENTAL).append("\n");
        sb.append("Codename: ").append(Build.VERSION.CODENAME).append("\n");
        sb.append("SDK Level: ").append(Build.VERSION.SDK_INT).append("\n");
        sb.append("----- APP INFO -----\n");
        sb.append("UUID: ").append(com.nexstreaming.app.general.util.z.a(context)).append("\n");
        sb.append("Name: ").append(com.nexstreaming.app.general.util.z.c(context)).append("\n");
        sb.append("Version: ").append(com.nexstreaming.app.general.util.z.e(context)).append("\n");
        sb.append("Package: ").append(com.nexstreaming.app.general.util.z.d(context)).append("\n");
        sb.append("----- MIXPANEL -----\n");
        sb.append("Distinct ID: ").append(KMUsage.getMixpanelInstanceFromContext(context).b()).append("\n");
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        if (deviceProfile != null) {
            NexEditorDeviceProfile.c captureSize = deviceProfile.getCaptureSize();
            sb.append("------ DEVICE PROFILE --------\n");
            sb.append("Match: ").append(deviceProfile.getProfileSource().name()).append("\n");
            sb.append("Max FPS: ").append(deviceProfile.getMaxSupportedFPS()).append("\n");
            sb.append("1080pTMax: ").append(deviceProfile.getFullHDMaxTransitionTime()).append("\n");
            sb.append("HW Dec Max: ").append(deviceProfile.getHardwareDecMaxCount()).append("\n");
            sb.append("HW Enc Max: ").append(deviceProfile.getHardwareEncMaxCount()).append("\n");
            sb.append("HW Mem Size: ").append(deviceProfile.getHardwareCodecMemSize()).append("\n");
            sb.append("Image Rec: ").append(deviceProfile.getImageRecordingMode().name()).append("\n");
            sb.append("Video Rec: ").append(deviceProfile.getVideoRecordingMode().name()).append("\n");
            sb.append("JPEG Dec: ").append(deviceProfile.getUseAndroidJPEGDecoder() ? "Android" : "KM").append("\n");
            sb.append("Audio Codec Max: ").append(deviceProfile.getAudioCodecMaxCount()).append("\n");
            sb.append("Media Extractor: ").append(deviceProfile.getUseMediaExtractor() ? "supported" : "not supported").append("\n");
            sb.append("Color Format Check: ").append(deviceProfile.getNeedsColorFormatCheck() ? "necessary" : "skip").append("\n");
            sb.append("SeekFastPreview: ").append(deviceProfile.getNeedSeekBeforeFastPreview()).append("\n");
            sb.append("captureSize: ").append(captureSize.f4483a).append("x").append(captureSize.b).append("\n");
            if (a3 != null) {
                NexExportProfile[] supportedExportProfiles = deviceProfile.getSupportedExportProfiles(a3.i());
                if (supportedExportProfiles == null || supportedExportProfiles.length < 1) {
                    sb.append("Export profiles: NONE\n");
                } else {
                    sb.append("Export profiles:\n");
                    int i = 0;
                    for (NexExportProfile nexExportProfile : supportedExportProfiles) {
                        sb.append("    ").append(i).append(": ").append(nexExportProfile.width()).append("x").append(nexExportProfile.height()).append(" bitrate=").append(nexExportProfile.bitrate()).append(" dh=").append(nexExportProfile.displayHeight()).append("\n");
                        i++;
                    }
                }
            }
            if (deviceProfile.getProfileSource() == NexEditorDeviceProfile.ProfileSource.Server && (a2 = com.nexstreaming.app.general.tracelog.h.a((Object) deviceProfile.getDSR())) != null) {
                sb.append("Match Source:\n");
                sb.append("    from_cache: ").append(a2.fromCache).append("\n");
                sb.append("    original_src: ").append(a2.originalSrc).append("\n");
                if (a2.dataReceived < 1) {
                    sb.append("    last_update: UNKNOWN\n");
                    sb.append("    last_update_age: UNKNOWN\n");
                } else {
                    sb.append("    last_update: ").append(simpleDateFormat.format(new Date(a2.dataReceived))).append("\n");
                    sb.append("    last_update_age: ").append(EditorGlobal.a(context.getResources(), (int) (System.currentTimeMillis() - a2.dataReceived)).trim()).append("\n");
                }
                if (a2.cacheExpiration < 1) {
                    sb.append("    cache_expiration: UNKNOWN\n");
                } else {
                    sb.append("    cache_expiration: ").append(simpleDateFormat.format(new Date(a2.cacheExpiration))).append("\n");
                }
                if (a2.cacheRefresh < 1) {
                    sb.append("    cache_refresh: UNKNOWN\n");
                } else {
                    sb.append("    cache_refresh: ").append(simpleDateFormat.format(new Date(a2.cacheRefresh))).append("\n");
                }
            }
            NexEditorDeviceProfile.a matchInfo = deviceProfile.getMatchInfo();
            if (matchInfo != null) {
                sb.append("Match Basis:\n");
                sb.append("    predicate_name: ").append(String.valueOf(matchInfo.h)).append("\n");
                sb.append("    record_number: ").append(String.valueOf(matchInfo.f4482a)).append("\n");
                sb.append("    board_platform: ").append(String.valueOf(matchInfo.e)).append("\n");
                sb.append("    build_device: ").append(String.valueOf(matchInfo.c)).append("\n");
                sb.append("    build_model: ").append(String.valueOf(matchInfo.b)).append("\n");
                sb.append("    os_api_level_min: ").append(String.valueOf(matchInfo.f)).append("\n");
                sb.append("    os_api_level_max: ").append(String.valueOf(matchInfo.g)).append("\n");
                sb.append("    manufacturer: ").append(String.valueOf(matchInfo.d)).append("\n");
            }
        }
        sb.append("------ RESOURCE PROFILE --------\n");
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        sb.append("locale: ").append(configuration.locale.getLanguage().toLowerCase(Locale.US)).append(configuration.locale.getCountry().length() > 0 ? "-r" + configuration.locale.getCountry().toUpperCase(Locale.US) : "").append("\n");
        sb.append("smallest-width: sw").append(configuration.smallestScreenWidthDp).append("dp\n");
        sb.append("screen size: ").append(configuration.screenWidthDp).append("x").append(configuration.screenHeightDp).append("dp ").append(displayMetrics.widthPixels).append("x").append(displayMetrics.heightPixels).append("px\n");
        switch (configuration.screenLayout & 15) {
            case 1:
                str = "small ";
                break;
            case 2:
                str = "normal ";
                break;
            case 3:
                str = "large ";
                break;
            case 4:
                str = "xlarge ";
                break;
            default:
                str = "unknown-screen-size ";
                break;
        }
        switch (configuration.screenLayout & 48) {
            case 16:
                str = str + "notlong ";
                break;
            case 32:
                str = str + "long ";
                break;
        }
        switch (configuration.orientation) {
            case 1:
                str = str + "port ";
                break;
            case 2:
                str = str + "land ";
                break;
        }
        sb.append("screen layout: ").append(str).append("\n");
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case 120:
                str2 = "ldpi ";
                break;
            case 160:
                str2 = "mdpi ";
                break;
            case 213:
                str2 = "tvdpi ";
                break;
            case 240:
                str2 = "hdpi ";
                break;
            case 320:
                str2 = "xhdpi ";
                break;
            case 480:
                str2 = "xxhdpi ";
                break;
            case 640:
                str2 = "xxxhdpi ";
                break;
            default:
                str2 = "? ";
                break;
        }
        sb.append("density: ").append(str2).append(" (").append(displayMetrics.densityDpi).append("dpi; scale=").append(displayMetrics.density).append("x) \n");
        sb.append("font-scale: ").append(configuration.fontScale).append("\n");
        sb.append("------ KINEMASTER --------\n");
        Date date = new Date();
        sb.append("Time: ").append(simpleDateFormat.format(date)).append("\n");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        sb.append("UTC: ").append(simpleDateFormat.format(date)).append("\n");
        try {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            str3 = "?";
            e.printStackTrace();
        }
        sb.append("Version: ").append(str3).append("\n");
        if (a3 != null) {
            sb.append("Engine: ").append(a3.getVersionNumber(1)).append(".").append(a3.getVersionNumber(2)).append(".").append(a3.getVersionNumber(3)).append(".").append(a3.getVersionNumber(4)).append("\n");
            sb.append("SWCodec: ").append(a3.i() ? "yes" : "no").append('\n');
            ColorFormatChecker.ColorFormat r = a3.r();
            if (r != null) {
                sb.append("Color Format: ").append(r.name()).append("\n");
            } else {
                sb.append("Color Format: (no check)\n");
            }
            NexVisualClipChecker d = a3.d();
            if (d != null) {
                sb.append("SW Max Import: ").append(a(d.a(true))).append("\n");
                sb.append("HW Max Import: ").append(a(d.a(false))).append("\n");
                sb.append("MaxHardwareAVCDecBaselineSize: ").append(a(d.b())).append("\n");
                sb.append("MaxHardwareAVCDecMainSize: ").append(a(d.c())).append("\n");
                sb.append("MaxHardwareAVCDecHighSize: ").append(a(d.d())).append("\n");
                sb.append("MaxHardwareAVCEncBaselineSize: ").append(a(d.e())).append("\n");
                sb.append("MaxHardwareAVCEncMainSize: ").append(a(d.f())).append("\n");
                sb.append("MaxHardwareAVCEncHighSize: ").append(a(d.g())).append("\n");
                sb.append("MaxMCSoftwareAVCDecBaselineSize: ").append(a(d.h())).append("\n");
                sb.append("MaxMCSoftwareAVCDecMainSize: ").append(a(d.i())).append("\n");
                sb.append("MaxMCSoftwareAVCDecHighSize: ").append(a(d.j())).append("\n");
            }
        }
        File j = EditorGlobal.j();
        sb.append("Projects: ").append(j.getAbsolutePath()).append(" (").append(j.getFreeSpace() / 1048576).append("MB free)\n");
        sb.append("M_ID: ").append(EditorGlobal.b()).append("\n");
        String sb2 = sb.toString();
        TextView textView = new TextView(context);
        textView.setText("Diagnostic Information");
        textView.setTextSize(1, 25.0f);
        textView.setClickable(true);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-11184811);
        textView.setPadding(5, 5, 5, 5);
        textView.setOnTouchListener(new co(new int[]{10}, context));
        TextView textView2 = new TextView(context);
        textView2.setText(sb2);
        textView2.setTextIsSelectable(true);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView2.setScrollBarStyle(16777216);
        new AlertDialog.Builder(context).setView(textView2).setCustomTitle(textView).setCancelable(true).setPositiveButton("OK", new cq()).setNeutralButton("Copy to Clipboard", new cp(context, sb2)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        new AlertDialog.Builder(context).setTitle("Config File Manager").setCancelable(false).setItems(new String[]{"Delete Config File", "Overwrite with: device support - STAGING", "Overwrite with: device support - DEV ", "Overwrite with: device support - LOCAL (in APK) ONLY ", "Overwrite with: theme server - DEV", "Overwrite with: notify and update server - DEV", "Overwrite with: promocode with Only Inapp Test - DEV"}, new cs(new File(Environment.getExternalStorageDirectory(), "kinemaster.cfg"), context)).setNegativeButton("Cancel", new cr()).show();
    }

    /* compiled from: NexPrefsFrag.java */
    /* loaded from: classes.dex */
    public static class a extends DialogFragment {

        /* renamed from: a, reason: collision with root package name */
        private static int f4576a;
        private int b;

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            int i = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            ArrayList b = cl.b();
            String[] strArr = new String[b.size()];
            String string = getActivity().getSharedPreferences("sdcardloc", 0).getString("sdcardlocation", Environment.getExternalStorageDirectory().getAbsolutePath());
            f4576a = 0;
            while (true) {
                int i2 = i;
                if (i2 < b.size()) {
                    strArr[i2] = (String) b.get(i2);
                    if (string.equalsIgnoreCase(strArr[i2])) {
                        f4576a = i2;
                    }
                    i = i2 + 1;
                } else {
                    this.b = f4576a;
                    builder.setTitle(R.string.pref_section_sdcard_dialog_title).setSingleChoiceItems(strArr, f4576a, new cv(this, strArr)).setPositiveButton(R.string.mediabrowser_ok, new cu(this, strArr)).setNegativeButton(R.string.button_cancel, new ct(this));
                    return builder.create();
                }
            }
        }
    }

    private static ArrayList<String> e() {
        File file;
        boolean z;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d("NexPrefsFrag", "Sdcard Default path : " + Environment.getExternalStorageDirectory().getAbsolutePath() + " Sdcards[0] = " + arrayList.get(0));
        try {
            Scanner scanner = new Scanner(new File("/system/etc/vold.fstab"));
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                if (nextLine.startsWith("dev_mount")) {
                    String str = nextLine.split(" ")[2];
                    String substring = str.contains(":") ? str.substring(0, str.indexOf(":")) : str;
                    if (!substring.contains("usb")) {
                        int i = 0;
                        while (true) {
                            if (i >= 100000) {
                                file = null;
                                break;
                            }
                            File file2 = new File(substring, "._km_wrttest_" + i);
                            if (!file2.exists()) {
                                file = file2;
                                break;
                            }
                            i++;
                        }
                        if (file != null && !file.exists()) {
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(0);
                                fileOutputStream.close();
                                z = true;
                            } catch (IOException e) {
                                z = false;
                            }
                            if (!file.delete()) {
                                Log.e("NexPrefsFrag", "Test file deletion failed : " + file);
                            }
                            if (z) {
                            }
                        }
                        if (!arrayList.contains(substring)) {
                            arrayList.add(substring);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e2) {
            Log.e("NexPrefsFrag", "Error reading fstab ", e2);
        }
        a(arrayList);
        return arrayList;
    }

    private static void a(ArrayList<String> arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            File file = new File(arrayList.get(i));
            if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                arrayList.remove(i);
                i--;
            }
            i++;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
        }
    }
}
