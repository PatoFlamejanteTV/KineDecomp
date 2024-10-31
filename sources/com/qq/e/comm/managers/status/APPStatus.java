package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;

/* loaded from: classes3.dex */
public class APPStatus {

    /* renamed from: a */
    private String f24998a;

    /* renamed from: b */
    private Context f24999b;

    public APPStatus(String str, Context context) {
        this.f24998a = str;
        this.f24999b = context;
    }

    public String getAPPID() {
        return this.f24998a;
    }

    public String getAPPName() {
        return this.f24999b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f24999b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f24999b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f24999b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
