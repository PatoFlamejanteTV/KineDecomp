package com.google.common.net;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
/* loaded from: classes2.dex */
public final class MediaType {
    private final String aq;
    private final String ar;
    private final ImmutableListMultimap<String, String> as;
    private static final ImmutableListMultimap<String, String> al = ImmutableListMultimap.of("charset", Ascii.a(Charsets.c.name()));
    private static final CharMatcher am = CharMatcher.b.a(CharMatcher.i.a()).a(CharMatcher.b(' ')).a(CharMatcher.b("()<>@,;:\\\"/[]?="));
    private static final CharMatcher an = CharMatcher.b.a(CharMatcher.b("\"\\\r"));
    private static final CharMatcher ao = CharMatcher.a((CharSequence) " \t\r\n");

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f2926a = a("*", "*");
    public static final MediaType b = a("text", "*");
    public static final MediaType c = a("image", "*");
    public static final MediaType d = a("audio", "*");
    public static final MediaType e = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "*");
    public static final MediaType f = a("application", "*");
    public static final MediaType g = b("text", "cache-manifest");
    public static final MediaType h = b("text", "css");
    public static final MediaType i = b("text", "csv");
    public static final MediaType j = b("text", "html");
    public static final MediaType k = b("text", "calendar");
    public static final MediaType l = b("text", "plain");
    public static final MediaType m = b("text", "javascript");
    public static final MediaType n = b("text", "vcard");
    public static final MediaType o = b("text", "vnd.wap.wml");
    public static final MediaType p = b("text", "xml");
    public static final MediaType q = a("image", "bmp");
    public static final MediaType r = a("image", "gif");
    public static final MediaType s = a("image", "vnd.microsoft.icon");
    public static final MediaType t = a("image", "jpeg");
    public static final MediaType u = a("image", "png");
    public static final MediaType v = b("image", "svg+xml");
    public static final MediaType w = a("image", "tiff");
    public static final MediaType x = a("image", "webp");
    public static final MediaType y = a("audio", "mp4");
    public static final MediaType z = a("audio", "mpeg");
    public static final MediaType A = a("audio", "ogg");
    public static final MediaType B = a("audio", "webm");
    public static final MediaType C = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "mp4");
    public static final MediaType D = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "mpeg");
    public static final MediaType E = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "ogg");
    public static final MediaType F = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "quicktime");
    public static final MediaType G = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "webm");
    public static final MediaType H = a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "x-ms-wmv");
    public static final MediaType I = b("application", "atom+xml");
    public static final MediaType J = a("application", "x-bzip2");
    public static final MediaType K = a("application", "x-www-form-urlencoded");
    public static final MediaType L = a("application", "x-gzip");
    public static final MediaType M = b("application", "javascript");
    public static final MediaType N = b("application", "json");
    public static final MediaType O = a("application", "vnd.google-earth.kml+xml");
    public static final MediaType P = a("application", "vnd.google-earth.kmz");
    public static final MediaType Q = a("application", "mbox");
    public static final MediaType R = a("application", "vnd.ms-excel");
    public static final MediaType S = a("application", "vnd.ms-powerpoint");
    public static final MediaType T = a("application", "msword");
    public static final MediaType U = a("application", "octet-stream");
    public static final MediaType V = a("application", "ogg");
    public static final MediaType W = a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType X = a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType Y = a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType Z = a("application", "vnd.oasis.opendocument.graphics");
    public static final MediaType aa = a("application", "vnd.oasis.opendocument.presentation");
    public static final MediaType ab = a("application", "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType ac = a("application", "vnd.oasis.opendocument.text");
    public static final MediaType ad = a("application", "pdf");
    public static final MediaType ae = a("application", "postscript");
    public static final MediaType af = b("application", "rtf");
    public static final MediaType ag = a("application", "x-shockwave-flash");
    public static final MediaType ah = a("application", "vnd.sketchup.skp");
    public static final MediaType ai = a("application", "x-tar");
    public static final MediaType aj = b("application", "xhtml+xml");
    public static final MediaType ak = a("application", "zip");
    private static final ImmutableMap<MediaType, MediaType> ap = new ImmutableMap.Builder().b(f2926a, f2926a).b(b, b).b(c, c).b(d, d).b(e, e).b(f, f).b(g, g).b(h, h).b(i, i).b(j, j).b(k, k).b(l, l).b(m, m).b(n, n).b(o, o).b(p, p).b(q, q).b(r, r).b(s, s).b(t, t).b(u, u).b(v, v).b(w, w).b(x, x).b(y, y).b(z, z).b(A, A).b(B, B).b(C, C).b(D, D).b(E, E).b(F, F).b(G, G).b(H, H).b(I, I).b(J, J).b(K, K).b(L, L).b(M, M).b(N, N).b(O, O).b(P, P).b(Q, Q).b(R, R).b(S, S).b(T, T).b(U, U).b(V, V).b(W, W).b(X, X).b(Y, Y).b(Z, Z).b(aa, aa).b(ab, ab).b(ac, ac).b(ad, ad).b(ae, ae).b(af, af).b(ag, ag).b(ah, ah).b(ai, ai).b(aj, aj).b(ak, ak).b();
    private static final Joiner.MapJoiner at = Joiner.a("; ").c("=");

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.aq = str;
        this.ar = str2;
        this.as = immutableListMultimap;
    }

    private static MediaType a(String str, String str2) {
        return new MediaType(str, str2, ImmutableListMultimap.of());
    }

    private static MediaType b(String str, String str2) {
        return new MediaType(str, str2, al);
    }

    private Map<String, ImmutableMultiset<String>> b() {
        return Maps.a((Map) this.as.asMap(), (Function) new a(this));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        return this.aq.equals(mediaType.aq) && this.ar.equals(mediaType.ar) && b().equals(mediaType.b());
    }

    public int hashCode() {
        return Objects.a(this.aq, this.ar, b());
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(this.aq).append('/').append(this.ar);
        if (!this.as.isEmpty()) {
            append.append("; ");
            at.a(append, Multimaps.a(this.as, new b(this)).entries());
        }
        return append.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        StringBuilder append = new StringBuilder(str.length() + 16).append('\"');
        for (char c2 : str.toCharArray()) {
            if (c2 == '\r' || c2 == '\\' || c2 == '\"') {
                append.append('\\');
            }
            append.append(c2);
        }
        return append.append('\"').toString();
    }
}
