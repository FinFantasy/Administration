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
                        <h1 class="col-md-5">教师名单管理</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;"
                              action="/admin/selectTeacher" id="form1" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
                                <span class="input-group-addon btn" onclick="document.getElementById('form1').submit"
                                      id="sub">搜索</span>
                            </div>
                        </form>
                        <button class="btn btn-default col-md-2" style="margin-top: 20px"
                                onClick="location.href='/admin/addTeacher'">
                            添加教师信息
                            <sapn class="glyphicon glyphicon-plus"/>
                        </button>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>教师编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>出生年份</th>
                        <th>学历</th>
                        <th>职称</th>
                        <th>入职年份</th>
                        <th>学院</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${teacherList}" var="item">
                        <tr>
                            <td>${item.userid}</td>
                            <td>${item.username}</td>
                            <td>${item.sex}</td>
                            <td><fmt:formatDate value="${item.birthyear}" dateStyle="medium" /></td>
                            <td>${item.degree}</td>
                            <td>${item.title}</td>
                            <td><fmt:formatDate value="${item.grade}" dateStyle="medium" /></td>
                            <td>${item.collegeName}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='/admin/editTeacher?id=${item.userid}'">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary"
                                        onClick="location.href='/admin/removeTeacher?id=${item.userid}'"
                                        onsubmit="return confirmed()">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pagingVO != null}">
                        <nav style="text-align: center">
                            <ul class="pagination" id="pagination">
                                <li><a href="/admin/showTeacher?page=${pagingVO.upPageNo}">&laquo;</a></li>
                                <c:choose>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage>=5}">
                                        <c:forEach begin="1" end="5" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage<=5}">
                                        <c:forEach begin="1" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${(pagingVO.currentPageNo+2)<pagingVO.totalPage}">
                                        <c:forEach begin="${pagingVO.currentPageNo-2}" end="${pagingVO.currentPageNo+2}"
                                                   var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach begin="${pagingVO.totalPage-4}" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/admin/showTeacher?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                <li><a href="/admin/showTeacher?page=${pagingVO.nextPageNo}">&raquo;</a></li>
                                <li><a href="/admin/showTeacher?page=${pagingVO.totalPage}">最后一页</a></li>
                            </ul>
                        </nav>
                    </c:if>
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
    $("#nav li:nth-child(3)").addClass("active")
    function confirmed() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });
</script>
</html>
