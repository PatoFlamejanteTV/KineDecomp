package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.y;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* compiled from: ViewSnapshot.java */
@TargetApi(16)
/* loaded from: classes.dex */
class n {
    private final List<g> b;
    private final y e;
    private final Handler d = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final c f3104a = new c();
    private final b c = new b(255);

    public n(List<g> list, y yVar) {
        this.b = list;
        this.e = yVar;
    }

    public void a(i<Activity> iVar, OutputStream outputStream) throws IOException {
        this.f3104a.a(iVar);
        FutureTask futureTask = new FutureTask(this.f3104a);
        this.d.post(futureTask);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List emptyList = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            emptyList = (List) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.d("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", e);
            }
        } catch (ExecutionException e2) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.e("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", e2);
            }
        } catch (TimeoutException e3) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.i("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", e3);
            }
        }
        int size = emptyList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                outputStreamWriter.write(",");
            }
            d dVar = (d) emptyList.get(i);
            outputStreamWriter.write("{");
            outputStreamWriter.write("\"activity\":");
            outputStreamWriter.write(JSONObject.quote(dVar.f3107a));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"scale\":");
            outputStreamWriter.write(String.format("%s", Float.valueOf(dVar.d)));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"serialized_objects\":");
            JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            jsonWriter.name("rootObject").value(dVar.b.hashCode());
            jsonWriter.name("objects");
            a(jsonWriter, dVar.b);
            jsonWriter.endObject();
            jsonWriter.flush();
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"screenshot\":");
            outputStreamWriter.flush();
            dVar.c.a(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStreamWriter.write("}");
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
    }

    void a(JsonWriter jsonWriter, View view) throws IOException {
        jsonWriter.beginArray();
        b(jsonWriter, view);
        jsonWriter.endArray();
    }

    private void b(JsonWriter jsonWriter, View view) throws IOException {
        String a2;
        float f;
        float f2 = 0.0f;
        int id = view.getId();
        if (-1 == id) {
            a2 = null;
        } else {
            a2 = this.e.a(id);
        }
        jsonWriter.beginObject();
        jsonWriter.name("hashCode").value(view.hashCode());
        jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_ID).value(id);
        jsonWriter.name("mp_id_name").value(a2);
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null) {
            jsonWriter.name("contentDescription").nullValue();
        } else {
            jsonWriter.name("contentDescription").value(contentDescription.toString());
        }
        Object tag = view.getTag();
        if (tag == null) {
            jsonWriter.name("tag").nullValue();
        } else if (tag instanceof CharSequence) {
            jsonWriter.name("tag").value(tag.toString());
        }
        jsonWriter.name("top").value(view.getTop());
        jsonWriter.name("left").value(view.getLeft());
        jsonWriter.name("width").value(view.getWidth());
        jsonWriter.name("height").value(view.getHeight());
        jsonWriter.name("scrollX").value(view.getScrollX());
        jsonWriter.name("scrollY").value(view.getScrollY());
        jsonWriter.name("visibility").value(view.getVisibility());
        if (Build.VERSION.SDK_INT >= 11) {
            f2 = view.getTranslationX();
            f = view.getTranslationY();
        } else {
            f = 0.0f;
        }
        jsonWriter.name("translationX").value(f2);
        jsonWriter.name("translationY").value(f);
        jsonWriter.name("classes");
        jsonWriter.beginArray();
        Class<?> cls = view.getClass();
        do {
            Class<?> cls2 = cls;
            jsonWriter.value(this.c.get(cls2));
            cls = cls2.getSuperclass();
            if (cls == Object.class) {
                break;
            }
        } while (cls != null);
        jsonWriter.endArray();
        c(jsonWriter, view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
            jsonWriter.name("layoutRules");
            jsonWriter.beginArray();
            for (int i : rules) {
                jsonWriter.value(i);
            }
            jsonWriter.endArray();
        }
        jsonWriter.name("subviews");
        jsonWriter.beginArray();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) != null) {
                    jsonWriter.value(r4.hashCode());
                }
            }
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                View childAt = viewGroup2.getChildAt(i3);
                if (childAt != null) {
                    b(jsonWriter, childAt);
                }
            }
        }
    }

    private void c(JsonWriter jsonWriter, View view) throws IOException {
        Object a2;
        Class<?> cls = view.getClass();
        for (g gVar : this.b) {
            if (gVar.b.isAssignableFrom(cls) && gVar.c != null && (a2 = gVar.c.a(view)) != null) {
                if (a2 instanceof Number) {
                    jsonWriter.name(gVar.f3093a).value((Number) a2);
                } else if (a2 instanceof Boolean) {
                    jsonWriter.name(gVar.f3093a).value(((Boolean) a2).booleanValue());
                } else if (a2 instanceof ColorStateList) {
                    jsonWriter.name(gVar.f3093a).value(Integer.valueOf(((ColorStateList) a2).getDefaultColor()));
                } else if (a2 instanceof Drawable) {
                    Drawable drawable = (Drawable) a2;
                    Rect bounds = drawable.getBounds();
                    jsonWriter.name(gVar.f3093a);
                    jsonWriter.beginObject();
                    jsonWriter.name("classes");
                    jsonWriter.beginArray();
                    for (Class<?> cls2 = drawable.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                        jsonWriter.value(cls2.getCanonicalName());
                    }
                    jsonWriter.endArray();
                    jsonWriter.name("dimensions");
                    jsonWriter.beginObject();
                    jsonWriter.name("left").value(bounds.left);
                    jsonWriter.name("right").value(bounds.right);
                    jsonWriter.name("top").value(bounds.top);
                    jsonWriter.name("bottom").value(bounds.bottom);
                    jsonWriter.endObject();
                    if (drawable instanceof ColorDrawable) {
                        jsonWriter.name("color").value(((ColorDrawable) drawable).getColor());
                    }
                    jsonWriter.endObject();
                } else {
                    jsonWriter.name(gVar.f3093a).value(a2.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewSnapshot.java */
    /* loaded from: classes.dex */
    public static class b extends LruCache<Class<?>, String> {
        public b(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    /* compiled from: ViewSnapshot.java */
    /* loaded from: classes.dex */
    private static class c implements Callable<List<d>> {

        /* renamed from: a, reason: collision with root package name */
        private i<Activity> f3106a;
        private final int e = 160;
        private final DisplayMetrics c = new DisplayMetrics();
        private final List<d> b = new ArrayList();
        private final a d = new a();

        public void a(i<Activity> iVar) {
            this.f3106a = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<d> call() throws Exception {
            this.b.clear();
            for (Activity activity : this.f3106a.a()) {
                String canonicalName = activity.getClass().getCanonicalName();
                View rootView = activity.getWindow().getDecorView().getRootView();
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.c);
                this.b.add(new d(canonicalName, rootView));
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a(this.b.get(i));
            }
            return this.b;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(com.mixpanel.android.viewcrawler.n.d r14) {
            /*
                Method dump skipped, instructions count: 276
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.n.c.a(com.mixpanel.android.viewcrawler.n$d):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewSnapshot.java */
    /* loaded from: classes.dex */
    public static class a {
        private final Paint b = new Paint(2);

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f3105a = null;

        public synchronized void a(int i, int i2, int i3, Bitmap bitmap) {
            if (this.f3105a == null || this.f3105a.getWidth() != i || this.f3105a.getHeight() != i2) {
                try {
                    this.f3105a = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError e) {
                    this.f3105a = null;
                }
                if (this.f3105a != null) {
                    this.f3105a.setDensity(i3);
                }
            }
            if (this.f3105a != null) {
                new Canvas(this.f3105a).drawBitmap(bitmap, 0.0f, 0.0f, this.b);
            }
        }

        public synchronized void a(Bitmap.CompressFormat compressFormat, int i, OutputStream outputStream) throws IOException {
            if (this.f3105a == null || this.f3105a.getWidth() == 0 || this.f3105a.getHeight() == 0) {
                outputStream.write("null".getBytes());
            } else {
                outputStream.write(34);
                Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                this.f3105a.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                base64OutputStream.flush();
                outputStream.write(34);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewSnapshot.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f3107a;
        public final View b;
        public a c = null;
        public float d = 1.0f;

        public d(String str, View view) {
            this.f3107a = str;
            this.b = view;
        }
    }
}
