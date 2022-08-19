# microservice-application

Set up of 3 different services :

# @CONFIGURATION SERVICE

- This one will be called by every new instance of the microservices
in order for them to laod their configuration (.properties file) once it starts
- Those file are directly stored in a git repo so that everytime the config 
changes we can refresh the scope
- The .properties file of every service are loaded inside of the git repo

# @REGISTER SERVICE

- It has all the location of every instance of each sercives 
- ip adresses + port -> http://localhost:port
- It is directly called by the proxy in order to redirect the rest call to the right service
- When a service starts, he published is reference

# @GETWAY SERVICE

- This one is used to orchestrate 
- Once a client (mobile, web, ..) this service is going to ask to the register service the address
of the service requested by the client since in the URL of the HTTP Request we have the name of 
the service, and thus, its reference

# @SOMETHING IMPORTANT TO NOTICE

Here, in our set up :

REQ 1 : GET http://localhost/proxy/company-service/companies
REQ 2 : GET http://localhost/proxy/company-service/companies
REQ N : GET http://localhost/proxy/company-service/companies

The proxy handles the scalability of the whole application
So, the more request we have on the same service, the more instance will be created on a different port
by the proxy through containers, in order not to slow the server responce, and to not overload the server.

I also added the actuator in my service in order to fetch the health state of my service, or the httptrace
that could be also very important.

I added a rest service in the company service : @Getmapping("/myConfif")
in which I added the thread name of the process, so here we can see that if we refresh this page a big 
times, we will have a different thread.

In order to manage the load rises, the proxy calculate the time from the request to the response, and if its
too high, it will send a notification to the cloud architecture (kubernetes for exemple) in order to notify
that a new instance of the service should be deployed.

@HugoCOSSA





