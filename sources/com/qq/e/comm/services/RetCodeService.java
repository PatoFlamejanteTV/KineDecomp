package com.qq.e.comm.services;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.pi.ACTD;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

/* loaded from: classes3.dex */
public class RetCodeService {

    /* renamed from: a, reason: collision with root package name */
    private final String f25043a;

    /* renamed from: b, reason: collision with root package name */
    private final String f25044b;

    /* renamed from: c, reason: collision with root package name */
    private final Random f25045c;

    /* renamed from: d, reason: collision with root package name */
    private final String f25046d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Holder {

        /* renamed from: a, reason: collision with root package name */
        static final RetCodeService f25047a = new RetCodeService(0);

        private Holder() {
        }
    }

    /* loaded from: classes3.dex */
    public static class RetCodeInfo {

        /* renamed from: a, reason: collision with root package name */
        final String f25048a;

        /* renamed from: b, reason: collision with root package name */
        final String f25049b;

        /* renamed from: c, reason: collision with root package name */
        final String f25050c;

        /* renamed from: d, reason: collision with root package name */
        final int f25051d;

        /* renamed from: e, reason: collision with root package name */
        final int f25052e;

        /* renamed from: f, reason: collision with root package name */
        final int f25053f;

        /* renamed from: g, reason: collision with root package name */
        final int f25054g;

        /* renamed from: h, reason: collision with root package name */
        final int f25055h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f25048a = str;
            this.f25049b = str2;
            this.f25050c = str3;
            this.f25051d = i;
            this.f25052e = i2;
            this.f25053f = i3;
            this.f25054g = i4;
            this.f25055h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f25048a + ", commandid=" + this.f25049b + ", releaseversion=" + this.f25050c + ", resultcode=" + this.f25051d + ", tmcost=" + this.f25052e + ", reqsize=" + this.f25053f + ", rspsize=" + this.f25054g + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SendTask implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private RetCodeInfo f25056a;

        /* renamed from: b, reason: collision with root package name */
        private int f25057b = 100;

        SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f25056a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f25056a, this.f25057b);
        }
    }

    private RetCodeService() {
        this.f25043a = "1000162";
        this.f25044b = "http://wspeed.qq.com/w.cgi";
        this.f25045c = new Random(System.currentTimeMillis());
        this.f25046d = "http://c.isdspeed.qq.com/code.cgi";
    }

    /* synthetic */ RetCodeService(byte b2) {
        this();
    }

    private static String a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return "0.0.0.0";
        }
    }

    static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        if (retCodeService.a(i)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Request.Method.GET, (byte[]) null);
            plainRequest.addQuery(ACTD.APPID_KEY, "1000162");
            plainRequest.addQuery("apn", String.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()));
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f25051d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f25052e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f25053f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f25054g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                String encode = URLEncoder.encode(GDTADManager.getInstance().getDeviceStatus().model, "utf-8");
                plainRequest.addQuery("deviceinfo", encode);
                plainRequest.addQuery("device", encode);
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f25049b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f25050c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f25048a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f25048a);
            plainRequest2.addQuery("cgi", retCodeInfo.f25049b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f25055h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f25051d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f25052e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        double nextDouble = this.f25045c.nextDouble();
        double d2 = i;
        Double.isNaN(d2);
        return nextDouble < 1.0d / d2;
    }

    public static RetCodeService getInstance() {
        return Holder.f25047a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
