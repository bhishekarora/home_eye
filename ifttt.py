import requests
import sys

print "This is the name of the file: ", sys.argv[1] 


requests.post("https://maker.ifttt.com/trigger/front_door_movement/with/key/yourkey", data="")
