package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyTokenHelper.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private static final String f414a = y.class.getSimpleName();
    private String b;
    private SharedPreferences c;

    public y(Context context) {
        this(context, null);
    }

    public y(Context context, String str) {
        Validate.notNull(context, "context");
        this.b = Utility.isNullOrEmpty(str) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        Context applicationContext = context.getApplicationContext();
        this.c = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.b, 0);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        for (String str : this.c.getAll().keySet()) {
            try {
                a(str, bundle);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, f414a, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public void b() {
        this.c.edit().clear().apply();
    }

    public static boolean a(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0) ? false : true;
    }

    public static String b(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static AccessTokenSource c(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static String d(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Date a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j != Long.MIN_VALUE) {
            return new Date(j);
        }
        return null;
    }

    private void a(String str, Bundle bundle) throws JSONException {
        int i = 0;
        JSONObject jSONObject = new JSONObject(this.c.getString(str, "{}"));
        String string = jSONObject.getString("valueType");
        if (string.equals("bool")) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            return;
        }
        if (string.equals("bool[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < zArr.length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        if (string.equals("byte")) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
            return;
        }
        if (string.equals("byte[]")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[jSONArray2.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) jSONArray2.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
            return;
        }
        if (string.equals("short")) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
            return;
        }
        if (string.equals("short[]")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
            short[] sArr = new short[jSONArray3.length()];
            while (i < sArr.length) {
                sArr[i] = (short) jSONArray3.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
            return;
        }
        if (string.equals("int")) {
            bundle.putInt(str, jSONObject.getInt("value"));
            return;
        }
        if (string.equals("int[]")) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
            int[] iArr = new int[jSONArray4.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray4.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
            return;
        }
        if (string.equals("long")) {
            bundle.putLong(str, jSONObject.getLong("value"));
            return;
        }
        if (string.equals("long[]")) {
            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
            long[] jArr = new long[jSONArray5.length()];
            while (i < jArr.length) {
                jArr[i] = jSONArray5.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        if (string.equals("float")) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
            return;
        }
        if (string.equals("float[]")) {
            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
            float[] fArr = new float[jSONArray6.length()];
            while (i < fArr.length) {
                fArr[i] = (float) jSONArray6.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
            return;
        }
        if (string.equals("double")) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
            return;
        }
        if (string.equals("double[]")) {
            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
            double[] dArr = new double[jSONArray7.length()];
            while (i < dArr.length) {
                dArr[i] = jSONArray7.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
            return;
        }
        if (string.equals("char")) {
            String string2 = jSONObject.getString("value");
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
                return;
            }
            return;
        }
        if (string.equals("char[]")) {
            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
            char[] cArr = new char[jSONArray8.length()];
            for (int i2 = 0; i2 < cArr.length; i2++) {
                String string3 = jSONArray8.getString(i2);
                if (string3 != null && string3.length() == 1) {
                    cArr[i2] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
            return;
        }
        if (string.equals("string")) {
            bundle.putString(str, jSONObject.getString("value"));
            return;
        }
        if (string.equals("stringList")) {
            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
            int length = jSONArray9.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray9.get(i3);
                arrayList.add(i3, obj == JSONObject.NULL ? null : (String) obj);
            }
            bundle.putStringArrayList(str, arrayList);
            return;
        }
        if (string.equals("enum")) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
