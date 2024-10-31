package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    private volatile Boolean f24956a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f24957b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SM f24958c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PM f24959d;

    /* renamed from: e, reason: collision with root package name */
    private volatile APPStatus f24960e;

    /* renamed from: f, reason: collision with root package name */
    private volatile DeviceStatus f24961f;

    /* renamed from: g, reason: collision with root package name */
    private PM.a.InterfaceC0127a f24962g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static GDTADManager f24963a = new GDTADManager(0);
    }

    private GDTADManager() {
        this.f24956a = Boolean.FALSE;
    }

    /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.f24963a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (!isInitialized()) {
            return null;
        }
        JSONObject a2 = com.qq.e.comm.net.a.a(this.f24958c);
        a2.put("app", com.qq.e.comm.net.a.a(this.f24960e));
        a2.put("c", com.qq.e.comm.net.a.a(this.f24961f));
        a2.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, com.qq.e.comm.net.a.a(this.f24959d));
        return a2;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f24957b;
    }

    public APPStatus getAppStatus() {
        return this.f24960e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f24961f;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f24959d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public SM getSM() {
        return this.f24958c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        }
        if (this.f24956a.booleanValue()) {
            return true;
        }
        if (context == null || StringUtil.isEmpty(str)) {
            GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
            return false;
        }
        try {
            long nanoTime = System.nanoTime();
            this.f24957b = context.getApplicationContext();
            this.f24958c = new SM(this.f24957b);
            this.f24959d = new PM(this.f24957b, this.f24962g);
            this.f24960e = new APPStatus(str, this.f24957b);
            this.f24961f = new DeviceStatus(this.f24957b);
            if (Build.VERSION.SDK_INT > 7) {
                com.qq.e.comm.services.a.a().a(this.f24957b, this.f24958c, this.f24959d, this.f24961f, this.f24960e, nanoTime);
            }
            this.f24956a = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            GDTLogger.report("ADManager init error", th);
            return false;
        }
    }

    public boolean isInitialized() {
        if (this.f24956a == null) {
            return false;
        }
        return this.f24956a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.InterfaceC0127a interfaceC0127a) {
        this.f24962g = interfaceC0127a;
    }
}
