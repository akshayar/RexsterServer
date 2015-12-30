# Running Rexster server from eclise and maven
The project is created to help people run Rexster and kibles from eclipse. A project to add custom extension is also added.
The project has two child projects - 

1. _rexster-server_ - has only a pom file and rexster-berkley.xml. pom file has relevant dependencies. To run -run com.tinkerpop.rexster.Application class with JVM parameters  *-s -c src/main/resources/rexster-berkley.xml*. When the server is run, kibbles which are added as dependencies are deployed. 
2. _rexster-custom_ - has the code for Rexster extension. The dependency of this can be added in _rexster-server_ to install the developed extension. 

## Getting started
1. Clone the repository. 
2. Import the project as maven project. This will create three project RexServiceParent,RexsterServer,RexCustomService. 
3. Edit titan DB configuration in rexster-server/src/main/resources/rexster-berkley.xml file. You may want to edit graphs/graph node and point to your DB file.
4. To run the server run *com.tinkerpop.rexster.Application* main class with JVM parameters  *-s -c src/main/resources/rexster-berkley.xml*. RexsterServer should be chose for this. 
5. To run from command line. Go to *rexster-server* directory. Execute *mvn exec:java* . 
6. Hit http://localhost:8182/ to access Rexster. 
7. Got to "The Dog House" to browse the graph.

## Rest APIS
https://github.com/tinkerpop/rexster/wiki/Basic-REST-API

## Rexster WIKI
https://github.com/tinkerpop/rexster/wiki/Introduction



