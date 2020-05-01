Maven Based SpringBoot Testproject which will be running on port 9091 on http.
As part of this app, total 4 rest API end points are implemented. Below are the details about them:

APIs which are available for all:
1. POST http://{{service-ip}}/api/add
2. POST http://{{service-ip}}/api/diff



APIs which needs basic authentication. 
1. POST http://{{service-ip}}/api/secured/add
2. POST http://{{service-ip}}/api/secured/diff

Please use below user creditials to consume above APIs (same configured as in memory authentication):
Username: user
Password: password


Update: May 1, 2020
Added audit functionality. Used Spring Data JPA and H2 datebase (in-memory database) to implement this.
To get all the transactions details, added below REST endpoint.

POST http://{{service-ip}}/api/transactions
