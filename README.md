# Distributed-systems-RMI-Project
4th year Semester 1 Ditributed systems module Project
The following are instructions to complete the project for the module Distributed Systems for 2017

## Overview
<p>In this Project you are required to use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary
lookup service. A JSP page should provide users with the ability to specify a string which will be checked
against the dictionary. The HTML form information should be dispatched to a servlet that adds the client request
to an in-queue and then returns a job ID to the web client. The web client should poll the web server periodically
(every 10 seconds) and query if the request has been processed. Client requests in the inQueue should
be periodically removed and processed (every 10 seconds).
 <br><br>
 
The processing of a client request will require a RMI method invocation to a remote object which implements
an interface called DictionaryService. The remote object which implements DictionaryService should check
if the string received exists in the dictionary, and return the dictionary definition of the string if it does exist in
the dictionary, or “String not found” if it does not exist in the dictionary. Once the result of the dictionary lookup
has been computed by the remote object, the returned response should be added to the outQueue on the Tomcat
server and returned to the original web client when they next poll the server. The following diagram depicts the
overall system architecture:</p>
<img src="https://github.com/gtonra89/Distributed-systems-RMI-Project/blob/master/architecture.png?raw=true?raw=true" align="middle"/>

## Minimum Requirements 
You are required to use the RMI framework to implement the dictionary lookup service. Your implementation
should include the following features:<br>
1. A web client request should be placed in a message queue to await processing. Each request should be
allocated a job number. The job number should be added to an inQueue (a Map) along with the request
string. The servlet handler should return the job number to the client which in turn should poll the server
every 10 seconds for a response. When a response is received with a completed task, the result of the
dictionary lookup should be displayed in the browser.<br><br>
2. An interface called DictionaryService should expose a remote method with the following signature:
public String lookup(String s) throws RemoteException;
where s is the string to lookup in the dictionary, and the String returned is either the dictionary definition
of s or the text “String not found”. In the DictionaryServiceImpl, before looking up the query string in
the dictionary the thread should be put to sleep for a time, i.e. Thread.sleep(1000), to slow the service
down and simulate a real asynchronous service

## Prerequisites & Technologies used

<img src="https://github.com/gtonra89/Distributed-systems-RMI-Project/blob/master/Eclipse-Neon-300x200.jpg?raw=true" align="left"/>
<img src="https://github.com/gtonra89/Distributed-systems-RMI-Project/blob/master/apache-tomcate-web-server-online-training.jpg?raw=true" align="left"/>
<br><br><br><br><br><br>
Eclipse Java EE I used Neon version :<br>https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3
<br>Apache Tomcat 9.0 :<brhttps://tomcat.apache.org/download-90.cgi

## Download Tomcat9.0
1.Have project open in Eclipse<br>
2.Go to Window -> Preferences<br>
3.Type in server -> Runtime environment<br>
4.Add -> Apache Tomcat v9.0<br>
5.Then go back & Go to Project -> Properties<br>
6.Java Build Path -> Libraries -> Add Library -> Server Runtime -> Apache Tomcat v9.0 -> Finish -> Apply<br>

## How to Run
1.Clone the repository to your machine.<br>
2.Extract the Zip
3.Import the unzipped folder from eclipse.<br>
4.Go to the src folder and run "DictionaryServer.java" file as a Java Application.<br>
5.Then go to the Dynamic Web Application and run "home.jsp" file on the server.<br>
6.Go to the web brower on your machine or on Eclipse and the webpage will be there 
Search for a word<br>



