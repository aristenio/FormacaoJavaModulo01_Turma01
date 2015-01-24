<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript" src="resources/jquery-ui-1.11.2/external/jquery/jquery.js"></script>
	<script type="text/javascript" src="resources/jquery-ui-1.11.2/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="resources/jquery-ui-1.11.2/jquery-ui.min.css">
	<link rel="stylesheet" href="resources/css/960.css" type="text/css" media="screen" charset="utf-8" />
	<link rel="stylesheet" href="resources/css/template.css" type="text/css" media="screen" charset="utf-8" />
	<link rel="stylesheet" href="resources/css/colour.css" type="text/css" media="screen" charset="utf-8" />
	<!--[if IE]><![if gte IE 6]><![endif]-->
	<script src="resources/js/glow/1.7.0/core/core.js" type="text/javascript"></script>
	<script src="resources/js/glow/1.7.0/widgets/widgets.js" type="text/javascript"></script>
	<link href="resources/js/glow/1.7.0/widgets/widgets.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		glow.ready(function(){
			new glow.widgets.Sortable(
				'#content .grid_5, #content .grid_6',
				{
					draggableOptions : {
						handle : 'h2'
					}
				}
			);
		});
	</script>
</head>
<body>
		<h1 id="head">SYSVENDAS  - Cepep Formação Java I</h1>
		
		<ul id="navigation">
			<li><a href="menu"><span class="active">Inicio</span></a></li>
			<li><a href="logout">Sair</a></li>
		</ul>

</body>
</html>