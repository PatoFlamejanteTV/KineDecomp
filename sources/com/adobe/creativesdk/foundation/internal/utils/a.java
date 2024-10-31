package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: AdobeAssetInfoUtil.java */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, Date date) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        calendar.get(4);
        calendar.get(5);
        long a2 = a(date, calendar);
        calendar.setTime(date);
        calendar.get(4);
        int i3 = i2 - calendar.get(2);
        int i4 = i - calendar.get(1);
        if (a2 < 7) {
            if (a2 == 0) {
                return context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_today);
            }
            return a2 == 1 ? context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_oneday) : String.format(context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_days), Long.valueOf(a2));
        }
        if (a2 < 31) {
            int i5 = (int) (a2 / 7);
            if (a2 < i5 * 7) {
                i5--;
            }
            return i5 == 1 ? context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_oneweek) : String.format(context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_weeks), Integer.valueOf(i5));
        }
        if (a2 >= 365) {
            if (i4 == 0) {
                return context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_thisyear);
            }
            return i4 == 1 ? context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_oneyear) : String.format(context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_years), Integer.valueOf(i4));
        }
        if (i3 <= 0) {
            i3 += 12;
        }
        if (a2 < i3 * 31) {
            i3--;
        }
        return i3 == 1 ? context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_onemonth) : String.format(context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_Loki_ModifedDate_months), Integer.valueOf(i3));
    }

    public static String a(Context context, long j) {
        if (j % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID != 0) {
            float f2 = ((float) j) / 1024.0f;
            if (f2 < 1024.0f) {
                return String.format("%.2f ", Float.valueOf(f2)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_KB);
            }
            float f3 = f2 / 1024.0f;
            if (f3 < 1024.0f) {
                return String.format("%.2f ", Float.valueOf(f3)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_MB);
            }
            return String.format("%.2f ", Float.valueOf(f3 / 1024.0f)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_GB);
        }
        long j2 = j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return String.format("%d ", Long.valueOf(j2)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_KB);
        }
        if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID != 0) {
            float f4 = ((float) j2) / 1024.0f;
            if (f4 < 1024.0f) {
                return String.format("%.2f ", Float.valueOf(f4)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_MB);
            }
            return String.format("%.2f ", Float.valueOf(f4 / 1024.0f)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_GB);
        }
        long j3 = j2 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (j3 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return String.format("%d ", Long.valueOf(j3)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_MB);
        }
        if (j3 % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID == 0) {
            return String.format("%d ", Long.valueOf(j3 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_GB);
        }
        return String.format("%.2f ", Float.valueOf(((float) j3) / 1024.0f)) + context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_DETAILS_GB);
    }

    public static Drawable a(Context context, String str) {
        String string = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_zip);
        String string2 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_xls);
        String string3 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_wav);
        String string4 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_ttf);
        String string5 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_ppt);
        String string6 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_otf);
        String string7 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_mp3);
        String string8 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_doc);
        String string9 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_docx);
        String string10 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_mkv);
        String string11 = context.getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_empty_file_extension_xd);
        if (str.equalsIgnoreCase(string)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_zip);
        }
        if (str.equalsIgnoreCase(string2)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_xls);
        }
        if (str.equalsIgnoreCase(string3)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_wav);
        }
        if (str.equalsIgnoreCase(string4)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_ttf);
        }
        if (str.equalsIgnoreCase(string5)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_ppt);
        }
        if (str.equalsIgnoreCase(string6)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_otf);
        }
        if (str.equalsIgnoreCase(string7)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_mp3);
        }
        if (str.equalsIgnoreCase(string8)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_doc);
        }
        if (str.equalsIgnoreCase(string9)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_doc);
        }
        if (str.equalsIgnoreCase(string10)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_mkv);
        }
        if (str.equalsIgnoreCase(string11)) {
            return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_file_xd);
        }
        return null;
    }

    public static Drawable a(Context context) {
        return ContextCompat.getDrawable(context, c.a.a.a.b.d.empty_generic_file);
    }

    private static long a(Date date, Calendar calendar) {
        Date time = calendar.getTime();
        return Math.abs((time.getTime() - date.getTime()) / 86400000);
    }
}
