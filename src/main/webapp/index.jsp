<html>
<head>
    <title>JSON Formatter</title>
    <link rel="icon" href="resources/images/json.png">
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
<h1>JSON Formatter</h1>
<div id ="form">
    <form action="process" method="post">
        <textarea class="jsonText" name="json" placeholder="Please copy your json here..."></textarea>
        <br><br>
        <label class="large-label" for="jsonTemplate">Choose a template:</label>
        <select class="button" id="jsonTemplate" name = "template">
            <option value="compact">Compact</option>
            <option value="space-tab">Space Tab</option>
        </select>
        <br><br>
        <input class="button" type="reset" value="Clear">
        <input class="button" type="submit" value="Process">
    </form>
    <br><br>

        <% if (request.getAttribute("formattedJSON") != null) {
        %><h1>Your formatted JSON is here:</h1>
        <div id="formattedSection">
            <span id="closeButton"></span>
            <%=request.getAttribute("formattedJSON").toString()%></div><%
        }
    %>
</div>
</body>
</html>
