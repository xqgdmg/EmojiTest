package com.mumu.easyemoji.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.mumu.easyemoji.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lq on 16/10/11.
 * 表情基础管理类
 */

public class EmoJiUtils {

    public static List<String> expressTitleList01;
    public static List<String> expressTitleList02;
    public static List<String> expressTitleList03;
    public static List<String> allResList;
    private static final Map<Pattern, Integer> emoticons = new HashMap<Pattern, Integer>();
    public static ArrayMap<String, Integer> expressMap01 = null;
    public static ArrayMap<String, Integer> expressMap02 = null;
    public static ArrayMap<String, Integer> allMap = null;
    public static ArrayMap<String, Integer> expressMap03 = null;
    private static final Spannable.Factory factory = Spannable.Factory.getInstance();

    static {
        // 所有表情资源
        expressTitleList01 = new ArrayList<>();
        expressTitleList02 = new ArrayList<>();
        expressTitleList03 = new ArrayList<>();
        allResList = new ArrayList<>();

        // 绑定文字和图片
        expressMap02 = new ArrayMap<>();
        expressMap03 = new ArrayMap<>();
        expressMap01 = new ArrayMap<>();
        allMap = new ArrayMap<>();

        expressMap01.put("[呵呵]", R.drawable.d_hehe);
        expressMap01.put("[可爱]", R.drawable.d_keai);
        expressMap01.put("[太开心]", R.drawable.d_taikaixin);
        expressMap01.put("[鼓掌]", R.drawable.d_guzhang);
        expressMap01.put("[嘻嘻]", R.drawable.d_xixi);
        expressMap01.put("[哈哈]", R.drawable.d_haha);
        expressMap01.put("[笑哭]", R.drawable.d_xiaoku);
        expressMap01.put("[急眼]", R.drawable.d_jiyan);
        expressMap01.put("[大馋嘴]", R.drawable.d_chanzui);
        expressMap01.put("[懒得理你]", R.drawable.d_landelini);
        expressMap01.put("[黑线]", R.drawable.d_heixian);
        expressMap01.put("[挖鼻屎]", R.drawable.d_wabishi);
        expressMap01.put("[哼]", R.drawable.d_heng);
        expressMap01.put("[怒]", R.drawable.d_nu);
        expressMap01.put("[抓狂]", R.drawable.d_zhuakuang);
        expressMap01.put("[委屈]", R.drawable.d_weiqu);
        expressMap01.put("[可怜]", R.drawable.d_kelian);
        expressMap01.put("[失望]", R.drawable.d_shiwang);
        expressMap01.put("[悲伤]", R.drawable.d_beishang);
        expressMap01.put("[累]", R.drawable.d_lei);
        expressMap01.put("[害羞]", R.drawable.d_haixiu);
        expressMap01.put("[捂]", R.drawable.d_wu);
        expressMap01.put("[爱你]", R.drawable.d_aini);
        expressMap01.put("[亲亲]", R.drawable.d_qinqin);
        expressMap01.put("[花心]", R.drawable.d_huaxin);
        expressMap01.put("[舔]", R.drawable.d_tian);
        expressMap01.put("[钱]", R.drawable.d_qian);
        expressMap01.put("[神烦狗]", R.drawable.d_doge);
        expressMap01.put("[喵]", R.drawable.d_miao);
        expressMap01.put("[二哈]", R.drawable.d_erha);
        expressMap01.put("[哭]", R.drawable.d_ku);
        expressMap01.put("[坏笑]", R.drawable.d_huaixiao);
        expressMap01.put("[阴险]", R.drawable.d_yinxian);
        expressMap01.put("[偷笑]", R.drawable.d_touxiao);
        expressMap01.put("[思考]", R.drawable.d_sikao);
        expressMap01.put("[疑问]", R.drawable.d_yiwen);
        expressMap01.put("[晕]", R.drawable.d_yun);
        expressMap01.put("[傻眼]", R.drawable.d_shayan);
        expressMap01.put("[衰]", R.drawable.d_shuai);
        expressMap01.put("[骷髅]", R.drawable.d_kulou);
        expressMap01.put("[嘘]", R.drawable.d_xu);
        expressMap01.put("[闭嘴]", R.drawable.d_bizui);
        expressMap01.put("[汗]", R.drawable.d_han);
        expressMap01.put("[吃惊]", R.drawable.d_chijing);
        expressMap01.put("[感冒]", R.drawable.d_ganmao);
        expressMap01.put("[生病]", R.drawable.d_shengbing);
        expressMap01.put("[吐]", R.drawable.d_tu);
        expressMap01.put("[拜拜]", R.drawable.d_baibai);
        expressMap01.put("[鄙视]", R.drawable.d_bishi);
        expressMap01.put("[左哼哼]", R.drawable.d_zuohengheng);
        expressMap01.put("[右哼哼]", R.drawable.d_youhengheng);
        expressMap01.put("[怒骂]", R.drawable.d_numa);
        expressMap01.put("[打脸]", R.drawable.d_dalian);
        expressMap01.put("[敲头]", R.drawable.d_ding);
        expressMap01.put("[打哈气]", R.drawable.d_dahaqi);
        expressMap01.put("[困]", R.drawable.d_kun);
        expressMap01.put("[互粉]", R.drawable.f_hufen);
        expressMap01.put("[抱抱]", R.drawable.d_baobao);
        expressMap01.put("[摊手]", R.drawable.d_tanshou);
        expressMap01.put("[心]", R.drawable.l_xin);
        expressMap01.put("[伤心]", R.drawable.l_shangxin);
        expressMap01.put("[鲜花]", R.drawable.w_xianhua);
        expressMap01.put("[男孩儿]", R.drawable.d_nanhaier);
        expressMap01.put("[女孩儿]", R.drawable.d_nvhaier);
        expressMap01.put("[握手]", R.drawable.h_woshou);
        expressMap01.put("[作揖]", R.drawable.h_zuoyi);
        expressMap01.put("[赞]", R.drawable.h_zan);
        expressMap01.put("[耶]", R.drawable.h_ye);
        expressMap01.put("[好]", R.drawable.h_good);
        expressMap01.put("[弱]", R.drawable.h_ruo);
        expressMap01.put("[不要]", R.drawable.h_buyao);
        expressMap01.put("[好的]", R.drawable.h_ok);
        expressMap01.put("[哈哈]", R.drawable.h_haha);
        expressMap01.put("[来]", R.drawable.h_lai);//
        expressMap01.put("[熊猫]", R.drawable.d_xiongmao);
        expressMap01.put("[兔子]", R.drawable.d_tuzi);
        expressMap01.put("[猪头]", R.drawable.d_zhutou);
        expressMap01.put("[神兽]", R.drawable.d_shenshou);
        expressMap01.put("[奥特曼]", R.drawable.d_aoteman);
        expressMap01.put("[太阳]", R.drawable.w_taiyang);
        expressMap01.put("[月亮]", R.drawable.w_yueliang);
        expressMap01.put("[浮云]", R.drawable.w_fuyun);
        expressMap01.put("[下雨]", R.drawable.w_xiayu);
        expressMap01.put("[沙尘暴]", R.drawable.w_shachenbao);
        expressMap01.put("[微风]", R.drawable.w_weifeng);
        expressMap01.put("[飞机]", R.drawable.o_feiji);
        expressMap01.put("[照相机]", R.drawable.o_zhaoxiangji);
        expressMap01.put("[话筒]", R.drawable.o_huatong);
        expressMap01.put("[音乐]", R.drawable.o_yinyue);
        expressMap01.put("[给力]", R.drawable.f_geili);
        expressMap01.put("[囧]", R.drawable.f_jiong);
        expressMap01.put("[萌]", R.drawable.f_meng);
        expressMap01.put("[神马]", R.drawable.f_shenma);
        expressMap01.put("[织]", R.drawable.f_zhi);
        expressMap01.put("[最右]", R.drawable.d_zuiyou);
        expressMap01.put("[蜡烛]", R.drawable.o_lazhu);
        expressMap01.put("[围观]", R.drawable.o_weiguan);
        expressMap01.put("[干杯]", R.drawable.o_ganbei);
        expressMap01.put("[蛋糕]", R.drawable.o_dangao);
        expressMap01.put("[礼物]", R.drawable.o_liwu);
        expressMap01.put("[囍]", R.drawable.f_xi);
        expressMap01.put("[钟]", R.drawable.o_zhong);
        expressMap01.put("[肥皂]", R.drawable.d_feizao);
        expressMap01.put("[绿丝带]", R.drawable.o_lvsidai);
        expressMap01.put("[围脖]", R.drawable.o_weibo);
        expressMap01.put("[删除]", R.drawable.compose_emotion_delete_highlighted);

        expressTitleList01.add("[呵呵]");
        expressTitleList01.add("[可爱]");
        expressTitleList01.add("[太开心]");
        expressTitleList01.add("[鼓掌]");
        expressTitleList01.add("[嘻嘻]");
        expressTitleList01.add("[哈哈]");
        expressTitleList01.add("[笑哭]");
        expressTitleList01.add("[急眼]");
        expressTitleList01.add("[大馋嘴]");
        expressTitleList01.add("[懒得理你]");
        expressTitleList01.add("[黑线]");
        expressTitleList01.add("[挖鼻屎]");
        expressTitleList01.add("[哼]");
        expressTitleList01.add("[怒]");
        expressTitleList01.add("[抓狂]");
        expressTitleList01.add("[委屈]");
        expressTitleList01.add("[可怜]");
        expressTitleList01.add("[失望]");
        expressTitleList01.add("[悲伤]");
        expressTitleList01.add("[累]");
        expressTitleList01.add("[害羞]");
        expressTitleList01.add("[捂]");
        expressTitleList01.add("[爱你]");
        expressTitleList01.add("[亲亲]");
        expressTitleList01.add("[花心]");
        expressTitleList01.add("[舔]");
        expressTitleList01.add("[钱]");
        expressTitleList01.add("[神烦狗]");
        expressTitleList01.add("[喵]");
        expressTitleList01.add("[二哈]");
        expressTitleList01.add("[哭]");
        expressTitleList01.add("[坏笑]");
        expressTitleList01.add("[阴险]");
        expressTitleList01.add("[偷笑]");
        expressTitleList01.add("[思考]");
        expressTitleList01.add("[疑问]");
        expressTitleList01.add("[晕]");
        expressTitleList01.add("[傻眼]");
        expressTitleList01.add("[衰]");
        expressTitleList01.add("[骷髅]");
        expressTitleList01.add("[嘘]");
        expressTitleList01.add("[闭嘴]");
        expressTitleList01.add("[汗]");
        expressTitleList01.add("[吃惊]");
        expressTitleList01.add("[感冒]");
        expressTitleList01.add("[生病]");
        expressTitleList01.add("[吐]");
        expressTitleList01.add("[拜拜]");
        expressTitleList01.add("[鄙视]");
        expressTitleList01.add("[左哼哼]");
        expressTitleList01.add("[右哼哼]");
        expressTitleList01.add("[怒骂]");
        expressTitleList01.add("[打脸]");
        expressTitleList01.add("[敲头]");
        expressTitleList01.add("[打哈气]");
        expressTitleList01.add("[困]");
        expressTitleList01.add("[互粉]");
        expressTitleList01.add("[抱抱]");
        expressTitleList01.add("[摊手]");
        expressTitleList01.add("[心]");
        expressTitleList01.add("[伤心]");
        expressTitleList01.add("[鲜花]");
        expressTitleList01.add("[男孩儿]");
        expressTitleList01.add("[女孩儿]");
        expressTitleList01.add("[握手]");
        expressTitleList01.add("[作揖]");
        expressTitleList01.add("[赞]");
        expressTitleList01.add("[耶]");
        expressTitleList01.add("[好]");
        expressTitleList01.add("[弱]");
        expressTitleList01.add("[不要]");
        expressTitleList01.add("[好的]");
        expressTitleList01.add("[哈哈]");
        expressTitleList01.add("[来]");//
        expressTitleList01.add("[熊猫]");
        expressTitleList01.add("[兔子]");
        expressTitleList01.add("[猪头]");
        expressTitleList01.add("[神兽]");
        expressTitleList01.add("[奥特曼]");
        expressTitleList01.add("[太阳]");
        expressTitleList01.add("[月亮]");
        expressTitleList01.add("[浮云]");
        expressTitleList01.add("[下雨]");
        expressTitleList01.add("[沙尘暴]");
        expressTitleList01.add("[微风]");
        expressTitleList01.add("[飞机]");
        expressTitleList01.add("[照相机]");
        expressTitleList01.add("[话筒]");
        expressTitleList01.add("[音乐]");
        expressTitleList01.add("[给力]");
        expressTitleList01.add("[囧]");
        expressTitleList01.add("[萌]");
        expressTitleList01.add("[神马]");
        expressTitleList01.add("[织]");
        expressTitleList01.add("[最右]");
        expressTitleList01.add("[蜡烛]");
        expressTitleList01.add("[围观]");
        expressTitleList01.add("[干杯]");
        expressTitleList01.add("[蛋糕]");
        expressTitleList01.add("[礼物]");
        expressTitleList01.add("[囍]");
        expressTitleList01.add("[钟]");
        expressTitleList01.add("[肥皂]");
        expressTitleList01.add("[绿丝带]");
        expressTitleList01.add("[围脖]");

        expressMap02.put("[悲催]", R.drawable.lxh_beicui);
        expressMap02.put("[被电]", R.drawable.lxh_beidian);
        expressMap02.put("[奔溃]", R.drawable.lxh_bengkui);
        expressMap02.put("[别烦我]", R.drawable.lxh_biefanwo);
        expressMap02.put("[不好意思]", R.drawable.lxh_buhaoyisi);
        expressMap02.put("[不想上班]", R.drawable.lxh_buxiangshangban);
        expressMap02.put("[得意地笑]", R.drawable.lxh_deyidexiao);
        expressMap02.put("[费劲]", R.drawable.lxh_feijin);
        expressMap02.put("[好爱哦]", R.drawable.lxh_haoaio);
        expressMap02.put("[好棒]", R.drawable.lxh_haobang);
        expressMap02.put("[好囧]", R.drawable.lxh_haojiong);
        expressMap02.put("[好喜欢]", R.drawable.lxh_haoxihuan);
        expressMap02.put("[坚持住]", R.drawable.lxh_holdzhu);
        expressMap02.put("[杰克逊]", R.drawable.lxh_jiekexun);
        expressMap02.put("[纠结]", R.drawable.lxh_jiujie);
        expressMap02.put("[巨汗]", R.drawable.lxh_juhan);
        expressMap02.put("[抠鼻屎]", R.drawable.lxh_koubishi);
        expressMap02.put("[困死了]", R.drawable.lxh_kunsile);
        expressMap02.put("[雷锋]", R.drawable.lxh_leifeng);
        expressMap02.put("[泪流满面]", R.drawable.lxh_leiliumanmian);
        expressMap02.put("[玫瑰]", R.drawable.lxh_meigui);
        expressMap02.put("[欧耶]", R.drawable.lxh_oye);
        expressMap02.put("[霹雳]", R.drawable.lxh_pili);
        expressMap02.put("[悄悄]", R.drawable.lxh_qiaoqiao);
        expressMap02.put("[丘比特]", R.drawable.lxh_qiubite);
        expressMap02.put("[求关注]", R.drawable.lxh_qiuguanzhu);
        expressMap02.put("[群体围观]", R.drawable.lxh_quntiweiguan);
        expressMap02.put("[甩甩手]", R.drawable.lxh_shuaishuaishou);
        expressMap02.put("[偷乐]", R.drawable.lxh_toule);
        expressMap02.put("[推荐]", R.drawable.lxh_tuijian);
        expressMap02.put("[相互膜拜]", R.drawable.lxh_xianghumobai);
        expressMap02.put("[想一想]", R.drawable.lxh_xiangyixiang);
        expressMap02.put("[笑哈哈]", R.drawable.lxh_xiaohaha);
        expressMap02.put("[羞嗒嗒]", R.drawable.lxh_xiudada);
        expressMap02.put("[许愿]", R.drawable.lxh_xuyuan);
        expressMap02.put("[有压力]", R.drawable.lxh_youyali);
        expressMap02.put("[狂躁症]", R.drawable.kuangzaozheng);
        expressMap02.put("[删除]", R.drawable.compose_emotion_delete_highlighted);

        expressTitleList02.add("[悲催]");
        expressTitleList02.add("[被电]");
        expressTitleList02.add("[奔溃]");
        expressTitleList02.add("[别烦我]");
        expressTitleList02.add("[不好意思]");
        expressTitleList02.add("[不想上班]");
        expressTitleList02.add("[得意地笑]");
        expressTitleList02.add("[费劲]");
        expressTitleList02.add("[好爱哦]");
        expressTitleList02.add("[好棒]");
        expressTitleList02.add("[好囧]");
        expressTitleList02.add("[好喜欢]");
        expressTitleList02.add("[坚持住]");
        expressTitleList02.add("[杰克逊]");
        expressTitleList02.add("[纠结]");
        expressTitleList02.add("[巨汗]");
        expressTitleList02.add("[抠鼻屎]");
        expressTitleList02.add("[困死了]");
        expressTitleList02.add("[雷锋]");
        expressTitleList02.add("[泪流满面]");
        expressTitleList02.add("[玫瑰]");
        expressTitleList02.add("[欧耶]");
        expressTitleList02.add("[霹雳]");
        expressTitleList02.add("[悄悄]");
        expressTitleList02.add("[丘比特]");
        expressTitleList02.add("[求关注]");
        expressTitleList02.add("[群体围观]");
        expressTitleList02.add("[甩甩手]");
        expressTitleList02.add("[偷乐]");
        expressTitleList02.add("[推荐]");
        expressTitleList02.add("[相互膜拜]");
        expressTitleList02.add("[想一想]");
        expressTitleList02.add("[笑哈哈]");
        expressTitleList02.add("[羞嗒嗒]");
        expressTitleList02.add("[许愿]");
        expressTitleList02.add("[有压力]");
        expressTitleList02.add("[狂躁症]");

        expressMap03.put("[ecf]",R.drawable.ecf);
        expressMap03.put("[ecv]",R.drawable.ecv);
        expressMap03.put("[ecb]",R.drawable.ecb);
        expressMap03.put("[ecy]",R.drawable.ecy);
        expressMap03.put("[ebu]",R.drawable.ebu);
        expressMap03.put("[ebr]",R.drawable.ebr);
        expressMap03.put("[ecc]",R.drawable.ecc);
        expressMap03.put("[eft]",R.drawable.eft);
        expressMap03.put("[ecr]",R.drawable.ecr);
        expressMap03.put("[ebs]",R.drawable.ebs);
        expressMap03.put("[ech]",R.drawable.ech);
        expressMap03.put("[ecg]",R.drawable.ecg);
        expressMap03.put("[ebh]",R.drawable.ebh);
        expressMap03.put("[ebg]",R.drawable.ebg);
        expressMap03.put("[ecp]",R.drawable.ecp);
        expressMap03.put("[deg]",R.drawable.deg);
        expressMap03.put("[ecd]",R.drawable.ecd);
        expressMap03.put("[ecj]",R.drawable.ecj);
        expressMap03.put("[ebv]",R.drawable.ebv);
        expressMap03.put("[ece]",R.drawable.ece);
        expressMap03.put("[ebl]",R.drawable.ebl);
        expressMap03.put("[eca]",R.drawable.eca);
        expressMap03.put("[ecn]",R.drawable.ecn);
        expressMap03.put("[eco]",R.drawable.eco);
        expressMap03.put("[eeo]",R.drawable.eeo);
        expressMap03.put("[eep]",R.drawable.eep);
        expressMap03.put("[eci]",R.drawable.eci);
        expressMap03.put("[ebj]",R.drawable.ebj);
        expressMap03.put("[eer]",R.drawable.eer);
        expressMap03.put("[edi]",R.drawable.edi);
        expressMap03.put("[ebq]",R.drawable.ebq);
        expressMap03.put("[eeq]",R.drawable.eeq);
        expressMap03.put("[ecq]",R.drawable.ecq);
        expressMap03.put("[ebt]",R.drawable.ebt);
        expressMap03.put("[ede]",R.drawable.ede);
        expressMap03.put("[eew]",R.drawable.eew);
        expressMap03.put("[eex]",R.drawable.eex);
        expressMap03.put("[dga]",R.drawable.dga);
        expressMap03.put("[ebp]",R.drawable.ebp);
        expressMap03.put("[ebo]",R.drawable.ebo);
        expressMap03.put("[删除]", R.drawable.compose_emotion_delete_highlighted);

        expressTitleList03.add("[ecf]");
        expressTitleList03.add("[ecv]");
        expressTitleList03.add("[ecb]");
        expressTitleList03.add("[ecy]");
        expressTitleList03.add("[ebu]");
        expressTitleList03.add("[ebr]");
        expressTitleList03.add("[ecc]");
        expressTitleList03.add("[eft]");
        expressTitleList03.add("[ecr]");
        expressTitleList03.add("[ebs]");
        expressTitleList03.add("[ech]");
        expressTitleList03.add("[ecg]");
        expressTitleList03.add("[ebh]");
        expressTitleList03.add("[ebg]");
        expressTitleList03.add("[ecp]");
        expressTitleList03.add("[deg]");
        expressTitleList03.add("[ecd]");
        expressTitleList03.add("[ecj]");
        expressTitleList03.add("[ebv]");
        expressTitleList03.add("[ece]");
        expressTitleList03.add("[ebl]");
        expressTitleList03.add("[eca]");
        expressTitleList03.add("[ecn]");
        expressTitleList03.add("[eco]");
        expressTitleList03.add("[eeo]");
        expressTitleList03.add("[eep]");
        expressTitleList03.add("[eci]");
        expressTitleList03.add("[ebj]");
        expressTitleList03.add("[eer]");
        expressTitleList03.add("[edi]");
        expressTitleList03.add("[ebq]");
        expressTitleList03.add("[eeq]");
        expressTitleList03.add("[ecq]");
        expressTitleList03.add("[ebt]");
        expressTitleList03.add("[ede]");
        expressTitleList03.add("[eew]");
        expressTitleList03.add("[eex]");
        expressTitleList03.add("[dga]");
        expressTitleList03.add("[ebp]");
        expressTitleList03.add("[ebo]");

        allResList.addAll(expressTitleList01);
        allResList.addAll(expressTitleList02);
        allResList.addAll(expressTitleList03);
        allMap.putAll((Map<? extends String, ? extends Integer>) expressMap01);
        allMap.putAll((Map<? extends String, ? extends Integer>) expressMap02);
        allMap.putAll((Map<? extends String, ? extends Integer>) expressMap03);

    }

