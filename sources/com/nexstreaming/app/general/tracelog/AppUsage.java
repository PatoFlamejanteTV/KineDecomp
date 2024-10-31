package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public class AppUsage {

    /* renamed from: a */
    private static AppUsage f19761a;

    /* renamed from: b */
    private final Context f19762b;

    /* renamed from: c */
    private final SharedPreferences f19763c;

    /* renamed from: d */
    private Map<Long, Integer> f19764d;

    /* renamed from: e */
    private HandlerThread f19765e;

    /* renamed from: f */
    private Handler f19766f;

    /* renamed from: h */
    private final String f19768h;
    private final String[] i;
    private ReportingMode k;
    private String l;

    /* renamed from: g */
    private Object f19767g = new Object();
    private boolean j = false;
    Runnable m = new com.nexstreaming.app.general.tracelog.a(this);

    /* loaded from: classes2.dex */
    private static class AppUsageRequest {
        String app_ucode;
        String app_uuid;
        String package_name;
        long[][] usage;
        int version;

        private AppUsageRequest() {
        }

        /* synthetic */ AppUsageRequest(com.nexstreaming.app.general.tracelog.a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class AppUsageResponse {
        int next;
        int result;

        private AppUsageResponse() {
        }
    }

    /* loaded from: classes2.dex */
    public enum MetricType {
        Counter(144115188075855872L),
        Total(216172782113783808L),
        Peak(288230376151711744L),
        Value(360287970189639680L);

        private long value;

        MetricType(long j) {
            this.value = j;
        }

        public static MetricType fromMetric(a aVar) {
            long value = aVar.getValue() & 1080863910568919040L;
            for (MetricType metricType : values()) {
                if (metricType.value == value) {
                    return metricType;
                }
            }
            return null;
        }

        public long getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum ReportingMode {
        OFF,
        NEXSTREAMING_USAGEAPP,
        FLURRY
    }

    /* loaded from: classes2.dex */
    public interface a {
        long getValue();

        boolean shouldReportForMode(ReportingMode reportingMode);
    }

    private AppUsage(Context context, String str, String[] strArr, ReportingMode reportingMode, String str2) {
        this.k = ReportingMode.OFF;
        this.f19762b = context.getApplicationContext();
        this.f19768h = str;
        this.i = strArr;
        this.f19763c = PreferenceManager.getDefaultSharedPreferences(this.f19762b);
        this.k = reportingMode;
        this.l = str2;
        int i = b.f19780a[this.k.ordinal()];
        if (i == 1 || i != 2) {
            return;
        }
        b();
    }

    public static AppUsage a(Context context, String str, String[] strArr, ReportingMode reportingMode, String str2) {
        Context applicationContext = context.getApplicationContext();
        AppUsage appUsage = f19761a;
        if (appUsage == null || !appUsage.f19762b.equals(applicationContext) || f19761a.k != reportingMode) {
            AppUsage appUsage2 = f19761a;
            if (appUsage2 != null) {
                appUsage2.a();
                f19761a = null;
            }
            f19761a = new AppUsage(applicationContext, str, strArr, reportingMode, str2);
        }
        return f19761a;
    }

    private void b() {
        try {
            this.f19764d = new HashMap();
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(this.f19762b.openFileInput("nexau.dat")));
            int readInt = dataInputStream.readInt();
            dataInputStream.readInt();
            dataInputStream.readInt();
            if (readInt == -1615982310) {
                int readInt2 = dataInputStream.readInt();
                for (int i = 0; i < readInt2; i++) {
                    long readLong = dataInputStream.readLong();
                    int readInt3 = dataInputStream.readInt();
                    Integer num = this.f19764d.get(Long.valueOf(readLong));
                    if (num != null) {
                        this.f19764d.put(Long.valueOf(readLong), Integer.valueOf(readInt3 + num.intValue()));
                    } else {
                        this.f19764d.put(Long.valueOf(readLong), Integer.valueOf(readInt3));
                    }
                }
            } else {
                this.f19764d = new HashMap();
            }
            dataInputStream.close();
        } catch (FileNotFoundException unused) {
            this.f19764d = new HashMap();
        } catch (IOException unused2) {
            this.f19764d = new HashMap();
        }
        this.f19765e = new HandlerThread("nex-au", 10);
        this.f19765e.start();
        this.f19766f = new Handler(this.f19765e.getLooper());
    }

    private void a() {
        HandlerThread handlerThread = this.f19765e;
        if (handlerThread != null) {
            handlerThread.getLooper().quit();
            this.f19765e = null;
        }
        this.f19766f = null;
    }

    public void a(a aVar) {
        if (aVar.shouldReportForMode(this.k)) {
            if (MetricType.fromMetric(aVar) == MetricType.Counter) {
                a(aVar, null, 0, null);
                return;
            }
            throw new IllegalArgumentException("Expected counter; got " + MetricType.fromMetric(aVar));
        }
    }

    public void a(a aVar, String str) {
        if (aVar.shouldReportForMode(this.k)) {
            if (MetricType.fromMetric(aVar) == MetricType.Counter) {
                a(aVar, str, 0, null);
                return;
            }
            throw new IllegalArgumentException("Expected counter; got " + MetricType.fromMetric(aVar));
        }
    }

    private void b(a aVar, String str, int i, Map<String, String> map) {
        if (aVar.shouldReportForMode(this.k)) {
            HashMap hashMap = new HashMap();
            int i2 = b.f19781b[MetricType.fromMetric(aVar).ordinal()];
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3 && i2 != 4) {
                    return;
                } else {
                    hashMap.put(MetricType.fromMetric(aVar).name(), String.valueOf(i));
                }
            }
            if (str != null) {
                hashMap.put("Tag", str);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
    }

    public void a(a aVar, String str, int i, Map<String, String> map) {
        if (aVar.shouldReportForMode(this.k)) {
            int i2 = b.f19780a[this.k.ordinal()];
            if (i2 == 1) {
                b(aVar, str, i, map);
            } else {
                if (i2 != 2) {
                    return;
                }
                a(aVar, str, i);
            }
        }
    }

    private void a(a aVar, String str, int i) {
        if (aVar.shouldReportForMode(this.k)) {
            long value = aVar.getValue() | (Integer.MAX_VALUE & (str != null ? str.hashCode() : 0));
            Integer num = this.f19764d.get(Long.valueOf(value));
            synchronized (this.f19767g) {
                int i2 = b.f19781b[MetricType.fromMetric(aVar).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return;
                            } else {
                                this.f19764d.put(Long.valueOf(value), Integer.valueOf(i));
                            }
                        } else if (num != null) {
                            this.f19764d.put(Long.valueOf(value), Integer.valueOf(num.intValue() + i));
                        } else {
                            this.f19764d.put(Long.valueOf(value), Integer.valueOf(i));
                        }
                    } else if (num != null) {
                        if (i > num.intValue()) {
                            this.f19764d.put(Long.valueOf(value), Integer.valueOf(i));
                        }
                    } else {
                        this.f19764d.put(Long.valueOf(value), Integer.valueOf(i));
                    }
                } else if (num != null) {
                    this.f19764d.put(Long.valueOf(value), Integer.valueOf(num.intValue() + 1));
                } else {
                    this.f19764d.put(Long.valueOf(value), 1);
                }
                this.f19766f.removeCallbacks(this.m);
                this.f19766f.postDelayed(this.m, 500L);
            }
        }
    }
}
