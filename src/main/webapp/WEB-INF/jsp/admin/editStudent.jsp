<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp"%>
<jsp:include page="../common/top.jsp">
    <jsp:param name="title" value="管理员"/>
</jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center">修改学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/admin/editStudent" id="editform" method="post">
                        <div class="form-group">
                            <label for="studentid" class="col-sm-2 control-label">学号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="number" class="form-control" id="studentid"
                                       name="userid" value="${student.userid}" placeholder="请输入学号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username" name="username"
                                       value="${student.username}" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="男" checked>男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="女">女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthyear" class="col-sm-2 control-label">出生年份</label>
                            <div class="col-sm-10">
                                <input type="date" id="birthyear" name="birthyear" value="<fmt:formatDate
                                value="${student.grade}" dateStyle="medium" pattern="yyyy-MM-dd"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="grade" class="col-sm-2 control-label">入学时间</label>
                            <div class="col-sm-10">
                                <input type="date" id="grade" name="grade" value="<fmt:formatDate
                                value="${student.grade}" dateStyle="medium" pattern="yyyy-MM-dd"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="collegeid" class="col-sm-2 control-label">所属院系</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="collegeid" name="collegeid">
                                    <c:forEach items="${collegeList}" var="item">
                                        <option value="${item.collegeid}">${item.collegename}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $("#nav li:nth-child(2)").addClass("active")
    var collegeSelect = $("#collegeid option");
    for (var    i=0; i < collegeSelect.length; i++) {
        if (collegeSelect[i].value == '${student.collegeid}') {
            collegeSelect[i].selected = true;
        }
    }
</script>
</html>

