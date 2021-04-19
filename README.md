# distributed_file_sharing_system
File sharing network in a distributed system

First go to the Overlay Network directory
Build the jar file for the Overlay Network using the ```mvn clean install```

Then Go to the File Transfer directory
Build the jar file for the File Transfer using the ```mvn clean install```
copy the jar ```filetransfer-0.0.1-SNAPSHOT.jar``` to the Overlay Network application's target folder

Traverse to the Overlay Network target directory. And execute the following command to create a master node.
```java -jar overlay_network-1.0-SNAPSHOT.jar 1```

You can add additional peer nodes using the following command to create peer nodes.
```java -jar overlay_network-1.0-SNAPSHOT.jar 2```

You can execute commands from different peers by using Netcat Terminal and executing the following command 
```nc -u <ip-address> <port>```

Following commands can be executed from a peer.
Search a file in the network =>
  SEARCH <no-of-hops> <search-term>
  
Download a specific file from the network =>
  DOWNLOAD <file_name>
  
Get the statistics for a specific node like number of answered,forwarded,received queries =>
  GETSTATS

Reset above acquired statistics like answered,forwarded,received queries =>
  CLEARSTATS

Show routing table of a selected node =>
  SHOWROUTES
  
Leave from the network gracefully =>
  LEAVENET
