<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp"%>
<jsp:include page="../common/top.jsp">
    <jsp:param name="title" value="学生"/>
</jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">已修课程</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名称</th>
                        <th>授课老师编号</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>周数</th>
                        <th>课程类型</th>
                        <th>学分</th>
                        <th>成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${overCourseList}" var="item">
                        <tr>
                            <td>${item.courseCustom.courseid}</td>
                            <td>${item.courseCustom.coursename}</td>
                            <td>${item.courseCustom.teacherid}</td>
                            <td>${item.courseCustom.coursetime}</td>
                            <td>${item.courseCustom.classroom}</td>
                            <td>${item.courseCustom.courseweek}</td>
                            <td>${item.courseCustom.coursetype}</td>
                            <td>${item.courseCustom.score}</td>
                            <td style="color: red">${item.mark}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pagingVO != null}">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <li><a href="/student/overCourse?page=${pagingVO.upPageNo}">&laquo;</a></li>
                                <c:choose>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage>=5}">
                                        <c:forEach begin="1" end="5" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${pagingVO.currentPageNo<=3 && pagingVO.totalPage<=5}">
                                        <c:forEach begin="1" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${(pagingVO.currentPageNo+2)<pagingVO.totalPage}">
                                        <c:forEach begin="${pagingVO.currentPageNo-2}" end="${pagingVO.currentPageNo+2}"
                                                   var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach begin="${pagingVO.totalPage-4}" end="${pagingVO.totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pagingVO.currentPageNo == i}">
                                                    <li class="disabled"><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/student/overCourse?page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                <li><a href="/student/overCourse?page=${pagingVO.nextPageNo}">&raquo;</a></li>
                                <li><a href="/student/overCourse?page=${pagingVO.totalPage}">最后一页</a></li>
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
<script>
    $("#nav li:nth-child(3)").addClass("active")
</script>
</html>