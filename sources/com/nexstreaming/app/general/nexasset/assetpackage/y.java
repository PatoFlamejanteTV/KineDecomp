package com.nexstreaming.app.general.nexasset.assetpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.util.LruCache;
import android.util.Xml;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.larvalabs.svgandroid.SVGParseException;
import com.larvalabs.svgandroid.SVGParser;
import com.nexstreaming.app.general.nexasset.assetpackage.s;
import com.nexstreaming.app.general.util.B;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.app.general.util.C1703g;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: XMLItemDefReader.java */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static u f19559a = new v();

    /* renamed from: b, reason: collision with root package name */
    private static LruCache<String, u> f19560b = new LruCache<>(100);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XMLItemDefReader.java */
    /* loaded from: classes2.dex */
    public static class a implements s {

        /* renamed from: a, reason: collision with root package name */
        public ItemParameterType f19561a;

        /* renamed from: b, reason: collision with root package name */
        public String f19562b;

        /* renamed from: c, reason: collision with root package name */
        public String f19563c;

        /* renamed from: d, reason: collision with root package name */
        public String f19564d;

        /* renamed from: e, reason: collision with root package name */
        public String f19565e;

        /* renamed from: f, reason: collision with root package name */
        public int f19566f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19567g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19568h;
        public boolean i;
        public double j;
        public double k;
        public double l;
        public RectF m;
        public Map<String, Map<String, String>> n;
        public List<s.a> o;
        public String p;
        public WidgetType q;
        public String r;
        public String s;
        public String t;
        public String u;

        private a() {
        }

        private String o() {
            switch (x.f19558b[this.f19561a.ordinal()]) {
                case 1:
                    return "selection";
                case 2:
                    return "switch";
                case 3:
                    return MessengerShareContentUtility.MEDIA_IMAGE;
                case 4:
                    return "range";
                case 5:
                    return "rect";
                case 6:
                case 7:
                    return "color";
                case 8:
                    return "text";
                case 9:
                case 10:
                    return "point";
                default:
                    throw new IllegalStateException("Unknown type: " + String.valueOf(this.f19561a));
            }
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public List<s.a> a() {
            return this.o;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public Map<String, Map<String, String>> b() {
            return this.n;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String c() {
            return this.r;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String d() {
            return this.u;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public boolean e() {
            return this.f19567g;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String f() {
            return this.s;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public WidgetType g() {
            WidgetType widgetType = this.q;
            return widgetType == null ? WidgetType.ANY : widgetType;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String getIconPath() {
            return this.p;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String getId() {
            return o() + ":" + this.f19565e;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public ItemParameterType getType() {
            return this.f19561a;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String h() {
            return this.f19563c;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String i() {
            return this.f19562b;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public boolean isHidden() {
            return this.i;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public double j() {
            return this.l;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String k() {
            return this.t;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public double l() {
            return this.k;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public String m() {
            return this.f19564d;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s
        public double n() {
            return this.j;
        }

        /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XMLItemDefReader.java */
    /* loaded from: classes2.dex */
    public static class b implements s.a {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, Map<String, String>> f19569a;

        /* renamed from: b, reason: collision with root package name */
        public String f19570b;

        /* renamed from: c, reason: collision with root package name */
        public String f19571c;

        private b() {
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s.a
        public Map<String, Map<String, String>> b() {
            return this.f19569a;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s.a
        public String getIconPath() {
            return this.f19570b;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.s.a
        public String getValue() {
            return this.f19571c;
        }

        /* synthetic */ b(v vVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XMLItemDefReader.java */
    /* loaded from: classes2.dex */
    public static class c implements u {

        /* renamed from: a, reason: collision with root package name */
        private int f19572a;

        /* renamed from: b, reason: collision with root package name */
        private int f19573b;

        /* renamed from: c, reason: collision with root package name */
        private int f19574c;

        /* renamed from: d, reason: collision with root package name */
        private int f19575d;

        /* renamed from: e, reason: collision with root package name */
        private List<s> f19576e;

        private c() {
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.u
        public List<s> e() {
            return this.f19576e;
        }

        /* synthetic */ c(v vVar) {
            this();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.u
        public int b() {
            return this.f19574c;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.u
        public int c() {
            return this.f19573b;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.u
        public int d() {
            return this.f19572a;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.u
        public int a() {
            return this.f19575d;
        }
    }

    public static u a(Context context, String str) throws XmlPullParserException, IOException {
        if (str == null) {
            return f19559a;
        }
        u uVar = f19560b.get(str);
        if (uVar != null) {
            return uVar;
        }
        r a2 = h.a(context).a(str);
        if (a2 == null) {
            return f19559a;
        }
        int i = 1;
        if (a2.getType() == ItemType.overlay) {
            String b2 = B.b(a2.getFilePath());
            if (!b2.equalsIgnoreCase("jpg") && !b2.equalsIgnoreCase("jpeg") && !b2.equalsIgnoreCase("png") && !b2.equalsIgnoreCase("gif") && !b2.equalsIgnoreCase("webp")) {
                if (b2.equalsIgnoreCase("svg")) {
                    InputStream g2 = AssetPackageReader.a(context, a2.getPackageURI(), a2.getAssetPackage().getAssetId()).g(a2.getFilePath());
                    try {
                        com.larvalabs.svgandroid.b a3 = SVGParser.a(g2);
                        Set<Integer> c2 = a3.c();
                        if (c2 != null && c2.size() >= 1) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(c2);
                            Collections.sort(arrayList, new w());
                            v vVar = null;
                            c cVar = new c(vVar);
                            if (a3.b() != null) {
                                cVar.f19574c = (int) Math.ceil(r4.width());
                                cVar.f19575d = (int) Math.ceil(r4.height());
                            }
                            cVar.f19576e = new ArrayList();
                            Iterator it = arrayList.iterator();
                            boolean z = false;
                            int i2 = 0;
                            int i3 = 0;
                            while (it.hasNext()) {
                                int intValue = ((Integer) it.next()).intValue();
                                if (i2 <= 0 || Math.max(Math.max(Math.abs(Color.red(i3) - Color.red(intValue)), Math.abs(Color.green(i3) - Color.green(intValue))), Math.abs(Color.blue(i3) - Color.blue(intValue))) > 50) {
                                    i2++;
                                    if (i2 > 4) {
                                        return f19559a;
                                    }
                                    a aVar = new a(vVar);
                                    aVar.f19561a = ItemParameterType.RGB;
                                    aVar.f19562b = C1703g.b(intValue);
                                    aVar.f19565e = C1703g.b(intValue).replace("#", "svgcolor_");
                                    aVar.f19568h = z;
                                    aVar.n = new HashMap();
                                    aVar.n.put("label", new HashMap());
                                    if (arrayList.size() > i) {
                                        aVar.n.get("label").put("", context.getResources().getString(R.string.opt_color) + " " + i2);
                                        aVar.n.get("label").put("en", "Color " + i2);
                                        aVar.n.get("label").put(context.getResources().getConfiguration().locale.getLanguage(), context.getResources().getString(R.string.opt_color) + " " + i2);
                                    } else {
                                        aVar.n.get("label").put("", context.getResources().getString(R.string.opt_color));
                                        aVar.n.get("label").put("en", "Color");
                                        aVar.n.get("label").put(context.getResources().getConfiguration().locale.getLanguage(), context.getResources().getString(R.string.opt_color));
                                    }
                                    cVar.f19576e.add(aVar);
                                    i3 = intValue;
                                    i = 1;
                                    vVar = null;
                                    z = false;
                                }
                            }
                            return cVar;
                        }
                        return f19559a;
                    } catch (SVGParseException e2) {
                        Log.e("XMLItemDefReader", "SVG parser error", e2);
                        return f19559a;
                    } finally {
                        C1702f.a(g2);
                    }
                }
            } else {
                return f19559a;
            }
        }
        int i4 = x.f19557a[a2.getType().ordinal()];
        if (i4 != 1 && i4 != 2 && i4 != 3) {
            return f19559a;
        }
        u a4 = a(AssetPackageReader.a(context, a2.getPackageURI(), a2.getAssetPackage().getAssetId()).g(a2.getFilePath()));
        f19560b.put(str, a4);
        return a4;
    }

    private static String b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException("expected start tag; got " + xmlPullParser.getEventType() + " instead; " + xmlPullParser.getPositionDescription());
        }
        int i = 1;
        String str = null;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            } else if (next == 4) {
                if (str == null) {
                    str = xmlPullParser.getText();
                } else {
                    str = str + xmlPullParser.getText();
                }
            }
        }
        return str;
    }

    private static s.a c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "option");
        b bVar = new b(null);
        bVar.f19571c = xmlPullParser.getAttributeValue(null, "value");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("string")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "lang");
                    String b2 = b(xmlPullParser);
                    if (attributeValue != null && attributeValue2 != null && b2 != null) {
                        if (bVar.f19569a == null) {
                            bVar.f19569a = new HashMap();
                        }
                        Map<String, String> map = bVar.f19569a.get(attributeValue);
                        if (map == null) {
                            map = new HashMap<>();
                            bVar.f19569a.put(attributeValue, map);
                        }
                        map.put(attributeValue2, b2);
                    }
                } else if (name.equalsIgnoreCase("icon")) {
                    if (bVar.f19570b == null) {
                        bVar.f19570b = xmlPullParser.getAttributeValue(null, "src");
                    } else {
                        throw new XmlPullParserException("multiple <icon> tags not allowed" + xmlPullParser.getPositionDescription());
                    }
                } else {
                    g(xmlPullParser);
                }
            }
        }
        return bVar;
    }

    private static s d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
        a aVar = new a(null);
        aVar.f19565e = xmlPullParser.getAttributeValue(null, "id");
        aVar.f19562b = xmlPullParser.getAttributeValue(null, "default");
        aVar.f19566f = a(xmlPullParser.getAttributeValue(null, "maxlen"), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        aVar.f19567g = a(xmlPullParser.getAttributeValue(null, "multiline"), false);
        aVar.f19568h = a(xmlPullParser.getAttributeValue(null, "private"), false);
        aVar.j = a(xmlPullParser.getAttributeValue(null, "minvalue"), 0.0d);
        aVar.k = a(xmlPullParser.getAttributeValue(null, "maxvalue"), 100.0d);
        aVar.l = a(xmlPullParser.getAttributeValue(null, "step"), 1.0d);
        aVar.m = a(xmlPullParser.getAttributeValue(null, "bounds"), (RectF) null);
        aVar.r = xmlPullParser.getAttributeValue(null, "format");
        aVar.s = xmlPullParser.getAttributeValue(null, "trackbg");
        aVar.t = xmlPullParser.getAttributeValue(null, "trackleft");
        aVar.u = xmlPullParser.getAttributeValue(null, "trackright");
        aVar.i = a(xmlPullParser.getAttributeValue(null, "hidden"), false);
        String str = aVar.r;
        if (str != null) {
            try {
                J.a(Locale.ENGLISH, str, 0.3f);
                J.a(Locale.ENGLISH, aVar.r, 0.0f);
                J.a(Locale.ENGLISH, aVar.r, -0.3f);
            } catch (IllegalFormatException e2) {
                throw new XmlPullParserException("format error (" + e2.getMessage() + ") " + xmlPullParser.getPositionDescription());
            }
        }
        String attributeValue = xmlPullParser.getAttributeValue(null, "widget");
        if (attributeValue == null) {
            aVar.q = WidgetType.ANY;
        } else if ("slider".equals(attributeValue)) {
            aVar.q = WidgetType.SLIDER;
        } else if ("spinner".equals(attributeValue)) {
            aVar.q = WidgetType.SPINNER;
        } else if ("any".equals(attributeValue)) {
            aVar.q = WidgetType.ANY;
        } else {
            throw new XmlPullParserException("unrecognized widget type " + xmlPullParser.getPositionDescription());
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "type");
        if ("choice".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.CHOICE;
        } else if ("point".equalsIgnoreCase(attributeValue2)) {
            int a2 = a(xmlPullParser.getAttributeValue(null, "dimensions"), 2);
            if (a2 == 2) {
                aVar.f19561a = ItemParameterType.XY;
            } else if (a2 == 3) {
                aVar.f19561a = ItemParameterType.XYZ;
            } else {
                throw new XmlPullParserException("unsupported number of parameter dimensions: " + a2);
            }
        } else if ("color".equalsIgnoreCase(attributeValue2)) {
            if (a(xmlPullParser.getAttributeValue(null, "alpha"), false)) {
                aVar.f19561a = ItemParameterType.RGBA;
            } else {
                aVar.f19561a = ItemParameterType.RGB;
            }
        } else if ("range".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.RANGE;
        } else if ("rect".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.RECT;
        } else if ("text".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.TEXT;
        } else if ("switch".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.SWITCH;
            aVar.f19563c = xmlPullParser.getAttributeValue(null, "off");
            aVar.f19564d = xmlPullParser.getAttributeValue(null, "on");
        } else if (MessengerShareContentUtility.MEDIA_IMAGE.equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.IMAGE;
        } else {
            throw new XmlPullParserException("unrecognized parameter type" + xmlPullParser.getPositionDescription());
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("string")) {
                    if (aVar.n == null) {
                        aVar.n = new HashMap();
                    }
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "name");
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "lang");
                    String b2 = b(xmlPullParser);
                    if (attributeValue3 != null && attributeValue4 != null && b2 != null) {
                        Map<String, String> map = aVar.n.get(attributeValue3);
                        if (map == null) {
                            map = new HashMap<>();
                            aVar.n.put(attributeValue3, map);
                        }
                        map.put(attributeValue4, b2);
                    }
                } else if (name.equalsIgnoreCase("option")) {
                    if (aVar.o == null) {
                        aVar.o = new ArrayList();
                    }
                    aVar.o.add(c(xmlPullParser));
                } else if (name.equalsIgnoreCase("icon")) {
                    if (aVar.p == null) {
                        aVar.p = xmlPullParser.getAttributeValue(null, "src");
                        g(xmlPullParser);
                    } else {
                        throw new XmlPullParserException("multiple <icon> tags not allowed" + xmlPullParser.getPositionDescription());
                    }
                } else {
                    g(xmlPullParser);
                }
            }
        }
        return aVar;
    }

    private static s e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "userfield");
        a aVar = new a(null);
        aVar.f19565e = xmlPullParser.getAttributeValue(null, "id");
        aVar.f19562b = xmlPullParser.getAttributeValue(null, "default");
        aVar.f19566f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        aVar.f19567g = a(xmlPullParser.getAttributeValue(null, "maxlines"), 1) > 1;
        aVar.f19568h = false;
        aVar.j = 0.0d;
        aVar.k = 100.0d;
        aVar.l = 1.0d;
        aVar.m = a(xmlPullParser.getAttributeValue(null, "step"), (RectF) null);
        String attributeValue = xmlPullParser.getAttributeValue(null, "label");
        if (attributeValue != null) {
            aVar.n = new HashMap();
            aVar.n.put("label", new HashMap());
            aVar.n.get("label").put("", attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "type");
        if ("selection".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.CHOICE;
        } else if ("color".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.RGB;
        } else if ("text".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.TEXT;
        } else if ("overlay".equalsIgnoreCase(attributeValue2)) {
            aVar.f19561a = ItemParameterType.IMAGE;
        } else {
            if ("undefined".equalsIgnoreCase(attributeValue2)) {
                g(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("unrecognized parameter type" + xmlPullParser.getPositionDescription());
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("fieldlabel")) {
                    if (aVar.n == null) {
                        aVar.n = new HashMap();
                    }
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "locale");
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "value");
                    g(xmlPullParser);
                    if (attributeValue3 != null && attributeValue4 != null) {
                        Map<String, String> map = aVar.n.get("label");
                        if (map == null) {
                            map = new HashMap<>();
                            aVar.n.put("label", map);
                        }
                        map.put(attributeValue3, attributeValue4);
                    }
                } else if (name.equalsIgnoreCase("option")) {
                    if (aVar.o == null) {
                        aVar.o = new ArrayList();
                    }
                    aVar.o.add(f(xmlPullParser));
                } else if (name.equalsIgnoreCase("icon")) {
                    if (aVar.p == null) {
                        aVar.p = xmlPullParser.getAttributeValue(null, "src");
                    } else {
                        throw new XmlPullParserException("multiple <icon> tags not allowed" + xmlPullParser.getPositionDescription());
                    }
                } else {
                    g(xmlPullParser);
                }
            }
        }
        return aVar;
    }

    private static s.a f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "option");
        b bVar = new b(null);
        bVar.f19571c = xmlPullParser.getAttributeValue(null, "value");
        bVar.f19570b = xmlPullParser.getAttributeValue(null, "icon");
        String attributeValue = xmlPullParser.getAttributeValue(null, "label");
        if (attributeValue != null) {
            bVar.f19569a = new HashMap();
            bVar.f19569a.put("label", new HashMap());
            bVar.f19569a.get("label").put("", attributeValue);
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equalsIgnoreCase("fieldlabel")) {
                    if (bVar.f19569a == null) {
                        bVar.f19569a = new HashMap();
                    }
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "locale");
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "value");
                    g(xmlPullParser);
                    if (attributeValue2 != null && attributeValue3 != null) {
                        Map<String, String> map = bVar.f19569a.get("label");
                        if (map == null) {
                            map = new HashMap<>();
                            bVar.f19569a.put("label", map);
                        }
                        map.put(attributeValue2, attributeValue3);
                    }
                } else {
                    g(xmlPullParser);
                }
            }
        }
        return bVar;
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException("expected start tag; got " + xmlPullParser.getEventType() + " instead; " + xmlPullParser.getPositionDescription());
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static u a(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return a(newPullParser);
        } finally {
            inputStream.close();
        }
    }

    public static u a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        c cVar = new c(null);
        String name = xmlPullParser.getName();
        if (xmlPullParser.getEventType() == 2 && (name.equalsIgnoreCase("effect") || name.equalsIgnoreCase("renderitem") || name.equalsIgnoreCase("overlay"))) {
            if (name.equalsIgnoreCase("effect")) {
                if ("transition".equalsIgnoreCase(xmlPullParser.getAttributeValue(null, "type"))) {
                    cVar.f19572a = a(xmlPullParser.getAttributeValue(null, "effectoffset"), 100);
                    String attributeValue = xmlPullParser.getAttributeValue(null, "effectoverlap");
                    if (attributeValue == null) {
                        attributeValue = xmlPullParser.getAttributeValue(null, "videooverlap");
                    }
                    cVar.f19573b = a(attributeValue, 100);
                }
            } else if (name.equalsIgnoreCase("renderitem")) {
                if ("transition".equalsIgnoreCase(xmlPullParser.getAttributeValue(null, "type"))) {
                    cVar.f19572a = a(xmlPullParser.getAttributeValue(null, "transitionoffset"), 100);
                    cVar.f19573b = a(xmlPullParser.getAttributeValue(null, "transitionoverlap"), 100);
                }
                cVar.f19574c = a(xmlPullParser.getAttributeValue(null, "width"), 0);
                cVar.f19575d = a(xmlPullParser.getAttributeValue(null, "height"), 0);
            }
            cVar.f19576e = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    String name2 = xmlPullParser.getName();
                    if (name2.equalsIgnoreCase(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD)) {
                        cVar.f19576e.add(d(xmlPullParser));
                    } else if (name2.equalsIgnoreCase("userfield")) {
                        s e2 = e(xmlPullParser);
                        if (e2 != null) {
                            cVar.f19576e.add(e2);
                        }
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            return cVar;
        }
        throw new XmlPullParserException("expected <effect>, <overlay> or <renderitem>" + xmlPullParser.getPositionDescription());
    }

    private static int a(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static double a(String str, double d2) {
        if (str == null) {
            return d2;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    private static RectF a(String str, RectF rectF) {
        if (str == null) {
            return rectF;
        }
        try {
            String[] split = str.split(" +");
            return split.length < 4 ? rectF : new RectF(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
        } catch (NumberFormatException unused) {
            return rectF;
        }
    }

    private static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str)) {
            return true;
        }
        if ("false".equalsIgnoreCase(str)) {
            return false;
        }
        return z;
    }
}
