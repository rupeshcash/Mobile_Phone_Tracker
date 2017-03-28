# Mobile_Phone_Tracker
This project solves the simplified version of mobile phone tracking problem i.e, the
fundamental problem of cellular networks: When a phone is called, and where
it is located so that a connection may be established.


The project gives the answer of some specific queries as specified in the SampleInput.txt file

> queryFindPhone a : This should print the identifier of the exchange re-
turned by the andPhone(MobilePhone m) method. Here, m represents
the mobile phone whose identifier is a.

>  queryLowestRouter a b : This should print the identifier of the ex-
change returned by the lowestRouter(Exchange e1, Exchange e2) method.
Here, e1 and e2 represent exchanges with identifier a and b respectively.

> queryFindCallPath a b : This should print the list returned by the
routeCall(MobilePhone m1, MobilePhone m2) method. Here, m1 and
m2 represent mobile phones with identifier a and b respectively. Suc-
cessive entries in the list should be separated by a comma.

> movePhone a b : This action should set the level 0 area exchange of the
mobile phone with identifier a to exchange with identifier b. Throw
exception if mobile a is not available, or exchange b does not exist.
