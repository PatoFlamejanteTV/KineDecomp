package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.util.z;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AppUsage {
    private static AppUsage d = null;
    private final Context b;
    private final SharedPreferences c;
    private Map<Long, Integer> e;
    private HandlerThread f;
    private Handler g;
    private final String i;
    private final String[] j;
    private ReportingMode l;
    private String m;
    private Object h = new Object();
    private boolean k = false;

    /* renamed from: a, reason: collision with root package name */
    Runnable f3200a = new com.nexstreaming.app.general.tracelog.a(this);

    /* loaded from: classes.dex */
    public enum ReportingMode {
        OFF,
        NEXSTREAMING_USAGEAPP,
        FLURRY
    }

    /* loaded from: classes.dex */
    public interface a {
        long getValue();

        boolean shouldReportForMode(ReportingMode reportingMode);
    }

    public static AppUsage a(Context context, String str, String[] strArr, ReportingMode reportingMode, String str2) {
        Context applicationContext = context.getApplicationContext();
        if (d == null || !d.b.equals(applicationContext) || d.l != reportingMode) {
            if (d != null) {
                d.b();
                d = null;
            }
            d = new AppUsage(applicationContext, str, strArr, reportingMode, str2);
        }
        return d;
    }

    private void b() {
        if (this.f != null) {
            this.f.getLooper().quit();
            this.f = null;
        }
        this.g = null;
    }

    private void c() {
        try {
            this.e = new HashMap();
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(this.b.openFileInput("nexau.dat")));
            int readInt = dataInputStream.readInt();
            dataInputStream.readInt();
            dataInputStream.readInt();
            if (readInt == -1615982310) {
                int readInt2 = dataInputStream.readInt();
                for (int i = 0; i < readInt2; i++) {
                    long readLong = dataInputStream.readLong();
                    int readInt3 = dataInputStream.readInt();
                    Integer num = this.e.get(Long.valueOf(readLong));
                    if (num != null) {
                        this.e.put(Long.valueOf(readLong), Integer.valueOf(num.intValue() + readInt3));
                    } else {
                        this.e.put(Long.valueOf(readLong), Integer.valueOf(readInt3));
                    }
                }
            } else {
                this.e = new HashMap();
            }
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            this.e = new HashMap();
        } catch (IOException e2) {
            this.e = new HashMap();
        }
        this.f = new HandlerThread("nex-au", 10);
        this.f.start();
        this.g = new Handler(this.f.getLooper());
    }

    private AppUsage(Context context, String str, String[] strArr, ReportingMode reportingMode, String str2) {
        this.l = ReportingMode.OFF;
        this.b = context.getApplicationContext();
        this.i = str;
        this.j = strArr;
        this.c = PreferenceManager.getDefaultSharedPreferences(this.b);
        this.l = reportingMode;
        this.m = str2;
        switch (this.l) {
            case FLURRY:
            default:
                return;
            case NEXSTREAMING_USAGEAPP:
                c();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AppUsageRequest {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AppUsageResponse {
        int next;
        int result;

        private AppUsageResponse() {
        }
    }

    public void a() {
        if (this.l == ReportingMode.NEXSTREAMING_USAGEAPP) {
            synchronized (this.h) {
                if (this.e.size() >= 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.c.getLong("nexau_last_report", 0L);
                    long j2 = this.c.getLong("nexau_last_try", 0L);
                    long j3 = this.c.getLong("nexau_report_interval", 604800000L);
                    if (j2 + 60000 <= currentTimeMillis && j + j3 < currentTimeMillis) {
                        this.c.edit().putLong("nexau_last_try", currentTimeMillis).commit();
                        d();
                    }
                }
            }
        }
    }

    private void d() {
        if (this.l == ReportingMode.NEXSTREAMING_USAGEAPP && !this.k) {
            this.k = true;
            AppUsageRequest appUsageRequest = new AppUsageRequest(null);
            appUsageRequest.version = 10000;
            appUsageRequest.app_uuid = z.a(this.b);
            appUsageRequest.package_name = z.d(this.b);
            appUsageRequest.app_ucode = this.i;
            synchronized (this.h) {
                appUsageRequest.usage = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.e.size(), 2);
                Iterator<Map.Entry<Long, Integer>> it = this.e.entrySet().iterator();
                int i = 0;
                while (it.hasNext()) {
                    appUsageRequest.usage[i][0] = it.next().getKey().longValue();
                    appUsageRequest.usage[i][1] = r0.getValue().intValue();
                    i++;
                }
            }
            new b(this).executeOnExecutor(EditorGlobal.l, appUsageRequest);
        }
    }

    /* loaded from: classes.dex */
    public enum MetricType {
        Counter(144115188075855872L),
        Total(216172782113783808L),
        Peak(288230376151711744L),
        Value(360287970189639680L);

        private long value;

        public long getValue() {
            return this.value;
        }

        MetricType(long j) {
            this.value = j;
        }

        public static MetricType fromMetric(a aVar) {
            long value = 1080863910568919040L & aVar.getValue();
            for (MetricType metricType : values()) {
                if (metricType.value == value) {
                    return metricType;
                }
            }
            return null;
        }
    }

    public void a(Context context) {
        if (this.l == ReportingMode.FLURRY) {
        }
    }

    public void b(Context context) {
        if (this.l == ReportingMode.FLURRY) {
        }
    }

    public void a(a aVar, String... strArr) {
        if (aVar.shouldReportForMode(this.l)) {
            if (MetricType.fromMetric(aVar) != MetricType.Counter) {
                throw new IllegalArgumentException("Expected counter; got " + MetricType.fromMetric(aVar));
            }
            HashMap hashMap = new HashMap();
            if (strArr != null) {
                for (int i = 0; i < strArr.length / 2; i++) {
                    hashMap.put(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
            a(aVar, null, 0, hashMap);
        }
    }

    public void a(a aVar) {
        if (aVar.shouldReportForMode(this.l)) {
            if (MetricType.fromMetric(aVar) != MetricType.Counter) {
                throw new IllegalArgumentException("Expected counter; got " + MetricType.fromMetric(aVar));
            }
            a(aVar, null, 0, null);
        }
    }

    public void a(a aVar, String str) {
        if (aVar.shouldReportForMode(this.l)) {
            if (MetricType.fromMetric(aVar) != MetricType.Counter) {
                throw new IllegalArgumentException("Expected counter; got " + MetricType.fromMetric(aVar));
            }
            a(aVar, str, 0, null);
        }
    }

    public void a(a aVar, int i) {
        if (aVar.shouldReportForMode(this.l)) {
            if (MetricType.fromMetric(aVar) == MetricType.Counter) {
                throw new IllegalArgumentException("Expected non-counter; got " + MetricType.fromMetric(aVar));
            }
            a(aVar, null, i, null);
        }
    }

    public void a(a aVar, String str, int i, Map<String, String> map) {
        if (aVar.shouldReportForMode(this.l)) {
            switch (this.l) {
                case FLURRY:
                    b(aVar, str, i, map);
                    return;
                case NEXSTREAMING_USAGEAPP:
                    a(aVar, str, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(a aVar, String str, int i, Map<String, String> map) {
        if (aVar.shouldReportForMode(this.l)) {
            HashMap hashMap = new HashMap();
            switch (MetricType.fromMetric(aVar)) {
                case Counter:
                    break;
                case Peak:
                case Total:
                case Value:
                    hashMap.put(MetricType.fromMetric(aVar).name(), String.valueOf(i));
                    break;
                default:
                    return;
            }
            if (str != null) {
                hashMap.put("Tag", str);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
    }

    private void a(a aVar, String str, int i) {
        if (aVar.shouldReportForMode(this.l)) {
            int i2 = 0;
            if (str != null) {
                i2 = str.hashCode();
            }
            long value = aVar.getValue() | (i2 & Integer.MAX_VALUE);
            Integer num = this.e.get(Long.valueOf(value));
            synchronized (this.h) {
                switch (MetricType.fromMetric(aVar)) {
                    case Counter:
                        if (num != null) {
                            this.e.put(Long.valueOf(value), Integer.valueOf(num.intValue() + 1));
                            break;
                        } else {
                            this.e.put(Long.valueOf(value), 1);
                            break;
                        }
                    case Peak:
                        if (num != null) {
                            if (i > num.intValue()) {
                                this.e.put(Long.valueOf(value), Integer.valueOf(i));
                                break;
                            }
                        } else {
                            this.e.put(Long.valueOf(value), Integer.valueOf(i));
                            break;
                        }
                        break;
                    case Total:
                        if (num != null) {
                            this.e.put(Long.valueOf(value), Integer.valueOf(num.intValue() + i));
                            break;
                        } else {
                            this.e.put(Long.valueOf(value), Integer.valueOf(i));
                            break;
                        }
                    case Value:
                        this.e.put(Long.valueOf(value), Integer.valueOf(i));
                        break;
                    default:
                        return;
                }
                this.g.removeCallbacks(this.f3200a);
                this.g.postDelayed(this.f3200a, 500L);
            }
        }
    }
}
