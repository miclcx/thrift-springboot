#!/bin/bash
#: Title : IFaceServer.restart.sh 8082 police true &
#: Date : 2016-01-07
#: Author : "Knight.Zhou" <youngwelle@gmail.com>
#: Version : 1.0
#: Description : start IFaceServer!
#: Options : None
#: Example : java -jar api.jar --spring.profiles.active=8082 --isJar=true &
#: restart it
echo "IFaceServer script is about to run stop script."
sh ./stop.sh $1
sleep 5
echo "IFaceServer script has just run start script."
sh ./start.sh $2 $3