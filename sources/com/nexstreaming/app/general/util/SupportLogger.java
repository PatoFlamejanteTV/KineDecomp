package com.nexstreaming.app.general.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class SupportLogger {

    /* renamed from: a */
    public static final SupportLogger f19845a = new SupportLogger();

    /* renamed from: b */
    private int[] f19846b = new int[256];

    /* renamed from: c */
    private int f19847c = 0;

    /* renamed from: d */
    private int f19848d = 0;

    /* renamed from: e */
    private Event f19849e = null;

    /* renamed from: f */
    private int f19850f = 0;

    /* loaded from: classes2.dex */
    public enum Abbreviation {
        KineMasterBaseActivity(1),
        ProjectEditActivity(2),
        ShareBaseActivity(3),
        ShareQualityActivity(4),
        ProjectGalleryActivity(5),
        SettingsActivity(6),
        HelpActivity(7),
        FontBrowserActivity(8),
        NewProjectActivity(9),
        ShareActivity(10),
        ShareSubscriptionActivity(11),
        FullScreenInputActivity(12),
        PreviewPlayActivity(13),
        CamcorderPreviewActivity(14),
        SupportAppsActivity(15),
        ShareSNSActivity(16),
        ExpiredActivity(17),
        BailActivity(18),
        CamcorderActivity(19),
        NexSNSUploadActivity(20),
        NexCloudUploadActivity(21),
        KMMediaStoreActivity(22),
        RelaunchActivity(23);

        public final int code;

        Abbreviation(int i) {
            this.code = i;
        }

        public static Abbreviation forString(String str) {
            for (Abbreviation abbreviation : values()) {
                if (abbreviation.name().equals(str)) {
                    return abbreviation;
                }
            }
            return null;
        }

        public static Abbreviation forStringIgnoreCase(String str) {
            for (Abbreviation abbreviation : values()) {
                if (abbreviation.name().equalsIgnoreCase(str)) {
                    return abbreviation;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public enum Event {
        Seek(1),
        SeekFail(2),
        SeekDeferred(3),
        Stop(4),
        BaseActivity_OnCreate(5),
        BaseActivity_OnDestroy(6),
        BaseActivity_OnPause(7),
        BaseActivity_OnStart(8),
        BaseActivity_OnResume(9),
        BaseActivity_OnStop(10),
        BaseActivity_OnRestart(11),
        Export_In(12),
        Export_Fail(13),
        Export_Start(14),
        Export_ProjectLoaded(15),
        Export_MediaTaskNotBusy(16),
        Export_DetectAndSetColorFormat(17),
        Export_GetEffectLibrary(18),
        Export_Prep(19),
        Export_SignalFail(20),
        Export_SignalCancel(21),
        Export_SignalSuccess(22),
        Export_RemoveOutOutputFile(23),
        Export_BeginSeek(24),
        Export_SeekComplete(25),
        Export_CompleteEventFromEngine(26),
        Export_ScanComplete(27),
        Activity_ShareQuality_OnCreate(28),
        Activity_ShareQuality_OnProjectInfoAvailable(29),
        Activity_ShareQuality_ExportQualityClick(30),
        BaseActivity_PAC(31),
        BaseActivity_DTL(32),
        ShareBaseActivity_Export(33),
        ShareBaseActivity_ExportFileExists(34),
        ShareBaseActivity_BeginGetPurchases(35),
        ShareBaseActivity_GetPurchasesComplete(36),
        ShareBaseActivity_MadeExportTask(37),
        ShareBaseActivity_MadeExportDialog(38),
        ExportDialogFragment_SetExportTask(39),
        ExportDialogFragment_OnCreate(40),
        ExportDialogFragment_OnCreateDialog(41),
        ExportDialogFragment_ShowCompletionDialog(42),
        ExportDialogFragment_ShowFailureDialog(43),
        ExportDialogFragment_OnFail(44),
        ExportDialogFragment_OnExportComplete(45),
        Export_Progress(46),
        IW_Subs_Success(47),
        IW_Subs_Failure(48),
        IW_Once_Success(49),
        IW_Once_Failure(50),
        IH_Service_Disconnected(51),
        IH_ResponseCode(52),
        IH_RemoteException(53),
        IH_GetSkuFail(54),
        ShareBaseActivity_APC(55),
        ShareBaseActivity_APCFail(56),
        KineMaster_App_Started(57),
        Export_PossibleFailItem(58);

        public final int code;

        Event(int i) {
            this.code = i;
        }

        public void log(int... iArr) {
            SupportLogger.f19845a.a(this, iArr);
        }
    }

    private SupportLogger() {
    }

    public void a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("supportLogger", null);
        int i = defaultSharedPreferences.getInt("supportLoggerCut", 0);
        if (string != null) {
            this.f19847c = 0;
            this.f19848d = i;
            for (String str : string.split(",")) {
                try {
                    int parseInt = Integer.parseInt(str);
                    int i2 = this.f19847c;
                    int[] iArr = this.f19846b;
                    if (i2 < iArr.length) {
                        this.f19847c = i2 + 1;
                        iArr[i2] = parseInt;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            int[] iArr2 = this.f19846b;
            if ((i < iArr2.length / 3 && this.f19847c > (iArr2.length * 2) / 3) || i > (this.f19846b.length * 2) / 3 || i > this.f19847c) {
                this.f19847c = 0;
                this.f19848d = 0;
            }
        }
        Event.KineMaster_App_Started.log(new int[0]);
    }

    public void b(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f19847c; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this.f19846b[i]);
        }
        defaultSharedPreferences.edit().putString("supportLogger", sb.toString()).putInt("supportLoggerCut", this.f19848d).apply();
    }

    public synchronized void a(Event event, int... iArr) {
        if (event == this.f19849e && event == Event.Seek) {
            this.f19850f++;
            return;
        }
        if (this.f19847c + iArr.length + 4 > this.f19846b.length) {
            System.arraycopy(this.f19846b, this.f19848d, this.f19846b, 0, this.f19847c - this.f19848d);
            this.f19847c -= this.f19848d;
            this.f19848d = 0;
        }
        if (this.f19850f > 0) {
            if (this.f19850f == 1) {
                int[] iArr2 = this.f19846b;
                int i = this.f19847c;
                this.f19847c = i + 1;
                iArr2[i] = -2;
            } else {
                int[] iArr3 = this.f19846b;
                int i2 = this.f19847c;
                this.f19847c = i2 + 1;
                iArr3[i2] = -1;
                int[] iArr4 = this.f19846b;
                int i3 = this.f19847c;
                this.f19847c = i3 + 1;
                iArr4[i3] = this.f19850f;
            }
            this.f19850f = 0;
        }
        this.f19849e = event;
        int[] iArr5 = this.f19846b;
        int i4 = this.f19847c;
        this.f19847c = i4 + 1;
        iArr5[i4] = event.code;
        int[] iArr6 = this.f19846b;
        int i5 = this.f19847c;
        this.f19847c = i5 + 1;
        iArr6[i5] = iArr.length;
        for (int i6 : iArr) {
            int[] iArr7 = this.f19846b;
            int i7 = this.f19847c;
            this.f19847c = i7 + 1;
            iArr7[i7] = i6;
        }
        if (this.f19847c > this.f19846b.length / 2 && this.f19848d < 1) {
            this.f19848d = this.f19847c;
        }
    }
}
