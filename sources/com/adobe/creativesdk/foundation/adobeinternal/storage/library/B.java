package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.os.Handler;
import android.util.Log;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.a.b.va;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.adobe.creativesdk.foundation.storage.sd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeLibraryBookmarkManager.java */
/* loaded from: classes.dex */
public class B {

    /* renamed from: a, reason: collision with root package name */
    private static String f4501a = "bookmarks.json";

    /* renamed from: b, reason: collision with root package name */
    private static String f4502b = "/sync/adobe-libraries/";

    /* renamed from: c, reason: collision with root package name */
    private String f4503c = "id";

    /* renamed from: d, reason: collision with root package name */
    private String f4504d = "url";

    /* renamed from: e, reason: collision with root package name */
    private String f4505e = "bookmarks";

    /* renamed from: f, reason: collision with root package name */
    ArrayList<C0291u> f4506f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<C0291u> f4507g;

    /* renamed from: h, reason: collision with root package name */
    D f4508h;
    com.adobe.creativesdk.foundation.internal.storage.model.resources.f i;
    boolean j;

    public B a(D d2) {
        this.f4507g = null;
        this.f4506f = null;
        this.j = false;
        this.f4508h = d2;
        this.i = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.b(f4502b + f4501a);
        return this;
    }

    String b() {
        return ((G) Gb.f()).w() + f4501a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        synchronized (this) {
            d();
        }
    }

    void d() {
        try {
            JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(a(b()));
            if (a2 == null) {
                return;
            }
            this.f4507g = a(a2);
            this.f4506f = a(a2);
            try {
                this.i.f6613e = a2.getString("etag");
                this.i.a(a2.toString().getBytes());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "LoadBookmarks-Error", e3.getMessage());
        }
    }

    void e() {
        ArrayList<C0291u> arrayList = this.f4507g;
        if (arrayList == null || arrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("etag", this.i.f6613e);
            jSONObject.put("bookmarks", a(this.f4507g).getJSONArray("bookmarks"));
            try {
                FileWriter fileWriter = new FileWriter(b());
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e2) {
                Log.e("TAG", "Error in Writing: " + e2.getLocalizedMessage());
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList<C0291u> arrayList) {
        if (arrayList != null) {
            ArrayList<C0291u> arrayList2 = new ArrayList<>();
            Iterator<C0291u> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next());
            }
            if (this.f4506f != null) {
                Iterator<C0291u> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C0291u next = it2.next();
                    C0291u a2 = a(next.f4661a, this.f4507g);
                    C0291u a3 = a(next.f4661a, this.f4506f);
                    if (a2 == null && a3 != null) {
                        arrayList2.remove(next);
                    }
                }
            }
            this.f4507g = arrayList2;
        }
    }

    JSONObject a(ArrayList<C0291u> arrayList) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<C0291u> it = arrayList.iterator();
        while (it.hasNext()) {
            C0291u next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f4503c, next.f4661a);
            jSONObject2.put(this.f4504d, next.f4662b);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put(this.f4505e, jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<C0291u> a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        if (jSONObject == null) {
            return null;
        }
        ArrayList<C0291u> arrayList = new ArrayList<>();
        try {
            jSONArray = jSONObject.getJSONArray("bookmarks");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(C0291u.a(jSONArray.getJSONObject(i).getString("id"), jSONArray.getJSONObject(i).getString("url")));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return arrayList;
    }

    C0291u a(String str, ArrayList<C0291u> arrayList) {
        Iterator<C0291u> it = arrayList.iterator();
        while (it.hasNext()) {
            C0291u next = it.next();
            if (next.f4661a.toLowerCase().equals(str.toLowerCase())) {
                return next;
            }
        }
        return null;
    }

    static String a(String str) throws IOException {
        new File(str);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        try {
            StringBuilder sb = new StringBuilder();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine + '\n');
            }
            return sb.toString();
        } finally {
            bufferedReader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(AdobeAssetException adobeAssetException) {
        return adobeAssetException.getErrorCode().equals(AdobeAssetErrorCode.AdobeAssetErrorConflictingChanges) || adobeAssetException.getHttpStatusCode().intValue() == 409;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.j a(sd sdVar) {
        ha haVar = this.f4508h.m;
        if (haVar == null) {
            return null;
        }
        return ((ra) haVar.o()).a(this.i, false, (va) new C0293w(this, sdVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Boolean bool) {
        synchronized (this) {
            e();
        }
        if (bool.booleanValue()) {
            a(new C0294x(this));
        }
    }

    public boolean a(C0291u c0291u) {
        synchronized (this) {
            C0291u a2 = a(c0291u.f4661a, this.f4507g);
            if (a2 == null) {
                return false;
            }
            a();
            this.f4507g.remove(a2);
            a(Boolean.valueOf(((G) Gb.f()).o()));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.j a(ja jaVar) {
        ha haVar = this.f4508h.m;
        if (haVar == null) {
            return null;
        }
        return ((ra) haVar.o()).a(this.i, new C0295y(this, this.i.d(), jaVar), (Handler) null, (String) null);
    }

    void a() {
        if (this.f4506f == null) {
            this.f4506f = new ArrayList<>();
            Iterator<C0291u> it = this.f4507g.iterator();
            while (it.hasNext()) {
                this.f4506f.add(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.j a(ka kaVar) {
        synchronized (this) {
            if (!Gb.f().k()) {
                return null;
            }
            this.j = false;
            if (this.f4507g != null) {
                try {
                    this.i.a(a(this.f4507g).toString().getBytes("utf-8"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f4506f != null) {
                return a(new C0296z(this, kaVar));
            }
            return a(new A(this, kaVar));
        }
    }
}
