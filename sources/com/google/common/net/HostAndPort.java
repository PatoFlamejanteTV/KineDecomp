package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;

@Beta
@Immutable
/* loaded from: classes2.dex */
public final class HostAndPort implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2922a = Pattern.compile("^\\[(.*:.*)\\](?::(\\d*))?$");
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i, boolean z) {
        this.host = str;
        this.port = i;
        this.hasBracketlessColons = z;
    }

    public String getHostText() {
        return this.host;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int getPort() {
        Preconditions.b(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i) {
        return hasPort() ? this.port : i;
    }

    public static HostAndPort fromParts(String str, int i) {
        Preconditions.a(a(i));
        HostAndPort fromString = fromString(str);
        Preconditions.a(!fromString.hasPort());
        return new HostAndPort(fromString.host, i, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        boolean z;
        int i;
        Preconditions.a(str);
        if (str.startsWith("[")) {
            Matcher matcher = f2922a.matcher(str);
            Preconditions.a(matcher.matches(), "Invalid bracketed host/port: %s", str);
            String group = matcher.group(1);
            str2 = matcher.group(2);
            str3 = group;
            z = false;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf < 0 || str.indexOf(58, indexOf + 1) != -1) {
                str2 = null;
                str3 = str;
                z = indexOf >= 0;
            } else {
                String substring = str.substring(0, indexOf);
                str2 = str.substring(indexOf + 1);
                str3 = substring;
                z = false;
            }
        }
        if (str2 != null) {
            Preconditions.a(!str2.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i = Integer.parseInt(str2);
                Preconditions.a(a(i), "Port number out of range: %s", str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        } else {
            i = -1;
        }
        return new HostAndPort(str3, i, z);
    }

    public HostAndPort withDefaultPort(int i) {
        Preconditions.a(a(i));
        return (hasPort() || this.port == i) ? this : new HostAndPort(this.host, i, this.hasBracketlessColons);
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.a(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return Objects.a(this.host, hostAndPort.host) && this.port == hostAndPort.port && this.hasBracketlessColons == hostAndPort.hasBracketlessColons;
    }

    public int hashCode() {
        return Objects.a(this.host, Integer.valueOf(this.port), Boolean.valueOf(this.hasBracketlessColons));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 7);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[').append(this.host).append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(':').append(this.port);
        }
        return sb.toString();
    }

    private static boolean a(int i) {
        return i >= 0 && i <= 65535;
    }
}
