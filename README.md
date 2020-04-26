
## Home Eye

This project will make a Home eye service which will do the following.

 1. Detect motion of Visitors on your front Door. 
 2. Make valid snapshots of visitors.
 3. Alert you on your Android/Ios phone of any movement
 4. Keep snapshots on Google cloud  
 5. Will give you an android app to see live view 
 6. Will give you a snapshot view also on the above app
 7. Will work even if you don't have static ip on your router.
 
![Home Eye Architecture](https://github.com/bhishekarora/home_eye/blob/master/homeeye.png)

## Prerequisites 
A raspberry pi 2/3 needs wifi dongle support or inbuilt one.
Static ip configured and has internet access.
8 Gig sd card. 
USB Camera attached via wire
Power adapter >  2 amps

## Nuts and Bolts

**DNS**

Get a static dns name for your raspberry pi 
[https://www.duckdns.org/install.jsp](https://www.duckdns.org/install.jsp)

**Static IP**
Assign a static ip to your raspberry by mapping its mac address to a local lan address. e.g on my dlink i assigned 192.168.1.7 to my raspi mac address. 

**Installation**
Install motion from RPI and use the motion.conf file attached in repo.
Take note of the following important configurations, rest of the configurations will work mostly OOB.

The notification server from IFTTT which will send alert on our android and iphone , make sure you install that app and create a web hook.

on_event_start python /home/pi/ifttt.py

>ifttt.py is bundled with repository.

Download ifttt app and register , make a webhook and put the key in above
file, this will send you alerts on visitor movements.

The below command will upload to google cloud storage bucket, all the
pics captured by motion library will be sent to gcp, checkout the bucker.jar
bundled with this repo, change the project id and path of your json file in the App.java and recompile as jar.

on_picture_save /home/pi/uploadtocloud.sh %f

**Android App**

The android app will be simple one page layout where, top 