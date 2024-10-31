package android.support.v4.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    /* renamed from: a */
    private final String f1024a;

    /* renamed from: b */
    private final CharSequence f1025b;

    /* renamed from: c */
    private final CharSequence[] f1026c;

    /* renamed from: d */
    private final boolean f1027d;

    /* renamed from: e */
    private final Bundle f1028e;

    /* renamed from: f */
    private final Set<String> f1029f;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private final String f1030a;

        /* renamed from: b */
        private CharSequence f1031b;

        /* renamed from: c */
        private CharSequence[] f1032c;

        /* renamed from: d */
        private boolean f1033d = true;

        /* renamed from: e */
        private Bundle f1034e = new Bundle();

        /* renamed from: f */
        private final Set<String> f1035f = new HashSet();

        public Builder(String str) {
            if (str != null) {
                this.f1030a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.f1034e.putAll(bundle);
            }
            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.f1030a, this.f1031b, this.f1032c, this.f1033d, this.f1034e, this.f1035f);
        }

        public Bundle getExtras() {
            return this.f1034e;
        }

        public Builder setAllowDataType(String str, boolean z) {
            if (z) {
                this.f1035f.add(str);
            } else {
                this.f1035f.remove(str);
            }
            return this;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.f1033d = z;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.f1032c = charSequenceArr;
            return this;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.f1031b = charSequence;
            return this;
        }
    }

    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.f1024a = str;
        this.f1025b = charSequence;
        this.f1026c = charSequenceArr;
        this.f1027d = z;
        this.f1028e = bundle;
        this.f1029f = set;
    }

    private static String a(String str) {
        return "android.remoteinput.dataTypeResultsData" + str;
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            android.app.RemoteInput.addDataResultToIntent(a(remoteInput), intent, map);
            return;
        }
        if (i >= 16) {
            Intent a2 = a(intent);
            if (a2 == null) {
                a2 = new Intent();
            }
            for (Map.Entry<String, Uri> entry : map.entrySet()) {
                String key = entry.getKey();
                Uri value = entry.getValue();
                if (key != null) {
                    Bundle bundleExtra = a2.getBundleExtra(a(key));
                    if (bundleExtra == null) {
                        bundleExtra = new Bundle();
                    }
                    bundleExtra.putString(remoteInput.getResultKey(), value.toString());
                    a2.putExtra(a(key), bundleExtra);
                }
            }
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, a2));
            return;
        }
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            android.app.RemoteInput.addResultsToIntent(a(remoteInputArr), intent, bundle);
            return;
        }
        if (i >= 20) {
            Bundle resultsFromIntent = getResultsFromIntent(intent);
            if (resultsFromIntent != null) {
                resultsFromIntent.putAll(bundle);
                bundle = resultsFromIntent;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
                android.app.RemoteInput.addResultsToIntent(a(new RemoteInput[]{remoteInput}), intent, bundle);
                if (dataResultsFromIntent != null) {
                    addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
                }
            }
            return;
        }
        if (i >= 16) {
            Intent a2 = a(intent);
            if (a2 == null) {
                a2 = new Intent();
            }
            Bundle bundleExtra = a2.getBundleExtra(EXTRA_RESULTS_DATA);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            for (RemoteInput remoteInput2 : remoteInputArr) {
                Object obj = bundle.get(remoteInput2.getResultKey());
                if (obj instanceof CharSequence) {
                    bundleExtra.putCharSequence(remoteInput2.getResultKey(), (CharSequence) obj);
                }
            }
            a2.putExtra(EXTRA_RESULTS_DATA, bundleExtra);
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, a2));
            return;
        }
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        String string;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }
        if (i >= 16) {
            Intent a2 = a(intent);
            if (a2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str2 : a2.getExtras().keySet()) {
                if (str2.startsWith("android.remoteinput.dataTypeResultsData")) {
                    String substring = str2.substring(39);
                    if (!substring.isEmpty() && (string = a2.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                        hashMap.put(substring, Uri.parse(string));
                    }
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            }
            return hashMap;
        }
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return null;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
        if (i >= 16) {
            Intent a2 = a(intent);
            if (a2 == null) {
                return null;
            }
            return (Bundle) a2.getExtras().getParcelable(EXTRA_RESULTS_DATA);
        }
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return null;
    }

    public boolean getAllowFreeFormInput() {
        return this.f1027d;
    }

    public Set<String> getAllowedDataTypes() {
        return this.f1029f;
    }

    public CharSequence[] getChoices() {
        return this.f1026c;
    }

    public Bundle getExtras() {
        return this.f1028e;
    }

    public CharSequence getLabel() {
        return this.f1025b;
    }

    public String getResultKey() {
        return this.f1024a;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }

    public static android.app.RemoteInput[] a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    static android.app.RemoteInput a(RemoteInput remoteInput) {
        return new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
    }

    private static Intent a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }
}
