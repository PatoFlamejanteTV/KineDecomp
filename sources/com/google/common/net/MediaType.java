package com.google.common.net;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
/* loaded from: classes2.dex */
public final class MediaType {
    private final String Ya;
    private final String Za;
    private final ImmutableListMultimap<String, String> _a;

    @LazyInit
    private String ab;

    @LazyInit
    private int bb;

    /* renamed from: a */
    private static final ImmutableListMultimap<String, String> f16021a = ImmutableListMultimap.of("charset", Ascii.a(Charsets.f15078c.name()));

    /* renamed from: b */
    private static final CharMatcher f16022b = CharMatcher.b().a(CharMatcher.g().l()).a(CharMatcher.c(' ')).a(CharMatcher.e("()<>@,;:\\\"/[]?="));

    /* renamed from: c */
    private static final CharMatcher f16023c = CharMatcher.b().a(CharMatcher.e("\"\\\r"));

    /* renamed from: d */
    private static final CharMatcher f16024d = CharMatcher.a(" \t\r\n");

    /* renamed from: e */
    private static final Map<MediaType, MediaType> f16025e = Maps.c();

    /* renamed from: f */
    public static final MediaType f16026f = a("*", "*");

    /* renamed from: g */
    public static final MediaType f16027g = a("text", "*");

    /* renamed from: h */
    public static final MediaType f16028h = a(MessengerShareContentUtility.MEDIA_IMAGE, "*");
    public static final MediaType i = a("audio", "*");
    public static final MediaType j = a("video", "*");
    public static final MediaType k = a("application", "*");
    public static final MediaType l = b("text", "cache-manifest");
    public static final MediaType m = b("text", "css");
    public static final MediaType n = b("text", "csv");
    public static final MediaType o = b("text", "html");
    public static final MediaType p = b("text", "calendar");
    public static final MediaType q = b("text", "plain");
    public static final MediaType r = b("text", "javascript");
    public static final MediaType s = b("text", "tab-separated-values");
    public static final MediaType t = b("text", "vcard");
    public static final MediaType u = b("text", "vnd.wap.wml");
    public static final MediaType v = b("text", "xml");
    public static final MediaType w = b("text", "vtt");
    public static final MediaType x = a(MessengerShareContentUtility.MEDIA_IMAGE, "bmp");
    public static final MediaType y = a(MessengerShareContentUtility.MEDIA_IMAGE, "x-canon-crw");
    public static final MediaType z = a(MessengerShareContentUtility.MEDIA_IMAGE, "gif");
    public static final MediaType A = a(MessengerShareContentUtility.MEDIA_IMAGE, "vnd.microsoft.icon");
    public static final MediaType B = a(MessengerShareContentUtility.MEDIA_IMAGE, "jpeg");
    public static final MediaType C = a(MessengerShareContentUtility.MEDIA_IMAGE, "png");
    public static final MediaType D = a(MessengerShareContentUtility.MEDIA_IMAGE, "vnd.adobe.photoshop");
    public static final MediaType E = b(MessengerShareContentUtility.MEDIA_IMAGE, "svg+xml");
    public static final MediaType F = a(MessengerShareContentUtility.MEDIA_IMAGE, "tiff");
    public static final MediaType G = a(MessengerShareContentUtility.MEDIA_IMAGE, "webp");
    public static final MediaType H = a("audio", "mp4");
    public static final MediaType I = a("audio", "mpeg");
    public static final MediaType J = a("audio", "ogg");
    public static final MediaType K = a("audio", "webm");
    public static final MediaType L = a("audio", "l24");
    public static final MediaType M = a("audio", "basic");
    public static final MediaType N = a("audio", "aac");
    public static final MediaType O = a("audio", "vorbis");
    public static final MediaType P = a("audio", "x-ms-wma");
    public static final MediaType Q = a("audio", "x-ms-wax");
    public static final MediaType R = a("audio", "vnd.rn-realaudio");
    public static final MediaType S = a("audio", "vnd.wave");
    public static final MediaType T = a("video", "mp4");
    public static final MediaType U = a("video", "mpeg");
    public static final MediaType V = a("video", "ogg");
    public static final MediaType W = a("video", "quicktime");
    public static final MediaType X = a("video", "webm");
    public static final MediaType Y = a("video", "x-ms-wmv");
    public static final MediaType Z = a("video", "x-flv");
    public static final MediaType aa = a("video", "3gpp");
    public static final MediaType ba = a("video", "3gpp2");
    public static final MediaType ca = b("application", "xml");
    public static final MediaType da = b("application", "atom+xml");
    public static final MediaType ea = a("application", "x-bzip2");
    public static final MediaType fa = b("application", "dart");
    public static final MediaType ga = a("application", "vnd.apple.pkpass");
    public static final MediaType ha = a("application", "vnd.ms-fontobject");
    public static final MediaType ia = a("application", "epub+zip");
    public static final MediaType ja = a("application", "x-www-form-urlencoded");
    public static final MediaType ka = a("application", "pkcs12");
    public static final MediaType la = a("application", "binary");
    public static final MediaType ma = a("application", "x-gzip");
    public static final MediaType na = b("application", "javascript");
    public static final MediaType oa = b("application", "json");
    public static final MediaType pa = b("application", "manifest+json");
    public static final MediaType qa = a("application", "vnd.google-earth.kml+xml");
    public static final MediaType ra = a("application", "vnd.google-earth.kmz");
    public static final MediaType sa = a("application", "mbox");
    public static final MediaType ta = a("application", "x-apple-aspen-config");
    public static final MediaType ua = a("application", "vnd.ms-excel");
    public static final MediaType va = a("application", "vnd.ms-powerpoint");
    public static final MediaType wa = a("application", "msword");
    public static final MediaType xa = a("application", "x-nacl");
    public static final MediaType ya = a("application", "x-pnacl");
    public static final MediaType za = a("application", "octet-stream");
    public static final MediaType Aa = a("application", "ogg");
    public static final MediaType Ba = a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType Ca = a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType Da = a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType Ea = a("application", "vnd.oasis.opendocument.graphics");
    public static final MediaType Fa = a("application", "vnd.oasis.opendocument.presentation");
    public static final MediaType Ga = a("application", "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType Ha = a("application", "vnd.oasis.opendocument.text");
    public static final MediaType Ia = a("application", "pdf");
    public static final MediaType Ja = a("application", "postscript");
    public static final MediaType Ka = a("application", "protobuf");
    public static final MediaType La = b("application", "rdf+xml");
    public static final MediaType Ma = b("application", "rtf");
    public static final MediaType Na = a("application", "font-sfnt");
    public static final MediaType Oa = a("application", "x-shockwave-flash");
    public static final MediaType Pa = a("application", "vnd.sketchup.skp");
    public static final MediaType Qa = b("application", "soap+xml");
    public static final MediaType Ra = a("application", "x-tar");
    public static final MediaType Sa = a("application", "font-woff");
    public static final MediaType Ta = a("application", "font-woff2");
    public static final MediaType Ua = b("application", "xhtml+xml");
    public static final MediaType Va = b("application", "xrd+xml");
    public static final MediaType Wa = a("application", "zip");
    private static final Joiner.MapJoiner Xa = Joiner.a("; ").c("=");

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.Ya = str;
        this.Za = str2;
        this._a = immutableListMultimap;
    }

