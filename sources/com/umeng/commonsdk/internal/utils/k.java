package com.umeng.commonsdk.internal.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMInternalUtils.java */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a */
    private static final String f26132a = "um_pri";

    /* renamed from: b */
    private static final String f26133b = "um_common_strength";

    /* renamed from: c */
    private static final String f26134c = "um_common_battery";

    public static String a(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
            }
            if (UMUtils.checkPermission(context, "android.permission.BLUETOOTH")) {
                return BluetoothAdapter.getDefaultAdapter().getAddress();
            }
        }
        return null;
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || !UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) == null) {
            return null;
        }
        return telephonyManager.getSimSerialNumber();
    }

    public static String c(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 23 || !UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager == null) {
                return null;
            }
            Class<?> cls = telephonyManager.getClass();
            if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() == 2) {
                return (String) cls.getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, 2);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.json.JSONObject] */
    public static JSONObject d(Context context) {
        TelephonyManager telephonyManager;
        if (context == null) {
            return null;
        }
        if ((!UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") && !UMUtils.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) || (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        int phoneType = telephonyManager.getPhoneType();
        try {
            if (phoneType == 1 && (cellLocation instanceof GsmCellLocation)) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                int cid = gsmCellLocation.getCid();
                if (cid <= 0 || cid == 65535) {
                    return null;
                }
                int lac = gsmCellLocation.getLac();
                ?? jSONObject = new JSONObject();
                jSONObject.put("cid", cid);
                jSONObject.put("lacid", lac);
                jSONObject.put("ts", System.currentTimeMillis());
                cellLocation = jSONObject;
            } else {
                if (phoneType != 2 || !(cellLocation instanceof CdmaCellLocation)) {
                    return null;
                }
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int baseStationId = cdmaCellLocation.getBaseStationId();
                int networkId = cdmaCellLocation.getNetworkId();
                ?? jSONObject2 = new JSONObject();
                jSONObject2.put("cid", baseStationId);
                jSONObject2.put("lacid", networkId);
                jSONObject2.put("ts", System.currentTimeMillis());
                cellLocation = jSONObject2;
            }
        } catch (Exception unused) {
        }
        return cellLocation;
    }

    public static String e(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26132a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f26133b, null);
    }

    public static String f(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26132a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f26134c, null);
    }

    public static JSONArray g(Context context) {
        SensorManager sensorManager;
        JSONArray jSONArray = new JSONArray();
        if (context == null || (sensorManager = (SensorManager) context.getSystemService(com.umeng.commonsdk.proguard.e.aa)) == null) {
            return jSONArray;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            if (sensor != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a_type", sensor.getType());
                    jSONObject.put("a_ven", sensor.getVendor());
                    if (Build.VERSION.SDK_INT >= 24) {
                        jSONObject.put("a_id", sensor.getId());
                    }
                    jSONObject.put("a_na", sensor.getName());
                    jSONObject.put("a_ver", sensor.getVersion());
                    jSONObject.put("a_mar", sensor.getMaximumRange());
                    jSONObject.put("a_ver", sensor.getVersion());
                    jSONObject.put("a_res", sensor.getResolution());
                    jSONObject.put("a_po", sensor.getPower());
                    if (Build.VERSION.SDK_INT >= 9) {
                        jSONObject.put("a_mid", sensor.getMinDelay());
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        jSONObject.put("a_mad", sensor.getMaxDelay());
                    }
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26132a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f26134c, str).commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26132a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f26133b, str).commit();
    }
}
