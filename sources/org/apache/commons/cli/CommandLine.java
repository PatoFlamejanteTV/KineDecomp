package org.apache.commons.cli;

import com.facebook.internal.ServerProtocol;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/* loaded from: classes3.dex */
public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;
    private List args = new LinkedList();
    private List options = new ArrayList();

    private Option a(String str) {
        String b2 = h.b(str);
        for (Option option : this.options) {
            if (b2.equals(option.getOpt()) || b2.equals(option.getLongOpt())) {
                return option;
            }
        }
        return null;
    }

    public void addArg(String str) {
        this.args.add(str);
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    public List getArgList() {
        return this.args;
    }

    public String[] getArgs() {
        String[] strArr = new String[this.args.size()];
        this.args.toArray(strArr);
        return strArr;
    }

    public Object getOptionObject(String str) {
        try {
            return getParsedOptionValue(str);
        } catch (ParseException e2) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception found converting ");
            stringBuffer.append(str);
            stringBuffer.append(" to desired type: ");
            stringBuffer.append(e2.getMessage());
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    public Properties getOptionProperties(String str) {
        Properties properties = new Properties();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                List valuesList = option.getValuesList();
                if (valuesList.size() >= 2) {
                    properties.put(valuesList.get(0), valuesList.get(1));
                } else if (valuesList.size() == 1) {
                    properties.put(valuesList.get(0), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
        return properties;
    }

    public String getOptionValue(String str) {
        String[] optionValues = getOptionValues(str);
        if (optionValues == null) {
            return null;
        }
        return optionValues[0];
    }

    public String[] getOptionValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                arrayList.addAll(option.getValuesList());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Option[] getOptions() {
        List list = this.options;
        return (Option[]) list.toArray(new Option[list.size()]);
    }

    public Object getParsedOptionValue(String str) throws ParseException {
        String optionValue = getOptionValue(str);
        Option a2 = a(str);
        if (a2 == null) {
            return null;
        }
        Object type = a2.getType();
        if (optionValue == null) {
            return null;
        }
        return g.a(optionValue, type);
    }

    public boolean hasOption(String str) {
        return this.options.contains(a(str));
    }

    public Iterator iterator() {
        return this.options.iterator();
    }

    public boolean hasOption(char c2) {
        return hasOption(String.valueOf(c2));
    }

    public Object getOptionObject(char c2) {
        return getOptionObject(String.valueOf(c2));
    }

    public String getOptionValue(char c2) {
        return getOptionValue(String.valueOf(c2));
    }

    public String getOptionValue(String str, String str2) {
        String optionValue = getOptionValue(str);
        return optionValue != null ? optionValue : str2;
    }

    public String getOptionValue(char c2, String str) {
        return getOptionValue(String.valueOf(c2), str);
    }

    public String[] getOptionValues(char c2) {
        return getOptionValues(String.valueOf(c2));
    }
}
