'Referral Service'

The intention of this simple Spring Boot application is to demonstrate a very simple use case - use MapStruct and MyBatis framework with PostgreSQL

The service allows creation and retieval of a Referral. A referral can be created by supplying a given name value (JSON request) to the service, as guided in the file src/env/Steps.

There 03 usable Spring profiles:
- local: uses H2 database (this is the default profile)
- dev: uses PostgreSQL database (on localhost)
- dockerize: uses PostgreSQL database (on Docker container)