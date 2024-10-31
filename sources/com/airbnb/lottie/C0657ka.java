package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.C0665oa;
import com.airbnb.lottie.Layer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LottieComposition.java */
/* renamed from: com.airbnb.lottie.ka */
/* loaded from: classes.dex */
public class C0657ka {

    /* renamed from: a */
    private final Map<String, List<Layer>> f7781a;

    /* renamed from: b */
    private final Map<String, C0665oa> f7782b;

    /* renamed from: c */
    private final LongSparseArray<Layer> f7783c;

    /* renamed from: d */
    private final List<Layer> f7784d;

    /* renamed from: e */
    private final Rect f7785e;

    /* renamed from: f */
    private final long f7786f;

    /* renamed from: g */
    private final long f7787g;

    /* renamed from: h */
    private final int f7788h;
    private final float i;

    /* synthetic */ C0657ka(Rect rect, long j, long j2, int i, float f2, C0655ja c0655ja) {
        this(rect, j, j2, i, f2);
    }

    public long e() {
        return this.f7787g;
    }

    public int f() {
        return this.f7788h;
    }

    public Map<String, C0665oa> g() {
        return this.f7782b;
    }

    public List<Layer> h() {
        return this.f7784d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.f7784d.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }

    private C0657ka(Rect rect, long j, long j2, int i, float f2) {
        this.f7781a = new HashMap();
        this.f7782b = new HashMap();
        this.f7783c = new LongSparseArray<>();
        this.f7784d = new ArrayList();
        this.f7785e = rect;
        this.f7786f = j;
        this.f7787g = j2;
        this.f7788h = i;
        this.i = f2;
    }

    public Layer a(long j) {
        return this.f7783c.get(j);
    }

    public float b() {
        return this.i;
    }

    public long c() {
        return (((float) (this.f7787g - this.f7786f)) / this.f7788h) * 1000.0f;
    }

    public float d() {
        return (((float) c()) * this.f7788h) / 1000.0f;
    }

    /* compiled from: LottieComposition.java */
    /* renamed from: com.airbnb.lottie.ka$a */
    /* loaded from: classes.dex */
    public static class a {
        public static B a(Context context, InputStream inputStream, InterfaceC0682xa interfaceC0682xa) {
            O o = new O(context.getResources(), interfaceC0682xa);
            o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, inputStream);
            return o;
        }

        private static void b(JSONArray jSONArray, C0657ka c0657ka) {
            if (jSONArray == null) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    LongSparseArray longSparseArray = new LongSparseArray();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        Layer a2 = Layer.a.a(optJSONArray.optJSONObject(i2), c0657ka);
                        longSparseArray.put(a2.a(), a2);
                        arrayList.add(a2);
                    }
                    c0657ka.f7781a.put(optJSONObject.optString("id"), arrayList);
                }
            }
        }

        public static C0657ka a(Context context, InputStream inputStream) throws IOException, JSONException {
            return a(context.getResources(), new JSONObject(new String(com.nexstreaming.app.general.util.H.a(inputStream), "UTF-8")));
        }

        public static C0657ka a(Resources resources, InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(inputStream.available());
                    try {
                        byte[] bArr = new byte[512];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream2.write(bArr, 0, read);
                            } else {
                                C0657ka a2 = a(resources, new JSONObject(new String(byteArrayOutputStream2.toByteArray(), "UTF-8")));
                                db.a(inputStream);
                                db.a(byteArrayOutputStream2);
                                return a2;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        throw new IllegalStateException("Unable to find file.", e);
                    } catch (JSONException e3) {
                        e = e3;
                        throw new IllegalStateException("Unable to load JSON.", e);
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        db.a(inputStream);
                        db.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (JSONException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        static C0657ka a(Resources resources, JSONObject jSONObject) {
            float f2 = resources.getDisplayMetrics().density;
            int optInt = jSONObject.optInt("w", -1);
            int optInt2 = jSONObject.optInt("h", -1);
            C0657ka c0657ka = new C0657ka((optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (optInt * f2), (int) (optInt2 * f2)), jSONObject.optLong("ip", 0L), jSONObject.optLong("op", 0L), jSONObject.optInt("fr", 0), f2);
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            a(optJSONArray, c0657ka);
            b(optJSONArray, c0657ka);
            a(jSONObject, c0657ka);
            return c0657ka;
        }

        private static void a(JSONObject jSONObject, C0657ka c0657ka) {
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                a((List<Layer>) c0657ka.f7784d, (LongSparseArray<Layer>) c0657ka.f7783c, Layer.a.a(optJSONArray.optJSONObject(i), c0657ka));
            }
        }

        private static void a(JSONArray jSONArray, C0657ka c0657ka) {
            if (jSONArray == null) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject.has("p")) {
                    C0665oa a2 = C0665oa.a.a(optJSONObject);
                    c0657ka.f7782b.put(a2.b(), a2);
                }
            }
        }

        private static void a(List<Layer> list, LongSparseArray<Layer> longSparseArray, Layer layer) {
            list.add(layer);
            longSparseArray.put(layer.a(), layer);
        }
    }

    public Rect a() {
        return this.f7785e;
    }

    public List<Layer> a(String str) {
        return this.f7781a.get(str);
    }
}
