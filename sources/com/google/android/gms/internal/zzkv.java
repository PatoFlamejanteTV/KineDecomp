package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzkv {
    private static final com.google.android.gms.cast.internal.zzl zzVo = new com.google.android.gms.cast.internal.zzl("MetadataUtils");
    private static final String[] zzZK = {"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String zzZL = "yyyyMMdd'T'HHmmss" + zzZK[0];

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zzVo.b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzZL;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", zzZK[0]) : format;
    }

    public static void zza(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void zza(JSONObject jSONObject, List<WebImage> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<WebImage> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e());
        }
        try {
            jSONObject.put("images", jSONArray);
        } catch (JSONException e) {
        }
    }

    public static Calendar zzbT(String str) {
        if (TextUtils.isEmpty(str)) {
            zzVo.b("Input string is empty or null", new Object[0]);
            return null;
        }
        String zzbU = zzbU(str);
        if (TextUtils.isEmpty(zzbU)) {
            zzVo.b("Invalid date format", new Object[0]);
            return null;
        }
        String zzbV = zzbV(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(zzbV)) {
            zzbU = zzbU + "T" + zzbV;
            str2 = zzbV.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : zzZL;
        }
        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat(str2).parse(zzbU));
            return gregorianCalendar;
        } catch (ParseException e) {
            zzVo.b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String zzbU(String str) {
        if (TextUtils.isEmpty(str)) {
            zzVo.b("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, "yyyyMMdd".length());
        } catch (IndexOutOfBoundsException e) {
            zzVo.c("Error extracting the date: %s", e.getMessage());
            return null;
        }
    }

    private static String zzbV(String str) {
        if (TextUtils.isEmpty(str)) {
            zzVo.b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            zzVo.b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    if (zzbW(substring)) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case 'Z':
                    if (substring.length() == "HHmmss".length() + zzZK[0].length()) {
                        return substring.substring(0, substring.length() - 1) + "+0000";
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zzVo.b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean zzbW(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == zzZK[1].length() + length2 || length == zzZK[2].length() + length2 || length == length2 + zzZK[3].length();
    }
}
