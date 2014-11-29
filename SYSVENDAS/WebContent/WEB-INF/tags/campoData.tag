<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true"%>

<input type="text" name="${id}" id="${id}">

<script type="text/javascript">
	$(function() {
	    $("#${id}").datepicker();
	  });
</script>
