package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ActivityChooserModel extends DataSetObservable {
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;

    /* renamed from: a */
    static final String f2563a = "ActivityChooserModel";

    /* renamed from: b */
    private static final Object f2564b = new Object();

    /* renamed from: c */
    private static final Map<String, ActivityChooserModel> f2565c = new HashMap();

    /* renamed from: g */
    final Context f2569g;

    /* renamed from: h */
    final String f2570h;
    private Intent i;
    private OnChooseActivityListener p;

    /* renamed from: d */
    private final Object f2566d = new Object();

    /* renamed from: e */
    private final List<ActivityResolveInfo> f2567e = new ArrayList();

    /* renamed from: f */
    private final List<HistoricalRecord> f2568f = new ArrayList();
    private ActivitySorter j = new DefaultSorter();
    private int k = 50;
    boolean l = true;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;

    /* loaded from: classes.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: classes.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    /* loaded from: classes.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class DefaultSorter implements ActivitySorter {

        /* renamed from: a */
        private final Map<ComponentName, ActivityResolveInfo> f2571a = new HashMap();

        DefaultSorter() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.f2571a;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f2;
                    f2 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* loaded from: classes.dex */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f2) {
            this(ComponentName.unflattenFromString(str), j, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j, float f2) {
            this.activity = componentName;
            this.time = j;
            this.weight = f2;
        }
    }

    /* loaded from: classes.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* loaded from: classes.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:            if (r15 != null) goto L92;     */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x00d5, code lost:            return null;     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:            r15.close();     */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:            if (r15 == null) goto L79;     */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:            if (r15 == null) goto L79;     */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d2, code lost:            if (r15 == null) goto L79;     */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f2569g = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(".xml")) {
            this.f2570h = str + ".xml";
            return;
        }
        this.f2570h = str;
    }

    private void a() {
        boolean b2 = b() | e();
        d();
        if (b2) {
            g();
            notifyChanged();
        }
    }

    private boolean b() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.f2567e.clear();
        List<ResolveInfo> queryIntentActivities = this.f2569g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2567e.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private void c() {
        if (this.m) {
            if (this.n) {
                this.n = false;
                if (TextUtils.isEmpty(this.f2570h)) {
                    return;
                }
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f2568f), this.f2570h);
                return;
            }
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void d() {
        int size = this.f2568f.size() - this.k;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.f2568f.remove(0);
        }
    }

    private boolean e() {
        if (!this.l || !this.n || TextUtils.isEmpty(this.f2570h)) {
            return false;
        }
        this.l = false;
        this.m = true;
        f();
        return true;
    }

    private void f() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.f2569g.openFileInput(this.f2570h);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (XmlPullParserException e2) {
                        Log.e(f2563a, "Error reading historical recrod file: " + this.f2570h, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (IOException e3) {
                    Log.e(f2563a, "Error reading historical recrod file: " + this.f2570h, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<HistoricalRecord> list = this.f2568f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (next != 3 && next != 4) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean g() {
        if (this.j == null || this.i == null || this.f2567e.isEmpty() || this.f2568f.isEmpty()) {
            return false;
        }
        this.j.sort(this.i, this.f2567e, Collections.unmodifiableList(this.f2568f));
        return true;
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f2564b) {
            activityChooserModel = f2565c.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                f2565c.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    public Intent chooseActivity(int i) {
        synchronized (this.f2566d) {
            if (this.i == null) {
                return null;
            }
            a();
            ActivityResolveInfo activityResolveInfo = this.f2567e.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2566d) {
            a();
            resolveInfo = this.f2567e.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.f2566d) {
            a();
            size = this.f2567e.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.f2566d) {
            a();
            List<ActivityResolveInfo> list = this.f2567e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.f2566d) {
            a();
            if (this.f2567e.isEmpty()) {
                return null;
            }
            return this.f2567e.get(0).resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.f2566d) {
            i = this.k;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.f2566d) {
            a();
            size = this.f2568f.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.f2566d) {
            intent = this.i;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.f2566d) {
            if (this.j == activitySorter) {
                return;
            }
            this.j = activitySorter;
            if (g()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.f2566d) {
            a();
            ActivityResolveInfo activityResolveInfo = this.f2567e.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.f2567e.get(0);
            a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f));
        }
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.f2566d) {
            if (this.k == i) {
                return;
            }
            this.k = i;
            d();
            if (g()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.f2566d) {
            if (this.i == intent) {
                return;
            }
            this.i = intent;
            this.o = true;
            a();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f2566d) {
            this.p = onChooseActivityListener;
        }
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.f2568f.add(historicalRecord);
        if (add) {
            this.n = true;
            d();
            c();
            g();
            notifyChanged();
        }
        return add;
    }
}
