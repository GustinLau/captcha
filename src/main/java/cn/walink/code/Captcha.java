package cn.walink.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by Gustin Lau on 2016/4/21.
 */
public class Captcha {

    private final String FILE_SEPARATOR = File.separator;
    private final String VERIFY_PATH = this.getClass().getClassLoader().getResource("").getPath() + "verify" + FILE_SEPARATOR;

    private Random random = new Random();  //随机器

    /*=============Config值===================*/
    private String seKey = "walink.cn";       // 验证码加密密钥
    private String codeSet = "2345678abcdefhijkmnpqrstuvwxyzABCDEFGHJKLMNPQRTUVWXY";     // 英文验证码字符集合
    private Long expire = 60000L;        // 验证码过期时间（ms）
    private Boolean useZh = false;      // 使用中文验证码
    private String zhSet = "们以我到他会作时要动国产的一是工就年阶义发成部民可出能方进在了不和有大这主中人上为来分生对于学下级地个用同行面说种过命度革而多子后自社加小机也经力线本电高量长党得实家定深法表着水理化争现所二起政三好十战无农使性前等反体合斗路图把结第里正新开论之物从当两些还天资事队批点育重其思与间内去因件日利相由压员气业代全组数果期导平各基或月毛然如应形想制心样干都向变关问比展那它最及外没看治提五解系林者米群头意只明四道马认次文通但条较克又公孔领军流入接席位情运器并飞原油放立题质指建区验活众很教决特此常石强极土少已根共直团统式转别造切九你取西持总料连任志观调七么山程百报更见必真保热委手改管处己将修支识病象几先老光专什六型具示复安带每东增则完风回南广劳轮科北打积车计给节做务被整联步类集号列温装即毫知轴研单色坚据速防史拉世设达尔场织历花受求传口断况采精金界品判参层止边清至万确究书术状厂须离再目海交权且儿青才证低越际八试规斯近注办布门铁需走议县兵固除般引齿千胜细影济白格效置推空配刀叶率述今选养德话查差半敌始片施响收华觉备名红续均药标记难存测士身紧液派准斤角降维板许破述技消底床田势端感往神便贺村构照容非搞亚磨族火段算适讲按值美态黄易彪服早班麦削信排台声该击素张密害侯草何树肥继右属市严径螺检左页抗苏显苦英快称坏移约巴材省黑武培著河帝仅针怎植京助升王眼她抓含苗副杂普谈围食射源例致酸旧却充足短划剂宣环落首尺波承粉践府鱼随考刻靠够满夫失包住促枝局菌杆周护岩师举曲春元超负砂封换太模贫减阳扬江析亩木言球朝医校古呢稻宋听唯输滑站另卫字鼓刚写刘微略范供阿块某功套友限项余倒卷创律雨让骨远帮初皮播优占死毒圈伟季训控激找叫云互跟裂粮粒母练塞钢顶策双留误础吸阻故寸盾晚丝女散焊功株亲院冷彻弹错散商视艺灭版烈零室轻血倍缺厘泵察绝富城冲喷壤简否柱李望盘磁雄似困巩益洲脱投送奴侧润盖挥距触星松送获兴独官混纪依未突架宽冬章湿偏纹吃执阀矿寨责熟稳夺硬价努翻奇甲预职评读背协损棉侵灰虽矛厚罗泥辟告卵箱掌氧恩爱停曾溶营终纲孟钱待尽俄缩沙退陈讨奋械载胞幼哪剥迫旋征槽倒握担仍呀鲜吧卡粗介钻逐弱脚怕盐末阴丰雾冠丙街莱贝辐肠付吉渗瑞惊顿挤秒悬姆烂森糖圣凹陶词迟蚕亿矩康遵牧遭幅园腔订香肉弟屋敏恢忘编印蜂急拿扩伤飞露核缘游振操央伍域甚迅辉异序免纸夜乡久隶缸夹念兰映沟乙吗儒杀汽磷艰晶插埃燃欢铁补咱芽永瓦倾阵碳演威附牙芽永瓦斜灌欧献顺猪洋腐请透司危括脉宜笑若尾束壮暴企菜穗楚汉愈绿拖牛份染既秋遍锻玉夏疗尖殖井费州访吹荣铜沿替滚客召旱悟刺脑措贯藏敢令隙炉壳硫煤迎铸粘探临薄旬善福纵择礼愿伏残雷延烟句纯渐耕跑泽慢栽鲁赤繁境潮横掉锥希池败船假亮谓托伙哲怀割摆贡呈劲财仪沉炼麻罪祖息车穿货销齐鼠抽画饲龙库守筑房歌寒喜哥洗蚀废纳腹乎录镜妇恶脂庄擦险赞钟摇典柄辩竹谷卖乱虚桥奥伯赶垂途额壁网截野遗静谋弄挂课镇妄盛耐援扎虑键归符庆聚绕摩忙舞遇索顾胶羊湖钉仁音迹碎伸灯避泛亡答勇频皇柳哈揭甘诺概宪浓岛袭谁洪谢炮浇斑讯懂灵蛋闭孩释乳巨徒私银伊景坦累匀霉杜乐勒隔弯绩招绍胡呼痛峰零柴簧午跳居尚丁秦稍追梁折耗碱殊岗挖氏刃剧堆赫荷胸衡勤膜篇登驻案刊秧缓凸役剪川雪链渔啦脸户洛孢勃盟买杨宗焦赛旗滤硅炭股坐蒸凝竟陷枪黎救冒暗洞犯筒您宋弧爆谬涂味津臂障褐陆啊健尊豆拔莫抵桑坡缝警挑污冰柬嘴啥饭塑寄赵喊垫丹渡耳刨虎笔稀昆浪萨茶滴浅拥穴覆伦娘吨浸袖珠雌妈紫戏塔锤震岁貌洁剖牢锋疑霸闪埔猛诉刷狠忽灾闹乔唐漏闻沈熔氯荒茎男凡抢像浆旁玻亦忠唱蒙予纷捕锁尤乘乌智淡允叛畜俘摸锈扫毕璃宝芯爷鉴秘净蒋钙肩腾枯抛轨堂拌爸循诱祝励肯酒绳穷塘燥泡袋朗喂铝软渠颗惯贸粪综墙趋彼届墨碍启逆卸航衣孙龄岭骗休借";       // 中文验证码字符串
    private Boolean useImgBg = false;   // 使用背景图片
    private Float fontSize = 16F;       // 验证码字体大小(px)
    private Boolean useCurve = true;   // 是否画混淆曲线
    private Boolean useNoise = true;   // 是否添加杂点
    private Integer imageH = 0;        // 验证码图片高度
    private Integer imageW = 0;        // 验证码图片宽度
    private Integer length = 4;        // 验证码位数
    private String fontttf = "";       // 验证码字体，不设置随机获取
    private Color bg = new Color(243, 251, 254);           // 背景颜色
    private Boolean reset = true;      // 验证成功后是否重置

