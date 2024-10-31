package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import b.b.a.h;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FetchStrategy {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        private final FontFileResourceEntry[] f1113a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f1113a = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.f1113a;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {

        /* renamed from: a */
        private final String f1114a;

        /* renamed from: b */
        private int f1115b;

        /* renamed from: c */
        private boolean f1116c;

        /* renamed from: d */
        private int f1117d;

        public FontFileResourceEntry(String str, int i, boolean z, int i2) {
            this.f1114a = str;
            this.f1115b = i;
            this.f1116c = z;
            this.f1117d = i2;
        }

        public String getFileName() {
            return this.f1114a;
        }

        public int getResourceId() {
            return this.f1117d;
        }

        public int getWeight() {
            return this.f1115b;
        }

        public boolean isItalic() {
            return this.f1116c;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* renamed from: a */
        private final FontRequest f1118a;

        /* renamed from: b */
        private final int f1119b;

        /* renamed from: c */
        private final int f1120c;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
            this.f1118a = fontRequest;
            this.f1120c = i;
            this.f1119b = i2;
        }

        public int getFetchStrategy() {
            return this.f1120c;
        }

        public FontRequest getRequest() {
            return this.f1118a;
        }

        public int getTimeout() {
            return this.f1119b;
        }
    }

    private static FamilyResourceEntry a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return b(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), h.FontFamily);
        String string = obtainAttributes.getString(h.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(h.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(h.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(h.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(h.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(h.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(c(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
    }

    private static FontFileResourceEntry c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), h.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(h.FontFamilyFont_fontWeight) ? h.FontFamilyFont_fontWeight : h.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(h.FontFamilyFont_fontStyle) ? h.FontFamilyFont_fontStyle : h.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(h.FontFamilyFont_font) ? h.FontFamilyFont_font : h.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i2, 0);
        String string = obtainAttributes.getString(i2);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new FontFileResourceEntry(string, i, z, resourceId);
    }

    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                arrayList = new ArrayList();
                if (obtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(a(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                } else {
                    arrayList.add(a(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
