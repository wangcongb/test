<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"  "http://www.w3.org/TR/html4/strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head></head>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
	<body style="font-size:20px;">
	<h2>操作员信息</h2>
<form name="f1" id="f1" method="post" action="query" >	
<div id="页面中部_右边_查询" style="padding:0">&nbsp;
	<div>
	<input type="button" value="增加查询条件" onclick="add()" id="addconditions"/>
	<input type="button" value="查询" onclick="search()" />
	<input type="hidden" name="condition" id="params" value=""/> 
	<input type="hidden" name="column" id="col" value=""/> 
	<div id="query">
	<div >
	<select type="select" name="Item" >
	<option value=""> 请选择 </option>
    <option value="user_id"> 操作员编号 </option>
    <option value="user_name"> 姓名</option>
    <option value="user_state"> 操作员状态</option>
    <option value="dept_id"> 部门ID</option>
    <option value="dept_name"> 部门名称</option>
    <option value="passwd"> 密码</option>
    <option value="crt_user"> 创建操作员</option>
    <option value="crt_date"> 创建日期</option>
    <option value="user_tel"> 操作员联系电话</option>
    <option value="email"> Email地址</option>
   </select> 
<select type="select" name="sypol" >
<option value=""> 请选择 </option>
    <option value=" > "> > </option>
    <option value=" = "> =  </option>
    <option value=" < "> < </option>
    <option value="like"> like</option>
   </select> 
<input type="text" id="param" name="texts" value=""/> 

</div>

</div>
<div>
请选择需要显示的列(不选择默认显示全部)<br />
<label><input name="colu" type="checkbox" value="user_id" />操作员编号 </label> 
<label><input name="colu" type="checkbox" value="user_name" />姓名 </label> 
<label><input name="colu" type="checkbox" value="user_state" />操作员状态 </label> 
<label><input name="colu" type="checkbox" value="dept_id" />部门id </label>
<label><input name="colu" type="checkbox" value="dept_name" />部门名称 </label>
<label><input name="colu" type="checkbox" value="passwd" />密码 </label>
<label><input name="colu" type="checkbox" value="crt_user" />创建操作员 </label>
<label><input name="colu" type="checkbox" value="crt_date" />创建日期</label>
<label><input name="colu" type="checkbox" value="user_tel" />操作员联系电话 </label>
<label><input name="colu" type="checkbox" value="email" />Email地址 </label>
<label><input name="colu" type="checkbox" value="str_remark" />备注 </label>
</div>
</div>
	
</div>
	<table border=“1”>
		<tr>
			<td>序号</td>
			<td>操作员编号</td>
			<td>姓名</td>
			<td>操作员状态</td>
			<td>部门ID</td>
			<td>部门名称</td>
			<td>密码</td>
			<td>创建操作员</td>
			<td>创建日期</td>
			<td>操作员联系电话</td>
			<td>Email地址</td>
			<td>备注</td>
		</tr>
	<c:forEach items="${result}" var="e" 
		varStatus="stat">
		<tr>
			<td>${stat.count }</td>
		<c:if test="${!e.user_id}"><td>${e.user_id }</td></c:if>
		<c:if test="${!e.user_name}"><td>${e.user_name }</td></c:if>
		<c:if test="${!e.user_state}"><td>${e.user_state }</td></c:if>
		<c:if test="${e.dept_id>0}"><td>${e.dept_id }</td></c:if>
		<c:if test="${!e.dept_name}"><td>${e.dept_name }</td></c:if>
		<c:if test="${!e.passwd}"><td>${e.passwd }</td></c:if>
		<c:if test="${!e.crt_user}"><td>${e.crt_user }</td></c:if>
		<c:if test="${!e.crt_date}"><td>${e.crt_date }</td></c:if>
		<c:if test="${!e.user_tel}"><td>${e.user_tel }</td></c:if>
		<c:if test="${!e.email}"><td>${e.email }</td></c:if>
		<c:if test="${!e.str_remark}"><td>${e.str_remark }</td></c:if>
			
		</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>
<script type="text/javascript">

function add(){
	var strhtml="<div >"+
	"<select type=\"select\" name=\"Item\">"+
	"<option value=\"\"> 请选择 </option>"+
    "<option value=\"user_id\"> 操作员编号 </option>"+
    "<option value=\"user_name\"> 姓名</option>"+
    "<option value=\"user_state\"> 操作员状态</option>"+
    "<option value=\"dept_id\"> 部门ID</option>"+
    "<option value=\"dept_name\"> 部门名称</option>"+
    "<option value=\"passwd\"> 密码</option>"+
    "<option value=\"crt_user\"> 创建操作员</option>"+
    "<option value=\"crt_date\"> 创建日期</option>"+
    "<option value=\"user_tel\"> 操作员联系电话</option>"+
    "<option value=\"email\"> Email地址</option>"+
   "</select> "+
"<select type=\"select\" name=\"sypol\" >"+
"  <option value=\"\"> 请选择 </option>  "+
    "<option value=\">\"> > </option>"+
    "<option value=\"=\"> =  </option>"+
    "<option value=\"<\"> < </option>"+
    "<option value=\"like\"> like</option>"+
   "</select>"+ 
"&nbsp;<input type=\"text\"  name=\"texts\" value=\"\"/>"+ 
"&nbsp;<input type=\"button\" value=\"删除\" onclick=\"del(this)\" />"+
"</div>";
	$("#query").append(strhtml);
}
function del(item){
$(item).parent().remove();

}
function search(){

var columns="";
var columns2="";
var nums=$("input[name='colu']").length-1;
$("input[name='colu']").each(function(a,b){
	if(b.checked){
		columns+=$(b).val()+",";
	}
		columns2+=$(b).val()+",";
	});
	
	if(columns==""){
		$("#col").val(columns2);
	}else{
		$("#col").val(columns);
	}


var params="";
var k=$("#query").children().length-1;
var flag="true";
$("#query").children().each(function(i,j){
	var param1=$(j).children().eq(0).val();
	var param2=$(j).children().eq(1).val();
	var param3=$(j).children().eq(2).val();
	if(""==param1||""==param2||""==param3){
		flag="false";
		alert("查询条件不可为空");
		return;
	}
	params+=param1+" "+param2;
	if($(j).children().eq(1).val()=="like"){
		params+=" '%"+param3+"%' "
	}else{
		params+=param3;
	}
	if(i<k){
	params+=" and ";
	}
});
$("#params").val(params);
if(flag=="true"){
f1.submit();
}

}
</script>