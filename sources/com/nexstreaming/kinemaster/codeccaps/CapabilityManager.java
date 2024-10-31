package com.nexstreaming.kinemaster.codeccaps;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.a.a.b.b.c;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.kinemaster.module.network.kinemaster.service.dci.error.DciServiceException;
import com.nexstreaming.app.general.util.C1699c;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes.dex */
public class CapabilityManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20039a = "CapabilityManager";

    /* renamed from: b, reason: collision with root package name */
    public static final CapabilityManager f20040b = new CapabilityManager();

    /* renamed from: c, reason: collision with root package name */
    private static final d f20041c = new d("km.capmgr.custom.mcms", 2764800);

    /* renamed from: d, reason: collision with root package name */
    private static final d f20042d = new d("km.capmgr.custom.maxCodecCount", 3);

    /* renamed from: e, reason: collision with root package name */
    private static final d f20043e = new d("km.capmgr.custom.maxTranscodeRes", 1080);

    /* renamed from: f, reason: collision with root package name */
    private static final d f20044f = new d("km.capmgr.custom.maxImportRes", 720);

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f20045g = {114, 27, 105, 106, 11, 29, 24, 60, 26, 34, 65, 12, 113, 87, 106, 23};

    /* renamed from: h, reason: collision with root package name */
    private CapabilityReport.CapabilityInfo f20046h = null;
    private CapabilityMode i = null;
    private CapabilityMode j = null;
    private CapabilitySource k = null;
    private boolean l = false;
    private String m = null;

    /* loaded from: classes.dex */
    public enum CapabilityMode {
        MAXIMIZE_FEATURES,
        MAXIMIZE_RESOLUTION,
        LEGACY;

        public static CapabilityMode fromValue(int i) {
            if (i == -1) {
                return null;
            }
            if (i == 0) {
                return MAXIMIZE_FEATURES;
            }
            if (i != 1) {
                return LEGACY;
            }
            return MAXIMIZE_RESOLUTION;
        }
    }

    /* loaded from: classes.dex */
    public enum CapabilitySource {
        AUTO,
        OLD_DB,
        CUSTOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private a() {
        }

        protected SharedPreferences a() {
            return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
        }

        /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f20047a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20048b;

        /* synthetic */ b(String str, int i, v vVar) {
            this(str, i);
        }

        private b(String str, int i) {
            this.f20047a = str;
            this.f20048b = i;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends a {

        /* renamed from: a, reason: collision with root package name */
        private final int f20049a;

        /* renamed from: b, reason: collision with root package name */
        private final String f20050b;

        /* renamed from: c, reason: collision with root package name */
        private int f20051c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f20052d;

        public d(String str, int i) {
            super(null);
            this.f20049a = i;
            this.f20050b = str;
        }

        public void a(int i) {
            if (i != b()) {
                this.f20051c = i;
                this.f20052d = true;
                a().edit().putInt(this.f20050b, this.f20051c).apply();
            }
        }

        public int b() {
            if (!this.f20052d) {
                this.f20051c = a().getInt(this.f20050b, this.f20049a);
                this.f20052d = true;
            }
            return this.f20051c;
        }
    }

    private CapabilityManager() {
    }

    public static int a(int i, int i2) {
        return (((i - 1) | 15) + 1) * (((i2 - 1) | 15) + 1);
    }

    private void v() {
        String str;
        String str2;
        String c2 = c.d.b.a.a.f3576b.c();
        b a2 = a(c2 + "." + c.d.b.a.a.f3576b.f().h());
        if (a2 != null) {
            str = a2.f20047a;
            str2 = "Db" + a2.f20048b + "V";
        } else {
            b a3 = a(c2);
            if (a3 != null) {
                String str3 = a3.f20047a;
                str2 = "Db" + a3.f20048b + "C";
                str = str3;
            } else {
                str = null;
                str2 = "";
            }
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f20046h = (CapabilityReport.CapabilityInfo) new Gson().fromJson(str, CapabilityReport.CapabilityInfo.class);
            this.m = str2;
        } catch (Exception e2) {
            Log.e(f20039a, e2.getMessage(), e2);
        }
    }

    public CapabilityReport.CapabilityInfo a() {
        if (this.j == CapabilityMode.LEGACY) {
            return null;
        }
        return b();
    }

    public CapabilityReport.CapabilityInfo b() {
        String string;
        c.c.a.a.a.b.b.a.a.a a2;
        if (!this.l) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
            String string2 = defaultSharedPreferences.getString("km.capmgr.capinfo", null);
            String string3 = defaultSharedPreferences.getString("km.capmgr.captag", null);
            if (string2 != null && string3 != null) {
                if (com.nexstreaming.app.general.util.J.a(string2 + c.d.b.a.a.f3576b.c() + 7).equals(string3)) {
                    this.f20046h = (CapabilityReport.CapabilityInfo) new Gson().fromJson(string2, CapabilityReport.CapabilityInfo.class);
                    this.m = "Ck7";
                }
            }
            if (this.f20046h == null && (string = KineMasterApplication.f24056d.getApplicationContext().getSharedPreferences("capabilityInfo", 0).getString("CapaInfos", null)) != null && (a2 = c.c.a.a.a.b.b.a.a.a.a(string)) != null) {
                try {
                    this.f20046h = CapabilityReport.CapabilityInfo.fromInfo(a2);
                    this.f20046h.versionNum = 1;
                    if (a2.f3527g < new Date().getTime() - c.d.b.b.i.d().e()) {
                        a((c) null);
                    }
                } catch (Exception unused) {
                    this.f20046h = null;
                }
            }
            if (this.f20046h == null) {
                v();
            }
            this.l = true;
        }
        return this.f20046h;
    }

    public String c() {
        return this.m;
    }

    public CapabilityMode d() {
        CapabilityReport.CapabilityInfo a2;
        if (this.j == null) {
            this.j = k();
        }
        if (this.j != CapabilityMode.LEGACY && (a2 = a()) != null && a2.legacyOnly) {
            this.j = CapabilityMode.LEGACY;
        }
        return this.j;
    }

    public CapabilitySource e() {
        if (this.k == null) {
            this.k = CapabilitySource.valueOf(PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getString("km.capmgr.src", CapabilitySource.AUTO.name()));
        }
        return this.k;
    }

    public String f() {
        return (!t() && s()) ? a().versionNum != 0 ? "FS" : "FF" : "FL";
    }

    public int g() {
        return f20041c.b();
    }

    public int h() {
        return f20042d.b();
    }

    public int i() {
        return f20044f.b();
    }

    public int j() {
        return f20043e.b();
    }

    public CapabilityMode k() {
        CapabilityMode capabilityMode;
        if (a() == null) {
            return null;
        }
        if (this.i == null) {
            if (a().maxImportResolutionWithOverlap >= a().maxImportResolutionNoOverlap) {
                return CapabilityMode.MAXIMIZE_FEATURES;
            }
            if (a().maxImportResolutionWithOverlap <= 0) {
                return CapabilityMode.MAXIMIZE_RESOLUTION;
            }
            if (a().maxImportResolutionWithOverlap >= 720) {
                capabilityMode = CapabilityMode.MAXIMIZE_FEATURES;
            } else {
                capabilityMode = CapabilityMode.MAXIMIZE_RESOLUTION;
            }
            this.i = CapabilityMode.valueOf(PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getString("km.capmgr.mode", capabilityMode.name()));
        }
        return this.i;
    }

    public String l() {
        String str;
        String str2;
        String str3;
        String str4;
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        CapabilityMode k = f20040b.k();
        if (k == null) {
            str = "X";
        } else if (k == CapabilityMode.LEGACY) {
            str = "L";
        } else if (k == CapabilityMode.MAXIMIZE_FEATURES) {
            str = "F";
        } else if (k == CapabilityMode.MAXIMIZE_RESOLUTION) {
            str = "R";
        } else {
            str = "Q";
        }
        String c2 = f20040b.c();
        StringBuilder sb = new StringBuilder();
        sb.append(str + "-");
        if (c2 == null) {
            c2 = "X";
        }
        sb.append(c2);
        sb.append("-");
        String sb2 = sb.toString();
        CapabilityReport.CapabilityInfo b2 = f20040b.b();
        if (b2 == null) {
            str2 = sb2 + "X";
        } else {
            str2 = sb2 + b2.supportLevel;
        }
        NexEditorDeviceProfile.ProfileSource profileSource = deviceProfile.getProfileSource();
        if (profileSource == NexEditorDeviceProfile.ProfileSource.Local) {
            str3 = str2 + "-L";
        } else if (profileSource == NexEditorDeviceProfile.ProfileSource.Server) {
            str3 = str2 + "-S";
        } else if (profileSource == NexEditorDeviceProfile.ProfileSource.Unknown) {
            str3 = str2 + "-U";
        } else {
            str3 = str2 + "-X";
        }
        NexEditorDeviceProfile.a matchInfo = deviceProfile.getMatchInfo();
        if (matchInfo == null) {
            str4 = str3 + "X";
        } else {
            str4 = str3 + matchInfo.f24086a;
        }
        return "DC" + com.nexstreaming.app.general.util.J.a(str4).substring(0, 3) + "-" + str4;
    }

    public int m() {
        return a().maxCodecMemorySize;
    }

    public int n() {
        return a().maxCodecMemorySize - a((p() * 16) / 9, p());
    }

    public int o() {
        return a().maxCodecMemorySize - (a((p() * 16) / 9, p()) * 2);
    }

    public int p() {
        int i = v.f20136a[d().ordinal()];
        if (i == 1) {
            return a().maxImportResolutionNoOverlap;
        }
        if (i != 2) {
            return NexEditorDeviceProfile.getDeviceProfile().getMaxImportSize(EditorGlobal.i().b(), true);
        }
        return a().maxImportResolutionWithOverlap;
    }

    public int q() {
        return a().maxPlaybackCodecMemorySize;
    }

    public int r() {
        return EditorGlobal.w() ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : a(d());
    }

    public boolean s() {
        return a() != null;
    }

    public boolean t() {
        if (this.j == null) {
            d();
        }
        return a() == null;
    }

    public void u() {
        NexEditor s = KineMasterApplication.f24056d.s();
        if (s != null) {
            s.closeProject();
            s.b(-1, -1, -1);
            s.createProject();
            s.q();
        }
    }

    public void c(CapabilityMode capabilityMode) {
        if (capabilityMode == null) {
            capabilityMode = CapabilityMode.MAXIMIZE_FEATURES;
        }
        if (this.i != capabilityMode) {
            this.i = capabilityMode;
            PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).edit().putString("km.capmgr.mode", capabilityMode.name()).apply();
            com.nexstreaming.kinemaster.mediastore.item.b.k();
            NexEditorDeviceProfile.getDeviceProfile().resetTranscodeProfile();
            NexEditor s = KineMasterApplication.f24056d.s();
            if (s != null) {
                s.q();
            }
        }
    }

    public void g(int i) {
        f20041c.a(i);
    }

    public void h(int i) {
        f20042d.a(i);
    }

    public void i(int i) {
        f20044f.a(i);
    }

    public void j(int i) {
        f20043e.a(i);
    }

    public void a(final c cVar) {
        String c2 = c.d.b.a.a.f3576b.c();
        String str = Build.PRODUCT;
        String str2 = Build.MODEL;
        int h2 = c.d.b.a.a.f3576b.f().h();
        final SharedPreferences sharedPreferences = KineMasterApplication.f24056d.getApplicationContext().getSharedPreferences("capabilityInfo", 0);
        c.c.a.a.a.a.a(KineMasterApplication.f24056d.getApplicationContext()).a(c2, h2, str2, str, new c.b() { // from class: com.nexstreaming.kinemaster.codeccaps.b
            @Override // c.c.a.a.a.b.b.c.b
            public final void onSuccess(Object obj) {
                CapabilityManager.this.a(cVar, sharedPreferences, (c.c.a.a.a.b.b.a.a.a) obj);
            }
        }, new c.a() { // from class: com.nexstreaming.kinemaster.codeccaps.a
            @Override // c.c.a.a.a.b.b.c.a
            public final void a(DciServiceException dciServiceException) {
                CapabilityManager.a(CapabilityManager.c.this, dciServiceException);
            }
        });
    }

    public int f(int i) {
        return !s() ? i : a().maxTranscodeResolution;
    }

    public int e(int i) {
        if (!s()) {
            return i;
        }
        int i2 = v.f20136a[d().ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i : a().maxImportResolutionWithOverlap;
        }
        return a().maxImportResolutionNoOverlap;
    }

    public int d(int i) {
        if (!s()) {
            return i;
        }
        int i2 = v.f20136a[d().ordinal()];
        if (i2 == 1) {
            int i3 = a().maxImportResolutionNoOverlap;
            return a((i3 * 16) / 9, i3);
        }
        if (i2 != 2) {
            return i;
        }
        int i4 = a().maxImportResolutionWithOverlap;
        return a((i4 * 16) / 9, i4);
    }

    public /* synthetic */ void a(c cVar, SharedPreferences sharedPreferences, c.c.a.a.a.b.b.a.a.a aVar) {
        aVar.f3527g = new Date().getTime();
        if (cVar != null) {
            try {
                CapabilityReport.CapabilityInfo fromInfo = CapabilityReport.CapabilityInfo.fromInfo(aVar);
                fromInfo.versionNum = 1;
                this.f20046h = fromInfo;
                u();
                cVar.a(true);
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.a(false);
                    return;
                }
                return;
            }
        }
        sharedPreferences.edit().putString("CapaInfos", aVar.toString()).apply();
    }

    public int c(int i) {
        if (!s() || t()) {
            return i;
        }
        int i2 = v.f20136a[d().ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i : a().maxCodecCount;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, DciServiceException dciServiceException) {
        if (cVar != null) {
            cVar.a(false);
        }
        Log.d(f20039a, "[fetchCapabilityInfoFromServer] error: " + dciServiceException.toString());
    }

    private static b a(String str) {
        C1699c c1699c;
        String e2;
        v vVar = null;
        try {
            c1699c = new C1699c(KineMasterApplication.f24056d.getApplicationContext().getAssets().open("km_device_capability_chipset_v1.csv"));
            e2 = c1699c.e(str);
        } catch (JsonSyntaxException e3) {
            Log.e(f20039a, e3.getMessage(), e3);
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (e2 != null) {
            return new b(e2, 0, vVar);
        }
        C1702f.a(c1699c);
        return null;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(CapabilityReport.CapabilityInfo capabilityInfo, String str, boolean z) {
        if (capabilityInfo.maxImportResolutionWithOverlap == 0 && capabilityInfo.maxImportResolutionNoOverlap == 0) {
            z = false;
        }
        if (z) {
            Gson gson = new Gson();
            this.f20046h = capabilityInfo;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
            String json = gson.toJson(capabilityInfo);
            String a2 = com.nexstreaming.app.general.util.J.a(json + c.d.b.a.a.f3576b.c() + 7);
            if (z) {
                defaultSharedPreferences.edit().putString("km.capmgr.capinfo", json).putString("km.capmgr.captag", a2).commit();
            }
            this.l = true;
            this.m = str;
        }
        com.nexstreaming.kinemaster.mediastore.item.b.k();
        NexEditorDeviceProfile.getDeviceProfile().resetTranscodeProfile();
        this.i = null;
        this.j = null;
        k();
    }

    public void b(CapabilityMode capabilityMode) {
        if (this.j != capabilityMode) {
            MediaInfo.l();
            com.nexstreaming.kinemaster.mediastore.item.b.k();
            NexEditor s = KineMasterApplication.f24056d.s();
            if (s != null) {
                s.q();
            }
        }
        this.j = capabilityMode;
    }

    public int b(int i) {
        return !s() ? i : (a().maxCodecMemorySize * 15) / 10;
    }

    public int b(int i, int i2, int i3, int i4) {
        if (!s()) {
            return i4;
        }
        return Math.max(30, Math.min(60, (q() * 30) / ((a(i, i2) * i3) / 30)));
    }

    public void a(CapabilitySource capabilitySource) {
        if (capabilitySource == null) {
            capabilitySource = CapabilitySource.AUTO;
        }
        if (this.k != capabilitySource) {
            this.k = capabilitySource;
            PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).edit().putString("km.capmgr.src", capabilitySource.name()).apply();
        }
    }

    public int a(int i) {
        return !s() ? i : a().maxCodecMemorySize;
    }

    public int a(CapabilityMode capabilityMode) {
        CapabilityReport.CapabilityInfo b2;
        if (capabilityMode == CapabilityMode.MAXIMIZE_RESOLUTION || (b2 = b()) == null) {
            return 0;
        }
        if (b2.legacyOnly) {
            return NexEditorDeviceProfile.getDeviceProfile().getLegacyVideoLayerCount();
        }
        int i = b2.maxCodecCountAtMaxImportResWithOverlap;
        if (i > 0) {
            return Math.max(0, i - 2);
        }
        int i2 = b2.maxImportResolutionWithOverlap;
        Integer valueOf = Integer.valueOf(b2.maxCodecCountAtMaxImportResNoSkipping);
        if (valueOf.intValue() <= 0) {
            valueOf = b2.codecInstanceCountByResolutionMinorSkipping.get(Integer.valueOf(i2));
        }
        if (valueOf == null) {
            return Math.max(0, a().maxCodecCountAtMaxImportRes - 2);
        }
        return Math.max(0, Math.min(valueOf.intValue(), a().maxCodecCountAtMaxImportRes) - 2);
    }

    public int a(int i, int i2, int i3) {
        if (!s()) {
            return i3;
        }
        return Math.max(35, Math.min(65, (q() * 30) / a(i, i2)));
    }

    public static int a(int i, int i2, int i3, int i4) {
        long a2 = a(i, i2);
        if (i3 <= 0) {
            i3 = 100;
        } else if (i3 > 100) {
            i3 = Math.max(100, i3 - 50);
        } else if (i3 < 50) {
            i3 = 50;
        }
        if (i4 <= 0) {
            i4 = 30;
        } else if (i4 < 15) {
            i4 = 15;
        } else if (i4 > 30) {
            i4 = Math.max(30, i4 - 15);
        }
        return (int) (((a2 * i3) * i4) / 3000);
    }
}
