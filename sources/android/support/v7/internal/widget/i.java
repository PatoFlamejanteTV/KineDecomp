package android.support.v7.internal.widget;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.keyczar.Keyczar;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ActivityChooserModel.java */
/* loaded from: classes.dex */
public class i extends DataSetObservable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f172a = i.class.getSimpleName();
    private static final Object b = new Object();
    private static final Map<String, i> c = new HashMap();
    private final Object d;
    private final List<a> e;
    private final List<c> f;
    private final Context g;
    private final String h;
    private Intent i;
    private b j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(i iVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.d) {
            e();
            size = this.e.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.d) {
            e();
            resolveInfo = this.e.get(i).f173a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.d) {
            e();
            List<a> list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f173a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.d) {
            if (this.i == null) {
                return null;
            }
            e();
            a aVar = this.e.get(i);
            ComponentName componentName = new ComponentName(aVar.f173a.activityInfo.packageName, aVar.f173a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.d) {
            e();
            if (!this.e.isEmpty()) {
                return this.e.get(0).f173a;
            }
            return null;
        }
    }

    public void c(int i) {
        float f;
        synchronized (this.d) {
            e();
            a aVar = this.e.get(i);
            a aVar2 = this.e.get(0);
            if (aVar2 != null) {
                f = (aVar2.b - aVar.b) + 5.0f;
            } else {
                f = 1.0f;
            }
            a(new c(new ComponentName(aVar.f173a.activityInfo.packageName, aVar.f173a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void d() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.h)) {
                android.support.v4.d.a.a(new e(), this.f, this.h);
            }
        }
    }

    private void e() {
        boolean g = g() | h();
        i();
        if (g) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.j == null || this.i == null || this.e.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
        return true;
    }

    private boolean g() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.e.clear();
        List<ResolveInfo> queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean h() {
        if (!this.l || !this.n || TextUtils.isEmpty(this.h)) {
            return false;
        }
        this.l = false;
        this.m = true;
        j();
        return true;
    }

    private boolean a(c cVar) {
        boolean add = this.f.add(cVar);
        if (add) {
            this.n = true;
            i();
            d();
            f();
            notifyChanged();
        }
        return add;
    }

    private void i() {
        int size = this.f.size() - this.k;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                this.f.remove(0);
            }
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f174a;
        public final long b;
        public final float c;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.f174a = componentName;
            this.b = j;
            this.c = f;
        }

        public int hashCode() {
            return (((((this.f174a == null ? 0 : this.f174a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f174a == null) {
                    if (cVar.f174a != null) {
                        return false;
                    }
                } else if (!this.f174a.equals(cVar.f174a)) {
                    return false;
                }
                return this.b == cVar.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.f174a);
            sb.append("; time:").append(this.b);
            sb.append("; weight:").append(new BigDecimal(this.c));
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public final class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public final ResolveInfo f173a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.f173a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.f173a.toString());
            sb.append("; weight:").append(new BigDecimal(this.b));
            sb.append("]");
            return sb.toString();
        }
    }

    private void j() {
        FileInputStream openFileInput;
        try {
            try {
                openFileInput = this.g.openFileInput(this.h);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(openFileInput, null);
                    for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                    }
                    if (!"historical-records".equals(newPullParser.getName())) {
                        throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                    }
                    List<c> list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput != null) {
                                try {
                                    openFileInput.close();
                                    return;
                                } catch (IOException e2) {
                                    return;
                                }
                            }
                            return;
                        }
                        if (next != 3 && next != 4) {
                            if (!"historical-record".equals(newPullParser.getName())) {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                            list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                        }
                    }
                } catch (IOException e3) {
                    Log.e(f172a, "Error reading historical recrod file: " + this.h, e3);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (XmlPullParserException e5) {
                    Log.e(f172a, "Error reading historical recrod file: " + this.h, e5);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public final class e extends AsyncTask<Object, Void, Void> {
        private e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = i.this.g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        newSerializer.setOutput(openFileOutput, null);
                        newSerializer.startDocument(Keyczar.DEFAULT_ENCODING, true);
                        newSerializer.startTag(null, "historical-records");
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            c cVar = (c) list.remove(0);
                            newSerializer.startTag(null, "historical-record");
                            newSerializer.attribute(null, "activity", cVar.f174a.flattenToString());
                            newSerializer.attribute(null, "time", String.valueOf(cVar.b));
                            newSerializer.attribute(null, "weight", String.valueOf(cVar.c));
                            newSerializer.endTag(null, "historical-record");
                        }
                        newSerializer.endTag(null, "historical-records");
                        newSerializer.endDocument();
                        i.this.l = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        Log.e(i.f172a, "Error writing historical recrod file: " + i.this.h, e2);
                        i.this.l = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (IllegalArgumentException e4) {
                        Log.e(i.f172a, "Error writing historical recrod file: " + i.this.h, e4);
                        i.this.l = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (IllegalStateException e6) {
                        Log.e(i.f172a, "Error writing historical recrod file: " + i.this.h, e6);
                        i.this.l = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e7) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    i.this.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                Log.e(i.f172a, "Error writing historical recrod file: " + str, e9);
            }
            return null;
        }
    }
}
