package com.umeng.commonsdk.service;

import android.content.Context;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private int mDeviceType;
    private boolean mIsDebugMode;
    private boolean mIsMainProcess;
    private String mModules;
    private String mProcessName;
    private String mPushSecret;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        public Context f26294a;

        /* renamed from: b */
        public int f26295b;

        /* renamed from: c */
        public String f26296c;

        /* renamed from: d */
        public String f26297d;

        /* renamed from: e */
        public String f26298e;

        /* renamed from: f */
        public String f26299f;

        /* renamed from: g */
        public boolean f26300g;

        /* renamed from: h */
        public String f26301h;
        public String i;
        public boolean j;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a */
        private static final UMGlobalContext f26302a = new UMGlobalContext();

        private b() {
        }
    }

    /* synthetic */ UMGlobalContext(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Context getAppContext(Context context) {
        if (context != null) {
            Context context2 = b.f26302a.mApplicationContext;
            return context2 != null ? context2 : context.getApplicationContext();
        }
        return b.f26302a.mApplicationContext;
    }

    public static UMGlobalContext getInstance() {
        return b.f26302a;
    }

    public static UMGlobalContext newUMGlobalContext(a aVar) {
        getInstance();
        b.f26302a.mDeviceType = aVar.f26295b;
        b.f26302a.mPushSecret = aVar.f26296c;
        b.f26302a.mAppkey = aVar.f26297d;
        b.f26302a.mChannel = aVar.f26298e;
        b.f26302a.mModules = aVar.f26299f;
        b.f26302a.mIsDebugMode = aVar.f26300g;
        b.f26302a.mProcessName = aVar.f26301h;
        b.f26302a.mAppVersion = aVar.i;
        b.f26302a.mIsMainProcess = aVar.j;
        if (aVar.f26294a != null) {
            b.f26302a.mApplicationContext = aVar.f26294a.getApplicationContext();
        }
        return b.f26302a;
    }

    public Context getAppContextDirectly() {
        return this.mApplicationContext;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getProcessName(Context context) {
        if (context != null) {
            if (b.f26302a.mApplicationContext != null) {
                return this.mProcessName;
            }
            return UMFrUtils.getCurrentProcessName(context);
        }
        return b.f26302a.mProcessName;
    }

    public String getPushSecret() {
        return this.mPushSecret;
    }

    public boolean hasAnalyticsSdk() {
        return this.mModules.contains(e.al);
    }

    public boolean hasErrorSdk() {
        return this.mModules.contains("e");
    }

    public boolean hasInternalModule() {
        return true;
    }

    public boolean hasOplusModule() {
        return this.mModules.contains("o");
    }

    public boolean hasPushSdk() {
        return this.mModules.contains("p");
    }

    public boolean hasShareSdk() {
        return this.mModules.contains(e.ap);
    }

    public boolean hasVisualDebugSdk() {
        return this.mModules.contains(FragmentC2201x.f23219a);
    }

    public boolean hasVisualSdk() {
        return this.mModules.contains("v");
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isMainProcess(Context context) {
        if (context != null && b.f26302a.mApplicationContext == null) {
            return UMUtils.isMainProgress(context.getApplicationContext());
        }
        return b.f26302a.mIsMainProcess;
    }

    public String toString() {
        if (b.f26302a.mApplicationContext == null) {
            return "uninitialized.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("devType:" + this.mDeviceType + ",");
        sb.append("appkey:" + this.mAppkey + ",");
        sb.append("channel:" + this.mChannel + ",");
        sb.append("procName:" + this.mProcessName + "]");
        return sb.toString();
    }

    private UMGlobalContext() {
        this.mProcessName = "unknown";
    }
}
