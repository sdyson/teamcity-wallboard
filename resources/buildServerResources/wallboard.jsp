<%@ include file="/include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="60">
        <title>TeamCity Wallboard</title>
        <link rel="stylesheet" type="text/css" href="/plugins/wallboard/wallboard.css"/>
    </head>
    <body>
        <%--@elvariable id="model" type="jetbrains.wallboard.model.WallboardModelImpl"--%>
        <%--@elvariable id="project" type="jetbrains.wallboard.model.ProjectModelImpl"--%>
        <%--@elvariable id="build" type="jetbrains.wallboard.model.BuildModelImpl"--%>
        <c:forEach items="${model.projects}" var="project">
            <c:if test="${project.active}">
                <div class="project project-${project.status}">
                    <div class="project-name">${project.name}</div>
                    <div class="project-builds">
                        <c:forEach items="${project.builds}" var="build">
                            <%--<c:if test="${build.active}">--%>
                                <c:set var="classes" value="build build-${build.status}"/>
                                <c:if test="${!empty build.responsible}">
                                    <c:set var="classes" value="${classes} build-has-responsible"/>
                                </c:if>
                                <div class="${classes}">
                                    <div class="build-name">${build.name}</div>
                                    <%--<div class="build-date"><fmt:formatDate value="${build.buildDate}" pattern="dd MMM yy HH:mm"/></div>--%>
                                    <c:if test="${build.buildStatus.failed}">
                                        <div class="build-time-broken">${build.timeBroken}</div>
                                    </c:if>
                                    <c:if test="${!empty build.pendingChanges}">
                                        <div class="build-pending-changes">${build.pendingChanges}</div>
                                    </c:if>
                                    <c:if test="${build.running}">
                                        <div class="build-running">&#x25B6;</div>
                                    </c:if>
                                    <c:if test="${!build.active}">
                                        <div class="build-paused">&#x25FC;</div>
                                    </c:if>
                                    <c:if test="${!empty build.responsible}">
                                        <div class="build-responsible">${build.responsible}</div>
                                    </c:if>
                                </div>
                            <%--</c:if>--%>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </body>
</html>