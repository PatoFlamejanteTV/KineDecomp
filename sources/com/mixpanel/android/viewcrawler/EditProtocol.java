package com.mixpanel.android.viewcrawler;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.y;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.viewcrawler.f;
import com.mixpanel.android.viewcrawler.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class EditProtocol {
    private static final Class<?>[] d = new Class[0];
    private static final List<f.c> e = Collections.emptyList();

    /* renamed from: a, reason: collision with root package name */
    private final y f3077a;
    private final ImageStore b;
    private final o.i c;

    /* loaded from: classes.dex */
    public static class BadInstructionsException extends Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static class InapplicableInstructionsException extends BadInstructionsException {
        private static final long serialVersionUID = 3977056710817909104L;

        public InapplicableInstructionsException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class CantGetEditAssetsException extends Exception {
        public CantGetEditAssetsException(String str) {
            super(str);
        }

        public CantGetEditAssetsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final o f3078a;
        public final List<String> b;

        private a(o oVar, List<String> list) {
            this.f3078a = oVar;
            this.b = list;
        }
    }

    public EditProtocol(y yVar, ImageStore imageStore, o.i iVar) {
        this.f3077a = yVar;
        this.b = imageStore;
        this.c = iVar;
    }

    public o a(JSONObject jSONObject, o.h hVar) throws BadInstructionsException {
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            List<f.c> a2 = a(jSONObject.getJSONArray("path"), this.f3077a);
            if (a2.size() == 0) {
                throw new InapplicableInstructionsException("event '" + string + "' will not be bound to any element in the UI.");
            }
            if ("click".equals(string2)) {
                return new o.a(a2, 1, string, hVar);
            }
            if ("selected".equals(string2)) {
                return new o.a(a2, 4, string, hVar);
            }
            if ("text_changed".equals(string2)) {
                return new o.b(a2, string, hVar);
            }
            if ("detected".equals(string2)) {
                return new o.k(a2, string, hVar);
            }
            throw new BadInstructionsException("Mixpanel can't track event type \"" + string2 + "\"");
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e2);
        }
    }

    public a a(JSONObject jSONObject) throws BadInstructionsException, CantGetEditAssetsException {
        o gVar;
        Integer a2;
        ArrayList arrayList = new ArrayList();
        try {
            List<f.c> a3 = a(jSONObject.getJSONArray("path"), this.f3077a);
            if (a3.size() == 0) {
                throw new InapplicableInstructionsException("Edit will not be bound to any element in the UI.");
            }
            if (jSONObject.getString("change_type").equals("property")) {
                String string = jSONObject.getJSONObject("property").getString("classname");
                if (string == null) {
                    throw new BadInstructionsException("Can't bind an edit property without a target class");
                }
                try {
                    g a4 = a(Class.forName(string), jSONObject.getJSONObject("property"));
                    JSONArray jSONArray = jSONObject.getJSONArray("args");
                    Object[] objArr = new Object[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        objArr[i] = a(jSONArray2.get(0), jSONArray2.getString(1), arrayList);
                    }
                    com.mixpanel.android.viewcrawler.a a5 = a4.a(objArr);
                    if (a5 == null) {
                        throw new BadInstructionsException("Can't update a read-only property " + a4.f3093a + " (add a mutator to make this work)");
                    }
                    gVar = new o.j(a3, a5, a4.c);
                } catch (ClassNotFoundException e2) {
                    throw new BadInstructionsException("Can't find class for visit path: " + string, e2);
                }
            } else if (jSONObject.getString("change_type").equals("layout")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("args");
                ArrayList arrayList2 = new ArrayList();
                int length = jSONArray3.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray3.optJSONObject(i2);
                    String string2 = optJSONObject.getString("view_id_name");
                    String string3 = optJSONObject.getString("anchor_id_name");
                    Integer a6 = a(-1, string2, this.f3077a);
                    if (string3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        a2 = 0;
                    } else if (string3.equals("-1")) {
                        a2 = -1;
                    } else {
                        a2 = a(-1, string3, this.f3077a);
                    }
                    if (a6 == null || a2 == null) {
                        Log.w("MixpanelAPI.EProtocol", "View (" + string2 + ") or anchor (" + string3 + ") not found.");
                    } else {
                        arrayList2.add(new o.f(a6.intValue(), optJSONObject.getInt("verb"), a2.intValue()));
                    }
                }
                gVar = new o.g(a3, arrayList2, jSONObject.getString("name"), this.c);
            } else {
                throw new BadInstructionsException("Can't figure out the edit type");
            }
            return new a(gVar, arrayList);
        } catch (NoSuchMethodException e3) {
            throw new BadInstructionsException("Can't create property mutator", e3);
        } catch (JSONException e4) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e4);
        }
    }

    public n b(JSONObject jSONObject) throws BadInstructionsException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(a(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new n(arrayList, this.f3077a);
        } catch (ClassNotFoundException e2) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e2);
        } catch (JSONException e3) {
            throw new BadInstructionsException("Can't read snapshot configuration", e3);
        }
    }

    public Pair<String, Object> c(JSONObject jSONObject) throws BadInstructionsException {
        Object string;
        try {
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString("type");
            if ("number".equals(string3)) {
                String string4 = jSONObject.getString("encoding");
                if ("d".equals(string4)) {
                    string = Double.valueOf(jSONObject.getDouble("value"));
                } else if ("l".equals(string4)) {
                    string = Long.valueOf(jSONObject.getLong("value"));
                } else {
                    throw new BadInstructionsException("number must have encoding of type \"l\" for long or \"d\" for double in: " + jSONObject);
                }
            } else if ("boolean".equals(string3)) {
                string = Boolean.valueOf(jSONObject.getBoolean("value"));
            } else if ("string".equals(string3)) {
                string = jSONObject.getString("value");
            } else {
                throw new BadInstructionsException("Unrecognized tweak type " + string3 + " in: " + jSONObject);
            }
            return new Pair<>(string2, string);
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't read tweak update", e2);
        }
    }

    List<f.c> a(JSONArray jSONArray, y yVar) throws JSONException {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String a2 = com.mixpanel.android.util.e.a(jSONObject, "prefix");
            String a3 = com.mixpanel.android.util.e.a(jSONObject, "view_class");
            int optInt = jSONObject.optInt("index", -1);
            String a4 = com.mixpanel.android.util.e.a(jSONObject, "contentDescription");
            int optInt2 = jSONObject.optInt(ShareConstants.WEB_DIALOG_PARAM_ID, -1);
            String a5 = com.mixpanel.android.util.e.a(jSONObject, "mp_id_name");
            String a6 = com.mixpanel.android.util.e.a(jSONObject, "tag");
            if ("shortest".equals(a2)) {
                i = 1;
            } else {
                if (a2 != null) {
                    Log.w("MixpanelAPI.EProtocol", "Unrecognized prefix type \"" + a2 + "\". No views will be matched");
                    return e;
                }
                i = 0;
            }
            Integer a7 = a(optInt2, a5, yVar);
            if (a7 == null) {
                return e;
            }
            arrayList.add(new f.c(i, a3, optInt, a7.intValue(), a4, a6));
        }
        return arrayList;
    }

    private Integer a(int i, String str, y yVar) {
        int i2;
        if (str == null) {
            i2 = -1;
        } else if (yVar.a(str)) {
            i2 = yVar.b(str);
        } else {
            Log.w("MixpanelAPI.EProtocol", "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"" + str + "\"");
            return null;
        }
        if (-1 != i2 && -1 != i && i2 != i) {
            Log.e("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        }
        if (-1 != i2) {
            return Integer.valueOf(i2);
        }
        return Integer.valueOf(i);
    }

    private g a(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        com.mixpanel.android.viewcrawler.a aVar;
        try {
            String string = jSONObject.getString("name");
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                aVar = new com.mixpanel.android.viewcrawler.a(cls, jSONObject2.getString("selector"), d, Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                aVar = null;
            }
            return new g(string, cls, aVar, jSONObject.has("set") ? jSONObject.getJSONObject("set").getString("selector") : null);
        } catch (ClassNotFoundException e2) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e2);
        } catch (NoSuchMethodException e3) {
            throw new BadInstructionsException("Can't create property reader", e3);
        } catch (JSONException e4) {
            throw new BadInstructionsException("Can't read property JSON", e4);
        }
    }

    private Object a(Object obj, String str, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        try {
            if (!"java.lang.CharSequence".equals(str) && !"boolean".equals(str) && !"java.lang.Boolean".equals(str)) {
                if ("int".equals(str) || "java.lang.Integer".equals(str)) {
                    return Integer.valueOf(((Number) obj).intValue());
                }
                if ("float".equals(str) || "java.lang.Float".equals(str)) {
                    return Float.valueOf(((Number) obj).floatValue());
                }
                if ("android.graphics.drawable.Drawable".equals(str)) {
                    return a((JSONObject) obj, list);
                }
                if ("android.graphics.drawable.BitmapDrawable".equals(str)) {
                    return a((JSONObject) obj, list);
                }
                if ("android.graphics.drawable.ColorDrawable".equals(str)) {
                    return new ColorDrawable(((Number) obj).intValue());
                }
                throw new BadInstructionsException("Don't know how to interpret type " + str + " (arg was " + obj + ")");
            }
            return obj;
        } catch (ClassCastException e2) {
            throw new BadInstructionsException("Couldn't interpret <" + obj + "> as " + str);
        }
    }

    private Drawable a(JSONObject jSONObject, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4 = 0;
        try {
            if (jSONObject.isNull("url")) {
                throw new BadInstructionsException("Can't construct a BitmapDrawable with a null url");
            }
            String string = jSONObject.getString("url");
            if (jSONObject.isNull("dimensions")) {
                i3 = 0;
                i2 = 0;
                i = 0;
                z = false;
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                i = jSONObject2.getInt("left");
                i2 = jSONObject2.getInt("right");
                i3 = jSONObject2.getInt("top");
                i4 = jSONObject2.getInt("bottom");
                z = true;
            }
            try {
                Bitmap a2 = this.b.a(string);
                list.add(string);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), a2);
                if (z) {
                    bitmapDrawable.setBounds(i, i3, i2, i4);
                }
                return bitmapDrawable;
            } catch (ImageStore.CantGetImageException e2) {
                throw new CantGetEditAssetsException(e2.getMessage(), e2.getCause());
            }
        } catch (JSONException e3) {
            throw new BadInstructionsException("Couldn't read drawable description", e3);
        }
    }
}
