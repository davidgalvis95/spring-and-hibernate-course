<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>Spring Rest Demo</h3>
    <!-- Here we are using the relative path to access the endpoint -->
    <!-- With the page cotext we are pointing to the page context where the index.jsp is saved in -->
    <a href="${pageContext.request.contextPath}/test/hello">hello</a>
    
    <a href="${pageContext.request.contextPath}/api/students">the students</a>
    
</body>
</html>