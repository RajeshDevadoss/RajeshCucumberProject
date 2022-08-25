#Author: Rajesh

Feature: Login as a student and Upload product then approve,decline and verify the status of all the certificate

@studentLogin
Scenario Outline: login student with the id and phone number and upload certificate
Given Student should login with id and mobile number
When click on co-curricular achievement dropdown and click certifications button
Then fill the certification "<Title>" , "<Industry>" , "<StatementPurpose>" and upload certificate
And click on logout button

Examples:
|Title|Industry|StatementPurpose|
|Desktop|Product|This is a Laptop|
|Airpod|Product|This is a Headset|
|Speaker|Product|This is a Mobile|

@adminLogin
Scenario: login to admin page approve certificate
Given login to admin with emailId and password
When click on co-curricular drop down button from admin page and click certification button
Then click pending button and search for a student with Id
When select certificate and click approve button
Then click logout button on admin page

@adminLogin
Scenario: login to admin page decline certificate
Given login to admin with emailId and password
When click on co-curricular drop down button from admin page and click certification button
Then click pending button and search for a student with Id
When select certificate and click decline button
Then click logout button on admin page

@adminLogin
Scenario: login to admin page and verify pending certificate
Given login to admin with emailId and password
When click on co-curricular drop down button from admin page and click certification button
Then click pending button and search for a student with Id
And verify the certificate title
Then click logout button on admin page

@adminLogin
Scenario: login to admin page and verify approved certificate
Given login to admin with emailId and password
When click on co-curricular drop down button from admin page and click certification button
Then click approved button and search for a student with Id
And verify the certificate title
Then click logout button on admin page

@adminLogin
Scenario: login to admin page and verify decline certificate
Given login to admin with emailId and password
When click on co-curricular drop down button from admin page and click certification button
Then click decline button and search for a student with Id
And verify the certificate title
Then click logout button on admin page