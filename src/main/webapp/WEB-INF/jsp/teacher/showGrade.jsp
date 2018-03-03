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
                        <h1 class="col-md-5">已选该课程学生名单</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>分数</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${selectedCourseList}" var="item">
                        <tr>
                            <td>${item.studentCustom.userid}</td>
                            <td>${item.studentCustom.username}</td>
                            <c:if test="${!item.over}">
                                <td>未打分</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info"
                                            onclick="location.href='/teacher/mark?studentid=${item.studentid}&courseid=${item.courseid}'">打分</button>
                                </td>
                            </c:if>
                            <c:if test="${item.over}">
                                <td>${item.mark}</td>
                                <td>已打分</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pagingVO != null}">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <li><a href="/teacher/gradeCourse?page=${pagingVO.upPageNo}">&laquo;</a></li>
                                <c:choose>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage>=5}">
                                        <c:forEach begin="1" end="5" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage<=5}">
                                        <c:forEach begin="1" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${(pagingVO.currentPageNo+2)<pagingVO.totalPage}">
                                        <c:forEach begin="${pagingVO.currentPageNo-2}" end="${pagingVO.currentPageNo+2}"
                                                   var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach begin="${pagingVO.totalPage-4}" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/teacher/gradeCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                <li><a href="/teacher/gradeCourse?page=${pagingVO.nextPageNo}">&raquo;</a></li>
                                <li><a href="/teacher/gradeCourse?page=${pagingVO.totalPage}">最后一页</a></li>
                            </ul>
                        </nav>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $("#nav li:nth-child(1)").addClass("active")
</script>
</html>
