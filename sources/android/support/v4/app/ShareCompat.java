package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.IntentCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* loaded from: classes.dex */
    public static class IntentBuilder {

        /* renamed from: a */
        private Activity f1036a;

        /* renamed from: b */
        private Intent f1037b = new Intent().setAction("android.intent.action.SEND");

        /* renamed from: c */
        private CharSequence f1038c;

        /* renamed from: d */
        private ArrayList<String> f1039d;

        /* renamed from: e */
        private ArrayList<String> f1040e;

        /* renamed from: f */
        private ArrayList<String> f1041f;

        /* renamed from: g */
        private ArrayList<Uri> f1042g;

        private IntentBuilder(Activity activity) {
            this.f1036a = activity;
            this.f1037b.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity.getPackageName());
            this.f1037b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity.getComponentName());
            this.f1037b.addFlags(524288);
        }

        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        Activity a() {
            return this.f1036a;
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.f1041f == null) {
                this.f1041f = new ArrayList<>();
            }
            this.f1041f.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.f1040e == null) {
                this.f1040e = new ArrayList<>();
            }
            this.f1040e.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.f1039d == null) {
                this.f1039d = new ArrayList<>();
            }
            this.f1039d.add(str);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            Uri uri2 = (Uri) this.f1037b.getParcelableExtra("android.intent.extra.STREAM");
            if (this.f1042g == null && uri2 == null) {
                return setStream(uri);
            }
            if (this.f1042g == null) {
                this.f1042g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f1037b.removeExtra("android.intent.extra.STREAM");
                this.f1042g.add(uri2);
            }
            this.f1042g.add(uri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f1038c);
        }

        public Intent getIntent() {
            ArrayList<String> arrayList = this.f1039d;
            if (arrayList != null) {
                a("android.intent.extra.EMAIL", arrayList);
                this.f1039d = null;
            }
            ArrayList<String> arrayList2 = this.f1040e;
            if (arrayList2 != null) {
                a("android.intent.extra.CC", arrayList2);
                this.f1040e = null;
            }
            ArrayList<String> arrayList3 = this.f1041f;
            if (arrayList3 != null) {
                a("android.intent.extra.BCC", arrayList3);
                this.f1041f = null;
            }
            ArrayList<Uri> arrayList4 = this.f1042g;
            boolean z = arrayList4 != null && arrayList4.size() > 1;
            boolean equals = this.f1037b.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (!z && equals) {
                this.f1037b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f1042g;
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    this.f1037b.putExtra("android.intent.extra.STREAM", this.f1042g.get(0));
                } else {
                    this.f1037b.removeExtra("android.intent.extra.STREAM");
                }
                this.f1042g = null;
            }
            if (z && !equals) {
                this.f1037b.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList6 = this.f1042g;
                if (arrayList6 != null && !arrayList6.isEmpty()) {
                    this.f1037b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1042g);
                } else {
                    this.f1037b.removeExtra("android.intent.extra.STREAM");
                }
            }
            return this.f1037b;
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.f1038c = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.f1037b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.f1037b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.f1039d != null) {
                this.f1039d = null;
            }
            this.f1037b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.f1037b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.f1037b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            if (!this.f1037b.getAction().equals("android.intent.action.SEND")) {
                this.f1037b.setAction("android.intent.action.SEND");
            }
            this.f1042g = null;
            this.f1037b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.f1037b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.f1037b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setType(String str) {
            this.f1037b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f1036a.startActivity(createChooserIntent());
        }

        private void a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f1037b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f1037b.putExtra(str, strArr);
        }

        public IntentBuilder setChooserTitle(int i) {
            return setChooserTitle(this.f1036a.getText(i));
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            a("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            a("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            a("android.intent.extra.EMAIL", strArr);
            return this;
        }

        private void a(String str, String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }
    }

    /* loaded from: classes.dex */
    public static class IntentReader {

        /* renamed from: a */
        private Activity f1043a;

        /* renamed from: b */
        private Intent f1044b;

        /* renamed from: c */
        private String f1045c;

        /* renamed from: d */
        private ComponentName f1046d;

        /* renamed from: e */
        private ArrayList<Uri> f1047e;

        private IntentReader(Activity activity) {
            this.f1043a = activity;
            this.f1044b = activity.getIntent();
            this.f1045c = ShareCompat.getCallingPackage(activity);
            this.f1046d = ShareCompat.getCallingActivity(activity);
        }

        private static void a(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#" + ((int) charAt) + ";");
                } else if (charAt == ' ') {
                    while (true) {
                        int i3 = i + 1;
                        if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i = i3;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i++;
            }
        }

        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        public ComponentName getCallingActivity() {
            return this.f1046d;
        }

        public Drawable getCallingActivityIcon() {
            if (this.f1046d == null) {
                return null;
            }
            try {
                return this.f1043a.getPackageManager().getActivityIcon(this.f1046d);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e2);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.f1045c == null) {
                return null;
            }
            try {
                return this.f1043a.getPackageManager().getApplicationIcon(this.f1045c);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e2);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.f1045c == null) {
                return null;
            }
            PackageManager packageManager = this.f1043a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f1045c, 0));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e2);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.f1045c;
        }

        public String[] getEmailBcc() {
            return this.f1044b.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.f1044b.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.f1044b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String stringExtra = this.f1044b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            if (text == null) {
                return stringExtra;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return Html.escapeHtml(text);
            }
            StringBuilder sb = new StringBuilder();
            a(sb, text, 0, text.length());
            return sb.toString();
        }

        public Uri getStream() {
            return (Uri) this.f1044b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.f1047e == null && isMultipleShare()) {
                this.f1047e = this.f1044b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f1047e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.f1044b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String getSubject() {
            return this.f1044b.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.f1044b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.f1044b.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f1044b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.f1044b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f1044b.getAction());
        }

        public Uri getStream(int i) {
            if (this.f1047e == null && isMultipleShare()) {
                this.f1047e = this.f1044b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f1047e;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            if (i == 0) {
                return (Uri) this.f1044b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }
    }

    private ShareCompat() {
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            shareActionProvider = new ShareActionProvider(intentBuilder.a());
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        shareActionProvider.setShareHistoryFileName(".sharecompat_" + intentBuilder.a().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
        if (Build.VERSION.SDK_INT >= 16 || menuItem.hasSubMenu()) {
            return;
        }
        menuItem.setIntent(intentBuilder.createChooserIntent());
    }

    public static ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? (ComponentName) activity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY) : callingActivity;
    }

    public static String getCallingPackage(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        return callingPackage == null ? activity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE) : callingPackage;
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
    }
}
