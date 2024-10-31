package com.facebook.appevents;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppEvent implements Serializable {

    /* renamed from: a */
    private static final HashSet<String> f9155a = new HashSet<>();
    private static final long serialVersionUID = 1;
    private final String checksum;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    /* loaded from: classes.dex */
    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean isImplicit;
        private final String jsonString;

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, null);
        }
    }

    /* loaded from: classes.dex */
    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean isImplicit;
        private final String jsonString;

        /* synthetic */ SerializationProxyV2(String str, boolean z, String str2, e eVar) {
            this(str, z, str2);
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, this.checksum);
        }

        private SerializationProxyV2(String str, boolean z, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.checksum = str2;
        }
    }

    /* synthetic */ AppEvent(String str, boolean z, String str2, e eVar) throws JSONException {
        this(str, z, str2);
    }

    private static JSONObject a(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) throws FacebookException, JSONException {
        b(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, str2);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, a(str2));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d2 != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d2.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                b(str3);
                Object obj = bundle.get(str3);
                if (!(obj instanceof String) && !(obj instanceof Number)) {
                    throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                }
                jSONObject.put(str3, obj.toString());
            }
        }
        if (!z) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private static void b(String str) throws FacebookException {
        boolean contains;
        if (str != null && str.length() != 0 && str.length() <= 40) {
            synchronized (f9155a) {
                contains = f9155a.contains(str);
            }
            if (contains) {
                return;
            }
            if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                synchronized (f9155a) {
                    f9155a.add(str);
                }
                return;
            }
            throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
        }
        if (str == null) {
            str = "<None Provided>";
        }
        throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public String getName() {
        return this.name;
    }

    public boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return a().equals(this.checksum);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
    }

    public AppEvent(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) throws JSONException, FacebookException {
        this.jsonObject = a(str, str2, d2, bundle, z, uuid);
        this.isImplicit = z;
        this.name = str2;
        this.checksum = a();
    }

    private AppEvent(String str, boolean z, String str2) throws JSONException {
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        this.checksum = str2;
    }

    private String a() {
        if (Build.VERSION.SDK_INT > 19) {
            return a(this.jsonObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str);
            sb.append(" = ");
            sb.append(this.jsonObject.optString(str));
            sb.append('\n');
        }
        return a(sb.toString());
    }

    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return AppEventUtility.bytesToHex(messageDigest.digest());
        } catch (UnsupportedEncodingException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            return "1";
        } catch (NoSuchAlgorithmException e3) {
            Utility.logd("Failed to generate checksum: ", e3);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }
}
