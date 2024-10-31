package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private JSONObject f24992a;

    public b() {
        this.f24992a = new JSONObject();
    }

    public b(String str) {
        this();
        GDTLogger.d("Initialize GDTSDKSetting,Json=" + str);
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            this.f24992a = new JSONObject(str);
        } catch (JSONException e2) {
            GDTLogger.report("Exception while building GDTSDKSetting from json", e2);
        }
    }

    public final Object a(String str) {
        return this.f24992a.opt(str);
    }

    public final void a(String str, Object obj) {
        try {
            this.f24992a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f24992a.toString() + "]";
    }
}
