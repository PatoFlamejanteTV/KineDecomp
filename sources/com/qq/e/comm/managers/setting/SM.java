package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.setting.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SM {

    /* renamed from: b */
    private String f24985b;

    /* renamed from: c */
    private c f24986c;

    /* renamed from: e */
    private String f24988e;

    /* renamed from: f */
    private b f24989f;

    /* renamed from: h */
    private String f24991h;
    private Context j;
    private String i = "";

    /* renamed from: a */
    private c f24984a = new c();

    /* renamed from: d */
    private c f24987d = new c();

    /* renamed from: g */
    private b f24990g = new a();

    public SM(Context context) {
        this.j = context;
        try {
            this.f24991h = StringUtil.readAll(new File(this.j.getDir(Constants.SETTING.SETTINGDIR, 0), Constants.SETTING.SUID_FILE));
        } catch (Throwable unused) {
            this.f24991h = null;
            GDTLogger.e("IO Exception while loading suid");
        }
        a();
        b();
    }

    private void a() {
        c.b b2 = c.b(this.j);
        if (b2 == null) {
            GDTLogger.d("Load Local SDK Cloud setting fail");
        } else {
            this.f24988e = b2.a();
            this.f24989f = b2.b();
        }
    }

    private void b() {
        c.a a2 = c.a(this.j);
        if (a2 == null) {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        } else {
            this.f24986c = a2.b();
            this.f24985b = a2.a();
        }
    }

    public Object get(String str) {
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            if (this.f24984a.a(str) != null && (a5 = this.f24984a.a(str)) != null) {
                return a5;
            }
            if (this.f24986c != null && (a4 = this.f24986c.a(str)) != null) {
                return a4;
            }
            if (this.f24987d != null && (a3 = this.f24987d.a(str)) != null) {
                return a3;
            }
            if (this.f24989f != null && (a2 = this.f24989f.a(str)) != null) {
                return a2;
            }
            if (this.f24990g != null) {
                return this.f24990g.a(str);
            }
            return null;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
            return null;
        }
    }

    public String getDevCloudSettingSig() {
        return this.f24985b;
    }

    public Object getForPlacement(String str, String str2) {
        Object a2;
        Object a3;
        Object a4;
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            try {
                return (this.f24984a == null || (a4 = this.f24984a.a(str, str2)) == null) ? (this.f24986c == null || (a3 = this.f24986c.a(str, str2)) == null) ? (this.f24987d == null || (a2 = this.f24987d.a(str, str2)) == null) ? get(str) : a2 : a3 : a4;
            } catch (Throwable th) {
                GDTLogger.report("Exception in settingManager.getForPlacement", th);
            }
        }
        return null;
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getSdkCloudSettingSig() {
        return this.f24988e;
    }

    public String getSid() {
        return this.i;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement == null) {
            return null;
        }
        return forPlacement.toString();
    }

    public String getSuid() {
        return this.f24991h;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f24987d.a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f24987d.a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            c cVar = new c();
            if (!StringUtil.isEmpty(str)) {
                cVar = new c(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.f24984a = cVar;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (c.b(this.j, str, str2)) {
            b();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (c.a(this.j, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        this.i = str;
    }

    public void updateSUID(String str) {
        if (StringUtil.isEmpty(str) || str.equals(this.f24991h)) {
            return;
        }
        this.f24991h = str;
        try {
            StringUtil.writeTo(str, new File(this.j.getDir(Constants.SETTING.SETTINGDIR, 0), Constants.SETTING.SUID_FILE));
        } catch (IOException e2) {
            GDTLogger.report("Exception while persit suid", e2);
        }
    }
}
