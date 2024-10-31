package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.firebase.iid.FirebaseInstanceId;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import org.json.JSONObject;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public abstract class Ua extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    protected a f23084a;

    /* renamed from: c */
    private boolean f23086c;

    /* renamed from: b */
    private boolean f23085b = false;

    /* renamed from: d */
    private boolean f23087d = false;

    /* renamed from: e */
    private Handler f23088e = new Handler();

    /* renamed from: f */
    private Preference.OnPreferenceClickListener f23089f = new La(this);

    /* renamed from: g */
    private Runnable f23090g = new Ka(this);

    /* compiled from: SettingFragment.java */
    /* loaded from: classes2.dex */
    public interface a {
        void b(String str);
    }

    /* compiled from: SettingFragment.java */
    /* loaded from: classes2.dex */
    public static class b extends DialogFragment {

        /* renamed from: a */
        private static int f23091a;

        /* renamed from: b */
        private int f23092b;

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            ArrayList a2 = Ua.a();
            String[] strArr = new String[a2.size()];
            String string = getActivity().getSharedPreferences("sdcardloc", 0).getString("sdcardlocation", Environment.getExternalStorageDirectory().getAbsolutePath());
            f23091a = 0;
            for (int i = 0; i < a2.size(); i++) {
                strArr[i] = (String) a2.get(i);
                if (string.equalsIgnoreCase(strArr[i])) {
                    f23091a = i;
                }
            }
            this.f23092b = f23091a;
            builder.setTitle(R.string.pref_section_sdcard_dialog_title).setSingleChoiceItems(strArr, f23091a, new Xa(this, strArr)).setPositiveButton(R.string.mediabrowser_ok, new Wa(this, strArr)).setNegativeButton(R.string.button_cancel, new Va(this));
            return builder.create();
        }
    }

    private void d() {
        this.f23087d = true;
        if (Build.VERSION.SDK_INT > 18) {
            a("select_sdcard");
        }
        a("pref_logo_edit");
        if (!EditorGlobal.s) {
            a("report_anon_usage");
        }
        if (EditorGlobal.r != EditorGlobal.DataUsage.ASK_WIFI_OR_MOBILE) {
            a("mobile_updates");
        }
        if (EditorGlobal.r != EditorGlobal.DataUsage.ASK_WIFI_MOBILE_NEVER) {
            a("data_usage");
        }
        if (!c.d.b.c.a.a()) {
            a("pref_gdpr_echosystem");
            a("pref_gdpr_ads");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f23086c = defaultSharedPreferences.getBoolean("asset_dev_mode", false);
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
            onSharedPreferenceChanged(defaultSharedPreferences, "sorting_project");
            onSharedPreferenceChanged(defaultSharedPreferences, "add_img_def_crop");
            onSharedPreferenceChanged(defaultSharedPreferences, "add_img_def_duration");
            onSharedPreferenceChanged(defaultSharedPreferences, "add_layer_def_duration");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_audio");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_video");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_image");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_capture");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_converted");
            onSharedPreferenceChanged(defaultSharedPreferences, "savefiles_download");
            onSharedPreferenceChanged(defaultSharedPreferences, "asset_env");
            onSharedPreferenceChanged(defaultSharedPreferences, "asms_server_url");
            onSharedPreferenceChanged(defaultSharedPreferences, "asms_edition");
            onSharedPreferenceChanged(defaultSharedPreferences, "asset_level");
        }
        this.f23087d = false;
    }

    private void e() {
        Preference b2 = b("pref_gdpr_echosystem");
        if (b2 != null) {
            b2.setOnPreferenceClickListener(this.f23089f);
        }
        Preference b3 = b("pref_gdpr_ads");
        if (b3 != null) {
            b3.setOnPreferenceClickListener(this.f23089f);
        }
        k();
    }

    private void f() {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(getString(R.string.pref_message_title_asset_scope));
        builder.setMessage(getString(R.string.pref_message_message_asset_scope) + " [current scope: " + KineMasterApplication.m().q().h() + "]");
        final EditText editText = new EditText(activity);
        editText.setInputType(2);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        builder.setView(editText);
        builder.setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.settings.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Ua.this.a(editText, activity, dialogInterface, i);
            }
        });
        builder.setNegativeButton(getString(R.string.button_no), new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.settings.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void g() {
        Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(getString(R.string.pref_message_title_remote_config));
        builder.setMessage(getString(R.string.pref_message_message_remote_config));
        final EditText editText = new EditText(activity);
        editText.setInputType(1);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        builder.setView(editText);
        builder.setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.settings.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Ua.this.a(editText, dialogInterface, i);
            }
        });
        builder.setNegativeButton(getString(R.string.button_no), new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.settings.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void h() {
        e.a aVar = new e.a(getActivity());
        aVar.e(R.string.pref_confirm_reset_guide_balloons_title);
        aVar.c(R.string.pref_confirm_reset_guide_balloons);
        aVar.d(16);
        aVar.a(18);
        aVar.c(R.string.reset_guide_balloons_ok, new Na(this));
        aVar.a(R.string.reset_guide_balloons_cancel, new Ma(this));
        aVar.a().show();
    }

    private void i() {
        new b().show(getFragmentManager(), "fragment_sdcard_dialog");
    }

    private static ArrayList<String> j() {
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
                    if (str.contains(":")) {
                        str = str.substring(0, str.indexOf(":"));
                    }
                    if (!str.contains("usb")) {
                        int i = 0;
                        while (true) {
                            file = null;
                            if (i >= 100000) {
                                break;
                            }
                            file = new File(str, "._km_wrttest_" + i);
                            if (!file.exists()) {
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
                            } catch (IOException unused) {
                                z = false;
                            }
                            if (!file.delete()) {
                                Log.e("NexPrefsFrag", "Test file deletion failed : " + file);
                            }
                            if (!z) {
                            }
                        }
                        if (!arrayList.contains(str)) {
                            arrayList.add(str);
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

    private void k() {
        Preference b2 = b("pref_gdpr_echosystem");
        Preference b3 = b("pref_gdpr_ads");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("kk:mm");
        int i = R.string.settings_Privacy_Policy_manage_agree_msg;
        if (b2 != null) {
            Date date = new Date(c.d.b.c.a.b(getActivity()));
            b2.setSummary(getString(c.d.b.c.a.d(getActivity()) ? R.string.settings_Privacy_Policy_manage_agree_msg : R.string.settings_Privacy_Policy_manage_Disagree_msg, simpleDateFormat.format(date), simpleDateFormat2.format(date)));
        }
        if (b3 != null) {
            Date date2 = new Date(c.d.b.c.a.a(getActivity()));
            if (!c.d.b.c.a.c(getActivity())) {
                i = R.string.settings_Privacy_Policy_manage_Disagree_msg;
            }
            b3.setSummary(getString(i, simpleDateFormat.format(date2), simpleDateFormat2.format(date2)));
        }
    }

    protected abstract int b();

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8193) {
            String e2 = FullScreenInputActivity.e(intent);
            if (e2 == null || e2.trim().length() <= 0) {
                return;
            }
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(new File(EditorGlobal.c(), "test_name.txt"));
                    try {
                        fileWriter2.write(e2);
                        fileWriter2.close();
                    } catch (IOException unused) {
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            fileWriter.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
                return;
            } catch (IOException unused4) {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f23084a = (a) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnMediaBrowserFragmentListener");
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(b());
        e();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        this.f23088e.removeCallbacks(this.f23090g);
        if (PreferenceManager.getDefaultSharedPreferences(getActivity()) != null) {
            PreferenceManager.getDefaultSharedPreferences(getActivity()).unregisterOnSharedPreferenceChangeListener(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e9, code lost:            if (r0 == null) goto L148;     */
    @Override // android.preference.PreferenceFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onPreferenceTreeClick(android.preference.PreferenceScreen r4, android.preference.Preference r5) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.settings.Ua.onPreferenceTreeClick(android.preference.PreferenceScreen, android.preference.Preference):boolean");
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("asset_env") && !this.f23087d) {
            KineMasterApplication.m().q().c();
        }
        if (str.equals("asms_server_url") && !this.f23087d) {
            KineMasterApplication.m().q().c();
        }
        if (str.equals("asset_dev_mode")) {
            this.f23088e.removeCallbacks(this.f23090g);
            this.f23088e.postDelayed(this.f23090g, 200L);
        }
        this.f23085b = true;
        Preference b2 = b(str);
        boolean z = b2 instanceof ListPreference;
        if (z && (str.equals("add_img_def_duration") || str.equals("add_layer_def_duration"))) {
            ListPreference listPreference = (ListPreference) b2;
            listPreference.setSummary(getResources().getString(R.string.pref_img_def_duration_summary, listPreference.getEntry()));
        } else if (z) {
            ListPreference listPreference2 = (ListPreference) b2;
            listPreference2.setSummary(listPreference2.getEntry());
        } else if (str.equals("pref_gdpr_echosystem") || str.equals("pref_gdpr_ads") || str.equals("pref_gdpr_echosystem_submit_time") || str.equals("pref_gdpr_ads_submit_time")) {
            k();
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        if (!this.f23085b || getActivity() == null) {
            return;
        }
        this.f23085b = false;
        new JSONObject();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        getPreferenceScreen();
        defaultSharedPreferences.getAll();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        d();
    }

    private static boolean b(PreferenceGroup preferenceGroup, String str) {
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            if (preference.hasKey() && preference.getKey().equals(str)) {
                preferenceGroup.removePreference(preference);
                return true;
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (b(preferenceGroup2, str)) {
                    if (preferenceGroup2.getPreferenceCount() < 1) {
                        preferenceGroup.removePreference(preferenceGroup2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void c(Context context) {
        String b2 = b(context);
        TextView textView = new TextView(context);
        textView.setText("Diagnostic Information");
        textView.setTextSize(1, 25.0f);
        textView.setClickable(true);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-11184811);
        textView.setPadding(5, 5, 5, 5);
        textView.setOnTouchListener(new Qa(new int[]{10}, context));
        TextView textView2 = new TextView(context);
        textView2.setText(b2);
        textView2.setTextIsSelectable(true);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView2.setScrollBarStyle(16777216);
        new AlertDialog.Builder(context).setView(textView2).setCustomTitle(textView).setCancelable(true).setPositiveButton("OK", new Sa()).setNeutralButton("Copy to Clipboard", new Ra(context, b2)).show();
    }

    static /* synthetic */ ArrayList a() {
        return j();
    }

    public static void e(Context context) {
        new AlertDialog.Builder(context).setTitle("Config File Manager").setCancelable(false).setItems(new String[]{"Delete Config File", "Overwrite with: device support - STAGING", "Overwrite with: device support - DEV ", "Overwrite with: device support - LOCAL (in APK) ONLY ", "Overwrite with: theme server - DEV", "Overwrite with: notify and update server - DEV", "Overwrite with: using test sku - DEV", "Overwrite with: promocode with Only Inapp Test - DEV", "Overwrite with: changed Inapp module - DEV"}, new Ba(new File(Environment.getExternalStorageDirectory(), "kinemaster.cfg"), context)).setNegativeButton("Cancel", new Ta()).show();
    }

    public void a(String str) {
        b(getPreferenceScreen(), str);
    }

    private static Preference a(PreferenceGroup preferenceGroup, String str) {
        Preference a2;
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            if (preference.hasKey() && preference.getKey().equals(str)) {
                return preference;
            }
            if ((preference instanceof PreferenceGroup) && (a2 = a((PreferenceGroup) preference, str)) != null) {
                return a2;
            }
        }
        return null;
    }

    private Preference b(String str) {
        return a(getPreferenceScreen(), str);
    }

    public static String b(Context context) {
        String str;
        String str2;
        String str3;
        TLP.TLPResponseInfo a2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        NexEditor i = EditorGlobal.i();
        String d2 = FirebaseInstanceId.b().d();
        StringBuilder sb = new StringBuilder();
        String a3 = com.nextreaming.nexeditorui.E.c().a();
        if (a3 == null) {
            sb.append("Config: DEFAULT\n");
        } else {
            sb.append("Config:\n");
            sb.append(a3);
        }
        sb.append("----- DEVICE INFO -----\n");
        sb.append("Board: ");
        sb.append(Build.BOARD);
        sb.append("\n");
        sb.append("Product: ");
        sb.append(Build.PRODUCT);
        sb.append("\n");
        sb.append("Device: ");
        sb.append(Build.DEVICE);
        sb.append("\n");
        sb.append("Manufacturer: ");
        sb.append(Build.MANUFACTURER);
        sb.append("\n");
        sb.append("Model: ");
        sb.append(Build.MODEL);
        sb.append("\n");
        sb.append("Brand: ");
        sb.append(Build.BRAND);
        sb.append("\n");
        sb.append("Hardware: ");
        sb.append(Build.HARDWARE);
        sb.append("\n");
        sb.append("ROBoardPlat: ");
        sb.append(NexEditor.a("ro.board.platform"));
        sb.append("\n");
        sb.append("ROHardware: ");
        sb.append(NexEditor.a("ro.hardware"));
        sb.append("\n");
        sb.append("ROOther: ");
        sb.append(NexEditor.a("ro.mediatek.platform"));
        sb.append("\n");
        sb.append("----- OS VERSION -----\n");
        sb.append("Build: ");
        sb.append(Build.DISPLAY);
        sb.append("\n");
        sb.append("Release: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("\n");
        sb.append("Incremental: ");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append("\n");
        sb.append("Codename: ");
        sb.append(Build.VERSION.CODENAME);
        sb.append("\n");
        sb.append("SDK Level: ");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("\n");
        sb.append("----- APP INFO -----\n");
        sb.append("UUID: ");
        sb.append(com.nexstreaming.app.general.util.N.c(context));
        sb.append("\n");
        sb.append("Name: ");
        sb.append(com.nexstreaming.app.general.util.N.a(context));
        sb.append("\n");
        sb.append("Version: ");
        sb.append(com.nexstreaming.app.general.util.N.d(context));
        sb.append("\n");
        sb.append("Package: ");
        sb.append(com.nexstreaming.app.general.util.N.b(context));
        sb.append("\n");
        sb.append("----- FIREBASE -----\n");
        sb.append("InstanceId: ");
        if (d2 == null) {
            d2 = "null";
        }
        sb.append(d2);
        sb.append("\n");
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        if (deviceProfile != null) {
            NexEditorDeviceProfile.c captureSize = deviceProfile.getCaptureSize();
            sb.append("------ DEVICE PROFILE --------\n");
            sb.append("Match: ");
            sb.append(deviceProfile.getProfileSource().name());
            sb.append("\n");
            sb.append("Max FPS @ 2160p: ");
            sb.append(deviceProfile.getMaxSupportedFPS(2160, 3840));
            sb.append("\n");
            sb.append("Max FPS @ 1440p: ");
            sb.append(deviceProfile.getMaxSupportedFPS(1440, 2560));
            sb.append("\n");
            sb.append("Max FPS @ 1080p: ");
            sb.append(deviceProfile.getMaxSupportedFPS(1920, 1080));
            sb.append("\n");
            sb.append("Max FPS @ 720p: ");
            sb.append(deviceProfile.getMaxSupportedFPS(1280, 720));
            sb.append("\n");
            sb.append("1080pTMax: ");
            sb.append(deviceProfile.getFullHDMaxTransitionTime());
            sb.append("\n");
            sb.append("HW Dec Max: ");
            sb.append(deviceProfile.getHardwareDecMaxCount());
            sb.append("\n");
            sb.append("HW Enc Max: ");
            sb.append(deviceProfile.getHardwareEncMaxCount());
            sb.append("\n");
            sb.append("HW Mem Size: ");
            sb.append(deviceProfile.getHardwareCodecMemSize());
            sb.append("\n");
            sb.append("Image Rec: ");
            sb.append(deviceProfile.getImageRecordingMode().name());
            sb.append("\n");
            sb.append("Video Rec: ");
            sb.append(deviceProfile.getVideoRecordingMode().name());
            sb.append("\n");
            sb.append("JPEG Dec: ");
            sb.append(deviceProfile.getUseAndroidJPEGDecoder() ? "Android" : "KM");
            sb.append("\n");
            sb.append("Audio Codec Max: ");
            sb.append(deviceProfile.getAudioCodecMaxCount());
            sb.append("\n");
            sb.append("Media Extractor: ");
            sb.append(deviceProfile.getUseMediaExtractor() ? "supported" : "not supported");
            sb.append("\n");
            sb.append("Color Format Check: ");
            sb.append(deviceProfile.getNeedsColorFormatCheck() ? "necessary" : "skip");
            sb.append("\n");
            sb.append("SeekFastPreview: ");
            sb.append(deviceProfile.getNeedSeekBeforeFastPreview());
            sb.append("\n");
            sb.append("captureSize: ");
            sb.append(captureSize.f24096a);
            sb.append(FragmentC2201x.f23219a);
            sb.append(captureSize.f24097b);
            sb.append("\n");
            if (i != null) {
                NexExportProfile[] supportedExportProfiles = deviceProfile.getSupportedExportProfiles(i.b());
                if (supportedExportProfiles != null && supportedExportProfiles.length >= 1) {
                    sb.append("Export profiles:\n");
                    int i2 = 0;
                    for (NexExportProfile nexExportProfile : supportedExportProfiles) {
                        sb.append("    ");
                        sb.append(i2);
                        sb.append(": ");
                        sb.append(nexExportProfile.width());
                        sb.append(FragmentC2201x.f23219a);
                        sb.append(nexExportProfile.height());
                        sb.append(" bitrate=");
                        sb.append(nexExportProfile.bitrate());
                        sb.append(" dh=");
                        sb.append(nexExportProfile.displayHeight());
                        sb.append("\n");
                        i2++;
                    }
                } else {
                    sb.append("Export profiles: NONE\n");
                }
            }
            if (deviceProfile.getProfileSource() != NexEditorDeviceProfile.ProfileSource.Server || (a2 = TLP.a((Object) deviceProfile.getDSR())) == null) {
                str = FragmentC2201x.f23219a;
            } else {
                sb.append("Match Source:\n");
                sb.append("    from_cache: ");
                sb.append(a2.fromCache);
                sb.append("\n");
                sb.append("    original_src: ");
                sb.append(a2.originalSrc);
                sb.append("\n");
                if (a2.dataReceived < 1) {
                    sb.append("    last_update: UNKNOWN\n");
                    sb.append("    last_update_age: UNKNOWN\n");
                    str = FragmentC2201x.f23219a;
                } else {
                    sb.append("    last_update: ");
                    sb.append(simpleDateFormat.format(new Date(a2.dataReceived)));
                    sb.append("\n");
                    sb.append("    last_update_age: ");
                    Resources resources = context.getResources();
                    long currentTimeMillis = System.currentTimeMillis();
                    str = FragmentC2201x.f23219a;
                    sb.append(EditorGlobal.a(resources, (int) (currentTimeMillis - a2.dataReceived)).trim());
                    sb.append("\n");
                }
                if (a2.cacheExpiration < 1) {
                    sb.append("    cache_expiration: UNKNOWN\n");
                } else {
                    sb.append("    cache_expiration: ");
                    sb.append(simpleDateFormat.format(new Date(a2.cacheExpiration)));
                    sb.append("\n");
                }
                if (a2.cacheRefresh < 1) {
                    sb.append("    cache_refresh: UNKNOWN\n");
                } else {
                    sb.append("    cache_refresh: ");
                    sb.append(simpleDateFormat.format(new Date(a2.cacheRefresh)));
                    sb.append("\n");
                }
            }
            NexEditorDeviceProfile.a matchInfo = deviceProfile.getMatchInfo();
            if (matchInfo != null) {
                sb.append(matchInfo.a());
            }
        } else {
            str = FragmentC2201x.f23219a;
        }
        sb.append("------ RESOURCE PROFILE --------\n");
        Resources resources2 = context.getResources();
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        Configuration configuration = resources2.getConfiguration();
        sb.append("locale: ");
        sb.append(configuration.locale.getLanguage().toLowerCase(Locale.US));
        sb.append(configuration.locale.getCountry().length() > 0 ? "-r" + configuration.locale.getCountry().toUpperCase(Locale.US) : "");
        sb.append("\n");
        sb.append("smallest-width: sw");
        sb.append(configuration.smallestScreenWidthDp);
        sb.append("dp\n");
        sb.append("screen size: ");
        sb.append(configuration.screenWidthDp);
        String str4 = str;
        sb.append(str4);
        sb.append(configuration.screenHeightDp);
        sb.append("dp ");
        sb.append(displayMetrics.widthPixels);
        sb.append(str4);
        sb.append(displayMetrics.heightPixels);
        sb.append("px\n");
        int i3 = configuration.screenLayout & 15;
        if (i3 == 1) {
            str2 = "small ";
        } else if (i3 == 2) {
            str2 = "normal ";
        } else if (i3 == 3) {
            str2 = "large ";
        } else if (i3 != 4) {
            str2 = "unknown-screen-size ";
        } else {
            str2 = "xlarge ";
        }
        int i4 = configuration.screenLayout & 48;
        if (i4 == 16) {
            str2 = str2 + "notlong ";
        } else if (i4 == 32) {
            str2 = str2 + "long ";
        }
        int i5 = configuration.orientation;
        if (i5 == 1) {
            str2 = str2 + "port ";
        } else if (i5 == 2) {
            str2 = str2 + "land ";
        }
        sb.append("screen layout: ");
        sb.append(str2);
        sb.append("\n");
        int i6 = context.getResources().getDisplayMetrics().densityDpi;
        String str5 = i6 != 120 ? i6 != 160 ? i6 != 213 ? i6 != 240 ? i6 != 320 ? i6 != 480 ? i6 != 640 ? "? " : "xxxhdpi " : "xxhdpi " : "xhdpi " : "hdpi " : "tvdpi " : "mdpi " : "ldpi ";
        sb.append("density: ");
        sb.append(str5);
        sb.append(" (");
        sb.append(displayMetrics.densityDpi);
        sb.append("dpi; scale=");
        sb.append(displayMetrics.density);
        sb.append("x) \n");
        sb.append("font-scale: ");
        sb.append(configuration.fontScale);
        sb.append("\n");
        sb.append("------ KINEMASTER --------\n");
        Date date = new Date();
        sb.append("Time: ");
        sb.append(simpleDateFormat.format(date));
        sb.append("\n");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        sb.append("UTC: ");
        sb.append(simpleDateFormat.format(date));
        sb.append("\n");
        try {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str3 = "?";
        }
        sb.append("Version: ");
        sb.append(str3);
        sb.append("\n");
        if (i != null) {
            HashMap<String, Integer> e3 = i.e();
            int intValue = e3.get(NexEditor.EngineVersion.MAJOR.name()).intValue();
            int intValue2 = e3.get(NexEditor.EngineVersion.MINOR.name()).intValue();
            int intValue3 = e3.get(NexEditor.EngineVersion.PATCH.name()).intValue();
            int intValue4 = e3.get(NexEditor.EngineVersion.BUILD.name()).intValue();
            sb.append("Engine: ");
            sb.append(intValue);
            sb.append(".");
            sb.append(intValue2);
            sb.append(".");
            sb.append(intValue3);
            sb.append(".");
            sb.append(intValue4);
            sb.append("\n");
            sb.append("SWCodec: ");
            sb.append(i.b() ? "yes" : "no");
            sb.append('\n');
            ColorFormatChecker.ColorFormat d3 = i.d();
            if (d3 != null) {
                sb.append("Color Format: ");
                sb.append(d3.name());
                sb.append("\n");
            } else {
                sb.append("Color Format: (no check)\n");
            }
            NexVisualClipChecker i7 = i.i();
            if (i7 != null) {
                sb.append("SW Max Import: ");
                sb.append(a(i7.a(true)));
                sb.append("\n");
                sb.append("HW Max Import: ");
                sb.append(a(i7.a(false)));
                sb.append("\n");
                sb.append("MaxHardwareAVCDecBaselineSize: ");
                sb.append(a(i7.a()));
                sb.append("\n");
                sb.append("MaxHardwareAVCDecMainSize: ");
                sb.append(a(i7.c()));
                sb.append("\n");
                sb.append("MaxHardwareAVCDecHighSize: ");
                sb.append(a(i7.b()));
                sb.append("\n");
                sb.append("MaxHardwareAVCEncBaselineSize: ");
                sb.append(a(i7.d()));
                sb.append("\n");
                sb.append("MaxHardwareAVCEncMainSize: ");
                sb.append(a(i7.f()));
                sb.append("\n");
                sb.append("MaxHardwareAVCEncHighSize: ");
                sb.append(a(i7.e()));
                sb.append("\n");
                sb.append("MaxMCSoftwareAVCDecBaselineSize: ");
                sb.append(a(i7.h()));
                sb.append("\n");
                sb.append("MaxMCSoftwareAVCDecMainSize: ");
                sb.append(a(i7.j()));
                sb.append("\n");
                sb.append("MaxMCSoftwareAVCDecHighSize: ");
                sb.append(a(i7.i()));
                sb.append("\n");
            }
        }
        File o = EditorGlobal.o();
        sb.append("Projects: ");
        sb.append(o.getAbsolutePath());
        sb.append(" (");
        sb.append(o.getFreeSpace() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        sb.append("MB free)\n");
        sb.append("M_ID: ");
        sb.append(EditorGlobal.h());
        sb.append("\n");
        return sb.toString();
    }

    public /* synthetic */ void a(ResultTask resultTask, Task.Event event, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC1821j interfaceC1821j = (InterfaceC1821j) it.next();
            if (c() != null) {
                c().a(interfaceC1821j.b(), getActivity());
            }
        }
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        Toast.makeText(getActivity(), "Failed: " + taskError, 0).show();
    }

    private static String a(int i) {
        int[] iArr;
        if (i == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        int[] iArr2 = {180, 192, ModuleDescriptor.MODULE_VERSION, 352, 360, 368, 480, 540, 544, 640, 720, 736, 960, 1080, 1088, 1280, 1920, 2048};
        int length = iArr2.length;
        String str = null;
        int i2 = 0;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (i2 < length) {
            int i4 = iArr2[i2];
            int length2 = iArr2.length;
            int i5 = i3;
            String str2 = str;
            int i6 = 0;
            while (i6 < length2) {
                int i7 = iArr2[i6];
                if (i4 <= i7) {
                    iArr = iArr2;
                } else {
                    int i8 = i4 * i7;
                    if (i == i8) {
                        iArr = iArr2;
                        if (i4 / i7 < 2.0f) {
                            return "" + i4 + FragmentC2201x.f23219a + i7 + " (" + i + ")";
                        }
                    } else {
                        iArr = iArr2;
                    }
                    if (i4 / i7 < 2.0f) {
                        int i9 = i8 - i;
                        if (Math.abs(i9) < i5) {
                            i5 = Math.abs(i9);
                            int i10 = i - i8;
                            if (i10 > 0) {
                                str2 = "" + i4 + FragmentC2201x.f23219a + i7 + "+" + i10 + " (" + i + ")";
                            } else {
                                str2 = "" + i4 + FragmentC2201x.f23219a + i7 + "" + i10 + " (" + i + ")";
                            }
                        }
                    }
                }
                i6++;
                iArr2 = iArr;
            }
            i2++;
            str = str2;
            i3 = i5;
        }
        if (str != null) {
            return str;
        }
        return "" + i;
    }

    private IABManager c() {
        if (getActivity() == null || !(getActivity() instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) getActivity()).y();
    }

    public /* synthetic */ void a(EditText editText, Context context, DialogInterface dialogInterface, int i) {
        String trim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            trim = String.valueOf(5);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
        edit.putString("asset_level", trim);
        edit.apply();
        Toast.makeText(context, getString(R.string.pref_dialog_result_success_message), 0).show();
    }

    public static void d(Context context) {
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Set trigger time");
            builder.setMessage("Enter notification trigger seconds");
            EditText editText = new EditText(context);
            editText.setInputType(2);
            editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            builder.setView(editText);
            builder.setPositiveButton("YES", new Oa(editText, context));
            builder.setNegativeButton("NO", new Pa());
            builder.show();
        }
    }

    public /* synthetic */ void a(EditText editText, DialogInterface dialogInterface, int i) {
        String trim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || c() == null) {
            return;
        }
        c().c(trim);
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

    public static void b(Context context, File file) {
        new AlertDialog.Builder(context).setTitle("Select Inapp Module").setCancelable(false).setItems(new String[]{"Google", "XiaoMi", "Wechat"}, new Ha(context, file)).setNegativeButton("Cancel", new Ca()).show();
    }
}
