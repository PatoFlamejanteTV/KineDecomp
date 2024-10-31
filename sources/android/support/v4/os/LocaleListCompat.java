package android.support.v4.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocaleListCompat {

    /* renamed from: a */
    static final LocaleListInterface f1533a;

    /* renamed from: b */
    private static final LocaleListCompat f1534b = new LocaleListCompat();

    /* loaded from: classes.dex */
    static class LocaleListCompatApi24Impl implements LocaleListInterface {

        /* renamed from: a */
        private LocaleList f1535a = new LocaleList(new Locale[0]);

        LocaleListCompatApi24Impl() {
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean equals(Object obj) {
            return this.f1535a.equals(((LocaleListCompat) obj).unwrap());
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Locale get(int i) {
            return this.f1535a.get(i);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Locale getFirstMatch(String[] strArr) {
            LocaleList localeList = this.f1535a;
            if (localeList != null) {
                return localeList.getFirstMatch(strArr);
            }
            return null;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Object getLocaleList() {
            return this.f1535a;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int hashCode() {
            return this.f1535a.hashCode();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int indexOf(Locale locale) {
            return this.f1535a.indexOf(locale);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean isEmpty() {
            return this.f1535a.isEmpty();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public void setLocaleList(Locale... localeArr) {
            this.f1535a = new LocaleList(localeArr);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int size() {
            return this.f1535a.size();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public String toLanguageTags() {
            return this.f1535a.toLanguageTags();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public String toString() {
            return this.f1535a.toString();
        }
    }

    /* loaded from: classes.dex */
    static class LocaleListCompatBaseImpl implements LocaleListInterface {

        /* renamed from: a */
        private LocaleListHelper f1536a = new LocaleListHelper(new Locale[0]);

        LocaleListCompatBaseImpl() {
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean equals(Object obj) {
            return this.f1536a.equals(((LocaleListCompat) obj).unwrap());
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Locale get(int i) {
            return this.f1536a.a(i);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Locale getFirstMatch(String[] strArr) {
            LocaleListHelper localeListHelper = this.f1536a;
            if (localeListHelper != null) {
                return localeListHelper.a(strArr);
            }
            return null;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public Object getLocaleList() {
            return this.f1536a;
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int hashCode() {
            return this.f1536a.hashCode();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int indexOf(Locale locale) {
            return this.f1536a.a(locale);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public boolean isEmpty() {
            return this.f1536a.a();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public void setLocaleList(Locale... localeArr) {
            this.f1536a = new LocaleListHelper(localeArr);
        }

        @Override // android.support.v4.os.LocaleListInterface
        public int size() {
            return this.f1536a.b();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public String toLanguageTags() {
            return this.f1536a.c();
        }

        @Override // android.support.v4.os.LocaleListInterface
        public String toString() {
            return this.f1536a.toString();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            f1533a = new LocaleListCompatApi24Impl();
        } else {
            f1533a = new LocaleListCompatBaseImpl();
        }
    }

    private LocaleListCompat() {
    }

    private void a(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            f1533a.setLocaleList(localeArr);
        }
    }

    public static LocaleListCompat create(Locale... localeArr) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        localeListCompat.a(localeArr);
        return localeListCompat;
    }

    public static LocaleListCompat forLanguageTags(String str) {
        Locale a2;
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",");
            Locale[] localeArr = new Locale[split.length];
            for (int i = 0; i < localeArr.length; i++) {
                if (Build.VERSION.SDK_INT >= 21) {
                    a2 = Locale.forLanguageTag(split[i]);
                } else {
                    a2 = LocaleHelper.a(split[i]);
                }
                localeArr[i] = a2;
            }
            LocaleListCompat localeListCompat = new LocaleListCompat();
            localeListCompat.a(localeArr);
            return localeListCompat;
        }
        return getEmptyLocaleList();
    }

    public static LocaleListCompat getAdjustedDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getAdjustedDefault()) : create(Locale.getDefault());
    }

    public static LocaleListCompat getDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getDefault()) : create(Locale.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return f1534b;
    }

    public static LocaleListCompat wrap(Object obj) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        if (obj instanceof LocaleList) {
            localeListCompat.a((LocaleList) obj);
        }
        return localeListCompat;
    }

    public boolean equals(Object obj) {
        return f1533a.equals(obj);
    }

    public Locale get(int i) {
        return f1533a.get(i);
    }

    public Locale getFirstMatch(String[] strArr) {
        return f1533a.getFirstMatch(strArr);
    }

    public int hashCode() {
        return f1533a.hashCode();
    }

    public int indexOf(Locale locale) {
        return f1533a.indexOf(locale);
    }

    public boolean isEmpty() {
        return f1533a.isEmpty();
    }

    public int size() {
        return f1533a.size();
    }

    public String toLanguageTags() {
        return f1533a.toLanguageTags();
    }

    public String toString() {
        return f1533a.toString();
    }

    public Object unwrap() {
        return f1533a.getLocaleList();
    }

    private void a(Locale... localeArr) {
        f1533a.setLocaleList(localeArr);
    }
}
