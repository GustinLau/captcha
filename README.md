# Walink验证码工具
----
根据[ThinkPHP](https://github.com/top-think/thinkphp)验证码源码翻译成的Java验证码工具  
感谢[ThinkPHP](https://github.com/top-think/thinkphp)提供验证码生成思路  

## 验证码效果图
![效果图](https://raw.githubusercontent.com/GustinLau/captcha/master/captcha.png)

## 使用
* 在resources目录下添加captcha文件夹

* Spring中配置Bean  
```xml
<bean id="captcha" class="cn.walink.code.Captcha">
        <property name="fontttf" value="0.ttf"></property>
</bean>
```
> Properties说明  
``sekey`` 验证码加密密钥  
``codeSet`` 英文验证码字符集合  
``expire`` 验证码过期时间(ms)  
``useZh`` 使用中文验证码 P.S 需要在captcha/zhttfs中添加中文字体  
``zhSet`` 中文验证码字符串(useZh为Ture时有效)  
``useImgBg`` 使用背景图片  
``fontSize`` 验证码字体大小(px)  
``useCurve`` 是否画混淆曲线  
``useNoise`` 是否添加噪点  
``imageH`` 验证码图片高度(默认根据字体大小调整)  
``imageW`` 验证码图片宽度(默认根据字体大小调整)  
``length`` 验证码位数  
``fontttf`` 验证码字体，不设置随机获取   
``bg`` 背景颜色  
``reset`` 验证成功后是否重置

* Servlet  
```java
public class CaptchaServlet extends HttpServlet {

    @Autowired
    Captcha captcha;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        captcha.generate(request, response);
    }
}
```

* web.xml配置  
```xml
<servlet>
        <servlet-name>captchaServlet</servlet-name>
        <servlet-class>cn.walink.code.servlets.CaptchaServlet</servlet-class>
        <load-on-startup>2</load-on-startup>
</servlet>
<servlet-mapping>
        <servlet-name>captchaServlet</servlet-name>
        <url-pattern>/captcha.png</url-pattern>
</servlet-mapping>
```

* 访问  
> http://localhost:8080/captcha.png

* 验证  
```java
@Controller
@RequestMapping("/captcha")
public class CaptchaController {
  @Autowired
  Captcha captcha;

  @RequestMapping("/verify")
  @ResponseBody
  public String captchaVerify(HttpServletRequest request, @RequestParam("captcha") String _captcha) {
    if (captcha.verify(request, _captcha)) {
      return "true"
    } else {
        return "false";
    }
  }
}
```
