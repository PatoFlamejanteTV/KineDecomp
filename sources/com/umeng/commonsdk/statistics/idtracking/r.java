package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.os.Environment;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: UTDIdTracker.java */
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: a */
    private static final String f26442a = "utdid";

    /* renamed from: b */
    private static final String f26443b = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: c */
    private static final Pattern f26444c = Pattern.compile("UTDID\">([^<]+)");

    /* renamed from: d */
    private Context f26445d;

    public r(Context context) {
        super(f26442a);
        this.f26445d = context;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f26444c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String g() {
        File h2 = h();
        if (h2 != null && h2.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(h2);
                try {
                    return b(HelperUtils.readStreamToString(fileInputStream));
                } finally {
                    HelperUtils.safeClose(fileInputStream);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private File h() {
        if (DeviceConfig.checkPermission(this.f26445d, f26443b) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return (String) Class.forName("c.g.a.a").getMethod("getUtdid", Context.class).invoke(null, this.f26445d);
        } catch (Exception unused) {
            return g();
        }
    }
}
