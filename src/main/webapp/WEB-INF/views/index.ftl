<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"] />
<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><@layout.block name="title">ToDoList</@layout.block></title>

    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
        var $resourcesRoot = "<@c.url value="/resources/" />";
    </script>

<@layout.block name="css_head">
    <!-- Bootstrap Styles-->
    <link href="<@c.url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<@c.url value="/resources/css/bootstrap-datepicker.css" />" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

    <style type="text/css">
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</@layout.block>
<@layout.block name="js_head">

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/jquery-1.10.2.js" />"></script>
    <!-- Bootstrap Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/bootstrap.min.js" />"></script>
    <!-- Bootstrap datepicker Js -->
    <script type="text/javascript" src="<@c.url value="/resources/js/lib/bootstrap-datepicker.js" />"></script>



</@layout.block>
</head>

<body>
<!-----------Content---------------->

    <@layout.block name="content">

        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Welcome to AutoSalon ;)</h1>
                </div>

            </div>
        </div>



    </@layout.block>
</body>


</html>