package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a */
    private static final Pattern f28758a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f28759b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f28760c;

    /* renamed from: d */
    private final String f28761d;

    /* renamed from: e */
    private final String f28762e;

    /* renamed from: f */
    @Nullable
    private final String f28763f;

    private C(String str, String str2, String str3, @Nullable String str4) {
        this.f28760c = str;
        this.f28761d = str2;
        this.f28762e = str3;
        this.f28763f = str4;
    }

    public static C a(String str) {
        Matcher matcher = f28758a.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f28759b.matcher(str);
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 != null) {
                            if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                                group2 = group2.substring(1, group2.length() - 1);
                            }
                        } else {
                            group2 = matcher2.group(3);
                        }
                        if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                        }
                        str2 = group2;
                    }
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
                }
            }
            return new C(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    @Nullable
    public static C b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String c() {
        return this.f28761d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C) && ((C) obj).f28760c.equals(this.f28760c);
    }

    public int hashCode() {
        return this.f28760c.hashCode();
    }

    public String toString() {
        return this.f28760c;
    }

    public String b() {
        return this.f28762e;
    }

    @Nullable
    public Charset a() {
        return a((Charset) null);
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        try {
            return this.f28763f != null ? Charset.forName(this.f28763f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
