package com.nexstreaming.kinemaster.codeccaps;

import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.ui.settings.U;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Locale;

/* compiled from: AnalyticsCapaReporter.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1715c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f20095a = false;

    private static String a(Enum<?> r0) {
        return r0 == null ? "null" : r0.name();
    }

    public static void b() {
        if (!f20095a) {
            a();
        }
        f20095a = true;
    }

    public static void a() {
        int r;
        int i;
        int i2;
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        boolean b2 = EditorGlobal.i().b();
        int maxImportHeight = deviceProfile.getMaxImportHeight(b2, true);
        int maxTranscodingHeight = deviceProfile.getMaxTranscodingHeight(b2);
        if (CapabilityManager.f20040b.t()) {
            r = deviceProfile.getSupportsVideoLayers(b2) ? 2 : 0;
        } else {
            r = CapabilityManager.f20040b.r();
        }
        CapabilityReport.CapabilityInfo b3 = CapabilityManager.f20040b.b();
        int i3 = -1;
        if (b3 != null) {
            int i4 = b3.maxImportResolutionWithOverlap;
            int i5 = b3.maxImportResolutionNoOverlap;
            i2 = b3.supportLevel;
            i = i4;
            i3 = i5;
        } else {
            i = -1;
            i2 = -1;
        }
        CapabilityManager.f20040b.c();
        NexEditorDeviceProfile.ProfileSource profileSource = deviceProfile.getProfileSource();
        String name = profileSource == null ? "null" : profileSource.name();
        String[] strArr = new String[34];
        strArr[0] = "maxImportHeight";
        strArr[1] = maxImportHeight + "";
        strArr[2] = "maxTranscodingHeight";
        strArr[3] = maxTranscodingHeight + "";
        strArr[4] = "maxVideoLayers";
        strArr[5] = r + "";
        strArr[6] = "defaultCapabilityMode";
        strArr[7] = a(CapabilityManager.f20040b.k());
        strArr[8] = "legacy";
        strArr[9] = CapabilityManager.f20040b.t() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        strArr[10] = "maxImportResolutionNoOverlap";
        strArr[11] = i3 + "";
        strArr[12] = "maxImportResolutionWithOverlap";
        strArr[13] = i + "";
        strArr[14] = "profileSource";
        strArr[15] = name;
        strArr[16] = "supportLevel";
        strArr[17] = i2 + "";
        strArr[18] = "chipset";
        strArr[19] = c.d.b.a.a.f3576b.e();
        strArr[20] = "chipsetEx";
        strArr[21] = c.d.b.a.a.f3576b.d();
        strArr[22] = "model";
        strArr[23] = Build.MODEL;
        strArr[24] = "manufacturer";
        strArr[25] = Build.MANUFACTURER;
        strArr[26] = "product";
        strArr[27] = Build.PRODUCT;
        strArr[28] = com.umeng.commonsdk.proguard.e.w;
        strArr[29] = "Android/" + Build.VERSION.RELEASE;
        strArr[30] = "km";
        strArr[31] = U.b(KineMasterApplication.f24056d.getApplicationContext());
        strArr[32] = "peakCodecPerformance";
        strArr[33] = String.format(Locale.ENGLISH, "%.1f", Float.valueOf(deviceProfile.getHardwareCodecMemSize() / 1048576.0f));
    }
}
