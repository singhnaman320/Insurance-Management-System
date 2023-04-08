
<h1 align="center">[] Insurance Management System []</h1>
<h2>Project Overview:</h2>
<p align="justify"> Insurance Management System is a backend project providing REST API for managing all the client details, policy details as well as claim details. This API can perform all the CRUD operations with proper validation at every step.

<h2>Main Features:</h2>
The main features developed in this application are as follows:</p>

<h3>[] Client Module :</h3>
<li>The client module will provide a broader view to create, delete and track all the client details present according to the information registered and their policy claims.</li><br></br>
<img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/client.png?raw=true">

<h3>[] Policy Module :</h3>
<li>The policy module will allow us to create, delete and track all the policy details present according to the policy registered and the client related to it.</li><br></br>
<img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/Insurance%20policy.png?raw=true">

<h3>[] Claim Module :</h3>
<li>The claim module will allow us to create, delete and track all the claim details present according to the policy registered and the client owning that policy.</li><br></br>
<img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/claim.png?raw=true">

<hr>


<h2>Tech-Stacks and Tools:</h2>
<table width = 100%>
<tbody>
<tr valign="top">
<td width="30%" align="center">
<h3 dir="auto"><span>Spring Tool Suite</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/spring%20Tool%20Suite.jpg?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>JAVA</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/java.png?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>MySQL</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/MySQL.png?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>SpringBoot</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/SpringBoot.png?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>Maven</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/Maven.png?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>Hibernate</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/Hibernate.png?raw=true" height = "80" width = "80"></a>
</td>
<td width="30%" align="center">
<h3 dir="auto"><span>Swagger</span><br><br></h3>
<a><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/Swagger.png?raw=true" height = "80" width = "80"></a>
</td>
</tr>
</td>
</tr>
</tbody>
</table>



<hr>

<h2>Application Structure:</h2>
<img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/FolderFormat.png?raw=true">
<hr>

<h2>MySQL Entity Relationship Schema:</h2>
<p align="center"><img src="https://github.com/singhnaman320/Insurance-Management-System/blob/master/Application%20PNG/ER-Diagram.png?raw=true"></p>

<hr>


 <h2 id="installation-run">Installation &amp; Run</h2>
    <ul>
        
        <li>Step-1: Before running the REST API server(example: Tomcat), update the database configuration inside the <a href="https://github.com/singhnaman320/Insurance-Management-System/blob/master/InsuranceManagementSystem/src/main/resources/application.properties">application.properties</a>
            file.</li>
        <li>Step-2: Update your port number, database name, username and password as per your local configuration.</li>
        <li>NOTE: Taking the same database name is not important as here database specific properties are dynamic in nature. If you want to take a different database name then also your application will work fine.</li>
        <li>Step-3: Start the server by running SpringBoot application.</li>
        <li>Step-4: Use API platform such as Postman to send and retrieve your data in form of request. You can also use Swagger for the same.</li>
        <li>Step-5: After confirming the proper working of all the modules, stop the server again.</li>
    </ul>
    <pre>
        <code>
            server.port=<span class="hljs-number">8088</span>
            <br>
            #database specific properties
            spring<span>.datasource</span><span>.url</span>=jdbc:mysql:<span>//${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:InsuranceManagementDatabase};</span>
            spring<span>.datasource</span><span>.driver-class-name</span>=com<span>.mysql</span><span>.cj</span><span>.jdbc</span><span>.Driver</span>
            spring<span>.datasource</span><span>.username</span>=${DB_USERNAME:root}
            spring<span>.datasource</span><span>.password</span>=${DB_PASSWORD:King@32911}
            <br>
            #ORM s/w specific properties
            spring<span>.jpa</span><span>.hibernate</span><span>.ddl-auto</span>=update
            spring<span>.jpa</span><span>.show-sql</span>=true
            <br>
            #For handling exception in validation
            spring<span>.mvc</span><span>.throw</span><span>-exception</span><span>-if</span><span>-no</span><span>-handler</span><span>-found</span><span>=true</span>
            spring<span>.web</span><span>.resources</span><span>.add</span><span>-mappings</span>=false
        </code>
    </pre>
    
