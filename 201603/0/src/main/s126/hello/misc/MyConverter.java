package s126.hello.misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyConverter extends DefaultTypeConverter {
	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		//return super.convertValue(context, value, toType);
		
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


class DemoConv extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}
	
}



