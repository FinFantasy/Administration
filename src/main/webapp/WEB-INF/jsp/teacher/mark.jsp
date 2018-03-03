<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp"%>
<jsp:include page="../common/top.jsp">
    <jsp:param name="title" value="教师"/>
</jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">学生打分</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form name="reset" class="form-horizontal" role="form" action="/teacher/mark" id="editform"
                          method="post" onsubmit="return check()">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <input readonly="readonly" type="hidden" class="form-control" name="courseid"
                                       id="inputId" value="${selectedCourse.courseid}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="StuId" class="col-sm-2 control-label">学号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" name="studentid"
                                       id="StuId" value="${selectedCourse.studentid}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Grade" class="col-sm-2 control-label">成绩</label>
                            <div class="col-sm-10">
                                <input type="number" name="mark" class="form-control" id="Grade"
                                       placeholder="请输入成绩">
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
    <div class="container" id="footer">
        <div class="row">
            <div class="col-md-12"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $("#nav li:nth-child(1)").addClass("active")
    function check() {
        if(reset.mark.value==""||reset.mark.value==null)
        {alert("请输入成绩");return false;}
    }
</script>
</html>
