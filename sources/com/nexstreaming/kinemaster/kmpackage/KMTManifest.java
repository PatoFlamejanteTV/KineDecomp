package com.nexstreaming.kinemaster.kmpackage;

import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class KMTManifest {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f3424a;
    private final Map<String, a> b;
    private final Map<String, a> c;
    private final Set<String> d;
    private final Set<String> e;
    private final String f;
    private final String g;

    /* loaded from: classes.dex */
    private enum ManifestSection {
        GENERAL,
        INTERNAL_DEPENDENCIES,
        EXTERNAL_DEPENDENCIES,
        OPT_EXTERNAL_DEPENDENCIES,
        PUBLISHED_EFFECTS
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3426a;
        public final String b;

        public a(String str, String str2) {
            this.f3426a = str;
            this.b = str2;
        }
    }

    public KMTManifest(InputStream inputStream) throws BadPackageException, IOException {
        String str;
        ManifestSection manifestSection;
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            } else {
                sb.append(new String(bArr, 0, read, Keyczar.DEFAULT_ENCODING));
            }
        }
        this.g = sb.toString();
        Scanner scanner = new Scanner(this.g);
        int i = 0;
        ManifestSection manifestSection2 = ManifestSection.GENERAL;
        Pattern compile = Pattern.compile("=", 16);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        String str2 = null;
        while (scanner.hasNextLine()) {
            int i2 = i + 1;
            String trim = scanner.nextLine().trim();
            if (i2 == 1) {
                if (!trim.startsWith("KineMaster Manifest/")) {
                    throw new BadPackageException();
                }
                try {
                    int parseInt = Integer.parseInt(trim.split("/")[1]);
                    if (parseInt != 100 && parseInt != 101) {
                        throw new BadPackageException("Unsupported KineMaster package manifest version (" + parseInt + ")");
                    }
                    str = str2;
                    manifestSection = manifestSection2;
                } catch (NumberFormatException e) {
                    throw new BadPackageException(e);
                }
            } else if (trim.startsWith("[") && trim.endsWith("]")) {
                String str3 = str2;
                manifestSection = (ManifestSection) an.a(trim.substring(1, trim.length() - 1), ManifestSection.values());
                str = str3;
            } else {
                if (trim.indexOf(61) > -1) {
                    String[] split = compile.split(trim);
                    if (split.length > 1) {
                        String trim2 = split[0].trim();
                        str = split[1].trim();
                        String trim3 = split.length > 2 ? split[2].trim() : null;
                        switch (manifestSection2) {
                            case EXTERNAL_DEPENDENCIES:
                                hashMap2.put(trim2, new a(str, trim3));
                                str = str2;
                                manifestSection = manifestSection2;
                                continue;
                            case OPT_EXTERNAL_DEPENDENCIES:
                                hashMap3.put(trim2, new a(str, trim3));
                                str = str2;
                                manifestSection = manifestSection2;
                                continue;
                            case INTERNAL_DEPENDENCIES:
                                hashMap.put("res/" + trim2, new a(str, trim3));
                                hashSet.add(trim2);
                                str = str2;
                                manifestSection = manifestSection2;
                                continue;
                            case PUBLISHED_EFFECTS:
                                hashMap.put(trim2 + ".xml", new a(str, trim3 == null ? "e" : trim3));
                                hashSet2.add(trim2);
                                str = str2;
                                manifestSection = manifestSection2;
                                continue;
                            case GENERAL:
                                if (trim2.equalsIgnoreCase(f())) {
                                    hashMap.put(trim2, new a(str, trim3));
                                    manifestSection = manifestSection2;
                                    break;
                                }
                                break;
                        }
                    }
                }
                str = str2;
                manifestSection = manifestSection2;
            }
            manifestSection2 = manifestSection;
            str2 = str;
            i = i2;
        }
        scanner.close();
        this.f3424a = Collections.unmodifiableMap(hashMap);
        this.b = Collections.unmodifiableMap(hashMap2);
        this.c = Collections.unmodifiableMap(hashMap3);
        this.d = Collections.unmodifiableSet(hashSet);
        this.e = Collections.unmodifiableSet(hashSet2);
        this.f = str2;
    }

    public Map<String, a> a() {
        return this.f3424a;
    }

    public Map<String, a> b() {
        return this.b;
    }

    public Map<String, a> c() {
        return this.c;
    }

    public Set<String> d() {
        return this.d;
    }

    public Set<String> e() {
        return this.e;
    }

    public String f() {
        return "summary.json";
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.g;
    }
}
