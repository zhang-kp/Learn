#### Utils



构造 BigDecimal 对象常用以下方法:

BigDecimal BigDecimal(double d); //不允许使用

BigDecimal BigDecimal(String s); //常用,推荐使用

```java


Bigdecimal 创建对象：

public static void main(String[] args) {
	double d1 = 0.10334;
	double d2 = 1234.0;
	
	System.out.println("new BigDecimal("+d1+")=" + new BigDecimal(d1)); //此种方式绝对不允许!!!!!
	System.out.println("new BigDecimal("+d2+")=" + new BigDecimal(d2)); //此种方式绝对不允许!!!!!
	System.out.println("");
	
	System.out.println("new BigDecimal(String.valueOf("+d1+"))=" + new BigDecimal(String.valueOf(d1)));
	System.out.println("new BigDecimal(String.valueOf("+d2+"))=" + new BigDecimal(String.valueOf(d2)));
	System.out.println("");
	
	System.out.println("new BigDecimal(String.valueOf("+d1+"))=" + new BigDecimal(Double.toString(d1)));
	System.out.println("new BigDecimal(String.valueOf("+d2+"))=" + new BigDecimal(Double.toString(d2)));
	System.out.println("");
	
	System.out.println("BigDecimal.valueOf("+d1+")=" + BigDecimal.valueOf(d1));
	System.out.println("BigDecimal.valueOf("+d2+")=" + BigDecimal.valueOf(d2));
	System.out.println("");
 
	BigDecimal b1 = BigDecimal.valueOf(1);
	BigDecimal b2 = BigDecimal.valueOf(1.00000);
	System.out.println(b1.equals(b2));
	System.out.println(b1.compareTo(b2));
}


输出：
new BigDecimal(0.10334)=0.10334000000000000130118138486068346537649631500244140625
new BigDecimal(1234.0)=1234
 
new BigDecimal(String.valueOf(0.10334))=0.10334
new BigDecimal(String.valueOf(1234.0))=1234.0
 
new BigDecimal(String.valueOf(0.10334))=0.10334
new BigDecimal(String.valueOf(1234.0))=1234.0
 
BigDecimal.valueOf(0.10334)=0.10334
BigDecimal.valueOf(1234.0)=1234.0
 
false
0

```

**对于BigDecimal的大小比较，用equals方法的话会不仅会比较值的大小，还会比较两个对象的精确度**，而compareTo方法则不会比较精确度，只比较数值的大小。





#### 获取请求的IP地址

```java
    private static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

```





#### JSON 字段为null 不显示 

```
@JsonInclude(JsonInclude.Include.NON_NULL)
```







