<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>Product Page</title>
</head>
<body>

<h1>Product Page</h1>
<h2>Public Products</h2>
<ul>
    <#list public as product>
        <li>${product}</li>
    </#list>
</ul>

</body>
</html>
