<%-- 
    Document   : addcategory
    Created on : Jun 27, 2019, 4:00:09 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Email</title>
        <jsp:include page="static.jsp"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Mailing</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Mailer</h1>
                </div>
            </div><!--/.row-->
            <div class="row">
                <strong>${messageObj}</strong>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Send Email</div>
                        <div class="panel-body">
                            <div class="col-md-6">
                                <form  id="sendEmailForm" action="<c:url value="/Admin/sendEmail?${_csrf.parameterName}=${_csrf.token}"/>" method="post"  enctype="multipart/form-data">

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <div class="form-group">
                                        <label>Email to</label>
                                        <input class="form-control" id="receiverMail" type="text" name="mailTo" size="65" >
                                        <p class="help-block">${error_title}</p>
                                    </div>

                                    <div class="form-group">
                                        <label>Subject </label>
                                        <input class="form-control"  id="mailSubject" type="text" name="subject" size="65">
                                        <p class="help-block">${error_tag}</p>
                                    </div>

                                    <div class="form-group">

                                        <textarea id="mailMessage" cols="50" rows="10" name="message" placeholder="Message"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Attachment</label>
                                        <input id="mailAttachment" type="file" name="attachFileObj" size="60" />
                                    </div>



                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default">Reset Button</button>
                                </form>
                            </div>


                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div><!--/.main-->
        <jsp:include page="js.jsp"/>
    </body>
</html>
