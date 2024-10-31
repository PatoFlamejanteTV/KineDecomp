package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.KMTServerIndex;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Effect.java */
/* loaded from: classes.dex */
public abstract class b extends am {
    private static Map<String, Integer> q = new HashMap<String, Integer>() { // from class: com.nexstreaming.kinemaster.kmpackage.Effect$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put("com.nexstreaming.kinemaster.spring", Integer.valueOf(R.string.fxcategory_nature));
            put("com.nexstreaming.kinemaster.summer", Integer.valueOf(R.string.fxcategory_nature));
            put("com.nexstreaming.kinemaster.winter", Integer.valueOf(R.string.fxcategory_nature));
            put("com.nexstreaming.kinemaster.fall", Integer.valueOf(R.string.fxcategory_nature));
            put("com.nexstreaming.kinemaster.nature", Integer.valueOf(R.string.fxcategory_nature));
            put("com.nexstreaming.kinemaster.birthday", Integer.valueOf(R.string.fxcategory_special_occasions));
            put("com.nexstreaming.kinemaster.christmas", Integer.valueOf(R.string.fxcategory_special_occasions));
            put("com.nexstreaming.kinemaster.halloween", Integer.valueOf(R.string.fxcategory_special_occasions));
            put("com.nexstreaming.kinemaster.wedding", Integer.valueOf(R.string.fxcategory_special_occasions));
            put("com.nexstreaming.kinemaster.news", Integer.valueOf(R.string.fxcategory_news_and_broadcast));
            put("com.nexstreaming.kinemaster.office", Integer.valueOf(R.string.fxcategory_workplace));
            put("com.nexstreaming.kinemaster.energy", Integer.valueOf(R.string.fxcategory_powerful));
            put("com.nexstreaming.kinemaster.fun", Integer.valueOf(R.string.fxcategory_powerful));
            put("com.nexstreaming.kinemaster.concert", Integer.valueOf(R.string.fxcategory_powerful));
            put("com.nexstreaming.kinemaster.onstage", Integer.valueOf(R.string.fxcategory_powerful));
            put("com.nexstreaming.kinemaster.magic", Integer.valueOf(R.string.fxcategory_powerful));
            put("com.nexstreaming.kinemaster.love", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.love2", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.tree", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.farewell", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.iloveyou", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.sorry", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.serene", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.thankyou", Integer.valueOf(R.string.fxcategory_sentimental));
            put("com.nexstreaming.kinemaster.baby", Integer.valueOf(R.string.fxcategory_family));
            put("com.nexstreaming.kinemaster.pet", Integer.valueOf(R.string.fxcategory_family));
            put("com.nexstreaming.kinemaster.photoalbum", Integer.valueOf(R.string.fxcategory_family));
            put("com.nexstreaming.kinemaster.70s", Integer.valueOf(R.string.fxcategory_pop));
            put("com.nexstreaming.kinemaster.comic", Integer.valueOf(R.string.fxcategory_pop));
            put("com.nexstreaming.kinemaster.comicbook", Integer.valueOf(R.string.fxcategory_pop));
            put("com.nexstreaming.kinemaster.alieninvasion", Integer.valueOf(R.string.fxcategory_sci_fi_and_fantasy));
            put("com.nexstreaming.kinemaster.transformer", Integer.valueOf(R.string.fxcategory_sci_fi_and_fantasy));
            put("com.nexstreaming.kinemaster.superhero", Integer.valueOf(R.string.fxcategory_sci_fi_and_fantasy));
            put("com.nexstreaming.kinemaster.vampire", Integer.valueOf(R.string.fxcategory_sci_fi_and_fantasy));
            put("com.nexstreaming.kinemaster.beach", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.camping", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.museum", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.snow", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.snowboarding", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.travel", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.underwater", Integer.valueOf(R.string.fxcategory_travel_and_activity));
            put("com.nexstreaming.kinemaster.worldcup", Integer.valueOf(R.string.fxcategory_other));
        }
    };
    private static WeakReference<Bitmap> r;

