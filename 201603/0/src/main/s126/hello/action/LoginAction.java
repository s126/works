package s126.hello.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import s126.hello.bean.Account;
import s126.hello.service.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class LoginAction extends ActionSupport {

	private String name;
	private String pwd;
	private String result;

	private Account acc = null;
	private InputStream inputStream;

	private LoginService loginService = new LoginService();

	private List<String> reslist = new ArrayList<String>();

	
	public String logout () {
		LoginService.logout();
		
		return "index";
	}
	
	
	
	/**
	 * 原生方法
	 */
	public String judgeUsername() throws IOException {
		boolean checkEname = loginService.checkEname(acc.getUsername());

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (checkEname)
			out.write("用户已存在");
		else
			out.write("可以注册");

		return null;
	}

	/**
	 * result type=stream
	 */
	public String judgeUsername2() throws IOException {

		boolean checkEname = loginService.checkEname(acc.getUsername());

		String result = checkEname ? "用户已存在" : "可以注册";

		inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));

		return SUCCESS;
	}

	/**
	 * json-plugin
	 */
	public String judgeUsername3() throws IOException {
		boolean checkEname = loginService.checkEname(acc.getUsername());
		if (checkEname)
			result = "用户已存在!";
		else
			result = "可以注册!";

		return SUCCESS;
	}

	/**
	 * 公用的验证方法。这个 Action 里面所有的请求方法，都会在执行前执行这个 validate
	 */
	@Override
	public void validate() {
		// 在这里写我们所有的公用验证逻辑。
		// 如果在其中写了 addXxxError 的方法，执行完后， struts 会跳转到 input 页面
		System.out.println("在 LoginAcion.validate()中，我们没做任何事情.");
	}

	/**
	 * 特定于 loginSubmit 方法的验证
	 */
	public void validateLoginSubmit() {
		if (name == null || name.isEmpty()) {
			addFieldError("name", "您的用户名不能为空。");
		}
		if (pwd == null || pwd.isEmpty()) {
			addFieldError("pwd", "密码太短。");
		}
	}

	/**
	 * 提交信息，进行登录
	 */
	@InputConfig(resultName = "input")
	// 可以通过 InputConfig 注解，来指定，如果在 validate 方法中出现错误的话，那么跳转到哪个 result.
	public String loginSubmit() {
		acc = loginService.checkLogin(name, pwd);
		if (acc == null) {
			return "fail";
		}
		ActionContext.getContext().getSession().put("account", acc);
		return SUCCESS;

	}

	/**
	 * 用来显示注册的页面
	 */
	public String registerIndex() {

		// 获取 request 对象。这是 struts 封装的一个 Map 类型。
		// 取 request 这么复杂，说明 struts 不建议你使用 request 对象，因为能用 request
		// 存取的数据，可以直接使用值栈存取。
		Map<String, Object> session = ActionContext.getContext().getSession();

		// 创建一个性别相关的 Map，在 jsp 中，可以这样使用
		// <s:radio label="性別" name="acc.sex" list="#request.sexmap" />
		// <s:radio label="性別" name="acc.sex" list="#request.sexmap"
		// listKey="key" listValue="value" />
		Map<Integer, String> sexmap = new HashMap<Integer, String>();
		sexmap.put(1, "m");
		sexmap.put(2, "f");
		sexmap.put(3, "u");

		// 创建一个对象列表，在 jsp 中，可以这样使用
		// <s:radio label="性別" name="acc.sex" list="#request.sexlist" value="3"
		// listKey="code" listValue="name" />
		List<Sex> sexlist = new ArrayList<Sex>();
		sexlist.add(new Sex("男", 1, "skfdjskjfdk"));
		sexlist.add(new Sex("女", 2, "skfdjskjfdk"));
		sexlist.add(new Sex("未知", 3, "skfdjskjfdk"));

		// 将变量保存在 request 中，这样在 jsp 中可以这样获取
		// ${#request.sexlist}
		// <s:property value="#request.sexmap" />
		// 有时候，我们需要把值保存在 request 或者 session 中使用。
		session.put("sexmap", sexmap);
		session.put("sexlist", sexlist);

		// 初始化处理，获取所有的身份类型，用来在 jsp 中显示
		// <s:select label="身份类型" name="acc.acctype"
		// list="#session.types"></s:select>
		ActionContext.getContext().getSession()
				.put("types", loginService.getAccTypes());

		return SUCCESS;

	}

	/**
	 * 提交注册信息
	 */
	public String registerSubmit() {
		if (!loginService.addAccount(acc))
			return "fail";
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<String> getReslist() {
		return reslist;
	}

	public void setReslist(List<String> reslist) {
		this.reslist = reslist;
	}

}

/**
 * 性别类，用作示例。一般情况下用 Map 表示性别即可。
 */
class Sex {
	private String name;
	private int code;
	private String pres;

	public Sex(String name, int code, String pres) {
		this.name = name;
		this.code = code;
		this.pres = pres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPres() {
		return pres;
	}

	public void setPres(String pres) {
		this.pres = pres;
	}
}
