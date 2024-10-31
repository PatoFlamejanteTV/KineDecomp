package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;

/* compiled from: OldUMIDTracker.java */
/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: a */
    private static final String f26422a = "oldumid";

    /* renamed from: b */
    private Context f26423b;

    /* renamed from: c */
    private String f26424c;

    /* renamed from: d */
    private String f26425d;

    public i(Context context) {
        super(f26422a);
        this.f26424c = null;
        this.f26425d = null;
        this.f26423b = context;
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void j() {
        try {
            b("/data/local/tmp/.um");
            HelperUtils.writeFile(new File("/data/local/tmp/.um/sysid.dat"), this.f26425d);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            b("/sdcard/Android/obj/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f26425d);
        } catch (Throwable unused) {
        }
    }

    private void l() {
        try {
            b("/sdcard/Android/data/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/data/.um/sysid.dat"), this.f26425d);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return this.f26424c;
    }

    public boolean g() {
        return h();
    }

    public boolean h() {
        this.f26425d = UMEnvelopeBuild.imprintProperty(this.f26423b, com.umeng.commonsdk.proguard.e.f26239f, null);
        if (TextUtils.isEmpty(this.f26425d)) {
            return false;
        }
        this.f26425d = DataHelper.encryptBySHA1(this.f26425d);
        String readFile = HelperUtils.readFile(new File("/sdcard/Android/data/.um/sysid.dat"));
        String readFile2 = HelperUtils.readFile(new File("/sdcard/Android/obj/.um/sysid.dat"));
        String readFile3 = HelperUtils.readFile(new File("/data/local/tmp/.um/sysid.dat"));
        if (TextUtils.isEmpty(readFile)) {
            l();
        } else if (!this.f26425d.equals(readFile)) {
            this.f26424c = readFile;
            return true;
        }
        if (TextUtils.isEmpty(readFile2)) {
            k();
        } else if (!this.f26425d.equals(readFile2)) {
            this.f26424c = readFile2;
            return true;
        }
        if (TextUtils.isEmpty(readFile3)) {
            j();
            return false;
        }
        if (this.f26425d.equals(readFile3)) {
            return false;
        }
        this.f26424c = readFile3;
        return true;
    }

    public void i() {
        try {
            l();
            k();
            j();
        } catch (Exception unused) {
        }
    }
}
