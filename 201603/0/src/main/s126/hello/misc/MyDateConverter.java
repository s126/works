package s126.hello.misc;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DateConverter;

@SuppressWarnings("rawtypes")
public class MyDateConverter extends DateConverter {

	// 实现我们自定义的转换
	// 实际上我们需要继承 StrutsTypeConverter，然后覆写里面的方法。DateConverter 是 struts 默认的日期转换器。
	// 自己的日期转换，请自行完成。
	@Override
	public Object convertValue(Map<String, Object> arg0, Object value,
			Member arg2, String arg3, Object arg4, Class toType) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (toType == Date.class) { // 当字符串向Date类型转换时
				String[] params = (String[]) value;
				return sdf.parseObject(params[0]);
			} else if (toType == String.class) { // 当Date转换成字符串时
				Date date = (Date) value;
				return sdf.format(date);
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
