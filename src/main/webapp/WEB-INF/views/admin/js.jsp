<%-- 
    Document   : js
    Created on : Jun 30, 2019, 1:15:53 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <body>
        <script src="<c:url value="/resources/admin/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/chart.min.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/chart-data.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/easypiechart.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/easypiechart-data.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/bootstrap-datepicker.js"/>"></script>
        <script src="<c:url value="/resources/admin/js/bootstrap-table.js"/>"></script>
        <script>
            $('#calendar').datepicker({
            });

            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>
    </body>
</html>
