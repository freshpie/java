FIRST=$1
SECOND=$2




for((a=1; a<=FIRST; a++))
do
  for (( c=1; c<=SECOND; c++ ))
  do
    echo "$a $c Run Start..."
    curl -s -H "Content-Type: application/json" -X POST --data @soapmsg http://localhost:8080/shubProxy > /dev/null
    #sleep 1
    echo "$a $c Run Done..."
  done
  sleep 3
done
