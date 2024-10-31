package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Locale;

/* compiled from: TipManager.java */
/* loaded from: classes2.dex */
public class Lb {

    /* compiled from: TipManager.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public final int f22858a;

        /* renamed from: b */
        public final String f22859b;

        /* renamed from: c */
        public final String f22860c;

        /* synthetic */ a(int i, String str, Kb kb) {
            this(i, str);
        }

        public Spannable a() {
            int indexOf = this.f22859b.indexOf(123);
            int indexOf2 = this.f22859b.indexOf(125);
            if (indexOf >= 0 && indexOf2 > indexOf) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f22859b.substring(0, indexOf));
                spannableStringBuilder.append((CharSequence) this.f22859b.substring(indexOf + 1, indexOf2));
                spannableStringBuilder.append((CharSequence) this.f22859b.substring(indexOf2 + 1));
                int i = indexOf2 - 1;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-42149), indexOf, i, 33);
                spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, i, 33);
                return spannableStringBuilder;
            }
            return new SpannableString(this.f22859b);
        }

        public boolean b() {
            String str = this.f22860c;
            return str != null && str.startsWith("tip:");
        }

        public boolean c() {
            String str = this.f22860c;
            return str != null && str.startsWith("help:");
        }

        public boolean d() {
            return this.f22860c != null;
        }

        public boolean e() {
            String str = this.f22860c;
            return str != null && str.startsWith("settings:");
        }

        public boolean f() {
            String str = this.f22860c;
            return str != null && (str.startsWith("http:") || this.f22860c.startsWith("https:"));
        }

        /* synthetic */ a(int i, String str, String str2, Kb kb) {
            this(i, str, str2);
        }

        private a(int i, String str, String str2) {
            this.f22858a = i;
            this.f22859b = str;
            this.f22860c = str2;
        }

        private a(int i, String str) {
            this.f22858a = i;
            this.f22859b = str;
            this.f22860c = null;
        }
    }

    public static a a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Resources resources = context.getResources();
        int i = -1;
        int i2 = defaultSharedPreferences.getInt("km.tipShownString", -1);
        int i3 = defaultSharedPreferences.getInt("km.tipMaxShownString", -1);
        if (defaultSharedPreferences.getInt("km.tipVer", -1) != 2) {
            i2 = -1;
        } else {
            i = i3;
        }
        a[] a2 = a(locale, resources);
        if (a2.length < 1) {
            return null;
        }
        if (i < a2.length - 1) {
            i2 = i;
        }
        int length = (i2 + 1) % a2.length;
        if (length > i) {
            i = length;
        }
        defaultSharedPreferences.edit().putInt("km.tipShownString", length).putInt("km.tipMaxShownString", i).putInt("km.tipVer", 2).apply();
        return a2[length];
    }

    private static a[] a(Locale locale, Resources resources) {
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        locale.getCountry().toUpperCase(Locale.US);
        if ("zh".equals(lowerCase)) {
            return new a[]{new a(R.drawable.ic_tips, resources.getString(R.string.tips_490_1_import_hevc_video), "https://data.newrank.cn/m/s.html?s=PTArPjI9LDw9")};
        }
        return new a[]{new a(R.drawable.ic_tips, resources.getString(R.string.tips_490_1_import_hevc_video)), new a(R.drawable.ic_tips, resources.getString(R.string.tips_490_2_more_video_layers))};
    }
}
