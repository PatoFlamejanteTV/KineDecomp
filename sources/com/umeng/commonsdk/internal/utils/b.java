package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: BaseStationUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b */
    private static final String f26079b = "BaseStationUtils";

    /* renamed from: c */
    private static boolean f26080c = false;

    /* renamed from: d */
    private static Context f26081d;

    /* renamed from: a */
    PhoneStateListener f26082a;

    /* renamed from: e */
    private TelephonyManager f26083e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseStationUtils.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.b$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends PhoneStateListener {
        AnonymousClass1() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            String str;
            super.onSignalStrengthsChanged(signalStrength);
            ULog.e(b.f26079b, "base station onSignalStrengthsChanged");
            try {
                b.this.f26083e = (TelephonyManager) b.f26081d.getSystemService(PlaceFields.PHONE);
                String[] split = signalStrength.toString().split(" ");
                String str2 = null;
                if (b.this.f26083e == null || b.this.f26083e.getNetworkType() != 13) {
                    if (b.this.f26083e != null && (b.this.f26083e.getNetworkType() == 8 || b.this.f26083e.getNetworkType() == 10 || b.this.f26083e.getNetworkType() == 9 || b.this.f26083e.getNetworkType() == 3)) {
                        String e2 = b.this.e();
                        if (!TextUtils.isEmpty(e2) && e2.equals("中国移动")) {
                            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        } else if (!TextUtils.isEmpty(e2) && e2.equals("中国联通")) {
                            str2 = signalStrength.getCdmaDbm() + "";
                        } else if (!TextUtils.isEmpty(e2) && e2.equals("中国电信")) {
                            str2 = signalStrength.getEvdoDbm() + "";
                        }
                        str = str2;
                    } else {
                        str = ((signalStrength.getGsmSignalStrength() * 2) - 113) + "";
                    }
                } else {
                    str = "" + Integer.parseInt(split[9]);
                }
                ULog.e(b.f26079b, "stationStrength is " + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        UMWorkDispatch.sendEvent(b.f26081d, com.umeng.commonsdk.internal.a.f26057h, com.umeng.commonsdk.internal.b.a(b.f26081d).a(), str);
                    } catch (Throwable unused) {
                    }
                }
                b.this.c();
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStationUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private static final b f26085a = new b(b.f26081d);

        private a() {
        }
    }

    /* synthetic */ b(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    public String e() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f26081d.getSystemService(PlaceFields.PHONE);
            if (telephonyManager == null) {
                return null;
            }
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return null;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002")) {
                if (simOperator.equals("46001")) {
                    return "中国联通";
                }
                if (simOperator.equals("46003")) {
                    return "中国电信";
                }
                return null;
            }
            return "中国移动";
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void c() {
        ULog.e(f26079b, "base station unRegisterListener");
        try {
            if (this.f26083e != null) {
                this.f26083e.listen(this.f26082a, 0);
            }
            f26080c = false;
        } catch (Throwable unused) {
        }
    }

    private b(Context context) {
        this.f26082a = new PhoneStateListener() { // from class: com.umeng.commonsdk.internal.utils.b.1
            AnonymousClass1() {
            }

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                String str;
                super.onSignalStrengthsChanged(signalStrength);
                ULog.e(b.f26079b, "base station onSignalStrengthsChanged");
                try {
                    b.this.f26083e = (TelephonyManager) b.f26081d.getSystemService(PlaceFields.PHONE);
                    String[] split = signalStrength.toString().split(" ");
                    String str2 = null;
                    if (b.this.f26083e == null || b.this.f26083e.getNetworkType() != 13) {
                        if (b.this.f26083e != null && (b.this.f26083e.getNetworkType() == 8 || b.this.f26083e.getNetworkType() == 10 || b.this.f26083e.getNetworkType() == 9 || b.this.f26083e.getNetworkType() == 3)) {
                            String e2 = b.this.e();
                            if (!TextUtils.isEmpty(e2) && e2.equals("中国移动")) {
                                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            } else if (!TextUtils.isEmpty(e2) && e2.equals("中国联通")) {
                                str2 = signalStrength.getCdmaDbm() + "";
                            } else if (!TextUtils.isEmpty(e2) && e2.equals("中国电信")) {
                                str2 = signalStrength.getEvdoDbm() + "";
                            }
                            str = str2;
                        } else {
                            str = ((signalStrength.getGsmSignalStrength() * 2) - 113) + "";
                        }
                    } else {
                        str = "" + Integer.parseInt(split[9]);
                    }
                    ULog.e(b.f26079b, "stationStrength is " + str);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            UMWorkDispatch.sendEvent(b.f26081d, com.umeng.commonsdk.internal.a.f26057h, com.umeng.commonsdk.internal.b.a(b.f26081d).a(), str);
                        } catch (Throwable unused) {
                        }
                    }
                    b.this.c();
                } catch (Exception unused2) {
                }
            }
        };
        if (context != null) {
            try {
                this.f26083e = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void b() {
        ULog.e(f26079b, "base station registerListener");
        try {
            if (this.f26083e != null) {
                this.f26083e.listen(this.f26082a, 256);
            }
            f26080c = true;
        } catch (Throwable unused) {
        }
    }

    public static b a(Context context) {
        if (f26081d == null && context != null) {
            f26081d = context.getApplicationContext();
        }
        return a.f26085a;
    }

    public synchronized boolean a() {
        return f26080c;
    }
}
