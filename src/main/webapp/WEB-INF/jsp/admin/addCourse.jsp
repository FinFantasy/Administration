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
                        <h1 style="text-align: center">添加课程信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/admin/addCourse" id="editform" method="post">
                        <div class="form-group">
                            <label for="courseid" class="col-sm-2 control-label">课程号</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="courseid" name="courseid"
                                       placeholder="请输入课程号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="coursename" class="col-sm-2 control-label">课程名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="coursename" name="coursename"
                                       placeholder="请输入课程名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="teacherid" class="col-sm-2 control-label">授课老师编号</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="teacherid" id="teacherid">
                                    <c:forEach items="${teacherList}" var="item">
                                        <option value="${item.userid}">${item.username}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="coursetime" class="col-sm-2 control-label">上课时间</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="coursetime" id="coursetime"
                                       placeholder="请输入上课时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="classroom" class="col-sm-2 control-label">上课地点</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="classroom" id="classroom"
                                       placeholder="上课地点">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="courseweek" class="col-sm-2 control-label">周数</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="courseweek" id="courseweek"
                                       placeholder="请输入周数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="coursetype" class="col-sm-2 control-label">课程的类型：</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="coursetype" id="coursetype">
                                    <option value="必修课">必修课</option>
                                    <option value="选修课">选修课</option>
                                    <option value="公共课">公共课</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="collegeid" class="col-sm-2 control-label">所属院系</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="collegeid" id="collegeid">
                                    <c:forEach items="${collegeList}" var="item">
                                        <option value="${item.collegeid}">${item.collegename}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="score" class="col-sm-2 control-label">学分：</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="score" id="score"
                                       placeholder="请输入学分">
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
    $("#nav li:nth-child(1)").addClass("active")
</script>
</html>