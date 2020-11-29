<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/11/28
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath }/statics/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${pageContext.request.contextPath }/statics/js/nprogress.js"></script>
    <!-- jQuery custom content scroller -->
    <script src="${pageContext.request.contextPath }/statics/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath }/statics/js/custom.min.js"></script>
    <!-- validator -->
    <%--     <script src="${pageContext.request.contextPath }/statics/js/validator.js"></script> --%>
    <!-- dropzone -->
    <script src="${pageContext.request.contextPath }/statics/js/dropzone.js"></script>

    <script type="text/javascript">
        $(function () {
                $.ajax({
                    url:"http://localhost:8080/AppPlatform/dev/flatform/dictionary/queryappstatus",
                    method:"get",
                    success:function (result) {
                        alert(1);
                    }
                })
        })
    </script>
</head>
<body>
  <button id="aa">ajax</button>
  <h1>${sessionScope.statusList[0].valueName}</h1>
</body>
</html>
