# kill java
ps -ef | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
# stop consul
consul leave
# kill python
ps -ef | grep python | grep -v grep | awk '{print $2}' | xargs kill -9
# stop nginx
ps -ef | grep nginx | grep -v grep | awk '{print $2}' | xargs kill -15