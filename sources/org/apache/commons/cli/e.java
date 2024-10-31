package org.apache.commons.cli;

import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/* compiled from: Parser.java */
/* loaded from: classes3.dex */
public abstract class e implements a {

    /* renamed from: a */
    protected CommandLine f29289a;

    /* renamed from: b */
    private Options f29290b;

    /* renamed from: c */
    private List f29291c;

    protected void a(Options options) {
        this.f29290b = options;
        this.f29291c = new ArrayList(options.getRequiredOptions());
    }

    protected Options b() {
        return this.f29290b;
    }

    protected abstract String[] b(Options options, String[] strArr, boolean z);

    protected List c() {
        return this.f29291c;
    }

    @Override // org.apache.commons.cli.a
    public CommandLine a(Options options, String[] strArr, boolean z) throws ParseException {
        return a(options, strArr, null, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:            if (r9 != false) goto L62;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.cli.CommandLine a(org.apache.commons.cli.Options r6, java.lang.String[] r7, java.util.Properties r8, boolean r9) throws org.apache.commons.cli.ParseException {
        /*
            r5 = this;
            java.util.List r0 = r6.helpOptions()
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L18
            java.lang.Object r1 = r0.next()
            org.apache.commons.cli.Option r1 = (org.apache.commons.cli.Option) r1
            r1.clearValues()
            goto L8
        L18:
            r5.a(r6)
            org.apache.commons.cli.CommandLine r6 = new org.apache.commons.cli.CommandLine
            r6.<init>()
            r5.f29289a = r6
            r6 = 0
            if (r7 != 0) goto L27
            java.lang.String[] r7 = new java.lang.String[r6]
        L27:
            org.apache.commons.cli.Options r0 = r5.b()
            java.lang.String[] r7 = r5.b(r0, r7, r9)
            java.util.List r7 = java.util.Arrays.asList(r7)
            java.util.ListIterator r7 = r7.listIterator()
        L37:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L9d
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "--"
            boolean r2 = r1.equals(r0)
            r3 = 1
            if (r2 == 0) goto L4e
        L4c:
            r6 = 1
            goto L83
        L4e:
            java.lang.String r2 = "-"
            boolean r4 = r2.equals(r0)
            if (r4 == 0) goto L5f
            if (r9 == 0) goto L59
            goto L4c
        L59:
            org.apache.commons.cli.CommandLine r2 = r5.f29289a
            r2.addArg(r0)
            goto L83
        L5f:
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L7b
            if (r9 == 0) goto L77
            org.apache.commons.cli.Options r2 = r5.b()
            boolean r2 = r2.hasOption(r0)
            if (r2 != 0) goto L77
            org.apache.commons.cli.CommandLine r6 = r5.f29289a
            r6.addArg(r0)
            goto L4c
        L77:
            r5.a(r0, r7)
            goto L83
        L7b:
            org.apache.commons.cli.CommandLine r2 = r5.f29289a
            r2.addArg(r0)
            if (r9 == 0) goto L83
            goto L4c
        L83:
            if (r6 == 0) goto L37
        L85:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L37
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r1.equals(r0)
            if (r2 != 0) goto L85
            org.apache.commons.cli.CommandLine r2 = r5.f29289a
            r2.addArg(r0)
            goto L85
        L9d:
            r5.a(r8)
            r5.a()
            org.apache.commons.cli.CommandLine r6 = r5.f29289a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.e.a(org.apache.commons.cli.Options, java.lang.String[], java.util.Properties, boolean):org.apache.commons.cli.CommandLine");
    }

    protected void a(Properties properties) {
        if (properties == null) {
            return;
        }
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String obj = propertyNames.nextElement().toString();
            if (!this.f29289a.hasOption(obj)) {
                Option option = b().getOption(obj);
                String property = properties.getProperty(obj);
                if (option.hasArg()) {
                    if (option.getValues() == null || option.getValues().length == 0) {
                        try {
                            option.addValueForProcessing(property);
                        } catch (RuntimeException unused) {
                        }
                    }
                } else if (!"yes".equalsIgnoreCase(property) && !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(property) && !"1".equalsIgnoreCase(property)) {
                    return;
                }
                this.f29289a.addOption(option);
            }
        }
    }

    protected void a() throws MissingOptionException {
        if (!c().isEmpty()) {
            throw new MissingOptionException(c());
        }
    }

    public void a(Option option, ListIterator listIterator) throws ParseException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String str = (String) listIterator.next();
            if (b().hasOption(str) && str.startsWith("-")) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.addValueForProcessing(h.a(str));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.getValues() == null && !option.hasOptionalArg()) {
            throw new MissingArgumentException(option);
        }
    }

    protected void a(String str, ListIterator listIterator) throws ParseException {
        if (b().hasOption(str)) {
            Option option = (Option) b().getOption(str).clone();
            if (option.isRequired()) {
                c().remove(option.getKey());
            }
            if (b().getOptionGroup(option) != null) {
                OptionGroup optionGroup = b().getOptionGroup(option);
                if (optionGroup.isRequired()) {
                    c().remove(optionGroup);
                }
                optionGroup.setSelected(option);
            }
            if (option.hasArg()) {
                a(option, listIterator);
            }
            this.f29289a.addOption(option);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized option: ");
        stringBuffer.append(str);
        throw new UnrecognizedOptionException(stringBuffer.toString(), str);
    }
}
