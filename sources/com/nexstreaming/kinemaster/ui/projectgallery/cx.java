package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Locale;

/* compiled from: TipManager.java */
/* loaded from: classes.dex */
public class cx {

    /* compiled from: TipManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f4204a;
        public final String b;
        public final String c;

        public Spannable a() {
            int indexOf = this.b.indexOf(123);
            int indexOf2 = this.b.indexOf(125);
            if (indexOf < 0 || indexOf2 <= indexOf) {
                return new SpannableString(this.b);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.b.substring(0, indexOf));
            spannableStringBuilder.append((CharSequence) this.b.substring(indexOf + 1, indexOf2));
            spannableStringBuilder.append((CharSequence) this.b.substring(indexOf2 + 1));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-42149), indexOf, indexOf2 - 1, 33);
            spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, indexOf2 - 1, 33);
            return spannableStringBuilder;
        }

        public boolean b() {
            return this.c != null && (this.c.startsWith("http:") || this.c.startsWith("https:"));
        }

        public boolean c() {
            return this.c != null && this.c.startsWith("help:");
        }

        public boolean d() {
            return this.c != null && this.c.startsWith("settings:");
        }

        public boolean e() {
            return this.c != null;
        }

        private a(int i, String str, String str2) {
            this.f4204a = i;
            this.b = str;
            this.c = str2;
        }

        private a(int i, String str) {
            this.f4204a = i;
            this.b = str;
            this.c = null;
        }
    }

    public static a a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Resources resources = context.getResources();
        int i = defaultSharedPreferences.getInt("km.tipShownString", -1);
        int i2 = defaultSharedPreferences.getInt("km.tipMaxShownString", -1);
        a[] a2 = a(locale, resources);
        if (a2.length < 1) {
            return null;
        }
        if (i2 < a2.length - 1) {
            i = i2;
        }
        int length = (i + 1) % a2.length;
        if (length > i2) {
            i2 = length;
        }
        defaultSharedPreferences.edit().putInt("km.tipShownString", length).putInt("km.tipMaxShownString", i2).apply();
        return a2[length];
    }

    private static a[] a(Locale locale, Resources resources) {
        int i = R.drawable.tip_crop_icon;
        int i2 = R.drawable.tip_trim_icon;
        int i3 = R.drawable.tip_settings_icon;
        int i4 = 0;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        locale.getCountry().toUpperCase(Locale.US);
        if (lowerCase.equals("en")) {
            return new a[]{new a(i4, "Want to be a KineMaster beta tester?\nJoin the {KineMaster User Community} on Google+", "https://plus.google.com/communities/106651618454986060628"), new a(R.drawable.tip_share_icon, "You can share directly from the editing screen."), new a(R.drawable.tip_animation_icon, "Layers can be {animated!} Tap here to learn more.", "https://support.kinemaster.com/hc/articles/210620503-Animation"), new a(i, "Cropping can be used to enlarge or reduce video."), new a(R.drawable.tip_media_icon, "Long press in the media browser\nfor media details."), new a(R.drawable.tip_cloud_icon, "You can use media from your\nGoogle Drive account."), new a(i, "Double-tap while cropping to fit or fill the screen."), new a(R.drawable.tip_text_icon, "Many additional fonts are available\nfor download."), new a(i3, "Set default duration for images in {settings}.", "settings:def_crop"), new a(i3, "Set default cropping for images in {settings}.", "settings:def_crop"), new a(i3, "Default layer duration can be\nadjusted in {settings}.", "settings:layer_dur"), new a(i4, "Long-press clips in the timeline to move them."), new a(i2, "Use just part of a clip or layer by {trimming it}.", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split"), new a(R.drawable.tip_capture_icon, "Tap a clip, then this icon to capture a frame."), new a(i2, "Layer and image duration can be\nadjusted by {trimming}.", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split")};
        }
        if (lowerCase.equals("ko")) {
            return new a[]{new a(i4, "키네마스터를 둘러보시려면 \"?\" 눌러주세요."), new a(i4, "키네마스터 베타 테스터가 되고 싶다면 Google + 의 {키네마스터 사용자 커뮤니티}에 가입하세요.", "https://plus.google.com/communities/106651618454986060628"), new a(R.drawable.tip_share_icon, "편집화면에서도 공유 할 수 있어요."), new a(R.drawable.tip_animation_icon, "{애니메이션} 기능 아직 사용해보지 않으셨나요?", "https://support.kinemaster.com/hc/articles/210620503-Animation"), new a(i, "비디오 크로핑으로 비디오도 확대, 축소 할 수 있어요."), new a(R.drawable.tip_media_icon, "미디어 정보를 보려면 브라우저에서 길게 누르세요."), new a(R.drawable.tip_cloud_icon, "구글 드라이브 폴더에서 미디어를 불러올 수 있어요."), new a(R.drawable.tip_audiob_icon, "오디오 브라우저에서도 폴더별로\n음악을 확인할 수 있어요."), new a(i, "크로핑 사용 중 두번 터치해서 화면에\n맞추거나 채울 수 있어요."), new a(R.drawable.tip_text_icon, "글꼴을 다운받아 텍스트를 꾸며보세요."), new a(i3, "{설정에서} 화면에 맞춰 사진을 추가할 수 있어요.", "settings:kr_a"), new a(i3, "{설정에서} 추가할 사진의 길이를 미리 선택하세요.", "settings:kr_b"), new a(i3, "{설정에서} 추가할 레이어의 길이를 미리 선택하세요.", "settings:kr_c"), new a(i4, "타임라인에서 클립을 길게 누르면 이동할 수 있어요."), new a(i2, "{트림}을 통해 클립의 재생 시간을 조절 할 수 있어요.", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split"), new a(R.drawable.tip_vol_env_icon, "{볼륨 상세 조정}으로 부분 볼륨을 조정해보세요.", "https://support.kinemaster.com/hc/articles/209015946-Volume-Envelope"), new a(R.drawable.tip_capture_icon, "클립을 선택 한 후 캡처를 사용해 보세요."), new a(i2, "레이어도 {트리밍}을 사용할 수 있어요.", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split"), new a(i3, "워터마크를 없애고 싶으신가요?\n내 계정 정보를 확인하세요.", "settings:kr_d")};
        }
        if (lowerCase.equals("ja")) {
            return new a[]{new a(R.drawable.tip_share_icon, "編集画面より直接共有可能"), new a(i, "クロッピング機能でビデオ画面の拡大や縮小可能"), new a(R.drawable.tip_cloud_icon, "Google Driveアカウントからメディア利用可能"), new a(R.drawable.tip_text_icon, "更に様々なフォントがダウンロード利用可能"), new a(i4, "タイムライン上でクリップを長押しすると移動可能"), new a(i2, "{トリミング機能}でクリップを部分や全体として使用可能", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split"), new a(i2, "{トリミング機能}は、レイヤーや静止画と共に使用可能", "https://support.kinemaster.com/hc/articles/209015826-Trim-Split")};
        }
        return new a[0];
    }
}