    /* renamed from: a, reason: collision with root package name */
    private String f3445a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private au h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private List<au> f = new ArrayList();
    private List<au> g = Collections.unmodifiableList(this.f);
    private Map<String, Map<String, String>> n = new HashMap();
    private String o = null;
    private WeakReference<Context> p = null;

    public String a() {
        return this.f3445a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String a(Context context) {
        String a2;
        ThemeEffectType themeEffectType;
        Context context2;
        if (this.o != null && this.p != null && (context2 = this.p.get()) != null && context2 == context) {
            return this.o;
        }
        String a3 = a(context, ThemeStringType.NAME);
        if ((a3 == null || a3.trim().length() < 1) && b()) {
            for (Theme theme : EffectLibrary.a(context).c()) {
                String[] d = theme.d();
                int length = d.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (!d[i].equals(this.f3445a) || (a2 = theme.a(context)) == null || a2.trim().length() <= 0) {
                        i++;
                    } else {
                        ThemeEffectType[] values = ThemeEffectType.values();
                        int length2 = values.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                themeEffectType = null;
                            } else {
                                themeEffectType = values[i2];
                                String a4 = theme.a(themeEffectType);
                                if (a4 == null || !a4.equals(this.f3445a)) {
                                    i2++;
                                }
                            }
                        }
                        if (themeEffectType == null) {
                            a3 = context.getResources().getString(R.string.thmefx_name_unknown, a2);
                        } else {
                            switch (themeEffectType) {
                                case MIDDLE:
                                    a3 = context.getResources().getString(R.string.thmefx_name_middle, a2);
                                    break;
                                case ACCENT:
                                    a3 = context.getResources().getString(R.string.thmefx_name_accent, a2);
                                    break;
                                case TRANSITION:
                                    a3 = context.getResources().getString(R.string.thmefx_name_transition, a2);
                                    break;
                                case ENDING:
                                    a3 = context.getResources().getString(R.string.thmefx_name_ending, a2);
                                    break;
                                case OPENING:
                                    a3 = context.getResources().getString(R.string.thmefx_name_opening, a2);
                                    break;
                                case CLIP:
                                    a3 = context.getResources().getString(R.string.thmefx_name_clip, a2);
                                    break;
                                default:
                                    a3 = context.getResources().getString(R.string.thmefx_name_unknown, a2);
                                    break;
                            }
                        }
                    }
                }
            }
        }
        if ((a3 == null || a3.trim().length() < 1) && (a3 = a()) != null && a3.length() > 25) {
            a3 = "..." + a3.substring(a3.length() - 25);
        }
        this.p = new WeakReference<>(context);
        this.o = a3;
        return a3;
    }

    public String b(Context context) {
        String str;
        String a2 = a(context, ThemeStringType.CATEGORY);
        if (a2 == null || a2.trim().length() < 1) {
            if (c()) {
                return "Hidden";
            }
            if (d()) {
                return "Special";
            }
            if (b()) {
                if (this instanceof at) {
                    return context.getResources().getString(R.string.cpanel_theme);
                }
                int lastIndexOf = this.f3445a.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    str = this.f3445a.substring(0, lastIndexOf);
                } else {
                    str = this.f3445a;
                }
                Integer num = q.get(str);
                if (num != null) {
                    return context.getResources().getString(num.intValue());
                }
                return context.getResources().getString(R.string.cpanel_theme);
            }
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        return a2;
    }

    public String a(Context context, ThemeStringType themeStringType) {
        String lowerCase = themeStringType.name().toLowerCase(Locale.US);
        return !this.n.containsKey(lowerCase) ? "" : ah.a(context, this.n.get(lowerCase));
    }

    public List<au> e() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.kmpackage.am
    public void a(String str, ae aeVar, int i) throws KineMasterPackageException {
        boolean z = false;
        if (str.equalsIgnoreCase("effect")) {
            this.f3445a = aeVar.a(ShareConstants.WEB_DIALOG_PARAM_ID).trim();
            this.k = aeVar.a("icon");
            this.m = aeVar.a("ratio");
            this.b = an.a(aeVar.a("theme"), false);
            this.d = this.f3445a.equalsIgnoreCase("none") || this.f3445a.equalsIgnoreCase("com.nexstreaming.kinemaster.builtin.kmlogoending") || this.f3445a.startsWith("com.nexstreaming.kinemaster.builtin.watermark.");
            this.e = false;
            for (String str2 : EffectLibrary.d) {
                if (this.f3445a.equalsIgnoreCase(str2)) {
                    this.e = true;
                }
            }
            if (this.e || (an.a(aeVar.a("hidden"), false) && !this.d)) {
                z = true;
            }
            this.c = z;
            a(ThemeStringType.CATEGORY, "en-us", aeVar.a("categorytitle"));
            a(ThemeStringType.NAME, "en-us", aeVar.a("name"));
            a(ThemeStringType.DESC, "en-us", aeVar.a("description"));
            return;
        }
        if (str.equalsIgnoreCase("userfield")) {
            this.h = new au(aeVar);
            return;
        }
        if (str.equalsIgnoreCase("fieldlabel") && this.h != null) {
            this.h.a(aeVar);
            return;
        }
        if (str.equalsIgnoreCase("option") && this.h != null) {
            this.h.b(aeVar);
            return;
        }
        if (str.equalsIgnoreCase("texture")) {
            String a2 = aeVar.a("typeface", (String) null);
            if (a2 != null) {
                this.l = a2;
                return;
            }
            return;
        }
        if (str.equalsIgnoreCase("string")) {
            this.i = aeVar.a("locale");
            this.j = aeVar.a("name");
            if (this.i == null) {
                this.i = "en-us";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.kmpackage.am
    public void a(String str, String str2, int i) throws KineMasterPackageException {
        if (str.equalsIgnoreCase("userfield") && this.h != null) {
            if (this.h.a()) {
                this.f.add(this.h);
            }
            this.h = null;
        } else {
            if (str.equalsIgnoreCase("option") && this.h != null) {
                this.h.h();
                return;
            }
            if (str.equalsIgnoreCase("string") && this.j != null) {
                if (!this.n.containsKey(this.j)) {
                    this.n.put(this.j, new HashMap());
                }
                this.n.get(this.j).put(this.i.toLowerCase(Locale.US), str2.trim());
                this.j = null;
                this.i = null;
            }
        }
    }

    private void a(ThemeStringType themeStringType, String str, String str2) {
        if (str2 != null && str != null && themeStringType != null) {
            String lowerCase = themeStringType.name().toLowerCase(Locale.US);
            if (!this.n.containsKey(lowerCase)) {
                this.n.put(lowerCase, new HashMap());
            }
            this.n.get(lowerCase).put(str.toLowerCase(Locale.US), str2.trim());
        }
    }

    private static Bitmap d(Context context) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (r == null) {
            bitmap = null;
        } else {
            bitmap2 = r.get();
            if (bitmap2 == null) {
                bitmap = bitmap2;
            }
            return bitmap2;
        }
        Drawable drawable = context.getResources().getDrawable(R.drawable.transition_t_effect);
        bitmap2 = (drawable == null || !(drawable instanceof BitmapDrawable)) ? bitmap : ((BitmapDrawable) drawable).getBitmap();
        if (bitmap2 == null) {
            bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.transition_t_effect);
        }
        r = new WeakReference<>(bitmap2);
        return bitmap2;
    }

    public Bitmap c(Context context) {
        if ((this.k == null || this.k.trim().length() < 1) && context != null) {
            if (!b()) {
                return null;
            }
            if (this instanceof at) {
                return d(context);
            }
            for (Theme theme : EffectLibrary.a(context).c()) {
                for (String str : theme.d()) {
                    if (str.equals(this.f3445a)) {
                        return theme.m();
                    }
                }
            }
        }
        try {
            InputStream a2 = k().a(this.k);
            Bitmap decodeStream = BitmapFactory.decodeStream(a2);
            decodeStream.setDensity(320);
            try {
                a2.close();
                return decodeStream;
            } catch (IOException e) {
                e.printStackTrace();
                return decodeStream;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String f() {
        return this.l;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected KMTServerIndex.Item g() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected URI h() {
        return null;
    }

    public void i() {
    }
}