    //region Setter
    public void setSeKey(String seKey) {
        this.seKey = seKey;
    }

    public void setCodeSet(String codeSet) {
        this.codeSet = codeSet;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public void setUseZh(boolean useZh) {
        this.useZh = useZh;
    }

    public void setZhSet(String zhSet) {
        this.zhSet = zhSet;
    }

    public void setUseImgBg(boolean useImgBg) {
        this.useImgBg = useImgBg;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public void setUseCurve(boolean useCurve) {
        this.useCurve = useCurve;
    }

    public void setUseNoise(boolean useNoise) {
        this.useNoise = useNoise;
    }

    public void setImageH(int imageH) {
        this.imageH = imageH;
    }

    public void setImageW(int imageW) {
        this.imageW = imageW;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFontttf(String fontttf) {
        this.fontttf = fontttf;
    }

    public void setBg(Color bg) {
        this.bg = bg;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    //endregion

    public void generate(HttpServletRequest request, HttpServletResponse response, String id) {
        try {
            entry(request, response, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 画验证码调用方法
     *
     * @param request  request
     * @param response response
     */
    public void generate(HttpServletRequest request, HttpServletResponse response) {
        generate(request, response, null);
    }


    /**
     * 验证码验证
     *
     * @param code 用户验证码
     * @param id   验证码标识
     * @return bool 用户验证码是否正确
     */
    public boolean verify(HttpServletRequest request, String code, String id) {
        //id 空值判断
        id = id == null ? "" : id;
        String key = authcode(seKey) + id;
        // 验证码不能为空
        Map secode = (HashMap) request.getSession().getAttribute(key);
        if (code == null || secode == null) {
            return false;
        }
        // session 过期
        if (System.currentTimeMillis() - (Long) secode.get("captcha_time") > expire) {
            request.getSession().setAttribute(key, null);
            return false;
        }
        if (authcode(code.toUpperCase()).equals(secode.get("captcha_code").toString())) {
            if (reset)
                request.getSession().setAttribute(key, null);
            return true;
        }
        return false;
    }


    /**
     * 验证码验证
     *
     * @param code 用户验证码
     * @return bool 用户验证码是否正确
     */
    public boolean verify(HttpServletRequest request, String code) {
        return verify(request, code, null);
    }


    /**
     * 输出验证码并把验证码的值保存的session中
     * 验证码保存到session的格式为： HashMap 'verify_code' => '验证码值', 'verify_time' => '验证码创建时间';
     *
     * @param id 标记
     * @throws Exception
     */
    private void entry(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
        //id 空值判断
        id = id == null ? "" : id;
        // 图片宽(px)
        if (imageW == 0)
            imageW = (int) (length * fontSize * 2);
        // 图片高(px)
        if (imageH == 0)
            imageH = (int) (fontSize * 2.5);
        // 建立一幅 $this->imageW x $this->imageH 的图像
        BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
        // 设置背景
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 设置颜色
        g.setColor(bg);
        // 填充区域
        g.fillRect(0, 0, imageW, imageH);
        if (useImgBg) {
            //设置背景
            writeBackground(g);
        }
        if (useNoise) {
            // 绘噪点
            writeNoise(g);
        }
        if (useCurve) {
            // 绘干扰线
            writeCurve(g);
        }
        // 验证码字体随机颜色
        Color color = new Color(random.nextInt(150) + 1, random.nextInt(150) + 1, random.nextInt(150) + 1);
        g.setColor(color);
        // 验证码使用随机字体
        String ttfPath = VERIFY_PATH + (useZh ? "zhttfs" : "ttfs") + FILE_SEPARATOR;
        String fontttf = this.fontttf;
        if (fontttf.equals("") || fontttf == null) {
            File file = new File(ttfPath);
            File[] tempList = file.listFiles();
            ArrayList<File> ttfs = new ArrayList();
            String ttfName;
            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile()) {
                    ttfName = tempList[i].toString();
                    if (ttfName.substring(ttfName.length() - 4, ttfName.length()).equals(".ttf")) {
                        ttfs.add(tempList[i]);
                    }
                }
            }
            fontttf = ttfs.get(random.nextInt(ttfs.size())).toString();
        } else {
            fontttf = ttfPath + this.fontttf;
        }
        //设置字体
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontttf));
        font = font.deriveFont(fontSize);
        g.setFont(font);
        // 绘验证码
        char[] chars = new char[length]; // 验证码
        float codeNX; // 验证码第N个字符的左边距
        int degree;
        String wordSet;
        if (useZh) { // 中文验证码
            wordSet = zhSet;
        } else {
            wordSet = codeSet;
        }
        for (int i = 0; i < length; i++) {
            chars[i] = wordSet.charAt(random.nextInt(wordSet.length()));
            // 设置字体旋转角度
            degree = new Random().nextInt(61) - 30;
            codeNX = (float) (fontSize * (i + 1) * 1.5);
            // 正向角度
            g.rotate(degree * Math.PI / 180, codeNX, fontSize / 2);
            g.drawString(String.valueOf(chars[i]), codeNX, fontSize + random.nextInt(imageH / 4 + 1) + imageH / 4);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, codeNX, imageH / 2);
        }
        // 保存验证码
        String key = authcode(seKey) + id;
        String code = authcode(String.copyValueOf(chars).toUpperCase());
        Map secode = new HashMap();
        secode.put("verify_code", code); // 把校验码保存到session
        secode.put("verify_time", System.currentTimeMillis());  // 验证码创建时间
        request.getSession().setAttribute(key, secode);
        response.setHeader("Cache-Control", "private, max-age=0, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("content-type", "image/png");
        // 输出图像
        g.dispose();
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 画一条由两条连在一起构成的随机正弦函数曲线作干扰线(你可以改成更帅的曲线函数)
     * 高中的数学公式咋都忘了涅，写出来
     * 正弦型函数解析式：y=Asin(ωx+φ)+b
     * 各常数值对函数图像的影响：
     * A：决定峰值（即纵向拉伸压缩的倍数）
     * b：表示波形在Y轴的位置关系或纵向移动距离（上加下减）
     * φ：决定波形与X轴位置关系或横向移动距离（左加右减）
     * ω：决定周期（最小正周期T=2π/∣ω∣）
     */
    private void writeCurve(Graphics2D g) {
        double px, py = 0;
        // 曲线前部分
        double A = random.nextInt(imageH / 2) + 1;                  // 振幅
        double b = random.nextInt(imageH / 2 + 1) - imageH / 4;   // Y轴方向偏移量
        double f = random.nextInt(imageH / 2 + 1) - imageH / 4;   // X轴方向偏移量
        double T = random.nextInt(imageW * 2 - imageH + 1) + imageH;// 周期
        double w = (2 * Math.PI) / T;
        int px1 = 0;  // 曲线横坐标起始位置
        int px2 = random.nextInt((int) (imageW * 0.8) - imageW / 2 + 1) + imageW / 2;// + mt_rand($this -> imageW / 2, $this -> imageW * 0.8);  // 曲线横坐标结束位置
        for (px = px1; px <= px2; px = px + 1) {
            if (w != 0) {
                py = A * Math.sin(w * px + f) + b + (double) imageH / 2;  // y = Asin(ωx+φ) + b
                int i = (int) (fontSize / 5);
                while (i > 0) {
                    g.drawLine((int) px + i, (int) py + i, (int) px + i + 1, (int) py + i + 1);
                    i--;
                }
            }
        }
        // 曲线后部分
        A = random.nextInt(imageH / 2) + 1;                  // 振幅
        f = random.nextInt(imageH / 2 + 1) - imageH / 4;   // X轴方向偏移量
        T = random.nextInt(imageW * 2 - imageH + 1) + imageH;  // 周期
        w = (2 * Math.PI) / T;
        b = py - A * Math.sin(w * px + f) - imageH / 2;
        px1 = px2;
        px2 = imageW;
        for (px = px1; px <= px2; px = px + 1) {
            if (w != 0) {
                py = A * Math.sin(w * px + f) + b + imageH / 2;  // y = Asin(ωx+φ) + b
                int i = (int) (fontSize / 5);
                while (i > 0) {
                    g.drawLine((int) px + i, (int) py + i, (int) px + i + 1, (int) py + i + 1);
                    i--;
                }
            }
        }
    }

    /**
     * 画噪点
     * 往图片上写不同颜色的字母或数字
     */
    private void writeNoise(Graphics2D g) {
        String codeSet = "0123456789abcdefghijklmnopqrstuvwxyz";
        Color noiseColor;
        for (int i = 0; i < 10; i++) {
            //噪点颜色
            noiseColor = new Color(random.nextInt(106) + 150, random.nextInt(106) + 150, random.nextInt(106) + 150);
            g.setColor(noiseColor);
            for (int j = 0; j < 5; j++) {
                g.drawString(String.valueOf(codeSet.charAt(random.nextInt(codeSet.length()))), random.nextInt(imageW + 10) - 10, random.nextInt(imageH + 10) - 10);
            }
        }
    }

    /**
     * 绘制背景图片
     * 注：如果验证码输出图片比较大，将占用比较多的系统资源
     */
    private void writeBackground(Graphics2D g) throws IOException {
        String bgspath = VERIFY_PATH + "bgs" + FILE_SEPARATOR;
        File file = new File(bgspath);
        File[] tempList = file.listFiles();
        ArrayList<File> bgs = new ArrayList();
        String bgName;
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                bgName = tempList[i].toString();
                if (bgName.substring(bgName.length() - 4, bgName.length()).equals(".jpg")) {
                    bgs.add(tempList[i]);
                }
            }
        }
        bgName = bgs.get(random.nextInt(bgs.size())).toString();
        Image backgroundImage = ImageIO.read(new File(bgName));
        backgroundImage = backgroundImage.getScaledInstance(imageW, imageH, Image.SCALE_FAST);
        g.drawImage(backgroundImage, 0, 0, imageW, imageH, null);
    }

    /**
     * 加密
     *
     * @return String 加密结果
     */
    private String authcode(String str) {
        String key = md5(seKey).substring(5, 8);
        str = md5(str).substring(8, 10);
        return md5(key + str);
    }

    /**
     * MD5加密算法抽取
     *
     * @param string 待加密字符串
     * @return 加密结果
     */
    private String md5(String string) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = string.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