    /*
     * 获取表情包标题
     * 默认返回第一组表情
     */
    public static List<String> getResTitleList(int type) {
        switch (type) {
            case 0:
                return expressTitleList01;
            case 1:
                return expressTitleList02;
            case 2:
                return expressTitleList03;
        }
        return expressTitleList01;
    }

    /*
     * 获取全部表情包
     */
    public static List<String> getAllResList() {
        return allResList;
    }

    /*
     * 获取表情标题和图片绑定的集合
     */
    public static ArrayMap<String, Integer> getEmoJiMap(int type) {
        switch (type) {
            case 0:
                return expressMap01;
            case 1:
                return expressMap02;
            case 2:
                return expressMap03;
        }
        return expressMap01;
    }

    /**
     * 解析 EmoJi表情
     */
    public static SpannableString parseEmoJi(int type, Context context, String etContent) {

        SpannableString spannable = new SpannableString(etContent);
        String reg = "\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]";//校验表情正则？？？？？？？？？
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(etContent);

        while (matcher.find()) {
            String regEmoJi = matcher.group();//获取匹配到的emoji字符串
            int start = matcher.start();//匹配到字符串的开始位置
            int end = matcher.end();//匹配到字符串的结束位置
            Integer resId = allMap.get(regEmoJi);//通过emoji名获取对应的表情id

            if (resId != null) {
                Drawable drawable = context.getResources().getDrawable(resId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan imageSpan = new ImageSpan(drawable, etContent);
                spannable.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }
        return spannable;
    }


}
