# BankReimbursement
Rev p1 Reimbursement
Overview
A Web Application built using Java Servelets, Apache Tomcat, and Bootstrap 5 which allows for the handling of expense reimbursements.

## Technologies
- Apache-Tomcat-9.0.41
- Bootstrap 5
- Jackson Databind
- Jackson Core
- Java Servlet API 4.0.1
- JUnit 4.12
- Log4j API 1.2.17
- PostgreSQL 42.2.18
- Mockito 1.10.19
- JavaMail 1.6.2

## Features
- Submit a reimbursement request
- Approve/ Deny a reimbursement request
- Add items to your request
- Sends out confirmation emails for each ticket submission

## Getting Started / Usage
In order to see this project in action, you will need a few things:

Be sure to have Apache Tomcat 9.0.41 installed.
Be sure to have the Java 8 runtime environment installed.
If both of the pre-requisites above are met, go ahead and clone this repo by using the below command:

    git clone https://github.com/chh14025/BankReimbursement
Once cloned, copy the .war file located within the /target directory and paste it into your tomcat webapps folder.

Once the .war has been exploded, by default you will be able to view the application at http://localhost:8080/ReimbursementProject/bank

Contributors
William He
