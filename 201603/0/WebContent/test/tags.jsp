<%@page import="test.action.TagsAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>标签的测试</title>
<style>
	.bookitem {
		color: darkblue;
		font-size: 16px;
	}
</style>
</head>
<body>

	<h1>hello,man</h1>

	<div id="main">

		<!-- 列表的直接打印 -->
		<s:property value="booklist" />

		<hr>
		
		<!-- 列表的循环，用 iterator 迭代器 -->
		<div>
			<s:iterator status="s" value="booklist">
				<p class="bookitem">第 <s:property value="#s.count" /> 本：<s:property value="name" /> （价格为：<s:property value="price" /> 元）</p> 
			</s:iterator>
		</div>
		
		<hr>
		<div>
			<p>用 el表达式，进行值的获取</p>
			<s:iterator status="ss" value="booklist">
				<p class="bookitem">第 ${ss.count} 本：${name}（价格为：${price} 元）</p> 
			</s:iterator>
		</div>
		
		
		<hr>
		
		
		<!-- 有时在嵌套循环中，不至于发生混淆的话，需要将 property 的 value 值写全，即加上 # 和当前对象的 var 值 -->
		<div>
			<s:iterator var="b" status="s" value="booklist">
				<p class="bookitem">第 <s:property value="#s.count" /> 本：<s:property value="#b.name" /> （价格为：<s:property value="#b.price" /> 元）</p> 
			</s:iterator>
		</div>
		
		<hr>
		
		<!-- 通过 bein/end/step 用来控制，我们输出的列表的起始位置，结束位置，还有递增值 -->
		<s:iterator var="b" status="s" value="booklist" begin="4" end="5" step="1">
			<p class="bookitem">第 <s:property value="#s.count" /> 本：<s:property value="#b.name" /> （价格为：<s:property value="#b.price" /> 元）</p> 
		</s:iterator>
		
		
		<hr>
		
		<!-- 对书籍按照价格由高到低排序输出。 -->
		<!-- 首先，创建我们的比较器，即写一个类，实现 Comparator 接口 -->
		<!-- 其次，在 jsp 中，通过 s:bean 标签，声明我们的比较器。 -->
		<!-- 然后，对我们的列表进行排序，排序的标签是 s:sort，我们需要指定比较器，还有要排序的列表。 -->
		<!-- 最后，我们可以在 s:sort 标签内部对列表进行迭代等处理。当然，也可以通过 s:sort 的 var 属性，为新生成的列表建立一个引用。再其他地方就可以用 "#attr.引用名字" 对这个新的列表进行操纵了。 -->
		<!-- 下面的 s:bean 标签，相当于下面的创建对象语句 -->
		<%--
			TagsAction bc = new TagsAction();
		--%>
		<s:bean var="bc" name="com.s126.demo.test.TagsAction"></s:bean>
		
		<s:sort comparator="bc" source="booklist" var="newbooklist"></s:sort>
		<s:iterator value="#attr.newbooklist">
			<p class="bookitem"><s:property value="name" /> （价格为：<s:property value="price" /> 元）</p> 
		</s:iterator>

		<hr>
		
		<!-- 这是排序的另一种写法 -->
		<s:sort comparator="bc" source="booklist">
			<s:iterator>
				<p>书名：<s:property value="name"/> 价格： <s:property value="price"/> </p>
			</s:iterator>
		</s:sort>
		
		
		<hr>
		
		<p>列出所有价格大于 50 的所有书籍（利用OGNL表达式过滤）</p>
		<s:sort comparator="bc" source="booklist.{? price>50}">
			<s:iterator>
				<p>书名：<s:property value="name"/> 价格： <s:property value="price"/> </p>
			</s:iterator>
		</s:sort>
		
		<hr>
		
		<p>列出所有价格大于 50 的所有书籍（利用条件判断）</p>
		<s:sort comparator="bc" source="booklist">
			<s:iterator>
				<s:if test="price>50">
					<p>书名：<s:property value="name"/> 价格： <s:property value="price"/> </p>
				</s:if>
			</s:iterator>
		</s:sort>
		
		<hr>
		
		<p></p>
		<s:sort comparator="bc" source="booklist">
			<s:iterator status="st">
				<s:if test="#st.odd">
					<p style="color:red">书名：<s:property value="name"/> 价格： <s:property value="price"/> </p>
				</s:if>
				<s:else>
					<p style="color:green">书名：<s:property value="name"/> 价格： <s:property value="price"/> </p>
				</s:else>
			</s:iterator>
		</s:sort>
		
	</div>


<s:debug />
</body>
</html>