    private static MediaType b(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, f16021a);
        a(mediaType);
        return mediaType;
    }

    private Map<String, ImmutableMultiset<String>> c() {
        return Maps.a((Map) this._a.asMap(), (Function) new a(this));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        return this.Ya.equals(mediaType.Ya) && this.Za.equals(mediaType.Za) && c().equals(mediaType.c());
    }

    public int hashCode() {
        int i2 = this.bb;
        if (i2 != 0) {
            return i2;
        }
        int a2 = Objects.a(this.Ya, this.Za, c());
        this.bb = a2;
        return a2;
    }

    public String toString() {
        String str = this.ab;
        if (str != null) {
            return str;
        }
        String b2 = b();
        this.ab = b2;
        return b2;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Ya);
        sb.append('/');
        sb.append(this.Za);
        if (!this._a.isEmpty()) {
            sb.append("; ");
            Xa.a(sb, Multimaps.a((ListMultimap) this._a, (Function) new b(this)).entries());
        }
        return sb.toString();
    }

    private static MediaType a(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, ImmutableListMultimap.of());
        a(mediaType);
        return mediaType;
    }

    private static MediaType a(MediaType mediaType) {
        f16025e.put(mediaType, mediaType);
        return mediaType;
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append('\"');
        return sb.toString();
    }
}
